package com.pcc.reservation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.reservation.db.ReservationDAO;
import com.pcc.reservation.db.ReservationDTO;
import com.pcc.member.db.MemberDAO;

import action.Action;
import vo.ActionForward;

public class ReservationUpdateForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		MemberDAO daoM = new MemberDAO();
		HttpSession session = request.getSession();
		if(session != null){
			String res_num = request.getParameter("res_num");
			System.out.println("res_num : "+res_num);
			
			ReservationDAO dao = new ReservationDAO();
			ReservationDTO dto = dao.getReservationInfo(Integer.parseInt(res_num));
			System.out.println(res_num+"번 글의 정보 : "+dto);
			
			request.setAttribute("dto", dto);
			request.setAttribute("res_num", res_num);
			
			ActionForward forward = new ActionForward();
			forward.setPath("./reservation/reservationUpdateForm.jsp");
			forward.setRedirect(false);
			return forward;
		} else {
			daoM.alert(response, "세션이 만료되어 메인 페이지로 이동합니다.", 
					"location.href='./MainPage.pcc';");
		}
		return null;
		
	}

}
