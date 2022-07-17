package com.ll.exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtil {

    @BeforeEach
    void beforeEach(){
        Util.deleteDir("test_data");
        Util.mkdir("test_data");
    }

    @Test
    void writeFileTest() {
        Util.saveToFile("test_data/1.json", "내용\n내용");

        String rs = Util.readFromFile("test_data/1.json");

        assertEquals("내용\n내용",rs);
    }

    @Test
    void InstanceToJsonTest(){
        Post post = new Post(1, "난 아직 배고프다","히딩크");
        String strInstance = post.toJson();

        Util.saveToFile("test_data/1.json",strInstance);

        String rs = Util.readFromFile("test_data/1.json");

        assertEquals(rs, strInstance);
    }

    @Test
    void JsonToMapTest(){
        Post post = new Post(1, "난 아직 배고프다","히딩크");
        String strInstance = post.toJson();

        Util.saveToFile("test_data/1.json",strInstance);

        String json = Util.readFromFile("test_data/1.json");
        Map<String, Object> rs = Util.jsonToMap(json);

        assertEquals(rs.get("id"), 1);
        assertEquals(rs.get("contents"), "난 아직 배고프다");
        assertEquals(rs.get("author"), "히딩크");
    }

    @Test
    void MapToInstance(){
        Post post = new Post(1, "난 아직 배고프다","히딩크");
        String strInstance = post.toJson();

        Util.saveToFile("test_data/1.json",strInstance);

        String json = Util.readFromFile("test_data/1.json");
        Map<String, Object> map = Util.jsonToMap(json);
        Post loadedPost = new Post(map);

        assertEquals(map.get("id"), 1);
        assertEquals(map.get("contents"), "난 아직 배고프다");
        assertEquals(map.get("author"), "히딩크");

        assertEquals(post, loadedPost);
    }

    @Test
    void saveFileToNumTest() {
        Util.saveNumberToFile("test_data/last_id.txt", 100);

        int rs = Util.readNumberFromFile("test_data/last_id.txt", 0);

        assertEquals(100, rs);
    }

    @Test
    void loadAllFilesInDirectory() {
        Util.saveNumberToFile("test_data/1.txt", 1);
        Util.saveNumberToFile("test_data/2.txt", 1);
        Util.saveNumberToFile("test_data/3.txt", 1);

        List<String> fileNames = Util.getFileNamesFromDir("test_data");

        assertEquals(fileNames.get(2), "1.txt");
        assertEquals(fileNames.get(1), "2.txt");
        assertEquals(fileNames.get(0), "3.txt");
    }
    @Test
    void 특정_폴더에_들어있는_JSON_파일들만_모아서_객체화_시킨_후_리스트에_담기() {
        Post wiseSaying1 = new Post(1, "내 사전에 불가능은 없다.", "나폴레옹");
        Post wiseSaying2 = new Post(2, "나의 죽음을 적들에게 알리지 마라.", "이순신");

        Util.saveToFile("test_data/1.json", wiseSaying1.toJson());
        Util.saveToFile("test_data/2.json", wiseSaying2.toJson());
        Util.saveNumberToFile("test_data/last_id.txt", 2);

        List<String> fileNames =
                Util.getFileNamesFromDir("test_data")
                        .stream() // 리스트를 스트림으로 변환
                        .filter(fileName -> fileName.endsWith(".json")) // 파일명이 .json 으로 끝나지 않는 것들은 모두 버림
                        .collect(Collectors.toList()); // 스트림을 다시 리스트로 변환

        List<Post> wiseSayings = new ArrayList<>();
        for (String fileName : fileNames) {
            String rs = Util.readFromFile("test_data/" + fileName);
            Map<String, Object> map = Util.jsonToMap(rs);
            Post wiseSaying = new Post(map);
            wiseSayings.add(wiseSaying);
        }

        assertEquals(wiseSaying1, wiseSayings.get(0));
        assertEquals(wiseSaying2, wiseSayings.get(1));
    }
}
