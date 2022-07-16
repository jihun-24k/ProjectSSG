package com.ll.exam;

import java.util.Map;

public class Post {
    int id;
    String contents;
    String author;
    Post (int id, String contents, String author){
        this.id =id;
        this.contents = contents;
        this.author = author;
    }

    Post(Map<String,Object> map){
        this.id = (int)map.get("id");
        this.contents = (String)map.get("contents");
        this.author = (String) map.get("author");
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

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o instanceof Post == false){
            return false;
        }

        // 박싱
        Post other = (Post) o;

        if (this.id != other.id){ return false;}
        if (this.contents.equals(other.contents)== false) {return false; }
        if (this.author.equals(other.author) == false){return false; }

        return true;
    }

    @Override
    public int hashCode(){
        int result = id;
        result = 31 * result + (contents != null ? contents.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
