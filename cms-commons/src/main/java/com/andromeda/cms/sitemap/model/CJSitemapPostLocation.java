package com.andromeda.cms.sitemap.model;

import com.andromeda.commons.model.BaseModel;

public class CJSitemapPostLocation extends BaseModel{
	private int id;
	private int year;
	private String url;
	
	
	public CJSitemapPostLocation(int year, String url) {
		super();
		this.year = year;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
