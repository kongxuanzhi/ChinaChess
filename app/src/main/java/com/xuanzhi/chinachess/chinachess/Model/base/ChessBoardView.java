package com.xuanzhi.chinachess.chinachess.Model.base;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;

/**
 * Created by Android on 2016/4/4.
 */
//向ViewGroup中添加子View
public class ChessBoardView {
        View mView;
        private Paint mPaint;     //画棋盘用

        private int mHeight;  //宽度
        private int mWidth;  //高度
        private float rowline;  //行距
        private  float colline;  //列距

        public ChessBoard getmChessBoard() {
            return mChessBoard;
        }

        ChessBoard mChessBoard;
        public ChessBoardView(View view){
            mView = view;
            InitPaint();
            mChessBoard = new ChessBoard();
        }

        private void InitPaint() {
            mPaint = new Paint();
            mPaint.setColor(Color.BLACK);
            mPaint.setStrokeWidth(3);   //设置线的粗细
            mPaint.setDither(true);    //设置是否有锯齿，使线条更平滑
            mPaint.setStyle(Paint.Style.FILL);   //填充
         }
    /**
     * 画棋盘
     * @param canvas
     */
    public void DrawBoard(Canvas canvas) {
        //画10行
        int startx, endx, starty, endy;
        for (int i = 1; i <= mChessBoard.RowCount; i++) {
            startx = (int) (colline);
            endx = (int) (mChessBoard.ColCount * colline);
            starty = (int) (rowline * i);
            endy = starty;
            canvas.drawLine(startx, starty, endx, endy, mPaint);
        }
        //画9列
        for (int j = 1; j <=mChessBoard.ColCount; j++) {
            startx = (int) (colline * j);
            endx = startx;
            int endl = 5;
            if (j == 1 || j == mChessBoard.ColCount) {
                endl = 10;
            }
            starty = (int) (rowline);
            endy = (int) (endl * rowline);
            canvas.drawLine(startx, starty, endx, endy, mPaint);
        }
        for (int j = 1; j <=mChessBoard.ColCount; j++) {
            startx = (int) (colline * j);
            endx = startx;
            starty = (int) (rowline * 6);
            endy = (int) (mChessBoard.RowCount * rowline);
            canvas.drawLine(startx, starty, endx, endy, mPaint);
        }
        //画士的四条线
        canvas.drawLine(colline * 4, rowline, colline * 6, rowline * 3, mPaint);
        canvas.drawLine(colline * 4, rowline * 3, colline * 6, rowline, mPaint);
        canvas.drawLine(colline * 4, rowline * 8, colline * 6, rowline * 10, mPaint);
        canvas.drawLine(colline * 4, rowline * 10, colline * 6, rowline * 8, mPaint);
    }
    /**
     * 利用多态画所有的棋子
     * @param canvas
     */
    public void DrawAllChessmanOnBoard(Canvas canvas){
        float percent = 7.0f/6.0f;
        for (Chessman chessman :mChessBoard.mChessmanMap.values()){
            Bitmap chessPic = BitmapFactory.decodeResource(mView.getResources(),chessman.getcPic());
            Bitmap bitmap = Bitmap.createScaledBitmap(chessPic, (int) (colline * percent), (int) (rowline * percent), false);  //缩放图片
            canvas.drawBitmap(bitmap, chessman.getCurPoint().x * colline + colline / 2, chessman.getCurPoint().y * rowline + rowline / 2, null);  //绘制图片
        }
    }

    /**
     * 根据屏幕的触点，得到整数坐标值
     * @param x
     * @param y
     * @return
     */
    public Point GetTouchAxiaPoint(int x, int y) {
        Point point = new Point((int)( (x-rowline/2)/rowline), (int)((y-colline/2)/colline));
        return point;
    }
        public  String ClickAndRun(Point point){
            return   mChessBoard.ClickAndRun(point);
        }

        public void DrawNextPoint(Canvas canvas) {
            if(mChessBoard.CanGoPoints != null){
                for(int i=0;i<mChessBoard.CanGoPoints.size();i++){
                    Point p = mChessBoard.CanGoPoints.get(i);
                    canvas.drawCircle(colline*(p.x+1), rowline*(p.y+1), 10,mPaint);
                }
            }
            //设置棋子为选中状态
            Paint paint2 = new Paint();
            paint2.setColor(Color.GREEN);
            paint2.setStyle(Paint.Style.FILL);
            if(!mChessBoard.IsFirstClick()){
                canvas.drawCircle(colline * (mChessBoard.getmCurClickPoint().x + 1)+8, rowline * (mChessBoard.getmCurClickPoint().y + 1)+8, colline / 2, paint2);
            }
        }
        /**
         * 标记刚走过的位置
         * @param canvas
         */
        public void DrawPrePoint(Canvas canvas) {
            Paint paint2 = new Paint();
            paint2.setColor(Color.GREEN);
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            Point prePoint  = mChessBoard.getmPreClickPoint();
            if(prePoint!=null){
                canvas.drawCircle(colline*(prePoint.x+1),  rowline*(prePoint.y+1), 10, paint2);
            }
        }

        public void setmWidth(int mWidth) {
            this.mWidth = mWidth;
            this.colline = (float) mWidth / (mChessBoard.ColCount+1.0f);    //72
        }
        public void setmHeight(int mHeight) {
            this.mHeight = mHeight;
            this.rowline = (float) mHeight / (mChessBoard.RowCount+1.0f);  //73
        }
}
