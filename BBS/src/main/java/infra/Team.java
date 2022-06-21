package infra;

public class Team {
	private String iftmName;			//팀 이름
	private String iftmAnniversary;		//팀에서 지정한 문구 또는 기념일
	private String iftmStartDay;		//팀에서 지정한 시작일자
	
	private String iftmInviteCd;		//팀을 가입하기 위한 코드
	
	private String iftmRegIp;			//가입 아이피
	private String iftmRegDatetime;		//가입 날짜 (소수점 6자리까지 표시)
	private String iftmModIp;			//데이터 수정 아이피
	private String iftmModDatetime;		//데이터 수정 날짜 (소수점 6자리까지 표시)
	private int iftmSeq;				//infrTeam 테이블의 primary key
	private int iftmTypeCd; 			//팀의 유형 1:개인 2:커플 3:단체
	private int iftmRegSeq;				//가입 seq
	private int iftmModSeq;				//데이터 수정 seq
	private int iftmRegDeviceCd;		//가입 기기 1:PC 2:Mobile
	private int iftmModDeviceCd;		//데이터 수정 기기 1:PC 2:Mobile
	private int iftmDelNy;				//데이터 삭제 여부 0:존재함 1:삭제됨
	
	public String getIftmName() {
		return iftmName;
	}
	public void setIftmName(String iftmName) {
		this.iftmName = iftmName;
	}
	public String getIftmAnniversary() {
		return iftmAnniversary;
	}
	public void setIftmAnniversary(String iftmAnniversary) {
		this.iftmAnniversary = iftmAnniversary;
	}
	public String getIftmStartDay() {
		return iftmStartDay;
	}
	public void setIftmStartDay(String iftmStartDay) {
		this.iftmStartDay = iftmStartDay;
	}
	public String getIftmRegIp() {
		return iftmRegIp;
	}
	public void setIftmRegIp(String iftmRegIp) {
		this.iftmRegIp = iftmRegIp;
	}
	public String getIftmRegDatetime() {
		return iftmRegDatetime;
	}
	public void setIftmRegDatetime(String iftmRegDatetime) {
		this.iftmRegDatetime = iftmRegDatetime;
	}
	public String getIftmModIp() {
		return iftmModIp;
	}
	public void setIftmModIp(String iftmModIp) {
		this.iftmModIp = iftmModIp;
	}
	public String getIftmModDatetime() {
		return iftmModDatetime;
	}
	public void setIftmModDatetime(String iftmModDatetime) {
		this.iftmModDatetime = iftmModDatetime;
	}
	public int getIftmSeq() {
		return iftmSeq;
	}
	public void setIftmSeq(int iftmSeq) {
		this.iftmSeq = iftmSeq;
	}
	public int getIftmTypeCd() {
		return iftmTypeCd;
	}
	public void setIftmTypeCd(int iftmTypeCd) {
		this.iftmTypeCd = iftmTypeCd;
	}
	public int getIftmRegSeq() {
		return iftmRegSeq;
	}
	public void setIftmRegSeq(int iftmRegSeq) {
		this.iftmRegSeq = iftmRegSeq;
	}
	public int getIftmModSeq() {
		return iftmModSeq;
	}
	public void setIftmModSeq(int iftmModSeq) {
		this.iftmModSeq = iftmModSeq;
	}
	public int getIftmRegDeviceCd() {
		return iftmRegDeviceCd;
	}
	public void setIftmRegDeviceCd(int iftmRegDeviceCd) {
		this.iftmRegDeviceCd = iftmRegDeviceCd;
	}
	public int getIftmModDeviceCd() {
		return iftmModDeviceCd;
	}
	public void setIftmModDeviceCd(int iftmModDeviceCd) {
		this.iftmModDeviceCd = iftmModDeviceCd;
	}
	public int getIftmDelNy() {
		return iftmDelNy;
	}
	public void setIftmDelNy(int iftmDelNy) {
		this.iftmDelNy = iftmDelNy;
	}
	
	public String getIftmInviteCd() {
		return iftmInviteCd;
	}
	public void setIftmInviteCd(String iftmInviteCd) {
		this.iftmInviteCd = iftmInviteCd;
	}
	
	
}
