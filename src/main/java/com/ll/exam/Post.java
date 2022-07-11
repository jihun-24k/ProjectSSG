package com.ll.exam;

public class Post {
    int idx;
    String contents;
    String author;
    Post (int idx, String contents, String author){
        this.idx =idx;
        this.contents = contents;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "idx=" + idx +
                ", contents='" + contents + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
