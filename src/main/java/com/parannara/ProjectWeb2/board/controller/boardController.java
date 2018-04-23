package com.parannara.ProjectWeb2.board.controller;

import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.parannara.ProjectWeb2.HomeController;
import com.parannara.ProjectWeb2.board.dao.boardDAO;
import com.parannara.ProjectWeb2.board.vo.Board;
import com.parannara.ProjectWeb2.common.util.FileService;
import com.parannara.ProjectWeb2.common.util.PageNavigator;


@Controller
public class boardController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	boardDAO dao;
	
	final String uploadPath = "/Users/wow90/Documents/workspace-sts-3.8.2.RELEASE/ProjectWeb1/src/main/webapp/resources/freeData";
	
	final int countPerPage = 10;
	
	final int pagePerGroup = 5;
	
	//자유게시판으로 이동, 게시판 리스트 불러오기
	@RequestMapping(value="freeBoard", method = RequestMethod.GET)
	public String toFreeBoard(Model model, @RequestParam(value="searchText", defaultValue="") String searchText,
			@RequestParam(value="page", defaultValue="1")int page) {
		logger.info("(controller)자유게시판으로 이동 시작");
		//전체 글 개수
		int total = dao.freeBoardNum(searchText);
				
		//페이지계산을 의한 객체 생성
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, page, total);
		
		//글 목록 가져오기
		ArrayList<Board> list = dao.selectAllBoard(searchText, navi.getStartRecord(), navi.getCountPerPage());
		model.addAttribute("list", list);
		model.addAttribute("searchText", searchText);
		model.addAttribute("navi", navi);
		logger.info("(controller)자유게시판으로 이동 완료");
		return "board/freeBoard";
	}
	//글 수정폼으로 이동 - 자유
	@RequestMapping(value="freeBoardUpdate", method=RequestMethod.GET)
	public String updateForm(int boardNum, Model model){
		logger.info("(controller)글 수정 폼 으로 이동 시작");
		Board board = dao.selectOneFreeBoard(boardNum);
		System.out.println(board.getBoardNum());
		model.addAttribute("boardNum", board.getBoardNum());
		model.addAttribute("title", board.getTitle());
		model.addAttribute("content", board.getContent());
		model.addAttribute("originalFile", board.getOriginalFile());
		logger.info("(controller)글 수정 폼 으로 이동 완료");
		return "board/updateForm";
	}
	
	//글쓰기 폼으로 이동
	@RequestMapping(value="writeForm", method = RequestMethod.GET)
	public String WriteForm() {
		logger.info("(controller)글 쓰기 폼 으로 이동");
		return "board/writeForm";
	}
	
	//홈페이지로 돌아가기
	@RequestMapping(value="returnHome", method = RequestMethod.GET)
	public String toMainPage() {
		logger.info("(controller)홈페이지로 이동 시작");
		return "home";
	}
	
	//자유게시판 글작성
	@RequestMapping(value="freeBoardWrite", method = RequestMethod.POST)
	public String freeBoardWrite(Board b, MultipartFile upload) {
		logger.info("(controller)자유게시판 글 작성 시작");
		if (!upload.isEmpty()) {
			String savedFile = FileService.saveFile(upload, uploadPath);
			b.setSavedFile(savedFile);
			b.setOriginalFile(upload.getOriginalFilename());
		}
		dao.writeBoard(b);
		logger.info("(controller)자유게시판 글 작성 완료");
		return "redirect:freeBoard";
	}
	
	
	//자유게시판 글 하나만 불러오기
	@RequestMapping(value="oneFreeBoard", method = RequestMethod.GET)
	public String oneFreeBoard(Model model, Board b, int boardNum) {
		logger.info("(controller)자유게시판 글 하나 불러오기 시작");
		boardNum = b.getBoardNum();
		Board board = dao.selectOneFreeBoard(boardNum);
		dao.updateFreeBoardHits(boardNum);
	
		model.addAttribute("id", board.getId());
		model.addAttribute("inputDate", board.getInputDate());
		model.addAttribute("hits", board.getHits());
		model.addAttribute("title", board.getTitle());
		model.addAttribute("content", board.getContent());
		model.addAttribute("originalFile", board.getOriginalFile());
		model.addAttribute("savedFile", board.getSavedFile());
		model.addAttribute("boardNum", board.getBoardNum());
		logger.info("(controller)자유게시판 글 하나 불러오기 완료");
		return "board/readFreeBoard";
	}
	
	
	//다운로드 파일
	@RequestMapping(value="download", method = RequestMethod.GET)
	public void fileDownload(int boardNum, HttpServletResponse response) {
		logger.info("(controller)파일 다운로드 시작");
		Board board = dao.selectOneFreeBoard(boardNum);
		
		//원래 파일명을 response header에 인코딩해서 등록
		String originalFile = board.getOriginalFile();
		try {
			response.setHeader("content-Disposition", "attachement;filename="+URLEncoder.encode(originalFile, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//outputstream을 연결
		//저장된 파일 결로
		String fullPath = uploadPath + "/" + board.getSavedFile();
		
		FileInputStream fis = null;
		ServletOutputStream sos = null;
		
		try {
			fis = new FileInputStream(fullPath);
			sos = response.getOutputStream();
			
			FileCopyUtils.copy(fis, sos);
			
			fis.close();
			sos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		logger.info("(controller)파일 다운로드 완료");
	}
	//자유게시판 글삭제
	@RequestMapping(value="deleteFreeBoard", method=RequestMethod.GET)
	public String deleteFreeBoard(int boardNum){
		logger.info("(controller)자유게시판 글 삭제 시작");
		dao.deleteFreeBoard(boardNum);
		logger.info("(controller)자유게시판 글 삭제 완료");
		return "redirect:freeBoard";
	}
	//자유게시판 글 수정
	@RequestMapping(value="updateFreeForm",method=RequestMethod.POST)
	public String updateFreeBoard(Board board){
		logger.info("(controller)자유게시판 글 수정 시작");
		dao.updateFreeBoard(board);
		logger.info("(controller)자유게시판 글 수정 완료");
		return "redirect:freeBoard";
	}
	
	
	
}
