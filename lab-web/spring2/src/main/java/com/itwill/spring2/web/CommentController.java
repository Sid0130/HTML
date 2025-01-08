package com.itwill.spring2.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.spring2.domain.Comment;
import com.itwill.spring2.dto.CommentItemDto;
import com.itwill.spring2.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // 필수 아규먼트 생성자
@RestController //-> 컨트롤러 메서드의 리턴 값이 뷰의 이름이 아니라 클라이언트로 직접 응답되는 데이터.
@RequestMapping("/api/comment")
public class CommentController {
	
	// final 필드와 (필수 아규먼트를 갖는) 생성자를 이용한 의존성 주입
	private final CommentService commentService;
	
	@GetMapping("/{id}")
	//-> 요청 주소가 변수처럼 변할 수 있는 값(path variable)일 때, {varName} 형식으로 작성.
	public ResponseEntity<CommentItemDto> getCommentById(@PathVariable Integer id) {
		//PathVariable: 요청 URI에 포함되어있는 변수. 
		// @PathVariable: 요청 주소의 일부가 변수처럼 변할 수 있는 값일 때, (요청 주소를 분석하는것은 디스패쳐 서블릿)
		// 디스패쳐 서블릿이 요청 주소를 분석해서 메서드의 아규먼트로 전달해줌.	
		// (1) @PathVariable(name = "id") 처럼 경로 변수(path variable)의 이름을 명시하거나,
        // (2) 메서드의 파라미터 이름을 경로 변수와 동일하게 선언하면 됨.
		// (Eclipse) Window -> Preferences -> Java -> Compiler ->
        // "Store information about method parameters (usable via reflection)" 항목을 체크해야 함.
		log.debug("getCommentById(id={})", id);
		
		CommentItemDto comment = commentService.readById(id);
		
		return ResponseEntity.ok(comment); 
		// 리스폰스 엔터티로 응답을 조절가능하다 ResponseEntity를 안쓰거나 ok면 널이든 아니든 200 성공으로 나왔는데
		// 어떤메서드를 이용하더라도 응답이 200이 될수도 400이 될수도 조절할 수 있는 메서드

		// ResponseEntity<T>
		// 서버가 클라이언트와 보내는 데이터와 응답코드를 함께 설정할 수 있는 객체
		
		// REST 컨트롤러 메서드가 자바 객체를 리턴하면
        // jackson-databind 라이브러리가 자바 객체를 JSON 문자열로 변환을 담당하고,
        // JSON 문자열이 클라이언트로 전송(응답)됨.
        // jackson-databind 라이브러리의 역할:
        //   1. 직렬화(serialization): 자바 객체 -> JSON (문자열)
        //   2. 역직렬화(de-serialization): JSON -> 자바 객체
        // jackson-databind 라이브러리에서 
        // Java 8 이후에 생긴 날짜/시간 타입(LocalDate, LocalDateTime)을 JSON으로 변환하기 위해서는
        // jackson-datatype-jsr310 모듈이 필요함(POM.xml에 dependency 추가).
		
		
				
	}
}
