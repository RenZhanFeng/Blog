package cr.ms.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cr.ms.pojo.Book;
import cr.ms.service.BookService;
import cr.ms.util.StringUtils;

@RequestMapping("/api")
@RestController
public class LibraryController {

	@Autowired
	private BookService bookService;
	
	/**
	 * 图书列表
	 * @return 
	 * @throws Exception
	 */
	@GetMapping("/books")
	public List<Book> bookLists() throws Exception {
		return bookService.bookLists();
	}
	
	/**
	 * 保存和修改图书
	 * @param book 图书
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/books")
	public Book addOrUpdate(@RequestBody Book book) throws Exception {
		bookService.addOrUpdate(book);
		return book;
	}
	
	/**
	 * 删除图书
	 * @param book 图书
	 * @throws Exception
	 */
	@PostMapping("/delete")
	public void delete(@RequestBody Book book) throws Exception {
		bookService.deleteById(book.getId());
	}
	
	/**
	 * 分类查询图书列表
	 * @param cid 分类ID
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/category/{cid}/books")
	public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
		if (0 != cid) {
			return bookService.listByCategory(cid);
		}else {
			return bookLists();
		}
	}
	
	/**
	 * 封面上传
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@CrossOrigin //实现跨域
	@PostMapping("/covers")
	public String coversUpload(@RequestBody MultipartFile file) throws Exception {
		//获取项目路径
		String folder = System.getProperty("user.dir").concat("/src/main/resources/static/img");
		//创建文件保存文件夹
		File imgFolder = new File(folder);
//		String fileName = file.getOriginalFilename();  //获取文件名
		//新建文件保存于服务器	
//		File destFile = new File(imgFolder, StringUtils.getRandomString(6) + "-" + file.getOriginalFilename());//教程方式
		//修改，生成新的文件名
		File destFile = new File(imgFolder, UUID.randomUUID() + "-" + file.getOriginalFilename());
		if (!destFile.getParentFile().exists()) {//判断父目录是否存在
			imgFolder.getParentFile().mkdirs();
		}
		try {
			System.out.println("目标文件保存于：" + destFile);
			file.transferTo(destFile); //保存文件
			String imgURL = "http://localhost:8443/api/file/" + destFile.getName();
			return imgURL;
		} catch (IOException e) {
			e.printStackTrace();
	        return "";
		}
		
	}
	
}
