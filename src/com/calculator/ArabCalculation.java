package com.calculator;

public class ArabCalculation{
    public static int arabResult;

    public ArabCalculation(String operator, String num1, String num2) throws Exception{
        if (operator.equals("\\+")){
            arabResult = Integer.parseInt(num1) + Integer.parseInt(num2);
        } else if (operator.equals("-")){
            arabResult = Integer.parseInt(num1) - Integer.parseInt(num2);
        } else if (operator.equals("\\*")){
            arabResult = Integer.parseInt(num1) * Integer.parseInt(num2);
        } else if (operator.equals("/")){
            if (Integer.parseInt(num1) == 0 || Integer.parseInt(num2) == 0){
                throw new Exception("Делить на ноль нельзя");
            }
            arabResult = Integer.parseInt(num1) / Integer.parseInt(num2);
        }
    }

    public ArabCalculation(String operator, int num1, int num2) throws Exception{
        if (operator.equals("\\+")){
            arabResult = num1 + num2;
        } else if (operator.equals("-")){
            int res = num1 - num2;
            if (res <= 0){
                throw new Exception("В римской системе счисления не может получится 0 или отрицательное число");
            } else {
                arabResult = res;
            }
        } else if (operator.equals("\\*")){
            arabResult = num1 * num2;
        } else if (operator.equals("/")){
            arabResult = num1 / num2;
            if (arabResult == 0){
                throw new Exception("В римской системе счисления не может получится 0 или отрицательное число");
            }
        }
    }

}
