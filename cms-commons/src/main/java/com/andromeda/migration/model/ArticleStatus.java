package com.andromeda.migration.model;

import com.andromeda.commons.model.BaseModel;

public class ArticleStatus extends BaseModel {
	int id;
	String abnStoryId;
	boolean status;

	public ArticleStatus() {
		super();
	}

	public ArticleStatus(int id, String abnStoryId, boolean status) {
		super();
		this.id = id;
		this.abnStoryId = abnStoryId;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbnStoryId() {
		return abnStoryId;
	}

	public void setAbnStoryId(String abnStoryId) {
		this.abnStoryId = abnStoryId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
