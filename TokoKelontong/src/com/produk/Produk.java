package com.produk;

import com.util.Util;

public class Produk {
	private int id;
	private String namaProduk;
	private double harga;
	private String deskripsiProduk;
	
	public Produk(int id, String nama, double harga, String deskripsi) {
		this.id = id;
		this.namaProduk = nama;
		this.harga = harga;
		this.deskripsiProduk = deskripsi;
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
		return "id["+this.id+"], nama["+this.namaProduk+"], harga["+Util.formatCurr(this.harga)+"], deskripsi["+this.deskripsiProduk+"]";
	}
}
