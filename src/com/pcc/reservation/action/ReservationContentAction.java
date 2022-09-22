package com.pcc.reservation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.member.db.MemberDAO;
import com.pcc.reservation.db.ReservationDAO;
import com.pcc.reservation.db.ReservationDTO;

import action.Action;
import vo.ActionForward;

public class ReservationContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ReservationContentAction_execute() 호출");
		HttpSession session = request.getSession();
		
		// 로그인중일 때
		if(session != null) {
			System.out.println("세션 있음(로그인중)");
			String mem_num = (String)session.getAttribute("mem_num");
			String mgr_num = (String)session.getAttribute("mgr_num");
			int res_num = Integer.parseInt(request.getParameter("res_num"));
			String pageNum = (String)request.getAttribute("pageNum");
			System.out.println("세션값이 존재하므로 데이터 가져오기 성공");
			System.out.println("MEM_NUM: "+mem_num);
			if (pageNum == null) {
				pageNum = "1";
//				System.out.println("pageNum : " + pageNum);
			}
			
			if(mem_num != null) {
				System.out.println("회원 로그인");
				ReservationDTO dto = new ReservationDTO();
				ReservationDAO dao = new ReservationDAO();
				
				dto = dao.getReservationContent(res_num);
				System.out.println(dto.getName()+"의 예약 정보 : "+dto);
				request.setAttribute("dto", dto);
				request.setAttribute("pageNum", Integer.parseInt(pageNum));
				request.setAttribute("res_num", res_num);
				
				ActionForward forward = new ActionForward();
				forward.setPath("./reservation/reservationContent.jsp");
				forward.setRedirect(false);
				return forward;
				
			} else if(mgr_num != null) {
				ReservationDTO dto = new ReservationDTO();
				ReservationDAO dao = new ReservationDAO();
				
				dto = dao.getReservationContent(res_num);
				request.setAttribute("dto", dto);
				request.setAttribute("pageNum", Integer.parseInt(pageNum));
				request.setAttribute("res_num", res_num);
				
				ActionForward forward = new ActionForward();
				forward.setPath("./reservation/reservationContent.jsp");
				forward.setRedirect(false);
				return forward;
			}
		// 로그인 시간 만료됐을 때	
		} else {
			MemberDAO daoM = new MemberDAO();
			daoM.alert(response, "세션값이 만료되어 메인 페이지로 이동합니다.", 
					"location.herf='./MainPage.pcc';");
		}
			
		return null;
	}

}
