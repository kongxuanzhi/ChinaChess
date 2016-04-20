package com.xuanzhi.chinachess.chinachess.Model.base;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Android on 2016/4/4.
 */
//向ViewGroup中添加子View
public class ChessBoard {
    class  Undo{
        Point point;
        Chessman chessman;
        int Steps;
        public  Undo(Point point,Chessman chessman,int Steps){
            this.point = new Point(point);
            this.chessman = chessman;
            this.Steps = Steps;
        }
    }
    Stack<Undo> historySteps;
    Map<Point,Chessman> mChessmanMap;  //一个点最多对应一个棋子的对象

    ChessInit mChessInit;   //依赖关系 ->将 所有棋子初始化



    private Point mCurClickPoint;    //当前点击的点
    private Chessman mFirstClickChess;      // 第一次点击的对象


    private Point mPreClickPoint;


    public static final int RowCount=10;
    public final static int ColCount = 9;

    public List<Point> CanGoPoints;

    private String CurrentHand = "红";

    public ChessBoard(){
        mChessmanMap = new HashMap<>();
        historySteps = new Stack<>();

        //初始化所有的棋子并添加到map（mChessman）中
        mChessInit = new ChessInit(mChessmanMap);
        mChessInit.InitAllChessman();

        mCurClickPoint = new Point(-1,-1);
    }

    public  String ClickAndRun(Point point){
        String Status = null;
        Chessman chessman = mChessmanMap.get(point);// 从map中根据坐标点获取chessman对象
        if(IsFirstClick()){    //第一次点击
            if(chessman != null){      //点到了棋子上
                if(chessman.getSideColor().equals(CurrentHand)){
                    CalcNextSteps(chessman);
                    RecordFirstClickInfo(chessman, point);
                    ClearPrePos();
                }else{
                    Status = "该"+CurrentHand+"方走棋";
                }
            }
        }else if(!IsFirstClick()){    //不是第一次点击，并且第一次点击到了棋子上
            if(mFirstClickChess.CanGo(this, point)){  //计算第一次点击的棋子mFirstClickChess 能否走到point这个点上
                GotoPoint(point);   //走到点击的位置
                ChangeHand();
                RecordPrePos();
                ClearRoad();//清空可走的痕迹
            } else if(chessman!=null && chessman.SameSide(mFirstClickChess)){  //如果不可以走
                //点击到自己方的棋子
                CalcNextSteps(chessman);
                RecordFirstClickInfo(chessman, point);
            }
        }
        return  Status;
    }

    public  void BackSteps(){
        if(historySteps != null && historySteps.size() != 0){
            Undo undo = historySteps.peek();
            if(undo.Steps == 1){
                mChessmanMap.remove(undo.chessman.CurPoint);
                undo.chessman.setCurPoint(undo.point);
                mChessmanMap.put(undo.point, undo.chessman);
                historySteps.pop();
                ChangeHand();
                CalcNextSteps(undo.chessman);
                RecordFirstClickInfo(undo.chessman, undo.point);
                ClearPrePos();
            }else if(undo.Steps == 2){
                undo = historySteps.peek();
                // mChessmanMap.remove(undo.chessman.CurPoint);
                undo.chessman.setCurPoint(undo.point);
                if(!mChessmanMap.containsValue(undo.chessman)){
                    mChessmanMap.put(undo.point,undo.chessman);
                }
                historySteps.pop();
                undo = historySteps.peek();
                //   mChessmanMap.remove(undo.chessman.CurPoint);
                undo.chessman.setCurPoint(undo.point);
                mChessmanMap.put(undo.point, undo.chessman);
                historySteps.pop();
                ChangeHand();
                CalcNextSteps(undo.chessman);
                RecordFirstClickInfo(undo.chessman, undo.point);
                ClearPrePos();
            }
        }
    }

    /**
     * 换手
     */
    private void ChangeHand(){
        if(CurrentHand.equals("黑")){
            CurrentHand = "红";
        }else if(CurrentHand.equals("红")){
            CurrentHand = "黑";
        }
    }
    private void ClearPrePos(){
        mPreClickPoint = null;   //消去刚才点击的棋子走过的痕迹
    }
    private void RecordPrePos(){
        mPreClickPoint = new Point(mCurClickPoint);  //记录上一个位置
        mCurClickPoint.x = mCurClickPoint.y = -1;  //变成第一次走

    }
    private void RecordFirstClickInfo(Chessman chessman, Point point){
        mFirstClickChess = chessman;    //记录点到的对象
        mCurClickPoint = point;   //记录点
    }
    private  void ClearRoad(){
        CanGoPoints = null;
    }
    /**
     * 计算是否是第一次点击
     * @return
     */
    public boolean IsFirstClick(){
        return  mCurClickPoint.equals(-1, -1);
    }
    /**
     * 计算当前选中棋子的下一步可走的区域
     * @param chessman
     */
    private  void  CalcNextSteps(Chessman chessman){
        CanGoPoints = chessman.CalcNextSteps(this);  //计算新的棋子可走的位置
    }
    private void GotoPoint(Point point) {
        mFirstClickChess.MoveToNext(point);  //当前棋子走到下一步
        UpdateBoard(point);  //更新棋盘 //记录棋谱
    }
    private  void UpdateBoard(Point point) {
        mChessmanMap.remove(mCurClickPoint);  //删除原位置的元素
        Undo undo = new Undo(mCurClickPoint,mFirstClickChess,1);
        historySteps.push(undo);
        //push(mCurClickPoint,mFirstClickChess,1);
        Chessman chessman = mChessmanMap.get(point);
        if (chessman != null) {
            undo = new Undo(point,chessman,2);
            historySteps.push(undo);
            // push(point,chessman,2);
        }
        //chessman.setCurPoint(point);
        mChessmanMap.put(point, mFirstClickChess);   //更新新位置的元素
    }


    public Map<Point, Chessman> getmChessmanMap() {
        return mChessmanMap;
    }

    public Point getmCurClickPoint() {
        return mCurClickPoint;
    }
    public Point getmPreClickPoint() {
        return mPreClickPoint;
    }
}
