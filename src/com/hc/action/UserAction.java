package com.hc.action;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.hc.bean.Grades;
import com.hc.bean.Users;
import com.hc.service.UserService;
import com.hc.util.FastJsonUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<Users> {

	private Users user = new Users();
	@Override
	public Users getModel() {
		return user;
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 检验用户名是否存在
	 * bool=false表示不存在此用户，可以注册
	 * @return
	 * @throws IOException 
	 */
	public String checkName() throws IOException{
		System.out.println("===================");
		String name = ServletActionContext.getRequest().getParameter("userName");
		boolean bool = userService.findByUserName(name);
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		String string = FastJsonUtil.toJSONString(bool);
		writer.print(string);
		return NONE;
	}
	/**
	 * 检验昵称是否存在
	 * bool=true表示不存在此昵称，可以注册
	 * @return
	 * @throws IOException
	 */
	public String checkNic() throws IOException{
		String nic = ServletActionContext.getRequest().getParameter("userNic");
		boolean bool = userService.findByUserNic(nic);
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		String string = FastJsonUtil.toJSONString(bool);
		writer.print(string);
		return NONE;
	}
	/**
	 * 注册
	 * @return
	 */
	public String register(){
		Grades grades = new Grades();
		grades.setId(1);
		user.setUsersGrade(grades);
		System.out.println(user);
		userService.register(user);
		return "login";
	}
	
	
	
	
}
