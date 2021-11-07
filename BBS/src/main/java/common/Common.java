package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
	public static String getClientIp(HttpServletRequest req) {						//������� �����Ǹ� �������� �޼ҵ�
	    String ip = req.getHeader("X-Forwarded-For");
	    if (ip == null) ip = req.getRemoteAddr();
	    return ip;
	    
	    
	    // ����: https://linked2ev.github.io/java/2019/05/22/JAVA-1.-java-get-clientIP/
	}
	
	public static String encrypt(String text) throws NoSuchAlgorithmException { 	//��й�ȣ ��ȣȭ �޼ҵ�
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
    	//����ǥ���İ� mathes()�޼��带 �̿��� Device ã�� (���� ����̽��� �׷����� ���� ��ġ�ϴ��� �˻�) 
    	boolean mobile1 = userAgent.matches( ".*(iPhone|iPod|Android|Windows CE|BlackBerry|Symbian|Windows Phone|webOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson).*");
    	boolean mobile2 = userAgent.matches(".*(LG|SAMSUNG|Samsung).*"); 

    	if (mobile1 || mobile2) {
    		return 2; 					//mobile
    	} else {
        	return 1;					//web(PC)
    	}
    	
    	//���� : https://8millimeters.tistory.com/10
    }
   
    public static String getToday() {												//���� ��¥�� String���� ��ȯ�ϴ� �޼ҵ�
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String today = sdf.format(date);
    	
    	return today;
    }
    
    public static void moveTo(String url, HttpServletResponse response) {			//url�� �޾� �̵�
    	PrintWriter printWriter = null;
    	try {
			printWriter = response.getWriter();
			printWriter.print("<script>location.href='"+url+"'</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void moveBack(HttpServletResponse response) {						//���� �������� �̵�
    	PrintWriter printWriter = null;
    	try {
			printWriter = response.getWriter();
			printWriter.print("<script>history.back();</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void alert(String msg, HttpServletResponse response) {			//���â�� ���� �޼ҵ�
    	PrintWriter printWriter = null;
    	try {
			printWriter = response.getWriter();
			printWriter.print("<script>alert('"+msg+"');</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
