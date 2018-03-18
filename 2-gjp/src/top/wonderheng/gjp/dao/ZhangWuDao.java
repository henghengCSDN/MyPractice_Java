package top.wonderheng.gjp.dao;
/*
 * ʵ�ֶ����ݱ�gjp_zhangwu���ݵ���ɾ�Ĳ�
 * ʹ��dbutils���������
 * ���Ա����QueryRunner����,ָ������Դ
 */


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import top.wonderheng.gjp.domain.ZhangWu;
import top.wonderheng.gjp.tools.JDBCUtils;

public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	/*
	 * ���巽����ʵ��ɾ������
	 * ��service����ã�����zhangwu����
	 * �����ݸ��µ����ݿ�
	 */
	public void deleteZhangWu(int zwid) {
		String sql = "DELETE FROM gjp_zhangwu WHERE zwid=? ";
		try {
			qr.update(sql,zwid);
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("ɾ������ʧ�ܣ�");
		}
	}
	
	/*
	 * ���巽����ʵ�ֱ༭������
	 * ��service����ã�����zhangwu����
	 * ���µ�������Ϣ���µ����ݿ�
	 */
	public void editZhangWu(ZhangWu zw) {
		//�༭�����SQL���
		String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhangHu=?,createtime=?,description=? WHERE zwid=?";
		try {
			Object [] params = {zw.getFlname(),zw.getMoney(),zw.getZhangHu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
			qr.update(sql,params);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("�༭����ʧ�ܣ�");
		}
	}

	/*
	 * ���巽����ʵ���������Ĺ���
	 * ��service����ã�����zhangwu����
	 * ���������͵�������ӵ����ݿ�
	 */
	public void addZhangWu (ZhangWu zw) {
		//��������SQL���
		String sql = "INSERT INTO gjp_zhangwu (flname,money,zhangHu,createtime,description) VALUES (?,?,?,?,?)";
		try {
			//�����������飬�洢5��ռλ��������
			//ʵ����Դ�����ݹ�����zw
			Object [] params = {zw.getFlname(),zw.getMoney(),zw.getZhangHu(),zw.getCreatetime(),zw.getDescription()};
			//���ö���qr�еķ���update�������
			qr.update(sql,params);
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("�������ʧ�ܣ�");
		}
		
	}
	
	
	/*
	 * ���巽������ѯ���ݿ⣬��ȡ��������
	 * ������service�����
	 * ��������������������������ݣ��洢��Bean���󣬴洢�ڼ�����
	 */
	public List<ZhangWu> select (String startDate,String endDate) {
		try {
			//��ѯ���������SQL���
			String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
			Object [] params = {startDate,endDate};
			//ʹ��qr�������query�����������BleanListHander
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class),params);
			return list;
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("������ѯ��������ʧ�ܣ�");
		}
	}
	
	/*
	 * ���巽������ѯ���ݿ⣬��ȡ��������
	 * ������service�����
	 * ������������е��������ݣ��洢��Bean���󣬴洢�ڼ�����
	 */
	public List<ZhangWu> selectAll() {
		try {
			//��ѯ���������SQL���
			String sql = "SELECT * FROM gjp_zhangwu";
			
			//ʹ��qr�������query�����������BleanListHander
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
			return list;
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("��ѯ������������ʧ�ܣ�");
		}
	}



}
