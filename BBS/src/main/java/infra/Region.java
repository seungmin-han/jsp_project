package infra;

public class Region {
	private String ifrgSido;			// 시/도
	private String ifrgSigungu;			// 시/군/구
	private String ifrgEupmyeondong;	// 읍/면/동
	private String ifrgImage;			// 대체이미지
	private String ifrgRegIp;			// 가입 아이피
	private String ifrgRegDatetime;		// 가입 시간
	private String ifrgModIp;			// 수정 아이피
	private String ifrgModDatetime;		// 수정 시간
	private int ifrgSeq;				// 기본 키
	private int iftmSeq;				// 팀 외래키
	private int ifrgViewer;				// 조회수
	private int ifrgPublicNy;			// 공개여부 0:비공개 1:공개
	private int ifrgNoticeNy;			// 공지여부	0:일반 게시글 1: 공지사항
	private int ifrgRegDeviceCd;		// 가입 기기 1:PC 2:Mobile
	private int ifrgRegSeq;				// 가입 Seq
	private int ifrgModDeviceCd;		// 수정 기기 1:PC 2:Mobile
	private int ifrgModSeq;				// 수정 Seq
	private int ifrgDelNy;				// 데이터 삭제 여부 0:존재함 1:삭제됨
	
	public String getIfrgSido() {
		return ifrgSido;
	}
	public void setIfrgSido(String ifrgSido) {
		this.ifrgSido = ifrgSido;
	}
	public String getIfrgSigungu() {
		return ifrgSigungu;
	}
	public void setIfrgSigungu(String ifrgSigungu) {
		this.ifrgSigungu = ifrgSigungu;
	}
	public String getIfrgEupmyeondong() {
		return ifrgEupmyeondong;
	}
	public void setIfrgEupmyeondong(String ifrgEupmyeondong) {
		this.ifrgEupmyeondong = ifrgEupmyeondong;
	}
	public String getIfrgImage() {
		return ifrgImage;
	}
	public void setIfrgImage(String ifrgImage) {
		this.ifrgImage = ifrgImage;
	}
	public String getIfrgRegIp() {
		return ifrgRegIp;
	}
	public void setIfrgRegIp(String ifrgRegIp) {
		this.ifrgRegIp = ifrgRegIp;
	}
	public String getIfrgRegDatetime() {
		return ifrgRegDatetime;
	}
	public void setIfrgRegDatetime(String ifrgRegDatetime) {
		this.ifrgRegDatetime = ifrgRegDatetime;
	}
	public String getIfrgModIp() {
		return ifrgModIp;
	}
	public void setIfrgModIp(String ifrgModIp) {
		this.ifrgModIp = ifrgModIp;
	}
	public String getIfrgModDatetime() {
		return ifrgModDatetime;
	}
	public void setIfrgModDatetime(String ifrgModDatetime) {
		this.ifrgModDatetime = ifrgModDatetime;
	}
	public int getIfrgSeq() {
		return ifrgSeq;
	}
	public void setIfrgSeq(int ifrgSeq) {
		this.ifrgSeq = ifrgSeq;
	}
	public int getIftmSeq() {
		return iftmSeq;
	}
	public void setIftmSeq(int iftmSeq) {
		this.iftmSeq = iftmSeq;
	}
	public int getIfrgViewer() {
		return ifrgViewer;
	}
	public void setIfrgViewer(int ifrgViewer) {
		this.ifrgViewer = ifrgViewer;
	}
	public int getIfrgPublicNy() {
		return ifrgPublicNy;
	}
	public void setIfrgPublicNy(int ifrgPublicNy) {
		this.ifrgPublicNy = ifrgPublicNy;
	}
	public int getIfrgNoticeNy() {
		return ifrgNoticeNy;
	}
	public void setIfrgNoticeNy(int ifrgNoticeNy) {
		this.ifrgNoticeNy = ifrgNoticeNy;
	}
	public int getIfrgRegDeviceCd() {
		return ifrgRegDeviceCd;
	}
	public void setIfrgRegDeviceCd(int ifrgRegDeviceCd) {
		this.ifrgRegDeviceCd = ifrgRegDeviceCd;
	}
	public int getIfrgRegSeq() {
		return ifrgRegSeq;
	}
	public void setIfrgRegSeq(int ifrgRegSeq) {
		this.ifrgRegSeq = ifrgRegSeq;
	}
	public int getIfrgModDeviceCd() {
		return ifrgModDeviceCd;
	}
	public void setIfrgModDeviceCd(int ifrgModDeviceCd) {
		this.ifrgModDeviceCd = ifrgModDeviceCd;
	}
	public int getIfrgModSeq() {
		return ifrgModSeq;
	}
	public void setIfrgModSeq(int ifrgModSeq) {
		this.ifrgModSeq = ifrgModSeq;
	}
	public int getIfrgDelNy() {
		return ifrgDelNy;
	}
	public void setIfrgDelNy(int ifrgDelNy) {
		this.ifrgDelNy = ifrgDelNy;
	}
}
