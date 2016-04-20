package com.xuanzhi.chinachess.chinachess.Model.base;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 2016/4/4.
 */
public abstract  class Chessman  {
     String cName;   //中文名
     String sideColor;  //红或黑
     int cPic;    //图片
     Point CurPoint;
     public List<Point> CanGoPoints;

     public  Chessman(int picRescourceId,String sideColor,Point point){
         this.sideColor=sideColor;
         this.CurPoint = point;
         this.cPic = picRescourceId;
         CanGoPoints = new ArrayList<>();
     }
    /**
     * 根据棋盘和下一步的落点判断是否可走
     * @param checkBoard  棋盘
     * @param NextStep  //下一步坐标
     * @return   可走true，不可走false
     */

     protected  boolean CanGo(ChessBoard checkBoard, Point NextStep){
         CalcNextSteps(checkBoard);
         if(CanGoPoints != null  && CanGoPoints.contains(NextStep)){
             return true;
         }
         return false;
     }
     protected abstract List<Point> CalcNextSteps(ChessBoard checkBoard);

     public boolean SameSide(Chessman B){
        return  this.getSideColor()==B.getSideColor();
    }

     public String getcName() {
        return cName;
    }
    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getSideColor() {
        return sideColor;
    }

    public Point getCurPoint() {
        return CurPoint;
    }
    public void setCurPoint(Point curPoint) {
        CurPoint = curPoint;
    }
    public int getcPic() {
        return cPic;
    }
    protected void MoveToNext(Point nextPoint){
        CurPoint = nextPoint;
    }
}
