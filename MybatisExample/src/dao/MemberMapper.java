package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import config.DBManager;
import dto.MemberDTO;

public class MemberMapper {
	private static MemberMapper instance = new  MemberMapper();
	private DBManager manager;
	private MemberMapper() {
		manager = DBManager.getInstance();
	}

	public static MemberMapper getInstance() {
		if(instance == null)
			instance = new MemberMapper();
		return instance;
	}
	
	public MemberDTO login(Map<String,Object> map){
		return manager.getSession().selectOne("login", map);
	}

	public List<MemberDTO> selectAllMember() {
		return manager.getSession().selectList("selectAllMember");
	}

	public int insertMember(MemberDTO dto) {
		return manager.getSession().insert("insertMember", dto);
	}

	public List<MemberDTO> selectAgeMember(int age) {
		return manager.getSession().selectList("selectAgeMember", age);
	}

	public Map<String,Object> loginTest(Map<String, Object> param) {
		return manager.getSession().selectOne("test_login", param);
	}
	
}









