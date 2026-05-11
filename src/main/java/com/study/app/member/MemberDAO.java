package com.study.app.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 아이디 중복확인
	public int getId(String id) {
		System.out.println("DAO" + id);
		return mybatis.selectOne("Member.getId", id);
	}
	
	// 회원가입
	public void join(MemberDTO dto) {
		System.out.println("비밀번호" + dto.getPw());
		mybatis.insert("Member.join", dto);
	}

	// 로그인
	public MemberDTO login(LoginDTO dto) {
		return mybatis.selectOne("Member.login", dto);
	}
	

	

}
