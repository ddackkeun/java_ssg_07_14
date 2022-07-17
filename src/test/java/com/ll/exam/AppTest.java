package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void junit_테스트(){
        int a = 10 + 20;
        assertEquals(30, a);
    }

    @Test
    void 표준출력_테스트() {
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕");

        String result = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        assertEquals("안녕", result);
    }

    @Test
    void 스캐너_테스트() {
        Scanner sc = TestUtil.getScanner("안녕");
        String cmd = sc.nextLine().trim();
        assertEquals("안녕", cmd);
    }
}
