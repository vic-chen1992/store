package com.vic.test.store.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@MapperScan("com.vic.test.store.product.dao")
@SpringBootApplication
@EnableDiscoveryClient

public class VicstoreProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(VicstoreProductApplication.class, args);
	}

}
