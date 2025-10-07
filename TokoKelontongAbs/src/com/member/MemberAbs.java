package com.member;

import com.produk.Promo;

public abstract class MemberAbs implements IMember {
    protected String name;
    protected int points;

    public MemberAbs(String name) {
    	this(name, 0);
    }
    
    public MemberAbs(String name, int points) {
        this.name = name;
        this.points = points;
    }
    
    public void addPoints(int point) {
        points += point;
        System.out.println(name + " mendapatkan " + point + " points. Total point saat ini: " + points);
    }
    
    public void redeemPoints(int points) {
        if (points > this.points) {
            System.out.println(name + " does not have enough points to redeem.");
        } else {
            this.points -= points;
            System.out.println(name + " redeemed " + points + " points. Remaining: " + this.points);
        }
    }

    public double calculateTotal(double price, Promo membership) {
        double percent = membership.getDiscount(getType());
        double discount = price * percent;
        
        return Math.max(0.0, price - discount);
    }

    @Override
    public void displayInfo() {
        System.out.println(this);
    }
    
    public String toString() {
    	return "Nama Member[" + name + "], Points[" + points + "], Type[" + getType() + "]";
    }
}

