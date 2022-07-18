package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private int sequence;
    private List<WiseSaying> wiseSayingList;

    public WiseSayingRepository() {
        sequence = 0;
        wiseSayingList = new ArrayList<>();
    }

    public WiseSaying save(String content, String author) {
        int id = ++sequence;

        WiseSaying newWiseSaying = new WiseSaying(id, content, author);
        wiseSayingList.add(newWiseSaying);

        return newWiseSaying;
    }

    public List<WiseSaying> findAll() {
        return new ArrayList<>(wiseSayingList);
    }

    public boolean remove(int id) {
        WiseSaying foundWiseSaying = findById(id);

        if (foundWiseSaying == null) {
            return false;
        }

        wiseSayingList.remove(foundWiseSaying);
        sequence--;
        return true;
    }

    public boolean modify(int id, String content, String author) {
        WiseSaying foundWiseSaying = findById(id);
        if (foundWiseSaying == null) {
            return false;
        }

        foundWiseSaying.setContent(content);
        foundWiseSaying.setAuthor(author);

        return true;
    }

    public WiseSaying findById(Integer id) {
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }
}
