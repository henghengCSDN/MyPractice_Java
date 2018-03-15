package top.wonderheng.gjp.view;
/*
 * 视图层
 * 用户操作的界面
 * 将数据传递给controller层
 * 成员位置创建controller对象
 */

import java.util.List;
import java.util.Scanner;

import top.wonderheng.gjp.controller.ZhangWuController;
import top.wonderheng.gjp.domain.ZhangWu;

public class MainView {
	private ZhangWuController controller = new ZhangWuController();

	/*
	 * 实现界面效果 接收用户输入的数据，根据数据调用不同的功能方法
	 */
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("---------------管家婆家庭记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
			// 接收用户选择
			int choose = sc.nextInt();
			switch (choose) {
			// 调用添加账务的方法
			case 1:
				addZhangWu ();
				break;
			// 调用编辑账务的方法
			case 2:
				editZhangWu();
				break;
			// 调用删除账务的方法
			case 3:
				deleteZhangWu();
				break;
			// 调用查询账务的方法
			case 4:
				selectZhangWu();
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
	 * 定义方法，实现账务删除
	 * 
	 */
	private void deleteZhangWu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("当前为删除账务模式，以下是当前数据库中的信息：");
		selectAll();
		System.out.println("请输入要删除的账务ID:");
		int zwid = sc.nextInt();
		sc.nextLine();
		System.out.print("你确定要删除该条账务信息吗？ 确认请输入Y(或y),取消请输入除Y(或y)以外的任意字符：");
		String str = sc.nextLine();
		if(str.equals("Y")||str.equals("y")) {
			//调用controller层的方法，传递ID号
			controller.deleteZhangWu(zwid);
			System.out.println("删除账务成功！");
		}else {
			System.out.println("已取消删除！");
		}
	}

	/*
	 * 定义方法，编辑账务
	 * 
	 */
	private void editZhangWu() {
		Scanner sc = new Scanner (System.in);
		System.out.println("当前为编辑账务模式，请按要求输入数据");
		System.out.print("请输入要编辑账务的ID：");
		int zwid = sc.nextInt();
		sc.nextLine();
		System.out.print("请输入要编辑账务的分类名称：");
		String flname = sc.nextLine();
		System.out.print("请输入要编辑账务的金额：");
		double money = sc.nextDouble();
		sc.nextLine();
		System.out.print("请输入账户：");
		String zhangHu = sc.nextLine();
		System.out.print("请输入日期（格式为 XXXX-XX-XX）：");
		String createtime = sc.nextLine();
		System.out.print("请输入要编辑账务的简略描述：");
		String description = sc.nextLine();
		
		//接受数据，调用controller层的方法，传递参数
		//用户输入所有参数，封装成zhangwu对象
		ZhangWu zw = new ZhangWu(zwid, money, flname, zhangHu, createtime, description);
		controller.editZhangWu(zw);
		System.out.println("编辑账务成功！");
		
	}

	/*
	 * 定义方法selectZhangWu() 
	 * 显示查询方式 1.查询所有 2.条件查询
	 */
	public void selectZhangWu() {
		System.out.println("1.查询所有    2.条件查询");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// 调用查询所有账务数据的方法
			selectAll();
			break;
		case 2:
			// 调用条件查询账务数据的方法
			select();
			break;
		default:
			System.out.println("输入有误！");
			return;
		}
	}
	
	
	/*
	 * 定义方法，添加账务数据
	 * 调用controller层的方法
	 */
	public void addZhangWu () {
		Scanner sc = new Scanner(System.in);
		System.out.println("当前为添加账务功能，请按要求输入数据");
		System.out.print("请输入待添加账务的分类名称：");
		String flname = sc.nextLine();
		System.out.print("请输入待添加账务的金额：");
		double money = sc.nextDouble();
		sc.nextLine();
		System.out.print("请输入账户：");
		String zhangHu = sc.nextLine();
		System.out.print("请输入日期（格式为 XXXX-XX-XX）：");
		String createtime = sc.nextLine();
		System.out.print("请输入待添加账务的简略描述：");
		String description = sc.nextLine();
		
		//接受数据，调用controller层的方法，传递参数
		//用户输入所有参数，封装成zhangwu对象
		ZhangWu zw = new ZhangWu(0, money, flname, zhangHu, createtime, description);
		controller.addZhangWu(zw);
		System.out.println("恭喜，添加账务成功！");
	}

	/*
	 * 定义方法，实现查询所有账务数据
	 */
	public void selectAll() {
		List<ZhangWu> list = controller.selectAll();
		if (list.size() != 0) {
			print(list);
		}else {
			System.out.println("抱歉！未查询到结果。");
		}
	}

	/*
	 * 定义方法，实现按条件查询账务数据 提供用户输入日期，开始日期和结束日期
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
		List<ZhangWu> list = controller.select(startDate, endDate);
		if (list.size() != 0) {
			print(list);
		}else {
			System.out.println("抱歉！未查询到该条件下的结果。");
		}
	}

	private void print(List<ZhangWu> list) {
		// 打印表头
		System.out.println("ID\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
		// 遍历集合，输出结果
		for (ZhangWu zw : list) {
			System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t\t" + zw.getZhangHu() + "\t\t" + zw.getMoney()
					+ "\t\t" + zw.getCreatetime() + "\t" + zw.getDescription());
		}
	}
}
