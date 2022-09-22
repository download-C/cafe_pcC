package com.pcc.reservation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.reservation.db.ReservationDAO;
import com.pcc.reservation.db.ReservationDTO;

import action.Action;
import vo.ActionForward;

public class MemberReservationListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8"); 

		ReservationDTO dto = new ReservationDTO();
		
		
		int mem_num = Integer.parseInt(request.getParameter("mem_num"));
		dto.setMem_num(mem_num);
		
		ReservationDAO dao = new ReservationDAO();
		System.out.println("DAO객체 생성");

		// 게시판에 작성되어 있는 전체 글 개수
		int cnt = dao.getReservationCount();

		// 페이징
		// 처리---------------------------------------------------------------------------

		// 2가지 형태
		// DB에서 통쨰로 들고와서 10개씩 보여주는거, DB에서 아애 10개씩 들고오는거.
		// 따로 들고오는게 효율적임.
		// 데이터가 많아 질수록 나눠서 들고오는게 좋음. 지금이야 몇개 안되서 차이가 얼마 안남.

		// 한 페이지에 보여줄 글의 개수 설정

		// ./BoardList.com?pageNum=2&pageSize=3
		String urlPageSize = request.getParameter("pageSize");  // 글 5개 행 5개 보여줌
		urlPageSize = "5";
		int pageSize = Integer.parseInt(urlPageSize);
		// URL에 ?pageSize = 15 이런식으로 입력하면 페이지 사이즈 조절 됨.

		// 현재 페이지가 몇번째 페이지인지 계산
		// 페이지 정보가 없을경우 항상 1페이지
		String pageNum = request.getParameter("pageNum");      // 5개씩 1페이지
		if (pageNum == null) {
			pageNum = "1";
		}
		// 시작행 번호 계산 1 6 11 16 .....
		
		int currentPage = Integer.parseInt(pageNum);
	
		int startRow = (currentPage - 1) * pageSize + 1;

		// 끝행 번호 계산 5 10 15 20 ....

		int endRow = currentPage * pageSize;

		
		List<ReservationDTO> reservationList = dao.reservationList(startRow, pageSize);
		
		
		int pageCount = cnt / pageSize + (cnt % pageSize == 0 ? 0 : 1);

		// 한 화면에 보여줄 페이지수(페이지 블럭)
		int pageBlock = 3;

		// 페이지블럭 시작번호 1 ~ 10 => 1, 11~20 => 11, 21~30 => 21
		int startPage = ((currentPage - 1) / pageBlock) * pageBlock+ 1;

		// 페이지 블럭 끝번호
		int endPage = startPage + pageBlock - 1;

		// view 페이지 정보 전달을 위해서 request영역
		// int는 소수점이하 자리를 버림.
		
		// 총 페이지, 페이지 블럭(끝번호) 비교
		if(endPage > pageCount){
				endPage = pageCount;
		}

		// 페이징 처리 2(하단 페이지
		// 링크)-----------------------------------------------------------------------------
		
	

		List<ReservationDTO> memberReservationList = dao.memberReservationList(mem_num);

		request.setAttribute("memberReservationList", memberReservationList);
		request.setAttribute("dto", dto);
		
		System.out.println(" M :  페이징 정보처리 ");

		// 페이지 처리 정보 전달(request 영역)

		request.setAttribute("pageNum", pageNum);
		request.setAttribute("cnt", cnt);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		System.out.println("M :  페이징 처리정보 완료");
		
		ActionForward forward = new ActionForward();
		forward.setPath("./reservation/memberReservationList.jsp");
		forward.setRedirect(false);

		return forward;
		
	}

}
