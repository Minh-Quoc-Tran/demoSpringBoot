package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Girl {
    // Bean được quản lý trong ApplicationContext và được tạo ra 1 lần duy nhất
    // Khi có class yêu cầu Autowired thì nó lấy đối tượng có sẵn trong Application và Inject vào
    // Nếu muôn tạo mới một Component thì đánh dấu nó bằng @Scope("prototy")

    //Đánh dấu để Spring  inject một đối tượng Outfit vào đây
    @Autowired
    Outfit outfit;
    // Đánh dấu Autowired bảo rằng Sping boot hãy tự inject(tiêm , tạo ) ra một Intance của Outfit
    // vào trong thuộc tính này khi khởi tạo Girl

    // Thứ tự ưu tiên Inject Outfit là Constructor -> Setter nếu không có cả hai thi sẽ sử dụng Java Reflection
    public Girl(){ }

    // Chỉ định bean naked được Inject vào Girl
    public Girl(Outfit outfit){
        this.outfit = outfit;
    }

    // PostConstruct được đánh dấu duy nhất trên một method duy nhất bên trong Bean
    //Ioc Container hoặc ApplicationContext sẽ gọi hàm này sau khi một Bean đc khởi tạo và quản lý
    @PostConstruct
    public void postConstruct() {
        System.out.println("Đối tượng Girl sau khi khởi tạo sẽ chạy hàm này!");

    }
    // PostConstruct được đánh dấu duy nhất trên một method duy nhất bên trong Bean
    //Ioc Container hoặc ApplicationContext sẽ gọi hàm này trước khi bị Destroy
    @PreDestroy
    public void preDestroy() {
        System.out.println("Đối tượng Girl trước khi bị xóa sẽ chạy hàm này!");
    }

}
