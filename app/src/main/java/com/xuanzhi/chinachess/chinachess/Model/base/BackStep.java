package com.xuanzhi.chinachess.chinachess.Model.base;

import android.graphics.Point;

import java.util.Stack;

/**
 * Created by Android on 2016/4/19.
 */
public class BackStep {
    class  Undo{
        Point point;
        Chessman chessman;
        int Steps;
        public  Undo(Point point,Chessman chessman,int Steps){
            this.point = new Point(point); this.chessman = chessman; this.Steps = Steps;
        }
    }

    Stack<Undo> historySteps;
}
