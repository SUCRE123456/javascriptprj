package co.edu.member.ajaxweb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



public class MemberServiceImpl extends DAO implements MemberService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> selectMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	


	

	@Override
	public int insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberMembership());
			psmt.setString(2, vo.getMemberId());
			psmt.setString(3, vo.getMemberPassword());
			psmt.setString(4, vo.getMemberName());
			psmt.setString(5, vo.getMemberPcode());
			psmt.setString(6, vo.getMemberAddress());
			psmt.setString(7, vo.getMemberExtraaddress());
			psmt.setString(8, vo.getMemberTel());
			psmt.setString(9, vo.getMemberPhone());
			psmt.setString(10, vo.getMemberEmail());
			psmt.setString(11, vo.getMemberForever());
			psmt.setString(12, vo.getMemberNickname());
			psmt.setString(13, vo.getMemberGender());
			psmt.setString(14, vo.getMemberBirthday());
			psmt.setString(15, vo.getMemberBank());
			psmt.setString(16, vo.getMemberBankname());
			psmt.setString(17, vo.getMemberBanknumber());
			r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}
	
	
	

	@Override
	public int updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		String sql = "select * from member where id=? and password=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public boolean idCheck(String id) {
		boolean isId = false; // 초기값을 존재하지 않는것을 기준으로 한다.
		String sql = "select id from member where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next())
				isId = true; // 레코드에 값이 존재하면
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return isId;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<NoticeVO> noticeSelectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
