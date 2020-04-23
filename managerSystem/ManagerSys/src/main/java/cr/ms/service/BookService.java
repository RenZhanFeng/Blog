package cr.ms.service;

import java.util.List;

import cr.ms.pojo.Book;
import cr.ms.pojo.Category;

public interface BookService {

	/**
	 * 图书列表
	 * @return
	 */
	List<Book> bookLists();
	
	void addOrUpdate(Book book);
	
	void deleteById(int id);
	
	List<Book> listByCategory(int cid);
	
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
	
	List<Book> search(String keywords);
}
