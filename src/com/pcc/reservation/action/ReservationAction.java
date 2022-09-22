package com.pcc.reservation.action;

import java.text.SimpleDateFormat;
import java.sql.Date;

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
		MemberDAO daoM = new MemberDAO();
		ReservationDTO dto = new ReservationDTO();
		System.out.println("DTO객체 생성");

		HttpSession session = request.getSession();
		if(session != null) {
			int mem_num = Integer.parseInt((String)session.getAttribute("mem_num"));
			String name = daoM.getName(mem_num);
			Date res_date = Date.valueOf(request.getParameter("res_date"));
			int res_time = Integer.parseInt(request.getParameter("res_time"));
			int res_persons = Integer.parseInt(request.getParameter("res_persons"));
			
			dto.setMem_num(mem_num);
			dto.setRes_date(res_date);
			dto.setName(name);
			dto.setRes_time(res_time);
			dto.setRes_persons(res_persons);
			
			ReservationDAO dao = new ReservationDAO();
	
			int result = dao.reservation(dto);
	
			if (result == 1) {
				
				request.setAttribute("dto", dto);
				daoM.alert(response, "예약이 완료되었습니다.", 
						"location.href='ReservationContent.re?res_num="+dto.getRes_num()+"&pageNum=1';");
				return null;
	
			} else if (result == 0) {
				daoM.alert(response, "해당 날짜의 오전에는 예약이 불가능합니다.", 
						"history.back();");
				return null;	
			} else {
				daoM.alert(response, "해당 날짜의 오후에는 예약이 불가능합니다.", 
						"history.back()");
				return null;
			}
		}
		return null;
	}
}
	
