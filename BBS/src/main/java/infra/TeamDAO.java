package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
					team.setIftmSeq(lastInsertId);
					this.updateInviteCode(team, ifmbId);
					
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
		String SQL = "SELECT iftmName, iftmTypeCd, iftmStartDay, iftmAnniversary, iftmInviteCd FROM infrTeam WHERE iftmSeq = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, iftmSeq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Team team = new Team();
				team.setIftmName(rs.getString(1));
				team.setIftmTypeCd(rs.getInt(2));
				team.setIftmStartDay(rs.getString(3));
				team.setIftmAnniversary(rs.getString(4));
				team.setIftmInviteCd(rs.getString(5));
				
				return team; // have team 
			} else {
				return null; //no team
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; //error
	}
	
	public int update(Team team, String ifmbId) {
		int result = -1;
		String SQL = "UPDATE infrTeam SET iftmTypeCd = ?, iftmStartDay = ?, iftmAnniversary = ?,iftmModDeviceCd = ?, iftmModIp = ?, iftmModDatetime = NOW(6), iftmModSeq = (select ifmbSeq from infrMember where ifmbId = ?) WHERE iftmSeq = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, team.getIftmTypeCd());
			pstmt.setString(2, team.getIftmStartDay());
			pstmt.setString(3, team.getIftmAnniversary());
			pstmt.setInt(4, team.getIftmModDeviceCd());
			pstmt.setString(5, team.getIftmModIp());
			pstmt.setString(6, ifmbId);
			pstmt.setInt(7, team.getIftmSeq());
			
			if(pstmt.executeUpdate() == 1) {
				result = 1;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public String updateInviteCode(Team team, String ifmbId) {
		String result = null;
		String SQL = "UPDATE infrTeam SET iftmInviteCd = ?,iftmModDeviceCd = ?, iftmModIp = ?, iftmModDatetime = NOW(6), iftmModSeq = (select ifmbSeq from infrMember where ifmbId = ?) WHERE iftmSeq = ?";
		try {
			String code = Common.createCode(team.getIftmSeq());
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, code);
			pstmt.setInt(2, team.getIftmModDeviceCd());
			pstmt.setString(3, team.getIftmModIp());
			pstmt.setString(4, ifmbId);
			pstmt.setInt(5, team.getIftmSeq());
			
			if(pstmt.executeUpdate() == 1) {
				result = code;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteByUpdate(Team team, String ifmbId) {
		int result = -1;
		if(new MemberDAO().isAdmin(ifmbId)) {
			System.out.print(1);
			String SQL = "UPDATE infrTeam SET iftmDelNy = 1, iftmModDeviceCd = ?, iftmModIp = ?, iftmModDatetime = NOW(6), iftmModSeq = (select ifmbSeq from infrMember where ifmbId = ?) WHERE iftmSeq = ?";
			try {
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, team.getIftmModDeviceCd());
				pstmt.setString(2, team.getIftmModIp());
				pstmt.setString(3, ifmbId);
				pstmt.setInt(4, team.getIftmSeq());
				
				if(pstmt.executeUpdate() == 1) {
					System.out.print(2);
					SQL = "UPDATE infrMember SET iftmSeq = NULL, iftmAdminNy = NULL, ifmbModDeviceCd = ?, ifmbModSeq = (select ifmbSeq from infrMember where ifmbId = ?), ifmbModIp = ?, ifmbModDatetime = NOW(6) WHERE iftmSeq = ?";
					pstmt = conn.prepareStatement(SQL);
					pstmt.setInt(1, team.getIftmModDeviceCd());
					pstmt.setString(2, ifmbId);
					pstmt.setString(3, team.getIftmModIp());
					pstmt.setInt(4, team.getIftmSeq());
					System.out.print("\n"+SQL);
					if(pstmt.executeUpdate() == 1) {
						result = 1;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;
	}
}
	

