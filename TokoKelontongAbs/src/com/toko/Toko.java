package com.toko;
import java.util.ArrayList;
import java.util.List;

import com.member.MemberAbs;
import com.member.MemberType;
import com.member.all.Bronze;
import com.member.all.Gold;
import com.member.all.Silver;
import com.produk.Produk;
import com.produk.Promo;
import com.util.Util;

public class Toko {	
	private List<Produk> daftarProduk;
	private String nama;
	private double kas;
	private Promo promo;
	private List<History> trans;
	private int pointMemberPerTransaksi;
	
	public Toko(String nama, int pointMemberPerTransaksi) {
		this.nama = nama;
		this.pointMemberPerTransaksi = pointMemberPerTransaksi;
		this.kas = 0;
		this.daftarProduk = new ArrayList<Produk>();
		this.trans = new ArrayList<History>();		
	}
	
	public Toko(String nama, int pointMemberPerTransaksi, Promo promo) {
		this(nama, pointMemberPerTransaksi);
		this.promo = promo;
	}
	
	public void daftarMember(Pembeli pembeli, MemberType tipe, double biaya) {
		if (tipe == MemberType.BRONZE) {
			pembeli.setMember(new Bronze(pembeli.getNama(), 100));
		} else if (tipe == MemberType.SILVER) {
			pembeli.setMember(new Silver(pembeli.getNama(), 500));
		} else if (tipe == MemberType.GOLD) {
			pembeli.setMember(new Gold(pembeli.getNama(),1000));
		}
		
		pembeli.bayar(biaya);
		this.kas = this.kas + biaya;
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
	
	private void tambahPointMember(Pembeli pembeli) {
		MemberAbs member = (MemberAbs) pembeli.getMember();
		if (member.getType() != MemberType.NONE) {
			member.addPoints(this.pointMemberPerTransaksi);
		}	
		System.out.println();
	}
	
	private void redeemPoints(Pembeli pembeli, Produk produk) {
		MemberAbs member = (MemberAbs) pembeli.getMember();
		if (member.getType() != MemberType.NONE) {
			System.out.println(pembeli.getNama() + " belanja promo produk (id="+ produk.getId() +")");
			member.redeemPoints(produk.getJmlPointUntukPromo());
		}		
	}
	
	public void processPayment(Pembeli pembeli) {
		//ambil keranjang nya pembeli
		List<Produk> keranjang = pembeli.getKeranjang();
		
		//hitung total belanjaan
		double total = 0;
		for (Produk produk : keranjang) {
			total = total + produk.getHarga();
			
			//jika ini produk promo dan pembeli adalah member, maka kurangi point yang dimiliki member
			if (produk.isPromo()) {
				this.redeemPoints(pembeli, produk);
			}
		}
		
		//setiap transaksi, jika member mendapatkan point promo
		this.tambahPointMember(pembeli);
		
		//ambil diskon/promo sesuai jenis member
		double diskon = total * this.promo.getDiscount(pembeli.getMember().getType());
		
		//kurangi total belanja dengan diskon
		double totalDis = total - diskon; //total yang harus dibayar
		
		//kurangi saldo pembeli
		pembeli.bayar(total);
		
		//masukkan total yang dibayar ke kas
		this.kas = this.kas + totalDis;
		
		//catat sebagai histori transaksi
		this.trans.add(new History("Pelanggan ["+pembeli+"], belanja Total ["+Util.formatCurr(total)+"], dengan Diskon["+Util.formatCurr(totalDis)+"]"));
	}
	
	public void displayProduk() {
		StringBuffer sb = new StringBuffer();
		if (!daftarProduk.isEmpty()) {
			sb.append("DAFTAR PRODUK:\n");
			for (Produk p : daftarProduk) {
				sb.append(p);
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();				 		
		if (!trans.isEmpty()) {
			sb.append("Daftar Transaksi: \n");
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
