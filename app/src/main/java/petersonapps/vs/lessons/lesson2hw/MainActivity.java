package petersonapps.vs.lessons.lesson2hw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView resultField;

    Button calculate;
    Button sign;
    Button point;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    Button zero, one, two, three, four, five, six, seven, eight, nine;

    Switch nightMode;
    Switch advancedCalc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultField = (TextView) findViewById(R.id.resultField);

        calculate = (Button) findViewById(R.id.buttonCalculate);
        sign = (Button) findViewById(R.id.buttonSign);
        point = (Button) findViewById(R.id.buttonPoint);
        plus = (Button) findViewById(R.id.buttonPlus);
        minus = (Button) findViewById(R.id.buttonMinus);
        multiply= (Button) findViewById(R.id.buttonMultiply);
        divide = (Button) findViewById(R.id.buttonDivide);
        zero = (Button) findViewById(R.id.button0);
        one = (Button) findViewById(R.id.button1);
        two = (Button) findViewById(R.id.button2);
        three = (Button) findViewById(R.id.button3);
        four = (Button) findViewById(R.id.button4);
        five = (Button) findViewById(R.id.button5);
        six = (Button) findViewById(R.id.button6);
        seven = (Button) findViewById(R.id.button7);
        eight = (Button) findViewById(R.id.button8);
        nine = (Button) findViewById(R.id.button9);

        nightMode = (Switch) findViewById(R.id.switchNightMode);
        advancedCalc  = (Switch) findViewById(R.id.switchadvancedCalc);



    }

    @Override
    public void onClick(View v) {

    }
}
