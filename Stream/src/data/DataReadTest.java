package data;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataReadTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("data.dat");
			dis = new DataInputStream(fis);

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
		}finally {
			try {
				if(dis != null)dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}









