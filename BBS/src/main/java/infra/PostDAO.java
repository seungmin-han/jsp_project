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
	
	public String getList(int iftmSeq, String category) {
		String result = null; 
		String SQL = "SELECT infrPost.ifptSeq, ifrgSido, ifptTitle, ifmbId, ifptRegDatetime, ifptViewer FROM infrPost INNER JOIN infrMember ON infrMember.ifmbSeq = infrPost.ifmbSeq INNER JOIN infrRegion ON infrRegion.ifrgSeq = infrPost.ifrgSeq WHERE 1=1"; 
		if(iftmSeq != 0) SQL += " AND ifptDelNy = 0 AND infrPost.iftmSeq = ?";
		if(!category.isEmpty()) SQL += " AND ifptNoticeNy = 1";
		SQL += " ORDER BY ifptSeq DESC";
		try {
			pstmt = conn.prepareStatement(SQL);
			if(iftmSeq != 0) pstmt.setInt(1, iftmSeq);
			rs = pstmt.executeQuery();
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
			result = jArr.toJSONString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String getList(int iftmSeq, String category, String keyword) {
		System.out.println(keyword);
		String result = null; 
		int idx = 1;
		String SQL = "SELECT infrPost.ifptSeq, ifrgSido, ifptTitle, ifmbId, ifptRegDatetime, ifptViewer FROM infrPost INNER JOIN infrMember ON infrMember.ifmbSeq = infrPost.ifmbSeq INNER JOIN infrRegion ON infrRegion.ifrgSeq = infrPost.ifrgSeq WHERE 1=1 AND ifptDelNy is null"; 
		if(iftmSeq != 0) SQL += " AND infrPost.iftmSeq = ?";
		if(!category.isEmpty()) SQL += " AND ifptNoticeNy = 1";
		if(!keyword.isEmpty()) SQL += " AND ifptTitle LIKE ?";
		SQL += " ORDER BY ifptSeq DESC";
		
		System.out.println(SQL);
		try {
			pstmt = conn.prepareStatement(SQL);
			if(iftmSeq != 0) {
				pstmt.setInt(idx, iftmSeq);
				idx++;
			}
			if(!keyword.isEmpty()) {
				System.out.println(idx);
				pstmt.setString(idx, "%"+keyword+"%");
			}
			rs = pstmt.executeQuery();
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
			result = jArr.toJSONString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	public String getCardList() {
		String result = null; 
		String SQL = "SELECT infrPost.ifptSeq, ifnull(ifimPath,'.\\\\images\\\\') as ifimPath, ifnull(ifimName,'no_img.jpg') as ifimName, ifrgSido, ifptTitle, ifmbId, ifptRegDatetime, ifptViewer FROM infrPost LEFT JOIN infrImage ON infrImage.ifptSeq = infrPost.ifptSeq INNER JOIN infrRegion ON infrRegion.ifrgSeq = infrPost.ifrgSeq INNER JOIN infrMember ON infrMember.ifmbSeq = infrPost.ifmbSeq where ifptDelNy is null group by ifptSeq"; 
		SQL += " ORDER BY infrPost.ifptSeq DESC LIMIT 5";
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			JSONArray jArr = new JSONArray();
			while(rs.next()) {
				JSONObject jObj = new JSONObject();
				jObj.put("ifptSeq",rs.getInt("ifptSeq"));
				jObj.put("ifimPath",rs.getString("ifimPath"));
				jObj.put("ifimName",rs.getString("ifimName"));
				jObj.put("ifrgSido",rs.getString("ifrgSido"));
				jObj.put("ifptTitle",rs.getString("ifptTitle"));
				jObj.put("ifmbId",rs.getString("ifmbId"));
				jObj.put("ifptRegDatetime",rs.getString("ifptRegDatetime"));
				jObj.put("ifptViewer",rs.getInt("ifptViewer"));
				
				jArr.add(jObj);
			}
			result = jArr.toJSONString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String getRecommendList(String userId) {
		int flag = 0;
		if(userId.equals("guest")) {
			flag = 1;
		}
		
		String result = null;
		String SQL = "SELECT infrPost.ifptSeq, ifnull(ifimPath,'.\\\\images\\\\') as ifimPath, ifnull(ifimName,'no_img.jpg') as ifimName, ifrgSido, ifnull(ifrgSigungu,'') as ifrgSigungu, ifptTitle, ifmbId, ifptRegDatetime, ifptViewer FROM infrPost LEFT JOIN infrImage ON infrImage.ifptSeq = infrPost.ifptSeq LEFT JOIN infrRegion ON infrRegion.ifrgSeq = infrPost.ifrgSeq INNER JOIN infrMember ON infrMember.ifmbSeq = infrPost.ifmbSeq WHERE (ifrgSido,ifrgSigungu) not in (select ifrgSido, ifrgSigungu from infrRegion where iftmSeq = (select iftmSeq from infrMember where ifmbId = ? and ifrgSido is not null) group by ifrgSido,ifrgSigungu ) and ifptDelNy is null group by ifrgSido, ifrgSigungu order by ifptRegDatetime DESC limit 3";
		if(flag == 1) {
			SQL = "SELECT infrPost.ifptSeq, ifnull(ifimPath,'.\\\\images\\\\') as ifimPath, ifnull(ifimName,'no_img.jpg') as ifimName, ifrgSido, ifnull(ifrgSigungu,'') as ifrgSigungu, ifptTitle, ifmbId, ifptRegDatetime, ifptViewer FROM infrPost LEFT JOIN infrImage ON infrImage.ifptSeq = infrPost.ifptSeq LEFT JOIN infrRegion ON infrRegion.ifrgSeq = infrPost.ifrgSeq INNER JOIN infrMember ON infrMember.ifmbSeq = infrPost.ifmbSeq where ifptDelNy is null group by infrPost.ifptSeq ORDER BY ifptViewer DESC, ifptRegDatetime DESC LIMIT 3";
			
		}
		JSONArray jArr = new JSONArray();
		try {
			
			pstmt = conn.prepareStatement(SQL);
			if(flag != 1) pstmt.setString(1, userId);
				
			rs = pstmt.executeQuery();
			while(rs.next()) {
				JSONObject jObj = new JSONObject();
				jObj.put("ifptSeq",rs.getInt("ifptSeq"));
				jObj.put("ifimPath",rs.getString("ifimPath"));
				jObj.put("ifimName",rs.getString("ifimName"));
				jObj.put("ifrgSido",rs.getString("ifrgSido"));
				jObj.put("ifrgSigungu",rs.getString("ifrgSigungu"));
				jObj.put("ifptTitle",rs.getString("ifptTitle"));
				jObj.put("ifmbId",rs.getString("ifmbId"));
				jObj.put("ifptRegDatetime",rs.getString("ifptRegDatetime"));
				jObj.put("ifptViewer",rs.getInt("ifptViewer"));
				
				jArr.add(jObj);
			}
			result = jArr.toJSONString();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public String getOne(int ifptSeq) {
		String result = null; 
		String SQL = "SELECT ifptSeq, ifrgSido, ifrgSigungu, ifptTitle, ifmbId, ifptContent, ifptRegDatetime, ifptViewer, ifptPublicNy FROM infrPost INNER JOIN infrMember ON infrMember.ifmbSeq = infrPost.ifmbSeq INNER JOIN infrRegion ON infrRegion.ifrgSeq = infrPost.ifrgSeq WHERE infrPost.ifptSeq = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, ifptSeq);
			rs = pstmt.executeQuery();
			JSONObject jObj = new JSONObject();
			if(rs.next()) {
				jObj.put("ifptSeq",rs.getInt("ifptSeq"));
				jObj.put("ifrgSido",rs.getString("ifrgSido"));
				jObj.put("ifrgSigungu",rs.getString("ifrgSigungu"));
				jObj.put("ifptTitle",rs.getString("ifptTitle"));
				jObj.put("ifmbId",rs.getString("ifmbId"));
				jObj.put("ifptContent",rs.getString("ifptContent"));
				jObj.put("ifptRegDatetime",rs.getString("ifptRegDatetime"));
				jObj.put("ifptPublicNy",rs.getString("ifptPublicNy"));
				jObj.put("ifptViewer",rs.getInt("ifptViewer"));
			}
			result = jObj.toJSONString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(Post post, String ifmbId) {
		int result = -1;
		String SQL = "UPDATE infrPost SET ifptTitle = ?, ifptContent = ?, ifptPublicNy = ?, ifptModDatetime = NOW(6), ifptModDeviceCd = ?, ifptModIp = ?, ifptModSeq = (select ifmbSeq from infrMember where ifmbId = ?) WHERE ifptSeq = ? ";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, post.getIfptTitle());
			pstmt.setString(2, post.getIfptContent());
			pstmt.setInt(3, post.getIfptPublicNy());
			pstmt.setInt(4, post.getIfptModDeviceCd());
			pstmt.setString(5, post.getIfptModIp());
			pstmt.setString(6, ifmbId);
			pstmt.setInt(7, post.getIfptSeq());
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteByUpdate(Post post, String ifmbId) {
		int result = -1;
		String SQL = "UPDATE infrPost SET ifptDelNy = 1, ifptModDatetime = NOW(6), ifptModDeviceCd = ?, ifptModIp = ?, ifptModSeq = (select ifmbSeq from infrMember where ifmbId = ?) WHERE ifptSeq = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, post.getIfptModDeviceCd());
			pstmt.setString(2, post.getIfptModIp());
			pstmt.setString(3, ifmbId);
			pstmt.setInt(4, post.getIfptSeq());
			
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateViewer(int ifptSeq) {
		System.out.println(ifptSeq);
		int result = -1;
		String SQL = "UPDATE infrPost SET ifptViewer = ifptViewer + 1 WHERE ifptSeq = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, ifptSeq);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}


