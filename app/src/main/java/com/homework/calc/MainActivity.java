package com.homework.calc;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.homework.calc.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Calculation calculation;
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculation = new Calculation();
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setCalcModel(calculation);
        mainBinding.setOnOkClick(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.num_0:
                setFirstNum(0);
                break;
            case R.id.num_1:
                setFirstNum(1);
                break;
            case R.id.num_2:
                setFirstNum(2);
                break;
            case R.id.num_3:
                setFirstNum(3);
                break;
            case R.id.num_4:
                setFirstNum(4);
                break;
            case R.id.num_5:
                setFirstNum(5);
                break;
            case R.id.num_6:
                setFirstNum(6);
                break;
            case R.id.num_7:
                setFirstNum(7);
                break;
            case R.id.num_8:
                setFirstNum(8);
                break;
            case R.id.num_9:
                setFirstNum(9);
                break;

            // SIGN
            case R.id.divide:
                Toast.makeText(this, "/", Toast.LENGTH_SHORT).show();
                saveFirstNum(Const.DIVIDE_SIGN);
                break;
            case R.id.multiply:
                Toast.makeText(this, "*", Toast.LENGTH_SHORT).show();
                saveFirstNum(Const.MULTIPLY_SIGN);
                break;
            case R.id.subtract:
                Toast.makeText(this, "-", Toast.LENGTH_SHORT).show();
                saveFirstNum(Const.SUBTRACT_SIGN);
                break;
            case R.id.add:
                Toast.makeText(this, "+", Toast.LENGTH_SHORT).show();
                saveFirstNum(Const.ADD_SIGN);
                break;

            //PROCESS
            case R.id.equal:
                if (!checkNull()) return;
                Toast.makeText(this, "EQUAL", Toast.LENGTH_SHORT).show();
                calculation.item.secondNum = Double.parseDouble(mainBinding.inputNum.getText().toString());
                mainBinding.standByNum.setText(calculation.runCalc(calculation.item.firstNum, calculation.item.secondNum));
                mainBinding.inputNum.setText("");
                break;
            case R.id.clear:
                Toast.makeText(this, "clear", Toast.LENGTH_SHORT).show();
                calculation.item.firstNum = 0;
                calculation.item.secondNum = 0;
                mainBinding.standByNum.setText("");
                mainBinding.inputNum.setText("");
                break;
        }
    }

    // 待機テキストビューに初数字セット、演算子保存
    private void saveFirstNum(String _sign) {
        if (!checkNull()) return;
        calculation.item.firstNum = Double.parseDouble(mainBinding.inputNum.getText().toString());

        switch (_sign) {
            case Const.DIVIDE_SIGN:
                mainBinding.standByNum.setText(String.valueOf(calculation.item.firstNum) + " " + Const.DIVIDE_SIGN);
                calculation.item.calcSign = Const.DIVIDE_SIGN;
                break;
            case Const.MULTIPLY_SIGN:
                mainBinding.standByNum.setText(String.valueOf(calculation.item.firstNum) + " " + Const.MULTIPLY_SIGN);
                calculation.item.calcSign = Const.MULTIPLY_SIGN;
                break;
            case Const.ADD_SIGN:
                mainBinding.standByNum.setText(String.valueOf(calculation.item.firstNum) + " " + Const.ADD_SIGN);
                calculation.item.calcSign = Const.ADD_SIGN;
                break;
            case Const.SUBTRACT_SIGN:
                mainBinding.standByNum.setText(String.valueOf(calculation.item.firstNum) + " " + Const.SUBTRACT_SIGN);
                calculation.item.calcSign = Const.SUBTRACT_SIGN;
                break;
        }

        mainBinding.inputNum.setText("");
    }

    // 初めての数字セット
    private void setFirstNum(int _num) {
        mainBinding.inputNum.setText(mainBinding.inputNum.getText().toString() + _num);
    }

    // ブランクチェック
    private boolean checkNull() {
        if (!calculation.checkNull(mainBinding.inputNum.getText().toString())) {
            Toast.makeText(this, "NULL IS BACK!!!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
