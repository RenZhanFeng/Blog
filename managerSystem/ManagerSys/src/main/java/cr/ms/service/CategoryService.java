package cr.ms.service;

import java.util.List;

import cr.ms.pojo.Category;

public interface CategoryService {
	
	List<Category> list();
	
	Category getCategoryById(int id);
}
