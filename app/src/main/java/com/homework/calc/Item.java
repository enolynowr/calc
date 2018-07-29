package com.homework.calc;

public class Item {

    double firstNum;
    double secondNum;

    public double getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    double resultNum;
    String calcSign;


    public double getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public double getResultNum() {
        return resultNum;
    }

    public void setResultNum(double resultNum) {
        this.resultNum = resultNum;
    }

    public String getCalcSign() {
        return calcSign;
    }

    public void setCalcSign(String calcSign) {
        this.calcSign = calcSign;
    }
}
