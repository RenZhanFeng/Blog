package cr.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cr.ms.enums.ArticleEnum;
import cr.ms.enums.ResultEnum;
import cr.ms.pojo.Category;
import cr.ms.result.Result;
import cr.ms.service.CategoryService;
import cr.ms.util.ResultUtil;

@RequestMapping("/api")
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	

	/**
	 * 分类列表
	 * @param cid 分类ID
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/categories")
	public Result categoryList() throws Exception {
		List<Category> categoryLists =  categoryService.list();
		if(!categoryLists.equals(null)) {
			return ResultUtil.success(categoryLists);
		}else {
			return ResultUtil.fail("分类结果为空");
		}
	}
	
	
	@PostMapping("/category")
	public Result saveAndUpdateCategory(Category category){
		System.out.println(category);
		categoryService.addAndupdateCategory(category);
		return ResultUtil.success(category);
	}
	
	@GetMapping("/categories/{id}/delete")
	public Result deleteCategory(@PathVariable("id") int id){
		System.out.println("由前台获取到的ID= " + id);
		categoryService.delCategory(id);
		return ResultUtil.success(ResultEnum.RESULT_DELETE_SUCCESS.getMessage());
	}
}
