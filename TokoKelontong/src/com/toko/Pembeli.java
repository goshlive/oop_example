package com.toko;
import java.util.ArrayList;
import java.util.List;

import com.produk.Member;
import com.produk.Produk;
import com.util.Util;

public class Pembeli {
	private String nama;
	private int umur;
	private List<Produk> keranjang;
	private double saldo;
	private Member member;
	
	public Pembeli(String nama, int umur, double saldo) {
		this.nama = nama;
		this.umur = umur;
		this.saldo = saldo;
		this.keranjang = new ArrayList<Produk>();
		this.member = Member.NONE;
	}
	
	public Pembeli(String nama, int umur, double saldo, Member member) {
		this(nama, umur, saldo);
		this.member = member;
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
	public Member getMember() {
		return this.member;
	}
	public void bayar(double harga) {
		this.saldo = this.saldo - harga;
	}
	
	public String toString() {
		return "Profil: nama["+this.nama+"], umur["+this.umur+"], saldo["+Util.formatCurr(this.saldo)+"], member["+this.member+"]";
	}
}
