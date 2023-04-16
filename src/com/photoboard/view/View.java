package com.photoboard.view;

import com.photoboard.controller.LoginController;
import com.photoboard.controller.MemberController;
import com.photoboard.dto.LoginDto;
import com.photoboard.dto.MemberDto;
import com.photoboard.view.session.Session;
import java.sql.SQLException;
import java.util.Scanner;

public class View {

    private final MemberController memberController;
    private final LoginController loginController;

    private String id;
    private String name;
    private String pwd;
    private MemberDto byIdMember;
    private Session<LoginDto> session;

    public View(MemberController memberController, LoginController loginController) {
        this.memberController = memberController;
        this.loginController = loginController;
    }

    public void print() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--- 환영합니다. ---");
            System.out.println("--- 1. 회원가입 ---");
            System.out.println("--- 2. 회원수정 ---");
            System.out.println("--- 3. 회원탈퇴 ---");
            System.out.println("--- 4. 로그인 ---");

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

                    byIdMember = memberController.findById(id);
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

                case 3:
                    System.out.println("*** 회원 탈퇴 ***");
                    System.out.print("아이디: ");
                    id = scanner.next();

                    byIdMember = memberController.findById(id);

                    if (byIdMember.getMemberId() == null) {
                        System.out.println("해당 회원 아이디로 조회된 정보는 없습니다.");
                        continue;
                    }

                    System.out.print("탈퇴할 아이디의 비밀번호: ");

                    pwd = scanner.next();

                    if (!byIdMember.getMemberPwd().equals(pwd)) {
                        System.out.println("비밀 번호가 맞지 않습니다.");
                        continue;
                    }

                    memberController.deleteMember(id);
                    break;

                case 4:
                    System.out.println("*** 로그인 페이지 ***");

                    if (session != null) {
                        System.out.println("이미 로그인 되어 있습니다.");
                        continue;
                    }

                    System.out.print("아이디: ");
                    id = scanner.next();

                    byIdMember = memberController.findById(id);

                    if (byIdMember.getMemberId() == null) {
                        System.out.println("해당 회원 아이디로 조회된 정보는 없습니다.");
                        continue;
                    }

                    System.out.print("비밀번호: ");
                    pwd = scanner.next();

                    LoginDto login = loginController.login(id, pwd);

                    if (login.getMemberNo() == -1) {
                        System.out.println("해당 로그인 정보는 존재하지 않습니다. 다시 로그인 해주세요.");
                        continue;
                    }

                    session = new Session<>(login);

                    System.out.println(login.getMemberName() + " 님 환영합니다.");
                    break;

                default:
                    break;
            }

            break;
        }
    }
}
