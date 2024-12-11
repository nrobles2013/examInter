package com.swagger;

import com.swagger.persistence.entity.PermissionEntity;
import com.swagger.persistence.entity.RoleEntity;
import com.swagger.persistence.entity.RoleEnum;
import com.swagger.persistence.entity.UserEntity;
import com.swagger.persistence.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringBootSwaggerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwaggerApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		

	}
}
