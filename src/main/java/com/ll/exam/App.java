package com.ll.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    ArrayList<Post> posts;
    Scanner sc;
    int postId;
    App(){
        this.posts = new ArrayList<>();
        this.sc = new Scanner(System.in);
        this.postId = 1;
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
                    write();
                    break;
                case "목록":
                    list();
                    break;
                case "삭제":
                    delete(rq);
                    break;
            }
        }
        sc.close();
    }
    public void write(){
        System.out.printf("명언 : ");
        String contents = sc.nextLine();
        System.out.printf("작가 : ");
        String author = sc.nextLine();

        Post newPost = new Post(postId, contents, author);
        posts.add(newPost);
        System.out.println(postId+"번 글이 등록되었습니다.");
        postId++;
    }
    public void list(){
        System.out.println("-- 명언 목록 --");
        System.out.println("id/  작가/  명언");
        for (int i = posts.size() - 1; i >= 0; i--){
            Post post1 = posts.get(i);
            System.out.printf("%d/%3s/%3s\n", post1.idx, post1.author, post1.contents);
        }
    }

    public void delete(Rq rq){
        int delId = rq.getIntParam("id",0);
        Post postNull = null;
        if (delId == 0){
            System.out.println("id 값을 입력해주세요.");
            return ;
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
    }

}
