package com.parannara.ProjectWeb2.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import com.parannara.ProjectWeb2.board.vo.Board;

public interface boardMapper {
	//자유게시판 글작성
	public void writeBoard(Board board);
	//음악게시판 글작성
	public void writeMusicBoard(Board board);
	//자유게시판 글 불러오기
	public ArrayList<Board> selectAllBoard(String searchText, RowBounds rb);
	//음악게시판 글 불러오기 위해 모든 글 개수 파악
	public int freeBoardNum();
	//음악게시판 글 불러오기
	public ArrayList<Board> selectAllMusicBoard();
	//자유게시판 글 하나만 불러오기
	public Board selectOneFreeBoard(int boardNum);
	//음악게시판 글 하나만 불러오기
	public Board selectOneMusicBoard(int boardNum);
	//자유게시판 글개수 불러오기
	public int freeBoardNum(String searchText);
	//조회수 1상승-자유게시판
	public void updateFreeBoardHits(int boardNum);
	//조회수 1 상승-음악게시판
	public void updateMusicBoardHits(int boardNum);
	//게시글 삭제-자유게시판
	public void deleteFreeBoard(int boardNum);
	//게시글 삭제-음악게시판
	public void deleteMusicBoard(int boardNum);
	//이미지 불러오기 -음악
	public Board imgSelecter(int boardNum);
	//동영상 불러오기 -음악
	public Board videoSelecter(int boardNum);
	//자유게시판 글수정
	public void updateFreeBoard(Board board);
	//음악게시판 글수정
	public void modifyMusic(Board board);
	//음악게시판 글개수 불러오기
	public int musicBoardNum(String searchText);
	
}
