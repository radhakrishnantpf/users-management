package com.sukri.users.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class UsersManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersManagementApplication.class, args);
	}

}
