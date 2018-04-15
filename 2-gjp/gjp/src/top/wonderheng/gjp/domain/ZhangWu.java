package top.wonderheng.gjp.domain;

public class ZhangWu {
	private int zwid;
	private double money;
	private String flname;
	private String zhangHu;
	private String createtime;
	private String description;

	public ZhangWu(int zwid, double money, String flname, String zhangHu, String createtime, String description) {
		super();
		this.zwid = zwid;
		this.money = money;
		this.flname = flname;
		this.zhangHu = zhangHu;
		this.createtime = createtime;
		this.description = description;
	}

	public ZhangWu() {

	}

	public int getZwid() {
		return zwid;
	}

	public void setZwid(int zwid) {
		this.zwid = zwid;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getFlname() {
		return flname;
	}

	public void setFlname(String flname) {
		this.flname = flname;
	}

	public String getZhangHu() {
		return zhangHu;
	}

	public void setZhangHu(String zhangHu) {
		this.zhangHu = zhangHu;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
