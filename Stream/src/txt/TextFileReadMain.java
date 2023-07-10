package txt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReadMain {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			//1. 스트림 초기화
			fr = new FileReader("text.txt");
			br = new BufferedReader(fr);
			
			//2. 데이터 입출력
			while(true) {
				String str = br.readLine();
				if(str == null) break;//null 더이상 읽어올 내용이 없을때
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//3. close
			try {
				if(br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}








