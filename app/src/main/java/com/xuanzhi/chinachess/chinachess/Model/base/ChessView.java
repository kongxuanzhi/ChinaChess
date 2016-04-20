package com.xuanzhi.chinachess.chinachess.Model.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Android on 2016/4/4.
 */
public class ChessView extends View {
    private ChessBoardView mChessBoardView;
    private Context mContext;

    public ChessView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
       // this.setBackgroundColor(Color.WHITE);
        mChessBoardView = new ChessBoardView(this);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int width = Math.min(widthSize,heightSize);
        //如果自定义View嵌套在ScollView等View里可能会不显示  widthMode == MeasureSpec.UNSPECIFIED
        if(widthMode == MeasureSpec.UNSPECIFIED){
            width = heightSize;
        }else if(heightMode == MeasureSpec.UNSPECIFIED){
            width = widthSize;
        }
        setMeasuredDimension(width, (int) (width * 9.0f / 8));
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mChessBoardView.setmWidth(w);
        mChessBoardView.setmHeight((int) (w * 9.0f / 8));
        // Toast.makeText(getContext(),mWidth+" "+mHeight,Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP){
            int x = (int)(event.getX());
            int y = (int)event.getY();
           // Toast.makeText(mContext,x+" "+ y,Toast.LENGTH_SHORT).show();
            Point p =  mChessBoardView.GetTouchAxiaPoint(x, y);
            String status = mChessBoardView.ClickAndRun(p);
            if(status != null){
                Toast.makeText(mContext,status,Toast.LENGTH_SHORT).show();
            }
            invalidate();
        }
        return true;
    }
    @Override
    protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            mChessBoardView.DrawBoard(canvas);
            mChessBoardView.DrawNextPoint(canvas);  //
            mChessBoardView.DrawPrePoint(canvas);
            mChessBoardView.DrawAllChessmanOnBoard(canvas);
    }
    public ChessBoardView getmChessBoardView() {
        return mChessBoardView;
    }
}
