package infra;

public class Post {
	private String ifmbId; 				//�����͸� �������� �� �ۼ���
	private String ifrgSido;			//�����͸� �������� �� ����(��/��)
	private String ifrgSigungu;			//�����͸� �������� �� ����(��/��/��)
	private String ifrgEupmyeondong;	//�����͸� �������� �� ����(��/��/��)
	
	
	
	private String ifptTitle;			// ����
	private String ifptContent;			// ����
	private String ifptRegIp;			// ���� ������
	private String ifptRegDatetime;		// ���� �ð�
	private String ifptModIp;			// ���� ������
	private String ifptModDatetime;		// ���� �ð�
	private int ifptSeq;				// �⺻ Ű
	private int ifmbSeq;				// �ۼ��� �ܷ�Ű
	private int iftmSeq;				// �� �ܷ�Ű
	private int ifrgSeq;				// ���� �ܷ�Ű
	private int ifptViewer;				// ��ȸ��
	private int ifptPublicNy;			// �������� 0:����� 1:����
	private int ifptNoticeNy;			// ��������	0:�Ϲ� �Խñ� 1: ��������
	private int ifptRegDeviceCd;		// ���� ��� 1:PC 2:Mobile
	private int ifptRegSeq;				// ���� Seq
	private int ifptModDeviceCd;		// ���� ��� 1:PC 2:Mobile
	private int ifptModSeq;				// ���� Seq
	private int ifptDelNy;				// ������ ���� ���� 0:������ 1:������
	
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
