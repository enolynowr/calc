package com.homework.calc;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.homework.calc.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Calculation calculation;
    Item item;
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculation = new Calculation();
        item = new Item();

        // データバインディング設定
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setCalcModel(calculation);
        mainBinding.setOnOkClick(this);
    }

    public void onClick(View v) {

        // 数字
        switch (v.getId()) {
            case R.id.num_0:
                displayFirstNum(0);
                break;
            case R.id.num_1:
                displayFirstNum(1);
                break;
            case R.id.num_2:
                displayFirstNum(2);
                break;
            case R.id.num_3:
                displayFirstNum(3);
                break;
            case R.id.num_4:
                displayFirstNum(4);
                break;
            case R.id.num_5:
                displayFirstNum(5);
                break;
            case R.id.num_6:
                displayFirstNum(6);
                break;
            case R.id.num_7:
                displayFirstNum(7);
                break;
            case R.id.num_8:
                displayFirstNum(8);
                break;
            case R.id.num_9:
                displayFirstNum(9);
                break;

            // 演算子
            case R.id.divide:
                saveFirstNum(Const.DIVIDE_SIGN);
                break;
            case R.id.multiply:
                saveFirstNum(Const.MULTIPLY_SIGN);
                break;
            case R.id.subtract:
                saveFirstNum(Const.SUBTRACT_SIGN);
                break;
            case R.id.add:
                saveFirstNum(Const.ADD_SIGN);
                break;

            // 演算する
            case R.id.equal:
                if (!checkNull()) return;
                //二番目の数字の取得
                item.setSecondNum(Double.parseDouble(mainBinding.inputNum.getText().toString()));
                // 初数字、二番目の数字、演算子記号を関数に渡す
                double resultNum = calculation.runCalc(item.getFirstNum(), item.getSecondNum(), item.getCalcSign());
                mainBinding.standByNum.setText(calculation.convertNum(resultNum));
                mainBinding.inputNum.setText("");
                break;

            // 数字、テキストビュー、エディタビューの削除
            case R.id.clear:
                Toast.makeText(this, "clear", Toast.LENGTH_SHORT).show();
                item.setFirstNum(0);
                item.setSecondNum(0);
                mainBinding.standByNum.setText("");
                mainBinding.inputNum.setText("");
                break;
        }
    }

    // 待機テキストビューに初数字セット、演算子保存
    private void saveFirstNum(String _sign) {
        if (!checkNull()) return;

        //初数字の取得し、保存
        item.setFirstNum(Double.parseDouble(mainBinding.inputNum.getText().toString()));

        switch (_sign) {
            case Const.DIVIDE_SIGN:
                // 演算子記号の保存
                item.setCalcSign(Const.DIVIDE_SIGN);
                mainBinding.standByNum.setText(calculation.convertNum(item.getFirstNum()) + " " + Const.DIVIDE_SIGN);
                break;
            case Const.MULTIPLY_SIGN:
                item.setCalcSign(Const.MULTIPLY_SIGN);
                mainBinding.standByNum.setText(calculation.convertNum(item.getFirstNum()) + " " + Const.MULTIPLY_SIGN);
                break;
            case Const.ADD_SIGN:
                item.setCalcSign(Const.ADD_SIGN);
                mainBinding.standByNum.setText(calculation.convertNum(item.getFirstNum()) + " " + Const.ADD_SIGN);
                break;
            case Const.SUBTRACT_SIGN:
                item.setCalcSign(Const.SUBTRACT_SIGN);
                mainBinding.standByNum.setText(calculation.convertNum(item.getFirstNum()) + " " + Const.SUBTRACT_SIGN);
                break;
        }

        mainBinding.inputNum.setText("");
    }

    // 初数字をエディタビュー設定
    private void displayFirstNum(int _num) {
        mainBinding.inputNum.setText(mainBinding.inputNum.getText().toString() + _num);
    }

    // ブランクチェック
    private boolean checkNull() {
        if (!calculation.checkNull(mainBinding.inputNum.getText().toString())) {
            Toast.makeText(this, getResources().getString(R.string.error_input_num), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
