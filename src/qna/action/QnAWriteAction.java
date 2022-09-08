package qna.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.ActionMapUIResource;

import com.pcc.QnAboard.db.QnABoardDAO;
import com.pcc.QnAboard.db.QnABoardDTO;

import vo.ActionForward;

public class QnAWriteAction implements Action {

	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println(" M : QnAWriteAction_execute() 메서드 호출 실행 ");
		
		// 0. 한글처리
		request.setCharacterEncoding("UTF-8");
		System.out.println(" 한글처리 완료! ");
		
		// 1. QnAWriteForm.jsp에서 받은 정보(제목, 내용, 첨부파일)를 담을 BoardDTO 생성 후 저장
		QnABoardDTO dto = new QnABoardDTO();
		
		dto.setQnA_password(Integer.parseInt(request.getParameter("QnA_password")));
		dto.setQnA_subject(request.getParameter("QnA_subject"));
		dto.setQnA_content(request.getParameter("QnA_content"));
		dto.setQnA__file(request.getParameter("QnA_file"));
		
		System.out.println(" 파라미터 값 DTO에 저장 완료! ");
		
		System.out.println(" M : " + dto);
		
		// 2. DB에 정보 저장
		
		QnABoardDAO dao = new QnABoardDAO();
		dao.QnAWrite(dto);
		
		System.out.println(" DAO 객체 생성 후 DB에 저장 완료");
		
		ActionForward forward = new ActionForward();
		forward.setPath("");
		forward.setRedirect(true);
		System.out.println(" QnAList.bo로 이동 ");
		
		return forward;
	}
	
	

}
