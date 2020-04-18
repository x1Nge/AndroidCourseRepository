package com.x1nge.shiyan_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class t1 extends AppCompatActivity {

    private String[] names = new String[]
            {"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] imgIds = new int[]
            {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};

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

        // 创建一个List集合，元素为Map类型
        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for (int i = 0;i < names.length;i++){
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("img_1",imgIds[i]);
            listItem.put("name_1",names[i]);
            listItems.add(listItem);
        }

        // 创建simpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,
                R.layout.simple_adapter_content,
                new String[] {"name_1","img_1"},
                new int[] {R.id.name_1,R.id.img_1});
        ListView list = findViewById(R.id.lv_1);

        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);

        // 为ListView的列表项的单击事件绑定事件监听器
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(t1.this,names[position],Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}
