package com.lincoln.UI.TextView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.lincoln.UI.R;
import com.lincoln.UI.util.LogUtil;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class TextViewActivity extends AppCompatActivity {
    //    private String descString = "<font size='10' color='#778797'><strong>体验计划说明:</strong></font> <br><font color='#8795a4'>1. 请下载步骤下载安装XXX；<br> 2. 首次参加后，立即获得</font><font color='red' ><big>10</big></font> <font  color='#8795a4'>元现金奖励； ";
    private String desc1 = "<head><title>体验计划Header</title></head> <br>"
            .concat("<strong>体验计划粗体</strong> <br>")
            .concat("<em>体验计划斜体</em> <br> ")
            .concat("<font size='10' color='#778797'><strong>体验计划字体加粗，设置颜色:</strong></font>  <br>")
            .concat("<big>体验计划<font color='red'>大号字</font></big> |  <small>小号字</small>  <br>")
            .concat("<a href='http://www.baidu.com'>体验计划 Http格式</href>  | 空一行 <br/>")
            .concat("<img src='http://7oti5i.com1.z0.glb.clouddn.com/bagua.jpg'>图片</img>");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        initViews();
    }

    private void initViews() {

        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
        TextView tv = (TextView) findViewById(R.id.tv1);
//        tv.setText(Html.fromHtml(desc1, new ImageDownloadGetter(this, tv), null));
//        tv.setText(Html.fromHtml(desc1, new Html.ImageGetter() {
//            @Override
//            public Drawable getDrawable(String source) {
//                Drawable drawable = null;
//                URL url;
//                try {
//                    url = new URL(source);
//                    drawable = Drawable.createFromStream(url.openStream(), "");  //获取网路图片
//                } catch (Exception e) {
//                    return null;
//                }
//                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable
//                        .getIntrinsicHeight());
//                return drawable;
//            }
//        },null));
        tv.setText(Html.fromHtml(desc1, new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                Drawable drawable = getResources().getDrawable(R.drawable.ic_menu_camera);
                drawable.setBounds(0, 0, 100, 100);
                return drawable;
            }
        }, null));
    }

    //异步线程加载图片
    private class ImageDownloadGetter implements Html.ImageGetter {
        Context context;
        TextView textView;

        public ImageDownloadGetter(Context context, TextView view) {
            this.textView = view;
            this.context = context;
        }


        @Override
        public Drawable getDrawable(String source) {
            BitmapDrawable drawable = new BitmapDrawable();
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            if (drawable != null){
                LogUtil.d("getDrawable is not null");
            }

            return drawable;
        }

        //下载图片
        private Drawable download(final String source) {
            final HtmlBitmap htmlBitmap = new HtmlBitmap();
            ImageLoader.getInstance().loadImage(source, new ImageLoadingListener() {
                        @Override
                        public void onLoadingStarted(String s, View view) {

                        }

                        @Override
                        public void onLoadingFailed(String s, View view, FailReason failReason) {

                        }

                        @Override
                        public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                            LogUtil.d("image downloaded success ");
                            if (bitmap != null){
                                LogUtil.d("bitmap is not null:"+bitmap.getByteCount());
                            }
                            htmlBitmap.bitmap = bitmap;

                            textView.invalidate();
                            textView.setText(textView.getText());
                        }

                        @Override
                        public void onLoadingCancelled(String s, View view) {

                        }
                    }
            );

            return htmlBitmap;
        }

        //封装Bitmap对象
        private class HtmlBitmap extends BitmapDrawable {
            public Bitmap bitmap;

            @Override
            public void draw(Canvas canvas) {
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, 0, 0, getPaint());
                }
            }
        }

    }


}
