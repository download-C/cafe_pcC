package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

// 요청을 처리하는 Action 클래스들을 
//동일한 타입으로 참조하기 위한 Action 인터페이스

public interface Action {
	ActionForward execute (HttpServletRequest request,
			HttpServletResponse response) throws Exception;
}
