package com.photoboard.controller;

import com.photoboard.dto.MemberDto;
import com.photoboard.service.MemberService;
import java.sql.SQLException;

public class MemberController {

    MemberService memberService;

    public MemberController() {
        this.memberService = new MemberService();
    }

    public void createMember(MemberDto memberDto) throws SQLException {
        memberService.createMember(memberDto);
    }

    public MemberDto findById(String id) throws SQLException {
        return memberService.findById(id);
    }

    public void updateMember(String id, MemberDto byIdMember) throws SQLException {
        memberService.updateMember(id, byIdMember);
    }

    public void deleteMember(String id) throws SQLException {
        memberService.deleteMember(id);
    }
}
