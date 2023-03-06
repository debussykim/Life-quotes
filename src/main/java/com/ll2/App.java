package com.ll2;

import com.ll2.system.controller.SystemController;
import com.ll2.wiseSaying.controller.WiseSayingController;
import com.ll2.wiseSaying.entity.WiseSaying;

import java.util.*;

public class App {

    public void run() {
        System.out.println("== 명언 SSG ==");

        long lastWiseSayingId = 0;
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        while(true) {
            System.out.printf("명령) ");
            String input = Container.getScanner().nextLine().trim(); // 좌우공백 제거

            Rq rq = new Rq(input);

            switch (rq.getActionCode()) {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.remove(rq);
                    break;
            }
        }
    }

}