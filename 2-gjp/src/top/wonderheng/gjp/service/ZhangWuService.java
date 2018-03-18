package top.wonderheng.gjp.service;

import java.util.List;

import top.wonderheng.gjp.dao.ZhangWuDao;
import top.wonderheng.gjp.domain.ZhangWu;

/*
 * 业务层类
 * 接收上一层（控制层controller）的数据
 * 经过计算，传递给dao层，实现对数据库的操作
 * 类成员位置创建dao层的对象，需要调用dao层中的类
 */
public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();
	
	/*
	 * 定义方法接收controller 层的参数
	 * 调用ZhangWuDao层的方法，实现删除账务
	 */
	public void deleteZhangWu(int zwid) {
		dao.deleteZhangWu(zwid);
	}
	
	/*
	 * 定义方法接收controller 层的参数
	 * 调用ZhangWuDao层的方法，实现编辑账务
	 */
	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu (zw);
	}

	/*
	 * 定义方法，实现添加账务功能
	 * 接收service层的参数，
	 * 调用zhangwudao层的方法addzhangwu()
	 */
	public void addZhangWu (ZhangWu zw) {
		dao.addZhangWu(zw);
	}
	
	/*
	 * 定义方法，实现条件查询
	 * 方法由controller层调用，传递两个字符串
	 * 调用dao层的方法，传递两个字符串，获取结果集
	 */
	public List<ZhangWu> select (String startDate,String endDate) {
		return dao.select(startDate, endDate);
	}
	
	/*
	 * 定义方法，实现查询所有账务数据
	 * 方法由控制层controller调用dao层的方法
	 */
	public List<ZhangWu> selectAll() {
		
		return dao.selectAll();
	}


}
