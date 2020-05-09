package com.x1nge.shiyan4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class t1 extends AppCompatActivity {

    private demoWebView dw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t1);

        Button bk_1 = findViewById(R.id.bk_1);

        bk_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(t1.this,MainActivity.class);
                startActivity(i);
            }
        });

        dw = findViewById(R.id.dw_1);
        dw.getSettings().setJavaScriptEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String url = bundle.getString("url");
        dw.loadUrl(url);
    }

}