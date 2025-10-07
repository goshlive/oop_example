package com.app;

import com.produk.Member;
import com.produk.Produk;
import com.produk.Promo;
import com.toko.Pembeli;
import com.toko.Toko;

public class TokoDemo {
	
	private static void greetings(Toko toko) {
		System.out.println("SELAMAT DATANG\n");
		System.out.println("di TOKO " + toko.getNama());
		
		System.out.println(toko);
	}
	
	public static void main(String[] args) {
		//buat toko dengan menerapkan promo percentage berbeda untuk masing-masing tipe member
		Toko toko = new Toko("Sejahtera", new Promo(0.1, 0.25, 0.35));

		//greetings
		greetings(toko);
		
		//masukkan produk ke toko
		toko.tambahkanProduk(new Produk(1, "Baterai", 1000, "Baterai Alkaline"));
		toko.tambahkanProduk(new Produk(2, "Sepatu", 10000, "Produk 2"));
		toko.tambahkanProduk(new Produk(3, "Tas", 100000, "Produk 3"));
		toko.tambahkanProduk(new Produk(4, "Jam", 900000, "Produk 4"));
		toko.tambahkanProduk(new Produk(5, "Topi", 3000, "Produk 5"));
		
		//pembeli
		System.out.println("PELANGGAN: ");
		Pembeli rina = new Pembeli("Rina", 20, 500000);
		System.out.println(rina);
		//pembeli sebagai member
		Pembeli joni = new Pembeli("Joni", 35, 2000000, Member.GOLD);
		System.out.println(joni);
		System.out.println();
		
		//isi kerangjang belanja
		rina.getKeranjang().add(toko.getProduk(2));
		rina.getKeranjang().add(toko.getProduk(5));
		
		//hitung total belanja
		toko.processPayment(rina);
				
		//isi kerangjang belanja
		joni.getKeranjang().add(toko.getProduk(3));
		joni.getKeranjang().add(toko.getProduk(4));
		joni.getKeranjang().add(toko.getProduk(5));
		
		//hitung total belanja
		toko.processPayment(joni);
		
		//print
		System.out.println(toko);
	}
}
