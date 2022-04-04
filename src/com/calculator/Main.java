package com.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);

        LineHandler lineHandler = new LineHandler();
        String result = lineHandler.calculator(console.nextLine());
        System.out.println(result);

    }
}
