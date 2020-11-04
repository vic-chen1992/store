package com.vic.test.store.product;

import com.vic.test.store.product.entity.BrandEntity;
import com.vic.test.store.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VicstoreProductApplicationTests {
	@Autowired
	BrandService brandService;
	@Test
	void contextLoads() {

		BrandEntity brandEntity=new BrandEntity();
		brandEntity.setName("test");
		boolean result = brandService.save(brandEntity);
		System.out.println("新增成功?:"+result);
	}

}
