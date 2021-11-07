package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import common.Common;
import infra.Member;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAO() {
		try {
			String dbURL ="jdbc:mysql://localhost:3306/cafe";
			String dbId = "root";
			String dbPasswd ="1234";
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(dbURL,dbId, dbPasswd);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int register(Member member) {
		String SQL ="INSERT INTO infrMember (ifmbId, ifmbPassword, ifmbFirstName, ifmbLastName, ifmbGenderCd, ifmbDob, ifmbNickName, ifmbRegIp, ifmbRegDatetime, ifmbRegDeviceCd)VALUE(?, ?, ?, ?, ?, ?, ?, ?, NOW(6), ?)";
//		String SQL = ""
//				+ "INSERT INTO "
//				+ "		infrMember "
//				+ "("
//				+ "		ifmbId"
//				+ "		, ifmbPassword"
//				+ "		, ifmbFirstName"
//				+ "		, ifmbLastName"
//				+ "		, ifmbGenderCd"
//				+ "		, ifmbDob"
//				+ "		, ifmbNickName"
//				+ "		, ifmbRegIp"
//				+ "		, ifmbRegDatetime"
//				+ "		, ifmbRegDeviceCd"
//				+ ")"
//				+ "VALUE"
//				+ "("
//				+ "		?"
//				+ "		, ?"
//				+ "		, ?"
//				+ "		, ?"
//				+ "		, ?"
//				+ "		, ?"
//				+ "		, ?"
//				+ "		, ?"
//				+ "		, NOW(6)"
//				+ "		, ?"
//				+ ")";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member.getIfmbId());
			pstmt.setString(2, member.getIfmbPassword());
			pstmt.setString(3, member.getIfmbFirstName());
			pstmt.setString(4, member.getIfmbLastName());
			pstmt.setInt(5, member.getIfmbGenderCd());
			pstmt.setString(6, member.getIfmbDob());
			pstmt.setString(7, member.getIfmbNickName());
			pstmt.setString(8, member.getIfmbRegIp());
			pstmt.setInt(9, member.getIfmbRegDeviceCd());
			
			return pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; // db error
	}
	
	public int login (Member member) {
		String SQL = "SELECT ifmbPassword FROM infrmember WHERE ifmbId = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member.getIfmbId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(Common.encrypt(member.getIfmbPassword()))) {
					return 1; //login success
				}
				else {
					return 0; //login fail
				}
			}
			return -1; // id not find
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; //db error
	}
}
