package com.xuanzhi.chinachess.chinachess.Model.Chesses;

import android.graphics.Point;

import com.xuanzhi.chinachess.chinachess.Model.base.ChessBoard;
import com.xuanzhi.chinachess.chinachess.Model.base.ChessBoardView;
import com.xuanzhi.chinachess.chinachess.Model.base.Chessman;

import java.util.List;
import java.util.Map;

/**
 * Created by Android on 2016/4/7.
 */
public class BigGun extends Chessman {
    int Num = 0;
    public BigGun(int picRescourceId, String sideColor, Point point) {
        super(picRescourceId, sideColor, point);
        setcName("炮");
    }

    @Override
    protected List<Point> CalcNextSteps(ChessBoard checkBoard) {
        CanGoPoints.clear();
        Point point = getCurPoint();
        Map<Point, Chessman> mChessmanMap =   checkBoard.getmChessmanMap();
        Chessman chessman = mChessmanMap.get(point);

        Num=0;
        for(int i=point.x-1;i>=0;i--){
            Point roadPoint = new Point(i, point.y);
            if(!AddPoints(mChessmanMap,chessman,roadPoint)){
                break;
            }
        }
        Num=0;
        for(int i=point.x+1;i< ChessBoard.ColCount;i++){
            Point roadPoint = new Point(i, point.y);
            if(!AddPoints(mChessmanMap,chessman,roadPoint)){
                break;
            }
        }
        Num=0;
        for(int j=point.y-1;j>=0;j--){
            Point roadPoint = new Point(point.x , j);
            if(!AddPoints(mChessmanMap,chessman,roadPoint)){
                break;
            }
        }
        Num=0;
        for(int j=point.y+1;j< ChessBoard.RowCount;j++){
            Point roadPoint = new Point(point.x , j);
            if(!AddPoints(mChessmanMap,chessman,roadPoint)){
                break;
            }
        }
        return CanGoPoints;
    }

    public boolean AddPoints( Map<Point, Chessman> mChessmanMap,Chessman chessman, Point roadPoint){
        Chessman roadChessman = mChessmanMap.get(roadPoint);
        if(Num==0){
            if(roadChessman==null){
                CanGoPoints.add(roadPoint);
            }else{
                Num=1;
            }
        }else if(Num==1){
            if(roadChessman!=null){
                if(!chessman.SameSide(roadChessman)){
                    CanGoPoints.add(roadPoint);
                }
                Num = 0;
                return  false;
            }
        }
        return true;
    }
}
