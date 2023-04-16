package com.photoboard.service;

import com.photoboard.dto.LoginDto;
import com.photoboard.model.LoginDao;
import java.sql.SQLException;

public class LoginService {
    private final LoginDao loginDao;

    public LoginService() {
        this.loginDao = new LoginDao();
    }

    public LoginDto login(String id, String pwd) throws SQLException {
        return loginDao.login(id, pwd);
    }
}
