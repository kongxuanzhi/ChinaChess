package com.xuanzhi.chinachess.chinachess.Model.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.xuanzhi.chinachess.chinachess.Model.Chesses.Horse;
import com.xuanzhi.chinachess.chinachess.R;

/**
 * Created by Android on 2016/4/4.
 */
public class ChessBoardLayout{
//    int mBorad[][];
//    public ChessBoardLayout(Context context,AttributeSet paramAttributeSet) {
//        super(context,paramAttributeSet);
//        mBorad = new int[10][9];
////        ImageView back = new ImageView(context);
////        back.setBackgroundResource(R.drawable.main);
////        back.setLayoutParams(
////                new ViewGroup.LayoutParams(
////                        ViewGroup.LayoutParams.MATCH_PARENT,
////                        ViewGroup.LayoutParams.WRAP_CONTENT));
//        //this.addView(back);
////        Horse  blackhorse = new Horse(R.drawable.blackhorse,"黑",new Point(0,1));
////        ChessView CV = new ChessView(context,blackhorse);
////        CV.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
////        this.addView(CV);
////        Horse blackhorse = new Horse(this,R.drawable.blackhorse,"黑");
////        //canvas.drawBitmap(blackhorse.getcPic(),blackhorse.getCurPoint().x,blackhorse.getCurPoint().y,null);
////        Button button = new Button(context);
////        this.addView(button);
////        Button butto2n = new Button(context);
////        this.addView(butto2n);
//    }
//    @Override
//    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//      //  super.onLayout(changed, left, top, right, bottom);
//        View v = getChildAt(0);
//        v.layout(10, 10, 60, 60);
//        View v2 = getChildAt(1);
//        v2.layout(30,40,60,60);
//     }
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        int width = Math.min(widthSize,heightSize);
//        //如果自定义View嵌套在ScollView等View里可能会不显示  widthMode == MeasureSpec.UNSPECIFIED
//        if(widthMode == MeasureSpec.UNSPECIFIED){
//            width = heightSize;
//        }else if(heightMode == MeasureSpec.UNSPECIFIED){
//            width = widthSize;
//        }
//        setMeasuredDimension(width, (int) (width * 9.0f / 8));
//    }
}
