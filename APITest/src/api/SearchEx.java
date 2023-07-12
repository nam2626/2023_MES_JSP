package api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class SearchEx {
	private static final String CLIENT_ID = "awMpx6mgF0anlMxarfxH";
	private static final String CLIENT_SECRET = "wIy75AhoH0";
	private static final String API_URL = "https://openapi.naver.com/v1/search/news.json?query=";
	
	public static String newsSearch(String text) {
		String result = "";
		DataOutputStream dos = null;
		BufferedReader br = null;
		HttpURLConnection con = null;
		
		try {
			//api 서버 접속 처리
			URL url = new URL(API_URL+URLEncoder.encode(text,"utf-8"));
			con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
			con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
			
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
				JSONArray arr = json.getJSONArray("items");
				result = "";
				for(int i=0;i<arr.length();i++) {
					result += arr.getJSONObject(i).getString("title") + " " + arr.getJSONObject(i).getString("originallink") +"\n";
				}
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
		System.out.print("검색할 내용 입력 : ");
		String str = sc.nextLine();
		//번역 결과를 출력
		System.out.println(newsSearch(str));
	}

}









