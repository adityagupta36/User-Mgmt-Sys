package com.aditya.CRUD.UserMgmtSys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.aditya.CRUD.UserMgmtSys")
@SpringBootApplication
public class UserMgmtSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMgmtSysApplication.class, args);
	}

}
