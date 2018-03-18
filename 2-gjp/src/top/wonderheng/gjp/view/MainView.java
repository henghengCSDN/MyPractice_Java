package top.wonderheng.gjp.view;
/*
 * ��ͼ��
 * �û������Ľ���
 * �����ݴ��ݸ�controller��
 * ��Աλ�ô���controller����
 */

import java.util.List;
import java.util.Scanner;

import top.wonderheng.gjp.controller.ZhangWuController;
import top.wonderheng.gjp.domain.ZhangWu;

public class MainView {
	private ZhangWuController controller = new ZhangWuController();

	/*
	 * ʵ�ֽ���Ч�� �����û���������ݣ��������ݵ��ò�ͬ�Ĺ��ܷ���
	 */
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("---------------�ܼ��ż�ͥ�������---------------");
			System.out.println("1.�������2.�༭����3.ɾ������4.��ѯ����5.�˳�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]:");
			// �����û�ѡ��
			int choose = sc.nextInt();
			switch (choose) {
			// �����������ķ���
			case 1:
				addZhangWu ();
				break;
			// ���ñ༭����ķ���
			case 2:
				editZhangWu();
				break;
			// ����ɾ������ķ���
			case 3:
				deleteZhangWu();
				break;
			// ���ò�ѯ����ķ���
			case 4:
				selectZhangWu();
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
	 * ���巽����ʵ������ɾ��
	 * 
	 */
	private void deleteZhangWu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ǰΪɾ������ģʽ�������ǵ�ǰ���ݿ��е���Ϣ��");
		selectAll();
		System.out.println("������Ҫɾ��������ID:");
		int zwid = sc.nextInt();
		sc.nextLine();
		System.out.print("��ȷ��Ҫɾ������������Ϣ�� ȷ��������Y(��y),ȡ���������Y(��y)����������ַ���");
		String str = sc.nextLine();
		if(str.equals("Y")||str.equals("y")) {
			//����controller��ķ���������ID��
			controller.deleteZhangWu(zwid);
			System.out.println("ɾ������ɹ���");
		}else {
			System.out.println("��ȡ��ɾ����");
		}
	}

	/*
	 * ���巽�����༭����
	 * 
	 */
	private void editZhangWu() {
		Scanner sc = new Scanner (System.in);
		System.out.println("��ǰΪ�༭����ģʽ���밴Ҫ����������");
		System.out.print("������Ҫ�༭�����ID��");
		int zwid = sc.nextInt();
		sc.nextLine();
		System.out.print("������Ҫ�༭����ķ������ƣ�");
		String flname = sc.nextLine();
		System.out.print("������Ҫ�༭����Ľ�");
		double money = sc.nextDouble();
		sc.nextLine();
		System.out.print("�������˻���");
		String zhangHu = sc.nextLine();
		System.out.print("���������ڣ���ʽΪ XXXX-XX-XX����");
		String createtime = sc.nextLine();
		System.out.print("������Ҫ�༭����ļ���������");
		String description = sc.nextLine();
		
		//�������ݣ�����controller��ķ��������ݲ���
		//�û��������в�������װ��zhangwu����
		ZhangWu zw = new ZhangWu(zwid, money, flname, zhangHu, createtime, description);
		controller.editZhangWu(zw);
		System.out.println("�༭����ɹ���");
		
	}

	/*
	 * ���巽��selectZhangWu() 
	 * ��ʾ��ѯ��ʽ 1.��ѯ���� 2.������ѯ
	 */
	public void selectZhangWu() {
		System.out.println("1.��ѯ����    2.������ѯ");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// ���ò�ѯ�����������ݵķ���
			selectAll();
			break;
		case 2:
			// ����������ѯ�������ݵķ���
			select();
			break;
		default:
			System.out.println("��������");
			return;
		}
	}
	
	
	/*
	 * ���巽���������������
	 * ����controller��ķ���
	 */
	public void addZhangWu () {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ǰΪ��������ܣ��밴Ҫ����������");
		System.out.print("��������������ķ������ƣ�");
		String flname = sc.nextLine();
		System.out.print("��������������Ľ�");
		double money = sc.nextDouble();
		sc.nextLine();
		System.out.print("�������˻���");
		String zhangHu = sc.nextLine();
		System.out.print("���������ڣ���ʽΪ XXXX-XX-XX����");
		String createtime = sc.nextLine();
		System.out.print("��������������ļ���������");
		String description = sc.nextLine();
		
		//�������ݣ�����controller��ķ��������ݲ���
		//�û��������в�������װ��zhangwu����
		ZhangWu zw = new ZhangWu(0, money, flname, zhangHu, createtime, description);
		controller.addZhangWu(zw);
		System.out.println("��ϲ���������ɹ���");
	}

	/*
	 * ���巽����ʵ�ֲ�ѯ������������
	 */
	public void selectAll() {
		List<ZhangWu> list = controller.selectAll();
		if (list.size() != 0) {
			print(list);
		}else {
			System.out.println("��Ǹ��δ��ѯ�������");
		}
	}

	/*
	 * ���巽����ʵ�ְ�������ѯ�������� �ṩ�û��������ڣ���ʼ���ںͽ�������
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
		List<ZhangWu> list = controller.select(startDate, endDate);
		if (list.size() != 0) {
			print(list);
		}else {
			System.out.println("��Ǹ��δ��ѯ���������µĽ����");
		}
	}

	private void print(List<ZhangWu> list) {
		// ��ӡ��ͷ
		System.out.println("ID\t���\t\t�˻�\t\t���\t\tʱ��\t\t˵��");
		// �������ϣ�������
		for (ZhangWu zw : list) {
			System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t\t" + zw.getZhangHu() + "\t\t" + zw.getMoney()
					+ "\t\t" + zw.getCreatetime() + "\t" + zw.getDescription());
		}
	}
}
