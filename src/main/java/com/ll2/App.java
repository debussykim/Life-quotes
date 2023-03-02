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
                // 정리 시작
                String[] inputBits = input.split("\\?", 2); //최대 2개까지 ?를 기준으로 나누기
                //System.out.println(Arrays.toString(inputBits));
                String actionCode = inputBits[0];

                Map<String, String> params = new HashMap<>();
                String[] paramBits = inputBits[1].split("&");
                for (String paramStr : paramBits) {
                    String[] paramStrBits = paramStr.split("=", 2);
                    String key = paramStrBits[0];
                    String value = paramStrBits[1];
                    params.put(key, value);
                }

                // 정리 끝
                System.out.printf("actionCode: %s\n", actionCode);
                System.out.printf("params: %s\n", params);

                wiseSayingController.remove();
            }
            else if(input.equals("종료")){
                systemController.exit();
                break;
            }
        }
    }

}