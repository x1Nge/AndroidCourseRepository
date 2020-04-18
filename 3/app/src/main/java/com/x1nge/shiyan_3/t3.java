package com.x1nge.shiyan_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class t3 extends AppCompatActivity {

    private TextView tv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t3);

        tv_test = findViewById(R.id.tv_test);
        registerForContextMenu(tv_test);

        Button bk_t3 = findViewById(R.id.bk_t3);

        bk_t3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(t3.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.t3_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_1_1:
                tv_test.setTextSize(11);
                return true;
            case R.id.menu_1_2:
                tv_test.setTextSize(16);
                return true;
            case R.id.menu_1_3:
                tv_test.setTextSize(21);
                return true;
            case R.id.menu_2:
                Toast toast = Toast.makeText(t3.this,"点击了普通菜单项",Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.menu_3_1:
                tv_test.setTextColor(Color.RED);
                return true;
            case R.id.menu_3_2:
                tv_test.setTextColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
