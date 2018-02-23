package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils1 {
	//4个必要参数
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	//2个策略参数
	private static int initialSize;
	private static int maxActive;
	//声明BasicDataSource对象,赋值为null
	private static BasicDataSource ds=null;
	//静态块中完成读取6个参数的操作
	//创建BasicDataSource对象的操作
	//给BasicDataSource对象设置6个参数的操作
	static{
		try {
			Properties cfg=new Properties();
			InputStream inStream= 
					DBUtils1.class.getClassLoader()
					.getResourceAsStream("db.properties");
			cfg.load(inStream);
			driver=cfg.getProperty("jdbc.driver");
			url=cfg.getProperty("jdbc.url");
			username=cfg.getProperty("jdbc.username");
			password=cfg.getProperty("jdbc.password");
			initialSize=
				Integer
				.parseInt(cfg.getProperty("initialSize"));
			maxActive=
					Integer
					.parseInt(cfg.getProperty("maxActive"));
			//创建BasicDataSource对象
			ds=new BasicDataSource();
			//设置6个属性
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setInitialSize(initialSize);
			ds.setMaxActive(maxActive);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//获取连接池中connection对象的方法
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return conn;
	}
	
	//归还连接池连接对象的方法
	public static void closeConnection(Connection conn){
		try {
			if (conn!=null) {
				conn.setAutoCommit(true);
				//此处close是归还
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//事务回滚的方法
	public static void rollback(Connection conn){
		if (conn!=null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
}




