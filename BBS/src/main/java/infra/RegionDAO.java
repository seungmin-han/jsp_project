package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RegionDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public RegionDAO() {
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
	
	public int posting(Region region, String ifmbId) {
		String SQL = "INSERT INTO infrRegion (ifrgSido,ifrgSigungu,ifrgEupmyeondong,ifrgImage, ifrgRegIp, ifrgRegDatetime, ifrgRegDeviceCd, iftmSeq ) VALUE (?,?,?,?,?,now(6),?,(SELECT iftmSeq FROM infrMember WHERE ifmbId = ?))";
//		String SQL = "INSERT INTO "
//						infrRegion
//					(
//						ifrgSido
//						,ifrgSigungu
//						,ifrgEupmyeondong
//						,ifrgImage
//						, ifrgRegIp
//						, ifrgRegDatetime
//						, ifrgRegDeviceCd
//						, iftmSeq
//					)
//					VALUE 
//					(
//						?
//						,?
//						,?
//						,?
//						,?
//						,now(6)
//						,?
//						,(SELECT iftmSeq FROM infrMember WHERE ifmbId = ?)
//					)";		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, region.getIfrgSido());
			pstmt.setString(2, region.getIfrgSigungu());
			pstmt.setString(3, region.getIfrgEupmyeondong());
			pstmt.setString(4, region.getIfrgImage());
			pstmt.setString(5, region.getIfrgRegIp());
			pstmt.setInt(6, region.getIfrgRegDeviceCd());
			pstmt.setString(7, ifmbId);
	
			
			if(pstmt.executeUpdate() == 1) {
				SQL = "SELECT last_insert_id()";
				pstmt = conn.prepareStatement(SQL);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					int lastInsertId = rs.getInt(1);
					return lastInsertId;
				} else {
					return 0; //마지막 auto increment값 반환 실패
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //DB에러
	}
	
	public String getRegionList(int iftmSeq) {
		String result = null;
		String SQL = "SELECT ifrgSido, ifrgSigungu, Count(*) FROM infrRegion WHERE 1=1 AND ifrgDelNy is null";
		if(iftmSeq != 0) SQL += " AND iftmSeq = ?";
		SQL += " AND ifrgSido IS NOT NULL GROUP BY ifrgSido, ifrgSigungu";
		
		try {
			pstmt = conn.prepareStatement(SQL);
			if(iftmSeq != 0) pstmt.setInt(1, iftmSeq);
			rs = pstmt.executeQuery();
			JSONArray jArr = new JSONArray();
			while(rs.next()) {
				JSONObject jObj = new JSONObject();
				jObj.put("ifrgSido", rs.getString(1));
				jObj.put("ifrgSigungu", rs.getString(2));
				jObj.put("count", rs.getInt(3));
				jArr.add(jObj);
			}
			result = jArr.toJSONString();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(Region region, int ifptSeq, String ifmbId) {
		int result = -1;
		String SQL = "UPDATE infrRegion SET ifrgSido = ?, ifrgSigungu = ?, ifrgModDeviceCd = ?, ifrgModIp = ?, ifrgModDatetime = NOW(6), ifrgModSeq = (select ifmbSeq from infrMember where ifmbId = ?) WHERE ifrgSeq = (select ifrgSeq from infrPost where ifptSeq = ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, region.getIfrgSido());
			pstmt.setString(2, region.getIfrgSigungu());
			pstmt.setInt(3, region.getIfrgModDeviceCd());
			pstmt.setString(4, region.getIfrgModIp());
			pstmt.setString(5, ifmbId);
			pstmt.setInt(6, ifptSeq);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteByUpdate(Region region, int ifptSeq, String ifmbId) {
		int result = -1;
		String SQL = "UPDATE infrRegion SET ifrgDelNy = 1, ifrgModDeviceCd = ?, ifrgModIp = ?, ifrgModDatetime = NOW(6), ifrgModSeq = (select ifmbSeq from infrMember where ifmbId = ?) WHERE ifrgSeq = (select ifrgSeq from infrPost where ifptSeq = ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, region.getIfrgModDeviceCd());
			pstmt.setString(2, region.getIfrgModIp());
			pstmt.setString(3, ifmbId);
			pstmt.setInt(4, ifptSeq);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
