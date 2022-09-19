package com.pcc.reservation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.reservation.db.ReservationDAO;
import com.pcc.reservation.db.ReservationDTO;

import action.Action;
import vo.ActionForward;

public class ReservationListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ReservationListAction_execute() 호출");
		
		request.setCharacterEncoding("UTF-8"); // request라는 내장객체는 자바에 없잖아 JSP에만
												// 있으니까 ㅇㅇ
		HttpSession session = request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		String mgr_num = (String)session.getAttribute("mgr_num");
		 
		ReservationDAO dao = new ReservationDAO();
		System.out.println("DAO객체 생성");
//		ReservationDTO dto = new ReservationDTO();
		
		// 회원이 로그인했을 때
		if(mem_num != null) {
//			dto.setMem_num(Integer.parseInt(mem_num));

			List<ReservationDTO> memberReservationList = dao.memberReservationList(Integer.parseInt(mem_num));
	
			request.setAttribute("memberReservationList", memberReservationList);
			
			ActionForward forward = new ActionForward();
			forward.setPath("./reservation/memberReservationList.jsp");
			forward.setRedirect(false);
			System.out.println("회원 예약 목록 페이지로 이동");
		
			 return forward;
			 
		// 매니저가 로그인했을 때
		} else if(mgr_num != null) {
			// ReservationDAO 객체 생성

			System.out.println("DAO객체 생성");
			
			List<ReservationDTO> reservationList = dao.reservationList();
			
			request.setAttribute("reservationList", reservationList);
			
			ActionForward forward = new ActionForward();
			forward.setPath("./reservation/ReservationList.jsp");
			forward.setRedirect(false);
			
			return forward;
		}
		return null;
	}

}
