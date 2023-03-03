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

            if (input.equals("등록")){
                wiseSayingController.write();
            }
            else if(input.equals("목록")){
                wiseSayingController.list();
            }
            else if(input.startsWith("삭제")){
                Rq rq = new Rq(input);
                System.out.printf("actionCode : %s\n", rq.getActionCode());
                System.out.printf("params.id : %s\n", rq.getParam("id"));
                System.out.printf("params.authorName : %s\n", rq.getParam("authorName"));
                System.out.printf("params.content : %s\n", rq.getParam("content"));
                wiseSayingController.remove();
            }
            else if(input.equals("종료")){
                systemController.exit();
                break;
            }
        }
    }

}