package com.x1nge.shiyan1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Content_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_2);

        Button back_2 = findViewById(R.id.back_2);

        back_2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(Content_2.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

}
