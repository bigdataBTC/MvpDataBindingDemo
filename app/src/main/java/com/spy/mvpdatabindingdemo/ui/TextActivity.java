package com.xinmang.mvpdatabindingdemo.ui;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xinmang.mvpdatabindingdemo.R;

public class TextActivity extends AppCompatActivity {
    private TextView login;
    private String success="success";
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(success.equals("fail")){
                login.setText("登录失败");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        login= (TextView) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.setText("登录中...");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        success="fail";
                        handler.sendEmptyMessage(0);
                    }
                },1000);
            }
        });
    }
}
