package com.vic.test.store.member;

import com.vic.test.store.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VicstoreMemberApplicationTests {
	@Autowired
	MemberService memberService;
	@Test
	void contextLoads() {


	}

}
