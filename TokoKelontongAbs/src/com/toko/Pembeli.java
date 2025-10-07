package com.toko;
import java.util.ArrayList;
import java.util.List;

import com.member.IMember;
import com.member.all.None;
import com.produk.Produk;
import com.util.Util;

public class Pembeli {
	private String nama;
	private int umur;
	private List<Produk> keranjang;
	private double saldo;
	private IMember member;
	
	public Pembeli(String nama, int umur, double saldo) {
		this.nama = nama;
		this.umur = umur;
		this.saldo = saldo;
		this.keranjang = new ArrayList<Produk>();
		this.member = new None(nama);
	}
	
	public void setMember(IMember member) {
		this.member = member;
	}
	public IMember getMember() {
		return this.member;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public int getUmur() {
		return umur;
	}
	public void setUmur(int umur) {
		this.umur = umur;
	}
	public List<Produk> getKeranjang() {
		return keranjang;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	//kurangi saldo saat bayar
	public void bayar(double harga) {
		this.saldo = this.saldo - harga;
	}
	
	//tampilkan info
	public String toString() {
		return "Profil: nama["+this.nama+"], umur["+this.umur+"], saldo["+Util.formatCurr(this.saldo)+"], member["+this.member+"]";
	}
}
