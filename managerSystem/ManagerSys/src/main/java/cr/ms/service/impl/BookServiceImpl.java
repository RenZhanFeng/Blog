package cr.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cr.ms.dao.BookDao;
import cr.ms.pojo.Book;
import cr.ms.pojo.Category;
import cr.ms.service.BookService;
import cr.ms.service.CategoryService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 图书列表（降序）
	 * @return 
	 */
	public List<Book> bookLists(){
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		return bookDao.findAll(sort);
	}
	
	/**
	 * 添加或更新图书
	 * @param book 图书
	 */
	public void addOrUpdate(Book book) {
		bookDao.save(book);
	}
	
	/**
	 * 删除图书
	 * @param id
	 */
	public void deleteById(int id) {
		bookDao.deleteById(id);
    }
	
	public List<Book> listByCategory(int cid) {
        Category category = categoryService.getCategoryById(cid);
        return bookDao.findAllByCategory(category);
    }
	
	@Override
	public List<Book> findAllByCategory(Category category) {
		//Category category2 
		return null;
	}

	@Override
	public List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2) {
		// TODO Auto-generated method stub
		return null;
	}

}
