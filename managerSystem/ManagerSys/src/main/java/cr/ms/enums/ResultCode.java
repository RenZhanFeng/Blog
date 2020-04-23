package cr.ms.enums;

public enum ResultCode {
	
	//设置枚举值，注意与后面的field字段对应
	
	  SUCCESS(1,"成功"), WARNING(0,"警告"), ERROR(-1,"报错");
	  
	  private int code; 
	  private String message;
	 
	  ResultCode(int code, String msg){
		  this.code = code;
		  this.message = msg;
	  }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
	  
    
	
}
