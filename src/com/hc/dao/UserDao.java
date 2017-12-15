package com.hc.dao;

import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;

import com.hc.bean.News;
import com.hc.bean.PageBean;
import com.hc.bean.Users;

public interface UserDao extends BaseDao<Users> {

	boolean findByUserName(String name);

	boolean findByUserNic(String nic);

	Users findUser(Users user);

	Users selectOne(String username);

	PageBean<News> findByPage(int nowPage, int pageSize, int id);



}
