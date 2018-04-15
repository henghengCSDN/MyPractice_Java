package top.wonderheng.bms.service;
/*
 * ҵ�����
 * ������һ�㣨���Ʋ�controller��������
 * �������㣬���ݸ�dao�㣬ʵ�ֶ����ݿ�Ĳ���
 * ���Աλ�ô���dao��Ķ�����Ҫ����dao���е���
 */

import java.util.List;

import top.wonderheng.bms.dao.BookDao;
import top.wonderheng.bms.domain.Book;

public class BookService {
	private BookDao dao = new BookDao();
	/*
	 * ���巽����ʵ�����ͼ�鹦��
	 * ����service��Ĳ�����
	 * ����Bookdao��ķ���addBook()
	 */
	public void addBook (Book b) {
		dao.addBook(b);
	}
	
	/*
	 * ���巽�����޸�ͼ����Ϣ
	 * ����dao��ķ���
	 */
	public void editBook(Book b) {
		dao.editBook(b);
	}
	
	/*
	 * ���巽����ʵ��������ѯ
	 * ������controller����ã����������ַ���
	 * ����dao��ķ��������������ַ�������ȡ�����
	 */
	public List<Book> select (String startDate,String endDate) {
		return dao.select(startDate, endDate);
	}
	
	/*
	 * ���巽����ʵ�ֲ�ѯ����ͼ������
	 * �����ɿ��Ʋ�controller����,����dao��ķ���
	 */
	public List<Book> selectAll() {
		
		return dao.selectAll();
	}
	
	/*
	 * ɾ��ͼ�飬��controller����
	 * ����dao�㷽��
	 */
	public void deleteBook(int bid) {
		dao.deleteBook(bid);
	}
}
