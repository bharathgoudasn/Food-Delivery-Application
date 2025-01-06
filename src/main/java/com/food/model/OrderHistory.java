package com.food.model;

public class OrderHistory {

	private int orderhistoryid;
	private int orderid;
	private int userid;
	private int totalamount;
	private String status;
	private int orderdate;
	
	public OrderHistory(int orderhistoryid, int orderid, int userid, int totalamount, String status) {
		super();
		this.orderhistoryid = orderhistoryid;
		this.orderid = orderid;
		this.userid = userid;
		this.totalamount = totalamount;
		this.status = status;
	}

	public int getOrderhistoryid() {
		return orderhistoryid;
	}

	public void setOrderhistoryid(int orderhistoryid) {
		this.orderhistoryid = orderhistoryid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(int orderdate) {
		this.orderdate = orderdate;
	}

	@Override
	public String toString() {
		return "OrderHistory [orderhistoryid=" + orderhistoryid + ", orderid=" + orderid + ", userid=" + userid
				+ ", totalamount=" + totalamount + ", status=" + status + ", orderdate=" + orderdate + "]";
	}
	
	
}