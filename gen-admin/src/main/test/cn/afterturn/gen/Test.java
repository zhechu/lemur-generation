package cn.afterturn.gen;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
	
	@org.junit.Test
	public void test() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.30.60:1521/orclpdb", "sys as sysdba", "123456");
        System.out.println(connection);
        connection.close();
	}

}
