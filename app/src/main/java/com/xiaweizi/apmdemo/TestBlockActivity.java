package com.xiaweizi.apmdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TestBlockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_block);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_test_block);
    }
}
