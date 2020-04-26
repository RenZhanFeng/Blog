package cr.ms.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cr.ms.enums.BookEnum;
import cr.ms.pojo.Book;
import cr.ms.pojo.Category;
import cr.ms.result.Result;
import cr.ms.service.BookService;
import cr.ms.service.CategoryService;
import cr.ms.util.ResultUtil;


@RequestMapping("/api")
@RestController
public class LibraryController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 图书列表
	 * @return 
	 * @throws Exception
	 */
	@GetMapping("/books")
	public Result bookLists() throws Exception {
		List<Book> books = bookService.bookLists();
		if (!books.equals(null)) {
			return ResultUtil.success(books);
		}
		return ResultUtil.fail(BookEnum.BOOK_QUERY_FAIL.getMessage());
	}
	
	/**
	 * 保存和修改图书
	 * @param book 图书
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/books")
	public Result addOrUpdate(@RequestBody Book book) throws Exception {
		System.out.println("传入的book对象" + book.toString());
		System.out.println(book.getDate().toString());
		
		//通过分类id设置分类值name
		Category category = categoryService.getCategoryById(book.getCategory().getId());
		//设置分类属性
		book.setCategory(category);
		System.out.println("修改后的book对象" + book.toString());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String date = (String)book.getDate().toString();
//		String date1 = sdf.format(date);
//		book.setDate(date1);
//		System.out.println(date1);
		bookService.addOrUpdate(book);
		return ResultUtil.success(book);
	}
	
	/**
	 * 删除图书
	 * @param book 图书
	 * @throws Exception
	 */
	@PostMapping("/delete")
	public Result delete(@RequestBody Book book) throws Exception {
		bookService.deleteById(book.getId());
		return ResultUtil.success(BookEnum.BOOK_DELETE_SUCCESS.getMessage());
	}

	
	/**
	 * 分类查询图书列表
	 * @param cid 分类ID
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/categories/{cid}/books")
	public Result listByCategory(@PathVariable("cid") int cid) throws Exception {
		if (0 != cid) {
			return ResultUtil.success(bookService.listByCategory(cid));
		}else {
			return ResultUtil.fail("分类不存在");
		}
	}
	
	@GetMapping("/search")
	public Result searchResult(@RequestParam("keywords") String keywords) throws Exception {
		//关键词为空时查询所有书籍
		if ("".equals(keywords)) {
			return this.bookLists();
		}
		List<Book> books = bookService.search(keywords);
		if (books != null && !books.isEmpty()) {
			return ResultUtil.success(books);
		}
		return ResultUtil.fail("很抱歉，无法搜索到该书籍");
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
		String folder = System.getProperty("user.dir").concat("/api/file");
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
			String imgURL = "http://clownz.xyz:8220/api/file/" + destFile.getName();
			System.out.println();
			return imgURL;
		} catch (IOException e) {
			e.printStackTrace();
	        return "";
		}
		
	}
	
	
	@GetMapping("/file")
	public String downloadImage(String imgName, HttpServletRequest request, HttpServletResponse response)  {
		
		String fileUrl = System.getProperty("user.dir").concat("\\api\\file\\") + imgName;
//		String fileUrl = request.getRequestURL() + imgName;
		if(fileUrl != null) {//目标文件是否存在
			fileUrl = fileUrl.replace("\\", "/").toString();
			File file = new File(fileUrl);
			if(file.exists()) {//文件存在
				//设置响应头
				response.setContentType("image/jpeg"); //设置强制下载不打开
				response.addHeader("Content-Disposition", "attachment;fileName=" + imgName);
				//response.setHeader("Context-Type", "application/x-jpg");

				byte[] bf = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
						
				try {
					fis = new FileInputStream(file);
	                bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(bf);;
					while(i != -1) {
						os.write(bf, 0, i);
						i = bis.read(bf);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

				}		
			}
		}
		return null;
	}
	
}
