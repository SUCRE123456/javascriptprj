package co.edu.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MemberJoinForm implements DbCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "member/memberJoinForm.tiles";
	}

}
