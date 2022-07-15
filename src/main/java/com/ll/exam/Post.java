package com.ll.exam;

public class Post {
    int id;
    String contents;
    String author;
    Post (int id, String contents, String author){
        this.id =id;
        this.contents = contents;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", contents='" + contents + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String toJson() {
        return """
                {
                    "id" : %d,
                    "contents" : "%s",
                    "author" : "%s"
                }
                """
                .stripIndent()
                .formatted(id, contents,author)
                .trim();
    }
}
