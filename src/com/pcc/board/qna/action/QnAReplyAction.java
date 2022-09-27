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
import vo.ActionForward;

public class QnAReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 한글 처리
		String uploadPath = request.getRealPath("/upload");
		MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath , 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		QnADAO dao = new QnADAO();
		MemberDAO daoM = new MemberDAO();
		
		// 매니저 로그인 여부 확인
		HttpSession session = request.getSession();
		String mgr_num = (String)session.getAttribute("mgr_num");
		if(mgr_num != null) {
			int qna_num = Integer.parseInt(multipartRequest.getParameter("qna_num"));
//			int qna_password = Integer.parseInt(multipartRequest.getParameter("qna_password"));
			String qna_subject = multipartRequest.getParameter("qna_subject");
			String qna_content = multipartRequest.getParameter("qna_content");
			String qna_ip = request.getRemoteAddr();
	
			QnADTO dto = new QnADTO();
			dto.setMgr_num(Integer.parseInt(mgr_num));
//			dto.setQna_password(qna_password);
			dto.setQna_subject(qna_subject);
			dto.setQna_content(qna_content);
			dto.setQna_ip(qna_ip);
			
			qna_num = dao.qnaReply(qna_num, dto);
			if(qna_num == 0) {
				daoM.alert(response, "답글 작성에 실패했습니다.", 
						"location.href='history.back()';");
			}
			
			request.setAttribute("dto", dto);
			request.setAttribute("qna_file", dto.getQna_file());
		
//			ActionForward forward = new ActionForward();
//			forward.setPath("./QnAContent.qna?qna_num="+qna_num+"&pageNum=1");
//			forward.setRedirect(true);
//			return forward;
			
			
			daoM.alert(response, "Q&A 답글이 작성되었습니다.", 
					"location.href='./QnAContent.qna?qna_num="+qna_num+"&pageNum=1';");
			return null;
		}
	return null;
	}

}
