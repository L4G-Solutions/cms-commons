package com.andromeda.cms.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.andromeda.cms.commons.dao.CmsBaseDao;
import com.andromeda.cms.defs.StrapiConstants;
import com.andromeda.cms.model.CJLiveBlog;

public class CJLiveBlogDao extends CmsBaseDao{

	private static String MASTER_TABLE = "cms_proxy.cj_liveblogs";
		private static String PARTITION_ID_COLUMN = "publishedYear";
		private static String UNIQUE_COLUMN = "id";
		private static String INDEX_COLUMN_1 = "publishedAt";
		private static String INDEX_COLUMN_2 = "primaryCategoryId";
		private static String INDEX_COLUMN_3 = "primarySubCategoryId";

		@Override
		public String getTableName()
		{
			return MASTER_TABLE;
		}

		@Override
		public String getMasterTable()
		{
			return MASTER_TABLE;
		}

		@Override
		public String getUniqueColumn()
		{
			return UNIQUE_COLUMN;
		}

		@Override
		public String getPartitionIdColumn()
		{
			return PARTITION_ID_COLUMN;
		}

		@Override
		public String getIndexColumn1()
		{
			return INDEX_COLUMN_1;
		}
		
		@Override
		public String getIndexColumn2()
		{
			return INDEX_COLUMN_2;
		}
		
		@Override
		public String getIndexColumn3()
		{
			return INDEX_COLUMN_3;
		}
		
		
		public void add(CJLiveBlog cjLiveBlog)
		{
			int publishedYear = cjLiveBlog.getPublishedYear();
			String tableName = getPartitionTableName(publishedYear);
			System.out.println("tableName: " + tableName);
			Map<String, Object> params = new HashMap<>();
			params.put("tableName", tableName);
			params.put("p", cjLiveBlog);
			sqlSessionTemplate.insert("com.andromeda.cms.model.CJLiveBlog.Add", params);
		}
		
	
		public int update(CJLiveBlog cjLiveBlog) 
		{
			Map<String, Object> params = new HashMap<>();
			params.put("p", cjLiveBlog);
			return sqlSessionTemplate.update("com.andromeda.cms.model.CJLiveBlog.Update", params);
		}

		
		public List<CJLiveBlog> getLatestArticlesWithoutPriority(String contentType, Integer limit)
		{
			List<CJLiveBlog> latestArticles = new ArrayList<>();
			
			Map<String, Object> params = new HashMap<>();
			params.put("contentType", contentType);
			params.put("limit", limit);
			
			List<CJLiveBlog> latestOTPriority =  sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLatestArticlesWithoutPriority", params);
			
			latestArticles.addAll(latestOTPriority);
			return latestArticles;
		}
		
		
		public List<CJLiveBlog> getLatestArticles(String contentType, Integer limit)
		{
			List<CJLiveBlog> latestArticles = new ArrayList<>();
			Map<String, Object> params = new HashMap<>();
			params.put("limit", StrapiConstants.PRIORITY_LIMIT);
			params.put("contentType", contentType);
			List<CJLiveBlog> latestInPriority =  sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLatestArticlesInPriority", params);
			
			latestArticles.addAll(latestInPriority);
			
			List<Integer> latestInPriorityIds = new ArrayList<>();
			if(latestInPriority != null)
			{
				for (CJLiveBlog article : latestInPriority) {
					latestInPriorityIds.add(article.getId());
				}	
			}
			
			params.put("limit", limit);
			if(latestInPriorityIds.size() > 0)
				params.put("latestInPriorityIds", latestInPriorityIds);
			else
				params.put("latestInPriorityIds", null);
			List<CJLiveBlog> latestOTPriority =  sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLatestArticles", params);
			
			latestArticles.addAll(latestOTPriority);
			return latestArticles;
		}
		
		public List<CJLiveBlog> getLatestArticlesOnCreated(String contentType, Integer limit)
		{
			List<CJLiveBlog> latestArticles = new ArrayList<>();
			Map<String, Object> params = new HashMap<>();
			params.put("contentType", contentType);
			params.put("limit", limit);
			
			List<CJLiveBlog> latestOTPriority =  sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLatestArticlesOnCreated", params);
			
			latestArticles.addAll(latestOTPriority);
			return latestArticles;
		}
		
