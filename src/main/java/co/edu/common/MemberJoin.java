package co.edu.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.member.ajaxweb.MemberService;
import co.edu.member.ajaxweb.MemberServiceImpl;
import co.edu.member.ajaxweb.MemberVO;



public class MemberJoin implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(); // 세션객체에 서버가 가지고 있는 세션객체를 담는다

		// TODO 이곳에 회원가입 처리를 작성한다.
		String sort = request.getParameter("memberSort");
		String gender = request.getParameter("gender");
		String id = request.getParameter("memberId");
		String name = request.getParameter("memberName");
		String pass = request.getParameter("memberPassword");
		String pcode = request.getParameter("memberPcode");
		String addr = request.getParameter("memberAddress");
		String extraaddr = request.getParameter("memberExtraaddress");
		String phone = request.getParameter("memberPhone");
		String cellphone = request.getParameter("memberCellPhone");
		String email = request.getParameter("memberEmail");
		String forever = request.getParameter("forever");
		String nickname = request.getParameter("memberNickname");
		String date = request.getParameter("memberBirthday");
		String bank = request.getParameter("bank");
		String bankname = request.getParameter("bankname");
		String banknumber = request.getParameter("banknumber");
		
		
		MemberVO member = new MemberVO();
		member.setMemberId(id);
		member.setMemberName(name);
		member.setMemberPassword(pass);
		member.setMemberAddress(addr);
		member.setMemberMembership(sort);
		member.setMemberGender(gender);
		member.setMemberPcode(pcode);
		member.setMemberExtraaddress(extraaddr);
		member.setMemberTel(phone);
		member.setMemberPhone(cellphone);
		member.setMemberEmail(email);
		member.setMemberForever(forever);
		member.setMemberNickname(nickname);
		member.setMemberBirthday(date);
		member.setMemberBank(bank);
		member.setMemberBankname(bankname);
		member.setMemberBanknumber(banknumber);
		
		
		
		
		MemberService service = new MemberServiceImpl();
		service.insertMember(member);

		session.setAttribute("id", id);
		request.setAttribute("member", member);
		
		return "member/memberJoin.tiles";
	}

}
