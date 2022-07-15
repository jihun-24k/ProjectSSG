package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtil {

    @Test
    void writeFileTest() {
        Util.mkdir("test_data");
        Util.saveToFile("test_data/1.json", "내용\n내용");

        String rs = Util.readFromFile("test_data/1.json");

        assertEquals("내용\n내용",rs);
    }

    @Test
    void InstanceToJsonTest(){
        Util.mkdir("test_data");
        Post post = new Post(1, "난 아직 배고프다","히딩크");
        String strInstance = post.toJson();

        Util.saveToFile("test_data/1.json",strInstance);

        String rs = Util.readFromFile("test_data/1.json");

        assertEquals(rs, strInstance);
    }

    @Test
    void JsonToMapTest(){
        Util.mkdir("test_data");
        Post post = new Post(1, "난 아직 배고프다","히딩크");
        String strInstance = post.toJson();

        Util.saveToFile("test_data/1.json",strInstance);

        String json = Util.readFromFile("test_data/1.json");
        Map<String, Object> rs = Util.jsonToMap(json);

        assertEquals(rs.get("id"), 1);
        assertEquals(rs.get("contents"), "난 아직 배고프다");
        assertEquals(rs.get("author"), "히딩크");
    }
}
