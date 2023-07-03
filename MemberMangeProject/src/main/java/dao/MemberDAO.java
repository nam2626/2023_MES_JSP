package dao;

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
		//select 문으로 회원정보 조회 후 그 결과로 MemberDTO 객체로 만들어서 리턴
		
		return dto;
	}

	
	
	
}






