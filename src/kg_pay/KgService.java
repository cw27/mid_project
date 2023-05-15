package kg_pay;

public interface KgService {
	public boolean correct(String cNum, String cvc, String cPwd);
	public int k_charge(int pay);
	public int k_point(int point1);
}
