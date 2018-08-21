package com.zimadai.boot.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.activation.MimetypesFileTypeMap;

public class UnZipUtils {
	/**
	 * 解压文件到指定目录 解压后的文件名，和之前一致
	 * 
	 * @param zipFile 待解压的zip文件
	 * @param descDir 指定目录
	 */
	@SuppressWarnings("resource")
	public static void unZipFiles(File zipFile, String descDir) throws IOException {
		ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));// 解决中文文件夹乱码
		String name = zip.getName().substring(zip.getName().lastIndexOf('\\') + 1, zip.getName().lastIndexOf('.'));

		File pathFile = new File(descDir + name);
		if (!pathFile.exists()) {
			pathFile.mkdirs();
		}

		for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements();) {
			ZipEntry entry = (ZipEntry) entries.nextElement();

			String zipEntryName = entry.getName();
			InputStream in = zip.getInputStream(entry);
			String outPath = (descDir + name + "/" + zipEntryName).replaceAll("\\*", "/");

			// 判断路径是否存在,不存在则创建文件路径
			File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
			if (!file.exists()) {
				file.mkdirs();
			}
			// 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
			if (new File(outPath).isDirectory()) {
				continue;
			}
			if (!isImage(new File(outPath))) {
				continue;
			}
			// 输出文件路径信息
//          System.out.println(outPath);  

			FileOutputStream out = new FileOutputStream(outPath);
			byte[] buf1 = new byte[1024];
			int len;
			while ((len = in.read(buf1)) > 0) {
				out.write(buf1, 0, len);
			}
			in.close();
			out.close();
		}
		System.out.println("******************解压完毕********************");
		return;
	}

	private static MimetypesFileTypeMap mtftp;

	public static boolean isImage(File file) {
		mtftp = new MimetypesFileTypeMap();
		/*
		 * 不添加下面的类型会造成误判
		 * 详见：http://stackoverflow.com/questions/4855627/java-mimetypesfiletypemap-
		 * always-returning-application-octet-stream-on-android-e
		 */
		mtftp.addMimeTypes("image png tif jpg jpeg bmp");
		String mimetype = mtftp.getContentType(file);
		String type = mimetype.split("/")[0];
		return type.equals("image");
	}

	public static void delDir(File f) {
		// 判断是否是一个目录, 不是的话跳过, 直接删除; 如果是一个目录, 先将其内容清空.
		if (f.isDirectory()) {
			// 获取子文件/目录
			File[] subFiles = f.listFiles();
			// 遍历该目录
			for (File subFile : subFiles) {
				// 递归调用删除该文件: 如果这是一个空目录或文件, 一次递归就可删除. 如果这是一个非空目录, 多次
				// 递归清空其内容后再删除
				delDir(subFile);
			}
		}
		// 删除空目录或文件
		f.delete();
	}

	// 测试
	public static void main(String[] args) {
		try {
			unZipFiles(new File("E:/Study/Java.zip"), "E:/Study/abc/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
