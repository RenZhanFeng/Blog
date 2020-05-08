package cr.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cr.ms.dao.CategoryDAO;
import cr.ms.pojo.Category;
import cr.ms.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	private CategoryDAO categoryDAO;
	
	public List<Category> list() {
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		return categoryDAO.findAll(sort);
	}
	
	public Category getCategoryById(int id) {
		Category category = categoryDAO.findById(id).orElse(null);
		return category;
	}

	@Override
	public void addAndupdateCategory(Category category) {
		categoryDAO.save(category);
	}

	@Override
	public void delCategory(int id) {
		categoryDAO.deleteById(id);
	}
}
