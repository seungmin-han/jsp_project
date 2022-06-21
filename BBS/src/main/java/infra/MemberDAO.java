package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
		int result = -1;
		String SQL = "SELECT ifmbPassword, iftmAdminNy FROM infrmember WHERE ifmbId = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member.getIfmbId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(Common.encrypt(member.getIfmbPassword()))) {
					result = rs.getInt(2); //login success
				}
				else {
					result = -2; //login fail
				}
			} else {
				result = -3;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean isAdmin(String ifmbId) {
		boolean result = false;
		String SQL = "SELECT iftmAdminNy FROM infrMember where ifmbId = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, ifmbId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)==1) {
					result = true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public int joinTeam(Member member,String code) {
		int result = -1;
		String SQL = "UPDATE infrMember SET iftmSeq = (select iftmSeq from infrTeam where iftmInviteCd = ?), iftmAdminNy = 0, ifmbModSeq = (SELECT ifmbSeq FROM infrMember WHERE ifmbId = ?), ifmbModDeviceCd = ?, ifmbModIp = ?, ifmbModDatetime = NOW(6) WHERE ifmbId = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, code);
			pstmt.setString(2, member.getIfmbId());
			pstmt.setInt(3, member.getIfmbModDeviceCd());
			pstmt.setString(4, member.getIfmbModIp());
			pstmt.setString(5, member.getIfmbId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public int leaveTeam(Member member) {
		int result = -1;
		String SQL = "UPDATE infrMember SET iftmSeq = NULL, iftmAdminNy = NULL, ifmbModSeq = (SELECT ifmbSeq FROM infrMember WHERE ifmbId = ?), ifmbModDeviceCd = ?, ifmbModIp = ?, ifmbModDatetime = NOW(6) WHERE ifmbId = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member.getIfmbId());
			pstmt.setInt(2, member.getIfmbModDeviceCd());
			pstmt.setString(3, member.getIfmbModIp());
			pstmt.setString(4, member.getIfmbId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public String getTeamMemberList(int iftmSeq, String ifmbId) {
		String result = "";
		String SQL = "SELECT ifmbSeq, ifmbId FROM infrMember WHERE iftmSeq = ? AND ifmbId != ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, iftmSeq);
			pstmt.setString(2, ifmbId);
			
			rs = pstmt.executeQuery();
			JSONArray jArr = new JSONArray(); 
			while(rs.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("ifmbId", rs.getString("ifmbId"));
				
				jArr.add(jobj);
			}
			
			result = jArr.toJSONString();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}
	
	public Member getOne(String ifmbId) {
		Member result = null;
		String SQL = "SELECT * FROM infrMember where ifmbId = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, ifmbId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new Member();
				result.setIfmbFirstName(rs.getString("ifmbFirstName"));
				result.setIfmbLastName(rs.getString("ifmbLastName"));
				result.setIfmbNickName(rs.getString("ifmbNickName"));
				result.setIfmbGenderCd(rs.getInt("ifmbGenderCd"));
				result.setIfmbDob(rs.getString("ifmbDob"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int update(Member member, String ifmbId) {
		int result = -1;
		String SQL = "UPDATE infrMember SET ifmbLastName = ?, ifmbFirstName = ?, ifmbNickName = ?, ifmbDob = ?, ifmbGenderCd = ?, ifmbModIp = ?, ifmbModDeviceCd = ?, ifmbModSeq = (select ifmbSeq from infrMember where ifmbId = ?), ifmbModDatetime = NOW(6) WHERE ifmbId = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member.getIfmbLastName());
			pstmt.setString(2, member.getIfmbFirstName());
			pstmt.setString(3, member.getIfmbNickName());
			pstmt.setString(4, member.getIfmbDob());
			pstmt.setInt(5, member.getIfmbGenderCd());
			pstmt.setString(6, member.getIfmbModIp());
			pstmt.setInt(7, member.getIfmbModDeviceCd());
			pstmt.setString(8, ifmbId);
			pstmt.setString(9, ifmbId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
}





