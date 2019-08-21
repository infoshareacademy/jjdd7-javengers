package com.infoshareacademy.service;

public class ClearScreenService {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



}
