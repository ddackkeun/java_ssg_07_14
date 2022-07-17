package com.ll.exam;

import org.junit.jupiter.api.Assertions;
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
        Util.file.mkdir("test_data");
        Util.file.saveToFile("test_data/1.txt", "안녕");
        String body = Util.file.readFromFile("test_data/1.txt");
        assertEquals("안녕", body);
    }

    @Test
    void 스캐너_테스트() {
        Scanner sc = TestUtil.getScanner("안녕");
        String cmd = sc.nextLine().trim();
        assertEquals("안녕", cmd);
    }

    @Test
    public void 출력테스트() {
        String result = AppTestRunner.run(
                        """
                        등록
                        나의 죽음을 적에게 알리지 말라
                        이순신
                        종료
                        """);

        assertTrue(result.contains("명언 : "));
        assertTrue(result.contains("작가 : "));
    }

    @Test
    public void 등록_출력테스트() {
        String result = AppTestRunner.run("""
                등록
                나의 죽음을 적에게 알리지 말라
                이순신
                등록
                나에게 불가능이란 없다.
                나폴레옹
                종료
                """);

        assertTrue(result.contains("1번 명언이 등록되었습니다."));
        assertTrue(result.contains("2번 명언이 등록되었습니다."));
    }

    @Test
    public void 목록_출력테스트() {
        String result = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                등록
                나에게 불가능이란 없다.
                나폴레옹
                목록
                종료
                """);
        assertTrue(result.contains("번호 / 작가 / 명언"));
        assertTrue(result.contains("----------------------"));
        assertTrue(result.contains("2 / 나폴레옹 / 나에게 불가능이란 없다."));
        assertTrue(result.contains("1 / 이순신 / 나의 죽음을 적들에게 알리지 말라"));
    }

    @Test
    public void 삭제_출력테스트() {
        String result = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                등록
                나에게 불가능이란 없다.
                나폴레옹
                삭제?id=1
                목록
                삭제?id=1
                종료
                """);
        assertTrue(result.contains("1번 명언이 삭제되었습니다."));
        assertTrue(result.contains("2 / 나폴레옹 / 나에게 불가능이란 없다."));
        assertFalse(result.contains("1 / 이순신 / 나의 죽음을 적들에게 알리지 말라"));
        assertTrue(result.contains("1번 명언은 존재하지 않습니다."));
    }
    @Test
    public void 시작시_타이틀_출력() {
        String result = AppTestRunner.run(
                        """
                        종료
                        """);

        assertTrue(result.contains("== 명언 SSG =="));
        assertTrue(result.contains("명령)"));
    }
}
