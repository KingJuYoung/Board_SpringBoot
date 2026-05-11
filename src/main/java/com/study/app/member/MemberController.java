package com.study.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.app.commons.JWTUtil;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberserv;
	
	@Autowired
	private JWTUtil jwt;
	
	// 로그인 중복확인
	@GetMapping("dupleCheck")
	public ResponseEntity<Boolean> getId(@RequestParam String id){
		Boolean count = memberserv.getId(id);
		System.out.println("id" + id);
		return ResponseEntity.ok(count);
	}
	
	// 회원가입
	@PostMapping
	public ResponseEntity<Void> join(@RequestBody MemberDTO dto){
		memberserv.join(dto);
		return ResponseEntity.ok().build();
	}
	
	// 로그인
	@PostMapping("login")
	public ResponseEntity<MemberDTO> login(@RequestBody LoginDTO dto) {
		
		MemberDTO member = memberserv.login(dto);
		
			return ResponseEntity.ok(member);
	}


}
