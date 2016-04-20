package com.xuanzhi.chinachess.chinachess.Model.base;

import android.graphics.Point;
import android.view.View;

import com.xuanzhi.chinachess.chinachess.Model.Chesses.Bachelor;
import com.xuanzhi.chinachess.chinachess.Model.Chesses.BigGun;
import com.xuanzhi.chinachess.chinachess.Model.Chesses.Bike;
import com.xuanzhi.chinachess.chinachess.Model.Chesses.Boss;
import com.xuanzhi.chinachess.chinachess.Model.Chesses.Elephant;
import com.xuanzhi.chinachess.chinachess.Model.Chesses.Horse;
import com.xuanzhi.chinachess.chinachess.Model.Chesses.Soldier;
import com.xuanzhi.chinachess.chinachess.R;

import java.util.Map;

/**
 * Created by Android on 2016/4/6.
 */
public class ChessInit   {
    Map<Point,Chessman> mChessmanMap;
    int row = 9;
    int col = 8;
    public ChessInit( Map<Point,Chessman> mChessmanMap) {
        this.mChessmanMap = mChessmanMap;
    }
    public void InitAllChessman() {
        // for(int i=0;i<l)
        Chessman chessman =  new Bike( R.drawable.blackbike,"黑",new Point(0,0));  PutInMap(chessman);
        chessman =  new Horse(R.drawable.blackhorse,"黑",new Point(1,0));  PutInMap(chessman);
        chessman =  new Elephant( R.drawable.blackelephants,"黑",new Point(2,0));  PutInMap(chessman);
        chessman =  new Bachelor( R.drawable.blackbachelor,"黑",new Point(3,0));  PutInMap(chessman);
        chessman =  new Boss(R.drawable.blackboss,"黑",new Point(4,0));  PutInMap(chessman);
        chessman =  new Bachelor(R.drawable.blackbachelor,"黑",new Point(5,0));  PutInMap(chessman);
        chessman =  new Elephant( R.drawable.blackelephants,"黑",new Point(6,0));  PutInMap(chessman);
        chessman =  new Horse(R.drawable.blackhorse,"黑",new Point(7,0));  PutInMap(chessman);
        chessman =  new Bike( R.drawable.blackbike,"黑",new Point(8,0));  PutInMap(chessman);
        chessman =  new BigGun(R.drawable.blackbiggun,"黑",new Point(1,2));  PutInMap(chessman);
        chessman =  new BigGun(R.drawable.blackbiggun,"黑",new Point(7,2));  PutInMap(chessman);
        chessman =  new Soldier( R.drawable.blacksoldier,"黑",new Point(0,3));  PutInMap(chessman);
        chessman =  new Soldier( R.drawable.blacksoldier,"黑",new Point(2,3));  PutInMap(chessman);
        chessman =  new Soldier( R.drawable.blacksoldier,"黑",new Point(4,3));  PutInMap(chessman);
        chessman =  new Soldier( R.drawable.blacksoldier,"黑",new Point(6,3));  PutInMap(chessman);
        chessman =  new Soldier(R.drawable.blacksoldier,"黑",new Point(8,3));  PutInMap(chessman);

         chessman =  new Bike( R.drawable.redbike,"红",new Point(col-0,row-0));  PutInMap(chessman);
        chessman =  new Horse( R.drawable.redhorse,"红",new Point(col-1,row-0));  PutInMap(chessman);
        chessman =  new Elephant( R.drawable.redelephants,"红",new Point(col-2,row-0));  PutInMap(chessman);
        chessman =  new Bachelor(R.drawable.redbachelor,"红",new Point(col-3,row-0));  PutInMap(chessman);
        chessman =  new Boss(R.drawable.redboss,"红",new Point(col-4,row-0)); PutInMap(chessman);
        chessman =  new Bachelor( R.drawable.redbachelor,"红",new Point(col-5,row-0));  PutInMap(chessman);
        chessman =  new Elephant( R.drawable.redelephants,"红",new Point(col-6,row-0));  PutInMap(chessman);
        chessman =  new Horse(R.drawable.redhorse,"红",new Point(col-7,row-0));  PutInMap(chessman);
        chessman =  new Bike( R.drawable.redbike,"红",new Point(col-8,row-0));  PutInMap(chessman);
        chessman =  new BigGun(R.drawable.redbiggun,"红",new Point(col-1,row-2));  PutInMap(chessman);
        chessman =  new BigGun(R.drawable.redbiggun,"红",new Point(col-7,row-2));  PutInMap(chessman);
        chessman =  new Soldier(R.drawable.redsoldier,"红",new Point(col-0,row-3));  PutInMap(chessman);
        chessman =  new Soldier( R.drawable.redsoldier,"红",new Point(col-2,row-3));  PutInMap(chessman);
        chessman =  new Soldier(R.drawable.redsoldier,"红",new Point(col-4,row-3));  PutInMap(chessman);
        chessman =  new Soldier(R.drawable.redsoldier,"红",new Point(col-6,row-3));  PutInMap(chessman);
        chessman =  new Soldier( R.drawable.redsoldier,"红",new Point(col-8,row-3));  PutInMap(chessman);
    }
    private void PutInMap(Chessman chessman){
        mChessmanMap.put(chessman.getCurPoint(),chessman);
    }
}
