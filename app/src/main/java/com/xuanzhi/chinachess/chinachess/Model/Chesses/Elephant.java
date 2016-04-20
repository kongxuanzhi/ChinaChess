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
public class Elephant extends Chessman {
    int mStartE ;
    int mEndE;
    public Elephant( int picRescourceId, String sideColor, Point point) {
        super( picRescourceId, sideColor, point);
        if (sideColor.equals("黑")){
            setcName("象");
            mStartE = 0;mEndE = 4;
        }
        else{
            setcName("相");
            mStartE = 5; mEndE = 9;
        }
    }

    @Override
    protected List<Point> CalcNextSteps(ChessBoard checkBoard) {
        CanGoPoints.clear();
        Map<Point, Chessman> mChessmanMap =   checkBoard.getmChessmanMap();
        Point point = getCurPoint();
        Chessman chessman = mChessmanMap.get(point);
        int  dir[][] = {{-2,-2},{2,-2},{2,2},{-2,2}};
        int foot[][] = {{-1,-1},{1,-1},{1,1},{-1,1}};
        for(int i=0;i<4;i++){
            int x = point.x + dir[i][0];
            int y = point.y + dir[i][1];
            if(x>=0&&x< ChessBoard.ColCount&&y>=mStartE&&y<=mEndE){  //在界内
                int fx = point.x+foot[i][0];
                int fy = point.y+foot[i][1];
                Chessman footChess = mChessmanMap.get(new Point(fx,fy));
                if(footChess == null){   //没有拌腿
                    Point endP = new Point(x,y);
                    Chessman AimPoint = mChessmanMap.get(endP);
                    if(AimPoint == null  || !AimPoint.SameSide(chessman)){   //目标位置没有棋子或者是对方的棋子
                        CanGoPoints.add(endP);
                    }
                }
            }
        }
        return CanGoPoints;
    }
}
