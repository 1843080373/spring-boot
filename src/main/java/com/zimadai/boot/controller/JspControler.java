package com.zimadai.boot.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zimadai.boot.bean.User;
import com.zimadai.boot.service.UserService;
import com.zimadai.boot.utils.FileUtil;
import com.zimadai.boot.utils.UnZipUtils;


@Controller
public class JspControler {
	@Autowired
	private UserService userService;

	@GetMapping("/index")
	public ModelAndView index() {
		final List<User> list = userService.findAllUser(0, 0);
		return new ModelAndView("index", new HashMap<String,Object>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put("data",list);
			}
		});
	}
	
	@GetMapping("/fileUpload")
	public ModelAndView fileUpload() {
		return new ModelAndView("fileUpload");
	}
	
	//处理文件上传
    @RequestMapping(value="/testuploadimg", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
            HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        System.out.println("getContentType-->" + contentType);
        String filePath = request.getSession().getServletContext().getRealPath("fileupload/");
        String imgPath = request.getSession().getServletContext().getRealPath("imgupload/");
        try {
        	File zipFile  = FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            UnZipUtils.unZipFiles(zipFile, imgPath);
            UnZipUtils.delDir(new File(filePath));
        } catch (Exception e) {
           e.printStackTrace();
        }
        //返回json
        return "uploadimg success";
    }
}
