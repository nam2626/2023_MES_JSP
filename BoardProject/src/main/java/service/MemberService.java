package service;

import java.util.HashMap;
import java.util.Map;

import dto.MemberDTO;
import mapper.MemberMapper;

public class MemberService {
	private static MemberService instance = new MemberService();
	private MemberMapper mapper;
	
	private MemberService() {
		mapper = MemberMapper.getInstance();
	}

	public static MemberService getInstance() {
		if(instance == null)
			instance = new MemberService();
		return instance;
	}

	public MemberDTO login(String id, String passwd) {
		if(id == null || passwd == null) return null;
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("passwd", passwd);
		
		return mapper.login(map);
	}

	
}







