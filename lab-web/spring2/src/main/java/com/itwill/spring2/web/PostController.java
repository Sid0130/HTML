package com.itwill.spring2.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.spring2.domain.Post;
import com.itwill.spring2.dto.PostCreateDto;
import com.itwill.spring2.dto.PostSearchDto;
import com.itwill.spring2.dto.PostUpdateDto;
import com.itwill.spring2.service.PostService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드를 초기화할 수 있는 아규먼트를 갖는 생성자.
@Controller
@RequestMapping("/post")  // 이 컨트롤러는 이런 요청주소로 시작 주소가 post로 시작하는 주소다.
// -> PostController 클래스의 모든 메서드의 매핑 주소는 "/post"로 시작.
// -> GET/POST등 모든 요청 방식(method)을 처리. 기능별로 다 만들 수 있다
public class PostController {
	
	// final 필드와 생성자를 사용한 의존성 주입:
	private final PostService postService;
	
	@GetMapping("/list") // -> GET 방식의 /post/list 주소를 처리하는 컨트롤러 메서드.
	public void list(Model model) {
		log.debug("list()");
		// 컨트롤러 메서드의 리턴 타입이 void
		// -> 뷰의 이름: /WEB-INF/views/post/list.jsp
		
		List<Post> list = postService.read();
		model.addAttribute("posts", list); // -> 뷰에 전달할 데이터.
		
		
		// 메서드를 보이드로 만들면 
		// RequestMapping는 요청 방식을 구분하지않고
	}
	
	@GetMapping("/create")
	public void create() {
		
	}
	@PostMapping("/create")
	public String create(PostCreateDto dto) {
		log.debug("POST create(dto={})", dto);
		
		// controller ==> service 메서드 호출 & DTO를 아규먼트로 전달.
		int result = postService.create(dto);
		// 모델의 의미는 테이블과 똑같이 생긴 자바클래스 = 엔터티
		// 엔터티는 값이 변경되면 자동적으로 업데이트되버리는데 (DB에 값이 바뀜)
		// 이것에 대비해서..
		// dto 와 entity와 구분
		return "redirect:/post/list";
	}
	
	@GetMapping({"/details", "/modify"}) 
	// -> GET 방식의 /post/details와 /post/modify 요청 주소들을 처리하는 컨트롤러
	// -> 메서드의 리턴 타입이 void이므로 
	// 요청 주소가 details 일 때 뷰의 이름은 details.jsp
	// 요청 주소가 modify 일 때 뷰의 이름은 modify.jsp
	public void details(@RequestParam Integer id, Model model) {
		// 컨트롤러가 jsp에 데이터를 넘길때 모델을 사용한다.
		log.debug("details()", id);
		
		// 서비스 계층의 메서드를 호출해서 상세보기 화면에 필요한 데이터를 읽어옴.
		Post post = postService.read(id);
		// 상세보기 내용을 뷰에 전달하기 위해서 Model에 속성으로 추가.
		model.addAttribute("post",post);
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		log.debug("delete(id={})", id);
		
		postService.delete(id);
		
		// 목록 페이지로 이동(redirect)
		return "redirect:/post/list";
	}
	
	@PostMapping("/update")
	public String update(PostUpdateDto dto) {
		log.debug("update(dto={})", dto);
		
		postService.update(dto);
		
		// 상세보기 페이지로 이동(redirect).
		return "redirect:/post/details?id=" + dto.getId();
	}
	
	@GetMapping("/search")
	public String search(PostSearchDto dto, Model model) {
		log.debug("search(dto={})", dto);
		
		// 서비스 계층의 메서드를 호출해서 검색 결과 리스트를 가져옴.
		List<Post> list = postService.read(dto);
		
		// 검색 결과를 뷰에게 전달.
		model.addAttribute("posts",list); //-> list의 리스트를 el로 선언되있는 변수 이름과 같아야함.
		
		return "post/list"; //-> /WEB-INF/views/post/list.jsp
	}
}
