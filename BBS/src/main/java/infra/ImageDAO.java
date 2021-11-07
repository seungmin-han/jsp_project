package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ImageDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ImageDAO() {
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
	
	public int imageUpload(Image img, String ifmbId, int ifptSeq) {
		String SQL="INSERT INTO infrImage (ifimName, ifimType, ifimPath, ifimSize, ifimRegIp, ifimRegDatetime, ifimRegDeviceCd,ifmbSeq, iftmSeq, ifptSeq) VALUE(?, ?, ?, ?, ?, NOW(6), ?, (SELECT ifmbSeq FROM infrMember WHERE ifmbId = ?), (SELECT iftmSeq FROM infrMember WHERE ifmbId = ?), ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, img.getIfimName());
			pstmt.setString(2, img.getIfimType());
			pstmt.setString(3, img.getIfimPath());
			pstmt.setInt(4, img.getIfimSize());
			pstmt.setString(5, img.getIfimRegIp());
			pstmt.setInt(6, img.getIfimRegDeviceCd());
			pstmt.setString(7, ifmbId);
			pstmt.setString(8, ifmbId);
			pstmt.setInt(9, ifptSeq);
			return pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
