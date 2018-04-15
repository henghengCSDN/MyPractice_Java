package top.wonderheng.bms.dao;
/*
 * ʵ�ֶ����ݱ�BMS_book���ݵ���ɾ�Ĳ�
 * ʹ��dbutils���������
 * ���Ա����QueryRunner����,ָ������Դ
 */

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import top.wonderheng.bms.domain.Book;
import top.wonderheng.bms.tools.JDBCUtils;

public class BookDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/*
	 * ���巽����ʵ�����ͼ��Ĺ���
	 * ��service����ã�����Book����
	 * ��ͼ�����͵�������ӵ����ݿ�
	 */
	public void addBook (Book b) {
		//���ͼ���SQL���
		String sql = "INSERT INTO bms_book (bname,bmoney,createtime,description) VALUES (?,?,?,?)";
		//�����������飬�洢5��ռλ��������
		//ʵ����Դ�����ݹ�����b
		Object [] params = {b.getBname(),b.getBmoney(),b.getCreatetime(),b.getDescription()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ͼ��ʧ�ܣ�");
		}
	}
	
	/*
	 * ���巽�����޸�ͼ����Ϣ
	 * �����µ�ͼ���������ӵ����ݿ�
	 */
	public void editBook(Book b) {
		//�༭ͼ���SQL���
		String sql = "UPDATE bms_book SET bname=?,bmoney=?,createtime=?,description=? WHERE bid=?";
		try {
			Object [] params = {b.getBname(),b.getBmoney(),b.getCreatetime(),b.getDescription(),b.getBid()};
			qr.update(sql,params);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("�༭ͼ��ʧ�ܣ�");
		}
	}
	
	/*
	 * ���巽������ѯ���ݿ⣬��ȡͼ������
	 * ������service�����
	 * �������������������ͼ�����ݣ��洢��Bean���󣬴洢�ڼ�����
	 */
	public List<Book> select (String startDate,String endDate) {
		try {
			//��ѯ����ͼ���SQL���
			String sql = "SELECT * FROM bms_book WHERE createtime BETWEEN ? AND ?";
			Object [] params = {startDate,endDate};
			//ʹ��qr�������query�����������BleanListHander
			List<Book> list = qr.query(sql, new BeanListHandler<>(Book.class),params);
			return list;
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("������ѯͼ������ʧ�ܣ�");
		}
	}
	
	/*
	 * ���巽������ѯ���ݿ⣬��ȡͼ������
	 * ������service�����
	 * ������������е�ͼ�����ݣ��洢��Bean���󣬴洢�ڼ�����
	 */
	public List<Book> selectAll() {
		try {
			//��ѯ����ͼ���SQL���
			String sql = "SELECT * FROM bms_book";
			
			//ʹ��qr�������query�����������BleanListHander
			List<Book> list = qr.query(sql, new BeanListHandler<>(Book.class));
			return list;
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("��ѯ����ͼ������ʧ�ܣ�");
		}
	}
	
	/*
	 * ���巽����ɾ��ͼ��
	 * ������service�����
	 */
	public void deleteBook(int bid) {
		String sql = "DELETE FROM bms_book WHERE bid=? ";
		try {
			qr.update(sql,bid);
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("ɾ��ͼ��ʧ�ܣ�������ͼ��IDδ�ҵ���");
		}
	}
}
