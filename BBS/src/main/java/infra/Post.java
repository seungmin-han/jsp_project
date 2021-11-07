package infra;

public class Post {
	private String ifmbId; 				//데이터를 가져왔을 때 작성자
	private String ifrgSido;			//데이터를 가져왔을 때 지역(시/도)
	private String ifrgSigungu;			//데이터를 가져왔을 때 지역(시/군/구)
	private String ifrgEupmyeondong;	//데이터를 가져왔을 때 지역(읍/면/동)
	
	
	
	private String ifptTitle;			// 제목
	private String ifptContent;			// 내용
	private String ifptRegIp;			// 가입 아이피
	private String ifptRegDatetime;		// 가입 시간
	private String ifptModIp;			// 수정 아이피
	private String ifptModDatetime;		// 수정 시간
	private int ifptSeq;				// 기본 키
	private int ifmbSeq;				// 작성자 외래키
	private int iftmSeq;				// 팀 외래키
	private int ifrgSeq;				// 지역 외래키
	private int ifptViewer;				// 조회수
	private int ifptPublicNy;			// 공개여부 0:비공개 1:공개
	private int ifptNoticeNy;			// 공지여부	0:일반 게시글 1: 공지사항
	private int ifptRegDeviceCd;		// 가입 기기 1:PC 2:Mobile
	private int ifptRegSeq;				// 가입 Seq
	private int ifptModDeviceCd;		// 수정 기기 1:PC 2:Mobile
	private int ifptModSeq;				// 수정 Seq
	private int ifptDelNy;				// 데이터 삭제 여부 0:존재함 1:삭제됨
	
	public String getIfmbId() {
		return ifmbId;
	}
	public void setIfmbId(String ifmbId) {
		this.ifmbId = ifmbId;
	}
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
	
	
	
	public String getIfptTitle() {
		return ifptTitle;
	}
	public void setIfptTitle(String ifptTitle) {
		this.ifptTitle = ifptTitle;
	}
	public String getIfptContent() {
		return ifptContent;
	}
	public void setIfptContent(String ifptContent) {
		this.ifptContent = ifptContent;
	}
	public String getIfptRegIp() {
		return ifptRegIp;
	}
	public void setIfptRegIp(String ifptRegIp) {
		this.ifptRegIp = ifptRegIp;
	}
	public String getIfptRegDatetime() {
		return ifptRegDatetime;
	}
	public void setIfptRegDatetime(String ifptRegDatetime) {
		this.ifptRegDatetime = ifptRegDatetime;
	}
	public String getIfptModIp() {
		return ifptModIp;
	}
	public void setIfptModIp(String ifptModIp) {
		this.ifptModIp = ifptModIp;
	}
	public String getIfptModDatetime() {
		return ifptModDatetime;
	}
	public void setIfptModDatetime(String ifptModDatetime) {
		this.ifptModDatetime = ifptModDatetime;
	}
	public int getIfptSeq() {
		return ifptSeq;
	}
	public void setIfptSeq(int ifptSeq) {
		this.ifptSeq = ifptSeq;
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
	public int getIfrgSeq() {
		return ifrgSeq;
	}
	public void setIfrgSeq(int ifrgSeq) {
		this.ifrgSeq = ifrgSeq;
	}
	public int getIfptViewer() {
		return ifptViewer;
	}
	public void setIfptViewer(int ifptViewer) {
		this.ifptViewer = ifptViewer;
	}
	public int getIfptPublicNy() {
		return ifptPublicNy;
	}
	public void setIfptPublicNy(int ifptPublicNy) {
		this.ifptPublicNy = ifptPublicNy;
	}
	public int getIfptNoticeNy() {
		return ifptNoticeNy;
	}
	public void setIfptNoticeNy(int ifptNoticeNy) {
		this.ifptNoticeNy = ifptNoticeNy;
	}
	public int getIfptRegDeviceCd() {
		return ifptRegDeviceCd;
	}
	public void setIfptRegDeviceCd(int ifptRegDeviceCd) {
		this.ifptRegDeviceCd = ifptRegDeviceCd;
	}
	public int getIfptRegSeq() {
		return ifptRegSeq;
	}
	public void setIfptRegSeq(int ifptRegSeq) {
		this.ifptRegSeq = ifptRegSeq;
	}
	public int getIfptModDeviceCd() {
		return ifptModDeviceCd;
	}
	public void setIfptModDeviceCd(int ifptModDeviceCd) {
		this.ifptModDeviceCd = ifptModDeviceCd;
	}
	public int getIfptModSeq() {
		return ifptModSeq;
	}
	public void setIfptModSeq(int ifptModSeq) {
		this.ifptModSeq = ifptModSeq;
	}
	public int getIfptDelNy() {
		return ifptDelNy;
	}
	public void setIfptDelNy(int ifptDelNy) {
		this.ifptDelNy = ifptDelNy;
	}
	
	
}
