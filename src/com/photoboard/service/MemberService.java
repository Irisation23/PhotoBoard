package com.photoboard.service;

import com.photoboard.dto.MemberDto;
import com.photoboard.model.MemberDao;
import java.sql.SQLException;

public class MemberService {

    private final MemberDao memberDao;

    public MemberService() {
        this.memberDao = new MemberDao();
    }

    public void createMember(MemberDto memberDto) throws SQLException {
        memberDao.createMember(memberDto);
    }

    public MemberDto findById(String id) throws SQLException {
        return memberDao.findById(id);
    }

    public void updateMember(int memberNo, MemberDto byIdMember) throws SQLException {
        memberDao.updateMember(memberNo, byIdMember);
    }

    public void deleteMember(int memberNo) throws SQLException {
        memberDao.deleteMember(memberNo);
    }
}
