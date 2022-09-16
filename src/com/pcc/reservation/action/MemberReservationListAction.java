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

		List<ReservationDTO> memberReservationList = dao.memberReservationList(mem_num);

		request.setAttribute("memberReservationList", memberReservationList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./memberReservationList.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
