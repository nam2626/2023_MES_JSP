package mapper;

import java.util.List;
import java.util.Map;

import config.DBManager;
import dto.GradeDTO;
import dto.MemberDTO;

public class MemberMapper {
	private static MemberMapper instance = new MemberMapper();
	private DBManager manager;
	
	private MemberMapper() {
		manager = DBManager.getInstance();
	}

	public static MemberMapper getInstance() {
		if(instance == null)
			instance = new MemberMapper();
		return instance;
	}

	public MemberDTO login(Map<String, Object> map) {
		return manager.getSession().selectOne("login", map);
	}

	public List<MemberDTO> selectAllMember() {
		return manager.getSession().selectList("selectAllMember");
	}

	public int deleteMember(String id) {
		return manager.getSession().delete("deleteMember",id);
	}

	public int updateMember(MemberDTO dto) {
		return manager.getSession().update("updateMember", dto);
	}

	public MemberDTO selectMember(String id) {
		return manager.getSession().selectOne("selectMember", id);
	}

	public List<MemberDTO> searchMember(Map<String, Object> map) {
		return manager.getSession().selectList("searchMember", map);
	}

	public int insertMember(MemberDTO dto) {
		return manager.getSession().insert("insertMember", dto);
	}

	public List<GradeDTO> selectAllGrade() {
		return manager.getSession().selectList("selectAllGrade");
	}

	public List<GradeDTO> selectGrade(String gradeName) {
		return manager.getSession().selectList("selectGrade", gradeName);
	}

	public int insertGrade(GradeDTO gradeDTO) {
		return manager.getSession().insert("insertGrade", gradeDTO);
	}

	public int updateGrade(GradeDTO gradeDTO) {
		return manager.getSession().update("updateGrade", gradeDTO);
	}

	public int deleteGrade(int gradeNo) {
		return manager.getSession().delete("deleteGrade", gradeNo);
	}

	
	
	
	
}
