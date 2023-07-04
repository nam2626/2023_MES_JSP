package dao;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private DBManager manager;
	
	private MemberDAO() {
		manager = DBManager.getInstance();		
	}

	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
		return instance;
	}

	public MemberDTO login(String id, String passwd) {
		MemberDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//select 문으로 회원정보 조회 후 그 결과로 MemberDTO 객체로 만들어서 리턴
		String sql = "select * from member where member_id like ? and member_passwd like ?";
		
		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new MemberDTO(rs.getString(1), null, rs.getString(3), 
						rs.getInt(4), rs.getString(5).charAt(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
			
			while(rs.next()) {
				list.add( new MemberDTO(rs.getString(1), null, rs.getString(3), 
						rs.getInt(4), rs.getString(5).charAt(0)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(rs, pstmt);
		}
		
		return list;
	}

	
	
	
}






