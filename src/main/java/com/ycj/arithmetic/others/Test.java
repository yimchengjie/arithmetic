package com.ycj.arithmetic.others;


import java.nio.charset.StandardCharsets;
import org.springframework.util.DigestUtils;

/**
 * Test
 *
 * @author yanchengjie
 * @version : Test.java, v 0.1 2022/9/3 12:08 yanchengjie Exp$
 */
public class Test {

	private static final String SECRET_KEY = "secret";

	public static void main(String[] args) {
		//1.执行命令获取UUID的值
		String uuid = "00000000-0000-0000-0000-AC1F6B48DAAC";
		//2.前后拼接secret
		String key = SECRET_KEY.concat(uuid).concat(SECRET_KEY);
		//3.生成md5
		String md5 = DigestUtils.md5DigestAsHex(key.getBytes(StandardCharsets.UTF_8));
		System.out.println(md5);
	}

}
