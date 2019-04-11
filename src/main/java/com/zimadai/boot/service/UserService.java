package com.zimadai.boot.service;

import com.github.pagehelper.PageInfo;
import com.zimadai.boot.bean.User;

public interface UserService {

    int addUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);
}
