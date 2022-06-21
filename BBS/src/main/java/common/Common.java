package common;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
	public static String getClientIp(HttpServletRequest req) {						//사용자의 아이피를 가져오는 메소드
	    String ip = req.getHeader("X-Forwarded-For");
	    if (ip == null) ip = req.getRemoteAddr();
	    return ip;
	    
	    
	    // 참조: https://linked2ev.github.io/java/2019/05/22/JAVA-1.-java-get-clientIP/
	}
	
	public static String encrypt(String text) throws NoSuchAlgorithmException { 	//비밀번호 암호화 메소드
        MessageDigest md = MessageDigest.getInstance("SHA-256");	
        md.update(text.getBytes());
        
        return bytesToHex(md.digest());
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
    
    public static int getDeviceCd(HttpServletRequest req) {
    	String userAgent = req.getHeader("user-agent");
    	//정규표현식과 mathes()메서드를 이용한 Device 찾기 (여러 디바이스를 그룹으로 묶고 일치하는지 검사) 
    	boolean mobile1 = userAgent.matches( ".*(iPhone|iPod|Android|Windows CE|BlackBerry|Symbian|Windows Phone|webOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson).*");
    	boolean mobile2 = userAgent.matches(".*(LG|SAMSUNG|Samsung).*"); 

    	if (mobile1 || mobile2) {
    		return 2; 					//mobile
    	} else {
        	return 1;					//web(PC)
    	}
    	
    	//참조 : https://8millimeters.tistory.com/10
    }
   
    public static String getToday() {												//오늘 날짜를 String으로 반환하는 메소드
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String today = sdf.format(date);
    	
    	return today;
    }
    
    public static void moveTo(String url, int replace, HttpServletResponse response) {			//url을 받아 이동
    	PrintWriter printWriter = null;
    	try {
    		printWriter = response.getWriter();
    		if(replace == 1) {
    			printWriter.print("<script>location.replace('"+url+"')</script>");
    		} else {
    			printWriter.print("<script>location.href='"+url+"'</script>");
    		}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void moveBack(HttpServletResponse response) {						//이전 페이지로 이동
    	PrintWriter printWriter = null;
    	try {
			printWriter = response.getWriter();
			printWriter.print("<script>history.back();</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void alert(String msg, HttpServletResponse response) {			//경고창을 띄우는 메소드
    	PrintWriter printWriter = null;
    	try {
			printWriter = response.getWriter();
			printWriter.print("<script>alert('"+msg+"');</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static String calcDate(String date)										// 입력한 날짜와 오늘 날짜를 비교하여 일 수를 계산
    {
    	String currentDate = Common.getToday();
        String inputDate = date;
     
        try{ 
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            Date firstDate = format.parse(currentDate);
            Date secondDate = format.parse(inputDate);
            
            
            long calDate = secondDate.getTime() - firstDate.getTime();
            
            long calDateDays = calDate / (24*60*60*1000);
     
            calDateDays = Math.abs(calDateDays);
            
            return Long.toString(calDateDays+1);
            }
            catch(ParseException e)
            {
                // 예외 처리
            }
        return null;
    }    


    //    출처: https://highcode.tistory.com/5 [HighCode]
    
    public static String createCode(int iftmSeq) {
    	int length = 16 - (int)(Math.log10(iftmSeq)+1);
    	String code = RandomStringUtils.randomAlphanumeric(length)+iftmSeq;
    	return code;
    }
    
    // 참고: https://hahaha2016.tistory.com/3
}
