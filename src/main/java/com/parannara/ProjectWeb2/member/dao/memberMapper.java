package com.parannara.ProjectWeb2.member.dao;

import com.parannara.ProjectWeb2.member.vo.Member;

public interface memberMapper {
	//회원가입
	public int joinMember(Member member);
	//아이디중복 확인
	public Member searchId(String memberId);
	//회원정보 업데이트
	public void update(Member member);
}
