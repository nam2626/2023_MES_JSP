package mapper;

import config.DBManager;

public class BoardMapper {
	private static BoardMapper instance = new BoardMapper();
	private DBManager manager;
	
	private BoardMapper() {
		manager = DBManager.getInstance();
	}

	public static BoardMapper getInstance() {
		if(instance == null)
			instance = new BoardMapper();
		return instance;
	}

	
}
