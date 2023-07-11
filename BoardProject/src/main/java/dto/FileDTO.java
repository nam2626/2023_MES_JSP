package dto;

import java.io.File;

public class FileDTO {
	private String path;
	private String fileName;
	private String type;
	private int bno;
	private int fno;

	public FileDTO() {	}

	public FileDTO(File file, int bno, int fno) {
		this.bno = bno;
		this.fno = fno;
		this.path = file.getAbsolutePath();
		this.fileName = file.getName();
		switch(fileName.substring(fileName.lastIndexOf('.')+1)) {
		case "png":
		case "jpg":
		case "gif":
		case "bmp":
			this.type = "image";
			 break;
		}
	}
	
	
	
	
}







