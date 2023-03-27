package com.andromeda.cms.sitemap.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.andromeda.cms.sitemap.model.CJSitemapDate;
import com.andromeda.commons.dao.BaseDAO;

public class CJSitemapDateDao extends BaseDAO{
	public List<CJSitemapDate> getAll() 
	{
		return sqlSessionTemplate.selectList("com.andromeda.cms.sitemap.model.CJSitemapDate.GetAll");
	}

	public int add(CJSitemapDate cJSitemapDate) 
	{
		Map<String, Object> params = new HashMap<>();
		params.put("p", cJSitemapDate);
		return sqlSessionTemplate.insert("com.andromeda.cms.sitemap.model.CJSitemapDate.Add", params);
	}
	
	public CJSitemapDate getLatestDate()
	{
		Date d = sqlSessionTemplate.selectOne("com.andromeda.cms.sitemap.model.CJSitemapDate.GetLatestDate");
		return new CJSitemapDate(d);
	}
	
	public CJSitemapDate getByDate(Date date)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("date", date);
		CJSitemapDate cJSitemapDate = sqlSessionTemplate.selectOne("com.andromeda.cms.sitemap.model.CJSitemapDate.GetByDate", params);
		return cJSitemapDate;
	}
}
