package dao;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.GradeDTO;
import dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private DBManager manager;

	private MemberDAO() {
		manager = DBManager.getInstance();
	}

	public static MemberDAO getInstance() {
		if (instance == null)
			instance = new MemberDAO();
		return instance;
	}

	public MemberDTO login(String id, String passwd) {
		MemberDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// select 문으로 회원정보 조회 후 그 결과로 MemberDTO 객체로 만들어서 리턴
		String sql = "select * from member where member_id like ? and member_passwd like ?";

		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto = new MemberDTO(rs.getString(1), null, rs.getString(3), rs.getInt(4), rs.getString(5).charAt(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(rs, pstmt);
		}

		return dto;
	}

	public ArrayList<MemberDTO> selectAllMember() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member";

		try {
			pstmt = manager.getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(
						new MemberDTO(rs.getString(1), null, rs.getString(3), rs.getInt(4), rs.getString(5).charAt(0)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(rs, pstmt);
		}

		return list;
	}

	public void insertMember(MemberDTO dto) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "insert into member values(?,?,?,?,?)";

		pstmt = manager.getConn().prepareStatement(sql);

		pstmt.setString(1, dto.getMemberId());
		pstmt.setString(2, dto.getPasswd());
		pstmt.setString(3, dto.getName());
		pstmt.setInt(4, dto.getAge());
		pstmt.setString(5, String.valueOf(dto.getGender()));

		pstmt.executeUpdate();
	}

	public MemberDTO selectMember(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO dto = null;
		String sql = "select * from member where member_id like ?";

		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto = new MemberDTO(rs.getString(1), null, rs.getString(3), rs.getInt(4), rs.getString(5).charAt(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}

	public int updateMember(MemberDTO dto) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "update member set member_passwd = ?, member_name = ?,"
				+ " member_age = ?, member_gender = ? where member_id like ?";

		pstmt = manager.getConn().prepareStatement(sql);

		pstmt.setString(1, dto.getPasswd());
		pstmt.setString(2, dto.getName());
		pstmt.setInt(3, dto.getAge());
		pstmt.setString(4, String.valueOf(dto.getGender()));
		pstmt.setString(5, dto.getMemberId());

		return pstmt.executeUpdate();
	}

	public int deleteMember(String id) {
		PreparedStatement pstmt = null;
		String sql = "delete from member where member_id like ?";
		int result = 0;
		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	public ArrayList<MemberDTO> searchMember(String kind, String search) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where ";
		switch (kind) {
		case "id":
			sql += "member_id like '%' || ? || '%'";
			break;
		case "name":
			sql += "member_name like '%' || ? || '%'";
			break;
		default:
			sql += "member_gender like ?";
			break;
		}

		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(
						new MemberDTO(rs.getString(1), null, rs.getString(3), rs.getInt(4), rs.getString(5).charAt(0)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(rs, pstmt);
		}

		return list;
	}

	public ArrayList<GradeDTO> selectAllGrade() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<GradeDTO> list = new ArrayList<GradeDTO>();
		String sql = "select * from board_member_grade order by grade_no";

		try {
			pstmt = manager.getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new GradeDTO(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(rs, pstmt);
		}

		return list;
	}

	public int insertGrade(GradeDTO gradeDTO) {
		int result = 0;

		PreparedStatement pstmt = null;
		String sql = "insert into board_member_grade values(?,?)";

		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setInt(1, gradeDTO.getGradeNo());
			pstmt.setString(2, gradeDTO.getGradeName());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
  			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}

		return result;
	}

	public int updateGrade(GradeDTO gradeDTO) {
		int result = 0;

		PreparedStatement pstmt = null;
		String sql = "update board_member_grade set grade_name = ? where grade_no = ?";

		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setString(1, gradeDTO.getGradeName());
			pstmt.setInt(2, gradeDTO.getGradeNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
  			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}

		return result;
	}

	public int deleteGrade(int gradeNo) {
		int result = 0;

		PreparedStatement pstmt = null;
		String sql = "delete from board_member_grade where grade_no = ?";

		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setInt(1, gradeNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
  			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}

		return result;
	}

}
