package com.member.all;

import com.member.MemberAbs;
import com.member.MemberType;

public class None extends MemberAbs {
	public None(String name) {
        super(name);
    }
    
    @Override
    public MemberType getType() {
        return MemberType.NONE;
    }

}
