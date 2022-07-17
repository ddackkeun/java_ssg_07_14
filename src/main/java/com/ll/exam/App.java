package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        WiseSayingController controller = new WiseSayingController(sc);

        outer:
        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);

            switch(rq.getCmd()){
                case "등록":
                    controller.register();
                    break;
                case "목록":
                    controller.list();
                    break;
                case "수정":
                    controller.modify(rq);
                    break;
                case "삭제":
                    controller.remove(rq);
                    break;

                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}
