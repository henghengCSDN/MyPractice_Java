package top.wonderheng.gjp.controller;
/*
 * ��������
 * ������ͼ��view�����ݣ����ݸ������sercice
 * ��Աλ�ô���sercice����
 */

import java.util.List;

import top.wonderheng.gjp.domain.ZhangWu;
import top.wonderheng.gjp.service.ZhangWuService;

public class ZhangWuController {
	private ZhangWuService service = new ZhangWuService();
	
	/*
	 * ���巽����ʵ��ɾ��������
	 * ����service��ķ���
	 */
	public void deleteZhangWu(int zwid) {
		service.deleteZhangWu(zwid);
	}
	
	/*
	 * ���巽�����༭����
	 * ����service��ķ���
	 */
	public void editZhangWu(ZhangWu zw) {
		service.editZhangWu (zw);
	}
	
	
	/*
	 * ���巽����ʵ�����������
	 * ������ͼ��Ĳ�����
	 * ����service��ķ���
	 */
	public void addZhangWu (ZhangWu zw) {
		service.addZhangWu(zw);
	}
	
	/*
	 * ���巽����ʵ��������ѯ
	 * ��������ͼ����ã����������ַ���
	 * ����service��ķ��������������ַ�������ȡ�����
	 */
	public List<ZhangWu> select (String startDate,String endDate) {
		return service.select(startDate, endDate);
	}
	
	/*
	 * ���Ʋ���÷�����ʵ�ֲ�ѯ������������
	 * ��������ͼ����ã���������service��
	 */
	public List<ZhangWu> selectAll() {
		return service.selectAll();
	}



}
