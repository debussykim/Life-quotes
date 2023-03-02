package com.ll2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 SSG ==");
        System.out.printf("명령) ");
        String input = sc.nextLine();

        while(true) {
            if (input.equals("등록")){
                System.out.printf("명언 : ");
                String quotes = sc.nextLine();
                System.out.printf("작가 : ");
                String author = sc.nextLine();
                System.out.printf("명령) ");
                input = sc.nextLine();
            }
            else if(input.equals("종료")){
                break;
            }
        }

        sc.close();
    }
}