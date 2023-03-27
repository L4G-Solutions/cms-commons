package com.andromeda.cms.sitemap.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.andromeda.cms.sitemap.model.SitemapDate;
import com.andromeda.commons.dao.BaseDAO;

public class SitemapDateDao extends BaseDAO
{
	public List<SitemapDate> getAll() 
	{
		return sqlSessionTemplate.selectList("com.andromeda.cms.sitemap.model.SitemapDate.GetAll");
	}

	public int add(SitemapDate sitemapDate) 
	{
		Map<String, Object> params = new HashMap<>();
		params.put("p", sitemapDate);
		return sqlSessionTemplate.insert("com.andromeda.cms.sitemap.model.SitemapDate.Add", params);
	}
	
	public SitemapDate getLatestDate()
	{
		Date d = sqlSessionTemplate.selectOne("com.andromeda.cms.sitemap.model.SitemapDate.GetLatestDate");
		return new SitemapDate(d);
	}
	
	public SitemapDate getByDate(Date date)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("date", date);
		SitemapDate sitemapDate = sqlSessionTemplate.selectOne("com.andromeda.cms.sitemap.model.SitemapDate.GetByDate", params);
		return sitemapDate;
	}
}
