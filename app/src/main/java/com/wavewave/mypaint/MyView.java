package com.wavewave.mypaint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * wavewave
 * paint学习
 */
public class MyView extends View {
    Paint mPaint;
    private Shader mShader;
    private Bitmap mBitmap;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();

//        mPaint.setColor(Color.RED);//设置画笔颜色
//        mPaint.setARGB(255, 138, 43, 226); // 设置 Paint对象颜色 0-255 参数1 透明度 255完全不透明
        mPaint.setAntiAlias(true);//是否抗锯齿
//        mPaint.setAlpha(127);//设置透明度
        mPaint.setStyle(Paint.Style.FILL);//FILL设置只绘制图形内容  STROKE设置只绘制图形的边 FILL_AND_STROKE设置都绘制
//        mPaint.setStrokeWidth(4);//设置描边宽度
//        mPaint.setStrokeCap(Paint.Cap.ROUND);//圆角效果
//        mPaint.setStrokeJoin(Paint.Join.BEVEL);//拐角风格

//        mPaint.setShader(new SweepGradient(250, 250, Color.BLUE, Color.RED)); //设置环形渲染器
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN)); //设置图层混合模式
//        mPaint.setColorFilter(new LightingColorFilter(0x00ffff, 0x000000)); //设置颜色过滤器
//        mPaint.setFilterBitmap(true); //设置双线性过滤
//        mPaint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));//设置画笔遮罩滤镜 ,传入度数和样式
//        mPaint.setTextScaleX(2);// 设置文本缩放倍数
//        mPaint.setTextSize(38);// 设置字体大小
//        mPaint.setTextAlign(Paint.Align.LEFT);//对其方式
//        mPaint.setUnderlineText(true);// 设置下划线
//
//        String str = "Android小菜鸡";
//        Rect rect = new Rect();
//        mPaint.getTextBounds(str, 0, str.length(), rect); //测量文本大小，将文本大小信息存放在rect中
//        mPaint.measureText(str); //获取文本的宽
//        mPaint.getFontMetrics(); //获取字体度量对象

        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 1.线性渲染,LinearGradient(float x0, float y0, float x1, float y1, @NonNull @ColorInt int colors[], @Nullable float positions[], @NonNull TileMode tile)
         * (x0,y0)：渐变起始点坐标
         * (x1,y1):渐变结束点坐标
         * color0:渐变开始点颜色,16进制的颜色表示，必须要带有透明度
         * color1:渐变结束颜色
         * colors:渐变数组
         * positions:位置数组，position的取值范围[0,1],作用是指定某个位置的颜色值，如果传null，渐变就线性变化。
         * tile:用于指定控件区域大于指定的渐变区域时，空白区域的颜色填充方法
         */
//        mShader = new LinearGradient(0, 0, 500, 500, new int[]{Color.RED, Color.BLUE, Color.WHITE}, new float[]{0.f, 0.5f, 1}, Shader.TileMode.REPEAT);

        /**
         * 环形渲染，RadialGradient(float centerX, float centerY, float radius, @ColorInt int colors[], @Nullable float stops[], TileMode tileMode)
         * centerX ,centerY：shader的中心坐标，开始渐变的坐标
         * radius:渐变的半径
         * centerColor,edgeColor:中心点渐变颜色，边界的渐变颜色
         * colors:渐变颜色数组
         * stoops:渐变位置数组，类似扫描渐变的positions数组，取值[0,1],中心点为0，半径到达位置为1.0f
         * tileMode:shader未覆盖以外的填充模式。
         */
//        mShader = new RadialGradient(250, 250, 250, new int[]{Color.parseColor("#C71585"), Color.parseColor("#1E90FF"), Color.parseColor("#FFD700"), Color.parseColor("#F08080")}, null, Shader.TileMode.CLAMP);


        /**
         * 扫描渲染，SweepGradient(float cx, float cy, @ColorInt int color0,int color1)
         * cx,cy 渐变中心坐标
         * color0,color1：渐变开始结束颜色
         * colors，positions：类似LinearGradient,用于多颜色渐变,positions为null时，根据颜色线性渐变
         */
//        mShader = new SweepGradient(250, 250, Color.parseColor("#FF69B4"), Color.parseColor("#A52A2A"));

        /**
         * 位图渲染，BitmapShader(@NonNull Bitmap bitmap, @NonNull TileMode tileX, @NonNull TileMode tileY)
         * Bitmap:构造shader使用的bitmap
         * tileX：X轴方向的TileMode
         * tileY:Y轴方向的TileMode
         REPEAT, 绘制区域超过渲染区域的部分，重复排版
         CLAMP， 绘制区域超过渲染区域的部分，会以最后一个像素拉伸排版
         MIRROR, 绘制区域超过渲染区域的部分，镜像翻转排版
         //         */
//        mShader = new BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);


        /**
         * 组合渲染，
         * ComposeShader(@NonNull Shader shaderA, @NonNull Shader shaderB, Xfermode mode)
         * ComposeShader(@NonNull Shader shaderA, @NonNull Shader shaderB, PorterDuff.Mode mode)
         * shaderA,shaderB:要混合的两种shader
         * Xfermode mode： 组合两种shader颜色的模式
         * PorterDuff.Mode mode: 组合两种shader颜色的模式
         */
        RadialGradient radialGradient = new RadialGradient(250, 250, 250, new int[]{Color.parseColor("#C71585"), Color.parseColor("#1E90FF"), Color.parseColor("#FFD700"), Color.parseColor("#F08080")}, null, Shader.TileMode.CLAMP);
        SweepGradient sweepGradient = new SweepGradient(250, 250, Color.parseColor("#FF69B4"), Color.parseColor("#A52A2A"));
        mShader = new ComposeShader(radialGradient, sweepGradient, PorterDuff.Mode.MULTIPLY);

        mPaint.setShader(mShader);
        //        canvas.drawRect(0, 0, 1000, 1000, mPaint);
        //参数1 2 圆心的坐标 参数3半径 4 画笔
        canvas.drawCircle(250, 250, 250, mPaint);

    }

}
