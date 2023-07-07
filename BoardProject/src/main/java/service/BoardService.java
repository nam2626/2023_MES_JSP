package service;

import java.util.List;

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

	
}







