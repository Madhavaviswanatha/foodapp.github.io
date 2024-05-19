package com.food.model;

public class Restaurants {
	private int restaurantId;
	private String name;
	private String cuisineType;
	private int deliveryTime;
	private String address;
	private int adminUserId;
	private float rating;
	private String isActive;
	private String imagePath;
	public Restaurants() {
		// TODO Auto-generated constructor stub
	}
	public Restaurants(int restaurantId, String name, String cuisineType, int deliveryTime, String address,
			int adminUserId, float rating, String  isActive, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		this.adminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAdminUserId() {
		return adminUserId;
	}
	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String isActive() {
		return isActive;
	}
	public void setActive(String isActive) {
		this.isActive = isActive;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "Restaurants [restaurantId=" + restaurantId + ", name=" + name + ", cuisineType=" + cuisineType
				+ ", deliveryTime=" + deliveryTime + ", address=" + address + ", adminUserId=" + adminUserId
				+ ", rating=" + rating + ", isActive=" + isActive + ", imagePath=" + imagePath + "]";
	}
	

}
