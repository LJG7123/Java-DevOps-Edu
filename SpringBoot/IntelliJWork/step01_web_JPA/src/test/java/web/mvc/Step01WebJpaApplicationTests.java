package web.mvc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 통합 테스트 (프로젝트 전체를 테스트)
@Slf4j
class Step01WebJpaApplicationTests {

	@BeforeEach
	public void before() {
		log.info("Before test...");
	}

	@AfterEach
	public void after() {
		log.info("After test...");
	}


	@Test
	@DisplayName("기본 test")
	void contextLoads() {
		log.info("기본 test입니다");
	}

}
