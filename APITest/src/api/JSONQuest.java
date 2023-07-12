package api;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONQuest {

	public static void main(String[] args) {
		//data.json에 있는 내용 중, 성별이 남자인 고객만 데이터를 출력
		//출력할 데이터는 고객 이름, 이메일, 아이피주소
		try {
			FileReader fr = new FileReader("data.json");
			BufferedReader br = new BufferedReader(fr);
			StringBuilder builder = new StringBuilder();
			
			while(true) {
				String str = br.readLine();
				if(str == null) break;
				builder.append(str);
			}
			
			System.out.println(builder);
			
			//-------------------------------------------------
			JSONArray arr = new JSONArray(builder.toString());
			
			for(int i=0;i<arr.length();i++) {
				JSONObject obj = arr.getJSONObject(i);
				if(obj.getString("gender").equals("Male")) {
					System.out.println(obj.getString("first_name") + " " +obj.getString("last_name") +
							" " +obj.getString("email") + " " +obj.getString("ip_address"));
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
