package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
 Đánh dấu class bằng @Component
 Class này sẽ được Spring Boot hiểu là một Bean (hoặc dependency)
 Và sẽ được Spring Boot quản lý
*/
// Conponent đc đánh dấu để Spring biết đó là một Bean
@Component

public class Biniki implements Outfit{
    @Override
    public void wear() {
        System.out.println("Mặc Biniki");
    }
}


