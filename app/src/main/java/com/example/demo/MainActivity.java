package com.example.demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox one, two;
    RadioButton rOne, rTwo, rThree, rFour, rFive;
    String checked;
    SeekBar seekBar;
    Button button;
    RadioGroup radioGroup, radioGroup3;
    TextView textView;
    int i,j,k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rOne = findViewById(R.id.radioButton3);
        rTwo = findViewById(R.id.radioButton4);
        rThree = findViewById(R.id.radioButton5);
        rFour = findViewById(R.id.radioButton8);
        rFive = findViewById(R.id.radioButton9);
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
                else{
                    i = 170;
                }
                textView.setText(String.valueOf(i+j+k));
            }
        });
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == rFour.getId()){
                    j = 100;
                }
                else{
                    j = 130;
                }
                textView.setText(String.valueOf(i+j+k));
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(one.isChecked()){
                    k = 125;
                }
                else{
                    k = 0;
                }
                textView.setText(String.valueOf(i+j+k));
            }
        });
        if(one.isChecked()){
            k = 125;
        }
        else{
            k = 0;
        }
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(MainActivity.this, String.valueOf(k), Toast.LENGTH_SHORT).show();
                textView.setText(String.valueOf(i+j+k+progress));
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
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("calories", i+j+k+seekBar.getProgress());
        outState.putInt("seek", seekBar.getProgress());
        outState.putBoolean("check", one.isChecked());
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        if(savedInstanceState!=null){
            seekBar.setProgress(savedInstanceState.getInt("seek"));
            k = savedInstanceState.getInt("checkbox");
            boolean check = savedInstanceState.getBoolean("check");
            if(check){
                one.setChecked(true);
                k = 125;
            }
            int total = savedInstanceState.getInt("calories") + k;
            textView.setText(String.valueOf(total));
        }
    }
}