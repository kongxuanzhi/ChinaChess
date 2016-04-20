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
public class Soldier extends Chessman {
    boolean GoRiver = false;
    int mStart,mEnd;
    public Soldier( int picRescourceId, String sideColor, Point point) {
        super( picRescourceId, sideColor, point);
        if (sideColor.equals("黑")){
            setcName("卒");
         }
        else{
            setcName("兵");
        }
    }

    @Override
    protected List<Point> CalcNextSteps(ChessBoard checkBoard) {
        CanGoPoints.clear();
        Map<Point, Chessman> mChessmanMap =   checkBoard.getmChessmanMap();
        Point point = getCurPoint();
        int oneStep = 1;
        if(getSideColor().equals("黑")){
            GoRiver = (point.y <5);
            mStart = 1;mEnd = 3;
            oneStep = 1;
        }else {
            GoRiver = (point.y >4);
            mStart = 0;mEnd = 2;
            oneStep = -1;
        }
        Chessman chessman = mChessmanMap.get(point);
        int dir[][] = {{0,-1},{1,0},{-1,0},{0,1}};
            if(GoRiver){
                Point endP = new Point(point.x, point.y + oneStep);
                Chessman AimPoint = mChessmanMap.get(endP);
                if(AimPoint == null || !chessman.SameSide(AimPoint)){
                    CanGoPoints.add(endP);
                }
            }else{
                for (int i = mStart; i <= mEnd; i++) {
                    int x = point.x + dir[i][0];
                    int y = point.y + dir[i][1];
                    if(x>=0 && x< ChessBoard.ColCount && y>=0 && y< ChessBoard.RowCount){
                        Point endP = new Point(x,y);
                        Chessman AimPoint = mChessmanMap.get(endP);
                        if(AimPoint == null || !chessman.SameSide(AimPoint)){
                            CanGoPoints.add(endP);
                        }
                    }
                }
            }
        return CanGoPoints;
    }
}
