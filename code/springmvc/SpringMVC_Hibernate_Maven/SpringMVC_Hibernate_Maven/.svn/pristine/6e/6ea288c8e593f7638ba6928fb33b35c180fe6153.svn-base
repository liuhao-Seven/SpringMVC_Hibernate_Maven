package com.lh.util.page;

import com.lh.util.common.FunctionUtils;

/**
 * 页面对象
 * 
 * @version 2014-2-13
 * @author lh
 */
public class Pager {

	/**记录总数*/
	private int totalRows = 0;
	/**总页数*/
	private int totalPages = 0;
	/**每页显示数据条数，默认为10条记录*/
	private int pageSize = 10;
	/**当前页数*/
	private int currentPage = 1;
	/**是否有上一页*/
	private boolean hasPrevious = false;
	/**是否有下一页*/
	private boolean hasNext = false;
	/**判断是否是当前方法*/
	private String methodName;
	/**返回的页面*/
	private String returnPage;
	/**搜索的条件*/
	private String searchHql;
	/**链接路径*/
	private String path;
	/**页面显示内容*/
	private String pageText;
	
	public Pager() {
	}

	public void init() {
		this.totalPages = ((totalRows + pageSize) - 1) / pageSize;
		refresh(); // 刷新当前页面信息
	}

	public void init(int totalRows, int pageSize) {
		this.totalRows = totalRows;
		this.pageSize = pageSize;
		this.totalPages = ((totalRows + pageSize) - 1) / pageSize;
		refresh(); // 刷新当前页面信息
	}
	
	/**
	 * 判断将要跳转的是那个页面
	 * @author 刘浩
	 * @date 2014-7-4
	 * @param pager 页面对象
	 * @param action  跳转动作(previous,next,first,last,toPage)
	 * @param toPage 要跳转的页数,只有action为toPage时有效
	 */
	public static void doAction(Pager pager, String action,String toPage){
		if (action != null){	
			//判断是否是跳页
			if (action.equalsIgnoreCase("toPage") && toPage!= null && !toPage.equals("")) {
				try {
					Integer page = Integer.parseInt(toPage);
					pager.toPage(page);
				} catch (NumberFormatException e) {
					FunctionUtils.printCLAndStr(new Exception(),Pager.class, "toPage转换Int型错误");
					e.printStackTrace();
				}
			}
        	// 根据传递进来的参数控制页面的前进后退
            if (action.equalsIgnoreCase("previous")){
                pager.previous();
            } 
            else if (action.equalsIgnoreCase("next")){
                pager.next();
            }
            else if (action.equalsIgnoreCase("first")){
                pager.first();
            } 
            else if (action.equalsIgnoreCase("last")){
                pager.last();
            }
        }
	}

