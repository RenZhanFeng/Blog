package cr.ms.result;

/**
 * http请求返回的最外层对象
 * @author Clown
 *
 */
public class Result<T> {

	//响应码
	private Integer code; //响应码
	
	private String msg;  //提示信息
	
	private T data; //具体内容
	
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
