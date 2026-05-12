package kosta.web.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rem")
public class RequestMappingController {
	/**
	 * 
	 * @return : String을 리턴하면 viewName이 된다
	 */
	@RequestMapping("/a.do")
	public String aaa() {
		System.out.println("RequestMappingController a.do 요청됨");
		return "result"; // WEB-INF/view/result.jsp
	}
	
	/**
	 * @return : void인 경우는 요청한 url주소가 View의 이름이 된다
	 * ex) /rem/b.do라고 요청하면 /WEB-INF/views/rem/b.jsp로 이동
	 * 
	 * 여러개의 요청이 하나의 메소드를 실행할 때 {}안에 작성한다
	 * 
	 * @param : Model객체를 받고 Model에 정보를 저장하면
	 * 			 그 객체가 뷰쪽에 전달되고 뷰에서 ${}로 사용
	 */
	@RequestMapping({"/b.do", "/c.do"})
	public void bbb(Model model) {
		System.out.println("RequestMappingController bbb() 호출됨");
		model.addAttribute("hobbies", Arrays.asList("등산", "낚시", "골프"));
		model.addAttribute("info", "점심 메뉴는?");
	}
	
	/**
	 * 요청방식 (get or post 요청 처리하기)
	 * 
	 * @GetMapping
	 * @PostMapping
	 * @PutMapping / @PatchMapping
	 * @DeleteMapping
	 */
//	@RequestMapping("/test.do")
//	@GetMapping("/test.do") // get방식 전용
	@PostMapping("/test.do") // post방식 전용
	public ModelAndView test(HttpServletRequest req) {
		String name = req.getParameter("name");
		System.out.println("이름 = " + name);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("message" , "spring연습");
		mv.addObject("age" , 100);
		
		return mv;
	}
	
	/**
	 * parameter의 정보에 따라 메소드 호출 여부
	 */
	@GetMapping(value="/a.do", params="id")
	public String test2(String id) {
		System.out.println("id = " + id);
		return "result";
	}
	
}
