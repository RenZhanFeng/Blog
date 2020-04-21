package cr.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cr.ms.pojo.Book;
import cr.ms.service.BookService;

@RequestMapping("/api")
@RestController
public class LibraryController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> bookLists() throws Exception {
		return bookService.bookLists();
	}
	
	@PostMapping("/books")
	public Book addOrUpdate(@RequestBody Book book) throws Exception {
		bookService.addOrUpdate(book);
		return book;
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody Book book) throws Exception {
		bookService.deleteById(book.getId());
	}
	
	@GetMapping("/category/{cid}/books")
	public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
		if (0 != cid) {
			return bookService.listByCategory(cid);
		}else {
			return bookLists();
		}
	}
}
