package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.MemberMapper;
import dto.MemberDTO;

public class TestMain {

	public static void main(String[] args) {
		Map<String, Object> param = new HashMap<String , Object>();
		param.put("id", "admin");
		param.put("passwd", "123456");
//		System.out.println(MemberMapper.getInstance().loginTest(param));
//		MemberDTO dto = MemberMapper.getInstance().login(param);
//		System.out.println(dto);
//		System.out.println(MemberMapper.getInstance().selectAllMember());
//		MemberDTO dto = new MemberDTO("AA001", "123456", "홍길동", 20, 'F');
//		System.out.println(MemberMapper.getInstance().insertMember(dto));
		//나이값을 파라미터 값으로 보내서 해당 나이값보다 작은 회원만 조회해서 결과를 출력
		int age = 30;
		List<MemberDTO> list = MemberMapper.getInstance().selectAgeMember(age);
		for(MemberDTO dto : list)
			System.out.println(dto);
	}

}









