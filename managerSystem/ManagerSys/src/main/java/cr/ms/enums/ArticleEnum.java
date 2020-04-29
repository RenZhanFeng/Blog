package cr.ms.enums;

public enum ArticleEnum {
	
	ARTICLE_NOT_EXISTS(50001, "图书不存在"),
	ARTICLE_ADD_SUCCESS(50002, "添加成功"),
	ARTICLE_ADD_FAIL(50003, "添加失败"),
	ARTICLE_UPDATE_SUCCESS(50004, "更新成功"),
	ARTICLE_UPDATE_FAIL(50005, "更新失败"),
	ARTICLE_DELETE_SUCCESS(50006, "删除成功"),
	ARTICLE_DELETE_FAIL(50007, "删除失败"),
	ARTICLE_QUERY_SUCCESS(50008, "查询成功"),
	ARTICLE_QUERY_FAIL(50008, "查询失败"),
	ARTICLE_INFO_ERROR(50009, "图书信息错误"),
	ARTICLE_NOT_SEARCH(30010, "很抱歉，无法搜索到该书籍");
	
	private int code; 
	private String message;
	
	ArticleEnum(int code, String msg){
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
