package cr.ms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cr.ms.enums.ArticleEnum;
import cr.ms.pojo.Article;
import cr.ms.result.Result;
import cr.ms.service.ArticleService;
import cr.ms.util.ResultUtil;

@RequestMapping("/api")
@RestController
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;

//	/**
//	 * 查询文章列表
//	 * @return
//	 */
//	@GetMapping("/articles")
//	public List<Article> listArticles() {
//		
//	    return articleService.listArticles();
//	}
	
	/**
	 * 分页查询文章列表
	 * @param size 页面显示的数量
	 * @param page 页数
	 * @return
	 */
	@GetMapping("/articles")
	public Result listArticles(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
		System.out.println(page + "---size: " + size);
	    return ResultUtil.success(articleService.listArticles(page, size)) ;
	}
	
	@GetMapping("/article/{id}")
	public Result getArticle(@PathVariable("id") int aid) {
	    return ResultUtil.success(articleService.getArticleById(aid));
	}
	
	/**
	 * 保存和更新文章
	 * @param article
	 * @return
	 */
	@PostMapping("/admin/content/article")
	public Result saveArticle(@RequestBody Article article) {
		articleService.addAndUpdateArticle(article);
		if ("null".equals(String.valueOf(article.getId()))) {
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			System.out.println(nowTime);
		}
		return ResultUtil.success(article);
	}
	
	
	/**
	 * 删除文章
	 * @param id //文章id
	 */
	@GetMapping("/admin/article/{id}")
	public Result delectArticle(@PathVariable("id") int aid) {
		articleService.deleteArticleById(aid);
		return ResultUtil.success(ArticleEnum.ARTICLE_DELETE_SUCCESS.getMessage());
	}
	
}
