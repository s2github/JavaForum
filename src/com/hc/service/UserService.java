package com.hc.service;

import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;

import com.hc.bean.News;
import com.hc.bean.PageBean;
import com.hc.bean.Users;

public interface UserService {

	void register(Users user);

	boolean findByUserName(String name);

	boolean findByUserNic(String nic);

	Users findUser(Users user);

	void updateInfo(Users user);

	Users selectOne(String username);

	PageBean<News> findByPage(int nowPage, int pageSize, int id);


	
}
