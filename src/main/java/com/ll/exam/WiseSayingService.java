package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {

    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying register(String content, String author) {
        return wiseSayingRepository.save(content, author);
    }

    public List<WiseSaying> list() {
        return wiseSayingRepository.findAll();
    }

    public boolean remove(Integer id) {
        return wiseSayingRepository.remove(id);
    }

    public boolean modify(int id, String content, String author) {
        return wiseSayingRepository.modify(id, content, author);
    }

    public WiseSaying findMember(int id) {
        return wiseSayingRepository.findById(id);
    }
}
