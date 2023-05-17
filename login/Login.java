package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import common.DBConnection;
import kgpayDTO.KgpayDTO;

public class Login {
	KgpayDTO kk = new KgpayDTO();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public Login() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login( KgpayDTO kk ) {
		int result = 0;
		String sql = "insert into kgMember(id, pwd) values(?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, kk.getId());
			ps.setInt(2, kk.getPwd());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void kg_login() {
		Scanner sc = new Scanner(System.in);
		System.out.print("가입할 id를 입력하세요: ");
		String id = sc.next();
		kk.setId(id);
		System.out.print("비밀번호를 설정하세요: ");
		int pwd = sc.nextInt();
		kk.setPwd(pwd);
		
		int result = login( kk );
		if(result == 0) {
			System.out.println("동일한 아이디가 존재합니다");
		}else {
			System.out.println("회원 가입을 축하합니다.");
		}
	}
}