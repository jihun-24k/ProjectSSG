package com.ll.exam;

import org.junit.jupiter.api.Test;

public class TestUtil {

    @Test
    void writeFileTest() {
        Util.mkdir("test_data");
        Util.saveToFile("test_data/1.json", "내용");
    }
}
