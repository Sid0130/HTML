package com.itwill.spring2.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.spring2.domain.Member;
import com.itwill.spring2.service.MemberService;
import com.itwill.spring2.service.PostService;

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
	
	@GetMapping("/signup")
	public void signUp() {
		log.debug("[GET] signUp()");

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
