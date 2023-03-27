package com.andromeda.cms.model;

import com.andromeda.commons.model.BaseModel;

public class RankingItem extends BaseModel
{
	private int id;
	private long storyId;
	private String storyType;
	private String website;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getStoryId() {
		return storyId;
	}
	public void setStoryId(long storyId) {
		this.storyId = storyId;
	}
	public String getStoryType() {
		return storyType;
	}
	public void setStoryType(String storyType) {
		this.storyType = storyType;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	
}
