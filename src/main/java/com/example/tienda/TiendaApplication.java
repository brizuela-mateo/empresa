package com.example.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
//@ComponentScan(basePackages = "com.example.tienda.config")
@ComponentScan(basePackages = {"com.example.tienda", "controller", "service", "dao", "config", "model"})
public class TiendaApplication {

	public static void main(String[] args) {

		SpringApplication.run(TiendaApplication.class, args);
	}

}
