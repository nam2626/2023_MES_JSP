package dto;

public class CommentDTO {
	private int cno;
	private int bno;
	private String writer;
	private String cdate;
	private String content;
	private int clike;
	private int chate;

	public CommentDTO() {
	}

	public CommentDTO(int cno, int bno, String writer, String cdate, String content, int clike, int chate) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.writer = writer;
		this.cdate = cdate;
		this.content = content;
		this.clike = clike;
		this.chate = chate;
	}

	public CommentDTO(int bno, String writer, String content) {
		super();
		this.bno = bno;
		this.writer = writer;
		this.content = content;
	}

	public int getClike() {
		return clike;
	}

	public void setClike(int clike) {
		this.clike = clike;
	}

	public int getChate() {
		return chate;
	}

	public void setChate(int chate) {
		this.chate = chate;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CommentDTO [cno=" + cno + ", bno=" + bno + ", writer=" + writer + ", cdate=" + cdate + ", content="
				+ content + ", clike=" + clike + ", chate=" + chate + "]";
	}


}
