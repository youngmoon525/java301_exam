package hr;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HrDAO {
	private static SqlSession sql;
	static {
		try {
			String resource = "mybatis/config1.xml"; // mybatis dtd 설정이 들어있는 파일(이파일을 이용해서 환경설정을 로딩)
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession();//Connection객체 이용해서 통신열기랑 같은 처리
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
	public List<HrDTO> getList(){
		List<HrDTO> list = sql.selectList("hr.Hrselect");
		return list;
	}
	
	
}