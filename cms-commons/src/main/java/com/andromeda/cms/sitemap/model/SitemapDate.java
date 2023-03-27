package com.andromeda.cms.sitemap.model;

import java.util.Date;

import com.andromeda.commons.model.BaseModel;

public class SitemapDate extends BaseModel
{
	Date date;

	public SitemapDate(Date date) {
		super();
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
