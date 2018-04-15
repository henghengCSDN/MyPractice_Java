package top.wonderheng.bms.app;

import top.wonderheng.bms.view.MainView;

/**
 * 主程序类
 * 功能：开启软件程序
 * @author 张恒
 * QQ邮箱：995107866@qq.com
 * 个人博客：www.wonderheng.top
 * Date:2018-4-10
 */
public class MainApp {

	public static void main(String[] args) {
		//view层
		new MainView().run();
	}
	
}
