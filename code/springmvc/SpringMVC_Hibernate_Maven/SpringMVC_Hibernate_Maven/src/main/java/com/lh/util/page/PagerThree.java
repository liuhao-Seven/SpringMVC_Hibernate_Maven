package com.lh.util.page;

import java.util.Collection;

import com.lh.util.log.LHLog;

/**
 * 页面对象
 * @description:
 * @author 刘浩
 * @date 2015-6-21 下午1:27:22 
 * @version V1.0  
 * 
 * @param <T>
 */
public class PagerThree<T> {

	/**记录总数*/
	private Integer totalRows = 0;
	/**总页数*/
	private Integer totalPages = 0;
	/**每页显示数据条数，默认为10条记录*/
	private Integer pageSize = 10;
	/**当前页数*/
	private Integer currentPage = 1;
	/**是否有上一页*/
//	private boolean hasPrevious = false;
	/**是否有下一页*/
//	private boolean hasNext = false;
	/**链接请求路径*/
//	private String path;
	/**页面显示数据*/
	private Collection<T> data;
	/**查询条件(json格式)*/
	private String queryData;
	/**当前页中第一条记录对应的序号，该序号是从0开始计算的*/
	private Integer firstEntityIndex=0;
	/**当前页中最后一条记录对应的序号，该序号是从0开始计算的*/
	private Integer lastEntityIndex=0;
	public PagerThree() {
	}

	public Integer getTotalPages() {
		return this.totalPages;
	}
	
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getPageSize() {
		return this.pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		this.totalPages = ((this.totalRows + this.pageSize) - 1) / this.pageSize;
	}

	/**
	 * 返回当前页中第一条记录对应的序号，该序号是从0开始计算的。<br>
	 * 注意，此处在计算firstEntityIndex是不考虑实际提取过程中当前页是否存在的。
	 */
	public int getFirstEntityIndex() {
		return this.firstEntityIndex;
	}
	
	public void setFirstEntityIndex(Integer firstEntityIndex) {
		this.firstEntityIndex = firstEntityIndex;
	}

	/**
	 * 返回当前页中最后一条记录对应的序号，该序号是从0开始计算的。<br>
	 * 注意，此处在计算lastEntityIndex是不考虑实际提取过程中当前页是否存在或者记录数是否可达到pageSize的。
	 */
	public int getLastEntityIndex() {
		return this.lastEntityIndex;
	}
	
	public void setLastEntityIndex(Integer lastEntityIndex) {
		this.lastEntityIndex = lastEntityIndex;
	}

	public Integer getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

//	public boolean getHasPrevious() {
//		return this.hasPrevious;
//	}
//
//	public void setHasPrevious(boolean hasPrevious) {
//		this.hasPrevious = hasPrevious;
//	}
//
//	public boolean getHasNext() {
//		return this.hasNext;
//	}
//
//	public void setHasNext(boolean hasNext) {
//		this.hasNext = hasNext;
//	}

	public Object getQueryData() {
		return queryData;
	}

	public void setQueryData(String queryData) {
		this.queryData = queryData;
	}

	public Integer getTotalRows() {
		return totalRows;
	}
	
	/**
	 * 设置记录总数
	 * 
	 * @author 刘浩
	 * @date 2015-6-21 下午1:11:39 
	 * @param totalRows
	 */
	public void setTotalRows(Integer totalRows) {
		if (totalRows < 0) {
			throw new IllegalArgumentException(
					"Illegal totalRows arguments. [totalRows="
							+ totalRows + "]");
		}
		this.totalRows = totalRows;
		this.totalPages = ((this.totalRows + this.pageSize) - 1) / this.pageSize;
	}

//	public String getPath() {
//		return this.path;
//	}
//
//	public void setPath(String path) {
//		this.path = path;
//	}

	public Collection<T> getData() {
		return this.data;
	}

	public void setData(Collection<T> data) {
		this.data = data;
	}

	/**
	 * 跳页
	 * 
	 * @param page
	 */
	public void toPage(Integer page) {
		if (page <= 0) {
			this.currentPage = 1;
		} else if (page <= this.totalPages) {
			this.currentPage = page;
		} else {
			this.currentPage = this.totalPages;
		}
		refresh();
	}

	/**
	 * 跳到第一页
	 */
	public void first() {
		this.currentPage = 1;
//		this.setHasPrevious(false);
		refresh();
	}

	/**
	 * 取得上一页（重新设定当前页面即可）
	 */
	public void previous() {
		this.currentPage--;
		refresh();
	}

	/**
	 * 取得下一页
	 */
	public void next() {
		if (this.currentPage < this.totalPages) {
			this.currentPage++;
		}
		refresh();
	}

	/**
	 * 跳到最后一页
	 */
	public void last() {
		this.currentPage = this.totalPages;
//		this.setHasNext(false);
		refresh();
	}

	/**
	 * 刷新当前页面信息
	 */
	public void refresh() {
		// 增加过滤当前页小于等于0的情况     刘浩 2014-4-19 下午10:17:33
		if (this.currentPage <= 0) {
			this.currentPage = 1;
		}
		// 增加过滤当前页大于总页数的情况       刘浩 2014-4-19 下午10:18:50
		if (this.currentPage > this.totalPages) {
			this.currentPage = this.totalPages;
		}
		this.firstEntityIndex = (this.currentPage - 1) * this.pageSize;
		this.lastEntityIndex = this.currentPage * this.pageSize;
//		if (this.totalPages <= 1) {
//			this.hasPrevious = false;
//			this.hasNext = false;
//		} else if (this.currentPage == 1) {
//			this.hasPrevious = false;
//			this.hasNext = true;
//		} else if (this.currentPage == this.totalPages) {
//			this.hasPrevious = true;
//			this.hasNext = false;
//		} else {
//			this.hasPrevious = true;
//			this.hasNext = true;
//		}
	}
	
	/**
	 * 判断将要跳转的是那个页面
	 * @author 刘浩
	 * @date 2014-7-4
	 * @param pager 页面对象
	 * @param action 跳转动作(previous,next,first,last,toPage)
	 * @param toPage 要跳转的页数,只有action为toPage时有效
	 */
	public void doAction(String action,String toPage){
		if (action != null){	
			//判断是否是跳页
			if (action.equalsIgnoreCase("toPage") && toPage!= null && !toPage.equals("")) {
				try {
					Integer page = Integer.parseInt(toPage);
					this.toPage(page);
				} catch (NumberFormatException e) {
					LHLog.error(
							"doAction过程出错[toPage="
									+ toPage + "]");
					//出错时默认返回第一页
					this.first();
				}
			}
        	// 根据传递进来的参数控制页面的前进后退
			else if (action.equalsIgnoreCase("previous")){
				this.previous();
            } 
            else if (action.equalsIgnoreCase("next")){
            	this.next();
            }
//            else if (action.equalsIgnoreCase("first")){
//                pager.first();
//            } 
            else if (action.equalsIgnoreCase("last")){
            	this.last();
            }else {
            	this.first();
            }
        }
	}
	
}
