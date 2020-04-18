package com.x1nge.shiyan_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class t2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t2);

        Button bk_1 = findViewById(R.id.bk_1);
        Button bk_2 = findViewById(R.id.btn_show);

        bk_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(t2.this,MainActivity.class);
                startActivity(i);
            }
        });

        bk_2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
//                LayoutInflater inflater = getLayoutInflater();
//                View view = inflater.inflate(R.layout.t2_content, null);
//                AlertDialog.Builder builder = new AlertDialog.Builder(t2.this);
//                builder.setView(view);

//                builder.setPositiveButton("登录", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(t2.this, "登录按钮测试",Toast.LENGTH_SHORT).show();
//                    }
//                });
//                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(t2.this,"取消按钮测试",Toast.LENGTH_SHORT).show();
//                    }
//                });

//                builder.show();
                CustomDialog customDialog = new CustomDialog(t2.this);
                customDialog.setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
                        Toast.makeText(t2.this, "取消成功！",Toast.LENGTH_SHORT).show();
                    }
                });
                customDialog.setConfirm("登录", new CustomDialog.IOnConfirmListener(){
                    @Override
                    public void onConfirm(CustomDialog dialog) {
                        Toast.makeText(t2.this, "登录成功！",Toast.LENGTH_SHORT).show();
                    }
                });
                customDialog.show();

            }
        });
    }


}
