package dto;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONTestMain {

	public static void main(String[] args) {
		//JSON 객체 생성
		JSONObject json = new JSONObject();
		json.put("result", true);
		
		//dto에 담긴 내용을 json에다가 객체로 저장
		//dto로 저장하면 문자열(toString())로 저장
		//json 객체를 하나더 생성해서 생성시 dto를 넣으면 dto 객체를 json으로 자동으로 변환
		MemberDTO dto = new MemberDTO("A0001", "123456", "홍길동", "도둑놈", 1);
		json.put("dto", new JSONObject(dto));
		
		//ArrayList 하나 생성해서 MemberDTO 객체 4개 생성해서 리스트에 저장
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		list.add(new MemberDTO("B0002", "1234", "AAAAA", "A1234", 1));
		list.add(new MemberDTO("B0003", "1234", "BBBBB", "B1234", 3));
		list.add(new MemberDTO("B0004", "1234", "CCCCC", "CD234", 4));
		list.add(new MemberDTO("B0005", "1234", "DDDDD", "D1234", 2));
		
		//JSONArray <-- json 객체를 배열로 저장
		JSONArray arr = new JSONArray(list);
		System.out.println(arr.toString());
		json.put("list", arr);
		System.out.println(json.toString());
	}

}










