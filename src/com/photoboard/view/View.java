package com.photoboard.view;

import com.photoboard.controller.MemberController;
import com.photoboard.dto.MemberDto;
import java.sql.SQLException;
import java.util.Scanner;

public class View {

    private MemberController memberController;

    public View(MemberController memberController) {
        this.memberController = memberController;
    }

    public void print() throws SQLException {
        System.out.println("--- 환영합니다. ---");
        System.out.println("--- 1. 회원가입 ---");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int value = scanner.nextInt();

            switch (value) {
                case 1:
                    System.out.println("*** 회원가입 ***");

                    System.out.print("이름: ");
                    String name = scanner.next();

                    System.out.print("아이디: ");
                    String id = scanner.next();

                    System.out.print("비밀번호: ");
                    String pwd = scanner.next();

                    memberController.createMember(new MemberDto(name, id, pwd));
                    break;

                default:
                    break;
            }

            break;
        }
    }
}
