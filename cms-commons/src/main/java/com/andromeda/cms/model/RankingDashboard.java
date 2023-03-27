package com.andromeda.cms.model;

import java.sql.Timestamp;
import java.util.List;

import com.andromeda.commons.model.BaseModel;

public class RankingDashboard extends BaseModel {
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Timestamp publishedAt;
	private String publishedAtSm;
	private String updatedAtSm;
	private int id;
	private List<RankingItem> rankingItems;

	public String getPublishedAtSm() {
		return publishedAtSm;
	}

	public void setPublishedAtSm(String publishedAtSm) {
		this.publishedAtSm = publishedAtSm;
	}

	public String getUpdatedAtSm() {
		return updatedAtSm;
	}

	public void setUpdatedAtSm(String updatedAtSm) {
		this.updatedAtSm = updatedAtSm;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(Timestamp publishedAt) {
		this.publishedAt = publishedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<RankingItem> getRankingItems() {
		return rankingItems;
	}

	public void setRankingItems(List<RankingItem> rankingItems) {
		this.rankingItems = rankingItems;
	}

}
