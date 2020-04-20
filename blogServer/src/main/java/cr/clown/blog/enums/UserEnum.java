package cr.clown.blog.enums;

public enum UserEnum {

	USER_NOT_EXITS(101, "用户不存在"),
	USER_ID_NOT_NULL(102, "用户ID不能为空"),
	USERNAME_NOT_NUll(103, "用户名不能为空"),
	USER_INFO_INCOMPLETE(104, "用户信息不完整"),
	USER_INFO_NOT_NUll(105, "用户信息不能为空"),
	USERNAME_OR_PASSWORD_REEOR(106, "用户或密码错误"),
	LOGIN_SUCCESS(107, "登录成功"),
	DEL_USER_INFO_FAIl(122, "删除用户信息失败"),
	;

	private int code;
    private String message;
    
	private UserEnum(int code, String msg) {
		this.code = code;
		this.message = msg;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	/**
	 * 根据code获取message
	 * @param code
	 * @return
	 */
	public static String getMessage(int code) {
		//通过enum.values()获取所有枚举值
		for (UserEnum uEnum : UserEnum.values()) {
			//通过enum.get获取字段值
			if (uEnum.getCode() == code) {
				return uEnum.message;
			}
		}
		return null;
	}
	
	/**
	 * 根据code获取UserEnum
	 * @param code
	 * @return
	 */
	public static UserEnum getUserEnum(int code) {
		//通过enum.values()获取所有枚举值
		for (UserEnum uEnum : UserEnum.values()) {
			//通过enum.get获取字段值
			if (uEnum.getCode() == code) {
				return uEnum;
			}
		}
		return null;
	}
	
}
