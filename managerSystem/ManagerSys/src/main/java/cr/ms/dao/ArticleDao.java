package cr.ms.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import cr.ms.pojo.Article;

public interface ArticleDao extends JpaRepository<Article,Integer>{
	
	/**
	 * 通过ID查找文章
	 * @param id 文章id
	 * @return
	 */
	Article findById(int id);
	
}
