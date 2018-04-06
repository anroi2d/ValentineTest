package com.lca.valentine.valentinetest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText edtYour;
    private EditText edtCrush;
    private Button btn;
    private Button btnTry;
    private TextView tvTime;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        getDayMonthYear();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String male = edtYour.getText().toString();
                String female = edtCrush.getText().toString();

                if (TextUtils.isEmpty(male) || TextUtils.isEmpty(female)) {
                    tvResult.setText("Please input name!");
                } else {
                    Pattern pattern = Pattern.compile("[a-zA-Z\\s]*");// \\[a-zA-Z0-9]
                    Matcher matcher = pattern.matcher(male);
                    Matcher matcher1 = pattern.matcher(female);
                    if (matcher.matches() && matcher1.matches()) {
                        getCharCount(male, female, 'l', 'o', 'v', 'e', 's');
                    } else {
                        tvResult.setText("Invalid name!");
                    }
                }

            }
        });
        btnTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("");
                edtYour.setText("");
                edtCrush.setText("");
                edtYour.setEnabled(true);
                edtCrush.setEnabled(true);
                btn.setEnabled(true);
                btnTry.setEnabled(false);
            }
        });

    }

    public void getCharCount(String m, String f, char l, char o, char v, char e, char s) {
        String test = m + "loves" + f;
        test = test.trim();
        test = test.toLowerCase();

        int deml = 0;int demo = 0;
        int demv = 0;int deme = 0;int dems = 0;

        for (int i = 0; i < test.length(); i++) {
            if (test.charAt(i) == l) {
                deml++;
            }
            if (test.charAt(i) == o) {
                demo++;
            }
            if (test.charAt(i) == v) {
                demv++;
            }
            if (test.charAt(i) == e) {
                deme++;
            }
            if (test.charAt(i) == s) {
                dems++;
            }

        }
        String str = deml + "" + demo + "" + demv + "" + deme + "" + dems;
        NumCharFive(str);

    }
    public void NumCharSix(String numcharf) {
        char a = numcharf.charAt(0);
        char b = numcharf.charAt(1);
        char c = numcharf.charAt(2);
        char d = numcharf.charAt(3);
        char e = numcharf.charAt(4);
        char f = numcharf.charAt(5);

        int num1 = Integer.parseInt(a + "") + Integer.parseInt(b + "");
        int num2 = Integer.parseInt(a + "") + Integer.parseInt(c + "");
        int num3 = Integer.parseInt(a + "") + Integer.parseInt(d + "");
        int num4 = Integer.parseInt(a + "") + Integer.parseInt(e + "");
        int num5 = Integer.parseInt(a + "") + Integer.parseInt(f + "");
        String num8 = num1+""+num2+""+num3+""+num4+""+num5;
        NumCharFive(num8);

    }


    public void NumCharFive(String numcharf) {
        char a = numcharf.charAt(0);
        char b = numcharf.charAt(1);
        char c = numcharf.charAt(2);
        char d = numcharf.charAt(3);
        char e = numcharf.charAt(4);

        int num1 = Integer.parseInt(a + "") + Integer.parseInt(b + "");
        int num2 = Integer.parseInt(a + "") + Integer.parseInt(c + "");
        int num3 = Integer.parseInt(a + "") + Integer.parseInt(d + "");
        int num4 = Integer.parseInt(a + "") + Integer.parseInt(e + "");
        String num5 = num1+""+num2+""+num3+""+num4+"";
        getNumCharFour(num5);

    }

    public void getNumCharFour(String numcharf) {
        char a = numcharf.charAt(0);
        char b = numcharf.charAt(1);
        char c = numcharf.charAt(2);
        char d = numcharf.charAt(3);

        int num1 = Integer.parseInt(a + "") + Integer.parseInt(b + "");
        int num2 = Integer.parseInt(a + "") + Integer.parseInt(c + "");
        int num3 = Integer.parseInt(a + "") + Integer.parseInt(d + "");
        String num6 = num1+""+num2+""+num3+"";
        if(num6.length()==3){
            getNumCharThree(num6);
        } else if(num6.length()==6){
            NumCharSix(num6);
        } else if(num6.length()==5){
            NumCharFive(num6);
        } else{
            getNumCharFour(num6);
        }

    }

    public void getNumCharThree(String numcharf) {
        char a = numcharf.charAt(0);
        char b = numcharf.charAt(1);
        char c = numcharf.charAt(2);

        int num1 = Integer.parseInt(a + "") + Integer.parseInt(b + "");
        int num2 = Integer.parseInt(a + "") + Integer.parseInt(c + "");
        String num7 = num1+""+num2+"";
        if(num7.length()==4){
            getNumCharFour(num7);
        }else if(num7.length()==3){
            getNumCharThree(num7);
        }else{
            btnTry.setEnabled(true);
            edtYour.setEnabled(false);
            edtCrush.setEnabled(false);
            tvResult.setText(num7+"%");
        }

    }


    public void initWidget() {
        edtYour = (EditText) findViewById(R.id.edtYour);
        edtCrush = (EditText) findViewById(R.id.edtCrush);
        btn = (Button) findViewById(R.id.btnTest);
        btnTry = (Button) findViewById(R.id.btnTry);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvResult = (TextView) findViewById(R.id.tv_Test);
    }

    public void getDayMonthYear() {
        //date amoment
        Date date = new Date();

        //12/04/2013
        String strDateFormat = "dd/MM/yyyy";
        //create object SimpleDateFormat;
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        //format
        tvTime.setText(sdf.format(date));
    }

}