package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conning.DBConn;

public class Dao {
	

	//1.insert
	public int insertData(Dto dto){
		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		sql = "insert into naverMember (id,pw,name,gender,birth,email,tel) ";
		sql+= "values (?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getBirth());
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getTel());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return result;
	}

	//2.update
	public int updateData(Dto dto){

		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "update naverMember set pw=?, email=?, tel=? ";
			sql+= "where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getTel());
			pstmt.setString(4, dto.getId());

			result = pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	//3.delete
	public int deleteDate(String id, String pw){
		int result = 0;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "delete naverMember where id=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			result = pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return result;	
	}
	
	//4.selectAll
	public List<Dto> getList() {
		List<Dto> lists = new ArrayList<Dto>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select id,pw,name,gender,birth,email,tel ";
			sql+= "from naverMember order by name";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				Dto dto = new Dto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));

				lists.add(dto);	

			}
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return lists;
	}


	//5.searchId
	public List<Dto> getList(String id){
		List<Dto> lists = new ArrayList<Dto>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try{
			sql = "select id,pw,name,gender,birth,email,tel ";
			sql+= "from naverMember where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while(rs.next()){
				Dto dto = new Dto();

				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));

				lists.add(dto);
			}
			rs.close();
			pstmt.close();

		}catch (SQLException e) {
			System.out.println(e.toString());

		}
		return lists;
	}


}
