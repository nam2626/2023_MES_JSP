package api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class BlogSearch {
	private static final String CLIENT_ID = "pI9D0MKp5RDTRshtxPgX";
	private static final String CLIENT_SECRET = "zmAMQu5TFA";
	private static final String API_URL = "https://openapi.naver.com/v1/search/blog?query=";

	public static String searchBlog(String text) {
		String result = null;
		BufferedReader br = null;
		HttpURLConnection con = null;

		try {
			text = URLEncoder.encode(text, "UTF-8");

			Map<String, String> requestHeaders = new HashMap<>();
			requestHeaders.put("X-Naver-Client-Id", CLIENT_ID);
			requestHeaders.put("X-Naver-Client-Secret", CLIENT_SECRET);

			URL url = new URL(API_URL+text);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}
			con.setDoOutput(true);
			
			//결과를 받아서 처리
			int responseCode = con.getResponseCode();
			String msg = "";
			if (responseCode == HttpURLConnection.HTTP_OK) {
				//정상처리가 되었을 때
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				//에러가 발생 했을 때
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			while(true) {
				String str = br.readLine();
				if(str == null) break;
				msg += str;
			}
			
			System.out.println(msg);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
			String date = sdf.format(Calendar.getInstance().getTime());
			text = URLDecoder.decode(text, "UTF-8");
			String fileName = date+"_"+text+".html";
			
			JSONObject json = new JSONObject(msg);
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				FileWriter fw = new FileWriter(fileName);
				PrintWriter pw = new PrintWriter(fw);
				
				JSONArray arr = json.getJSONArray("items");
				result = new String();
				for(int i=0;i<arr.length();i++) {
					pw.println("<p>");
					//JSON객체 하나 읽어옴
					JSONObject obj = arr.getJSONObject(i);
					result += obj.getString("title") + "\n";
					result += obj.getString("link") + "\n";
					result += obj.getString("description") + "\n";
					result += obj.getString("bloggername") + "\n";
					result += obj.getString("bloggerlink") + "\n";
					result += obj.getString("postdate") + "\n";
					result += "----------------------------------\n";
					pw.println("<p>"+obj.getString("title")+"</p>");
					pw.println("<p><a href='"+obj.getString("link")+"'>해당 페이지 이동</a></p>");
					pw.println("<p>"+obj.getString("description")+"</p>");
					pw.println("</p><hr>");
					pw.flush();
				}
				pw.close();
			}
			else
				result = json.getString("errorMessage");
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
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
		System.out.print("검색어 입력 : ");
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		System.out.println(searchBlog(text));
	}

}










