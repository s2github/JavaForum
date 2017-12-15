package com.hc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.hc.bean.Grades;
import com.hc.bean.News;
import com.hc.bean.PageBean;
import com.hc.bean.Users;
import com.hc.service.UserService;
import com.hc.util.FastJsonUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<Users> {

	private HttpSession session;
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
	/**
	 * 登录
	 * @return
	 */
	public String login(){
		Users u = userService.findUser(user);
		System.out.println(u);
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("tu", u);
		session.setAttribute("1", "asdasd");
		System.out.println(session.getId());
		if(u != null){
			return "index";
		}
		return "login";
	}
	/**
	 * 安全退出
	 * @return
	 */
	public String logout(){
		session.removeAttribute("tu");
		return "login";
	}
	/**
	 * 个人中心
	 * @return
	 */
	public String goHome(){
		
		return "home";
	}
	/**
	 * 更新用户信息
	 * ？发现问题：前面在session中存入值，这里居然取不到。
	 * @return
	 */
	public String updateInfo(){
		Users u = (Users) session.getAttribute("tu");
		u.setNickname(user.getNickname());
		u.setSex(user.getSex());
		u.setEmail(user.getEmail());
		u.setComefrom(user.getComefrom());
		u.setIntroduction(user.getIntroduction());
		u.setProfession(user.getProfession());
		userService.updateInfo(u);
		session.setAttribute("tu", u);
		
		return "updateInfo";
	}
	/**
	 * 修改密码
	 * @return
	 */
	public String updatePass(){
		return "updatePass";
	}
	/**
	 * 我的消息
	 * @return
	 */
	private int pageSize=5;
	private int nowPage=1;
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public String getNews(){
		System.out.println(1);
		//Users u1 = (Users) session.getAttribute("tu");
		//System.out.println(u1);
		
		session = ServletActionContext.getRequest().getSession();
		String str = (String) session.getAttribute("1");
		System.out.println(str);
		System.out.println(session.getId());
		Users u = (Users) session.getAttribute("tu");
		System.out.println(u);
		PageBean<News> page = userService.findByPage(nowPage,pageSize,u.getId());
		List<News> list = page.getPageList();
		session.setAttribute("listNews",list);
		return "news";
	}
	/**
	 * 我的帖子
	 * @return
	 */
	public String getTopics(){
		
		return null;
	}
	/**
	 * 我的评论
	 * @return
	 */
	public String getComments(){
		
		return null;
	}
}
