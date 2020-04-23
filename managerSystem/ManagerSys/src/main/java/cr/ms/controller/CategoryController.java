package cr.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@GetMapping("/category/books")
	public Result categoryList() throws Exception {
		List<Category> categoryLists =  categoryService.list();
		if(!categoryLists.equals(null)) {
			return ResultUtil.success(categoryLists);
		}else {
			return ResultUtil.fail("分类结果为空");
		}
	}
}
