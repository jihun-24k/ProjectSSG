package com.ll.exam;

import java.util.ArrayList;

public class PostRepository {
    int postId;
    ArrayList<Post> posts;

    PostRepository(){
        this.postId = 0;
        this.posts = new ArrayList<>();
    }

    public Post write(String contents, String author){
        postId++;
        Post newPost = new Post(postId, contents, author);
        posts.add(newPost);

        return newPost;
    }

    public Post delete(int delId){
        Post delPost = findById(delId);
        posts.remove(delId);
        return delPost;
    }

    public Post findById(int id){
        for (Post post: posts){
            if (post.id == id){
                return post;
            }
        }
        return null;
    }
}
