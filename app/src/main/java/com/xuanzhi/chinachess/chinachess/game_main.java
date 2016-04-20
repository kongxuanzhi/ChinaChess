package com.xuanzhi.chinachess.chinachess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xuanzhi.chinachess.chinachess.Model.base.ChessBoardView;
import com.xuanzhi.chinachess.chinachess.Model.base.ChessView;

public class game_main extends AppCompatActivity {
    ChessView mview ;
    ChessBoardView mChessBoardView;

    public  static  String Info = "坐标";
    public  static  String Origin = Info;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_main);
        mview = (ChessView) findViewById(R.id.CV);
        mChessBoardView =  mview.getmChessBoardView();
        tv   = (TextView) this.findViewById(R.id.zuo);
        tv.setText(Info);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(!Origin.equals(Info)){
                        tv.post(new Runnable() {
                            @Override
                            public void run() {
                                tv.setText(Info);
                                Origin = Info;
                            }
                        });
                    }
                }
            }
        });
        thread.start();
    }

    public   void  setText(String text){
        TextView tv = (TextView) this.findViewById(R.id.zuo);
        tv.setText(text);
    }

    public void backUndo(View view){
        if(mChessBoardView != null){
            mChessBoardView.getmChessBoard().BackSteps();
            mview.invalidate();
        }
    }
}
