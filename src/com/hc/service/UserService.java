package com.hc.service;

import com.hc.bean.Users;

public interface UserService {

	void register(Users user);

	boolean findByUserName(String name);

	boolean findByUserNic(String nic);


	
}
