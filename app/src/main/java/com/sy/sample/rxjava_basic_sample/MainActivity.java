package com.sy.sample.rxjava_basic_sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final TextView textView = (TextView) findViewById(R.id.text_view);
//
//        Observable.just(textView.getText().toString())          // 이벤트가 시작되는 부분
//                .map(s -> s + "test!")                          // 이벤트를 가공하고 조합 하여 결과를 만듬
//                .subscribe(text -> textView.setText(text));     // 가공한 결과를 출력


        EditText input = (EditText) findViewById(R.id.edit_input);
        EditText result = (EditText) findViewById(R.id.edit_result);
        Button btn_start = (Button) findViewById(R.id.btn_result);

        btn_start.setOnClickListener(v -> {
            int dan = Integer.parseInt(input.getText().toString());
            result.setText("");
            Observable.range(1, 9)
                    .map(row -> dan + " * " + row + " = " + (dan * row))
                    .map(row -> row + "\n")
                    .subscribe(result::append);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
