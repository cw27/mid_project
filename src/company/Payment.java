package company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import common.DBConnection;
import kgpayDTO.KgpayDTO;

public class Payment {
	KgpayDTO kk = new KgpayDTO();
	Product pro = new Product();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int pnum;
	int num2;
	int i = 0;
	int e = 0;
	public Payment() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int search_price( int num2 ) {
		System.out.println("bbb");
		String sql = "select price from product where pnum = " + num2;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				kk.setpPrice(rs.getInt("price"));
			}
			i = kk.getpPrice();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int search_expense( int c_num ) {
		System.out.println("bbb");
		String sql = "select expense from product where cnum = " + c_num;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				kk.setExpense(rs.getInt("expense"));
			}
			e = kk.getExpense();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return e;
	}
	
	public int ex_change(KgpayDTO kk, int c_num) {
		System.out.println("aaa" + kk);
		int result = 0;
		String sql = "update card_custom set expense = " + (i + e) +  "where cNum = " + c_num;
		try {
			ps = con.prepareStatement(sql);
			//rs = ps.executeUpdate();
			result = ps.executeUpdate();
			if(result == 0) {
				System.out.println("업데이트 x");
			} else {
				System.out.println("업데이트 완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<KgpayDTO> select2(int c_num) {
		String sql = "select cnum, cvc, cpwd from card_custom where cnum =" + c_num;
		ArrayList<KgpayDTO> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				KgpayDTO kk = new KgpayDTO();
				kk.setcNum(rs.getInt("cnum"));
				kk.setCvc(rs.getInt("cvc"));
				kk.setPwd(rs.getInt("cpwd"));
				list.add(kk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
