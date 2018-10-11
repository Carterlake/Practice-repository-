package com.example.dell.bubbleanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class MOrderView extends View {
    private int height =0,width=0;
    private Canvas canvas;
    private Paint paint ;
    private int[] nums;
    private Rect[] r10;

    public MOrderView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public void init(int[] nums,int width){

        this.height = getHeight();
        this.width = width;
        this.nums = new int[10];
        this.nums = nums;
        canvas = new Canvas();
        paint = new Paint();
        paint.setAntiAlias(true);                       //设置画笔为无锯齿
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth((float) 3.0);
        canvas.drawColor(Color.WHITE);


    }


    public void setNums(int[] nums){
        this.nums = nums;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        r10 =new Rect[10]; //Rect对象
        this.nums = nums;
         for (int i = 0; i < 10 ;i++){
            r10[i] = new Rect();
             r10[i].left = (int)(0.1*width*i);
             r10[i].right = (int)((i+1)*0.1*width);
             r10[i].top = (int) ((10-nums[i])*0.1*600);
             r10[i].bottom =600 ;
             if (i%2==0){
                 paint.setColor(Color.RED);
             }else {
                 paint.setColor(Color.BLACK);
             }
            canvas.drawRect(r10[i],paint);
        }

    }


    @Override
    public void invalidate() {
        super.invalidate();
    }

    public void draw(int[] nums){

        canvas = new Canvas();
        this.nums = nums;
        r10 =new Rect[10];
        for (int i = 0; i < 10 ;i++){
            r10[i] = new Rect();
            r10[i].left = (int)(0.1*width*i);
            r10[i].right = (int)((i+1)*0.1*width);
            r10[i].top = (int) ((10-nums[i])*0.1*600);
            r10[i].bottom =600 ;
            if (i%2==0){
                paint.setColor(Color.RED);
            }else {
                paint.setColor(Color.BLACK);
            }
            canvas.drawRect(r10[i],paint);
        }
        Toast.makeText(getContext(),"draw!",Toast.LENGTH_SHORT).show();
    }
}
