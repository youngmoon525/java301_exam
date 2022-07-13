package Emp;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpDAO {
	private static SqlSession sql;
	
	static {
		try {
			String resource = "mybatis/config1.xml";	//mybatis dtd 설정이 들어있는 파일(이 파일을 이용해서 환경설정 로딩)
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession();	//connection 객체 이용해서 통신 열기랑 같은 처리 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<EmpDTO> getList() {
		List<EmpDTO> list = sql.selectList("emp.list");
		System.out.println(list.size());
		return list;
	}

	
	
}

