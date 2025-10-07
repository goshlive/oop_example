package com.produk;

public class Promo {
	private double brzPercent;
	private double slvPercent;
	private double gldPercent;
	
	public Promo(double brzPercent, double slvPercent, double gldPercent) {
		this.brzPercent = brzPercent;
		this.slvPercent = slvPercent;
		this.gldPercent = gldPercent;
	}
	
	public double getPercent(Member member) {
		if (member == Member.BRONZE) {
			return brzPercent;
		} else if (member == Member.SILVER) {
			return slvPercent;
		} else if (member == Member.GOLD) {
			return gldPercent;
		}
		
		return 0;
	}

}
