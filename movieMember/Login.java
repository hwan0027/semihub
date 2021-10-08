package movieMember;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Login {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//아이디, 비밀번호를 입력
		
		System.out.println("유저 아이디를 입력하세요");
		String userId = scan.next();
		System.out.println("비밀번호를 입력하세요");
		String password = scan.next();
		
		try (Connection conn = DBConn.getConn();
			Statement stmt = conn.createStatement()){
			
			String sql = "select * from movieMember where user_id='"+userId+"'and password='"+password+"'";
			
			try (ResultSet rs = stmt.executeQuery(sql)){
				
				if(rs.next()) {
					System.out.println("id: "+rs.getInt("id"));
					System.out.println("user_id: "+rs.getString("user_id"));
					System.out.println("password: "+rs.getString("password"));
				}else {
					System.out.println("아이디 또는 비번이 틀렸습니다.");
				}
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
