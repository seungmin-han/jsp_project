package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
