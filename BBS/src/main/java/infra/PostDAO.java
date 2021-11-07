package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.json.simple.*;

import common.Common;

public class PostDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public PostDAO() {
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
	
	public int posting(Post post, String ifmbId, int ifrgSeq) {
		String SQL = "INSERT INTO infrPost (ifptTitle, ifptContent, ifptPublicNy, ifptRegIp, ifptRegDatetime, ifptRegDeviceCd, ifmbSeq, iftmSeq, ifrgSeq) VALUE (?, ?, ?, ?, NOW(6), ?, (SELECT ifmbSeq FROM infrMember where ifmbId = ?), (SELECT iftmSeq FROM infrmember where ifmbId = ?), ?)";
//		String SQL = "
//		INSERT INTO 
//			infrPost 
//		(
//			ifptTitle
//			, ifptContent
//			, ifptPublicNy
//			, ifptRegIp
//			, ifptRegDatetime
//			, ifptRegDeviceCd
//			, ifmbSeq
//			, iftmSeq
// 			, ifrgSeq
//		) 
//		VALUE 
//		(
//			?
//			, ?
//			, ?
//			, ?
//			, ?
//			, NOW(6)
//			, ?
//			, (SELECT ifmbSeq FROM infrMember where ifmbId = ?)
//			, (SELECT iftmSeq FROM infrmember where ifmbId = ?)
//			, ?
//		)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, post.getIfptTitle());
			pstmt.setString(2, post.getIfptContent());
			pstmt.setInt(3, post.getIfptPublicNy());
			pstmt.setString(4, post.getIfptRegIp());
			pstmt.setInt(5, post.getIfptRegDeviceCd());
			pstmt.setString(6, ifmbId);
			pstmt.setString(7, ifmbId);
			pstmt.setInt(8, ifrgSeq);
			
			if(pstmt.executeUpdate() == 1) {
				SQL = "SELECT last_insert_id()";
				pstmt = conn.prepareStatement(SQL);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				} else {
					return 0;
				}
			}
			return -1;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
	
	public String getDatas(int iftmSeq) {
		String result = null; 
		String SQL = "SELECT ifptSeq, ifrgSido, ifptTitle, ifmbId, ifptRegDatetime, ifptViewer FROM infrPost INNER JOIN infrMember ON infrMember.ifmbSeq = infrPost.ifmbSeq INNER JOIN infrRegion ON infrRegion.ifrgSeq = infrPost.ifrgSeq WHERE infrPost.iftmSeq = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, iftmSeq);
			rs = pstmt.executeQuery();
//			JSONObject mainJobj = new JSONObject();
			JSONArray jArr = new JSONArray();
			while(rs.next()) {
				JSONObject jObj = new JSONObject();
				jObj.put("ifptSeq",rs.getInt("ifptSeq"));
				jObj.put("ifrgSido",rs.getString("ifrgSido"));
				jObj.put("ifptTitle",rs.getString("ifptTitle"));
				jObj.put("ifmbId",rs.getString("ifmbId"));
				jObj.put("ifptRegDatetime",rs.getString("ifptRegDatetime"));
				jObj.put("ifptViewer",rs.getInt("ifptViewer"));
				
				jArr.add(jObj);
			}
//			mainJobj.put("list", jArr);
			result = jArr.toJSONString();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String getOne(int ifptSeq) {
		String result = null; 
		String SQL = "SELECT ifptSeq, ifrgSido, ifrgSigungu, ifrgEupmyeondong, ifptTitle, ifmbId, ifptContent, ifptRegDatetime, ifptViewer FROM infrPost INNER JOIN infrMember ON infrMember.ifmbSeq = infrPost.ifmbSeq INNER JOIN infrRegion ON infrRegion.ifrgSeq = infrPost.ifrgSeq WHERE infrPost.ifptSeq = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, ifptSeq);
			rs = pstmt.executeQuery();
			JSONObject jObj = new JSONObject();
			if(rs.next()) {
				jObj.put("ifptSeq",rs.getInt("ifptSeq"));
				jObj.put("ifrgSido",rs.getString("ifrgSido"));
				jObj.put("ifrgSigungu",rs.getString("ifrgSigungu"));
				jObj.put("ifrgEupmyeondong",rs.getString("ifrgEupmyeondong"));
				jObj.put("ifptTitle",rs.getString("ifptTitle"));
				jObj.put("ifmbId",rs.getString("ifmbId"));
				jObj.put("ifptContent",rs.getString("ifptContent"));
				jObj.put("ifptRegDatetime",rs.getString("ifptRegDatetime"));
				jObj.put("ifptViewer",rs.getInt("ifptViewer"));
			}
			result = jObj.toJSONString();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}


