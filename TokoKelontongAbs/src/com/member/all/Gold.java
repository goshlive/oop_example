package com.member.all;

import com.member.MemberAbs;
import com.member.MemberType;

public class Gold extends MemberAbs {
	
	public Gold(String nama, int points) {
        super(nama, points);
    }

	@Override
    public MemberType getType() {
        return MemberType.GOLD;
    }
}
