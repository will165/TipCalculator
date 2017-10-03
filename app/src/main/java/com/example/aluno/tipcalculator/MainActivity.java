package com.example.aluno.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "tag" ;
    private EditText amountEditText;
    private SeekBar customTipSeekBar;
    private TextView percent15TextView;
    private TextView tip15TextView;
    private  TextView tipCustomTextView;
    private TextView total15TextView;
    private TextView totalCustomTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amountEditText = (EditText) findViewById(R.id.amountEditText);
        customTipSeekBar = (SeekBar) findViewById(R.id.customTipSeekBar);

        tip15TextView = (TextView) findViewById(R.id.tip15TextView);
        tipCustomTextView = (TextView) findViewById(R.id.tipCustomTextView);
        total15TextView = (TextView) findViewById(R.id.total15TextView);
        totalCustomTextView = (TextView) findViewById(R.id.totalCustomTextView);

        customTipSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Integer inte = progress;
                CalculaTip(inte.doubleValue());
                Log.d(TAG, "onProgressChanged: "+ progress);
            }
        });
    }

    public void CalculaTip(Double tipCustomPercent){
        Double tip15Percent = 15.00;
        Double valor = Double.parseDouble(amountEditText.getText().toString());
        Log.d(TAG, "CalculaTip:valor: "+tip15Percent);
        Double tip15 = valor * (tip15Percent/100);


        Double tipCustom = valor * (tipCustomPercent/100);

        Double tip15Total = valor + tip15;
        Double tipCustomTotal = valor + tipCustom;

        Log.d(TAG, "CalculaTip: "+tip15);
        tip15TextView.setText(tip15.toString());
        tipCustomTextView.setText(Double.toString(tipCustom));
        total15TextView.setText(Double.toString(tip15Total));
        totalCustomTextView.setText(Double.toString(tipCustomTotal));
    }
}
