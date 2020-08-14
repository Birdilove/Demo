package com.example.demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox one, two;
    RadioButton rOne, rTwo, rThree, rFour, rFive;
    String checked;
    SeekBar seekBar;
    Button button;
    RadioGroup radioGroup, radioGroup3;
    TextView textView;
    int i,j,k, total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rOne = findViewById(R.id.radioButton3);
        rTwo = findViewById(R.id.radioButton4);
        rThree = findViewById(R.id.radioButton5);
        rFour = findViewById(R.id.radioButton9);
        rFive = findViewById(R.id.radioButton8);
        seekBar = findViewById(R.id.seekBar2);
        radioGroup = findViewById(R.id.radioGroup2);
        textView = findViewById(R.id.textView4);
        one = findViewById(R.id.checkBox3);
        radioGroup3 = findViewById(R.id.radioGroup3);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == rOne.getId()){
                    i = 120;
                }
                else if (checkedId == rTwo.getId()){
                    i = 190;
                }
                else if (checkedId == rThree.getId()){
                    i = 170;
                }
                else {
                    i = 0;
                }
                Calculate(i, j, k ,seekBar.getProgress());
            }
        });
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                j=0;
                if(checkedId == rFour.getId()){
                    j = 100;
                }
                else if(checkedId == rFive.getId()){
                    j = 130;
                }
                else {
                    j = 0;
                }
                Calculate(i, j, k ,seekBar.getProgress());
            }
        });
        one.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    k = 125;
                }
                else{
                    k = 0;
                }
                Calculate(i, j, k ,seekBar.getProgress());
            }
        });
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Calculate(i, j, k ,seekBar.getProgress());
                textView.setText(String.valueOf(i+j+k+seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("a", i);
        outState.putInt("b", j);
        outState.putInt("c", k);
        outState.putInt("seek", seekBar.getProgress());
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        assert savedInstanceState != null;
        super.onRestoreInstanceState(savedInstanceState);
        seekBar.setProgress(savedInstanceState.getInt("seek"));
        int l,m,n;
        l = savedInstanceState.getInt("a");
        m = savedInstanceState.getInt("b");
        n = savedInstanceState.getInt("c");
        Log.i("here", String.valueOf(k));
        Calculate(l,m,n,savedInstanceState.getInt("seek"));
    }
    public void Calculate(int a, int b, int c, int d){
        textView.setText(String.valueOf(a+b+c+d));
    }
}