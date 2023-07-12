package api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class PaPaGoEx2 {
	private static final String CLIENT_ID = "애플리케이션 클라이언트 아이디값";
	private static final String CLIENT_SECRET = "애플리케이션 클라이언트 시크릿값";
	private static final String API_URL = "https://openapi.naver.com/v1/papago/n2mt";
	
	public static String papagoTranslate(String target, String text) {
		String result = "";
		DataOutputStream dos = null;
		BufferedReader br = null;
		HttpURLConnection con = null;
		
		try {
			//api 서버 접속 처리
			URL url = new URL(API_URL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
			con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
			
			String param = String.format("source=ko&target=%s&text=%s", target,text);
			
			//데이터 전송
			dos = new DataOutputStream(con.getOutputStream());
			dos.write(param.getBytes());
			dos.flush();
			
			//결과를 받아서 처리
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String str = null;
			while((str = br.readLine()) != null) {
				result += str;
			}
			
			//데이터 파싱
			JSONObject json = new JSONObject(result);
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				result = json.getJSONObject("message").getJSONObject("result").getString("translatedText");
			}else {
				result = json.getString("errorMessage");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			con.disconnect();
		}
		
		
		return result;
	}
	
	
	public static void main(String[] args) {
		//사용자로부터 번역할 텍스트를 입력 받아서
		Scanner sc = new Scanner(System.in);
		System.out.print("번역할 내용 입력 : ");
		String str = sc.nextLine();
		//번역 결과를 출력
		System.out.println(papagoTranslate("ja", str));
	}

}









