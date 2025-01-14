package com.itwill.spring2.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.spring2.domain.Member;
import com.itwill.spring2.dto.MemberSignInDto;
import com.itwill.spring2.dto.MemberSignUpDto;
import com.itwill.spring2.service.MemberService;
import com.itwill.spring2.service.PostService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// 회원가입, 로그인, 로그아웃 컨트롤러
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class MemberController {
	
	// final 필드와 생성자를 사용한 의존성 주입.
	private final MemberService memberService;
	
	@GetMapping("/signout")
	public String signOut(HttpSession session) { // 디스패쳐 서블릿이 리퀘스트를 통해서 세션을 찾고 세션 객체를 넘겨줌.
		log.debug("signOut()");
		
		// 로그아웃 - 세션에 저장된 로그인 정보를 지움. 세션을 무효화(invalidate).
		session.removeAttribute("signedInUser");
		session.invalidate();
		
		// 로그아웃 이후에 로그인 페이지로 이동(redirect)
		return "redirect:/user/signin";
	}
	
	
	@GetMapping("/signin")
	public void signIn() {
		log.debug("[GET] signIn()");
	}
	
	@PostMapping("/signin")
	public String signIn(MemberSignInDto dto, HttpSession session) { // 클라이언트에서 요청이오면 세션 객체를 컨트롤러에 연결, 파라미터만 넣어주면됨
		
		Member member = memberService.read(dto);
		
		String targetPage = null;
		if (member != null) {
			// username과 password가 일치하는 사용자가 DB에 있는 경우 - 로그인 성공.
			
			// 로그인 사용자 정보를 세션에 저장.
			session.setAttribute("signedInUser", member.getUsername());
			
			// 로그인 성공 이후 이동할 페이지 설정.
			targetPage = "/";
		} else {
			// username과 password가 일치하는 사용자가 DB에 없는 경우 - 로그인 실패.
			// 로그인 실패인 경우 다시 로그인 페이지로 이동하도록 설정.
			targetPage = "/user/signin?result=f";
		}
		
		return "redirect:" + targetPage;
	}
	
	@GetMapping("/signup")
	public void signUp() {
		log.debug("[GET] signUp()");

	}
	@PostMapping("/signup")
	public String signUp(MemberSignUpDto dto) {
		log.debug("[POST] signUp(dto = {})",dto);
		
		int result = memberService.create(dto);
		
		// 회원 가입 성공 이후에는 로그인 페이지로 이동
		return "redirect:/user/signin";
		
	}
	
	// API 테스터로 테스트하기 구글 확장 프로그램.
	// username 중복체크 
	// 중복되지 않은 username이면 "Y", 중복된 username이면 "N"을 전송(응답).
	@GetMapping("/checkusername")
	@ResponseBody // 반드시 @Controller에 사용
	public ResponseEntity<String> checkUsername(@RequestParam String username) {
		log.debug("checkUsername(username={})", username);
		boolean result = memberService.checkUsername(username);
		
		if(result) {
			return ResponseEntity.ok("Y"); // 중복되지 않은
		} else {
			return ResponseEntity.ok("N"); // 중복된
		}
	}
	
	// email 중복체크
	// 중복되지 않은 email이면 "Y", 중복된 email이면 "N"을 전송(응답).
	@GetMapping("checkemail")
	@ResponseBody
	public ResponseEntity<String> checkEmail(@RequestParam String email){
		log.debug("checkEmail(email={})",email);
		boolean result = memberService.checkEmail(email);
		
		return result ? ResponseEntity.ok("Y") : ResponseEntity.ok("N");
		
//		if (result) {
//			return ResponseEntity.ok("Y");
//		} else {
//			return ResponseEntity.ok("N");
//		}
			
	}

}
