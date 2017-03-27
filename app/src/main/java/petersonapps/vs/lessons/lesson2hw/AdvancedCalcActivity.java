package petersonapps.vs.lessons.lesson2hw;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by vs on 27.03.2017.
 */

public class AdvancedCalcActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    TextView expressionField;
    TextView resultField;

    Switch nightMode;
    Switch advancedCalc;

    double valueOne = Double.NaN;
    double valueTwo;

    String currentAction;
    private DecimalFormat decimalFormat;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advanced_calc);

        decimalFormat = new DecimalFormat("#.##########");

        expressionField = (TextView) findViewById(R.id.expressionField);
        resultField = (TextView) findViewById(R.id.resultField);

        nightMode = (Switch) findViewById(R.id.switchNightMode);

        advancedCalc  = (Switch) findViewById(R.id.switchadvancedCalc);
        advancedCalc.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        startActivity(getIntent().setClass(this, MainActivity.class));
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
}
