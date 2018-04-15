package top.wonderheng.bms.controller;
/*
 * 控制器层
 * 接收视图层view的数据，传递给服务层sercice
 * 成员位置创建sercice对象
 */

import java.util.List;

import top.wonderheng.bms.domain.Book;
import top.wonderheng.bms.service.BookService;

public class BookController {
	private BookService service = new BookService();
	/*
	 * 定义方法，实现添加图书功能
	 * 接收视图层的参数，
	 * 调用service层的方法
	 */
	public void addBook (Book b) {
		service.addBook(b);
	}
	
	/*
	 * 定义方法，修改图书信息
	 * 调用service层的方法
	 */
	public void editBook(Book b) {
		service.editBook(b);
	}
	
	/*
	 * 定义方法，实现条件查询
	 * 方法由视图层调用，传递两个字符串
	 * 调用service层的方法，传递两个字符串，获取结果集
	 */
	public List<Book> select (String startDate,String endDate) {
		return service.select(startDate, endDate);
	}
	
	/*
	 * 控制层调用方法，实现查询所有账务数据
	 * 方法由视图层调用，方法调用service层
	 */
	public List<Book> selectAll() {
		return service.selectAll();
	}
	
	/*
	 * 删除图书，由view层调用
	 * 调用controller层方法
	 */
	public void deleteBook(int bid) {
		service.deleteBook(bid);
	}
}
