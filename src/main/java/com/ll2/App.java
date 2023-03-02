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
                System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                lastWiseSayingId = id;
            }
            else if(input.equals("목록")){
                System.out.println("번호 / 명언 / 작가");
                System.out.println("-".repeat(30));

                for(int i=wiseSayings.size()-1; i>=0; i--){
                    WiseSaying wiseSaying = wiseSayings.get(i);
                    System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor());

                }
            }
            else if(input.equals("종료")){
                break;
            }
        }

        sc.close();
    }

}