package mapper;


public class BoardMapper {
	private static BoardMapper instance = new BoardMapper();
	private BoardMapper manager;
	
	private BoardMapper() {
		manager = BoardMapper.getInstance();
	}

	public static BoardMapper getInstance() {
		if(instance == null)
			instance = new BoardMapper();
		return instance;
	}

	
}