		public List<CJLiveBlog> getLatestVideos(Integer limit)
		{
			List<CJLiveBlog> latestVideos = new ArrayList<>();
			
			Map<String, Object> params = new HashMap<>();
			params.put("limit", StrapiConstants.PRIORITY_LIMIT);
			params.put("contentType", StrapiConstants.CONTENT_TYPE_CHITRA_VIDEO);
			List<CJLiveBlog> latestInPriority =  sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLatestArticlesInPriority", params);
			
			latestVideos.addAll(latestInPriority);
			
			List<Integer> latestInPriorityIds = new ArrayList<>();
			if(latestInPriority != null)
			{
				for (CJLiveBlog article : latestInPriority) {
					latestInPriorityIds.add(article.getId());
				}	
			}
			
			params.put("limit", limit);
			if(latestInPriorityIds.size() > 0)
				params.put("latestInPriorityIds", latestInPriorityIds);
			else
				params.put("latestInPriorityIds", null);
			List<CJLiveBlog> latestOTPriority =   sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLatestArticles", params);
			latestVideos.addAll(latestOTPriority);
			
			return latestVideos;
		}
		
		
		public List<CJLiveBlog> getVideos(Integer limit)
		{
			Map<String, Object> params = new HashMap<>();
			params.put("limit", limit);
			return sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetVideos", params);
		}

		public CJLiveBlog getById(int id) {
			Map<String, Object> params = new HashMap<>();
			params.put("id", id);
			return sqlSessionTemplate.selectOne("com.andromeda.cms.model.CJLiveBlog.GetById", params);
		}
		
		
		public CJLiveBlog getByIdWOPublished(int id) {
			Map<String, Object> params = new HashMap<>();
			params.put("id", id);
			return sqlSessionTemplate.selectOne("com.andromeda.cms.model.CJLiveBlog.GetByIdWOPublished", params);
		}
		
		public List<CJLiveBlog> getSubCategoryRelatedArticles(int subCategoryId) {
			
				Map<String, Object> params = new HashMap<>();
				params.put("subCategoryId", subCategoryId);
				return sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetBySubCategoryId", params);
		}

		public List<CJLiveBlog> getByCategoryId(int categoryId) {
				Map<String, Object> params = new HashMap<>();
				params.put("categoryId", categoryId);
				return sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetByCategoryId", params);
		}
		
		public List<CJLiveBlog> getLatestByCategoryIdWithoutPriority(int categoryId, Integer limit, Integer offset) 
		{
			if(categoryId != 0)
			{
				List<CJLiveBlog> latestArticles = new ArrayList<>();
				Map<String, Object> params = new HashMap<>();
				params.put("categoryId", categoryId);
				params.put("limit", limit);
				params.put("offset", offset);
				params.put("latestInPriorityIds", null);
				List<CJLiveBlog> latestOTPriority = sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLatestByCategoryIdWithoutPriority", params);
				
				latestArticles.addAll(latestOTPriority);
				return latestArticles;
				
			}
			return null;
		}
		
		
		public List<CJLiveBlog> getLatestByCategoryIdOnCreated(int categoryId, Integer limit, Integer offset) 
		{
			if(categoryId != 0)
			{
				List<CJLiveBlog> latestArticles = new ArrayList<>();
				Map<String, Object> params = new HashMap<>();
				params.put("limit", StrapiConstants.PRIORITY_LIMIT);
				params.put("categoryId", categoryId);
				List<CJLiveBlog> latestInPriority =  sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLatestInPriorityByCategoryIdOnCreated", params);
				
				latestArticles.addAll(latestInPriority);
				
				List<Integer> latestInPriorityIds = new ArrayList<>();
				if(latestInPriority != null)
				{
					for (CJLiveBlog article : latestInPriority) {
						latestInPriorityIds.add(article.getId());
					}	
				}
				
				params.put("limit", limit);
				params.put("offset", offset);
				if(latestInPriorityIds.size() > 0)
					params.put("latestInPriorityIds", latestInPriorityIds);
				else
					params.put("latestInPriorityIds", null);
				List<CJLiveBlog> latestOTPriority = sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLatestByCategoryIdOnCreated", params);
				
				latestArticles.addAll(latestOTPriority);
				return latestArticles;
				
			}
			return null;
		}
		

		public List<CJLiveBlog> getLatestByCategoryId(int categoryId, Integer limit, Integer offset) 
		{
			if(categoryId != 0)
			{
				List<CJLiveBlog> latestArticles = new ArrayList<>();
				Map<String, Object> params = new HashMap<>();
				params.put("limit", StrapiConstants.PRIORITY_LIMIT);
				params.put("categoryId", categoryId);
				List<CJLiveBlog> latestInPriority =  sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLatestInPriorityByCategoryId", params);
				
				latestArticles.addAll(latestInPriority);
				
				List<Integer> latestInPriorityIds = new ArrayList<>();
				if(latestInPriority != null)
				{
					for (CJLiveBlog article : latestInPriority) {
						latestInPriorityIds.add(article.getId());
					}	
				}
				
				params.put("limit", limit);
				params.put("offset", offset);
				if(latestInPriorityIds.size() > 0)
					params.put("latestInPriorityIds", latestInPriorityIds);
				else
					params.put("latestInPriorityIds", null);
				List<CJLiveBlog> latestOTPriority = sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLatestByCategoryId", params);
				
				latestArticles.addAll(latestOTPriority);
				return latestArticles;
				
			}
			return null;
		}
		
