package com.ll.exam;

import java.util.Scanner;

public class App {
    int sequence;
    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 SSG ==");

        outer:
        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            switch(cmd){
                case "등록":
                    System.out.print("명언 : ");
                    String wiseSaying = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();
                    sequence++;
                    System.out.println( sequence + "번 명언이 등록되었습니다.");
                    break;

                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}
