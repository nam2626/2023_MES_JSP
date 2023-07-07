package mapper;

import config.DBManager;

public class GradeMapper {
	private static GradeMapper instance = new GradeMapper();
	private DBManager manager;
	
	private GradeMapper() {
		manager = DBManager.getInstance();
	}

	public static GradeMapper getInstance() {
		if(instance == null)
			instance = new GradeMapper();
		return instance;
	}

	
}
