package com.member.all;

import com.member.MemberAbs;
import com.member.MemberType;

public class Silver extends MemberAbs {

	public Silver(String name, int points) {
        super(name, points);
    }

	@Override
    public MemberType getType() {
        return MemberType.SILVER;
    }
}