	/**
	 * 获取页面显示的内容-----修改进行中
	 * 该获取内容可根据具体
	 * @author 刘浩
	 * @date 2014-8-8
	 * @return
	 */
	public String getPageText() {
		try {
			StringBuffer strbuf = new StringBuffer();
			if (this.totalRows != 0) {
				strbuf.append("共【<font color=\"red\">");
				strbuf.append(this.totalRows);
				strbuf.append("</font>】条记录&nbsp;&nbsp;每页显示<font color=\"red\">");
				strbuf.append(this.pageSize);
				strbuf.append("</font>条记录&nbsp;&nbsp;共【<font color=\"red\">");
				strbuf.append(this.totalPages);
				strbuf.append("</font>】页&nbsp;&nbsp;当前第<font color=\"red\">");
				strbuf.append(this.currentPage);
				strbuf.append("</font>页 ");
				if (this.currentPage <= 1) {
//					 this.pageText+="[已是首页] &nbsp;&nbsp;";
				} else {
					strbuf.append("<a style=\"color:#157DF0\" href=\"");
					strbuf.append(this.path);
					strbuf.append(1);
					strbuf.append("\" title='首  页'>[首  页]</a> &nbsp;");
					
					strbuf.append("<a style=\"color:#157DF0\" href=\"");
					strbuf.append(this.path);
					strbuf.append((this.currentPage - 1));
					strbuf.append("\" title='上一页'>[上 一 页]</a> &nbsp;");
				}
				if (this.currentPage >= this.totalPages) {
					// this.pageText+="[已是尾页] &nbsp;&nbsp;";
				} else {
					strbuf.append("<a style=\"color:#157DF0\" href=\"");
					strbuf.append(this.path);
					strbuf.append((this.currentPage + 1));
					strbuf.append("\" title='下一页'>[下 一 页]</a>&nbsp;");
					
					strbuf.append("<a style=\"color:#157DF0\" href=\"");
					strbuf.append(this.path);
					strbuf.append((this.totalPages));
					strbuf.append("\" title='尾页'>[尾  页]</a>&nbsp;");
				}
				strbuf.append("跳到第");
				strbuf.append("<script text='text/javascript'>function inPage(){ var reg = /^\\d+$/;");
				strbuf.append(" var pageno=document.getElementById('pageno').value; ");
				strbuf.append(" if(!reg.test(pageno) || parseInt(pageno)<=0){");
				strbuf.append(" alert('请输入有效页数'); return false;");
				strbuf.append("}else if(pageno>");
				strbuf.append(this.totalPages);
				strbuf.append("){alert('输入的页数超过了总页数，请重新输入');return false; }else{window.location.href='");
				strbuf.append(this.path);
				strbuf.append("'+pageno;return true;");
				strbuf.append("}}   </script>");
				
				strbuf.append("<input name='pageno'  id='pageno' type='text' value='' size='5' />");
				strbuf.append("页<input type='button' value='跳转' class='btn' onclick=\"javascript:inPage();\"/>");
				this.pageText = strbuf.toString();
		} else
				this.pageText = "<font color=red><strong> 未查询到数据 !!! </strong></font>";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.pageText;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		refresh();
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public boolean getHasPrevious() {
		return hasPrevious;
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public boolean getHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		refresh();
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
		refresh();
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
		refresh();
	}

	public String getReturnPage() {
		return returnPage;
	}

	public void setReturnPage(String returnPage) {
		this.returnPage = returnPage;
	}

	public String getSearchHql() {
		return searchHql;
	}

	public void setSearchHql(String searchHql) {
		this.searchHql = searchHql;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setPageText(String pageText) {
		this.pageText = pageText;
	}

	/**
	 * 跳页
	 * 
	 * @param page
	 */
	public void toPage(int page) {
		if (page <= 0) {
			currentPage = 1;
		} else if (page <= totalPages) {
			currentPage = page;
		} else {
			currentPage = totalPages;
		}
		refresh();
	}

	/**
	 * 跳到第一页
	 */
	public void first() {
		currentPage = 1;
		this.setHasPrevious(false);
		refresh();
	}

	/**
	 * 取得上一页（重新设定当前页面即可）
	 */
	public void previous() {
		currentPage--;
		refresh();
	}

	/**
	 * 取得下一页
	 */
	public void next() {
		if (currentPage < totalPages) {
			currentPage++;
		}
		refresh();
	}

	/**
	 * 跳到最后一页
	 */
	public void last() {
		currentPage = totalPages;
		this.setHasNext(false);
		refresh();
	}

	/**
	 * 刷新当前页面信息
	 */
	public void refresh() {
		// 增加过滤当前页小于等于0的情况     刘浩 2014-4-19 下午10:17:33
		if (currentPage <= 0) {
			currentPage = 1;
		}
		// 增加过滤当前页大于总页数的情况       刘浩 2014-4-19 下午10:18:50
		if (currentPage > totalPages) {
			currentPage = totalPages;
		}
		if (totalPages <= 1) {
			hasPrevious = false;
			hasNext = false;
		} else if (currentPage == 1) {
			hasPrevious = false;
			hasNext = true;
		} else if (currentPage == totalPages) {
			hasPrevious = true;
			hasNext = false;
		} else {
			hasPrevious = true;
			hasNext = true;
		}
	}
}
