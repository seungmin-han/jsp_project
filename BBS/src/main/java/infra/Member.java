package infra;

public class Member {
	private String ifmbFirstName; 	// 이름
	private String ifmbLastName; 	// 성
	private String ifmbId; 			// 아이디
	private String ifmbPassword; 	// 비밀번호
	private String ifmbDob;			// 생년월일
	private String ifmbNickName;	// 닉네임
	private String ifmbRegIp; 		// 가입 아이피 
	private String ifmbRegDatetime;	// 가입 날짜 (소수점 6자리까지 표기)
	private String ifmbModIp; 		// 데이터 수정 아이피 
	private String ifmbModDatetime;	// 데이터 수정 날짜 (소수점 6자리까지 표기)
	private int ifmbSeq;			// infrMember 테이블의 primary key 
	private int ifmbGenderCd; 		// 성별코드 1: 남성 2: 여성
	private int ifmbDormantNy;		// 휴면상태 0: 활동 1: 휴면
	private int ifmbAdminNy;		// 관리자여부 0: 일반 사용자 1: 페이지 관리자
	private int ifmbRegSeq; 		// 가입 seq
	private int ifmbRegDeviceCd; 	// 가입 기기 1: PC 2: Mobile 
	private int ifmbModSeq; 		// 데이터 수정 seq
	private int ifmbModDeviceCd; 	// 데이터 수정 기기 1: PC 2: Mobile 
	private int iftmSeq;			// team 테이블의 외래키
	private int iftmAdminNy;		// team의 어드민 여부 0:일반유저 1:어드민
	private int ifmbDelNy; 			// 데이터 삭제 여부 0: 존재함 1: 삭제됨 
	
	
	public String getIfmbFirstName() {
		return ifmbFirstName;
	}
	public void setIfmbFirstName(String ifmbFirstName) {
		this.ifmbFirstName = ifmbFirstName;
	}
	public String getIfmbLastName() {
		return ifmbLastName;
	}
	public void setIfmbLastName(String ifmbLastName) {
		this.ifmbLastName = ifmbLastName;
	}
	public String getIfmbId() {
		return ifmbId;
	}
	public void setIfmbId(String ifmbId) {
		this.ifmbId = ifmbId;
	}
	public String getIfmbPassword() {
		return ifmbPassword;
	}
	public void setIfmbPassword(String ifmbPassword) {
		this.ifmbPassword = ifmbPassword;
	}
	public String getIfmbDob() {
		return ifmbDob;
	}
	public void setIfmbDob(String ifmbDob) {
		this.ifmbDob = ifmbDob;
	}
	public String getIfmbNickName() {
		return ifmbNickName;
	}
	public void setIfmbNickName(String ifmbNickName) {
		this.ifmbNickName = ifmbNickName;
	}
	public String getIfmbRegIp() {
		return ifmbRegIp;
	}
	public void setIfmbRegIp(String ifmbRegIp) {
		this.ifmbRegIp = ifmbRegIp;
	}
	public String getIfmbRegDatetime() {
		return ifmbRegDatetime;
	}
	public void setIfmbRegDatetime(String ifmbRegDatetime) {
		this.ifmbRegDatetime = ifmbRegDatetime;
	}
	public String getIfmbModIp() {
		return ifmbModIp;
	}
	public void setIfmbModIp(String ifmbModIp) {
		this.ifmbModIp = ifmbModIp;
	}
	public String getIfmbModDatetime() {
		return ifmbModDatetime;
	}
	public void setIfmbModDatetime(String ifmbModDatetime) {
		this.ifmbModDatetime = ifmbModDatetime;
	}
	public int getIfmbGenderCd() {
		return ifmbGenderCd;
	}
	public void setIfmbGenderCd(int ifmbGenderCd) {
		this.ifmbGenderCd = ifmbGenderCd;
	}
	public int getIfmbDormantNy() {
		return ifmbDormantNy;
	}
	public void setIfmbDormantNy(int ifmbDormantNy) {
		this.ifmbDormantNy = ifmbDormantNy;
	}
	public int getIfmbAdminNy() {
		return ifmbAdminNy;
	}
	public void setIfmbAdminNy(int ifmbAdminNy) {
		this.ifmbAdminNy = ifmbAdminNy;
	}
	public int getIfmbDelNy() {
		return ifmbDelNy;
	}
	public void setIfmbDelNy(int ifmbDelNy) {
		this.ifmbDelNy = ifmbDelNy;
	}
	public int getIfmbRegSeq() {
		return ifmbRegSeq;
	}
	public void setIfmbRegSeq(int ifmbRegSeq) {
		this.ifmbRegSeq = ifmbRegSeq;
	}
	public int getIfmbRegDeviceCd() {
		return ifmbRegDeviceCd;
	}
	public void setIfmbRegDeviceCd(int ifmbRegDeviceCd) {
		this.ifmbRegDeviceCd = ifmbRegDeviceCd;
	}
	public int getIfmbModSeq() {
		return ifmbModSeq;
	}
	public void setIfmbModSeq(int ifmbModSeq) {
		this.ifmbModSeq = ifmbModSeq;
	}
	public int getIfmbModDeviceCd() {
		return ifmbModDeviceCd;
	}
	public void setIfmbModDeviceCd(int ifmbModDeviceCd) {
		this.ifmbModDeviceCd = ifmbModDeviceCd;
	}
	public int getIftmSeq() {
		return iftmSeq;
	}
	public void setIftmSeq(int iftmSeq) {
		this.iftmSeq = iftmSeq;
	}
	public int getIftmAdminNy() {
		return iftmAdminNy;
	}
	public void setIftmAdminNy(int iftmAdminNy) {
		this.iftmAdminNy = iftmAdminNy;
	}
	public void setIfmbSeq(int ifmbSeq) {
		this.ifmbSeq = ifmbSeq;
	}
	public int getIfmbSeq() {
		return ifmbSeq;
	}
	
	
	
}
