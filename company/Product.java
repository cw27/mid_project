package company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import common.DBConnection;
import kgpayDTO.KgpayDTO;

public class Product {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	boolean ttff = true;

	public Product() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<KgpayDTO> search() {
		String sql = "select * from product";
		ArrayList<KgpayDTO> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				KgpayDTO kk = new KgpayDTO();
				kk.setpName(rs.getString("pName"));
				kk.setpPrice(rs.getInt("price"));
				kk.setpNum(rs.getInt("pNum"));
				kk.setCate(rs.getString("pcate"));
				list.add(kk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void select() {
		String cate;
		System.out.print("찾으시는 상품을 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		cate = sc.next();
		System.out.println("");
		ArrayList<KgpayDTO> list = search();
		System.out.println("상품 번호\t   상품명\t    가격");
		System.out.println("========================");
		for (KgpayDTO k : list) {
			if (k.getCate().equals(cate)) {
				System.out.print(k.getpNum() + "번" + "\t ");
				System.out.print(k.getpName() + "\t  ");
				System.out.println(k.getpPrice() + "원");
				System.out.println("");
			}
		}
		ttff = true;
		while (ttff) {
			System.out.println("1. 상품 번호 선택창으로 이동");
			System.out.println("2. 이전으로 돌아가기");
			System.out.print(">>> ");
			int num1 = sc.nextInt();
			System.out.println("");
			switch (num1) {

			case 1:
				System.out.print("상품 번호 입력: ");
				int num2 = sc.nextInt();
				for (KgpayDTO d : list) {
					if (num2 == d.getpNum()) {
						System.out.println(d.getpPrice() + "원을 결제합니다.");
						System.out.println("");
						System.out.println("===카드 정보 입력===");
						System.out.print("카드 번호: ");
						int c_num = sc.nextInt();
						System.out.print("cvc 번호 입력: ");
						int c_cvc = sc.nextInt();
						System.out.print("카드 비밀번호 입력: ");
						int c_pwd = sc.nextInt();
						Payment paym = new Payment();
						ArrayList<KgpayDTO> list2 = paym.select2(c_num); 
						
						for(KgpayDTO kk : list2) {
							if ((c_num == kk.getcNum()) && (c_cvc == kk.getCvc()) && c_pwd == kk.getPwd()) {
								System.out.println("\n★★★결제가 완료되었습니다.★★★\n");
								Payment pay = new Payment();
								pay.search_price(num2);
								//pay.search_expense(c_num);
								pay.ex_change(kk, c_num);
							} else {
								System.out.println("카드 정보가 일치하지 않습니다.");
							}
						}
					} else {
						continue;
					}
				}
				break;

			case 2:
				ttff = false;
				break;
			}
		}
	}
}