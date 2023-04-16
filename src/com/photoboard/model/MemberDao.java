package com.photoboard.model;

import com.photoboard.dto.MemberDto;
import com.photoboard.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDao {

    public void createMember(MemberDto memberDto) throws SQLException {
        Connection connection = DBUtil.getInstance().getConnection();
        PreparedStatement pstmt = null;

        try {
            StringBuilder sql = new StringBuilder("insert into member (member_name,member_id,member_pwd) \n");
            connection.setAutoCommit(false);
            sql.append("values (?,?,?)");

            pstmt = connection.prepareStatement(sql.toString());

            pstmt.setString(1, memberDto.getMemberName());
            pstmt.setString(2, memberDto.getMemberId());
            pstmt.setString(3, memberDto.getMemberPwd());

            if (pstmt.executeUpdate() > 0) {
                System.out.println("create Member Success!");
                connection.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close();
        }
    }
}
