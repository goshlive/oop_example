package com.produk;

import com.member.MemberType;

public class Promo {
	private final double bronzeDiscount;
	private final double silverDiscount;
	private final double goldDiscount;

	public Promo(double bronzeDiscount, double silverDiscount, double goldDiscount) {
		this.bronzeDiscount = bronzeDiscount;
		this.silverDiscount = silverDiscount;
		this.goldDiscount = goldDiscount;
	}

	public double getDiscount(MemberType tipe) {
		switch (tipe) {
		case BRONZE:
			return bronzeDiscount;
		case SILVER:
			return silverDiscount;
		case GOLD:
			return goldDiscount;
		default:
			return 0.0;
		}
	}
}
