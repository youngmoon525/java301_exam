package customer;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomerDAO {
	//JDBC api(lib) 사용해서 --> Connection초기화, Statement(전송객체)초기화 & 쿼리넣기 --> ResultSet(결과)
	
	//위의 과정보다 관리,이용하기 쉽게 : ● Mybatis 사용( 자동으로 끊고 변수넘기기도 편함 )
	//환경설정이 좀 까다롭다는 단점이 있음.
	
	//Mybatis 환경설정 :  String sql 대신에 xml mapper 라는 xml로 파일로 쿼리의 집합파일을 만들어서 관리
						// ( 자바 파일이나 여러가지 방식으로 환경설정할 수 있기도 함. )
	
	//● 환경설정 방법
	//① Maven에서 해당 API를 프로젝트에 넣어주기(jar파일) pom.xml 이용		<<<  ※ 단, 프로젝트에 JDBC(ojdbc11)은 반드시 있어야 함   >>>
	//② xml파일 만들기 : mybatis dtd 검색하여 아래 태그 복사하여 붙여넣고 property 태그수정
	
	//③ XML에서 SqlSessionFactory 빌드하기 : mybatis dtd에서 복붙, try catch 로 싸줌. 
	
	//⑤ sqlSession static으로 sql로 선언
	
	//★★이걸로 통신을 열어둠
	private static SqlSession sql ; //전송 결과 처리하는 객체 (sqlSessionFactory를 이용하여 초기화)
	
	//★★★스태틱해두면 제일먼저 실행이 된다. 
	static {
		try {
			String resource = "mybatis/config.xml";	//mybatis dtd 설정이 들어있는 파일( 이파일을 이용해서 환경설정을 로딩 )
			InputStream inputStream = Resources.getResourceAsStream(resource);
			//④
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);		//Connection 역할을 함. 어떤 통신을 할건지 정해주는친구
			sql = sqlSessionFactory.openSession();		//통신 열림
			
			
		} catch (Exception e) {
			
		}
	}
	
	public void test() {		//sql.selectOne(" mapper.xml 파일의 mapper태그의 Namespace속성값 . 셀렉트 태그 id -> sql(id)")
								//namespace . id 형식임
		int result = sql.selectOne("test.selectTest");			//목록이 아니라 ( 데이터 베이스 조회 시 행의 갯수가 1개인 걸 조회함)
		System.out.println(result);
	}
	
	
	public List<CustomerDTO> getList(){
		//sql.update, sql.delete, sql.selectone, selectlist메소드→ 리턴타입이 리스트
		//①mapper.xml
		
		//②
		List<CustomerDTO> list = sql.selectList("cus.listselect");	//cus-mapper.xml의 namespace와 id
		return list;
	}


	public int insert(CustomerDTO dto) {
		//sql맵퍼에 파라메터(사용할 변수들)를 보내는 방법 (하나만 넘길수있음) ex)String , HashMap, ArrayList 모두 하나로 친다.
		//● sql.insert()로 보낼수 있다. 외부에서 접근할 경우 nameplace 맵퍼 이용
		//① insert로 dto담음
		int result = sql.insert("cus.insert",dto);
		//② 수동커밋
		sql.commit();		//Mybatis는 Auto Commit속성이 기본적으로 false 임 ( true로 나중에 바꿀 수도 있음 )
		return result;
	}
	
	public int update(CustomerDTO dto) {
		int result = sql.update("cus.update", dto);
		sql.commit();
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
