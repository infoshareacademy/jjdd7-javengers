package com.infoshareacademy.service;

import java.io.IOException;

public class ClearScreenService {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
