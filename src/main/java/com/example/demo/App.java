package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springmvc.GirlService;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		//SpringApplication.run(App.class, args); là câu lệnh tạo ra container để chưa các bean (Component)
		ApplicationContext context =  SpringApplication.run(App.class, args);
		//Sping boot chạy sẽ dò tìm các class cùng cấp và các package cấp thấp hơn so với class
		//khi gặp một class đc đánh dấu Component thì nó tạo ra một instance đưa vào context quản lý
		// Khi chạy xong các context sẽ chứa các Bean có đánh dấu @Component

		//Lấy bean ra bằng cách
		Outfit outfit = context.getBean(Outfit.class);
		System.out.println("Instance 1: " + outfit);

		Girl girl = context.getBean(Girl.class);
		System.out.println("Instance 2: " + girl);
		girl.outfit.wear();

		/*Outfit outfit1 = new SkirtWithTshirt();
		Girl girl = new Girl(outfit1);
		// In ra
		System.out.println("Instance: " + outfit);
		//Gọi hàm wear
		outfit.wear();

		Girl girl1 = context.getBean(Girl.class);

		System.out.println("Girl Intance : " + girl);

		System.out.println("Outfit: " + girl.outfit);

		girl.outfit.wear();*/


	}

}
