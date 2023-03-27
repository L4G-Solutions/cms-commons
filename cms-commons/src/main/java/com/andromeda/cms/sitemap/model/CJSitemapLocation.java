package com.andromeda.cms.sitemap.model;

import com.andromeda.commons.model.BaseModel;

public class CJSitemapLocation extends BaseModel{
	private int id;
	private String type;
	private String url;
	
	
	public CJSitemapLocation(String url, String type) {
		super();
		this.type = type;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
