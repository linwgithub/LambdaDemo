package com.linw.lambdademo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btn_insert);

        if (button != null) {
            button.setOnClickListener(v -> {
                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_LONG).show();
                Log.e("", "");
            });
        }


        Button button1 = (Button) findViewById(R.id.btn_click);
        if (button1 != null) {
            button1.setOnClickListener((b) -> {

            });
            button1.setOnClickListener(b -> showDialog());
        }

        new Thread(() -> {
            Log.e("threadLog", "run");
        }).start();
    }

    private void showDialog() {
        new AlertDialog.Builder(this)
                .setTitle("dialog")
                .setMessage("message")
                .setNegativeButton("取消", (d, w) -> d.dismiss())
                .setPositiveButton("确定", (d, w) -> {
                    d.dismiss();
                })
                .show();
    }

}
