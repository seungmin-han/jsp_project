package infra;

public class Team {
	private String iftmName;			//�� �̸�
	private String iftmAnniversary;		//������ ������ ���� �Ǵ� �����
	private String iftmStartDay;		//������ ������ ��������
	
	private String iftmInviteCd;		//���� �����ϱ� ���� �ڵ�
	
	private String iftmRegIp;			//���� ������
	private String iftmRegDatetime;		//���� ��¥ (�Ҽ��� 6�ڸ����� ǥ��)
	private String iftmModIp;			//������ ���� ������
	private String iftmModDatetime;		//������ ���� ��¥ (�Ҽ��� 6�ڸ����� ǥ��)
	private int iftmSeq;				//infrTeam ���̺��� primary key
	private int iftmTypeCd; 			//���� ���� 1:���� 2:Ŀ�� 3:��ü
	private int iftmRegSeq;				//���� seq
	private int iftmModSeq;				//������ ���� seq
	private int iftmRegDeviceCd;		//���� ��� 1:PC 2:Mobile
	private int iftmModDeviceCd;		//������ ���� ��� 1:PC 2:Mobile
	private int iftmDelNy;				//������ ���� ���� 0:������ 1:������
	
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
