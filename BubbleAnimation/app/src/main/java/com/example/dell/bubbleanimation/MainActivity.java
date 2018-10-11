package com.example.dell.bubbleanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tvN1, tvN2, tvN3, tvN4, tvN5, tvN6, tvN7, tvN8, tvN9, tvN10;
    private int[] nums;
    private Button changeButton;
    private Button orderButton;
    private Button oneChangeButton;
    private MOrderView mOrderView;
    private Canvas canvas = new Canvas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setOnClickListener();
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        int window_height = wm.getDefaultDisplay().getHeight();
        int window_width = wm.getDefaultDisplay().getWidth();
        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width2 = outMetrics.widthPixels;
        int height2 = outMetrics.heightPixels;
        setWidth(width2);
        nums = new int[10];
        nums = getNewNums();
        setNums(nums);
        mOrderView.init(nums,width2);

    }

    private void setOnClickListener(){
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nums = getNewNums();
                setNums(nums);
                mOrderView.setNums(nums);
                mOrderView.invalidate();
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nums = allNumOrder(nums,10);
                setNums(nums);
                mOrderView.setNums(nums);
                mOrderView.invalidate();
            }
        });

        oneChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nums = oneChangeOrder(nums,10);
                setNums(nums);
            }
        });
    }

    private int[] oneChangeOrder(int[] nums,int n){
        int i,j,ifo,temp;
        for(i = 0; i < n;i++){
            ifo = 0;//每一轮的起点
            for(j = 0; j < n - 1; j++){
                if(nums[j]>nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    ifo++;
                    Toast.makeText(getApplicationContext(),"ordered!",Toast.LENGTH_SHORT).show();
                    mOrderView.setNums(nums);
                    mOrderView.invalidate();
                   // mOrderView.draw(nums);
                    return nums;
                }
            }
            if(ifo == 0){
                Toast.makeText(getApplicationContext(),"already ordered!",Toast.LENGTH_SHORT).show();
                return nums;
            }
        }
        return nums;
    }
    private int[] allNumOrder(int[] nums,int n){
        boolean isOrder = false;
        int temp = 0;//用于交换变量
        for(int i = 1; i < n; i++){
            isOrder = true;
            for(int j = 0; j < n; j++){
                if(nums[i] < nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    isOrder = false;
                }
            }
            if (isOrder){
                return nums;
            }
        }
        return nums;
    }

    private void setNums(int[] nums){
        tvN1.setText("" + nums[0]);
        tvN2.setText("" + nums[1]);
        tvN3.setText("" + nums[2]);
        tvN4.setText("" + nums[3]);
        tvN5.setText("" + nums[4]);
        tvN6.setText("" + nums[5]);
        tvN7.setText("" + nums[6]);
        tvN8.setText("" + nums[7]);
        tvN9.setText("" + nums[8]);
        tvN10.setText("" + nums[9]);
    }

    private int[] getNewNums(){
        int[] nums = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10 ; i++){
            nums[i] = random.nextInt(10);
            for (int j = 0; j < i; j++){//和前面的数依次比较一遍
               if (nums[i] == nums[j]&&j != i ) {
                   nums[i] = random.nextInt(10);
                   j = -1;
               }
            }
        }
        return nums;
    }

    private void setWidth(int width2){
        tvN1.setWidth(width2/10);
        tvN2.setWidth(width2/10);
        tvN3.setWidth(width2/10);
        tvN4.setWidth(width2/10);
        tvN5.setWidth(width2/10);
        tvN6.setWidth(width2/10);
        tvN7.setWidth(width2/10);
        tvN8.setWidth(width2/10);
        tvN9.setWidth(width2/10);
        tvN10.setWidth(width2/10);

    }

    private void findView(){
        mOrderView  = findViewById(R.id.orderView);      oneChangeButton = findViewById(R.id.oneOrderButton);
        orderButton = findViewById(R.id.orderButton);
        changeButton = findViewById(R.id.changeButton);
        tvN1 = findViewById(R.id.NumText1);
        tvN2 = findViewById(R.id.NumText2);
        tvN3 = findViewById(R.id.NumText3);
        tvN4 = findViewById(R.id.NumText4);
        tvN5 = findViewById(R.id.NumText5);
        tvN6 = findViewById(R.id.NumText6);
        tvN7 = findViewById(R.id.NumText7);
        tvN8 = findViewById(R.id.NumText8);
        tvN9 = findViewById(R.id.NumText9);
        tvN10 = findViewById(R.id.NumText10);
    }

}