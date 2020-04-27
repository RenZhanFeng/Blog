package cr.ms.service;

import java.util.List;

import cr.ms.pojo.Article;

public interface ArticleService {
	
	
	/**
	 * 查询全部文章列表
	 * @return
	 */
	List<Article> listArticles();
	
	
	/**
	 * 通过ID查找文章
	 * @param id 文章id
	 * @return
	 */
	Article getArticleById(int aid);
	
	/**
	 * 保存和修改文章
	 * @param article 文章对象
	 */
	void addAndUpdateArticle(Article article);
	
	/**
	 * 删除文章
	 * @param aid 文章id
	 */
	void deleteArticleById(int aid);
}
