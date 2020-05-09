package com.x1nge.shiyan4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

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
