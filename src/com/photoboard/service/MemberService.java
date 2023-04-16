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

    public void updateMember(String id, MemberDto byIdMember) throws SQLException {
        memberDao.updateMember(id, byIdMember);
    }

    public void deleteMember(String id) throws SQLException {
        memberDao.deleteMember(id);
    }
}
