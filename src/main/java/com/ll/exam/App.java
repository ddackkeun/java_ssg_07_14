package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;
    int sequence;
    List<WiseSaying> wiseSayingList;

    public App() {
        sc = new Scanner(System.in);
        wiseSayingList = new ArrayList<>();
        sequence = 0;
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);

            switch(rq.getCmd()){
                case "등록":
                    register();
                    break;
                case "목록":
                    list();
                    break;
                case "수정":
                    modify(rq);
                    break;
                case "삭제":
                    remove(rq);
                    break;

                case "종료":
                    break outer;
            }
        }

        sc.close();
    }

    private void modify(Rq rq) {
        if(rq.getParamMap() == null ) return ;

        Integer selectedId = rq.getParamValue("id");

        if(selectedId <= 0){
            System.out.println("번호를 입력해주세요.");
            return;
        }

        WiseSaying foundWiseSaying = null;
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == selectedId) {
                foundWiseSaying = wiseSaying;
            }
        }

        // 존재하지 않음
        if (foundWiseSaying == null) {
            System.out.println(selectedId + "번 명언은 존재하지 않습니다.");
            return;
        }

        // 존재
        System.out.println("명언(기존) : " + foundWiseSaying.getContent());
        System.out.print("명언 : ");
        foundWiseSaying.setContent(sc.nextLine().trim());

        System.out.println("작가(기존) : " + foundWiseSaying.getAuthor());
        System.out.print("작가 : ");
        foundWiseSaying.setAuthor(sc.nextLine().trim());
    }

    private void register() {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        int id = ++sequence;
        WiseSaying newWiseSaying = new WiseSaying(id, content, author);
        wiseSayingList.add(newWiseSaying);

        System.out.println(newWiseSaying.getId() +"번 명언이 등록되었습니다.");
    }

    private void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        // 내림차순 출력
        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying foundWiseSaying = wiseSayingList.get(i);
            System.out.println(foundWiseSaying.getId() + " / " +
                    foundWiseSaying.getAuthor() + " / " +
                    foundWiseSaying.getContent());
        }
    }

    private void remove(Rq rq) {
        if (rq.getParamMap() == null) return;

        Integer selectedId = rq.getParamValue("id");

        if(selectedId <= 0){
            System.out.println("번호를 입력해주세요.");
            return;
        }

        WiseSaying foundWiseSaying = null;
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == selectedId) {
                foundWiseSaying =  wiseSaying;
                break;
            }
        }

        // 존재하지 않음
        if (foundWiseSaying == null) {
            System.out.println(selectedId + "번 명언은 존재하지 않습니다.");
            return;
        }

        // 존재
        wiseSayingList.remove(foundWiseSaying);
        System.out.println(selectedId + "번 명언이 삭제되었습니다.");
    }

}
