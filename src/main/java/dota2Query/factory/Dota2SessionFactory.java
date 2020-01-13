package dota2Query.factory;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class Dota2SessionFactory {
	private static SqlSessionFactory sqlSessionFactory = null;
	//创建初始化sqlSessionFactory
	static {
		try{
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//获取sqlsession对象的静态方法
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	public static SqlSession getSqlSession() {return sqlSessionFactory.openSession();}
}