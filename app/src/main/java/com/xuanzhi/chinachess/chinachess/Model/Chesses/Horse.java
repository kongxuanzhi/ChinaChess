package com.xuanzhi.chinachess.chinachess.Model.Chesses;
import android.graphics.Point;

import com.xuanzhi.chinachess.chinachess.Model.base.ChessBoard;
import com.xuanzhi.chinachess.chinachess.Model.base.ChessBoardView;
import com.xuanzhi.chinachess.chinachess.Model.base.Chessman;

import java.util.List;
import java.util.Map;

/**
 * Created by Android on 2016/4/4.
 */
public class Horse  extends Chessman{
    public Horse(int picRescourceId,String sideColor,Point point) {
        super(picRescourceId, sideColor,point);
        setcName("馬");
    }
    /**
     * 根据当前位置得到下一步可走的 Point的集合
     */
    @Override
    protected List<Point> CalcNextSteps(ChessBoard checkBoard) {
        CanGoPoints.clear();
        Point point = getCurPoint();
        Map<Point, Chessman>  mChessmanMap =   checkBoard.getmChessmanMap();
        Chessman chessman = mChessmanMap.get(point);
        int dir[][] ={{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1}};
        int foot[][] = {{0,-1},{1,0},{0,1},{-1,0}};
        int k = 0;
        for (int i=0;i<8;i++){
            int x =  point.x+dir[i][0];
            int y =  point.y+dir[i][1];
            //要走的位置在界内，并且走的位置为空，或者非同种颜色的棋子，且不会绊脚
            if(!(x>8||y>9||x<0||y<0)){
                    Point NextPoint = new Point(x,y);
                    Chessman NextPointChessman = mChessmanMap.get(NextPoint);
                   //下一个位置上没有棋子，或者是对方的棋子就可以走
                    if(NextPointChessman==null ||  !chessman.SameSide(NextPointChessman)){
                        int xf = point.x+foot[k][0];
                        int yf = point.y+foot[k][1];
                        Chessman chessmanfoot = mChessmanMap.get(new Point(xf,yf));
                        if(chessmanfoot == null){   //没有拌马腿
                            CanGoPoints.add(NextPoint);
                        }
                    }
            }
            if((i+1)%2==0){  //不绊马腿
                k++;  //下一个方向
            }
        }
        return  CanGoPoints;
    }
}
