package service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.BoardDTO;
import dto.CommentDTO;
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

	public int insertBoardContentHate(int bno, String id) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("bno", bno);
		return mapper.insertBoardContentHate(map);
	}

	public int deleteBoardContentHate(int bno, String id) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("bno", bno);
		
		return mapper.deleteBoardContentHate(map);
		
	}

	public int selectBoardHateCount(int bno) {
		return mapper.selectBoardHateCount(bno);
	}

	public int insertBoardComment(int bno, String id, String comment) {
		return mapper.insertBoardComment(new CommentDTO(bno, id, comment));
	}

	public List<CommentDTO> selectCommentList(int bno) {
		return mapper.selectCommentList(bno);
	}

	public int insertCommentLike(String id, int cno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("cno", cno);
		return mapper.insertCommentLike(map);
	}
	public int deleteCommentLike(String id, int cno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("cno", cno);
		return mapper.deleteCommentLike(map);
	}
	public int insertCommentHate(String id, int cno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("cno", cno);
		return mapper.insertCommentHate(map);
	}
	public int deleteCommentHate(String id, int cno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("cno", cno);
		return mapper.deleteCommentHate(map);
	}

	
}







