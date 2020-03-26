package com.x1nge.shiyan1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Content_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_3);

        Button back_3 = findViewById(R.id.back_3);

        back_3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(Content_3.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

}
