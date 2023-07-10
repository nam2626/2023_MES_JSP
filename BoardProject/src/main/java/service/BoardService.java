package service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.BoardDTO;
import mapper.BoardMapper;

public class BoardService {
	private static BoardService instance = new BoardService();
	private BoardMapper mapper;
	
	private BoardService() {
		mapper = BoardMapper.getInstance();
	}

	public static BoardService getInstance() {
		if(instance == null)
			instance = new BoardService();
		return instance;
	}

	public List<BoardDTO> selectAllBoard() {
		return mapper.selectAllBoard();
	}

	public BoardDTO selectBoard(int bno) {
		return mapper.selectBoard(bno);
	}

	public int deleteBoard(int bno) {
		return mapper.deleteBoard(bno);
	}

	public int updateBoard(BoardDTO dto) {
		return mapper.updateBoard(dto);
	}

	public int insertBoardContentLike(int bno, String id) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("bno", bno);
		return mapper.insertBoardContentLike(map);
	}

	public int deleteBoardContentLike(int bno, String id) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("bno", bno);
		
		return mapper.deleteBoardContentLike(map);
		
	}

	public int selectBoardLikeCount(int bno) {
		return mapper.selectBoardLikeCount(bno);
	}

	
}







