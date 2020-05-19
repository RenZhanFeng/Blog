package cr.ms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cr.ms.enums.DateFormatEnum;
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
	
	
	@PostMapping("/categories")
	public Result saveAndUpdateCategory(@RequestBody Category category) throws ParseException{
		System.out.println("id" + String.valueOf(category.getId()));
		System.out.println("UpdateTime: " + String.valueOf(category.getUpdateTime()));
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormatEnum.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS.getMessage());
		Date date = new Date();
		if (category.getCreateTime().equals(null)) {
			category.setCreateTime(sdf.format(date));
		}		
		category.setUpdateTime(sdf.format(date));
		categoryService.addAndupdateCategory(category);
		return ResultUtil.success(category);
	}
	
	
	@PostMapping("/categories/delete")
	public Result deleteCategory(@RequestBody Category category){
		System.out.println("由前台获取到的ID= " + category.getId());
		categoryService.delCategory(category.getId());
		return ResultUtil.success(ResultEnum.RESULT_DELETE_SUCCESS.getMessage());
	}
}
