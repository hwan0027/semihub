package movieMember;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBConnection() {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "mysql");
			 System.out.println("데이터베이스 연결 완료");
			 
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 오류: ");
		}
	}
	
}
