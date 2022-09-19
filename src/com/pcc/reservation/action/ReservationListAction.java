package com.pcc.reservation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.reservation.db.ReservationDAO;
import com.pcc.reservation.db.ReservationDTO;

import action.Action;
import vo.ActionForward;

public class ReservationListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		request.setCharacterEncoding("UTF-8"); // request라는 내장객체는 자바에 없잖아 JSP에만
												// 있으니까 ㅇㅇ

		// ReservationDAO 객체 생성
		ReservationDAO dao = new ReservationDAO();
		System.out.println("DAO객체 생성");

		List<ReservationDTO> reservationList = dao.reservationList();
		
		
		request.setAttribute("reservationList", reservationList);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./reservationList.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
