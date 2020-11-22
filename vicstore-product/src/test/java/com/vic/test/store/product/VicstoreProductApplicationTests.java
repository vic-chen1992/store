package com.vic.test.store.product;

import com.aliyun.oss.OSSClient;
import com.vic.test.store.product.entity.BrandEntity;
import com.vic.test.store.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

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
	@Test
	void uploadtest(){
		// Endpoint以杭州為例，其它Region請按實際情況填寫。
		String endpoint = "http://oss-cn-beijing.aliyuncs.com";
// 阿里雲主帳號AccessKey擁有所有API的存取權限，風險很高。強烈建議您建立並使用RAM帳號進行API訪問或日常運維，請登入 https://ram.console.aliyun.com 建立RAM帳號。
		String accessKeyId = "LTAI4GH5eht1TvjGuDw6C1t7";
		String accessKeySecret = "vobBJdq70705xIA4YmEw2HhDHt1CGu";
// 建立OSSClient執行個體。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 上傳檔案。<yourLocalFile>由本地檔案路徑加檔案名包括尾碼組成，例如/users/local/myfile.txt。
		ossClient.putObject("myosstest001", "test", new File("C:\\Users\\user\\Pictures\\Camera Roll\\WIN_20190512_02_00_22_Pro.jpg"));
// 關閉OSSClient。
		ossClient.shutdown();
		System.out.println("上傳成功");
	}

}
