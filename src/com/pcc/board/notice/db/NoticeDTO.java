package com.pcc.board.notice.db;

import java.sql.Timestamp;

// 게시판 관련 정보 객체

public class NoticeDTO {
	private int notice_num;					// 게시판 글 번호(글식별자)
	private int mgr_num;					// 매니저 번호(매니저식별자) -> 모든 게시판에 사용
	private String notice_subject;			// 글 제목
	private String notice_content;			// 글 내용
	private int notice_readcount;			// 글 조회수
	private Timestamp notice_date;			// 글 작성시간 -> sql에 디폴트로 now() 되어있음.
	private  String notice_file;			// 첨부파일
	
	public int getNotice_num() {
		return notice_num;
	}
	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}
	public int getMgr_num() {
		return mgr_num;
	}
	public void setMgr_num(int mgr_num) {
		this.mgr_num = mgr_num;
	}
	public String getNotice_subject() {
		return notice_subject;
	}
	public void setNotice_subject(String notice_subject) {
		this.notice_subject = notice_subject;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public int getNotice_readcount() {
		return notice_readcount;
	}
	public void setNotice_readcount(int notice_readcount) {
		this.notice_readcount = notice_readcount;
	}
	public Timestamp getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(Timestamp notice_date) {
		this.notice_date = notice_date;
	}
	public String getNotice_file() {
		return notice_file;
	}
	public void setNotice_file(String notice_file) {
		this.notice_file = notice_file;
	}
	
	@Override
	public String toString() {
		return "NoticeBoardDTO [notice_num=" + notice_num + ", mgr_num=" + mgr_num + ", notice_subject="
				+ notice_subject + ", notice_content=" + notice_content + ", notice_readcount=" + notice_readcount
				+ ", notice_date=" + notice_date + ", notice_file=" + notice_file + "]";
	}
	
}
