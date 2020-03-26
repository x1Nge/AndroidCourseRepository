# Android开发课程实验报告
@author：065

- **实验二**：Android布局实验	 
 
-------------------
@[TOC](实验报告目录)
# 实验目的

初学移动应用公开发中的Android开发，实验二的主要内容为几个布局的使用，通过这一次实验，掌握基本的布局开发方式。
# 具体实验分析
实验第一步：阅读官方文档：[关于布局的官方文档](https://developer.android.google.cn/guide/topics/ui/declaring-layout.html)
为了查看时更好地区分，写了一个主界面用于跳转到其他三个子实验：
1. 创建三个新的activity，在这里我把它命名为Content_1 2 3
![p1](https://img-blog.csdnimg.cn/20200320202603259.png)
> **问题：** 在第一次创建的时候我直接创建三个java类，编译的时候就不通过，通过查找问题原因，发现是没有在AndroidManifest.xml中进行声明导致，添加声明即可，或者直接创建Activity，IDE会自动声明。
2. 我在主界面中写了一些个人信息和几个按钮，如图所示：
![p2](https://img-blog.csdnimg.cn/20200320203902845.png)
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
**Content_1.java:**

```java
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
```
接下来的模块将介绍几个子实验。
## 内容一：线性布局
![p3](https://img-blog.csdnimg.cn/20200320205336742.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
看到这个效果图第一反应就是如果只能用线性布局的话，就是一个竖直的布局嵌套四个水平的布局（很显然用约束布局会比线性布局更好实现），比较简单的一个子实验，这里贴一个效果图：
![p4](https://img-blog.csdnimg.cn/20200320210020549.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
## 内容二：约束布局
![p5](https://img-blog.csdnimg.cn/2020032021051733.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
> **问题：** 由于题目只给出了一个效果图，所以我只能目测来判断这几个色块的位置。

下面贴一小段实例代码，具体代码见GitHub内源文件：

```bash
<TextView
        android:id="@+id/orange"
        android:layout_width="90dp"
        android:layout_height="66dp"
        android:background="@android:color/holo_orange_light"
        android:gravity="center"
        android:text="ORANGE"
        app:layout_constraintLeft_toRightOf="@id/red"
        app:layout_constraintRight_toLeftOf="@id/yellow"
        app:layout_constraintTop_toTopOf="parent" />
```
效果图：
![p6](https://img-blog.csdnimg.cn/20200320211144306.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
## 内容三：表格布局
![p7](https://img-blog.csdnimg.cn/20200320211300709.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
也是比较简单的布局，效果图：
![p8](https://img-blog.csdnimg.cn/20200320211613379.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)

# 实验总结
- 第一次以.md形式写实验报告还不太熟练，不过好像和写博客的时候用的差不多
- 这一次实验整体比较简单，这学期刚开始接触移动应用开发，由浅入深，相信以后的实验会有更多值得写的内容。
- 同步更新至CSDN，仅作实验记录之用。