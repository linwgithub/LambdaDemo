package com.linw.lambdademo.ui.activity;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.linw.lambdademo.R;
import com.linw.lambdademo.ui.adapter.MainListViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MainListViewAdapter adapter;
    private ArrayList<String> lablelsStr = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.main_list);
        adapter = new MainListViewAdapter(this, lablelsStr);
        for (int i = 0; i < 8; i++) {
            lablelsStr.add("请输入数据");
        }
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            TextView label = (TextView) view.getTag();
            if (label != null) {
                showEditLableDialog(i);
            }
        });
    }

    private void showEditLableDialog(int selectLabel) {
        EditText editLabel = new EditText(this);
        new AlertDialog.Builder(this)
                .setView(editLabel)
                .setPositiveButton("确定", (d, i) -> {
                    lablelsStr.set(selectLabel, editLabel.getText().toString());
                    adapter.notifyDataSetChanged();
                    d.dismiss();
                })
                .setNegativeButton("取消", (d, i) -> {
                    d.dismiss();
                })
                .show();

    }
}
