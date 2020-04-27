package cr.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Sort;

import cr.ms.dao.ArticleDao;
import cr.ms.pojo.Article;
import cr.ms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDao articleDao;
	
	/**
	 * 查询全部文章列表
	 * @return
	 */
	@Override
	public List<Article> listArticles() {
		//id降序
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		return articleDao.findAll(sort);
	}

	
	/**
	 * ID查找文章
	 *  @param aid 文章id
	 */
	@Override
	public Article getArticleById(int aid) {
		return articleDao.findById(aid);
	}

	
	/**
	 * 保存和修改文章
	 * @param article 文章对象
	 */
	@Override
	public void addAndUpdateArticle(Article article) {
		articleDao.save(article);
	}

	/**
	 * 删除文章
	 * @param aid 文章id
	 */
	@Override
	public void deleteArticleById(int aid) {
		articleDao.deleteById(aid);
		
	}

	
}
