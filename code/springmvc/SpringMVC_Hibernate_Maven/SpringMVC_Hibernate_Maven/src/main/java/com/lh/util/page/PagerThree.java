package com.lh.util.page;

import java.util.Collection;

import com.lh.util.log.LHLog;

/**
 * ҳ�����
 * @description:
 * @author ����
 * @date 2015-6-21 ����1:27:22 
 * @version V1.0  
 * 
 * @param <T>
 */
public class PagerThree<T> {

	/**��¼����*/
	private Integer totalRows = 0;
	/**��ҳ��*/
	private Integer totalPages = 0;
	/**ÿҳ��ʾ����������Ĭ��Ϊ10����¼*/
	private Integer pageSize = 10;
	/**��ǰҳ��*/
	private Integer currentPage = 1;
	/**�Ƿ�����һҳ*/
//	private boolean hasPrevious = false;
	/**�Ƿ�����һҳ*/
//	private boolean hasNext = false;
	/**��������·��*/
//	private String path;
	/**ҳ����ʾ����*/
	private Collection<T> data;
	/**��ѯ����(json��ʽ)*/
	private String queryData;
	/**��ǰҳ�е�һ����¼��Ӧ����ţ�������Ǵ�0��ʼ�����*/
	private Integer firstEntityIndex=0;
	/**��ǰҳ�����һ����¼��Ӧ����ţ�������Ǵ�0��ʼ�����*/
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
	 * ���ص�ǰҳ�е�һ����¼��Ӧ����ţ�������Ǵ�0��ʼ����ġ�<br>
	 * ע�⣬�˴��ڼ���firstEntityIndex�ǲ�����ʵ����ȡ�����е�ǰҳ�Ƿ���ڵġ�
	 */
	public int getFirstEntityIndex() {
		return this.firstEntityIndex;
	}
	
	public void setFirstEntityIndex(Integer firstEntityIndex) {
		this.firstEntityIndex = firstEntityIndex;
	}

	/**
	 * ���ص�ǰҳ�����һ����¼��Ӧ����ţ�������Ǵ�0��ʼ����ġ�<br>
	 * ע�⣬�˴��ڼ���lastEntityIndex�ǲ�����ʵ����ȡ�����е�ǰҳ�Ƿ���ڻ��߼�¼���Ƿ�ɴﵽpageSize�ġ�
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
	 * ���ü�¼����
	 * 
	 * @author ����
	 * @date 2015-6-21 ����1:11:39 
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
	 * ��ҳ
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
	 * ������һҳ
	 */
	public void first() {
		this.currentPage = 1;
//		this.setHasPrevious(false);
		refresh();
	}

	/**
	 * ȡ����һҳ�������趨��ǰҳ�漴�ɣ�
	 */
	public void previous() {
		this.currentPage--;
		refresh();
	}

	/**
	 * ȡ����һҳ
	 */
	public void next() {
		if (this.currentPage < this.totalPages) {
			this.currentPage++;
		}
		refresh();
	}

	/**
	 * �������һҳ
	 */
	public void last() {
		this.currentPage = this.totalPages;
//		this.setHasNext(false);
		refresh();
	}

	/**
	 * ˢ�µ�ǰҳ����Ϣ
	 */
	public void refresh() {
		// ���ӹ��˵�ǰҳС�ڵ���0�����     ���� 2014-4-19 ����10:17:33
		if (this.currentPage <= 0) {
			this.currentPage = 1;
		}
		// ���ӹ��˵�ǰҳ������ҳ�������       ���� 2014-4-19 ����10:18:50
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
	 * �жϽ�Ҫ��ת�����Ǹ�ҳ��
	 * @author ����
	 * @date 2014-7-4
	 * @param pager ҳ�����
	 * @param action ��ת����(previous,next,first,last,toPage)
	 * @param toPage Ҫ��ת��ҳ��,ֻ��actionΪtoPageʱ��Ч
	 */
	public void doAction(String action,String toPage){
		if (action != null){	
			//�ж��Ƿ�����ҳ
			if (action.equalsIgnoreCase("toPage") && toPage!= null && !toPage.equals("")) {
				try {
					Integer page = Integer.parseInt(toPage);
					this.toPage(page);
				} catch (NumberFormatException e) {
					LHLog.error(
							"doAction���̳���[toPage="
									+ toPage + "]");
					//����ʱĬ�Ϸ��ص�һҳ
					this.first();
				}
			}
        	// ���ݴ��ݽ����Ĳ�������ҳ���ǰ������
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
