package com.hc.service;

import org.springframework.transaction.annotation.Transactional;

import com.hc.bean.Users;
import com.hc.dao.UserDao;

@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 * 注册
	 */
	@Override
	public void register(Users user) {
		System.out.println("-------------------");
		userDao.save(user);
	}
	
	/**
	 * 查询用户名是否存在
	 */
	@Override
	public boolean findByUserName(String name) {
		return userDao.findByUserName(name);
	}
	/**
	 * 查询昵称是否存在
	 */
	@Override
	public boolean findByUserNic(String nic) {
		return userDao.findByUserNic(nic);
	}
	
}
