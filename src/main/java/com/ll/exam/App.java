package com.ll.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Scanner sc;
    PostController postController;
    App(){
        this.sc = new Scanner(System.in);
        this.postController = new PostController();
    }
    public void run() {
        System.out.println("-- 명언 SSG --");

        outer:
        while (true){
            System.out.printf("명령) ");
            // trim()은 띄어쓰기를 삭제
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);

            switch (rq.getPath()){
                case "종료":
                    break outer;
                case "등록":
                    postController.write();
                    break;
                case "목록":
                    postController.list();
                    break;
                case "수정":
                    postController.change(rq);
                    break;
                case "삭제":
                    postController.delete(rq);
                    break;
            }
        }
        sc.close();
    }

}
