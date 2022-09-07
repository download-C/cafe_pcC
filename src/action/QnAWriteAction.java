package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.ActionMapUIResource;

import com.pcc.board.db.QnABoardDAO;
import com.pcc.board.db.QnABoardDTO;

import vo.ActionForward;

public class QnAWriteAction implements Action {

	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println(" M : QnAWriteAction_execute() 메서드 호출 실행 ");
		
		request.setCharacterEncoding("UTF-8");
		
		QnABoardDTO dto = new QnABoardDTO();
		
		dto.setmem_num(Integer.parseInt(request.getParameter("qna_name")));
		dto.setQnA_password(Integer.parseInt(request.getParameter("qna_pw")));
		dto.setQnA_subject(request.getParameter("qna_subject"));
		dto.setQnA_content(request.getParameter("qna_content"));
		
		System.out.println(" 파라미터 값 DTO에 저장 완료! ");
		
		System.out.println(" M : " + dto);
		
		QnABoardDAO dao = new QnABoardDAO();
		
		dao.QnAWrite(dto);
		System.out.println(" DAO 객체 생성 ");
		System.out.println(" DAO 객체 생성 후 DB에 저장 완료");
		
		ActionForward forward = new ActionForward();
		forward.setPath("/QnAList.bo");
		forward.setRedirect(true);
		System.out.println(" QnAList.bo로 이동 ");
		
		return forward;
	}
	
	

}
