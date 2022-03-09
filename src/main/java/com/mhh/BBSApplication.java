package com.mhh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mhh.mapper")
public class BBSApplication {

	public static void main(String[] args) {
		SpringApplication.run(BBSApplication.class, args);
	}

}