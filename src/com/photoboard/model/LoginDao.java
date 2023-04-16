package com.photoboard.model;

import com.photoboard.dto.LoginDto;
import com.photoboard.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    public LoginDto login(String id, String pwd) throws SQLException {
        Connection connection;
        PreparedStatement pstmt;
        ResultSet resultSet;

        try {
            connection = DBUtil.getInstance().getConnection();
            pstmt = connection.prepareStatement("SELECT member_no, member_name FROM Member WHERE member_id = ? "
                + "AND member_pwd = ?");

            pstmt.setString(1, id);
            pstmt.setString(2, pwd);

            resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                int memberNo = resultSet.getInt("member_no");
                String memberName = resultSet.getString("member_name");

                return new LoginDto(memberNo, memberName);
            }
        } catch (SQLException e) {
            System.out.println("정보 조회 실패");
            return new LoginDto(-1, null);
        } finally {
            DBUtil.getInstance().close();
        }

        return new LoginDto(-1, null);
    }
}
