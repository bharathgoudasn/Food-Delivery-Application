package com.food.model;

public class CartItem {

	private int itemid;
	private int restaurantid;
	private String name;
	private int quantity;
	private int price;
	
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CordItem [itemid=" + itemid +  ", restaurantid=" + restaurantid + ", name=" + name
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
	public CartItem(int itemid, int restaurantid, String name, int quantity, int price) {
		super();
		this.itemid = itemid;
		this.restaurantid = restaurantid;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public CartItem() {
		super();
	}
	
	
}
