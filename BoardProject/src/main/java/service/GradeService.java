package service;

import mapper.GradeMapper;

public class GradeService {
	private static GradeService instance = new GradeService();
	private GradeMapper mapper;
	
	private GradeService() {
		mapper = GradeMapper.getInstance();
	}

	public static GradeService getInstance() {
		if(instance == null)
			instance = new GradeService();
		return instance;
	}

	
}
