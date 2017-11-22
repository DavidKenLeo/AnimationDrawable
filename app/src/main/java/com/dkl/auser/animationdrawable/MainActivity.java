package com.dkl.auser.animationdrawable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.imageView1);
        img.setOnTouchListener(imgListener);//觸控時監聽
    }

    private View.OnTouchListener imgListener = new View.OnTouchListener() {
        private float x, y;    // 原本圖片存在的X,Y軸位置
        private int mx, my; // 圖片被拖曳的X ,Y軸距離長度

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            // Log.e("View", v.toString());
            switch (event.getAction()) {          //判斷觸控的動作

                case MotionEvent.ACTION_DOWN:// 按下圖片時
                    x = event.getX();                  //觸控的X軸位置
                    y = event.getY();                  //觸控的Y軸位置

                case MotionEvent.ACTION_MOVE:// 移動圖片時

                    //getX()：是獲取當前控件(View)的座標

                    //getRawX()：是獲取相對顯示螢幕左上角的座標
                    mx = (int) (event.getRawX() - x);
                    my = (int) (event.getRawY() - y);
                    v.layout(mx, my, mx + v.getWidth(), my + v.getHeight());
                    if(mx>1000){

                    }
                    break;
            }
            Log.e("address", String.valueOf(mx) + "~~" + String.valueOf(my)); // 記錄目前位置
            return true;
        }
    };
}