package co.edu.member.ajaxweb;

import java.util.List;



public interface MemberService {
	List<MemberVO> selectMemberList();
	List<NoticeVO> noticeSelectList();
	MemberVO selectMember(MemberVO vo);
	public int insertMember(MemberVO vo);
	public int updateMember(MemberVO vo);
	public int deleteMember(MemberVO vo);
	public MemberVO loginCheck(MemberVO vo);
	
	public int insertNotice(NoticeVO vo);
}
