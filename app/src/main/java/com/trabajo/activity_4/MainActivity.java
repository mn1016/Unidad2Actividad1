package com.trabajo.activity_4;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private final static String TEXT_VIEW_KEY = "TEXT_VIEW_KEY";
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    tv.setText(LocalDateTime.now().toString());
                }
                else{
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy HH:mma");
                    String ans = formatter.format(date);
                    tv.setText(ans);
                }
            }
        });
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        tv = (TextView) findViewById(R.id.tv);
        tv.setText(savedInstanceState.getString(TEXT_VIEW_KEY));
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        tv = (TextView) findViewById(R.id.tv);
        outState.putString(TEXT_VIEW_KEY, tv.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
