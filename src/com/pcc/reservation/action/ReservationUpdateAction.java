package com.pcc.reservation.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.member.db.MemberDAO;
import com.pcc.reservation.db.ReservationDAO;
import com.pcc.reservation.db.ReservationDTO;
import com.sun.xml.internal.bind.v2.runtime.Location;

import action.Action;
import vo.ActionForward;

public class ReservationUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		ReservationDAO dao = new ReservationDAO();
		MemberDAO daoM = new MemberDAO();
		
		if(session != null) {
			String mem_num = (String)session.getAttribute("mem_num");
			String mgr_num = (String)session.getAttribute("mgr_num");
			
			int res_num = Integer.parseInt(request.getParameter("res_num"));
			Date res_date = Date.valueOf(request.getParameter("res_date"));
			int res_time = Integer.parseInt(request.getParameter("res_time"));
			int res_persons = Integer.parseInt(request.getParameter("res_persons"));
			
			ReservationDTO dto = dao.getReservationInfo(res_num);
			dto.setRes_date(res_date);
			dto.setRes_time(res_time);
			dto.setRes_persons(res_persons);
			
			int result = dao.updateReservation(res_num, dto);
			
			if(result == 1) {
				dto = dao.getReservationInfo(res_num);
				request.setAttribute("dto", dto);	
				
				daoM.alert(response, "예약이 수정되었습니다.", 
						"location.href='./ReservationList.re?pageNum=1';");
				return null;
			} else if(result == 0) {
				daoM.alert(response, "해당 날짜의 오전 예약이 가득 차 수정할 수 없습니다.", 
						"history.back();");
				return null;
			} else {
			daoM.alert(response, "해당 날짜의 오전 예약이 가득 차 수정할 수 없습니다.", 
					"history.back();");
				return null;
			}
		} else {
			daoM.alert(response, "세션이 만료되어 로그인 페이지로 돌아갑니다.", "location.href='./Login.pcc';");
		}
		return null;
	}

}
