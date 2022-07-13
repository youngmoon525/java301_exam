package employees;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.jasper.tagplugins.jstl.core.Import;
import employees.EmpDTO;
public class EmpDAO {

	private static SqlSession sql;//<= 전송과 결과 처리하는 모두 객체
	static {
		try {
			String resource = "mybatis/emp-config.xml"; // mybatis dtd 설정이 들어있는 파일(이 파일을 이용해서 환경설정을 로딩)
//		(1)	resource 에 mybatis/config.xml 경로에 있는 mybatis dtd 설정을 읽어와서
			InputStream inputStream = Resources.getResourceAsStream(resource);
//		(2)	InputStream을 이용해서 해독을 하고 
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		(3)	데이터 베이스에 연결하는 객체를 초기화 
			sql = sqlSessionFactory.openSession();// <= Connection객체를 이용해서 통신을 여는 것과 같은 처리를 한다.
//			▲▲ 여기까지가 (1)~(3)번까지 진행하는 코드이다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//S
	public List<EmpDTO> getEmpList() {
		
		 List<EmpDTO> list = sql.selectList("emp.empselect");
		return list;
	}
}//C
