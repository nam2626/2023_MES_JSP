package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadTextHex {

	public static void main(String[] args) {
		//out.txt를 읽어와서 1바이트씩 출력
		try(FileInputStream fis = new FileInputStream("out.txt")){
			int data = 0;
			
			while((data = fis.read()) != -1) {
				System.out.print(data + " ");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
