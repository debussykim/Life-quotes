package com.ll2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 공통적으로 사용되는 기능 모아둔 Container 초기화
        Container.init();

        new App().run();

        // Container 자원해제
        Container.close();
    }
}