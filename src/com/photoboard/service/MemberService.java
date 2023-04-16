package com.photoboard.service;

import com.photoboard.dto.MemberDto;
import com.photoboard.model.MemberDao;
import java.sql.SQLException;

public class MemberService {

    private MemberDao memberDao;

    public MemberService() {
        this.memberDao = new MemberDao();
    }

    public void createMember(MemberDto memberDto) throws SQLException {
        memberDao.createMember(memberDto);
    }
}
