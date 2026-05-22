package web.mvc.step03_userboardreply;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import web.mvc.domain.FreeBoard;
import web.mvc.service.FreeBoardService;
import web.mvc.service.UserService;

@SpringBootTest
class Step03UserBoardReplyApplicationTests {

	@Autowired
	FreeBoardService freeBoardService;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("자유게시판_글작성_테스트")
	@Transactional
	@Rollback(false)
	void freeBoardInsertTest() {
		for (int i = 1; i <= 50; i++) {
			FreeBoard fb = FreeBoard.builder()
					.subject("Title" + i)
					.writer("User" + i)
					.password("1234")
					.content("content " + i)
					.build();

			freeBoardService.insert(fb);
		}
	}

}
