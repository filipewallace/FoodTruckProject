package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private static int nextTruckId = 1;
	private String truckName;
	private String foodType;
	private int rating;
	private int truckID;

	public FoodTruck() {

	}

	public FoodTruck(String truckName, String foodType, int rating) {
		this(truckName, foodType, rating, nextTruckId);

	}

	public FoodTruck(String truckName, String foodType, int rating, int truckId) {
		this.truckID = truckId;
		this.truckName = truckName;
		this.foodType = foodType;
		this.rating = rating;
	}

	public int getTruckID() {
		return truckID;
	}

	public void setTruckID(int truckID) {
		this.truckID = truckID;
	}

	public void setNextTruckID() {
		nextTruckId = nextTruckId * 3;

	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "FoodTruck [truckName = " + truckName + ", foodType = " + foodType + ", rating = " + rating
				+ ", truckID = " + truckID + "]";
	}

}