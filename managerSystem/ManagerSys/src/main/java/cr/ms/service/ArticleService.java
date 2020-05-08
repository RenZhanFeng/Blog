package cr.ms.service;

import java.util.List;

import org.springframework.data.domain.Page;

import cr.ms.pojo.Article;

public interface ArticleService {
	
	
	/**
	 * 查询全部文章列表
	 * @return
	 */
	List<Article> listArticles();
	
	/**
	 * 分页查询全部文章列表
	 * @return
	 */
	Page<Article> listArticles(int pageNum, int size);

	/**
	 * 通过分类查找文章列表
	 * @param category 分类
	 * @return
	 */
	List<Article> listByCategory(int page, int size, int cid);
	
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
