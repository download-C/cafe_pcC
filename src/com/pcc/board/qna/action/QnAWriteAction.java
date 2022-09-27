package com.pcc.board.qna.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pcc.board.qna.db.QnADAO;
import com.pcc.board.qna.db.QnADTO;
import com.pcc.member.db.MemberDAO;

import action.Action;
import sun.text.resources.cldr.yo.FormatData_yo;
import vo.ActionForward;

public class QnAWriteAction implements Action {

	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println(" M : QnAWriteAction_execute() 메서드 호출 실행 ");
		
		// 0. 한글처리
//		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberDAO daoM = new MemberDAO();
		
		if(session != null) {
			String uploadPath = request.getRealPath("/upload");
			MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath , 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			String mem_num = (String)session.getAttribute("mem_num");
//			String mgr_num = (String)session.getAttribute("mgr_num");
	//		System.out.println("mem_num"+mem_num);
				
			if(mem_num != null) {
				String name = multipartRequest.getParameter("name");
				int qna_password = Integer.parseInt(multipartRequest.getParameter("qna_password"));
				String qna_subject = multipartRequest.getParameter("qna_subject");
				String qna_content = multipartRequest.getParameter("qna_content");
				String qna_file = multipartRequest.getParameter("qna_file");
				
				QnADTO dto = new QnADTO();
				System.out.println("DTO 객체 생성 완료");
				System.out.println(" 값 불러오기!");
				
				dto.setName(name);
				dto.setQna_subject(qna_subject);
				dto.setQna_content(qna_content);
				dto.setQna_file(qna_file);
				dto.setQna_ip(request.getRemoteAddr());
				dto.setQna_file(qna_file);
				dto.setMem_num(Integer.parseInt(mem_num));
				dto.setQna_password(qna_password);	
				
				QnADAO dao = new QnADAO();
				
				int qna_num = dao.QnAWrite(dto);
				
				System.out.println(" M : " + dto);
				
				daoM.alert(response, "문의사항 작성에 성공했습니다.", 
						"location.href='./QnAContent.qna?qna_num="+qna_num+"&pageNum=1';");
				
				return null;
			} else {
				daoM.alert(response, "세션이 만료되어 로그인 화면으로 돌아갑니다.", "location.href='./Login.pcc';");
				return null;
			}

		}
		daoM.alert(response, "세션이 만료되어 로그인 화면으로 돌아갑니다.", "location.href='./Login.pcc';");
		return null;
	}	

}
