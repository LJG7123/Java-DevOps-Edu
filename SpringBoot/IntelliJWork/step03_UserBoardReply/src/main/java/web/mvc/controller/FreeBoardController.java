package web.mvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.mvc.domain.FreeBoard;
import web.mvc.service.FreeBoardService;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class FreeBoardController {

	private final FreeBoardService freeBoardService;

	@GetMapping("/{url}")
	public void url() {}

	@GetMapping("/list")
	public String boardList(Model model) {
		List<FreeBoard> list = freeBoardService.selectAll();
//		Pageable pageable = PageRequest.of(0, 10);
//		List<FreeBoard> list = freeBoardService.selectAll(pageable).toList();
		log.info("list size: {}", list.size());
		model.addAttribute("freeList", list);
		return "board/list";
	}

	@PostMapping("/insert")
	public String insert(FreeBoard freeBoard) {
		freeBoardService.insert(freeBoard);
		return "redirect:/board/list";
	}

	@GetMapping("/read/{bno}")
	public String read(@PathVariable Long bno, Model model) {
		FreeBoard board = freeBoardService.selectBy(bno, true);
		model.addAttribute("board", board);
		return "board/read";
	}

	@PostMapping("/updateForm")
	public String updateForm(Model model, Long bno) {
		FreeBoard board = freeBoardService.selectBy(bno, false);
		model.addAttribute("board", board);
		return "board/update";
	}

	@PostMapping("/update")
	public String update(FreeBoard freeBoard) {
		freeBoardService.update(freeBoard);

		return "redirect:/board/read/" + freeBoard.getBno();
	}

	@PostMapping("/delete")
	public String delete(Long bno, String password) {
		log.info("delete: {}, {}", bno, password);

		freeBoardService.delete(bno, password);

		return "redirect:/board/list";
	}
}
