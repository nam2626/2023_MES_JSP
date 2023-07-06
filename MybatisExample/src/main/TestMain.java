package main;

import java.util.HashMap;
import java.util.Map;

import dao.MemberMapper;
import dto.MemberDTO;

public class TestMain {

	public static void main(String[] args) {
		Map<String, Object> param = new HashMap<String , Object>();
		param.put("id", "admin");
		param.put("passwd", "123456");
		MemberDTO dto = MemberMapper.getInstance().login(param);
//		System.out.println(dto);
//		System.out.println(MemberMapper.getInstance().selectAllMember());
		
	}

}
