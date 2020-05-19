package cr.ms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.elasticsearch.search.aggregations.pipeline.movavg.models.EwmaModel;
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
	    return ResultUtil.success(articleService.listArticles(page, size)) ;
	}
	
	/**
	 * 通过分类查询文章列表
	 * @param size 页面显示的数量
	 * @param page 页数
	 * @return
	 */
	@GetMapping("/articles/cid={id}")
	public Result listArticles(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size", defaultValue = "10") int size, @PathVariable("id") int cid) {
	    return ResultUtil.success(articleService.listByCategory(page, size, cid)) ;
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

		System.out.println("id" + String.valueOf(article.getId()));
//		if (!article.getArticleDate().equals(null)) {
//			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(TimeUtil.stringToDate(article.getArticleDate()));
//			//String date= article.getArticleDate();
//	
//			article.setArticleDate(nowTime);
//			System.out.println(nowTime);
//		}	
//		if (article.getArticleDate() instanceof Date) {
//			Date new_name = (Date) article.getArticleDate();
//			
//		}
		return ResultUtil.success(article);
	}
	
	/**
	 * 删除文章
	 * @param id //文章id
	 */
	@PostMapping("/admin/article")
	public Result delectArticle(@RequestBody Article article) {
		System.out.println(article);
		articleService.deleteArticleById(article.getId());
		return ResultUtil.success(ArticleEnum.ARTICLE_DELETE_SUCCESS.getMessage());
	}
	
}
