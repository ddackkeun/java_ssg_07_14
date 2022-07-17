package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    private WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingService = new WiseSayingService();
    }

    public void register() {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying newWiseSaying = wiseSayingService.register(content, author);
        System.out.println(newWiseSaying.getId() +"번 명언이 등록되었습니다.");
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseSayingList = wiseSayingService.findAll();

        // 내림차순 출력
        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying foundWiseSaying = wiseSayingList.get(i);
            System.out.println(foundWiseSaying.getId() + " / " +
                    foundWiseSaying.getAuthor() + " / " +
                    foundWiseSaying.getContent());
        }
    }

    public void remove(Rq rq) {
        if (rq.getParamMap() == null) return;

        Integer selectedId = rq.getParamValue("id");

        if(selectedId <= 0){
            System.out.println("번호를 입력해주세요.");
            return;
        }

        WiseSaying foundWiseSaying = wiseSayingService.findById(selectedId);

        // 존재하지 않음
        if (foundWiseSaying == null) {
            System.out.println(selectedId + "번 명언은 존재하지 않습니다.");
            return;
        }

        // 존재
        if (wiseSayingService.remove(selectedId)) {
            System.out.println(selectedId + "번 명언이 삭제되었습니다.");
        }
        else{
            System.out.println(selectedId + "번 명언을 삭제하지 못했습니다.");
        }
    }

    public void modify(Rq rq) {
        if(rq.getParamMap() == null ) return ;

        Integer selectedId = rq.getParamValue("id");

        if(selectedId <= 0){
            System.out.println("번호를 입력해주세요.");
            return;
        }

        WiseSaying foundWiseSaying = wiseSayingService.findById(selectedId);

        // 존재하지 않음
        if (foundWiseSaying == null) {
            System.out.println(selectedId + "번 명언은 존재하지 않습니다.");
            return;
        }

        // 존재
        System.out.println("명언(기존) : " + foundWiseSaying.getContent());
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();

        System.out.println("작가(기존) : " + foundWiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        if (wiseSayingService.modify(foundWiseSaying.getId(), content, author)) {
            System.out.println(foundWiseSaying.getId() + "번 명언이 수정되었습니다.");
        }
        else{
            System.out.println(foundWiseSaying.getId() + "번 명언을 수정하지 못했습니다");
        }
    }
}
