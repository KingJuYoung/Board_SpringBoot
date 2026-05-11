package com.study.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	// 아이디 중복체크
	public Boolean getId(String id) {
		return memberDAO.getId(id) > 0;
	}

	// 회원가입
	public void join(MemberDTO dto) {
		memberDAO.join(dto);
	}

	// 로그인
	public MemberDTO login(LoginDTO dto) {
		return memberDAO.login(dto);
	}

}
