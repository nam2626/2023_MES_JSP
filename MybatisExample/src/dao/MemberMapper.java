package dao;

import java.util.List;
import java.util.Map;

import config.DBManager;

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
	
	public Map<String,Object> login(Map<String,Object> map){
		return manager.getSession().selectOne("login", map);
	}

	public List<Map<String,Object>> selectAllMember() {
		return manager.getSession().selectList("selectAllMember");
	}
	
}









