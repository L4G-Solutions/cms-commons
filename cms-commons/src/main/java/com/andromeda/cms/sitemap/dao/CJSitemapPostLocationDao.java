package com.andromeda.cms.sitemap.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.andromeda.cms.sitemap.model.CJSitemapPostLocation;
import com.andromeda.commons.dao.BaseDAO;


public class CJSitemapPostLocationDao extends BaseDAO{
	public List<CJSitemapPostLocation> getAll()
	{
		return sqlSessionTemplate.selectList("com.andromeda.cms.sitemap.model.CJSitemapPostLocation.GetAll");
	}
	
	public int add(CJSitemapPostLocation CJSitemapPostLocation) 
	{
		Map<String, Object> params = new HashMap<>();
		params.put("p", CJSitemapPostLocation);
		return sqlSessionTemplate.insert("com.andromeda.cms.sitemap.model.CJSitemapPostLocation.Add", params);
	}
	
	public List<CJSitemapPostLocation> getByYear(int year)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("year", year);
		return sqlSessionTemplate.selectList("com.andromeda.cms.sitemap.model.CJSitemapPostLocation.GetByYear", params);
	}
}
