package com.pcc.reservation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.reservation.db.ReservationDAO;
import com.pcc.reservation.db.ReservationDTO;

import action.Action;
import vo.ActionForward;


public class ReservationAction implements Action{
		
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		// 한글처리
		// 한글처리
				request.setCharacterEncoding("UTF-8"); 		// request라는 내장객체는 자바에 없잖아 JSP에만 있으니까 ㅇㅇ
															// JSP의 정보를 자바에 넣으려면 Controller가 있어야함 그 역할이 Servlet임.
															// 액션태그는 못씀 jsp에서만 쓸 수 있음 여기는 java니까
				
				
				// 전달정보를 저장(제목,비밀번호,이름,내용)
				// BoardDTO 객체 생성 
				ReservationDTO dto = new ReservationDTO();
				System.out.println("DTO객체 생성");
			
				
				String res_date = request.getParameter("res_date");
				String res_hour = request.getParameter("res_hour");
				String res_num_of_persons = request.getParameter("res_num_of_persons");


				dto.setRes_date(res_date);
				dto.setRes_hour(res_hour);
				dto.setRes_num_of_persons(Integer.parseInt(res_num_of_persons));
				dto.setTable_total(20);
				
				
				
				// ReservationDAO 객체 생성
				ReservationDAO dao = new ReservationDAO();
				System.out.println("DAO객체 생성");
				
				
				System.out.println("reservation 메서드 생성");
				dao.reservation(dto);
			
			
				
				ActionForward forward = new ActionForward();
				forward.setPath("./reservation.jsp");
				forward.setRedirect(false);

				
				return forward;


	}
}
