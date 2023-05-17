package company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import common.DBConnection;
import kgpayDTO.KgpayDTO;

public class Product2 {
	KgpayDTO kk = new KgpayDTO();
	Connection con; // DB연결
	PreparedStatement ps;// 자바명령어 보내줌
	ResultSet rs; // 보내준 명령문 저장

	public Product2() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int proRegister(KgpayDTO kk) { // DB 등록
		int result = 0;
		String sql = "insert into product(pnum,pcate,pname,price) values(?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, kk.getpNum());
			ps.setString(2, kk.getCate());
			ps.setString(3, kk.getpName());
			ps.setInt(4, kk.getpPrice());
			result = ps.executeUpdate();
		} catch (Exception e) {

		}
		return result;
	}

	public void pdSelect() {
		Scanner sc = new Scanner(System.in);
		System.out.print("상품코드 등록하세요: ");
		int pnum = sc.nextInt();
		System.out.print("종류 등록하세요: ");
		String pcate = sc.next();
		System.out.print("제품명을 등록하세요: ");
		String pname = sc.next();
		System.out.print("가격 입력하세요: ");
		int price = sc.nextInt();
		kk.setpNum((int) pnum);
		kk.setCate(pcate);
		kk.setpName(pname);
		kk.setpPrice((int) price);
		int result = proRegister(kk);
		if (result == 0) {
			System.out.println("동일한 상품이 존재합니다");
		} else {
			System.out.println("상품 등록이 완료되었습니다.");
		}
	}
}