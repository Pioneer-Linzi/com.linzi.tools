package com.linzi.commonUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 我的小小工具类，暂时有 1. 获得一个32位长的随机的字符串 2.toBean 给一个map 给你返回一个封装好的类
 * 需要两个包：commonUtils-logging,commonUtils-beanutils
 * @author PCPC
 * 
 */

public class CommonUtils {
	/**
	 * 给一个map 我给你封装成你想要的类
	 * 
	 * @param map
	 * @param clazz
	 * @return
	 */

	public static <T> T toBean(Map map,Class<T> clazz) {
		try {
			T bean = clazz.newInstance();
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获得一个不重得的32位的字符串
	 * 
	 * @return
	 */
	public static String uuid() {

		return UUID.randomUUID().toString().replace("-", "").toUpperCase();

	}

}
