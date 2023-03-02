package com.ll2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public final Scanner sc;
    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        long lastWiseSayingId = 0;
        List<WiseSaying> wiseSayings = new ArrayList<>();

        while(true) {
            System.out.printf("명령) ");
            String input = sc.nextLine().trim(); // 좌우공백 제거

            if (input.equals("등록")){
                long id = lastWiseSayingId + 1;
                System.out.printf("명언 : ");
                String content =sc.nextLine().trim();
                System.out.printf("작가 : ");
                String author=sc.nextLine().trim();

                WiseSaying wiseSaying = new WiseSaying(id, content, author);
                wiseSayings.add(wiseSaying);
                System.out.printf("%d번 명언이 등록되었습니다.", id);
                lastWiseSayingId = id;
            }
            else if(input.equals("목록")){
                System.out.println("생성된 명언 수 : " + wiseSayings.size());
            }
            else if(input.equals("종료")){
                break;
            }
        }

        sc.close();
    }

}