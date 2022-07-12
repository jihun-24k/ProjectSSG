package com.ll.exam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RqTest {

    @Test
    public void getIntParamTest1(){
        Rq rq = new Rq("삭제?id=1");
        int id = rq.getIntParam("id",0);

        assertEquals(1, id);
    }

    @Test
    public void getIntParamTest2(){
        Rq rq = new Rq("검색?id=10&no=1");
        int id = rq.getIntParam("id",0);
        int no = rq.getIntParam("no",0);

        assertEquals(10,id);
        assertEquals(1, no);
    }

}
