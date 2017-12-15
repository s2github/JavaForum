package com.hc.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;

import com.hc.bean.News;
import com.hc.bean.PageBean;
import com.hc.bean.Users;

public class UserDaoImpl extends BaseDaoImpl<Users> implements UserDao {
	/**
	 * 注册：
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
	 * 注册：
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
	/**
	 * 登录：查询用户是否存在
	 */
	@Override
	public Users findUser(Users user) {
		List<Users> list = (List<Users>) this.getHibernateTemplate().find("from Users where username=? and password=?", user.getUsername(),user.getPassword());
		if(list.size() != 0){
			return list.get(0);
		}else{
			return null;
		}
	}
	/**
	 * 根据用户名查询该人
	 */
	@Override
	public Users selectOne(String username) {
		List<Users> list = (List<Users>) this.getHibernateTemplate().find("from Users where username=?", username);
		return list.get(0);
	}
	/**
	 * 获得News
	 */
	@Override
	public PageBean<News> findByPage(int nowPage, int pageSize, int id) {
		PageBean<News> pageBean = new PageBean<News>();
		String sql = "from News where newsCommentUser.id="+id+"order by id desc";
		Query query1 = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sql);
		int size = query1.list().size();
		Query query2 = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(sql);
		query2.setFirstResult((nowPage-1)*pageSize);
		query2.setMaxResults(pageSize);
		List<News> list = query2.list();
		pageBean.setAllRecords(size);
		pageBean.setCurrentPage(nowPage);
		pageBean.setPageList(list);
		pageBean.setPageSize(pageSize);
		return pageBean;
	}


}
