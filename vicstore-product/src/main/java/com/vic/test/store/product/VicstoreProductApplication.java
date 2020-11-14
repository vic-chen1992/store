package com.vic.test.store.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.vic.test.store.product.dao")
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class VicstoreProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(VicstoreProductApplication.class, args);
	}

}
