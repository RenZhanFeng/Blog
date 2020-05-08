package cr.ms.dao;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import cr.ms.pojo.Article;
import cr.ms.pojo.Category;

public interface ArticleDao extends JpaRepository<Article,Integer>{
	
	/**
	 * 通过ID查找文章
	 * @param id 文章id
	 * @return
	 */
	Article findById(int id);
	
	
	/**
	 * 通过分类查找文章列表
	 * @param category 分类
	 * @return
	 */
	List<Article> findAllByCategory(Category category);
	
}
