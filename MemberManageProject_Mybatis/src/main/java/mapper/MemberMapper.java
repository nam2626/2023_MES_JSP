package mapper;

import java.util.List;
import java.util.Map;

import config.DBManager;
import dto.MemberDTO;

public class MemberMapper {
	private static MemberMapper instance = new MemberMapper();
	private DBManager manager;
	
	private MemberMapper() {
		manager = DBManager.getInstance();
	}

	public static MemberMapper getInstance() {
		if(instance == null)
			instance = new MemberMapper();
		return instance;
	}

	public MemberDTO login(Map<String, Object> map) {
		return manager.getSession().selectOne("login", map);
	}

	public List<MemberDTO> selectAllMember() {
		return manager.getSession().selectList("selectAllMember");
	}

	public int deleteMember(String id) {
		return manager.getSession().delete("deleteMember",id);
	}

	public int updateMember(MemberDTO dto) {
		return manager.getSession().update("updateMember", dto);
	}

	
	
	
	
}
