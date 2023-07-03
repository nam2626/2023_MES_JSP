package service;

import dao.MemberDAO;
import dto.MemberDTO;

//싱글톤 패턴 적용
//MemberDAO도 필드로 적용
public class MemberService {
	private static MemberService instance = new MemberService();
	
	private MemberDAO dao;
	
	private MemberService() {
		dao = MemberDAO.getInstance();
	}

	public static MemberService getInstance() {
		if(instance == null)
			instance = new MemberService();
		return instance;
	}

	public MemberDTO login(String id, String passwd) {
		return dao.login(id,passwd);
	}

	
}










