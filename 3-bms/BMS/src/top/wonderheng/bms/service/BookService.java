package top.wonderheng.bms.service;
/*
 * 业务层类
 * 接收上一层（控制层controller）的数据
 * 经过计算，传递给dao层，实现对数据库的操作
 * 类成员位置创建dao层的对象，需要调用dao层中的类
 */

import java.util.List;

import top.wonderheng.bms.dao.BookDao;
import top.wonderheng.bms.domain.Book;

public class BookService {
	private BookDao dao = new BookDao();
	/*
	 * 定义方法，实现添加图书功能
	 * 接收service层的参数，
	 * 调用Bookdao层的方法addBook()
	 */
	public void addBook (Book b) {
		dao.addBook(b);
	}
	
	/*
	 * 定义方法，修改图书信息
	 * 调用dao层的方法
	 */
	public void editBook(Book b) {
		dao.editBook(b);
	}
	
	/*
	 * 定义方法，实现条件查询
	 * 方法由controller层调用，传递两个字符串
	 * 调用dao层的方法，传递两个字符串，获取结果集
	 */
	public List<Book> select (String startDate,String endDate) {
		return dao.select(startDate, endDate);
	}
	
	/*
	 * 定义方法，实现查询所有图书数据
	 * 方法由控制层controller调用,调用dao层的方法
	 */
	public List<Book> selectAll() {
		
		return dao.selectAll();
	}
	
	/*
	 * 删除图书，由controller调用
	 * 调用dao层方法
	 */
	public void deleteBook(int bid) {
		dao.deleteBook(bid);
	}
}
