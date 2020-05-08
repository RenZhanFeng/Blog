package cr.ms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cr.ms.enums.DateFormatEnum;

public class DateUtils {
	 	
	private static SimpleDateFormat sdf =  new SimpleDateFormat(DateFormatEnum.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS.getMessage());
	
	/**
	 * @Description 获取当前时间字符串
	 * @return 
	 */
	public static String currenDate() {
		//获取当前的日期
		Date date = new Date();
		//设置时间格式
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //2000-01-01 11:01:11
		//获取String类型的时间
		String currentDate = sdf.format(date);
		return currentDate;
	}
	
	/**
	 * @Description 获取指定日期的前一天
	 * @param specifieDay //指定日期
	 * @return 格式化后的字符串
	 * @throws ParseException 
	 */
	public static String getSpecifiedDayBefore(String specifieDay) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		Date date = new SimpleDateFormat("yy-MM-dd").parse(specifieDay);
		calendar.setTime(date);
		int day = calendar.get(Calendar.DATE);
		calendar.set(Calendar.DATE, day-1);
		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
		return dayBefore;
	}
	
	/**
	 * strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日  HH时mm分ss秒，
	 * strTime的时间格式必须要与formatType的时间格式相同
	 * @Description  string类型转换为date类型
	 * @param strTime 字符串类型时间
	 * @return
	 * @throws ParseException 
	 */
	public static Date stringToDate(String strTime) throws ParseException {
//		Date date = null;
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		try {
//			date = sdf.parse(strTime);
//			return date;
//		} catch (ParseException e) {		
//			e.printStackTrace();
//		}
		return sdf.parse(strTime);
	}
	
	/**
	 * @Description 日期转换为字符串
	 * @param date 日期
	 * @return
	 */
	public static String DateToString(Date date) {
		return sdf.format(date);
	}

}
