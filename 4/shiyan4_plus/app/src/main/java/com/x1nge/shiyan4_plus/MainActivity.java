package com.x1nge.shiyan4_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private demoWebView dw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent getInfo = getIntent();

        Uri uri = getInfo.getData();
        URL url = null;

        try {
            url = new URL(uri.getScheme(), uri.getHost(),
                    uri.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        dw = findViewById(R.id.webView);
        dw.getSettings().setJavaScriptEnabled(true);

        dw.loadUrl(url.toString());

    }
}
