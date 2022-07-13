package customer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomerDAO {
	//Mybatis 이용 관리, 가독성 등등의 장점을 추가한 API
	//기존-JDBC api(lib)사용 -> Connection초기화,Statement(전송)초기화 쿼리 넣기 =>전송 => ResultSet(결과) , int(결과)
	
		//Mybatis↑(이용 , 관리 , 가독성 등등의 장점을 추가한 API )
		//환경설정이 좀 까다롭다는 단점이 있음
		//xml파일로 환경설정 , String sql x => xml mapper라는 쿼리의 집합 파일을 만들어서 관리 ※
	
	//환경설정
	//1.maven에서 해당하는 api를 프로젝트에 넣어주기 pom.xml 프로젝트에 JDBC는 반드시 있어야함
	
	private static SqlSession sql;//전송 결과 처리를 하는 객체 (sqlSessionFactory 이용해서 초기화)
	static {
		try {
			String resource = "mybatis/config.xml"; //mybatis dtd 설정이 들어있는 파일(이 파일을 이용해서 활경설정을 로딩)
			InputStream inputStream = Resources.getResourceAsStream(resource); //환경설정을 inputstream으로 불러옴
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession(); //Connection 객체 이용해서 통신열기랑 같은 처리
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void test() {//sql.selectOne("mapperNamespace.sql(id)")
		int result = sql.selectOne("test.selectTest"); //목록이 아니라 데이터베이스 조회했을 때 행갯수가 1개인 것 조회
		System.out.println(result);
	}
	
	public List<CustomerDTO> getList(){
		//sql.update, sql.delete, sql.selectone, selectlist (return타입이 List)
		List<CustomerDTO> list = sql.selectList("cus.Listselect");
		
		return list;
	}

	public int insert(CustomerDTO dto) {
		// sql 맵퍼에 파라메터(사용할 변수들)를 보내는 방법(하나만 넘길 수 있음) ex) String HashMap ArrayList
		
		int result = sql.insert("cus.insert",dto);
		sql.commit(); //속성이 기본적으로 false임
		return result;
		
	}
	public int update(CustomerDTO dto) {
		int result = sql.update("cus.update", dto);
		sql.commit();
		return result;
	}
	
}
