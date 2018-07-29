package com.homework.calc;


import android.util.Log;

public class Calculation {

    // Running process
    protected double runCalc(double _firstNum, double _secondNum, String _calcSign) {
        if (_calcSign.equals(Const.DIVIDE_SIGN)) {
            return divideNum(_firstNum, _secondNum);

        } else if (_calcSign.equals(Const.MULTIPLY_SIGN)) {
            return multiplyNum(_firstNum, _secondNum);

        } else if (_calcSign.equals(Const.ADD_SIGN)) {
            return addNum(_firstNum, _secondNum);

        } else if (_calcSign.equals(Const.SUBTRACT_SIGN)) {
            return subtractNum(_firstNum, _secondNum);
        }

        return 0.0;
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

    // ブランクチェック
    protected String convertNum(double num) {
        double _num = num;
        if ((_num - ((int) _num)) == 0) {
            Log.d("if", ">>>" + String.valueOf((int) _num));

            return String.valueOf((int) _num);
        } else{
            double n = Math.pow(10.0, Const.DECIMAL_POINT);
            _num = Math.round(_num*n)/n;
        }

        return String.valueOf(_num);
    }
}




