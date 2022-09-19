package com.pcc.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.pcc.member.db.MemberDAO;

import action.Action;
import vo.ActionForward;

public class IdCheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3. IdCheck");
		
		request.setCharacterEncoding("UTF-8");
		
/*		String phone = request.getParameter("phone");
		System.out.println(" phone정보 받아오기");
		
		MemberDAO dao = new MemberDAO();
		
		System.out.println(" DAO 객체 생성");
		
		MemberDTO dto = new MemberDTO();
		dto.setPhone(phone);
				
		int check = dao.IdCheck(dto);

		
		System.out.println("dto"+dto);
		String result="";
		
		if(check == 1){
			//아이디 중복
			result="아이디 중복";
		}else{
			//아이디 없음
			result="아이디 사용가능";
		}
		//결과 출력
		System.out.println("  중복 확인 완료");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println(result);
		out.close();
		
//		System.out.println("3. IdCheck 돌아옴");
//		ActionForward forward = new ActionForward();
//		forward.setPath("./JoinAction.me");
//		forward.setRedirect(true);
		return null ;*/
		
		
		// 1. 페이지에서 ID값 불러오기 ->  'id':$('id').val()
		String phone = request.getParameter("phone");
		System.out.println("phone: "+phone);
	 
		 // 2. MemberDAO 객체 생성
		 MemberDAO dao = new MemberDAO();
		 
		 // 3. MemberBean 객체 생성 후 getMember(id)로 id 텍스트창에 입력된 id 정보 호출
		 boolean result = dao.IdCheck(phone);
		 
		 // 4. 아이디 입력 확인 후 중복 여부에 따른 문구 정의하기
		 String divResult = "";
		 
		 if(result) {
			 divResult = "사용 가능한 아이디입니다.";
		 } else {
			 divResult = "이미 사용중인 아이디입니다.";
		 }
				// 4-1. 중복 아이디 있음 
		 response.setContentType("text/html; charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 out.println(divResult);
		 
		 return null;
		 
	}
}
