package com.toko;
import java.util.ArrayList;
import java.util.List;

import com.produk.Produk;
import com.produk.Promo;
import com.util.Util;

public class Toko {
	private List<Produk> daftarProduk;
	private String nama;
	private double kas;
	private Promo promo;
	private List<History> trans;
	
	public Toko(String nama) {
		this.nama = nama;
		this.kas = 0;
		this.daftarProduk = new ArrayList<Produk>();
		this.trans = new ArrayList<History>();
	}
	
	public Toko(String nama, Promo promo) {
		this(nama);
		this.promo = promo;
	}
	
	public void tambahkanProduk(Produk produk) {
		this.daftarProduk.add(produk);
	}
	
	public Produk getProduk(int id) {
		for (Produk p : daftarProduk) {
			if (p.getId() == id) {
				return p;
			}
		}
		
		return null;
	}
	
	public String getNama() {
		return this.nama;
	}
	
	public void setKas(double kas) {
		this.kas = kas;
	}
	
	public double getKas() {
		return kas;
	}
	
	public void processPayment(Pembeli pembeli) {
		//ambil keranjang nya pembeli
		List<Produk> keranjang = pembeli.getKeranjang();
		
		//hitung total belanjaan
		double total = 0;
		for (Produk p : keranjang) {
			total = total + p.getHarga();
		}
		
		//ambil diskon/promo sesuai jenis member
		double diskon = total * this.promo.getPercent(pembeli.getMember());
		
		//kurangi total belanja dengan diskon
		double totalDis = total - diskon; //total yang harus dibayar
		
		//kurangi saldo pembeli
		pembeli.bayar(total);
		
		//masukkan total yang dibayar ke kas
		this.kas = this.kas + totalDis;
		
		//catat sebagai histori transaksi
		this.trans.add(new History("Pelanggan ["+pembeli+"], belanja Total ["+Util.formatCurr(total)+"], dengan Diskon["+Util.formatCurr(totalDis)+"]"));
	}
	
	
	public String toString() {
		StringBuffer sb = new StringBuffer();				 
		if (!daftarProduk.isEmpty()) {
			sb.append("DAFTAR PRODUK:\n");
			for (Produk p : daftarProduk) {
				sb.append(p);
				sb.append("\n");
			}
		}
		
		if (!trans.isEmpty()) {
			sb.append("\nDaftar Transaksi: \n");
			for (History h : trans) {
				sb.append(h);
				sb.append("\n");
			}
			sb.append("\n");
		}
		
		sb.append("Jumlah Kas saat ini["+Util.formatCurr(this.kas)+"]\n");

		return sb.toString();
	}
}
