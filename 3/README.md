# Android开发课程实验报告
@author：065

- **实验三**：Android布局实验	 
 
-------------------
@[TOC](实验报告目录)
# 实验目的

初学移动应用公开发中的Android开发，实验三的主要内容为UI组件的使用，通过这一次实验，掌握基本的UI组件使用方法。
# 具体实验分析
实验第一步：阅读官方文档：[关于菜单的官方文档](https://developer.android.google.cn/guide/topics/ui/menus.html)
为了查看时更好地区分，写了一个主界面用于跳转到其他四个子实验：
1. 创建四个新的activity，在这里我把它命名为t1 2 3 4
![p1](https://img-blog.csdnimg.cn/2020041812172963.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)

2. 我在主界面中写了一些个人信息和几个按钮，如图所示：
![p2](https://img-blog.csdnimg.cn/20200418121827296.png)
3. 设置按钮跳转事件（包含返回按钮的事件）：

**MainActivity.java:**
```java
Button btn_1 = findViewById(R.id.btn_1);    
btn_1.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
        Intent i = new Intent(MainActivity.this,Content_1.class);
        startActivity(i);
        }
});
```
**t1.java:**

```java
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_1);

        Button back_1 = findViewById(R.id.back_1);

        back_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(t1.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
```
接下来的模块将介绍几个子实验。
## 内容一：用SimpleAdapter和ListView的使用
![p3](https://img-blog.csdnimg.cn/20200418122001875.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
老师上课讲的例子和这个差不多，然后再去网上自学了toast的使用方式，还是可以很快完成的，但是这个图片大小不一，为了调整到更美观的状态，我将它们固定了大小。

ListView的布局：

```css
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".t1">

    <!-- 定义一个ListView -->
    <ListView
        android:id="@+id/lv_1"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toTopOf="@id/bk_1"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/bk_1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="返回"
        android:paddingRight="6dp"
        app:layout_constraintTop_toBottomOf="@id/lv_1"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintRight_toRightOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

每一项的布局：

```css
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <TextView
        android:id="@+id/name_1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:textSize="36dp"
        app:layout_constraintRight_toLeftOf="@id/name_1"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageView
        android:id="@+id/img_1"
        android:layout_width="66dp"
        android:layout_height="66dp"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintLeft_toRightOf="@id/name_1"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

适配器部分代码根据老是上课教授的方法，类似的写下来：

```java
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

```
效果图：
![p4](https://img-blog.csdnimg.cn/20200418122523543.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
## 内容二：AlertDialog的自定义布局实现
![p5](https://img-blog.csdnimg.cn/20200418122630649.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
> **问题：** 这一题我先学习了系统自带的AlertDialog的使用方法，然后学习了自定义布局的使用。

系统自带的样式：
```java
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
```

自定义布局，首先画一个自定义的样式：

```css
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <TextView
        android:id="@+id/tv_title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="ANDROID APP"
        android:textSize="36sp"
        android:textColor="@android:color/white"
        android:textStyle="bold"
        android:gravity="center"
        android:padding="6dp"
        android:background="@android:color/holo_orange_light"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"/>

    <EditText
        android:id="@+id/et_userName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:textSize="21sp"
        android:hint=" Username"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/tv_title" />

    <EditText
        android:id="@+id/et_password"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint=" Password"
        android:textSize="21sp"
        android:inputType="textPassword"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/et_userName" />

    <Button
        android:id="@+id/bt_1"
        android:layout_width="0dp"
        app:layout_constraintHorizontal_weight="1"
        android:text="取消"
        android:background="@android:color/white"
        android:textColor="#14BFB1"
        android:textSize="21sp"
        android:layout_height="wrap_content"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toLeftOf="@id/bt_confirm"
        app:layout_constraintTop_toBottomOf="@id/et_password" />

    <Button
        android:id="@+id/bt_confirm"
        android:layout_width="0dp"
        app:layout_constraintHorizontal_weight="1"
        android:text="登录"
        android:background="@android:color/white"
        android:textColor="#14BFB1"
        android:textSize="21sp"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@id/et_password"
        app:layout_constraintLeft_toRightOf="@id/bt_1"
        app:layout_constraintRight_toRightOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```
对样式进行微调，大概预览是这个样子：
![p6](https://img-blog.csdnimg.cn/20200418123105112.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
看起来也算比较像，接下来编写CustomDialog.java，设置弹窗的大小和位置并且为两个按钮设置点击事件，效果如图所示：
![p7](https://img-blog.csdnimg.cn/20200418123413266.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
![p8](https://img-blog.csdnimg.cn/20200418123451280.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
## 内容三：使用XML定义菜单
![p9](https://img-blog.csdnimg.cn/20200418123605954.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
这一个实验内容是菜单的基础用法，菜单可以在java代码中定义也可以使用xml来定义实现布局与代码的分离。
首先在res目录下新建menu文件夹，在里面创建我们用来写布局的xml文件
**t3_menu.xml:**

```css
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <item
        android:id="@+id/menu_1"
        android:title="字体大小">

        <menu xmlns:android="http://schemas.android.com/apk/res/android">

            <item
                android:id="@+id/menu_1_1"
                android:title="小" />

            <item
                android:id="@+id/menu_1_2"
                android:title="中" />

            <item
                android:id="@+id/menu_1_3"
                android:title="大" />

        </menu>
    </item>

    <item
        android:id="@+id/menu_2"
        android:title="普通菜单项" />

    <item
        android:id="@+id/menu_3"
        android:title="字体颜色">

        <menu xmlns:android="http://schemas.android.com/apk/res/android">

            <item
                android:id="@+id/menu_3_1"
                android:title="红色" />

            <item
                android:id="@+id/menu_3_2"
                android:title="黄色" />

        </menu>
    </item>

</menu>
```
这里添加了几个子菜单用来表示可选项。我在主页面放了一句测试文本和一个按钮，接下来就是编写逻辑代码：

```java
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
```
这里定义了点击每一个菜单所获得的效果。
效果图：
![p10](https://img-blog.csdnimg.cn/20200418124923130.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
![p11](https://img-blog.csdnimg.cn/20200418124257899.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
## 内容四：创建上下文操作模式的上下文菜单
![good](https://img-blog.csdnimg.cn/20200418125029918.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
菜单的布局：

```css
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/item_delete"
        android:icon="@android:drawable/ic_menu_delete"
        android:title="Delete"
        android:titleCondensed="Delete"
        app:showAsAction="ifRoom|withText">
    </item>
</menu>
```
ListView等代码见GitHub
效果图：
![p66](https://img-blog.csdnimg.cn/2020041812525189.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
# 实验总结
- 这学期刚开始接触移动应用开发，由浅入深，相信以后的实验会有更多值得写的内容，这一次的实验还是有很多内容值得自己去挖掘细节的知识点，我也是花了一些功夫去查找每一个组件的相关功能，以及怎么样去实现让它看起来更好。
- 同步更新至CSDN，仅作实验记录之用。
- 加油！
