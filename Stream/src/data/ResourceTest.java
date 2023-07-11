package data;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ResourceTest {

	public static void main(String[] args) {
		//jdk8 버전부터 지원
		try(FileInputStream fis = new FileInputStream("data.dat");
			DataInputStream dis = new DataInputStream(fis);){
			
			int n = dis.readInt();
			double pi = dis.readDouble();
			char ch = dis.readChar();
			boolean flag = dis.readBoolean();
			
			System.out.println(n);
			System.out.println(pi);
			System.out.println(ch);
			System.out.println(flag);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}







