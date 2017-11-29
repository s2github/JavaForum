package com.hc.dao;

import com.hc.bean.Users;

public interface UserDao extends BaseDao<Users> {

	boolean findByUserName(String name);

	boolean findByUserNic(String nic);



}
