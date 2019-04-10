package com.zimadai.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.zimadai.boot.bean.User;
import com.zimadai.boot.service.UserService;
import com.zimadai.boot.utils.RestData;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/add", produces = { "application/json;charset=UTF-8" })
	public RestData addUser(User user) {
		int row = userService.addUser(user);
		if (row > 0) {
			return new RestData.Builder().success(true).build();
		}
		return new RestData.Builder().success(false).data(null).message("操作失败").build();
	}

	@GetMapping(value = "/all/{pageNum}/{pageSize}", produces = { "application/json;charset=UTF-8" })
	public RestData findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
		List<User> data = userService.findAllUser(pageNum, pageSize);
		return new RestData.Builder().success(true).data(data).build();
	}
}