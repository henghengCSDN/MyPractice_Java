package top.wonderheng.bms.controller;
/*
 * ��������
 * ������ͼ��view�����ݣ����ݸ������sercice
 * ��Աλ�ô���sercice����
 */

import java.util.List;

import top.wonderheng.bms.domain.Book;
import top.wonderheng.bms.service.BookService;

public class BookController {
	private BookService service = new BookService();
	/*
	 * ���巽����ʵ�����ͼ�鹦��
	 * ������ͼ��Ĳ�����
	 * ����service��ķ���
	 */
	public void addBook (Book b) {
		service.addBook(b);
	}
	
	/*
	 * ���巽�����޸�ͼ����Ϣ
	 * ����service��ķ���
	 */
	public void editBook(Book b) {
		service.editBook(b);
	}
	
	/*
	 * ���巽����ʵ��������ѯ
	 * ��������ͼ����ã����������ַ���
	 * ����service��ķ��������������ַ�������ȡ�����
	 */
	public List<Book> select (String startDate,String endDate) {
		return service.select(startDate, endDate);
	}
	
	/*
	 * ���Ʋ���÷�����ʵ�ֲ�ѯ������������
	 * ��������ͼ����ã���������service��
	 */
	public List<Book> selectAll() {
		return service.selectAll();
	}
	
	/*
	 * ɾ��ͼ�飬��view�����
	 * ����controller�㷽��
	 */
	public void deleteBook(int bid) {
		service.deleteBook(bid);
	}
}
