package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.simple.Restaurant;

public class RestaurantTest {
	private Restaurant restaurant;
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig.xml");
		Restaurant r1 = (Restaurant)ctx.getBean("restaurantBean");
		r1.setRestaurantId(1);
		r1.setRestaurantNmae("Hi");
		Restaurant r2 = (Restaurant)ctx.getBean("restaurantBean");
		r2.setRestaurantId(2);
		r2.setRestaurantNmae("Hello");
		System.out.println(r1);
		System.out.println(r2.getRestaurantId()+"="+r2.getRestaurantName());
		System.out.println(r1.getRestaurantId()+"="+r1.getRestaurantName());*/
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext(); 
		Restaurant res = (Restaurant) cxt.getBean("restaurantBean");
		res.setRestaurantId(1);
		System.out.println(res.getRestaurantName());
	}
	
	public void show(){
		System.out.println("Test this");
		
	}

}
