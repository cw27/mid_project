package company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import kgpayDTO.*;
import common.DBConnection;

public class CEnroll {
	KgpayDTO kk = new KgpayDTO();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public CEnroll() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int comRegister( KgpayDTO kk ) {
		int result = 0;
		String sql = "insert into company(code, comname) values(?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, kk.getCode());
			ps.setString(2, kk.getComName());
			result = ps.executeUpdate();
		} catch (Exception e) {
			
		}
		return result;
	}
	
	public void com_name() {
		Scanner sc = new Scanner(System.in);
		double code = (int)(Math.random() * 899) + 100;
		System.out.print("업체 이름을 입력하세요: ");
		String com = sc.next();
		
		kk.setCode((int)code);
		kk.setComName(com);
		
		int result = comRegister( kk );
		if(result == 0) {
			System.out.println("동일한 업체가 존재합니다");
		} else {
			System.out.println("업체 등록이 완료되었습니다.");
		}
	}
}