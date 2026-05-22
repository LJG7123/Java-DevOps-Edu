package web.mvc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;
import web.mvc.entity.Board;
import web.mvc.repository.BoardRepository;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@Slf4j
public class BoardQueryMethodJPQLTests {

	@Autowired
    private BoardRepository boardRepository;

	@Test
	@DisplayName("1. 글번호보다_큰_게시물_조회")
    public void test1() {
		List<Board> list = boardRepository.findByBnoGreaterThan(100L);
		list.forEach(System.out::println);
	}

	@Test
	@DisplayName("2. 글번호_작성자_기준_조회")
    public void test2() {
		List<Board> list = boardRepository.findByBnoLessThanEqualOrTitle(50L, "제목150");
		list.forEach(System.out::println);
	}

	@Test
	@DisplayName("3. 글번호_인수보다_큰_게시물_삭제")
	public void test3() {
		boardRepository.deleteByBnoGreaterThan(180L);

		List<Board> list = boardRepository.findByBnoGreaterThan(180L);
		Assertions.assertTrue(list.isEmpty());
	}

	@Test
	@DisplayName("4. 글번호_제목_조회")
	public void test4() {
		List<Board> list = boardRepository.findBnoTitle(20L, "제목3%");
		list.forEach(System.out::println);
	}

	@Test
	@DisplayName("5. 글번호_제목_작성자_조회")
	public void test5() {
		List<Board> list = boardRepository.findByWhere(Board.builder().bno(30L).title("제목50").writer("작성자70").build());
		list.forEach(System.out::println);
	}
}
