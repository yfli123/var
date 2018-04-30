package com.yfli.ssh.service;

import com.yfli.ssh.pojo.User;

public interface UserService extends BaseService{
	boolean isExist(String name);	
	
	User get(String name, String password);
}