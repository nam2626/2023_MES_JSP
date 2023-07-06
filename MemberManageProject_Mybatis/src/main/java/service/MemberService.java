package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.MemberDAO;
import dto.GradeDTO;
import dto.MemberDTO;
import mapper.MemberMapper;

//싱글톤 패턴 적용
//MemberDAO도 필드로 적용
public class MemberService {
	private static MemberService instance = new MemberService();
	
	private MemberDAO dao;
	private MemberMapper mapper;
	
	
	private MemberService() {
		dao = MemberDAO.getInstance();
		mapper = MemberMapper.getInstance();
	}

	public static MemberService getInstance() {
		if(instance == null)
			instance = new MemberService();
		return instance;
	}

	public MemberDTO login(String id, String passwd) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("passwd", passwd);
		return mapper.login(map);
	}

	public List<MemberDTO> selectAllMember() {
		return mapper.selectAllMember(); 
	}

	public void insertMember(MemberDTO dto) throws SQLException {
		dao.insertMember(dto);
	}

	public MemberDTO selectMember(String id) {
		return dao.selectMember(id);
	}

	public int updateMember(MemberDTO dto) throws SQLException{
		return dao.updateMember(dto);
	}

	public int deleteMember(String id) {
		return dao.deleteMember(id);
	}

	public ArrayList<MemberDTO> searchMember(String kind, String search) {
		return dao.searchMember(kind,search);
	}

	public ArrayList<GradeDTO> selectAllGrade() {
		return dao.selectAllGrade();
	}

	public int insertGrade(GradeDTO gradeDTO) {
		return dao.insertGrade(gradeDTO);
	}

	public int updateGrade(GradeDTO gradeDTO) {
		return dao.updateGrade(gradeDTO);
	}

	public int deleteGrade(int gradeNo) {
		return dao.deleteGrade(gradeNo);
	}

	public ArrayList<GradeDTO> selectGrade(String gradeName) {
		return dao.selectGrade(gradeName);
	}

	
}










