package com.andromeda.cms.sitemap.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.andromeda.cms.sitemap.model.CJSitemapLocation;
import com.andromeda.commons.dao.BaseDAO;


public class CJSitemapLocationDao extends BaseDAO{
	public List<CJSitemapLocation> getAll()
	{
		return sqlSessionTemplate.selectList("com.andromeda.cms.sitemap.model.CJSitemapLocation.GetAll");
	}
	
	public int add(CJSitemapLocation cJSitemapLocation) 
	{
		Map<String, Object> params = new HashMap<>();
		params.put("p", cJSitemapLocation);
		return sqlSessionTemplate.insert("com.andromeda.cms.sitemap.model.CJSitemapLocation.Add", params);
	}
	
	public List<CJSitemapLocation> getByType(String type)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("type", type);
		return sqlSessionTemplate.selectList("com.andromeda.cms.sitemap.model.CJSitemapLocation.GetByType", params);
	}
}
