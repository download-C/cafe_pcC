package com.pcc.reservation.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.member.db.MemberDAO;
import com.pcc.reservation.db.ReservationDAO;
import com.pcc.reservation.db.ReservationDTO;

import action.Action;
import vo.ActionForward;

public class ReservationAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글처리
		request.setCharacterEncoding("UTF-8"); 

		ReservationDTO dto = new ReservationDTO();
		System.out.println("DTO객체 생성");

		HttpSession session = request.getSession();
		if(session != null) {
			String mem_num = (String)session.getAttribute("mem_num");
			
			SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date res_date = (java.sql.Date) dFormat.parse(request.getParameter("res_date"));
			
			Date date = new Date();

	        long timeInMilliSeconds = date.getTime();
	        java.sql.Date res_date2 = new java.sql.Date(timeInMilliSeconds);
			

			int res_time = Integer.parseInt(request.getParameter("res_time"));
			int res_persons = Integer.parseInt(request.getParameter("res_persons"));
			
			dto.setMem_num(Integer.parseInt(mem_num));
			dto.setRes_date(res_date);
			dto.setRes_time(res_time);
			dto.setRes_persons(res_persons);
			
			ReservationDAO dao = new ReservationDAO();
	
			int result = dao.reservation(dto);
			
			
			MemberDAO daoM = new MemberDAO();
	
			if (result == 1) {

				request.getAttribute("dto");
	
				daoM.alert(response, "예약이 완료되었습니다.", "location.href = 'ReservationContent.re';");
	
				return null;
	
			} else if (result == 0 || result == -1) {
				
				daoM.alert(response, "해당 날짜는 예약이 불가능합니다.", "location.href = 'history.back()';");

				return null;	
			}
		}
		
		return null;
	}
}
