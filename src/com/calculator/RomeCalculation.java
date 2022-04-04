package com.calculator;

public class RomeCalculation extends LineHandler{
    public static String romeResult;
    private int number1;
    private int number2;
    private final String[] arrayRomeNums = {"#", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public void handlerRomeNumbers(String str, String operator) throws Exception {
        convertToNums(str, operator);
        ArabCalculation arabColcucation = new ArabCalculation(operator, number1, number2);
        convertToRomeNumber(ArabCalculation.arabResult);
    }

    public void convertToNums(String str, String operator){
        String[] arrValues = str.split(" " + operator + " ");

        for (int i = 0; i < arrValues.length; i++) {
            for (int j = 0; j < arrayRomeNums.length; j++) {
                if (arrValues[i].equals(arrayRomeNums[j])){
                    if (number1 == 0){
                        number1 = j;
                    } else {
                        number2 = j;
                    }
                }
            }
        }
    }

    private String convertToRomeNumber(int number){
        String[] arrayRomanTens = {"#", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        if (number == 100) {
            return romeResult = arrayRomanTens[10];
        } else if (number > 10){
            int tens = number / 10;
            if (number % 10 == 0){
                return romeResult = arrayRomanTens[tens];
            } else {
                int unit = number % 10;
                return romeResult = arrayRomanTens[tens] + arrayRomeNums[unit];
            }
        } else {
            return romeResult = arrayRomeNums[number];
        }
    }
}
