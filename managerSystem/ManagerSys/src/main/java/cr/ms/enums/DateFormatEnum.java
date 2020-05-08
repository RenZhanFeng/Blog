package cr.ms.enums;


/**
 * 日期格式枚举类
 * @author Clown
 *
 */
public enum DateFormatEnum {
	
	DATE_FORMAT_YYYY(700001, "yyyy"),//日期格式，年份，例如：2004，2008
	DATE_FORMAT_YYYYMM(700002, "yyyyMM"),//日期格式，年份和月份，例如：200707，200808
	DATE_FORMAT_YYMMDD (700003, "yyMMdd"),//日期格式，年月日，例如：050630，080808 
	DATE_FORMAT_YY_MM_DD(700004, "yy-MM-dd"),//日期格式，年月日，用横杠分开，例如：06- 12-25，08-08-08 
	DATE_FORMAT_YYYYMMDD(700005, "yyyyMMdd"),//日期格式，年月日，例如：20050630，20080808 
	DATE_FORMAT_YYYY_MM_DD(700006, "yyyy-MM-dd"),//日期格式，年月日，用横杠分开，例如：2006-12-25，2008-08-08 
	DATE_FORMAT_POINTYYYYMMDD(700007, "yyyy.MM.dd"),//日期格式，年月日，例如：2016.10.05
	DATE_TIME_FORMAT_YYYY年MM月DD日(700008, "yyyy年MM月dd日"),//日期格式，年月日，例如：2016年10月05日
	DATE_FORMAT_YYYYMMDDHHmm(700009, "yyyyMMddHHmm"),//日期格式，年月日时分，例如：200506301210，200808081210
	DATE_TIME_FORMAT_YYYYMMDD_HH_MI(700010, "yyyyMMdd HH:mm"),//日期格式，年月日时分，例如：20001230 12:00，20080808 20:08 
	DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI(700011, "yyyy-MM-dd HH:mm"),//日期格式，年月日时分，例如：2000-12-30 12:00，2008-08-08 20:08
	DATE_TIME_FORMAT_YYYYMMDDHHMISS(700012, "yyyyMMddHHmmss"),//日期格式，年月日时分秒，例如：20001230120000，20080808200808
	DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS(700013, "yyyy-MM-dd HH:mm:ss"),//日期格式，年月日时分秒，年月日用横杠分开，时分秒用冒号分开  例如：2005-05-10 23：20：00，2008-08-08 20:08:08 
	DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS  (700014, "yyyyMMddHHmmssSSS"),//日期格式，年月日时分秒毫秒，例如：20001230120000123，20080808200808456
	DATE_FORMAT_MMDDHHMI  (700015, "MM-dd HH:mm"),//日期格式，月日时分，例如：10-05 12:00
	;
	
	private int code;
	private String message;
	
	
	DateFormatEnum(int code, String msg) {
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
