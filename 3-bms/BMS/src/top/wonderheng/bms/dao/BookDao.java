package top.wonderheng.bms.dao;
/*
 * 实现对数据表BMS_book数据的增删改查
 * 使用dbutils工具类完成
 * 类成员创建QueryRunner对象,指定数据源
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
	 * 定义方法，实现添加图书的功能
	 * 由service层调用，传递Book对象
	 * 将图书类型的数据添加到数据库
	 */
	public void addBook (Book b) {
		//添加图书的SQL语句
		String sql = "INSERT INTO bms_book (bname,bmoney,createtime,description) VALUES (?,?,?,?)";
		//创建对象数组，存储5个占位符的数据
		//实参来源，传递过来的b
		Object [] params = {b.getBname(),b.getBmoney(),b.getCreatetime(),b.getDescription()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加图书失败！");
		}
	}
	
	/*
	 * 定义方法，修改图书信息
	 * 将更新的图书的数据添加到数据库
	 */
	public void editBook(Book b) {
		//编辑图书的SQL语句
		String sql = "UPDATE bms_book SET bname=?,bmoney=?,createtime=?,description=? WHERE bid=?";
		try {
			Object [] params = {b.getBname(),b.getBmoney(),b.getCreatetime(),b.getDescription(),b.getBid()};
			qr.update(sql,params);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("编辑图书失败！");
		}
	}
	
	/*
	 * 定义方法，查询数据库，获取图书数据
	 * 方法由service层调用
	 * 结果集，将符合条件的图书数据，存储到Bean对象，存储于集合中
	 */
	public List<Book> select (String startDate,String endDate) {
		try {
			//查询所有图书的SQL语句
			String sql = "SELECT * FROM bms_book WHERE createtime BETWEEN ? AND ?";
			Object [] params = {startDate,endDate};
			//使用qr对象调用query方法，结果集BleanListHander
			List<Book> list = qr.query(sql, new BeanListHandler<>(Book.class),params);
			return list;
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("条件查询图书数据失败！");
		}
	}
	
	/*
	 * 定义方法，查询数据库，获取图书数据
	 * 方法由service层调用
	 * 结果集，将所有的图书数据，存储到Bean对象，存储于集合中
	 */
	public List<Book> selectAll() {
		try {
			//查询所有图书的SQL语句
			String sql = "SELECT * FROM bms_book";
			
			//使用qr对象调用query方法，结果集BleanListHander
			List<Book> list = qr.query(sql, new BeanListHandler<>(Book.class));
			return list;
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("查询所有图书数据失败！");
		}
	}
	
	/*
	 * 定义方法，删除图书
	 * 方法由service层调用
	 */
	public void deleteBook(int bid) {
		String sql = "DELETE FROM bms_book WHERE bid=? ";
		try {
			qr.update(sql,bid);
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("删除图书失败！可能是图书ID未找到。");
		}
	}
}
