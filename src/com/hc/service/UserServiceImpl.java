package com.hc.service;

import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.hc.bean.News;
import com.hc.bean.PageBean;
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
	/**
	 * 查询用户是否存在
	 */
	@Override
	public Users findUser(Users user) {
		return userDao.findUser(user);
	}
	/**
	 * 更新用户信息
	 */
	@Override
	public void updateInfo(Users user) {
		userDao.update(user);
	}
	/**
	 * 更新用户信息之查询该用户
	 */
	@Override
	public Users selectOne(String username) {
		return userDao.selectOne(username);
	}
	/**
	 * 获取News
	 */
	@Override
	public PageBean<News> findByPage(int nowPage, int pageSize, int id) {
		return userDao.findByPage(nowPage,pageSize,id);
	}
	
}
