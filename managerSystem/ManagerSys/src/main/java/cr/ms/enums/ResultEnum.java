package cr.ms.enums;

public enum ResultEnum {
	
	//RESULT_NOT_EXISTS(20001, "图书不存在"),
	RESULT_ADD_SUCCESS(20002, "添加成功"),
	RESULT_ADD_FAIL(20003, "添加失败"),
	RESULT_UPDATE_SUCCESS(20004, "更新成功"),
	RESULT_UPDATE_FAIL(20005, "更新失败"),
	RESULT_DELETE_SUCCESS(20006, "删除成功"),
	RESULT_DELETE_FAIL(20007, "删除失败"),
	RESULT_QUERY_SUCCESS(20008, "查询成功"),
	RESULT_QUERY_FAIL(20008, "查询失败"),
	RESULT_INFO_ERROR(20009, "图书信息错误"),
	RESULT_NOT_SEARCH(20010, "很抱歉，无法搜索到该书籍"),
	RESULT_UPLOAD_FILE_FAIL(20011, "文件上传失败"),
	RESULT_UPLOAD_FILE_NOT_NULL(20012, "上传文件不可为空"),
	RESULT_FILE_EXISTS(20012, "文件已存在");
	
	private int code; 
	private String message;
	
	ResultEnum(int code, String msg){
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
