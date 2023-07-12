package vo;

public class PaggingVO {
	//전체 게시글 개수
	private int count;
	//현재 페이지 번호
	private int currentPageNo;
	//한 페이지당 출력할 게시글 개수
	private int pageOfContentCount;
	//게시판 하단에 나타낼 페이지 번호 개수
	private int pageGroupOfCount;

	public PaggingVO(int count, int currentPageNo, int pageOfContentCount, int pageGroupOfCount) {
		this.count = count;
		this.currentPageNo = currentPageNo;
		this.pageOfContentCount = pageOfContentCount;
		this.pageGroupOfCount = pageGroupOfCount;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	//전체 페이지 개수 : 전체 게시글 개수 / 한페이지당 출력할 게시글 개수 + (나머지가 0 아니면 1)
	public int getTotalPage() {
		return count / pageOfContentCount + (count % pageOfContentCount == 0 ? 0 : 1);
	}
	
	//전체 페이지 그룹 개수 : 전체 페이지 개수 / 게시판 하단에 나타낼 페이지 번호 개수 + (나머지가 0 아니면 1)
	public int getTotalPageGroup() {
		return getTotalPage() / pageGroupOfCount + (getTotalPage() / pageGroupOfCount == 0 ? 0 : 1);
	}
	
	//현재 페이지 그룹 번호
	public int getNowPageGroupNo() {
		
	}
	
}















