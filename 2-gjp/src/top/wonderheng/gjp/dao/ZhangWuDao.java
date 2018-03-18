package top.wonderheng.gjp.dao;
/*
 * 实现对数据表gjp_zhangwu数据的增删改查
 * 使用dbutils工具类完成
 * 类成员创建QueryRunner对象,指定数据源
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
	 * 定义方法，实现删除账务
	 * 有service层调用，传递zhangwu对象
	 * 将数据更新到数据库
	 */
	public void deleteZhangWu(int zwid) {
		String sql = "DELETE FROM gjp_zhangwu WHERE zwid=? ";
		try {
			qr.update(sql,zwid);
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("删除账务失败！");
		}
	}
	
	/*
	 * 定义方法，实现编辑账务功能
	 * 由service层调用，传递zhangwu对象
	 * 将新的账务信息更新到数据库
	 */
	public void editZhangWu(ZhangWu zw) {
		//编辑账务的SQL语句
		String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhangHu=?,createtime=?,description=? WHERE zwid=?";
		try {
			Object [] params = {zw.getFlname(),zw.getMoney(),zw.getZhangHu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
			qr.update(sql,params);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("编辑账务失败！");
		}
	}

	/*
	 * 定义方法，实现添加账务的功能
	 * 由service层调用，传递zhangwu对象
	 * 将账务类型的数据添加到数据库
	 */
	public void addZhangWu (ZhangWu zw) {
		//添加账务的SQL语句
		String sql = "INSERT INTO gjp_zhangwu (flname,money,zhangHu,createtime,description) VALUES (?,?,?,?,?)";
		try {
			//创建对象数组，存储5个占位符的数据
			//实参来源，传递过来的zw
			Object [] params = {zw.getFlname(),zw.getMoney(),zw.getZhangHu(),zw.getCreatetime(),zw.getDescription()};
			//调用对象qr中的方法update添加账务
			qr.update(sql,params);
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("添加账务失败！");
		}
		
	}
	
	
	/*
	 * 定义方法，查询数据库，获取账务数据
	 * 方法由service层调用
	 * 结果集，将符合条件的账务数据，存储到Bean对象，存储于集合中
	 */
	public List<ZhangWu> select (String startDate,String endDate) {
		try {
			//查询所有账务的SQL语句
			String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
			Object [] params = {startDate,endDate};
			//使用qr对象调用query方法，结果集BleanListHander
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class),params);
			return list;
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("条件查询账务数据失败！");
		}
	}
	
	/*
	 * 定义方法，查询数据库，获取账务数据
	 * 方法由service层调用
	 * 结果集，将所有的账务数据，存储到Bean对象，存储于集合中
	 */
	public List<ZhangWu> selectAll() {
		try {
			//查询所有账务的SQL语句
			String sql = "SELECT * FROM gjp_zhangwu";
			
			//使用qr对象调用query方法，结果集BleanListHander
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
			return list;
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("查询所有账务数据失败！");
		}
	}



}
