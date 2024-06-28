package com.elleined.caching;

import net.datafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
public class CachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingApplication.class, args);
	}


	@Bean
	public Faker faker() {
		return new Faker();
	}
}
