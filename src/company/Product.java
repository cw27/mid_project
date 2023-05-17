package company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
<<<<<<< HEAD
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import common.DBConnection;
import kgpayDTO.KgpayDTO;

public class Product {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

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
				kk.setCode(rs.getInt("code"));
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
		ArrayList<KgpayDTO> list = search();
		System.out.println("   상품명\t    가격");
		System.out.println("=================");
		for (KgpayDTO k : list) {
			if (k.getCate().equals(cate)) {
				System.out.print(k.getpName() + "\t  ");
				System.out.println(k.getpPrice() + "원");
			}
		}
		while (true) {
			System.out.println("1. 상품 번호 선택");
			System.out.println("2. 이전으로 돌아가기");
			System.out.print(">>> ");
			int num1 = sc.nextInt();
			switch (num1) {

			case 1:
				System.out.print("상품 번호 입력: ");
				int num2 = sc.nextInt();
				for (KgpayDTO d : list) {
					if (num2 == d.getpNum()) {
						System.out.println(d.getpPrice() + "원을 결제합니다.");
						System.out.println("===카드 정보 입력===");
						System.out.print("카드 번호: ");
						int c_num = sc.nextInt();
						System.out.print("cvc 번호 입력: ");
						int c_cvc = sc.nextInt();
						System.out.print("카드 비밀번호 입력: ");
						int c_pwd = sc.nextInt();
						Payment paym = new Payment();
						ArrayList<KgpayDTO> list2 = paym.select2(c_num); 
						System.out.println(list2.size());
						for(KgpayDTO kk : list2) {
							System.out.println("ccc");
							if ((c_num == kk.getcNum()) && (c_cvc == kk.getCvc()) && c_pwd == kk.getPwd()) {
								System.out.println("결제가 완료되었습니다.");
								Payment pay = new Payment();
								pay.search_price(num2);
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

				break;
			}
		}
	}
=======
import java.util.Scanner;
>>>>>>> origin/b

import common.DBConnection;
import kgpayDTO.KgpayDTO;

public class Product {
	KgpayDTO kk = new KgpayDTO();
	Connection con; // DB연결
	PreparedStatement ps;// 자바명령어 보내줌
	ResultSet rs; // 보내준 명령문 저장

	public Product() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int proRegister(KgpayDTO kk) {  // DB 등록
		int result = 0;
		String sql = "insert into product(code,pnum,pcate,pname,price) values(?, ?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1 , kk.getCode());
			ps.setInt(2 , kk.getpNum());
			ps.setString(3 , kk.getCate());
			ps.setString(4 , kk.getpName());
			ps.setInt(5 , kk.getpPrice());
			result = ps.executeUpdate();
		} catch (Exception e) {
			
		}
		return result;
	}
	public void pdSelect() {
		Scanner sc = new Scanner(System.in);
		double code = (int)(Math.random() * 899) + 100;
		System.out.println(" 상품코드 등록하세요 ");
		int pnum = sc.nextInt();
		System.out.println(" 종류 등록하세요 ");
		String pcate= sc.next();
		System.out.println(" 제품명을 등록하세요 ");
		String pname = sc.next();
		System.out.println(" 가격 입력하세요 ");
		int price = sc.nextInt();
		kk.setCode((int)code);
		kk.setpNum((int)pnum);
		kk.setCate(pcate);
		kk.setpName(pname);
		kk.setpPrice((int)price);
		  int result = proRegister( kk );
		  if(result == 0) {
	         System.out.println("동일한 상품이 존재합니다");
	      }else {
	         System.out.println("상품 등록이 완료되었습니다.");
	      }
		
	}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
