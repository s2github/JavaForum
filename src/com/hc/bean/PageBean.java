/**
 * 
 */
package com.hc.bean;

import java.util.List;

/**
 * @author 
 * 
 */
public class PageBean<T> {

	private List<T> pageList;

	private int currentPage; // 当前页数
	private int pageSize; // 每页显示的记录数
	private int totalPages; // 总页数
	private int allRecords; // 总记录数

	private boolean isFirstPage; // 是否是第一页
	private boolean isFinalPage; // 是否是最后一页
	private boolean hasPreviousPage; // 是否有上一页
	private boolean hasNextPage; // 是否有下一页
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPages() {
		if(allRecords%pageSize == 0){
			totalPages = allRecords/pageSize;
			return totalPages;

		}else{
			totalPages = allRecords/pageSize+1;
			return totalPages;
		}
	}
	public int getAllRecords() {
		return allRecords;
	}
	public void setAllRecords(int allRecords) {
		this.allRecords = allRecords;
	}
	public boolean isFirstPage() {
		return isFirstPage;
	}
	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}
	public boolean isFinalPage() {
		return isFinalPage;
	}
	public void setFinalPage(boolean isFinalPage) {
		this.isFinalPage = isFinalPage;
	}
	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}
	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	
	
}