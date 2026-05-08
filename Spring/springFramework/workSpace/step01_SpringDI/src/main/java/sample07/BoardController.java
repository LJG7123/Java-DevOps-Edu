package sample07;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller("controller") //<bean class="BoardController" id="controller" />
@RequiredArgsConstructor // final field 또는 @NonNull이 선언된 필드를 기준으로 생성자를 만든다.
public class BoardController {
	
	private final BoardService boardService; // final 필드는 초기화 필수 (명시적 초기화 or 생성자 이용)
	
	@Autowired
	private BoardDTO boardDto;
	
	@Autowired
	private BoardDTO boardDto2;
	
//	public BoardController(BoardService boardService) {
//		System.out.println("BoardController 생성자");
//		this.boardService = boardService;
//	}
	
	@PostConstruct
	public void init() {
		System.out.println("boardDto = " + boardDto);
		System.out.println("boardDto2 = " + boardDto2);
	}
	
	public void test() {
		System.out.println("BoardController test call");
		
		boardService.select();
	}
	

}
