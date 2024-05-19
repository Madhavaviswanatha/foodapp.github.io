package com.food.model;

public class Orderitems {
	private int orderItemId;
	private int orderId;
	private int menuId;
	private String itemName;
	private int quantity;
	private int itemTotal;
	private float itemPrice; 
	public Orderitems() {
		// TODO Auto-generated constructor stub
	}
	public Orderitems(int orderItemId, int orderId, int menuId, String itemName, int quantity, int itemTotal,
			float itemPrice) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
		this.itemPrice = itemPrice;
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(int itemTotal) {
		this.itemTotal = itemTotal;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	
	 

}
