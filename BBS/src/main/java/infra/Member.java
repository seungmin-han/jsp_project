package infra;

public class Member {
	private String ifmbFirstName; 	// �̸�
	private String ifmbLastName; 	// ��
	private String ifmbId; 			// ���̵�
	private String ifmbPassword; 	// ��й�ȣ
	private String ifmbDob;			// �������
	private String ifmbNickName;	// �г���
	private String ifmbRegIp; 		// ���� ������ 
	private String ifmbRegDatetime;	// ���� ��¥ (�Ҽ��� 6�ڸ����� ǥ��)
	private String ifmbModIp; 		// ������ ���� ������ 
	private String ifmbModDatetime;	// ������ ���� ��¥ (�Ҽ��� 6�ڸ����� ǥ��)
	private int ifmbSeq;			// infrMember ���̺��� primary key 
	private int ifmbGenderCd; 		// �����ڵ� 1: ���� 2: ����
	private int ifmbDormantNy;		// �޸���� 0: Ȱ�� 1: �޸�
	private int ifmbAdminNy;		// �����ڿ��� 0: �Ϲ� ����� 1: ������ ������
	private int ifmbRegSeq; 		// ���� seq
	private int ifmbRegDeviceCd; 	// ���� ��� 1: PC 2: Mobile 
	private int ifmbModSeq; 		// ������ ���� seq
	private int ifmbModDeviceCd; 	// ������ ���� ��� 1: PC 2: Mobile 
	private int iftmSeq;			// team ���̺��� �ܷ�Ű
	private int iftmAdminNy;		// team�� ���� ���� 0:�Ϲ����� 1:����
	private int ifmbDelNy; 			// ������ ���� ���� 0: ������ 1: ������ 
	
	
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
