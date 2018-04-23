package com.parannara.ProjectWeb2.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.parannara.ProjectWeb2.HomeController;
import com.parannara.ProjectWeb2.board.vo.Board;


@Repository
public class boardDAO {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	SqlSession sqlSession;
	//자유게시판 글쓰기
	public void writeBoard(Board b) {
		logger.info("(DAO)자유게시판 글쓰기 시작");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		
		try {
			mapper.writeBoard(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("(DAO)자유게시판 글쓰기 완료");
	}
	//음악게시판 글작성
	public void writeMusicBoard(Board board) 
		{
		logger.info("(DAO)음악게시판 글쓰기 시작");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		
		try {
			mapper.writeMusicBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("(DAO)음악게시판 글쓰기 완료");
	}
	//자유게시판 리스트 생성
	public ArrayList<Board> selectAllBoard(String searchText, int startRecord, int countPerPage) {
		logger.info("(DAO)자유게시판 리스트 불러오기 시작");
		ArrayList<Board> boardList = null;
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		
		RowBounds rb = new RowBounds(startRecord, countPerPage);
		try {
			boardList = mapper.selectAllBoard(searchText, rb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("(DAO)자유게시판 리스트 불러오기 완료");
		return boardList;
	}
	
	//음악게시판 리스트 생성
	public ArrayList<Board> selectAllMusicBoard() {
		logger.info("(DAO)음악게시판 리스트 불러오기 시작");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		ArrayList<Board> list = null;
		try {
			list = mapper.selectAllMusicBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("(DAO)음악게시판 리스트 불러오기 완료");
		return list;
	}
	//자유게시판 글개수 파악
	public int freeBoardNum() {
		logger.info("(DAO)자유게시판 글 개수 파악 시작");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		int result = 0;
		try {
			result = mapper.freeBoardNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("(DAO)자유게시판 글 개수 파악 완료");
		return result;
	}

	//자유게시판 하나만 글 불러오기
	public Board selectOneFreeBoard(int boardNum) {
		logger.info("(DAO)자유게시판 글 하나 불러오기 시작");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		Board board = null;
		try {
			board = mapper.selectOneFreeBoard(boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("(DAO)자유게시판 글 하나 불러오기 완료");
		return board;
	}
	//음악게시판 하나만 글 불러오기
	public Board selectOneMusicBoard(int boardNum) {
		logger.info("(DAO)음악게시판 글 하나 불러오기 시작");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		Board board = null;
		try {
			board = mapper.selectOneMusicBoard(boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("(DAO)음악게시판 글 하나 불러오기 완료");
		return board;
	}
	//총 게시글 숫자-자유
	public int freeBoardNum(String searchText) {
		logger.info("전체 글 개수 시작");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		int total = 0;
		try{
			total = mapper.freeBoardNum(searchText);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		logger.info("전체 글 개수 종료");
		return total;
	}
	//총 게시글 숫자-자유
	public int musicBoardNum(String searchText) {
		logger.info("전체 글 개수 시작");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		int total = 0;
		try{
			total = mapper.musicBoardNum(searchText);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		logger.info("전체 글 개수 종료");
		return total;
	}
	
	//조회수 1상승-자유
	public void updateFreeBoardHits(int boardNum){
		logger.info("(DAO)히트수 1올림 시작");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		
		try {
			mapper.updateFreeBoardHits(boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("(DAO)히트수 1올림 시작");
	}
	//조회수 1상승-음악
	public void updateMusicBoardHits(int boardNum){
		logger.info("(DAO)히트수 1올림 시작");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		
		try {
			mapper.updateMusicBoardHits(boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("(DAO)히트수 1올림 시작");
	}
	//게시글 삭제-자유
	public void deleteFreeBoard(int boardNum){
		logger.info("(DAO)게시글 삭제");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		try {
			mapper.deleteFreeBoard(boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("(DAO)게시글 삭제");
	}
	//게시글 삭제-음악
	public void deleteMusicBoard(int boardNum) {
		logger.info("(DAO)음악-게시글 삭제");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		try {
			mapper.deleteMusicBoard(boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("(DAO)음악-게시글 삭제");
	}
	//이미지 전부 불러오기-음악
	public Board imgSelecter(int boardNum) {
		logger.info("(DAO)음악-이미지주소 셀렉터 시작");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		Board board = null;
		try {
			board = mapper.imgSelecter(boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("(DAO)음악-이미지주소 셀렉터 시작");
		return board;
	}
	//동영상 전부 불러오기-음악
	public Board videoSelecter(int boardNum) {
		logger.info("(DAO)음악-동영상주소 셀렉터 시작");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		Board board = null;
		try {
			board = mapper.videoSelecter(boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("(DAO)음악-동영상주소 셀렉터 시작");
		return board;
	}
	//자유게시판 글수정
	public void updateFreeBoard(Board board){
		logger.info("(DAO)자게-자유게시판 글수정 시작");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		try {
			mapper.updateFreeBoard(board);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("(DAO)자게-자유게시판 글수정 완료");
	}
	//음악게시판 수정
	public void modifyMusic(Board board){
		logger.info("(DAO)음악게시판 글수정 시작");
		boardMapper mapper = sqlSession.getMapper(boardMapper.class);
		try {
			mapper.modifyMusic(board);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("(DAO)음악게시판 글수정 완료");
	}
}
