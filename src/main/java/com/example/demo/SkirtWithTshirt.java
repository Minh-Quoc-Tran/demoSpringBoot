package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class SkirtWithTshirt implements Outfit{
    @Override
    public void wear() {
        System.out.println("Đã mặc Váy và Áo khoác");
    }
}
