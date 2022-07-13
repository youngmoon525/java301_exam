package employee;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import customer.CustomerDTO;
import student.StudentDTO;

public class EmployeeDAO {
	Connection conn;
	PreparedStatement ps; //질의문객체
	ResultSet rs ;
	
	static {
		String resource = "mybatis/config2.xml"; //mybatis dtd 설정이 들어있는 파일( 이파일을 이용해서 환경설정을 로딩)
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession(); // Connection객체 이용해서 통신열기랑 같은 처리
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

		
	private static SqlSession sql;


	public List<EmployeeDTO> getList(){
		List<EmployeeDTO> list = sql.selectList("employee.selectList");
		
		return list;
	}








}
	
	
	
	
	
	
	
	
	
	
	

