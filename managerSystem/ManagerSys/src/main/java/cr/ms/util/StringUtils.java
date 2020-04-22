package cr.ms.util;

import java.util.Random;

/**
 * 随机字符串生成类
 * @author Clwon
 *
 */
public class StringUtils {

	/**
	 * 随机生成指定长度的字符串
	 * @param length 生成的字符串长度
	 * @return 指定长度字符串
	 */
	public static String getRandomString(int length) {
		//创建基本字符串
		String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		//创建随机数对象Random
		Random random = new Random();
		//创建StringBuffer对象
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			//随机生成小于base字符串长度的数值
			int number = random.nextInt(base.length());
			//添加生成的随机字符到sb对象中
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
}
