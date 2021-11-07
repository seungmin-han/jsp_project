package infra;

public class Image {
	private String ifimName;		//이미지파일이름
	private String ifimType;		//이미지타입 
	private String ifimPath;		//이미지 경로
	private String ifimRegIp;		//가입 아이피
	private String ifimModIp;		//데이터 수정 아이피
	private String ifimRegDatetime;	//가입 날짜
	private String ifimModDatetime;	//데이터 수정 날짜
	private int ifimRegDeviceCd;	//가입 기기 1: PC 2: Mobile
	private int ifimModDeviceCd;	//데이터 수정 기기 1: PC 2: Mobile
	private int ifimRegSeq;			//가입 seq
	private int ifimModSeq;			//데이터 수정 seq
	private int ifimDelNy;			//데이터 삭제 여부 0:존재함 1:삭제됨 
	private int ifimSize;			//이미지 파일 크기 byte
	private int ifimSeq;			//Image 테이블의 primary key
	private int ifmbSeq;			//Member 테이블의 외래키
	private int iftmSeq;			//Team 테이블의 외래키
	private int ifptSeq; 			//Post 테이블의 외래키
	
	public String getIfimName() {
		return ifimName;
	}
	public void setIfimName(String ifimName) {
		this.ifimName = ifimName;
	}
	public String getIfimType() {
		return ifimType;
	}
	public void setIfimType(String ifimType) {
		this.ifimType = ifimType;
	}
	public String getIfimPath() {
		return ifimPath;
	}
	public void setIfimPath(String ifimPath) {
		this.ifimPath = ifimPath;
	}
	public String getIfimRegIp() {
		return ifimRegIp;
	}
	public void setIfimRegIp(String ifimRegIp) {
		this.ifimRegIp = ifimRegIp;
	}
	public String getIfimModIp() {
		return ifimModIp;
	}
	public void setIfimModIp(String ifimModIp) {
		this.ifimModIp = ifimModIp;
	}
	public String getIfimRegDatetime() {
		return ifimRegDatetime;
	}
	public void setIfimRegDatetime(String ifimRegDatetime) {
		this.ifimRegDatetime = ifimRegDatetime;
	}
	public String getIfimModDatetime() {
		return ifimModDatetime;
	}
	public void setIfimModDatetime(String ifimModDatetime) {
		this.ifimModDatetime = ifimModDatetime;
	}
	public int getIfimRegDeviceCd() {
		return ifimRegDeviceCd;
	}
	public void setIfimRegDeviceCd(int ifimRegDeviceCd) {
		this.ifimRegDeviceCd = ifimRegDeviceCd;
	}
	public int getIfimModDeviceCd() {
		return ifimModDeviceCd;
	}
	public void setIfimModDeviceCd(int ifimModDeviceCd) {
		this.ifimModDeviceCd = ifimModDeviceCd;
	}
	public int getIfimRegSeq() {
		return ifimRegSeq;
	}
	public void setIfimRegSeq(int ifimRegSeq) {
		this.ifimRegSeq = ifimRegSeq;
	}
	public int getIfimModSeq() {
		return ifimModSeq;
	}
	public void setIfimModSeq(int ifimModSeq) {
		this.ifimModSeq = ifimModSeq;
	}
	public int getIfimDelNy() {
		return ifimDelNy;
	}
	public void setIfimDelNy(int ifimDelNy) {
		this.ifimDelNy = ifimDelNy;
	}
	public int getIfimSize() {
		return ifimSize;
	}
	public void setIfimSize(int ifimsize) {
		this.ifimSize = ifimsize;
	}
	public int getIfimSeq() {
		return ifimSeq;
	}
	public void setIfimSeq(int ifimSeq) {
		this.ifimSeq = ifimSeq;
	}
	public int getIfmbSeq() {
		return ifmbSeq;
	}
	public void setIfmbSeq(int ifmbSeq) {
		this.ifmbSeq = ifmbSeq;
	}
	public int getIftmSeq() {
		return iftmSeq;
	}
	public void setIftmSeq(int iftmSeq) {
		this.iftmSeq = iftmSeq;
	}
	public int getIfptSeq() {
		return ifptSeq;
	}
	public void setIfptSeq(int ifptSeq) {
		this.ifptSeq = ifptSeq;
	}
}
