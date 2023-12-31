package controller;
//싱글톤
//createController(command)
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {	}

	public static HandlerMapping getInstance() {
		if(instance == null)
			instance = new HandlerMapping();
		return instance;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		switch(command) {
		case "login.do":
			controller = new LoginController();
			break;
		case "main.do":
			controller = new MainController();
			break;
		case "logout.do":
			controller = new LogoutController();
			break;
		case "boardView.do":
			controller = new BoardViewController();
			break;
		case "boardDelete.do":
			controller = new BoardDeleteController();
			break;
		case "boardUpdateView.do":
			controller = new BoardUpdateViewController();
			break;
		case "boardUpdate.do":
			controller = new BoardUpdateController();
			break;
		case "boardContentLike.do":
			controller = new BoardContentLikeController();
			break;
		case "boardContentHate.do":
			controller = new BoardContentHateController();
			break;
		case "commentWrite.do":
			controller = new BoardCommentInsertController();
			break;
		case "commentLike.do":
			controller = new BoardCommentLikeController();
			break;
		case "commentHate.do":
			controller = new BoardCommentHateController();
			break;
		case "boardWriteView.do":
			controller = new BoardWriteViewController();
			break;
		case "boardWrite.do":
			controller = new BoardWriteController();
			break;
		}
		
		return controller;
	}
	
	
	
	
}






