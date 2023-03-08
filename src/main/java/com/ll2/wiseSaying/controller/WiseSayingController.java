package com.ll2.wiseSaying.controller;

import com.ll2.Container;
import com.ll2.wiseSaying.entity.WiseSaying;
import com.ll2.Rq;

import java.util.*;

public class WiseSayingController {
    private long lastWiseSayingId;
    private final List<WiseSaying> wiseSayings;

    public WiseSayingController() {
        lastWiseSayingId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void write() {
        long id = lastWiseSayingId + 1;
        System.out.printf("명언 : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.printf("작가 : ");
        String author=Container.getScanner().nextLine().trim();

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
        lastWiseSayingId = id;
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));

        for(int i=wiseSayings.size()-1; i>=0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }

    public void remove(Rq rq) {
        // id값을 정수화해서 보내주고, 만약 실패하면 -1을 보낸다.
        int id = rq.getIntParams("id", -1);

        if (id==1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }
        // 입력된 id와 일치하는 명언 객체 찾기
        WiseSaying wiseSaying = findById(id);

        // 찾은 명언 객체를 리스트에서 제거
        wiseSayings.remove(wiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    private WiseSaying findById(int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }
}
