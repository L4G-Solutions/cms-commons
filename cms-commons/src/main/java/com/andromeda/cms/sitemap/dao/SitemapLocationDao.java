package com.andromeda.cms.sitemap.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.andromeda.cms.model.Category;
import com.andromeda.cms.sitemap.model.SitemapLocation;
import com.andromeda.commons.dao.BaseDAO;


public class SitemapLocationDao extends BaseDAO
{
	public List<SitemapLocation> getAll()
	{
		return sqlSessionTemplate.selectList("com.andromeda.cms.sitemap.model.SitemapLocation.GetAll");
	}
	
	public int add(SitemapLocation sitemapLocation) 
	{
		Map<String, Object> params = new HashMap<>();
		params.put("p", sitemapLocation);
		return sqlSessionTemplate.insert("com.andromeda.cms.sitemap.model.SitemapLocation.Add", params);
	}
	
	public List<SitemapLocation> getByType(String type)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("type", type);
		return sqlSessionTemplate.selectList("com.andromeda.cms.sitemap.model.SitemapLocation.GetByType", params);
	}
	
}
