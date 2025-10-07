package com.produk;

import com.util.Util;

public class Produk {
	private int id;
	private String namaProduk;
	private double harga;
	private String deskripsiProduk;
	private int jmlPointUntukPromo;
	
	public Produk(int id, String nama, double harga, String deskripsi, int jmlPointUntukPromo) {
		this.id = id;
		this.namaProduk = nama;
		this.harga = harga;
		this.deskripsiProduk = deskripsi;
		this.jmlPointUntukPromo = jmlPointUntukPromo;
	}
	
	public Produk(int id, String nama, double harga, String deskripsi) {
		this(id, nama, harga, deskripsi, 0);
	}
	
	public boolean isPromo() {
		return jmlPointUntukPromo > 0; //kalau point yang diperlukan untuk mendapatkan promo > 0, berarti ini adalah produk yang menggunakan promo buat member (true)
	}
	
	public int getJmlPointUntukPromo() {
		return jmlPointUntukPromo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamaProduk() {
		return namaProduk;
	}
	public void setNamaProduk(String namaProduk) {
		this.namaProduk = namaProduk;
	}
	public double getHarga() {
		return harga;
	}
	public void setHarga(double harga) {
		this.harga = harga;
	}
	public String getDeskripsiProduk() {
		return deskripsiProduk;
	}
	public void setDeskripsiProduk(String deskripsiProduk) {
		this.deskripsiProduk = deskripsiProduk;
	}
	
	public String toString() {
		return "id["+this.id+"], nama["+this.namaProduk+"], harga["+Util.formatCurr(this.harga)+"], deskripsi["+this.deskripsiProduk+"], point-promo["+this.jmlPointUntukPromo+"]";
	}
}
