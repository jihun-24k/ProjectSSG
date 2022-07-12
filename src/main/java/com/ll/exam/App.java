package com.ll.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Post post;
    ArrayList<Post> posts;
    App(){
        posts = new ArrayList<>();
    }

    public Post write(int idx){
        Scanner sc1 = new Scanner(System.in);

        System.out.printf("명언 : ");
        String contents = sc1.nextLine();
        System.out.printf("작가 : ");
        String author = sc1.nextLine();

        post = new Post(idx, contents, author);

        System.out.println(idx+"번 글이 등록되었습니다.");
        return post;
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
            Rq rq = new Rq(cmd);

            switch (rq.getPath()){
                case "종료":
                    break outer;
                case "등록":
                    posts.add(write(idx));
                    idx++;
                    break;
                case "목록":
                    System.out.println("-- 명언 목록 --");
                    System.out.println("id/  작가/  명언");
                    for (int i = posts.size() - 1; i >= 0; i--){
                        Post post1 = posts.get(i);
                        System.out.printf("%d/%3s/%3s\n", post1.idx, post1.author, post1.contents);
                    }
                    break;
                case "삭제":
                    int delId = rq.getIntParam("id",0);
                    Post postNull = null;
                    if (delId == 0){
                        System.out.println("id 값을 입력해주세요.");
                        continue ;
                    }
                    for (int i = posts.size() - 1; i >= 0; i--){
                        Post delPost = posts.get(i);
                        if (delPost.idx == delId){
                            System.out.println(delPost.idx+"번 명언이 삭제되었습니다.");
                            posts.remove(i);
                            postNull = delPost;
                            break ;
                        }
                    }
                    if (postNull == null){
                        System.out.println(delId+"번 명언은 없습니다.");
                    }
                    break;
            }
        }
        sc.close();
    }
}
