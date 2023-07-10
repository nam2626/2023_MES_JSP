package mapper;

import java.util.List;
import java.util.Map;

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

	public int deleteBoard(int bno) {
		return manager.getSession().delete("deleteBoard",bno);
	}

	public int updateBoard(BoardDTO dto) {
		return manager.getSession().update("updateBoard", dto);
	}

	public int insertBoardContentLike(Map<String, Object> map) {
		return manager.getSession().insert("insertBoardContentLike", map);
	}
	public int deleteBoardContentLike(Map<String, Object> map) {
		return manager.getSession().delete("deleteBoardContentLike", map);
	}

	public int selectBoardLikeCount(int bno) {
		return manager.getSession().selectOne("selectBoardLikeCount", bno);
	}

	
}











