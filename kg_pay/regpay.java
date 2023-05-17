package kg_pay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import common.DBConnection;
import kgpayDTO.KgpayDTO;

public class regpay {
	KgpayDTO kk = new KgpayDTO();
	Connection con; // DB연결
	PreparedStatement ps;// 자바명령어 보내줌
	ResultSet rs; // 보내준 명령문 저장

	public KgpayDTO search(String id) {
		String sql = "select * from kgmember where id='" + id + "'";
		KgpayDTO dto = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new KgpayDTO();
				dto.setId(rs.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public regpay() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int regRegister(KgpayDTO kk) { // DB 등록
		int result = 0;
		String sql = "insert into kgPay(id,cNum,cvc,cPwd) values(?,?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, kk.getId());
			ps.setDouble(2, kk.getcNum());
			ps.setDouble(3, kk.getCvc());
			ps.setInt(4, kk.getcPwd());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void regSelect() {
		Scanner sc = new Scanner(System.in);
		String id = null;
		double cNum = 0, cvc = 0;
		int cPwd = 0;
		System.out.println("아이디를 입력하시오");
		id = sc.next();
		KgpayDTO k = search(id);
		if (k == null) {
			System.out.println("존재하지 않는 아이디정보!!!");
		} else {
			System.out.println(" 카드 번호를 등록하세요 ");
			cNum = sc.nextInt();
			System.out.println(" cvc을 등록하세요 ");
			cvc = sc.nextInt();
			System.out.println(" 비밀번호를 입력하세요 ");
			cPwd = sc.nextInt();
			kk.setId(id);
			kk.setcNum(cNum);
			kk.setCvc(cvc);
			kk.setcPwd(cPwd);
			int result = regRegister(kk);
			if (result == 0) {
				System.out.println("카드 정보가 존재합니다");
			} else {
				System.out.println("카드 등록이 완료되었습니다.");
			}
		}
	}
}