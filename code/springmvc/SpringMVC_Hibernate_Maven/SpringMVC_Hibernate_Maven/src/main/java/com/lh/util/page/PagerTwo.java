package com.lh.util.page;

import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * @ClassName: PagerTwo
 * @Description: 
 * @author ����
 * @date 2015-4-17 ����10:03:49 
 * 
 * @param <T>
 */
public class PagerTwo<T> {

	/** Ĭ��ÿҳ��ʾ���� */
	public final static int DEFAULT_SIZE=10;
	
	private int pageSize;
	private int pageNo;
	
	private int firstEntityIndex;
	private int lastEntityIndex;

	private Collection<T> data;
	private int entityCount;
	private int pageCount;
	
	public PagerTwo(){}
	
	/**
	 * ��ȡ����·��
	 */
	private String path;
	
	/**
	 * @param pageSize
	 *            ÿҳ��¼��
	 * @param pageNo
	 *            ҳ��
	 */
	public PagerTwo(int pageSize, int pageNo) {
		if (pageNo > 1 && pageSize <= 0) {
			throw new IllegalArgumentException(
					"Illegal paging arguments. [pageSize=" + pageSize
							+ ", pageIndex=" + pageNo + "]");
		}

		if (pageSize < 0)
			pageSize = 0;
		if (pageNo < 1)
			pageNo = 1;

		this.pageSize = pageSize;
		this.pageNo = pageNo;
		firstEntityIndex = (pageNo - 1) * pageSize;
		lastEntityIndex = pageNo * pageSize;
	}
	
	/**
	 * @param pageSize
	 *            ÿҳ��¼��
	 * @param pageNo
	 *            ҳ��
	 */
	public PagerTwo(String path, int pageSize, int pageNo) {
		if (pageNo > 1 && pageSize <= 0) {
			throw new IllegalArgumentException(
					"Illegal paging arguments. [pageSize=" + pageSize
							+ ", pageIndex=" + pageNo + "]");
		}

		this.path = path;
		
		if (pageSize < 0)
			pageSize = 0;
		if (pageNo < 1)
			pageNo = 1;

		this.pageSize = pageSize;
		this.pageNo = pageNo;
		firstEntityIndex = (pageNo - 1) * pageSize;
		lastEntityIndex = pageNo * pageSize;
	}
	
	/**
	 * ����ÿһҳ�Ĵ�С����ÿҳ�ļ�¼����
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * ����Ҫ��ȡ��ҳ����ţ�������Ǵ�1��ʼ����ġ�
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * ���ص�ǰҳ�е�һ����¼��Ӧ����ţ�������Ǵ�0��ʼ����ġ�<br>
	 * ע�⣬�˴��ڼ���firstEntityIndex�ǲ�����ʵ����ȡ�����е�ǰҳ�Ƿ���ڵġ�
	 */
	public int getFirstEntityIndex() {
		return firstEntityIndex;
	}

	/**
	 * ���ص�ǰҳ�����һ����¼��Ӧ����ţ�������Ǵ�0��ʼ����ġ�<br>
	 * ע�⣬�˴��ڼ���lastEntityIndex�ǲ�����ʵ����ȡ�����е�ǰҳ�Ƿ���ڻ��߼�¼���Ƿ�ɴﵽpageSize�ġ�
	 */
	public int getLastEntityIndex() {
		return lastEntityIndex;
	}

	/**
	 * �����ܼ�¼����
	 * <p>
	 * �˴����ܼ�¼��������ָ��ҳ���ݵ�����������ָ��������������� ��ÿһҳ�����ۼƵ�������
	 * </p>
	 */
	public int getEntityCount() {
		return entityCount;
	}

	/**
	 * �����ܼ�¼����
	 * <p>
	 * �˴����ܼ�¼��������ָ��ҳ���ݵ�����������ָ�����������������ÿһҳ�����ۼƵ�������
	 * </p>
	 */
	public void setEntityCount(int entityCount) {
		if (entityCount < 0) {
			throw new IllegalArgumentException(
					"Illegal entityCount arguments. [entityCount="
							+ entityCount + "]");
		}

		this.entityCount = entityCount;
		pageCount = ((entityCount - 1) / pageSize) + 1;
	}

	/**
	 * �����ܵļ�¼ҳ����
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * ��������·��
	 */
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * ���ص�ҳ���ݵĵ�������
	 */
	public Iterator<T> iterator() {
		if (data != null) {
			return data.iterator();
		} else {
			return null;
		}
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * ���ص�ҳ���ݡ�
	 */
	public Collection<T> getData() {
		return data;
	}

	/**
	 * ���õ�ҳ���ݡ�
	 */
	public void setData(Collection<T> data) {
		this.data = data;
	}
	
}
