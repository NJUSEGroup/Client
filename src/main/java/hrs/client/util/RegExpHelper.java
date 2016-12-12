package hrs.client.util;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;

public class RegExpHelper {
	/**
	 * 
	 * @Title: matchUsernameAndPWD
	 * @Description: 要求字符串含有字母or数字，并且在6位及以上
	 * @param @param str
	 * @param @return   
	 * @return boolean   
	 * @throws
	 */
	public static boolean matchUsernameAndPWD(String str){
		return str.matches("^[0-9A-Za-z]{6,}$");
	}
	/**
	 * 
	 * @Title: matchCHNNumAndLetter
	 * @Description: 要求字符串含有字母or数字or中文，且至少1位
	 * @param @param str
	 * @param @return   
	 * @return boolean   
	 * @throws
	 */
	public static boolean matchCHNNumAndLetter(String str){
		return str.matches("^[a-zA-Z0-9\u4e00-\u9fa5]+$");
		
	}
	/**
	 * 
	 * @Title: matchOnlyNum
	 * @Description: 要求字符串只含数字且至少1位
	 * @param @param str
	 * @param @return   
	 * @return boolean   
	 * @throws
	 */
	public static boolean matchOnlyNum(String str){
		return str.matches("^[0-9]+");
	}
	
	public static void main(String[] args) {
		System.out.println(RegExpHelper.matchUsernameAndPWD("12siWSsa"));
		System.out.println(RegExpHelper.matchOnlyNum("123s"));
		System.out.println(RegExpHelper.matchOnlyNum("0.23333"));
	}
}
