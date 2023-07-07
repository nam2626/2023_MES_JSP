package mapper;

import config.DBManager;

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

	
}
