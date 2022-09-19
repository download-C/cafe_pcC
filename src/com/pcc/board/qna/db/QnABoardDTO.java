package com.pcc.board.qna.db;

import java.sql.Timestamp;

// 게시판 관련 정보 객체

	public class QnABoardDTO {
	private int qna_num;						// 게시판 글 번호(글식별자)
	private int qna_writer_type;				// 글 작성자 타입 -> 관리자일 경우 9로 시작, 일반 회원은 20으로 시작(회원번호가 가입한 날짜를 기반으로 생성됨)
	private int mgr_num;						// 매니저 번호 -> 모든 게시판에 사용
	private int mem_num;						// 회원 번호(회원식별자) -> 게시판 타입이 고객도 쓸 수 있는 리뷰나 qna일 경우 사용
	private String name;
	private int qna_password;					// 글 비밀번호
	private String qna_subject;					// 글 제목
	private String qna_content;					// 글 내용
	private int qna_readcount;					// 글 조회수
	private int qna_re_ref;						// 답글 그룹번호 -> 특정 글에 답글이 달릴 경우 모두 같은 그룹
	private int qna_re_lev;						// 답글 레벨 -> 일반 글은 0, 그 글의 답글은 1, 답글의 답글일 경우는 2 
	private int qna_re_seq;						// 답글 순서 -> 같은 레벨의 답글일 경우 먼저 작성된 글의 숫자가 더 작음
	private Timestamp qna_date;				// 글 작성시간 -> sql에 디폴트로 now() 되어있음.
	private String qna_ip;
	private  String qna_file;
	
	

	
	public int getQna_num() {
		return qna_num;
	}

	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}

	public int getQna_writer_type() {
		return qna_writer_type;
	}

	public void setQna_writer_type(int qna_writer_type) {
		this.qna_writer_type = qna_writer_type;
	}


	public int getMgr_num() {
		return mgr_num;
	}


	public void setMgr_num(int mgr_num) {
		this.mgr_num = mgr_num;
	}


	public int getMem_num() {
		return mem_num;
	}


	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQna_password() {
		return qna_password;
	}


	public void setQna_password(int qna_password) {
		this.qna_password = qna_password;
	}


	public String getQna_subject() {
		return qna_subject;
	}


	public void setQna_subject(String qna_subject) {
		this.qna_subject = qna_subject;
	}


	public String getQna_content() {
		return qna_content;
	}


	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}


	public int getQna_readcount() {
		return qna_readcount;
	}


	public void setQna_readcount(int qna_readcount) {
		this.qna_readcount = qna_readcount;
	}


	public int getQna_re_ref() {
		return qna_re_ref;
	}


	public void setQna_re_ref(int qna_re_ref) {
		this.qna_re_ref = qna_re_ref;
	}


	public int getQna_re_lev() {
		return qna_re_lev;
	}


	public void setQna_re_lev(int qna_re_lev) {
		this.qna_re_lev = qna_re_lev;
	}


	public int getQna_re_seq() {
		return qna_re_seq;
	}


	public void setQna_re_seq(int qna_re_seq) {
		this.qna_re_seq = qna_re_seq;
	}


	public Timestamp getQna_date() {
		return qna_date;
	}


	public void setQna_date(Timestamp qna_date) {
		this.qna_date = qna_date;
	}


	public String getQna_ip() {
		return qna_ip;
	}


	public void setQna_ip(String qna_ip) {
		this.qna_ip = qna_ip;
	}


	public String getQna_file() {
		return qna_file;
	}


	public void setQna_file(String qna_file) {
		this.qna_file = qna_file;
	}

	@Override
	public String toString() {
		return "QnABoardDTO [qna_num=" + qna_num + ", qna_writer_type=" + qna_writer_type + ", mgr_num=" + mgr_num
				+ ", mem_num=" + mem_num + ", name=" + name + ", qna_password=" + qna_password + ", qna_subject="
				+ qna_subject + ", qna_content=" + qna_content + ", qna_readcount=" + qna_readcount + ", qna_re_ref="
				+ qna_re_ref + ", qna_re_lev=" + qna_re_lev + ", qna_re_seq=" + qna_re_seq + ", qna_date=" + qna_date
				+ ", qna_ip=" + qna_ip + ", qna_file=" + qna_file + "]";
	}

}
