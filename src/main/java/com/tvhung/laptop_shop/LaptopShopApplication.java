package com.tvhung.laptop_shop;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication(exclude = {
// 		SecurityAutoConfiguration.class,
// 		UserDetailsServiceAutoConfiguration.class
// })

@SpringBootApplication
public class LaptopShopApplication {
	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

		SpringApplication.run(LaptopShopApplication.class, args);

		// ApplicationContext context =
		// SpringApplication.run(LaptopShopApplication.class,
		// args);
		// for (String name : context.getBeanDefinitionNames()) {
		// System.out.println(name);
		// }
	}
}
