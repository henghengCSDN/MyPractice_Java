package top.wonderheng.bms.domain;

public class Book {
	private int bid;
	private double bmoney;
	private String bname;
	private String createtime;
	private String description;

	public Book() {

	}

	public Book(int bid, double bmoney, String bname, String createtime, String description) {
		this.bid = bid;
		this.bmoney = bmoney;
		this.bname = bname;
		this.createtime = createtime;
		this.description = description;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public double getBmoney() {
		return bmoney;
	}

	public void setBmoney(double bmoney) {
		this.bmoney = bmoney;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
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
