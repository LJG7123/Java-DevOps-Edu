package web.mvc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import web.mvc.entity.Board;
import web.mvc.repository.BoardRepository;
import web.mvc.service.BoardService;

/**
 * @DataJpaTest는 기본적으로 내장 DB(H2설정)를 자동 설정해서 테스트를 수행한다.
 * @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
 * 설정해서 ~.properties설정을 변경하지 않고 설정에 있는 DB사용하겠다.
 *
 * 기본 transaction이 설정되어 있고 rollback처리된다.
 */
//@SpringBootTest
@DataJpaTest // Controller나 Service는 접근 불가
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@Slf4j
public class BoardRepoTests {

	@Autowired
	private BoardRepository boardRepository;

//	@Autowired
//	private BoardService boardService;

	@Test
	@DisplayName("기본 테스트")
	public void test() {
		log.info("Board test 입니다..");
		log.info("boardRepository = {}", boardRepository);
//		log.info("boardService = {}", boardService);
	}

	// 등록 테스트
	@Test
	@DisplayName("게시물 등록")
	public void test2() {
		/*boardRepository.save(Board.builder().title("title1").build());
		boardRepository.save(Board.builder().title("title2").build());*/

		// 한번에 여러개의 레코드를 등록
		/*for (int i = 1; i <= 200; i++) {
			Board board = Board.builder().title("제목" + i).writer("작성자" + i).content("내용" + i).build();
			boardRepository.save(board);
		}*/

		/*Board board = Board.builder().bno(1L).title("제목").writer("작성자").content("내용").build();
		boardRepository.save(board);*/

		Board board = Board.builder().bno(210L).title("제목").writer("작성자").content("내용").build();
		boardRepository.save(board);

		log.info("end...");
	}

	// 전체검색
	@Test
	@DisplayName("전체검색")
	public void test3() {
		log.info("전체 검색...");
		boardRepository.findAll().forEach(board -> log.info("board = {}", board));
	}

	// PK를 대상으로 검색
	@Test
	@DisplayName("PK검색")
	public void test4() {
		log.info("PK검색...");
		Board board = boardRepository.findById(100L).orElseThrow(() -> new RuntimeException("100번 글이 존재하지 않습니다"));

		log.info("board = {}", board);
	}

	// PK를 대상으로 수정
	@Test
	@DisplayName("PK대상 수정")
	public void test5() {
		log.info("PK대상 수정...");
		boardRepository.findById(20L).ifPresent(board -> {
			board.setTitle("제목 수정");
			board.setContent("내용 수정");
		});

		log.info("수정 완료...");
	}

	// PK를 대상으로 삭제
	@Test
	@DisplayName("PK대상 삭제")
	public void test6() {
//		boardRepository.deleteById(10L);
		boardRepository.findById(20L).ifPresent(board -> boardRepository.delete(board));
		log.info("삭제 완료...");
	}

	// 페이징 처리
	@Test
	@DisplayName("페이징 처리")
	public void test7() {
		//Pageable pageable =PageRequest.of(2, 5);// 페이지번호 0부터시작
		Pageable pageable = PageRequest.of(0, 10 , Sort.by("bno").descending());

		Page<Board> page = boardRepository.findAll(pageable);
		System.out.println("***********************************");
		System.out.println("page.getTotalElements() = "+page.getTotalElements());
		System.out.println("page.getNumber() = "+page.getNumber());
		System.out.println("page.getSize() = "+page.getSize());
		System.out.println("page.getTotalPages() = "+page.getTotalPages());
		System.out.println("page.previousPageable() = "+page.previousPageable());
		System.out.println("page.nextPageable() = "+page.nextPageable());

		System.out.println("page.isFirst() = "+page.isFirst());
		System.out.println("page.isLast() = "+page.isLast());
		System.out.println("page.hasNext() = "+page.hasNext());
		System.out.println("page.hasPrevious() = "+page.hasPrevious());
		System.out.println("***********************************");
		page.getContent().forEach(System.out::println);

		pageable = page.nextPageable();
		page = boardRepository.findAll(pageable);
		page.getContent().forEach(System.out::println);
	}
}
