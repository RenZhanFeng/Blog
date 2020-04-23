package cr.ms.util;

import cr.ms.result.Result;

public class ResultUtil {
	
	
	public static Result<Object>  success(Object T) {
		return new Result<Object>(200, "success", T);
	}
	
	public static Result<Object> fail(Object T) {
		return new Result<Object>(500, "fail", T);
	}
}
