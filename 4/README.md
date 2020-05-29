# Android开发课程实验报告
@author：065

- **实验四**：intent	 
 
-------------------
@[TOC](实验报告目录)
# 实验目的

初学移动应用公开发中的Android开发，实验四的主要内容为intent的使用，通过这一次实验，掌握基本的intent使用方法。
# 具体实验分析
实验第一步：阅读官方文档：[intent](https://developer.android.google.cn/guide/components/intents-filters)
实验解析：本次实验共分为两个部分。第一个部分是完成一个获取URL地址并启动隐式intent的调用的内容，另一个部分就是自己编写一个自定义WebView，然后选择用这个自定义的WebView来加载网页。
![1](https://img-blog.csdnimg.cn/20200509220520847.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)

## 内容一：获取URL地址并启动隐式intent的调用
简单来说这部分的内容就是访问用户输入在EditView上的网址（采用隐式intent调用）
这部分还是比较简单的，上逻辑代码：

```java
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
```
输入网址后调用系统自带的浏览器访问：
![2](https://img-blog.csdnimg.cn/20200509221054313.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)

## 内容二：编写一个自定义WebView供用户选择
这一部分的内容，我们首先要自定义一个WebView，然后再运行上一部分我们完成的应用来选择这里写好的自定义WebView打开指定网址。
**为了更加方便地进行测试，我直接在上一个应用里增加了一个按钮用来测试自定义WebView的一些属性或者方法是否编写正确，如图：**
![3](https://img-blog.csdnimg.cn/20200509221459313.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
下面介绍自定义WebView的写法（这里参考了一些网上增加进度条的资料，由于查阅资料很多，所以具体搞不清楚来自哪里）：

```java
public class demoWebView extends WebView {

    public demoWebView(Context context, AttributeSet attrs) {
        super(context,attrs);

        // 创建进度条
        ProgressBar pb = new ProgressBar(context,null,android.R.attr.progressBarStyleHorizontal);

        // 设置位置参数
        pb.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,3));
        addView(pb);

        //设置内部加载器
        setWebChromeClient(new MyWebChromeClient(context,pb));
        setWebViewClient(new MyWebViewClient());
    }

    public class MyWebChromeClient extends WebChromeClient {

        private Context context;
        private ProgressBar progressBar;


        public MyWebChromeClient(Context context, ProgressBar progressBar){
            this.context = context;
            this.progressBar = progressBar;
        }


        //监听进度的回调
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if(newProgress == 100){
                progressBar.setVisibility(View.GONE);
            }else{

                if(progressBar.getVisibility() == View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
                }
            }
            super.onProgressChanged(view, newProgress);
        }
    }

    public class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }
}

```

> **注意：** 自定义WebView记得改intent-filter。

```bash
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
                <data android:scheme="http" />
            </intent-filter>
```

接着编写主要的逻辑代码：

```java
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
```
代码解析如下：
首先我们通过intent从上一个Activity获取需要访问的地址，将它转换成url，再通过编写好的代码访问。
效果图：
![4](https://img-blog.csdnimg.cn/20200509222331437.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
![5](https://img-blog.csdnimg.cn/20200509222349334.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
![6](https://img-blog.csdnimg.cn/20200509222445293.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3gxTmdl,size_16,color_FFFFFF,t_70)
# 实验总结
- 这学期刚开始接触移动应用开发，由浅入深，相信以后的实验会有更多值得写的内容，这一次的实验还是有很多内容值得自己去挖掘细节的知识点，通过查阅网上的资料以及老师上课的PPT，还是可以很容易地掌握这一节的内容。
- 同步更新至CSDN，仅作实验记录之用。
- 加油！
