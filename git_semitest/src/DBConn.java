package movieMember;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConn {
	private static Connection dbConn;	
	public static Connection getConnection(){
		if(dbConn==null){
			try {
				String url = "jdbc:mysql://localhost:3306/employee_db?characterEncoding=utf-8&serverTimezone=Asia/Seoul";
				String user = "root";
				String password = "mysql";
	            Class.forName("com.mysql.cj.jdbc.Driver");

	         
	            dbConn = DriverManager.getConnection(url, user, password);	
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			}
		return dbConn;
		}
		
	public static void close(){
		if(dbConn!=null){
			try {
				if(!dbConn.isClosed()){
					dbConn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//연결을 끊어주면 그 안에 쓰레기 값이 남아 두번째 연결을 할때는 Adapter에러가 발생, 접속이 안된다

		//★항상 연결을 끊으면 dbConn을 null로 초기화 해야함
		dbConn=null;
	}
}
