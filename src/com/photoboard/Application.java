package com.photoboard;

import com.photoboard.controller.LoginController;
import com.photoboard.controller.MemberController;
import com.photoboard.util.DBUtil;
import com.photoboard.view.View;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        String currentDirectory = System.getProperty("user.dir");
        String txtFile = currentDirectory + "/src/info/dbinfo.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(txtFile))) {
            String driverName = br.readLine().trim();
            String url = br.readLine().trim();
            String userName = br.readLine().trim();
            String password = br.readLine().trim();

            DBUtil dbUtil = DBUtil.getInstance();
            dbUtil.setDriverName(driverName);
            dbUtil.setUrl(url);
            dbUtil.setUserName(userName);
            dbUtil.setPassword(password);

        } catch (IOException e) {
            e.printStackTrace();
        }

        View view = new View(new MemberController(), new LoginController());
        view.print();
    }
}
