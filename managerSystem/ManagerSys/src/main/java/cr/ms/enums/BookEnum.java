package cr.ms.enums;

public enum BookEnum {
	
	BOOK_NOT_EXISTS(30001, "图书不存在"),
	BOOK_ADD_SUCCESS(30002, "添加成功"),
	BOOK_ADD_FAIL(30003, "添加失败"),
	BOOK_UPDATE_SUCCESS(30004, "更新成功"),
	BOOK_UPDATE_FAIL(30005, "更新失败"),
	BOOK_DELETE_SUCCESS(30006, "删除成功"),
	BOOK_DELETE_FAIL(30007, "删除失败"),
	BOOK_QUERY_SUCCESS(30008, "查询成功"),
	BOOK_QUERY_FAIL(30008, "查询失败"),
	BOOK_INFO_ERROR(30009, "图书信息错误"),
	BOOK_NOT_SEARCH(30010, "很抱歉，无法搜索到该书籍");
	
	private int code; 
	private String message;
	
	BookEnum(int code, String msg){
		this.code = code;
		this.message = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	
}
