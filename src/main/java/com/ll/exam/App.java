package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;
    int sequence;
    List<WiseSaying> wiseSayingList;

    public void run() {
        sc = new Scanner(System.in);
        wiseSayingList = new ArrayList<>();

        sequence = 0;

        System.out.println("== 명언 SSG ==");

        outer:
        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            switch(cmd){
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();
                    int id = ++sequence;
                    WiseSaying wiseSaying = new WiseSaying(id, content, author);
                    System.out.println(wiseSaying.getId() +"번 명언이 등록되었습니다.");
                    break;

                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}
