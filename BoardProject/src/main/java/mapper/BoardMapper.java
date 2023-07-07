package mapper;

import java.util.List;

import config.DBManager;
import dto.BoardDTO;

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

	public List<BoardDTO> selectAllBoard() {
		return manager.getSession().selectList("selectAllBoard");
	}

	public BoardDTO selectBoard(int bno) {
		return manager.getSession().selectOne("selectBoard",bno);
	}

	
}











