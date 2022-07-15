package com.ll.exam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtil {

    @Test
    void writeFileTest() {
        Util.mkdir("test_data");
        Util.saveToFile("test_data/1.json", "내용\n내용");

        String rs = Util.readFromFile("test_data/1.json");

        assertEquals("내용\n내용",rs);
    }
}
