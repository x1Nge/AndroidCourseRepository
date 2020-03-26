package com.x1nge.shiyan1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Content_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_1);

        Button back_1 = findViewById(R.id.back_1);

        back_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(Content_1.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

}
