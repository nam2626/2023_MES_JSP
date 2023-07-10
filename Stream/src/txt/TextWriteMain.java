package txt;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextWriteMain {

	public static void main(String[] args) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			//true => 이어서 쓰기, false => 새파일 생성
			fw = new FileWriter("out.txt",true);
			pw = new PrintWriter(fw);
			
			pw.println("Hello World");
			pw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(pw!=null)pw.close();
		}
	}

}










