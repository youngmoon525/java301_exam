package employee;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmployeeDAO {
	
	private static SqlSession sql;
	
	static {
		try {
			String resource = "mybatis/emp-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession();
		} catch (IOException e) {
		}//try
	}//static
	
	public List<EmployeeDTO> employeeInfo() {
		//sql.update, sap.delete, sal.selectone, selectlist(return타입이 list)
		List<EmployeeDTO> list = sql.selectList("emp.listEmployee");
		return list;
	}

	
}//class