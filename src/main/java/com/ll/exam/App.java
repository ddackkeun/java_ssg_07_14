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
            Rq rq = new Rq(cmd);

            switch(rq.getCmd()){
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();

                    int id = ++sequence;
                    WiseSaying newWiseSaying = new WiseSaying(id, content, author);
                    wiseSayingList.add(newWiseSaying);

                    System.out.println(newWiseSaying.getId() +"번 명언이 등록되었습니다.");
                    break;

                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
                        WiseSaying foundWiseSaying = wiseSayingList.get(i);
                        System.out.println(foundWiseSaying.getId() + " / " +
                                            foundWiseSaying.getAuthor() + " / " +
                                            foundWiseSaying.getContent());
                    }
                    break;
                case "삭제":
                    //해당 명언이 목록에 있는지확인명언
                    // 실행했는데 목록에 계속있으면 로직이 제대로 설계되지 않았음
                    Integer paramId = rq.getParamValue("id", 0);

                    if(paramId == 0){
                        System.out.println("번호를 입력해주세요.");
                        continue;
                    }

                    WiseSaying selectedWiseSaying = null;
                    for (WiseSaying wiseSaying : wiseSayingList) {
                        if (wiseSaying.getId() == paramId) {
                            selectedWiseSaying = wiseSaying;
                        }
                    }

                    if (selectedWiseSaying == null) {
                        System.out.println(paramId + "번 명언은 존재하지 않습니다.");
                        continue;
                    }

                    wiseSayingList.remove(selectedWiseSaying);
                    System.out.println(paramId + "번 명언이 삭제되었습니다.");
                    break;

                case "종료":
                    break outer;
            }
        }
        sc.close();
    }

//    private void remove(Rq rq) {
//
//    }
}
