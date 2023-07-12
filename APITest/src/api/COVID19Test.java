package api;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class COVID19Test {

	public static void main(String[] args) throws Exception {
		 StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1352000/ODMS_COVID_02/callCovid02Api");
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=hpOVfNem4MVro1QdBZTMTq%2FMZs%2B8yylSvxNQlqPiEQec%2Bo99WRRbIvrVqLltto5W0TmluoxR7uQHpHFNZ146qg%3D%3D");
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("apiType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
	        urlBuilder.append("&" + URLEncoder.encode("status_dt","UTF-8") + "=" + URLEncoder.encode("20230306", "UTF-8")); 
	        System.out.println(urlBuilder.toString());
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	       
	        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.parse(conn.getInputStream());
			document.getDocumentElement().normalize();
			
			NodeList list = document.getElementsByTagName("item");
			System.out.println(list.getLength());
			for(int i=0;i<list.getLength();i++) {
				NodeList childList = list.item(i).getChildNodes();
				System.out.println(list.item(i).getNodeName());
				for(int j=0;j<childList.getLength();j++) {
					System.out.println("\t"+childList.item(j).getNodeName() + " - " + 
							childList.item(j).getTextContent());
				}
			}
	        conn.disconnect();
	}

}
