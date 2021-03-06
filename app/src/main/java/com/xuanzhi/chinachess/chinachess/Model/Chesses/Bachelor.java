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
public class Bachelor extends Chessman {
    int  mStartRow,mEndRow;
    int mStartCol, mEndCol;
    public Bachelor( int picRescourceId, String sideColor, Point point) {
        super(picRescourceId, sideColor, point);
        setcName("士");
        if (sideColor.equals("黑")){
            mStartRow=0;mEndRow = 2;
            mStartCol = 3;mEndCol = 5;
        }
        else{
            mStartRow=7;mEndRow = 9;
            mStartCol = 3;mEndCol = 5;
        }
    }

    @Override
    protected List<Point> CalcNextSteps(ChessBoard checkBoard) {
        CanGoPoints.clear();
        Map<Point, Chessman> mChessmanMap =   checkBoard.getmChessmanMap();
        Point point = getCurPoint();
        Chessman chessman = mChessmanMap.get(point);
        int dir[][] = {{-1,-1},{1,-1},{1,1},{-1,1}};
        for (int i = 0; i < dir.length; i++) {
            int  x = point.x + dir[i][0];
            int  y = point.y + dir[i][1];
            if(x>=mStartCol&&x<=mEndCol && y>=mStartRow && y<=mEndRow){
                Point endP = new Point(x,y);
                Chessman AimPoint = mChessmanMap.get(endP);
                if(AimPoint == null || !chessman.SameSide(AimPoint)){
                    CanGoPoints.add(endP);
                }
            }
        }
        return CanGoPoints;
    }
}
