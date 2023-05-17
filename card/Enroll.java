package card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import common.DBConnection;
import kgpayDTO.KgpayDTO;

//카드 등록
// 이름, 주민번호, 주소
// 난수 생성으로 카드번호 발급, 카드 비밀번호 설정, cvc 난수

public class Enroll {
	KgpayDTO kk = new KgpayDTO();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public Enroll() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int register(KgpayDTO kk) {
		int result = 0;
		String sql = "insert into card_custom(cName, addr, perNum, cNum, cvc, cPwd) values(?, ?, ?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, kk.getcName());
			ps.setString(2, kk.getAddr());
			ps.setString(3, kk.getPerNum());
			ps.setDouble(4, kk.getcNum());
			ps.setDouble(5, kk.getCvc());
			ps.setInt(6, kk.getcPwd());
			result = ps.executeUpdate();
		} catch (Exception e) {

		}
		return result;
	}

	public void cardInfo() {
		Scanner sc = new Scanner(System.in);
		String cName = null, addr = null, perNum = null;
		double cNum = 0, cvc = 0;
		int cPwd = 0;

		System.out.print("이름을 입력해 주세요. : ");
		cName = sc.next();
		System.out.print("주민번호를 입력해 주세요. : ");
		perNum = sc.next();
		System.out.print("주소를 입력해 주세요. : ");
		addr = sc.next();

		cNum = (int) (Math.random() * 89999) + 10000;
		cvc = (int) (Math.random() * 899) + 100;

		System.out.print("카드 비밀번호를 설정해 주세요.(숫자 4자리) : ");
		cPwd = sc.nextInt();

		KgpayDTO kk = new KgpayDTO();
		kk.setcName(cName);
		kk.setPerNum(perNum);
		kk.setAddr(addr);
		kk.setcNum((int) cNum);
		kk.setCvc((int) cvc);
		kk.setcPwd(cPwd);

		int result = register(kk);
		if (result == 0) {
			System.out.println("이미 존재하는 회원입니다.");
		} else {
			System.out.println("카드 생성이 완료되었습니다.");
		}
	}

	public static void main(String[] args) {
		Enroll er = new Enroll();
		er.cardInfo();
	}
}