package service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.GradeDTO;
import dto.MemberDTO;
import mapper.MemberMapper;

//싱글톤 패턴 적용
//MemberDAO도 필드로 적용
public class MemberService {
	private static MemberService instance = new MemberService();
	
	private MemberMapper mapper;
	
	private MemberService() {
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
		mapper.insertMember(dto);
	}
 
	public MemberDTO selectMember(String id) {
		return mapper.selectMember(id);
	}

	public int updateMember(MemberDTO dto) throws SQLException{
		return mapper.updateMember(dto);
	}

	public int deleteMember(String id) {
		return mapper.deleteMember(id);
	}

	public List<MemberDTO> searchMember(String kind, String search) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("kind", kind);
		map.put("search", search);
		return mapper.searchMember(map);
	}

	public List<GradeDTO> selectAllGrade() {
		return mapper.selectAllGrade();
	}

	public int insertGrade(GradeDTO gradeDTO) {
		return mapper.insertGrade(gradeDTO);
	}

	public int updateGrade(GradeDTO gradeDTO) {
		return mapper.updateGrade(gradeDTO);
	}

	public int deleteGrade(int gradeNo) {
		return mapper.deleteGrade(gradeNo);
	}

	public List<GradeDTO> selectGrade(String gradeName) {
		return mapper.selectGrade(gradeName);
	}

	
}










