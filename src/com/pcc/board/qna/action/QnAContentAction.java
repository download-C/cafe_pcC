package com.pcc.board.qna.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.qna.db.QnABoardDAO;
import com.pcc.board.qna.db.QnABoardDTO;
import com.pcc.member.db.MemberDAO;

import action.Action;

import vo.ActionForward;

public class QnAContentAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("QnAContent_execute() 호출");
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		String mgr_num = (String)session.getAttribute("mgr_mum");
		
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		String pageNum = (String)request.getAttribute("pageNum");
		
		if (pageNum == null) {
			pageNum = "1";
//			System.out.println("pageNum : " + pageNum);
		}
		
		if(mem_num != null) {
			
			QnABoardDAO dao = new QnABoardDAO();
			QnABoardDTO dto = dao.getQnAContent(qna_num);
			System.out.println("===========================");
			System.out.println("dto:"+dto);
			System.out.println("===========================");
			if(Integer.parseInt(mem_num) != dto.getMem_num()){
				dao.updateReadCount(qna_num);
			System.out.println("본인이 쓴 글이 아니므로 "+qna_num + "번 문의사항 조회수 1 증가 ");
			}
			//dao.getQnAReadCount(qna_num);
			
			System.out.println("DTO 완료");
			
			request.setAttribute("dto", dto);
			request.setAttribute("pageNum", Integer.parseInt(pageNum));
			System.out.println("pageNum" + pageNum);
			request.setAttribute("qna_num", qna_num);
			System.out.println("pageNum : " + pageNum);		
			request.setAttribute("qna_name", dto.getName());
			request.setAttribute("qmn", Integer.toString(dto.getMem_num()));
			
			ActionForward forward = new ActionForward();
			
			forward.setPath("./QnA/QnAContent.jsp");
			forward.setRedirect(false);
			
			return forward;
			
		} else if (mgr_num != null) {
			QnABoardDTO dto = new QnABoardDTO();
			
			QnABoardDAO dao = new QnABoardDAO();
			dto = dao.getQnAContent(qna_num);

			System.out.println( "DTO : " + dto );
			 
			request.setAttribute("dto", dto);
			request.setAttribute("pageNum", Integer.parseInt(pageNum));
			request.setAttribute("qna_num", qna_num);
			
			ActionForward forward = new ActionForward();
			
			forward.setPath("./QnA/QnAContent.jsp");
			forward.setRedirect(false);
			
			return forward;
			
		} else {
			MemberDAO dao = new MemberDAO();
			dao.alert(response, "로그인 후 이용 가능합니다.", "location.href='./LoginForm.me';");
			return null;
		}
	}
}
