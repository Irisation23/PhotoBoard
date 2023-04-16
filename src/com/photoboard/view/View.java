package com.photoboard.view;

import com.photoboard.controller.MemberController;
import com.photoboard.dto.MemberDto;
import java.sql.SQLException;
import java.util.Scanner;

public class View {

    private MemberController memberController;

    private String id;
    private String name;
    private String pwd;

    private MemberDto byIdMember;

    public View(MemberController memberController) {
        this.memberController = memberController;
    }

    public void print() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--- 환영합니다. ---");
            System.out.println("--- 1. 회원가입 ---");
            System.out.println("--- 2. 회원수정 ---");

            int value = scanner.nextInt();

            switch (value) {
                case 1:
                    System.out.println("*** 회원가입 ***");

                    System.out.print("이름: ");
                    name = scanner.next();

                    System.out.print("아이디: ");
                    id = scanner.next();

                    byIdMember = memberController.findById(id);
                    if (byIdMember.getMemberId() != null) {
                        System.out.println("이미 가입된 회원입니다.");
                        continue;
                    }

                    System.out.print("비밀번호: ");
                    pwd = scanner.next();

                    memberController.createMember(new MemberDto(name, id, pwd));
                    break;

                case 2:
                    System.out.println("*** 회원수정 ***");
                    System.out.print("아이디: ");
                    id = scanner.next();

                    MemberDto byIdMember = memberController.findById(id);
                    if (byIdMember.getMemberId() == null) {
                        System.out.println("해당 회원 아이디로 조회된 정보는 없습니다.");
                        continue;
                    }

                    System.out.print("변경할 이름: ");
                    byIdMember.setMemberName(scanner.next());

                    System.out.print("변경할 아이디: ");
                    byIdMember.setMemberId(scanner.next());

                    System.out.print("변경할 비밀번호: ");
                    byIdMember.setMemberPwd(scanner.next());

                    memberController.updateMember(id, byIdMember);

                    System.out.println("변경 완료 되었습니다.");
                    break;

                default:
                    break;
            }

            break;
        }
    }
}
