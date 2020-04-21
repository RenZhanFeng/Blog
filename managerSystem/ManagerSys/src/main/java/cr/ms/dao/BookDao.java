package cr.ms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cr.ms.pojo.Book;
import cr.ms.pojo.Category;

public interface BookDao extends JpaRepository<Book,Integer> {

	/**
	 * 通过分类查找全部图书
	 * @param category 分类
	 * @return 图书列表
	 */
	List<Book> findAllByCategory(Category category);
	
	/**
	 * 通过作者或标题查找全部图书
	 * @param keyword1 //关键词1
	 * @param keyword2 //关键词2
	 * @return 图书列表
	 */
	List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
