package com.homework.calc;


public class Calculation {

    Item item = new Item();

    // Running process
    protected String runCalc(double _firstNum, double _secondNum) {
        if (item.calcSign.equals(Const.DIVIDE_SIGN)) {
            item.resultNum = divideNum(_firstNum, _secondNum);
            return String.valueOf(item.resultNum);

        } else if (item.calcSign.equals(Const.MULTIPLY_SIGN)) {
            item.resultNum = multiplyNum(_firstNum, _secondNum);
            return String.valueOf(item.resultNum);

        } else if (item.calcSign.equals(Const.ADD_SIGN)) {
            item.resultNum = addNum(_firstNum, _secondNum);
            return String.valueOf(item.resultNum);

        } else if (item.calcSign.equals(Const.SUBTRACT_SIGN)) {
            item.resultNum = subtractNum(_firstNum, _secondNum);
            return String.valueOf(item.resultNum);
        }

        return String.valueOf(0.0);
    }


    // ADD
    protected double addNum(double firstNum, double secondNum) {
        double addSum;
        addSum = firstNum + secondNum;
        return addSum;
    }

    // SUBTRACT
    protected double subtractNum(double firstNum, double secondNum) {
        double subtractSum;
        subtractSum = firstNum - secondNum;
        return subtractSum;
    }

    // MULTIPLY
    protected double multiplyNum(double firstNum, double secondNum) {
        double multiplySum;
        multiplySum = firstNum * secondNum;
        return multiplySum;
    }

    // DIVIDE
    protected double divideNum(double firstNum, double secondNum) {
        double divideSum;
        divideSum = firstNum / secondNum;
        return divideSum;
    }

    protected boolean checkNull(String _firstNum) {
        if (_firstNum.equals("") || _firstNum == null) {
            return false;
        }
        return true;
    }
}




