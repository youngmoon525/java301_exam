package hr;

import java.io.InputStream;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
	

public class HrDAO {
	
	//③ SqlSession 을 sql로 선언
	private static SqlSession sql;
	
	// 리소스 : dtd설정 저장된 config.xml로 지정( 이걸로 mybatis환경설정 로딩됨)
	static {
		try {
			String resource = "mybatis/config1.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			//② 연결 : opensession,   ④ sql 초기화
			sql = sqlSessionFactory.openSession();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//list담기 
	
	public List<HrDTO> getList(){
		List<HrDTO> list = sql.selectList("hr.listselect");
		return list;
	}
	
	
	
//	Connection conn;
//	PreparedStatement ps;
//	ResultSet rs;
//	
//	//DB Conn
//	public Connection getConn() {
//		String url = "jdbc:oracle:thin:@localhost:1521:XE";
//		String user = "hr";
//		String password = "0000";
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection(url, user, password);
//			System.out.println("연결됨");
//		} catch (Exception e) {
//			System.out.println("getConn오류");
//		}
//		return conn;
//	}
//	
//	//DB Close
//	public void dbClose() {
//		try {
//			if(rs != null) {
//				rs.close();
//			}
//			if(ps != null) {
//				ps.close();
//			}
//			if(conn != null) {
//				conn.close();
//				System.out.println("연결끊음");
//			}
//		} catch (Exception e) {
//		}
//	}
//	
//	public ArrayList<hrDTO> getList(){
//		
//		ArrayList<hrDTO> list = new ArrayList<hrDTO>();
//		conn = getConn();
//		String sql = "SELECT  e.employee_id 사번, e.first_name || ' ' || e.last_name 이름, e.email 이메일, e.department_id,  e.PHONE_NUMBER 휴대전화, d.department_name 부서명, "
//					+ "        NVL(c.country_name ||' '|| l.city ||' '|| l.street_address || ' ' || l.postal_code, ' ') 전체주소, m.부서최대급여, m.부서최소급여, m.부서평균급여"
//					+ " FROM    employees e LEFT OUTER JOIN departments d "
//					+ " ON      e.department_id = d.department_id LEFT OUTER JOIN locations l"
//					+ " ON      d.location_id = l.location_id LEFT OUTER JOIN countries c"
//					+ " ON      l.country_id = c.country_id LEFT OUTER JOIN (SELECT department_id, NVL(MAX(salary),null) 부서최대급여 , NVL(MIN(salary),null) 부서최소급여 , NVL(AVG(salary),null) 부서평균급여 FROM employees GROUP BY department_id) m"
//					+ " ON      e.department_id = m.department_id";
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				
//				list.add(new hrDTO(rs.getString("사번")
//						, rs.getString("이름")
//						, rs.getString("이메일")
//						, rs.getString("department_id")
//						, rs.getString("휴대전화")
//						, rs.getString("부서명")
//						, rs.getString("전체주소")
//						, rs.getDouble("부서최대급여")
//						, rs.getDouble("부서최소급여")
//						, rs.getDouble("부서평균급여")));
//			}
//			
//		} catch (Exception e) {
//			System.out.println("getList오류");
//		}finally {
//			dbClose();
//		}
//		
//		return list;
//	}
//	
//	
//	
//	
//	
//	
//	
}

