package api;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChunCheonTest {
	public static ArrayList<String> searchPlace(String search) throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/4180000/cctour/getTourList");
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
				+ "=hpOVfNem4MVro1QdBZTMTq%2FMZs%2B8yylSvxNQlqPiEQec%2Bo99WRRbIvrVqLltto5W0TmluoxR7uQHpHFNZ146qg%3D%3D");
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("tourNm", "UTF-8") + "=" + URLEncoder.encode(search, "UTF-8"));
		System.out.println(urlBuilder.toString());
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		JSONObject json = new JSONObject(sb.toString());
		JSONArray arr = json.getJSONArray("data");
		for (int i = 0; i < arr.length(); i++) {
			list.add(arr.getJSONObject(i).getString("accommodations"));
		}
		return list;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 춘천 관광지 : ");
		String search = sc.nextLine();
		try {
			System.out.println(searchPlace(search));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
