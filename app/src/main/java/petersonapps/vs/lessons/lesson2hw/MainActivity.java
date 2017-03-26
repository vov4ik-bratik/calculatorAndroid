package petersonapps.vs.lessons.lesson2hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView expressionField;
    TextView resultField;

    Button equals;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;

    Switch nightMode;
    Switch advancedCalc;

    double valueOne = Double.NaN;
    double valueTwo;

    String currentAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expressionField = (TextView) findViewById(R.id.expressionField);
        resultField = (TextView) findViewById(R.id.resultField);

        equals = (Button) findViewById(R.id.buttonCalculate);
        plus = (Button) findViewById(R.id.buttonPlus);
        minus = (Button) findViewById(R.id.buttonMinus);
        multiply= (Button) findViewById(R.id.buttonMultiply);
        divide = (Button) findViewById(R.id.buttonDivide);

        nightMode = (Switch) findViewById(R.id.switchNightMode);
        advancedCalc  = (Switch) findViewById(R.id.switchadvancedCalc);


    }

    public void onButtonDigitClick(View v){

        String digits = resultField.getText().toString();

        if(v.getContentDescription().equals(".") && digits.contains(".")){
            return;
        }

        if(digits.startsWith("0") && !(v.getContentDescription().equals(".")) && !(digits.contains("."))){
            resultField.setText(v.getContentDescription());
            return;
        }

        resultField.setText(resultField.getText().toString() + v.getContentDescription());
    }

    public void onClearClick(View view) {

        if(resultField.length() > 0){
            resultField.setText(resultField.getText().subSequence(0, resultField.length() - 1));
        }
        else {
            valueOne = Double.NaN;
            valueTwo = Double.NaN;
            resultField.setText("");
            expressionField.setText("");
        }

    }

    public void onEqualsClick(View view) {
        calculation();
        expressionField.setText(expressionField.getText().toString() + valueTwo + " = " + valueOne);
        valueOne = Double.NaN;
        currentAction = "0";
    }

    @Override
    public void onClick(View v) {
        calculation();
        currentAction = v.getContentDescription().toString();

        expressionField.setText(valueOne + v.getContentDescription().toString());
        resultField.setText(null);
    }

    private void calculation() {

        if(!Double.isNaN(valueOne)){
            valueTwo = Double.parseDouble(resultField.getText().toString());
            resultField.setText(null);
            valueOne = calculate(valueOne, valueTwo);
        }
        else{
            try{
                valueOne = Double.parseDouble(resultField.getText().toString());
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private double calculate(double valueOne, double valueTwo) {

        switch (currentAction){
            case "+":
                return valueOne += valueTwo;

            case "-":
                return valueOne -= valueTwo;

            case "*":
                return valueOne *= valueTwo;

            case "/":
                return valueOne /= valueTwo;

            default:
                return Double.NaN;
        }
    }



}
