package com.ll.exam;

import java.util.Scanner;

public class PostController {
    private Scanner sc;
    private PostRepository postRepository;

    PostController(Scanner sc){
        this.sc = sc;
        this.postRepository = new PostRepository();
    }

    public void write(){
        System.out.printf("명언 : ");
        String contents = sc.nextLine();
        System.out.printf("작가 : ");
        String author = sc.nextLine();

        postRepository.write(contents, author);
        System.out.println(postRepository.postId+"번 글이 등록되었습니다.");
    }
    public void list(){
        System.out.println("-- 명언 목록 --");
        System.out.println("id/  작가/  명언");
        for (int i = postRepository.posts.size() - 1; i >= 0; i--){
            Post post1 = postRepository.posts.get(i);
            System.out.printf("%d/%3s/%3s\n", post1.idx, post1.author, post1.contents);
        }
    }

    public void delete(Rq rq){
        int delId = rq.getIntParam("id",0);

        if (delId == 0){
            System.out.println("id 값을 입력해주세요.");
            return ;
        }
        Post delPost = postRepository.findById(delId);
        if (delPost == null){
            System.out.println(delId+"번 명언은 없습니다.");
        }
        else{
            postRepository.delete(delId);
            System.out.println(delId+"번 명언이 삭제되었습니다.");
        }
    }

    public void change(Rq rq) {
        int chaId = rq.getIntParam("id",0);

        if (chaId == 0){
            System.out.println("id 값을 입력해주세요.");
            return ;
        }
        Post changePost = postRepository.findById(chaId);
        if (changePost == null){
            System.out.println(chaId+"번 명언은 없습니다.");
        }
        else{
            System.out.printf("변경할 명언 : %s\n", changePost.contents);
            System.out.print("새로운 명언 : ");
            String contents = sc.nextLine().trim();
            changePost.contents = contents;

            System.out.printf("변경할 작가 : %s\n", changePost.author);
            System.out.print("새로운 작가 : ");
            String author = sc.nextLine().trim();
            changePost.author = author;

            System.out.println("수정이 완료되었습니다.");
        }
    }
}
