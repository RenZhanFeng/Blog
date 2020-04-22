package cr.ms.result;

import java.util.List;

import cr.ms.pojo.Book;

public class BookResult extends Result {
	
	//响应码
	private Integer code;
	
	private String msg;
	
	private List<Book> books;
	
	public BookResult() {}
	
	public BookResult(Result result, List<Book> books) {
		this.books = books;
	}

	public BookResult(Integer code, String msg, List<Book> books) {
		super();
		this.code = code;
		this.msg = msg;
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
