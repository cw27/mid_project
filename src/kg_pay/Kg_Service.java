package kg_pay;

import java.util.Scanner;

public class Kg_Service implements KgService {
	Scanner sc = new Scanner(System.in);
	public boolean tf1;
	@Override
	public boolean correct(String cNum, String cvc, String cPwd) {
		String cNum1 = sc.next();
		
		return tf1;
	}

	@Override
	public int k_charge(int pay) {
		return 0;
	}

	@Override
	public int k_point(int point1) {
		return 0;
	}
	
}
