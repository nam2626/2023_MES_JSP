package api;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONFileReader {

	public static void main(String[] args) {
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
//				System.out.println(obj.names()); //모든 키값 꺼내는 부분
				for (Object key : obj.names()) {
					System.out.println(key + " : " + obj.get(key.toString()));
				}
				System.out.println();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}









