package infra;

public class Image {
	private String ifimName;		//�̹��������̸�
	private String ifimType;		//�̹���Ÿ�� 
	private String ifimPath;		//�̹��� ���
	private String ifimRegIp;		//���� ������
	private String ifimModIp;		//������ ���� ������
	private String ifimRegDatetime;	//���� ��¥
	private String ifimModDatetime;	//������ ���� ��¥
	private int ifimRegDeviceCd;	//���� ��� 1: PC 2: Mobile
	private int ifimModDeviceCd;	//������ ���� ��� 1: PC 2: Mobile
	private int ifimRegSeq;			//���� seq
	private int ifimModSeq;			//������ ���� seq
	private int ifimDelNy;			//������ ���� ���� 0:������ 1:������ 
	private int ifimSize;			//�̹��� ���� ũ�� byte
	private int ifimSeq;			//Image ���̺��� primary key
	private int ifmbSeq;			//Member ���̺��� �ܷ�Ű
	private int iftmSeq;			//Team ���̺��� �ܷ�Ű
	private int ifptSeq; 			//Post ���̺��� �ܷ�Ű
	
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
