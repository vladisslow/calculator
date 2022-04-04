package com.calculator;

import java.util.Arrays;

public class LineHandler {
    protected String sign;
    protected String value1;
    protected String value2;
    private final String[] arrSigns = {"+", "-", "*", "/"};
    private final String[] arabNumbers = {"10", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private final String[] romeNumbers = {"X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String calculator(String str) throws Exception {
        checkSign(str, arrSigns);
        getValues(str, this.sign, this.arabNumbers, this.romeNumbers);
        try {
            // Пробуем перевести в число
            // Если число не переводится и является римским, программа выдаст ошибку и перейдет в catch
            int convertStringToNum = Integer.parseInt(this.value1);
            ArabCalculation arabCalculation = new ArabCalculation(this.sign, this.value1, this.value2);
            return ArabCalculation.arabResult + "";
        } catch(NumberFormatException e){
            RomeCalculation romeCalculation = new RomeCalculation();
            romeCalculation.handlerRomeNumbers(str, this.sign);
            return RomeCalculation.romeResult;
        }
    }


    // Метод определяет, является ли строка арифетической и если да возвращает полученный знак
    private String checkSign(String str, String[] arrSigns) throws Exception {
        String valueSign = "";
        int indexSign = 0;
        int countSign = 0;
        for (int i = 0; i < arrSigns.length; i++) {
            if (str.contains(arrSigns[i])) {
                valueSign = arrSigns[i];
                indexSign = str.indexOf(arrSigns[i]);
                countSign++;
            }
        }
        for (int i = 0; i < arrSigns.length; i++) {
            if (str.indexOf(arrSigns[i], indexSign + 1) != -1) {
                countSign++;
            }
        }
        if (countSign == 1) {
            if (valueSign.equals("+") || valueSign.equals("*")) {
                this.sign = "\\" + valueSign;
            } else {
                this.sign = valueSign;
            }
        } else {
            throw new Exception("Empty Sign || more 1 sign...");
        }
        return this.sign;
    }

    // Метод определяет значения и, если значения верны по условию, заполняет нужные поля
    private void getValues(String str, String sign, String[] arabNumbers, String[] romeNumbers) throws Exception {
        String[] arrValues = str.split(" " + sign + " ");
        int countArabNums = 0;
        int countRomeNums = 0;
        if (arrValues.length == 2) {
            for (int i = 0; i < arrValues.length; i++) {
                for (int j = 0; j < arabNumbers.length; j++) {
                    if (arrValues[i].equals(arabNumbers[j])) {
                        countArabNums++;
                    }
                }
            }
            for (int i = 0; i < arrValues.length; i++) {
                for (int j = 0; j < romeNumbers.length; j++) {
                    if (arrValues[i].equals(romeNumbers[j])) {
                        countRomeNums++;
                    }
                }
            }
        }
        if (countArabNums == 2) {
            value1 = arrValues[0];
            value2 = arrValues[1];
        } else if (countRomeNums == 2) {
            value1 = arrValues[0];
            value2 = arrValues[1];
        } else {
            throw new Exception("Неверные значения или неверно введена строка");
        }
    }
}
