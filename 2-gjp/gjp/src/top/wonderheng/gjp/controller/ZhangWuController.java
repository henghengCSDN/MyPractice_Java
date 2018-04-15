package top.wonderheng.gjp.controller;
/*
 * 控制器层
 * 接收视图层view的数据，传递给服务层sercice
 * 成员位置创建sercice对象
 */

import java.util.List;

import top.wonderheng.gjp.domain.ZhangWu;
import top.wonderheng.gjp.service.ZhangWuService;

public class ZhangWuController {
	private ZhangWuService service = new ZhangWuService();
	
	/*
	 * 定义方法，实现删除账务功能
	 * 调用service层的方法
	 */
	public void deleteZhangWu(int zwid) {
		service.deleteZhangWu(zwid);
	}
	
	/*
	 * 定义方法，编辑账务
	 * 调用service层的方法
	 */
	public void editZhangWu(ZhangWu zw) {
		service.editZhangWu (zw);
	}
	
	
	/*
	 * 定义方法，实现添加账务功能
	 * 接收视图层的参数，
	 * 调用service层的方法
	 */
	public void addZhangWu (ZhangWu zw) {
		service.addZhangWu(zw);
	}
	
	/*
	 * 定义方法，实现条件查询
	 * 方法由视图层调用，传递两个字符串
	 * 调用service层的方法，传递两个字符串，获取结果集
	 */
	public List<ZhangWu> select (String startDate,String endDate) {
		return service.select(startDate, endDate);
	}
	
	/*
	 * 控制层调用方法，实现查询所有账务数据
	 * 方法由视图层调用，方法调用service层
	 */
	public List<ZhangWu> selectAll() {
		return service.selectAll();
	}



}
