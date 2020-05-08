package cr.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import cr.ms.dao.ArticleDao;
import cr.ms.dao.CategoryDAO;
import cr.ms.pojo.Article;
import cr.ms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDao articleDao;
	
	@Autowired
	private CategoryDAO categoryDao;
	
	
	/**
	 * 查询全部文章列表
	 * @return
	 */
	@Override
	public List<Article> listArticles() {
		// 排序方式，这里是以“id”为标准进行降序
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		return articleDao.findAll(sort);
	}
	
	/**
	 * 分页查询全部文章列表
	 * @return
	 */
	@Override
	public Page<Article> listArticles(int pageNum, int size) {
		// 排序方式，这里是以“id”为标准进行降序
		Sort sort = new Sort(Sort.Direction.DESC, "id");//记住一定要是实体类的属性，而不能是数据库的字段
		Pageable pageable = PageRequest.of(pageNum-1, size, sort);
		Page<Article> articleLists = articleDao.findAll(pageable);
		return articleLists;
	}

	/**
	 * 通过分类查找文章列表
	 * @param cid 分类id
	 * @return
	 */
	@Override
	public Page<Article> listByCategory(int page, int size, int cid) {
		Pageable pageable = PageRequest.of(page-1, size, new Sort(Sort.Direction.DESC, "id"));
		Page<Article> articleLists = articleDao.findAllByCategory(categoryDao.getOne(cid),pageable);
		System.out.println(articleLists);
		for (Article article : articleLists) {
			System.out.println(article.toString());
		}
		return articleLists;
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
