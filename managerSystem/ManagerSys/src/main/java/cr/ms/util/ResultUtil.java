package cr.ms.util;

import cr.ms.enums.BookEnum;
import cr.ms.result.Result;

public class ResultUtil {
	
	public ResultUtil(){}
	
	public ResultUtil(int code, String msg){}
	
	public static Result<Object>  success(Object T) {
		return new Result<Object>(200, "success", T);
	}

	public static Result<Object> fail(Object T) {
		return new Result<Object>(500, "fail", T);
	}
	

}
