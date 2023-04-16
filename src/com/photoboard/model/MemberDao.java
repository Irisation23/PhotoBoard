package com.photoboard.model;

import com.photoboard.dto.MemberDto;
import com.photoboard.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {

    public void createMember(MemberDto memberDto) throws SQLException {
        Connection connection = DBUtil.getInstance().getConnection();
        PreparedStatement pstmt;

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

    public MemberDto findById(String id) throws SQLException {
        Connection connection = DBUtil.getInstance().getConnection();
        PreparedStatement pstmt;
        ResultSet resultSet;

        System.out.println(id);

        try {
            pstmt = connection.prepareStatement("SELECT member_name, member_id, member_pwd FROM member where "
                + "member_id = ?");
            pstmt.setString(1, id);

            resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                String memberName = resultSet.getString("member_name");
                String memberId = resultSet.getString("member_id");
                String memberPwd = resultSet.getString("member_pwd");

                return new MemberDto(memberName, memberId, memberPwd);
            }

        } catch (SQLException e) {
            return new MemberDto(null, null, null);
        } finally {
            DBUtil.getInstance().close();
        }

        return new MemberDto(null, null, null);
    }

    public void updateMember(String id, MemberDto byIdMember) throws SQLException {
        Connection connection = DBUtil.getInstance().getConnection();
        PreparedStatement pstmt;

        try {
            connection.setAutoCommit(false);
            pstmt = connection.prepareStatement("UPDATE Member SET member_name = ?, member_id = ?, member_pwd = ? "
                + "WHERE member_id = ?");

            pstmt.setString(1, byIdMember.getMemberName());
            pstmt.setString(2, byIdMember.getMemberId());
            pstmt.setString(3, byIdMember.getMemberPwd());
            pstmt.setString(4, id);

            if (pstmt.executeUpdate() > 0) {
                System.out.println("update Member Success!");
                connection.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close();
        }
    }

    public void deleteMember(String id) throws SQLException {
        Connection connection = DBUtil.getInstance().getConnection();
        PreparedStatement pstmt;

        try {
            connection.setAutoCommit(false);
            pstmt = connection.prepareStatement("DELETE FROM Member WHERE member_id = ?");

            pstmt.setString(1, id);

            if (pstmt.executeUpdate() > 0) {
                System.out.println("delete Member Success!");
                connection.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close();
        }
    }
}
