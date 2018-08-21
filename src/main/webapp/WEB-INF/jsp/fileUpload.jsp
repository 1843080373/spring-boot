<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>
</head>
<body>
	<h3>zip文件上传</h3>
	<form enctype="multipart/form-data" method="post" action="/testuploadimg">
    zip文件<input type="file" name="file"/>
    <input type="submit" value="上传"/>
    </form>
</html>