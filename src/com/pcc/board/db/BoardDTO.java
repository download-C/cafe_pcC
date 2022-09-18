package com.pcc.board.db;

import java.sql.Timestamp;

// 게시판 관련 정보 객체

public class BoardDTO {
	private int board_num;					// 게시판 글 번호(글식별자)
	private int mem_num;					// 회원 번호(회원식별자) -> 게시판 타입이 고객도 쓸 수 있는 리뷰나 QnA일 경우 사용
	private int board_type;					// 게시판 타입 -> 1:공지사항, 2:QnA, 3:리뷰
	private int writer_type;				// 글 작성자 타입 -> 관리자일 경우 9로 시작, 일반 회원은 20으로 시작(회원번호가 가입한 날짜를 기반으로 생성됨)
	private int board_password;				// 글 비밀번호
	private String subject;					// 글 제목
	private String content;					// 글 내용
	private int readcount;					// 글 조회수
	private int re_ref;						// 답글 그룹번호 -> 특정 글에 답글이 달릴 경우 모두 같은 그룹
	private int re_lev;						// 답글 레벨 -> 일반 글은 0, 그 글의 답글은 1, 답글의 답글일 경우는 2 
	private int re_seq;						// 답글 순서 -> 같은 레벨의 답글일 경우 먼저 작성된 글의 숫자가 더 작음
	private Timestamp board_datetime;	// 글 작성시간 -> sql에 디폴트로 now() 되어있음.
	private String ip;
	private  String file;
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public int getBoard_type() {
		return board_type;
	}
	public void setBoard_type(int board_type) {
		this.board_type = board_type;
	}
	public int getWriter_type() {
		return writer_type;
	}
	public void setWriter_type(int writer_type) {
		this.writer_type = writer_type;
	}
	public int getBoard_password() {
		return board_password;
	}
	public void setBoard_password(int board_password) {
		this.board_password = board_password;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getRe_ref() {
		return re_ref;
	}
	public void setRe_ref(int re_ref) {
		this.re_ref = re_ref;
	}
	public int getRe_lev() {
		return re_lev;
	}
	public void setRe_lev(int re_lev) {
		this.re_lev = re_lev;
	}
	public int getRe_seq() {
		return re_seq;
	}
	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}
	public Timestamp getBoard_datetime() {
		return board_datetime;
	}
	public void setBoard_datetime(Timestamp board_datetime) {
		this.board_datetime = board_datetime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "boardDTO [board_num=" + board_num + ", mem_num=" + mem_num + ", board_type=" + board_type
				+ ", writer_type=" + writer_type + ", board_password=" + board_password + ", subject=" + subject
				+ ", content=" + content + ", readcount=" + readcount + ", re_ref=" + re_ref + ", re_lev=" + re_lev
				+ ", re_seq=" + re_seq + ", board_datetime=" + board_datetime + ", ip=" + ip + ", file=" + file + "]";
	}
	
}
