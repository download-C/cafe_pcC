package com.pcc.board.review.db;

import java.sql.Timestamp;

// 게시판 관련 정보 객체

public class ReviewDTO {
	private int review_num;					// 게시판 글 번호(글식별자)
	private int review_writer_type;				// 글 작성자 타입 -> 관리자일 경우 9로 시작, 일반 회원은 20으로 시작(회원번호가 가입한 날짜를 기반으로 생성됨)
	private int mgr_num;					// 매니저 번호(매니저 식별자)
	private int mem_num;					// 회원 번호(회원식별자) -> 게시판 타입이 고객도 쓸 수 있는 리뷰나 QnA일 경우 사용
	private String name;
	private int review_password;				// 글 비밀번호
	private String review_subject;					// 글 제목
	private String review_content;					// 글 내용
	private int review_readcount;					// 글 조회수
	private int review_re_ref;						// 답글 그룹번호 -> 특정 글에 답글이 달릴 경우 모두 같은 그룹
	private int review_re_lev;						// 답글 레벨 -> 일반 글은 0, 그 글의 답글은 1, 답글의 답글일 경우는 2 
	private int review_re_seq;						// 답글 순서 -> 같은 레벨의 답글일 경우 먼저 작성된 글의 숫자가 더 작음
	private Timestamp review_date;	// 글 작성시간 -> sql에 디폴트로 now() 되어있음.
	private String review_ip;
	private String review_file;
	
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public int getReview_writer_type() {
		return review_writer_type;
	}
	public void setReview_writer_type(int review_writer_type) {
		this.review_writer_type = review_writer_type;
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
	public int getReview_password() {
		return review_password;
	}
	public void setReview_password(int review_password) {
		this.review_password = review_password;
	}
	public String getReview_subject() {
		return review_subject;
	}
	public void setReview_subject(String review_subject) {
		this.review_subject = review_subject;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public int getReview_readcount() {
		return review_readcount;
	}
	public void setReview_readcount(int review_readcount) {
		this.review_readcount = review_readcount;
	}
	public int getReview_re_ref() {
		return review_re_ref;
	}
	public void setReview_re_ref(int review_re_ref) {
		this.review_re_ref = review_re_ref;
	}
	public int getReview_re_lev() {
		return review_re_lev;
	}
	public void setReview_re_lev(int review_re_lev) {
		this.review_re_lev = review_re_lev;
	}
	public int getReview_re_seq() {
		return review_re_seq;
	}
	public void setReview_re_seq(int review_re_seq) {
		this.review_re_seq = review_re_seq;
	}
	public Timestamp getReview_date() {
		return review_date;
	}
	public void setReview_date(Timestamp review_date) {
		this.review_date = review_date;
	}
	public String getReview_ip() {
		return review_ip;
	}
	public void setReview_ip(String review_ip) {
		this.review_ip = review_ip;
	}
	public String getReview_file() {
		return review_file;
	}
	public void setReview_file(String review_file) {
		this.review_file = review_file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ReviewDTO [review_num=" + review_num + ", review_writer_type=" + review_writer_type + ", mgr_num="
				+ mgr_num + ", mem_num=" + mem_num + ", review_name=" + name + ", review_password="
				+ review_password + ", review_subject=" + review_subject + ", review_content=" + review_content
				+ ", review_readcount=" + review_readcount + ", review_re_ref=" + review_re_ref + ", review_re_lev="
				+ review_re_lev + ", review_re_seq=" + review_re_seq + ", review_date=" + review_date + ", review_ip="
				+ review_ip + ", review_file=" + review_file + "]";
	}
	
}