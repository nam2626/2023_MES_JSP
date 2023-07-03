package dao;

import config.DBManager;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private DBManager manager;
	
	private MemberDAO() {
		manager = DBManager.getInstance();		
	}

	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
		return instance;
	}

	
	
	
}
