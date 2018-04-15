package top.wonderheng.bms.view;
/*
 * ��ͼ��
 * �û���������
 * �����ݴ��ݸ�controller��
 * ��Աλ�ô���controller����
 */

import java.util.List;
import java.util.Scanner;

import top.wonderheng.bms.controller.BookController;
import top.wonderheng.bms.domain.Book;

public class MainView {
	private BookController controller = new BookController();
	//ʵ�ֽ���Ч���������û���������ݣ��������ݵ��ò�ͬ�Ĺ��ܷ���
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("---------------ͼ�����ϵͳ---------------");
			System.out.println("1.���ͼ�顡2.�༭ͼ�顡3.��ѯͼ�顡4.ɾ��ͼ�顡5.�˳�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]:");
			// �����û�ѡ��
			int choose = sc.nextInt();
			switch (choose) {
			// �������ͼ��ķ���
			case 1:
				addBook();
				break;
			// ���ñ༭ͼ��ķ���
			case 2:
				editBook();
				break;
			// ���ò�ѯͼ��ķ���
			case 3:
				selectBook();
				break;
			// ����ɾ��ͼ��ķ���
			case 4:
				deleteBook();
				break;
			// �˳�ϵͳ
			case 5:
				System.out.println("�ѳɹ��˳�ϵͳ��");
				System.exit(0);
			default:
				System.out.println("�����������������룡");
			}
		}
	}
	
	/*
	 * ���巽�������ͼ������
	 * ����controller��ķ���
	 */
	public void addBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ǰΪ���ͼ�鹦�ܣ��밴Ҫ����������");
		System.out.print("����������ͼ������ƣ�");
		String bname = sc.nextLine();
		System.out.println("����������ͼ��Ľ�");
		double bmoney = sc.nextDouble();
		sc.nextLine();
		System.out.println("���������ڣ���ʽΪXXXX-XX-XX����");
		String createtime = sc.nextLine();
		System.out.println("����������ͼ��ļ���������");
		String description = sc.nextLine();
		
		//�������ݣ�����controller��ķ��������ݲ���
		//�û��������в�������װ��Book����
		Book b = new Book(0, bmoney, bname, createtime, description);
		controller.addBook(b);
		System.out.println("��ϲ�����ͼ��ɹ���");
	}
	
	/*
	 * ���巽�����޸�ͼ����Ϣ
	 * ����controller��ķ���
	 */
	public void editBook() {
		Scanner sc = new Scanner (System.in);
		System.out.println("��ǰΪ�༭ͼ��ģʽ���밴Ҫ����������");
		System.out.print("������Ҫ�༭ͼ���ID��");
		int bid = sc.nextInt();
		sc.nextLine();
		System.out.print("������Ҫ�༭ͼ��ķ������ƣ�");
		String bname = sc.nextLine();
		System.out.print("������Ҫ�༭ͼ��Ľ�");
		double bmoney = sc.nextDouble();
		sc.nextLine();
		System.out.print("���������ڣ���ʽΪ XXXX-XX-XX����");
		String createtime = sc.nextLine();
		System.out.print("������Ҫ�༭ͼ��ļ���������");
		String description = sc.nextLine();
		
		//�������ݣ�����controller��ķ��������ݲ���
		//�û��������в�������װ��Book����
		Book b = new Book(bid, bmoney, bname,createtime, description);
		controller.editBook(b);
		System.out.println("�༭ͼ��ɹ���");
	}
	
	/*
	 * ���巽��selectBook() 
	 * ��ʾ��ѯ��ʽ 1.��ѯ���� 2.������ѯ
	 */
	public void selectBook() {
		System.out.println("1.��ѯ����    2.������ѯ");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// ���ò�ѯ����ͼ�����ݵķ���
			selectAll();
			break;
		case 2:
			// ����������ѯͼ�����ݵķ���
			select();
			break;
		default:
			System.out.println("��������");
			return;
		}
	}
	
	/*
	 * ���巽����ʵ�ֲ�ѯ����ͼ������
	 */
	public void selectAll() {
		List<Book> list = controller.selectAll();
		if (list.size() != 0) {
			print(list);
		}else {
			System.out.println("��Ǹ��δ��ѯ�������");
		}
	}

	/*
	 * ���巽����ʵ�ְ�������ѯͼ������ �ṩ�û��������ڣ���ʼ���ںͽ�������
	 * ���ݵ�controller�� ����controller�ķ���������2�����ڲ���
	 * ��ȡ����ӡ���
	 */
	public void select() {
		System.out.println("������ѯ���밴��ʾ�������ڣ����ڸ�ʽΪ��XXXX-XX-XX");
		Scanner sc = new Scanner(System.in);
		System.out.print("�����뿪ʼ���ڣ�");
		String startDate = sc.nextLine();
		System.out.print("�������ֹ���ڣ�");
		String endDate = sc.nextLine();

		// ����controller��ķ���,���������ַ�������ȡ�����
		List<Book> list = controller.select(startDate, endDate);
		if (list.size() != 0) {
			print(list);
		}else {
			System.out.println("��Ǹ��δ��ѯ���������µĽ����");
		}
	}
	
	public void deleteBook() {
		System.out.println("��ǰΪɾ��ͼ��ģʽ�������ɾ����");
		System.out.println("�������ɾ��ͼ���ID��");
		Scanner sc = new Scanner(System.in);
		int bid = sc.nextInt();
		controller.deleteBook(bid);
		System.out.println("ɾ��ͼ��ɹ���");
	}

	public void print(List<Book> list) {
		// ��ӡ��ͷ
		System.out.println("ID\t���\t\t���\t\tʱ��\t\t����");
		// �������ϣ�������
		for (Book b : list) {
			System.out.println(b.getBid() + "\t" + b.getBname() + "\t\t" + b.getBmoney()
					+ "\t\t" + b.getCreatetime() + "\t" + b.getDescription());
		}
	}
	
}





