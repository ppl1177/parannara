package com.parannara.ProjectWeb2.board.controller;

import java.io.File;
import java.io.FileInputStream;

import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.parannara.ProjectWeb2.HomeController;
import com.parannara.ProjectWeb2.board.dao.boardDAO;
import com.parannara.ProjectWeb2.board.vo.Board;
import com.parannara.ProjectWeb2.common.util.FileService;
import com.parannara.ProjectWeb2.common.util.PageNavigator;

@Controller
public class musicBoardController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	boardDAO dao;
	
	final String uploadPath = "/Users/wow90/Documents/workspace-sts-3.8.2.RELEASE/ProjectWeb1/src/main/webapp/resources/musicData";
	
	final int countPerPage = 5;
	
	final int pagePerGroup = 5;
	
		//비디오 실행 Ajax

		@RequestMapping(value = "loadVideoFile", method = RequestMethod.GET)
		@ResponseBody public void loadVideoFile(HttpServletResponse response, HttpSession session) {
			logger.info("(controller)비디오 로드 컨트롤러 시작, Ajax");
			int boardNum = (int) session.getAttribute("sessionNum");
			Board board = dao.videoSelecter(boardNum);
			String fileName = board.getSavedFile();
			
			try 
			{           
			String filePath = "C://Users/wow90/Documents/workspace-sts-3.8.2.RELEASE/ProjectWeb1/src/main/webapp/resources/musicData/"+fileName;        
	        int fileSize = (int) new File(filePath).length();
	        response.setContentLength(fileSize);
	        response.setContentType("video/quicktime");
	        FileInputStream inputStream = new FileInputStream(filePath);
	        ServletOutputStream outputStream = response.getOutputStream();
	        int value = IOUtils.copy(inputStream, outputStream);
	        System.out.println("File Size :: "+fileSize);
	        System.out.println("Copied Bytes :: "+value);
	        IOUtils.closeQuietly(inputStream);
	        IOUtils.closeQuietly(outputStream);
	        response.setStatus(HttpServletResponse.SC_OK);
	    	} 
	    	catch (java.io.FileNotFoundException e) {         
	        response.setStatus(HttpStatus.NOT_FOUND.value());
	    	} 
	    	catch (Exception e) 
	    	{         
	        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    	}
			logger.info("(controller)비디오 로드 컨트롤러 완료, Ajax");
		}
		
		
		//음악게시판으로 이동, 게시판 리스트 불러오기
		@RequestMapping(value="musicBoard", method = RequestMethod.GET)
		public String toMusicBoard(Model model, HttpServletRequest request, HttpServletResponse response,  @RequestParam(value="searchText", defaultValue="") String searchText,
				@RequestParam(value="page", defaultValue="1")int page){
			logger.info("(controller)음악게시판으로 이동/게시판리스트 불러오기 시작");
			
			int total = dao.musicBoardNum(searchText);
			
			//페이지계산을 의한 객체 생성
			PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, page, total);
			
			
			ArrayList<Board> list = dao.selectAllMusicBoard();
			model.addAttribute("list", list);
			model.addAttribute("searchText", searchText);
			model.addAttribute("navi", navi);
			logger.info("(controller)음악게시판으로 이동/게시판리스트 불러오기 완료");
			 
			return "board/musicBoard";
		}
		//음악게시판 글쓰기이동
		@RequestMapping(value="musicWriteForm", method = RequestMethod.GET)
		public String MusicWriteForm() {
			logger.info("(controller)음악게시판 글쓰기폼으로 이동");
			return "board/musicWriteForm";
		}
		//음악게시판 글수정
		@RequestMapping(value="modifyMusic",method=RequestMethod.POST)
		public String modifyMusicBoard(Board board){
			logger.info("(controller)음악게시판 글 수정 시작");
			dao.modifyMusic(board);
			logger.info("(controller)음악게시판 글 수정 시작");
			return "redirect:musicBoard";
		}
		//음악게시판 글수정 폼 이동
		@RequestMapping(value="updateMusicBoard",method=RequestMethod.GET)
		public String toMusicUpdateForm(Board board, int boardNum, Model model){
			board = dao.selectOneMusicBoard(boardNum);
			model.addAttribute("title", board.getTitle());
			model.addAttribute("content", board.getContent());
			model.addAttribute("boardNum", boardNum);
			model.addAttribute("originalFile", board.getOriginalFile());
			model.addAttribute("screenShot", board.getScreenShot());
			
			return "board/updateMusicForm";
		}
		//음악게시판 글 작성
		@RequestMapping(value= "mBoardWrite", method = RequestMethod.POST)
		public String musicBoardWrite(Board b, MultipartFile upload, MultipartFile uploadPic) {

			logger.info("(controller)음악게시판 글 작성 시작");
			if (!upload.isEmpty()) {
				String savedFile = FileService.saveFile(upload, uploadPath);
				b.setSavedFile(savedFile);
				b.setOriginalFile(upload.getOriginalFilename());
			}
			if (!uploadPic.isEmpty()) {
				String screenShot = FileService.saveFile(uploadPic, uploadPath);
				b.setSavePicFile(screenShot);
				b.setScreenShot(uploadPic.getOriginalFilename());

			}
							
			dao.writeMusicBoard(b);
			logger.info("(controller)음악게시판 글 작성 완료");
			return "redirect:musicBoard";
		}
		//음악 게시판 글 하나만 불러오기
		@RequestMapping(value = "oneMusicBoard", method = RequestMethod.GET)
		public String oneMusicBoard(Model model, Board b, int boardNum, HttpSession session) {
			logger.info("(controller)음악게시판 글 하나만 불러오기 시작");
			boardNum = b.getBoardNum();
			Board board = dao.selectOneMusicBoard(boardNum);
			session.setAttribute("sessionNum", boardNum);
			model.addAttribute("id", board.getId());
			model.addAttribute("inputDate", board.getInputDate());
			model.addAttribute("hits", board.getHits());
			model.addAttribute("title", board.getTitle());
			model.addAttribute("content", board.getContent());
			model.addAttribute("originalFile", board.getOriginalFile());
			model.addAttribute("savedFile", board.getSavedFile());
			model.addAttribute("boardNum", board.getBoardNum());
			dao.updateMusicBoardHits(boardNum);
			
			logger.info("(controller)음악게시판 글 하나만 불러오기 완료"+session.getAttribute("sessionNum"));
			return "board/readMusicBoard";
		}
		
		//음악게시판 글삭제
		@RequestMapping(value="deleteMusic", method=RequestMethod.GET)
		public String deleteMusicBoard(int boardNum){
			System.out.println(boardNum);
			System.out.println(boardNum);
			System.out.println(boardNum);
			System.out.println(boardNum);
			dao.deleteMusicBoard(boardNum);
			
			return "redirect:musicBoard";
		}
		//다운로드 파일-영상
		@RequestMapping(value="mDownload", method = RequestMethod.GET)
		
		public void fileDownload(int boardNum, HttpServletResponse response) {
			logger.info("(controller)음악게시판 자료 다운로드 시작");
			
			Board board = dao.selectOneMusicBoard(boardNum);
			
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
			logger.info("(controller)음악게시판 자료 다운로드 완료");		
		}
		//다운로드파일-이미지
		@RequestMapping(value="imgDownload", method = RequestMethod.GET)
		public void imgFileDownload(int boardNum, HttpServletResponse response) {
			logger.info("(controller)음악게시판 자료 다운로드 시작");
			
			Board board = dao.imgSelecter(boardNum);
			
			//원래 파일명을 response header에 인코딩해서 등록
			String originalFile = board.getScreenShot();
			try {
				response.setHeader("content-Disposition", "attachement;filename="+URLEncoder.encode(originalFile, "UTF-8"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//outputstream을 연결
			//저장된 파일 결로
			String fullPath = uploadPath + "/" + board.getSavePicFile();
			
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
			logger.info("(controller)음악게시판 자료 다운로드 완료");		
		}
}
