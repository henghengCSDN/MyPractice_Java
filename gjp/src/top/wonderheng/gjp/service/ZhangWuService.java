package top.wonderheng.gjp.service;

import java.util.List;

import top.wonderheng.gjp.dao.ZhangWuDao;
import top.wonderheng.gjp.domain.ZhangWu;

/*
 * ҵ�����
 * ������һ�㣨���Ʋ�controller��������
 * �������㣬���ݸ�dao�㣬ʵ�ֶ����ݿ�Ĳ���
 * ���Աλ�ô���dao��Ķ�����Ҫ����dao���е���
 */
public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();
	
	/*
	 * ���巽������controller ��Ĳ���
	 * ����ZhangWuDao��ķ�����ʵ��ɾ������
	 */
	public void deleteZhangWu(int zwid) {
		dao.deleteZhangWu(zwid);
	}
	
	/*
	 * ���巽������controller ��Ĳ���
	 * ����ZhangWuDao��ķ�����ʵ�ֱ༭����
	 */
	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu (zw);
	}

	/*
	 * ���巽����ʵ�����������
	 * ����service��Ĳ�����
	 * ����zhangwudao��ķ���addzhangwu()
	 */
	public void addZhangWu (ZhangWu zw) {
		dao.addZhangWu(zw);
	}
	
	/*
	 * ���巽����ʵ��������ѯ
	 * ������controller����ã����������ַ���
	 * ����dao��ķ��������������ַ�������ȡ�����
	 */
	public List<ZhangWu> select (String startDate,String endDate) {
		return dao.select(startDate, endDate);
	}
	
	/*
	 * ���巽����ʵ�ֲ�ѯ������������
	 * �����ɿ��Ʋ�controller����dao��ķ���
	 */
	public List<ZhangWu> selectAll() {
		
		return dao.selectAll();
	}


}
