package com.lh.entity;

import org.hibernate.SessionFactory;

public class HibernateSFBean {
	private static SessionFactory sf;

	/**
	 * 
	 */
	public HibernateSFBean() {
		super();
	}

	/**
	 * @return the sf
	 */
	public static SessionFactory getSf() {
		return sf;
	}

	/**
	 * @param sf the sf to set
	 */
	public static void setSf(SessionFactory sf) {
		HibernateSFBean.sf = sf;
	}
}
