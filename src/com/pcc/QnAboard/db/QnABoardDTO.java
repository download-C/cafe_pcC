package com.pcc.QnAboard.db;

import java.sql.Timestamp;

// 게시판 관련 정보 객체

public class QnABoardDTO {
	private int QnA_num;						// 게시판 글 번호(글식별자)
	private int QnA_writer_type;				// 글 작성자 타입 -> 관리자일 경우 9로 시작, 일반 회원은 20으로 시작(회원번호가 가입한 날짜를 기반으로 생성됨)
	private int mgr_num;						// 매니저 번호 -> 모든 게시판에 사용
	private int mem_num;						// 회원 번호(회원식별자) -> 게시판 타입이 고객도 쓸 수 있는 리뷰나 QnA일 경우 사용
	//private int QnA_board_type;				// 게시판 타입 -> 1:공지사항, 2:QnA, 3:리뷰
	private int QnA_password;					// 글 비밀번호
	private String QnA_subject;					// 글 제목
	private String QnA_content;					// 글 내용
	private int QnA_readcount;					// 글 조회수
	private int QnA_re_ref;						// 답글 그룹번호 -> 특정 글에 답글이 달릴 경우 모두 같은 그룹
	private int QnA_re_lev;						// 답글 레벨 -> 일반 글은 0, 그 글의 답글은 1, 답글의 답글일 경우는 2 
	private int QnA_re_seq;						// 답글 순서 -> 같은 레벨의 답글일 경우 먼저 작성된 글의 숫자가 더 작음
	private Timestamp QnA_date;				// 글 작성시간 -> sql에 디폴트로 now() 되어있음.
	private String QnA_ip;
	private  String QnA_file;
	
	
	public int getQnA_num() {
		return QnA_num;
	}
	public void setQnA_num(int qnA_num) {
		QnA_num = qnA_num;
	}
	public int getQnA_writer_type() {
		return QnA_writer_type;
	}
	public void setQnA_writer_type(int qnA_writer_type) {
		QnA_writer_type = qnA_writer_type;
	}
	public int getmgr_num() {
		return mgr_num;
	}
	public void setmgr_num(int mgr_num) {
		this.mgr_num = mgr_num;
	}
	public int getmem_num() {
		return mem_num;
	}
	public void setmem_num(int mem_num) {
		this.mem_num = mem_num;
	}
//	public int getQnA_board_type() {
//		return QnA_board_type;
//	}
//	public void setQnA_board_type(int qnA_board_type) {
//		QnA_board_type = qnA_board_type;
//	}
	public int getQnA_password() {
		return QnA_password;
	}
	public void setQnA_password(int qnA_password) {
		QnA_password = qnA_password;
	}
	public String getQnA_subject() {
		return QnA_subject;
	}
	public void setQnA_subject(String qnA_subject) {
		QnA_subject = qnA_subject;
	}
	public String getQnA_content() {
		return QnA_content;
	}
	public void setQnA_content(String qnA_content) {
		QnA_content = qnA_content;
	}
	public int getQnA_readcount() {
		return QnA_readcount;
	}
	public void setQnA_readcount(int qnA_readcount) {
		QnA_readcount = qnA_readcount;
	}
	public int getQnA_re_ref() {
		return QnA_re_ref;
	}
	public void setQnA_re_ref(int qnA_re_ref) {
		QnA_re_ref = qnA_re_ref;
	}
	public int getQnA_re_lev() {
		return QnA_re_lev;
	}
	public void setQnA_re_lev(int qnA_re_lev) {
		QnA_re_lev = qnA_re_lev;
	}
	public int getQnA_re_seq() {
		return QnA_re_seq;
	}
	public void setQnA_re_seq(int qnA_re_seq) {
		QnA_re_seq = qnA_re_seq;
	}
	public Timestamp getQnA_date() {
		return QnA_date;
	}
	public void setQnA_date(Timestamp qnA_date) {
		QnA_date = qnA_date;
	}
	public String getQnA_ip() {
		return QnA_ip;
	}
	public void setQnA__ip(String qnA_ip) {
		
	}
	public void setQnA_ip(String qnA_ip) {
		QnA_ip = qnA_ip;
	}
	public String getQnA_file() {
		return QnA_file;
	}
	public void setQnA__file(String qnA_file) {
		
	}
	public void setQnA_file(String qnA_file) {
		QnA_file = qnA_file;
	}

	
	@Override
	public String toString() {
		return "QnA_BoardDTO [QnA_num=" + QnA_num + ", QnA_writer_type=" + QnA_writer_type + ", mgr_num=" + mgr_num
				+ ", mem_num=" + mem_num + ", QnA_password=" + QnA_password
				+ ", QnA_subject=" + QnA_subject + ", QnA_content=" + QnA_content + ", QnA_readcount=" + QnA_readcount
				+ ", QnA_re_ref=" + QnA_re_ref + ", QnA_re_lev=" + QnA_re_lev + ", QnA_re_seq=" + QnA_re_seq
				+ ", QnA_date=" + QnA_date + ", QnA_ip=" + QnA_ip + ", QnA_file=" + QnA_file + "]";
	}
	

}
