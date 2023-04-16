package com.photoboard.controller;

import com.photoboard.dto.LoginDto;
import com.photoboard.service.LoginService;
import java.sql.SQLException;

public class LoginController {

    LoginService loginService;
    public LoginController() {
        this.loginService = new LoginService();
    }

    public LoginDto login(String id, String pwd) throws SQLException {
        return loginService.login(id, pwd);
    }
}
