package com.simple;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	String restaurantName;
	int restaurantId;
	List<IRestaurantAddress> restaurantAddress;
	List<IRestaurantMenus> restaurantMenus;
	
	/*Restaurant(int id,String name){
		restaurantId=id;
		restaurantName=name;
		show();
	}*/

	@Bean("restaurantBean")
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantNmae(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public List<IRestaurantAddress> getRestaurantAddress() {
		return restaurantAddress;
	}
	public void setRestaurantAddress(List<IRestaurantAddress> restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	public List<IRestaurantMenus> getRestaurantMenus() {
		return restaurantMenus;
	}
	public void setRestaurantMenus(List<IRestaurantMenus> restaurantMenus) {
		this.restaurantMenus = restaurantMenus;
	}
	
	public void show(){
		System.out.println(restaurantId+" = "+restaurantName);
		
	}
	
	
}
