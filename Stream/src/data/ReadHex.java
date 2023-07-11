package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadHex {

	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("data.dat")){
			int date = 0;
			
			while(true) {
				date = fis.read();
				if(date == -1) break;
				System.out.print(Integer.toHexString(date) + " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}









