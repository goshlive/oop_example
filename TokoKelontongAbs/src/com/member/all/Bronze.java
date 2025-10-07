package com.member.all;

import com.member.MemberAbs;
import com.member.MemberType;

public class Bronze extends MemberAbs {

    public Bronze(String name, int points) {
        super(name, points);
    }
    
    @Override
    public MemberType getType() {
        return MemberType.BRONZE;
    }
}