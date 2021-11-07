package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.Common;
import infra.Team;

public class TeamDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public TeamDAO() {
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
	
	public int createTeam(Team team,String ifmbId) {
		String SQL = "INSERT INTO infrTeam(	iftmName, iftmAnniversary, iftmStartDay, iftmTypeCd, iftmRegIp, iftmRegDatetime, iftmRegDeviceCd) VALUE (?, ?, ?, ?, ?, NOW(6), ?)";
//		String SQL = ""
//				+ "INSERT INTO "
//				+ "		infrTeam "
//				+ "("
//				+ "		iftmName"
//				+ "		, iftmAnniversary"
//				+ "		, iftmStartDay"
//				+ "		, iftmTypeCd"
//				+ "		, iftmRegIp"
//				+ "		, iftmRegDatetime"
//				+ "		, iftmRegDeviceCd"
//				+ ")"
//				+ "VALUE"
//				+ "("
//				+ "		?"
//				+ "		, ?"
//				+ "		, ?"
//				+ "		, ?"
//				+ "		, ?"
//				+ "		, NOW(6)"
//				+ "		, ?"
//				+ ")";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, team.getIftmName());
			pstmt.setString(2, team.getIftmAnniversary());
			pstmt.setString(3, team.getIftmStartDay());
			pstmt.setInt(4, team.getIftmTypeCd());
			pstmt.setString(5, team.getIftmRegIp());
			pstmt.setInt(6, team.getIftmRegDeviceCd());
			
			if(pstmt.executeUpdate() == 1) {
				SQL = "SELECT last_insert_id()";
				pstmt = conn.prepareStatement(SQL);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					int lastInsertId = rs.getInt(1);
					
					SQL = "UPDATE infrMember SET iftmSeq = ?, "
							+ "iftmAdminNy = 1 WHERE ifmbId = ?";
					pstmt = conn.prepareStatement(SQL);
					pstmt.setInt(1, lastInsertId);
					pstmt.setString(2, ifmbId);
					
					return pstmt.executeUpdate();
				}
				
				return -2; //last insert id ¸øºÒ·¯¿È
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; // db error
	}
	
	public int getTeamSeq(String ifmbId) {
		String SQL = "SELECT iftmSeq FROM infrMember WHERE ifmbId = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, ifmbId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1); // have team 
			} else {
				return 0; //no team
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //error
	}
	
	public Team getTeamData(int iftmSeq) {
		String SQL = "SELECT iftmStartDay, iftmAnniversary FROM infrTeam WHERE iftmSeq = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, iftmSeq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Team team = new Team();
				team.setIftmStartDay(rs.getString(1));
				team.setIftmAnniversary(rs.getString(2));
				
				return team; // have team 
			} else {
				return null; //no team
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; //error
	}
}
	

