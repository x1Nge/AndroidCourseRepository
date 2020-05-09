package com.x1nge.shiyan4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_1 = findViewById(R.id.btn_1);
        Button btn_2 = findViewById(R.id.btn_2);

        btn_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
//                Intent i = new Intent(MainActivity.this,t1_start.class);
//                startActivity(i);
                EditText et = findViewById(R.id.et_1);
                String n;
                n = et.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("url",n);
                Intent intent = new Intent(getBaseContext(),t1.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText et = findViewById(R.id.et_1);
                String n;
                n = et.getText().toString();
                Intent loadWeb = new Intent();
                loadWeb.setAction(Intent.ACTION_VIEW);
                loadWeb.setData(Uri.parse(n));
                startActivity(loadWeb);
            }
        });

    }
}
