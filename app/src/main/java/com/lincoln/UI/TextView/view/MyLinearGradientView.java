package com.lincoln.UI.TextView.view;

/**
 * Created by lincoln on 16/4/5.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;
public class MyLinearGradientView extends View {

    private LinearGradient linearGradientClamp,linearGradientMirror,linearGradientRepeat;

    public MyLinearGradientView(Context context) {
        super(context);
        /**
         * 第1，2个参数，代表渐变起点；
         * 第3，4个参数，代表渐变终点；
         * 第5个参数，代表渐变颜色；
         * 弟6个参数，每个颜色渐变位置，可以为空
         * 第七个参数平铺模式：CLAMP：复制最后一种颜色进行着色，MIRROR：以镜像方式须知渲染图，REPEAT：以平铺方式复制渲染图。
         */
        linearGradientClamp  =new LinearGradient(0,0,50,50,new int[]{Color.GRAY,Color.YELLOW},null, Shader.TileMode.CLAMP);
        linearGradientMirror  =new LinearGradient(0,0,50,50,new int[]{Color.GRAY,Color.YELLOW},null, Shader.TileMode.MIRROR);
        linearGradientRepeat  =new LinearGradient(0,0,50,50,new int[]{Color.GRAY,Color.YELLOW},null, Shader.TileMode.REPEAT);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(40);
        paint.setColor(Color.BLACK);

        //设置渐变方式
        paint.setShader(linearGradientClamp);
        canvas.drawRect(0, 0, 400, 400, paint);
        canvas.drawText("CLAMP", 0, 450, paint);

        //Mirror模式绘制
        paint.setShader(linearGradientMirror);
        canvas.drawRect(0, 450, 400, 850, paint);
        canvas.drawText("MIRROR", 0, 900, paint);
        //Repeat模式绘制
        paint.setShader(linearGradientRepeat);
        canvas.drawRect(0,900,400,1250,paint);
        canvas.drawText("REPEAT",0,1300,paint);

    }

}
