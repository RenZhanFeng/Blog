package cr.ms.result;

public class Result {

	//响应码
	private Integer code;
	
	private String msg;
		
	public Result(){}
	
	public Result(int code) {
		this.code = code;
	}
	
	public Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
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
	
	
	
}
