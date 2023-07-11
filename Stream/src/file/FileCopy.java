package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileCopy {

	public static void main(String[] args) {
		//text.txt를 c:\\2023_07_11\\copy.txt 로 복사
		//FileInputStream, FileOutputStream, Calendar, SimpleDateFormat, File
		//원본파일 선택
		File originFile = new File("stream.pdf");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
		System.out.println(sdf.format(cal.getTime()));
		//복사할 위치 지정
		File copyFile = new File("c:\\"+sdf.format(cal.getTime())+"\\copy.pdf");
		//복사할 경로까지의 폴더가 존재하는지 확인 후 없으면 폴더 생성
		if(!copyFile.getParentFile().exists())
			copyFile.getParentFile().mkdirs();
		
		try(FileInputStream fis = new FileInputStream(originFile);
			FileOutputStream fos = new FileOutputStream(copyFile)){
			
//			int data = 0;
			long startTime = System.currentTimeMillis();
//			while((data = fis.read()) != -1) {
//				fos.write(data);
//				fos.flush();
//			}
			byte[] buffer = new byte[100];
			while(true) {
				int count = fis.read(buffer);
				if(count == -1) break;
				fos.write(buffer, 0, count);
				fos.flush();
			}
			
			long endTime = System.currentTimeMillis();
			System.out.println(endTime - startTime);
			System.out.println("파일 복사 완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}










