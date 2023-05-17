package main;

import java.util.Scanner;

import card.Enroll;
import company.CEnroll;
import company.Product;
import company.Product2;
import login.Login;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CEnroll cen = new CEnroll();
		Product prod = new Product();
		Product2 prod2 = new Product2();
		Enroll enr = new Enroll();
		Login log = new Login();
		while(true) {
			
			System.out.println("1. 업체 이용자");
			System.out.println("2. 개인 이용자");
			System.out.print(">>> ");
			int num_se1 = sc.nextInt();
			
			
			switch(num_se1) {
			case 1:
				cen.com_name();
				boolean tf = true;
				while (tf) {
					System.out.println("1. 상품 등록하기");
					System.out.println("2. 종료");
					System.out.println("");
					System.out.print(">>>");
					int num_se3 = sc.nextInt();
					System.out.println("");
					switch(num_se3) {
					case 1:
						prod2.pdSelect();
						break;
						
					case 2:
						tf = false;
						break;
					}
				}
				break;
				
			case 2:
				while( true ) {
					System.out.println("===== 개인 회원 =====");
					System.out.println("1. 회원 가입");
					System.out.println("2. 카드 등록");
					System.out.println("3. 상품 구매");
					System.out.println("4. 종료");
					System.out.print(">>> ");
					int num_se4 = sc.nextInt();
					System.out.println("");
					switch(num_se4) {
					case 1:
						log.kg_login();
						break;
						
					case 2:
						enr.cardInfo();
						break;
						
					case 3:
						
						prod.select();
						break;
						
					case 4:
						System.exit(0);
						break;
					}
				}
			case 3:
				enr.cardInfo();
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}