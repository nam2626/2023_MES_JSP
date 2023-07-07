package config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//싱글톤 패턴 적용
//생성자에서 DB 접속 처리
public class DBManager {
	private static DBManager instance = new DBManager();
	private SqlSessionFactory sqlSessionFactory;
	private DBManager() {
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static DBManager getInstance() {
		if(instance == null)
			instance = new DBManager();
		return instance;
	}

	public SqlSession getSession() {
		return sqlSessionFactory.openSession(true);//auto commit(O)
	}
	
}


