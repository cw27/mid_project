package kgpayDTO;

public class KgpayDTO {
	private boolean plus;
	private String cNum;
	private String cName;
	private String cvc;
	private String cPwd;
	private String comName;
	private String pNum;
	private String pName;
	private String pPrice;
	private String perNum;
	private String addr;
	private String point;
	
	public String getcNum() {
		return cNum;
	}
	public void setcNum(String cNum) {
		this.cNum = cNum;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getCvc() {
		return cvc;
	}
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	public String getcPwd() {
		return cPwd;
	}
	public void setcPwd(String cPwd) {
		this.cPwd = cPwd;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getpNum() {
		return pNum;
	}
	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpPrice() {
		return pPrice;
	}
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
	public boolean isPlus() {
		return plus;
	}
	public void setPlus(boolean plus) {
		this.plus = plus;
	}
	public String getPerNum() {
		return perNum;
	}
	public void setPerNum(String perNum) {
		this.perNum = perNum;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
}
