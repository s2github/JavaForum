package com.hc.dao;

import java.util.List;

import com.hc.bean.Users;

public class UserDaoImpl extends BaseDaoImpl<Users> implements UserDao {
	/**
	 * 检验用户名是否存在
	 * false表示不存在此用户，可以注册
	 */
	@Override
	public boolean findByUserName(String name) {
		List<Users> list = (List<Users>) this.getHibernateTemplate().find("select username from Users where username=?", name);
		if(list.size()==0){
			return false;
		}else{
			return true;}
	}
	/**
	 * 检验昵称是否存在
	 * false表示不存在此昵称，可以注册
	 */
	@Override
	public boolean findByUserNic(String nic) {
		List<Users> list = (List<Users>) this.getHibernateTemplate().find("select nickname from Users where nickname=?", nic);
		if(list.size()==0){
			return false;
		}else{return true;}
	}


}
