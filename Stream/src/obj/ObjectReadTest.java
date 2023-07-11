package obj;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectReadTest {

	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("object.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)) {

			Person p = null;
			try {
				while ((p = (Person) ois.readObject()) != null) {
					System.out.println(p.toString());
				}
			} catch (EOFException e) {
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
