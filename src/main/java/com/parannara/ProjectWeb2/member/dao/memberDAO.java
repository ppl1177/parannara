package com.parannara.ProjectWeb2.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.parannara.ProjectWeb2.member.vo.Member;

@Repository
public class memberDAO {

	@Autowired
	SqlSession sqlSession;
	//회원가입 DAO, 가입 성공 실패 result로 반환
	public int joinMember(Member member) {
		memberMapper mapper = sqlSession.getMapper(memberMapper.class);
		int result = 0;
		try {
			result = mapper.joinMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//아이디 중복확인
	public Member searchId(String memberId) {
		memberMapper mapper = sqlSession.getMapper(memberMapper.class);
		Member member = null;
		
		try {
			member = mapper.searchId(memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	//회원정보 업데이트
	public void update(Member member) {
		memberMapper mapper = sqlSession.getMapper(memberMapper.class);
		
		try {
			mapper.update(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
