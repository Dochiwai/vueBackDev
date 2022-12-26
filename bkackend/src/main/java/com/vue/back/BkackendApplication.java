package com.vue.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.vue.back")
public class BkackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BkackendApplication.class, args);
	}

}