		public List<CJLiveBlog> getBySubCategoryId(int subCategoryId) {
			Map<String, Object> params = new HashMap<>();
			params.put("subCategoryId", subCategoryId);
			return sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetBySubCategoryId", params);
		}
		
		public List<CJLiveBlog> getLatestBySubCategoryIdWithoutPriority(String contentType, int categoryId, int subCategoryId, Integer limit, Integer offset) 
		{
			if(subCategoryId != 0)
			{
				List<CJLiveBlog> latestArticles = new ArrayList<>();
				Map<String, Object> params = new HashMap<>();
				
				params.put("contentType", contentType);
				params.put("subCategoryId", subCategoryId);
				params.put("categoryId", categoryId);
				params.put("limit", limit);
				params.put("offset", offset);
				
				List<CJLiveBlog> latestOTPriority = sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLatestBySubCategoryIdWithoutPriority", params);
				
				latestArticles.addAll(latestOTPriority);
				return latestArticles;
			}
			return null;
		}
		
		public List<CJLiveBlog> getLatestBySubCategoryIdOnCreated(String contentType, int categoryId, int subCategoryId, Integer limit, Integer offset) 
		{
			if(subCategoryId != 0)
			{
				List<CJLiveBlog> latestArticles = new ArrayList<>();
				Map<String, Object> params = new HashMap<>();
				params.put("contentType", contentType);
				params.put("subCategoryId", subCategoryId);
				params.put("categoryId", categoryId);
				params.put("limit", limit);
				params.put("offset", offset);
				
				List<CJLiveBlog> latestOTPriority = sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLatestBySubCategoryIdOnCreated", params);
				
				latestArticles.addAll(latestOTPriority);
				return latestArticles;
			}
			return null;
		}
		
		public List<CJLiveBlog> getLatestBySubCategoryId(String contentType, int categoryId, int subCategoryId, Integer limit, Integer offset) 
		{
			if(subCategoryId != 0)
			{
				List<CJLiveBlog> latestArticles = new ArrayList<>();
				Map<String, Object> params = new HashMap<>();
				params.put("contentType", contentType);
				params.put("subCategoryId", subCategoryId);
				params.put("categoryId", categoryId);
				params.put("limit", limit);
				params.put("offset", offset);
				
				List<CJLiveBlog> latestOTPriority = sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLatestBySubCategoryId", params);
				
				latestArticles.addAll(latestOTPriority);
				return latestArticles;
			}
			return null;
		}

		public List<Date> getDistinctPublishDates() 
		{
			return sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetDistinctPublishDates");
		}
		
		public List<Integer> getDistinctPublishYears() 
		{
			return sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetDistinctPublishYears");
		}
		
		public Date getMaxArticlePublishDate() 
		{
			return sqlSessionTemplate.selectOne("com.andromeda.cms.model.CJLiveBlog.GetMaxArticlePublishDate");
		}

		public List<CJLiveBlog> getByPublishedDate(Date date) {
			Map<String, Object> params = new HashMap<>();
			params.put("publishedAt", date);
			return sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetByPublishedDate", params);
		}

		/*public List<CJLiveBlog> getLatestPriorityArticles(Integer limit) {
			Map<String, Object> params = new HashMap<>();
			params.put("limit", StrapiConstants.LIMIT);
			List<CJLiveBlog> priorityArticles =  sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLatestPriorityArticles", params);
			return priorityArticles;
		}*/

		public List<CJLiveBlog> getByPublishedYear(String contentType, int publishedYear) {
			Map<String, Object> params = new HashMap<>();
			params.put("contentType", contentType);
			params.put("publishedYear", publishedYear);
			List<CJLiveBlog> chitraArticles =  sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetByPublishedYear", params);
			return chitraArticles;
		}

		/*public List<CJLiveBlog> getRkArticlesWithLetter(int categoryId, String c, int limit) {
			Map<String, Object> params = new HashMap<>();
			params.put("categoryId", categoryId);
			params.put("startChar", c);
			params.put("limit", limit);
			List<CJLiveBlog> chitraArticles =  sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetRkArticlesWithLetter", params);
			return chitraArticles;
		}*/

		public void deleteById(int id) {
			Map<String, Object> params = new HashMap<>();
			params.put("id", id);
			sqlSessionTemplate.delete("com.andromeda.cms.model.CJLiveBlog.DeleteById", params);
		}

		public List<CJLiveBlog> getTagRelatedLiveblogs(String tag, int limit) {
			Map<String, Object> params = new HashMap<>();
			params.put("tag", "%," + tag + ",%" ); // ,tag,
			params.put("limit", limit);
			return sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetLiveblogsWithTag", params);
		}

		public List<CJLiveBlog> getByIds(List<Long> ids) {
			Map<String, Object> params = new HashMap<>();
			params.put("ids", ids);
			return sqlSessionTemplate.selectList("com.andromeda.cms.model.CJLiveBlog.GetByIds", params);
		}

}
