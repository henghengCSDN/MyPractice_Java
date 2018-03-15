package top.wonderheng.gjp.tools;

/*
 * ��ȡ���ݿ����ӵĹ�����
 * ʵ�����ӳأ�dbcp���ӳ�
 */
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	//����basicsource����
	private static BasicDataSource datasource = new BasicDataSource();
	//��̬����飬ʵ�ֱ�Ҫ��������
	static {
		//��ȡ�����ļ�
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		//�������ݿ�
		datasource.setUrl("jdbc:mysql://localhost:3306/gjp");
		//���ݿ��˻���
		datasource.setUsername("root");
		//���ݿ�����
		datasource.setPassword("123");
		//��󼤻�
		datasource.setMaxActive(10);
		//������
		datasource.setMaxIdle(5);
		//��С����
		datasource.setMinIdle(2);
		//��ʼ��
		datasource.setInitialSize(10);
	}
	
	public static DataSource getDataSource () {
		return datasource;
	}
}
