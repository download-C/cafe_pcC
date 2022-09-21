package com.pcc.reservation.action;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.reservation.db.ReservationDAO;
import com.pcc.reservation.db.ReservationDTO;

import action.Action;
import vo.ActionForward;

public class ReservationAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글처리
		request.setCharacterEncoding("UTF-8"); // request라는 내장객체는 자바에 없잖아 JSP에만
												// 있으니까 ㅇㅇ
												// JSP의 정보를 자바에 넣으려면 Controller가
												// 있어야함 그 역할이 Servlet임.
												// 액션태그는 못씀 jsp에서만 쓸 수 있음 여기는
												// java니까

		// 전달정보를 저장(제목,비밀번호,이름,내용)
		// BoardDTO 객체 생성
		ReservationDTO dto = new ReservationDTO();
		System.out.println("DTO객체 생성");

		HttpSession session = request.getSession();
		String res_date = request.getParameter("res_date");
		String res_persons = request.getParameter("res_persons");
		
		dto.setRes_date(res_date);
		dto.setRes_persons(Integer.parseInt(res_persons));
	
		// 병합 후 로그인 아이디 세션으로 받을꺼 
		//String loginID = session.getAttribute("loginID");

		
		// ReservationDAO 객체 생성
		ReservationDAO dao = new ReservationDAO();
		System.out.println("DAO객체 생성");

		System.out.println("reservation 메서드 생성");
		int result = dao.reservation(dto);

		session.setAttribute("res_date", res_date.substring(0, 10) + " " + res_date.substring(11, 16));
		session.setAttribute("res_num", res_persons);

		if (result == 1) {

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pr = response.getWriter();

			pr.println("<script type = 'text/javascript'>");
			pr.println("alert('예약이 완료되었습니다.')");
			pr.println("location.href = 'ReservationContent.re'");
			pr.println("</script>");
			pr.close();

			return null;

		} else if (result == 2) {

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pr = response.getWriter();

			pr.println("<script type = 'text/javascript'>");
			pr.println("alert('예약이 완료되었습니다.')");
			pr.println("location.href = 'ReservationContent.re'");
			pr.println("</script>");
			pr.close();

			return null;

		} else if (result == 3) {

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pr = response.getWriter();

			pr.println("<script type = 'text/javascript'>");
			pr.println("alert('예약이 불가능한 시간이거나, 당일 예약인원이 가득 찼습니다.')");
			pr.println("location.href = 'Reservation.re'");
			pr.println("</script>");
			pr.close();
			return null;
		} 
		
		return null;

	}
}
