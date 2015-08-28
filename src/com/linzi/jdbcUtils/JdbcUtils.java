package com.linzi.jdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 用单例模式来写一个静态的工具类，可以从c3p0连接池中获得connetion 对象
 * 从默认的配置文件中获得参数，不要忘了加入配置文件
 * @author PCPC
 *
 */

public class JdbcUtils {
	//饿汉式，单例
	private static ComboPooledDataSource cpds=new ComboPooledDataSource();
	/**
	 * 用单例模式来写一个静态的类，来从连接池中获得connetion
	 * @return
	 * @throws SQLException
	 */
	public static   Connection getConnection() throws SQLException{
	return	cpds.getConnection();
	}

}
