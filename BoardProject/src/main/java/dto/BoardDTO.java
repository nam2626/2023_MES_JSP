package dto;

public class BoardDTO {
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String bdate;
	private int bcount;
	private int blike;
	private int bhate;

	public BoardDTO() {
	}

	public BoardDTO(int bno, String title, String writer, String content, String bdate, int bcount, int blike,
			int bhate) {
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.bdate = bdate;
		this.bcount = bcount;
		this.blike = blike;
		this.bhate = bhate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public int getBlike() {
		return blike;
	}

	public void setBlike(int blike) {
		this.blike = blike;
	}

	public int getBhate() {
		return bhate;
	}

	public void setBhate(int bhate) {
		this.bhate = bhate;
	}

	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content + ", bdate="
				+ bdate + ", bcount=" + bcount + ", blike=" + blike + ", bhate=" + bhate + "]";
	}

}
