package petersonapps.vs.lessons.lesson2hw;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;

import android.app.UiModeManager;
import android.widget.Toast;
import static petersonapps.vs.lessons.lesson2hw.Calculation.calculate;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    TextView expressionField;
    TextView resultField;

    Switch nightMode;
    Switch advancedCalc;

    double valueOne = Double.NaN;
    double valueTwo;

    String currentAction;
    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");

        expressionField = (TextView) findViewById(R.id.expressionField);
        resultField = (TextView) findViewById(R.id.resultField);

        nightMode = (Switch) findViewById(R.id.switchNightMode);

        advancedCalc  = (Switch) findViewById(R.id.switchadvancedCalc);
        advancedCalc.setOnCheckedChangeListener(this);
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
        expressionField.setText(expressionField.getText().toString() + decimalFormat.format(valueTwo)
                + " = " + decimalFormat.format(valueOne));
        valueOne = Double.NaN;
        currentAction = "0";
    }

    @Override
    public void onClick(View v) {
            calculation();
            currentAction = v.getContentDescription().toString();
            expressionField.setText(decimalFormat.format(valueOne) + currentAction);
            resultField.setText(null);
    }

    private void calculation() {

        if(resultField.getText().length() == 0){
            return;
        }

        if(!Double.isNaN(valueOne)){
            valueTwo = Double.parseDouble(resultField.getText().toString());
            resultField.setText(null);
            valueOne = calculate(currentAction, valueOne, valueTwo);
        }
        else{
            try{
                valueOne = Double.parseDouble(resultField.getText().toString());
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Intent intend = new Intent(this, AdvancedCalcActivity.class);
        startActivity(intend);
        finish();
    }

    public void NightModeOn(View view) {
        UiModeManager uiManager = (UiModeManager) getSystemService(Context.UI_MODE_SERVICE);
        uiManager.setNightMode(UiModeManager.MODE_NIGHT_YES);
    }

    public void NightModeOff(View view) {
        UiModeManager uiManager = (UiModeManager) getSystemService(Context.UI_MODE_SERVICE);
        uiManager.setNightMode(UiModeManager.MODE_NIGHT_NO);
    }

    private void showToastMessage(int messageId) {
        Toast toastMessage = Toast.makeText(this, messageId, Toast.LENGTH_LONG);
        toastMessage.setGravity(Gravity.CENTER, 0, 0);
        toastMessage.show();
    }
}
