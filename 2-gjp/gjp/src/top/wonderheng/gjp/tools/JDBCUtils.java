package top.wonderheng.gjp.tools;

/*
 * 获取数据库连接的工具类
 * 实现连接池，dbcp连接池
 */
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	//创建basicsource对象
	private static BasicDataSource datasource = new BasicDataSource();
	//静态代码块，实现必要参数设置
	static {
		//读取驱动文件
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		//连接数据库
		datasource.setUrl("jdbc:mysql://localhost:3306/gjp");
		//数据库账户名
		datasource.setUsername("root");
		//数据库密码
		datasource.setPassword("123");
		//最大激活
		datasource.setMaxActive(10);
		//最大空闲
		datasource.setMaxIdle(5);
		//最小空闲
		datasource.setMinIdle(2);
		//初始化
		datasource.setInitialSize(10);
	}
	
	public static DataSource getDataSource () {
		return datasource;
	}
}
