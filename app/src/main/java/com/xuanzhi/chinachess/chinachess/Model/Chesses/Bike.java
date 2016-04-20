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
public class Bike  extends Chessman {
    public Bike(int picRescourceId, String sideColor, Point point) {
        super( picRescourceId, sideColor, point);
        setcName("車");
    }

    @Override
    protected List<Point> CalcNextSteps(ChessBoard checkBoard) {
        CanGoPoints.clear();
        Point point = getCurPoint();
        Map<Point, Chessman> mChessmanMap =   checkBoard.getmChessmanMap();
        Chessman chessman = mChessmanMap.get(point);
        for(int i = point.x-1; i >= 0; i--){
            Point roadPoint = new Point(i,point.y);
            if(!AddPoints(mChessmanMap,chessman,roadPoint)){
                break;
            }
        }
        for(int i = point.x+1; i < ChessBoard.ColCount; i++){
            Point roadPoint = new Point(i,point.y);
            if(!AddPoints(mChessmanMap,chessman,roadPoint)){
                break;
            }
        }
        for(int j = point.y-1; j >= 0; j--){
            Point roadPoint = new Point(point.x,j);
            if(!AddPoints(mChessmanMap,chessman,roadPoint)){
                break;
            }
        }
        for(int j=point.y+1;  j < ChessBoard.RowCount;  j++){
            Point roadPoint = new Point(point.x,j);
            if(!AddPoints(mChessmanMap,chessman,roadPoint)){
                break;
            }
        }
        return CanGoPoints;
    }

    public boolean AddPoints( Map<Point, Chessman> mChessmanMap,Chessman chessman, Point roadPoint){
        Chessman roadChessman = mChessmanMap.get(roadPoint);
        if(roadChessman != null) {
            if(!chessman.SameSide(roadChessman)){
                CanGoPoints.add(roadPoint);
            }
            return false;
        }
        CanGoPoints.add(roadPoint);
        return true;
    }
}
