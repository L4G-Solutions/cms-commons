package com.andromeda.cms.sitemap.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.andromeda.cms.sitemap.model.SitemapPostLocation;
import com.andromeda.commons.dao.BaseDAO;

public class SitemapPostLocationDao extends BaseDAO
{
	public List<SitemapPostLocation> getAll()
	{
		return sqlSessionTemplate.selectList("com.andromeda.cms.sitemap.model.SitemapPostLocation.GetAll");
	}
	
	public int add(SitemapPostLocation sitemapPostLocation) 
	{
		Map<String, Object> params = new HashMap<>();
		params.put("p", sitemapPostLocation);
		return sqlSessionTemplate.insert("com.andromeda.cms.sitemap.model.SitemapPostLocation.Add", params);
	}
	
	public List<SitemapPostLocation> getByYear(int year)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("year", year);
		return sqlSessionTemplate.selectList("com.andromeda.cms.sitemap.model.SitemapPostLocation.GetByYear", params);
	}
}
