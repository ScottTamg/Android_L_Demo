package com.example.xwtang.android_l_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;

public class MainActivity extends Activity {

    private TextView first_txt;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
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

    private void init() {
        first_txt = (TextView)findViewById(R.id.first_txt);
        first_txt.setText("Test_FirstTxt. Hello World");
        final boolean[] flag = {true};
        first_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag[0]) {
                    first_txt.setTranslationX(50f);
                    first_txt.setTranslationY(50f);
                    first_txt.setElevation(50f);
                    flag[0] = false;
                } else {
                    first_txt.setTranslationX(0f);
                    first_txt.setTranslationY(0f);
                    first_txt.setElevation(0f);
                    flag[0] = true;
                }
            }
        });

        button = (Button)findViewById(R.id.id_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        volleyGet();
    }

    private void volleyGet() {
        String url = "www.baidu.com";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
