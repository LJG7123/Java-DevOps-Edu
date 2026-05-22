package web.mvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.mvc.domain.FreeBoard;
import web.mvc.domain.Reply;
import web.mvc.service.ReplyService;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {

	private final ReplyService replyService;

	@PostMapping("/writeForm")
	public String writeFrom(Long bno, Model model) {
		model.addAttribute("bno", bno);
		return "reply/write";
	}

	@PostMapping("/insert")
	public String insert(Long bno, Reply reply) {
		reply.setFreeBoard(FreeBoard.builder().bno(bno).build());
		replyService.insert(reply);

		return "redirect:/board/read/" + bno;
	}

	@GetMapping("/delete/{rno}/{bno}")
	public String delete(@PathVariable Long rno, @PathVariable Long bno) {
		replyService.delete(rno);

		return "redirect:/board/read/" + bno;
	}
}
