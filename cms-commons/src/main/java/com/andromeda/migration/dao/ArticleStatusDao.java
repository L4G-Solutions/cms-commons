package com.andromeda.migration.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.andromeda.commons.dao.BaseDAO;
import com.andromeda.migration.model.ArticleStatus;

public class ArticleStatusDao extends BaseDAO
{
	public List<ArticleStatus> getAll()
	{
		return sqlSessionTemplate.selectList("com.andromeda.migration.model.ArticleStatus.GetAll");
	}
	
	public int add(ArticleStatus articleStatus) 
	{
		Map<String, Object> params = new HashMap<>();
		params.put("p", articleStatus);
		return sqlSessionTemplate.insert("com.andromeda.migration.model.ArticleStatus.Add", params);
	}
	
	public ArticleStatus getById(int id)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return sqlSessionTemplate.selectOne("com.andromeda.migration.model.ArticleStatus.GetById", params);
	}
}
