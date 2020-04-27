package cr.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cr.ms.pojo.Article;
import cr.ms.result.Result;
import cr.ms.service.ArticleService;
import cr.ms.util.ResultUtil;

@RequestMapping("/api")
@RestController
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	
	@PostMapping("/admin/content/article")
	public Result saveArticle(@RequestBody Article article) {
		articleService.addAndUpdateArticle(article);
		return ResultUtil.success(article);
	}

}
