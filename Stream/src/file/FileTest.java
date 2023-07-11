package file;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		File file = new File("c:\\test\\test.txt");
		
		System.out.println(file);
		
		//현재 파일의 절대 경로 위치값을 뽑음
		System.out.println(file.getAbsolutePath());
		//부모 폴더 경로를 뽑음
		System.out.println(file.getParent());
		//부모 폴더 경로에 해당하는 파일 객체를 뽑음
		File parent = file.getParentFile();
		System.out.println(parent.exists());
		if(!parent.exists())
			parent.mkdirs(); //해당 경로까지의 폴더를 전부 생성
		try {
			boolean result = file.createNewFile();
			System.out.println("파일 생성 결과 : "+result);
//			file.renameTo(new File("test111.txt"));//해당 파일 객체 경로로 이동, 이미 파일이 있으면 동작 X
			file.delete();//파일 삭제
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}









