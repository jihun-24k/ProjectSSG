package com.ll.exam;

import java.util.Scanner;

public class App {

    public void add(int idx){
        Scanner sc1 = new Scanner(System.in);

        System.out.printf("명언 : ");
        sc1.nextLine();
        System.out.printf("작가 : ");
        sc1.nextLine();

        System.out.println(idx+"번 글이 등록되었습니다.");
    }

    public void run() {
        System.out.println("-- 명언 SSG --");
        Scanner sc = new Scanner(System.in);
        int idx = 1;

        outer:
        while (true){
            System.out.printf("명령) ");
            // trim()은 띄어쓰기를 삭제
            String cmd = sc.nextLine().trim();

            switch (cmd){
                case "종료":
                    break outer;
                case "등록":
                    add(idx);
                    idx++;
                    break;
            }
        }
        sc.close();
    }
}
