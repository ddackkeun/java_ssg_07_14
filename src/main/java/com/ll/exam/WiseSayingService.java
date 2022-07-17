package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private int sequence;
    private List<WiseSaying> wiseSayingList;

    public WiseSayingService() {
        sequence = 0;
        wiseSayingList = new ArrayList<>();
    }

    public WiseSaying findById(Integer id) {
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }

    public WiseSaying register(String content, String author) {
        int id = ++sequence;

        WiseSaying newWiseSaying = new WiseSaying(id, content, author);
        wiseSayingList.add(newWiseSaying);

        return newWiseSaying;
    }

    public List<WiseSaying> findAll() {
        return new ArrayList<>(wiseSayingList);
    }


    public boolean remove(Integer id) {
        WiseSaying foundWiseSaying = findById(id);

        if (foundWiseSaying == null) {
            return false;
        }
        wiseSayingList.remove(foundWiseSaying);
        return true;
    }

    public boolean modify(int id, String content, String author) {
        WiseSaying foundWiseSaying = wiseSayingList.get(id);

        if (foundWiseSaying == null) {
            return false;
        }

        foundWiseSaying.setContent(content);
        foundWiseSaying.setAuthor(author);
        return true;
    }
}
