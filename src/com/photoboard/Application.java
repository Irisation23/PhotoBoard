package com.photoboard;

import com.photoboard.util.DBUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Application {

    public static void main(String[] args) {
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
    }
}
