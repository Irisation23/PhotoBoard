package com.photoboard.dto;

public class LoginDto {
    private int memberNo;
    private String memberName;

    public LoginDto(int memberNo, String memberName) {
        this.memberNo = memberNo;
        this.memberName = memberName;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
