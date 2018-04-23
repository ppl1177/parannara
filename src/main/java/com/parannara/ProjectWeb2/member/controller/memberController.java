package com.parannara.ProjectWeb2.member.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.parannara.ProjectWeb2.HomeController;
import com.parannara.ProjectWeb2.member.dao.memberDAO;
import com.parannara.ProjectWeb2.member.vo.Member;

@Controller
public class memberController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
		memberDAO dao;
	//회원가입 폼으로 이동
	@RequestMapping(value="join",method=RequestMethod.GET)
	
	public String joinForm() {
		logger.info("회원가입 폼으로 이동");
		return "member/joinForm";
	}
	//로그인 관리
	@RequestMapping (value="loginMember", method=RequestMethod.POST)
	public String login(String memberId, String password, Model model, HttpSession session) {
		
			Member member = dao.searchId(memberId);
		
		if (member != null && member.getPassword().equals(password)) {
			session.setAttribute("sessionId", member.getMemberId());
			session.setAttribute("sessionName", member.getName());
			return "redirect:/";
		}
		else {
			model.addAttribute("errorMsg", "ID 또는 비밀번호가 틀립니다.");
			return "member/loginForm";
		}
	}
	//개인정보 변경 폼으로 이동
		@RequestMapping(value = "updateForm", method = RequestMethod.GET)
		public String updateForm(Member m, Model model, HttpSession session) {
			String id = (String) session.getAttribute("sessionId");
			Member member = dao.searchId(id);
			model.addAttribute("memberId", member.getMemberId());
			model.addAttribute("name", member.getName());
			model.addAttribute("email", member.getEmail());
			model.addAttribute("phoneNum", member.getPhoneNum());
			model.addAttribute("address", member.getAddress());
			
			return "member/updateForm";
		}
	//회원정보 업데이트 
	@RequestMapping(value="update", method = RequestMethod.POST)
		public String update(HttpSession session, Member m) {
			Member member = m;
			System.out.println(member);
			dao.update(member);
			return "redirect:/";
		}
	//아이디 체크 폼으로 이동
	@RequestMapping(value="idCheck", method = RequestMethod.GET)
	public String idCheck(Model model) {
		logger.info("아이디 중복 체크 폼으로 이동 시작");
		model.addAttribute("search", false);
		logger.info("아이디 중복 체크 폼으로 이동 완료");
		return "member/idCheckForm";
	}
	//로그인 폼으로 이동
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("로그인 폼으로 이동");
		return "member/loginForm";
	}
	//아이디 중복확인
	@RequestMapping(value="searchId", method = RequestMethod.POST)
	public String searchId(Model model, Member m) {
		logger.info("아이디 중복 체크 시작");
		String memberId = m.getMemberId();
		m = null;
		m = dao.searchId(memberId);
		model.addAttribute("search", true);
		model.addAttribute("member", m);
		model.addAttribute("memberId", memberId);
		logger.info("아이디 중복 체크 완료");
		return "member/idCheckForm";
	}
	//회원가입
	@RequestMapping(value="joinMember", method=RequestMethod.POST)
	public String joinMember(Member m) {
		logger.info("회원가입 시작");
		int result = dao.joinMember(m);
		if (result == 0) {
			logger.info("회원가입 실패");
			return "redirect:join";
		}
		logger.info("회원가입 완료");
		return "redirect:/";
	}

	//로그아웃
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
