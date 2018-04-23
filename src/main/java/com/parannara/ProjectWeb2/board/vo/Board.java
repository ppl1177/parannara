package com.parannara.ProjectWeb2.board.vo;

public class Board {
	private int boardNum;
	private String id;
	private String title;
	private String content;
	private String inputDate;
	private String hits;
	private String originalFile;
	private String savedFile;
	private int deleteInfo;
	private String screenShot;
	private String savePicFile;
	public Board() {
	}
	public Board(int boardNum, String id, String title, String content, String inputDate, String hits,
			String originalFile, String savedFile, int deleteInfo, String screenShot, String savePicFile) {
		this.boardNum = boardNum;
		this.id = id;
		this.title = title;
		this.content = content;
		this.inputDate = inputDate;
		this.hits = hits;
		this.originalFile = originalFile;
		this.savedFile = savedFile;
		this.deleteInfo = deleteInfo;
		this.screenShot = screenShot;
		this.savePicFile = savePicFile;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	public String getHits() {
		return hits;
	}
	public void setHits(String hits) {
		this.hits = hits;
	}
	public String getOriginalFile() {
		return originalFile;
	}
	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}
	public String getSavedFile() {
		return savedFile;
	}
	public void setSavedFile(String savedFile) {
		this.savedFile = savedFile;
	}
	public int getDeleteInfo() {
		return deleteInfo;
	}
	public void setDeleteInfo(int deleteInfo) {
		this.deleteInfo = deleteInfo;
	}
	public String getScreenShot() {
		return screenShot;
	}
	public void setScreenShot(String screenShot) {
		this.screenShot = screenShot;
	}
	public String getSavePicFile() {
		return savePicFile;
	}
	public void setSavePicFile(String savePicFile) {
		this.savePicFile = savePicFile;
	}
	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", inputDate=" + inputDate + ", hits=" + hits + ", originalFile=" + originalFile + ", savedFile="
				+ savedFile + ", deleteInfo=" + deleteInfo + ", screenShot=" + screenShot + ", savePicFile="
				+ savePicFile + "]";
	}
	
	
}	