package main;

import java.util.Scanner;

import common.DBConnection;
import company.Product;
import kg_pay.regpay;
import kgpayDTO.KgpayDTO;

public class MainClass {
	public static void main(String[] args) {
		Product pr = new Product();
		regpay rg = new regpay();
		rg.regSelect();
		//pr.pdSelect();
	}

}
