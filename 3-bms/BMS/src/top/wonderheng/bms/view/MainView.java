package top.wonderheng.bms.view;
/*
 * 视图层
 * 用户操作界面
 * 将数据传递给controller层
 * 成员位置创建controller对象
 */

import java.util.List;
import java.util.Scanner;

import top.wonderheng.bms.controller.BookController;
import top.wonderheng.bms.domain.Book;

public class MainView {
	private BookController controller = new BookController();
	//实现界面效果，接收用户输入的数据，根据数据调用不同的功能方法
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("---------------图书管理系统---------------");
			System.out.println("1.添加图书　2.编辑图书　3.查询图书　4.删除图书　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
			// 接收用户选择
			int choose = sc.nextInt();
			switch (choose) {
			// 调用添加图书的方法
			case 1:
				addBook();
				break;
			// 调用编辑图书的方法
			case 2:
				editBook();
				break;
			// 调用查询图书的方法
			case 3:
				selectBook();
				break;
			// 调用删除图书的方法
			case 4:
				deleteBook();
				break;
			// 退出系统
			case 5:
				System.out.println("已成功退出系统！");
				System.exit(0);
			default:
				System.out.println("输入有误，请重新输入！");
			}
		}
	}
	
	/*
	 * 定义方法，添加图书数据
	 * 调用controller层的方法
	 */
	public void addBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("当前为添加图书功能，请按要求输入数据");
		System.out.print("请输入待添加图书的名称：");
		String bname = sc.nextLine();
		System.out.println("请输入待添加图书的金额：");
		double bmoney = sc.nextDouble();
		sc.nextLine();
		System.out.println("请输入日期（格式为XXXX-XX-XX）：");
		String createtime = sc.nextLine();
		System.out.println("请输入待添加图书的简略描述：");
		String description = sc.nextLine();
		
		//接收数据，调用controller层的方法，传递参数
		//用户输入所有参数，封装成Book对象
		Book b = new Book(0, bmoney, bname, createtime, description);
		controller.addBook(b);
		System.out.println("恭喜！添加图书成功！");
	}
	
	/*
	 * 定义方法，修改图书信息
	 * 调用controller层的方法
	 */
	public void editBook() {
		Scanner sc = new Scanner (System.in);
		System.out.println("当前为编辑图书模式，请按要求输入数据");
		System.out.print("请输入要编辑图书的ID：");
		int bid = sc.nextInt();
		sc.nextLine();
		System.out.print("请输入要编辑图书的分类名称：");
		String bname = sc.nextLine();
		System.out.print("请输入要编辑图书的金额：");
		double bmoney = sc.nextDouble();
		sc.nextLine();
		System.out.print("请输入日期（格式为 XXXX-XX-XX）：");
		String createtime = sc.nextLine();
		System.out.print("请输入要编辑图书的简略描述：");
		String description = sc.nextLine();
		
		//接受数据，调用controller层的方法，传递参数
		//用户输入所有参数，封装成Book对象
		Book b = new Book(bid, bmoney, bname,createtime, description);
		controller.editBook(b);
		System.out.println("编辑图书成功！");
	}
	
	/*
	 * 定义方法selectBook() 
	 * 显示查询方式 1.查询所有 2.条件查询
	 */
	public void selectBook() {
		System.out.println("1.查询所有    2.条件查询");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// 调用查询所有图书数据的方法
			selectAll();
			break;
		case 2:
			// 调用条件查询图书数据的方法
			select();
			break;
		default:
			System.out.println("输入有误！");
			return;
		}
	}
	
	/*
	 * 定义方法，实现查询所有图书数据
	 */
	public void selectAll() {
		List<Book> list = controller.selectAll();
		if (list.size() != 0) {
			print(list);
		}else {
			System.out.println("抱歉！未查询到结果。");
		}
	}

	/*
	 * 定义方法，实现按条件查询图书数据 提供用户输入日期，开始日期和结束日期
	 * 传递到controller层 调用controller的方法，传递2个日期参数
	 * 获取并打印结果
	 */
	public void select() {
		System.out.println("条件查询，请按提示输入日期，日期格式为：XXXX-XX-XX");
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入开始日期：");
		String startDate = sc.nextLine();
		System.out.print("请输入截止日期：");
		String endDate = sc.nextLine();

		// 调用controller层的方法,传递两个字符串，获取结果集
		List<Book> list = controller.select(startDate, endDate);
		if (list.size() != 0) {
			print(list);
		}else {
			System.out.println("抱歉！未查询到该条件下的结果。");
		}
	}
	
	public void deleteBook() {
		System.out.println("当前为删除图书模式，请谨慎删除！");
		System.out.println("请输入待删除图书的ID：");
		Scanner sc = new Scanner(System.in);
		int bid = sc.nextInt();
		controller.deleteBook(bid);
		System.out.println("删除图书成功！");
	}

	public void print(List<Book> list) {
		// 打印表头
		System.out.println("ID\t类别\t\t金额\t\t时间\t\t描述");
		// 遍历集合，输出结果
		for (Book b : list) {
			System.out.println(b.getBid() + "\t" + b.getBname() + "\t\t" + b.getBmoney()
					+ "\t\t" + b.getCreatetime() + "\t" + b.getDescription());
		}
	}
	
}





