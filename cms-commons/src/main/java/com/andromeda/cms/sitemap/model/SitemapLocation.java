package com.andromeda.cms.sitemap.model;

import com.andromeda.commons.model.BaseModel;

public class SitemapLocation extends BaseModel
{
	
	private int id;
	private String type;
	private String url;
	
	
	public SitemapLocation(String url, String type) {
		super();
		this.url = url;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
