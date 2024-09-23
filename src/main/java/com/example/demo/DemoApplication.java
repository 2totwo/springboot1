package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 2)자동설정기능
public class DemoApplication {
	// springboot의 시작메서드
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
