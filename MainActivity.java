package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rand=new Random();
    int r1,r2,br,i,t,u=0,d=0;
    GridLayout gridLayout;
    TextView timertext,fa;
    TextView restext,dis,go;
    Button b1,b2,b3,b4;
    CountDownTimer countDownTimer;
    Button buttons[] = new Button[4];

    public void goo(View view){
        Button ans=(Button)view;
        t=Integer.parseInt((String) ans.getTag());
        Toast.makeText(this, ""+String.valueOf(t)+" "+String.valueOf(br), Toast.LENGTH_SHORT).show();
        if(t==br+1){
            u=u+1;
            fa.setText("Correct");
        }
        else{
            fa.setText("Wrong");
        }
    }
    public void onClick(View v) {
        gridLayout.setVisibility(View.VISIBLE);
        timertext.setVisibility(View.VISIBLE);
        restext.setVisibility(View.VISIBLE);
        dis.setVisibility(View.VISIBLE);
        go.setVisibility(View.INVISIBLE);
        d=0;
        u=0;
        countDownTimer=new CountDownTimer(50100,10000) {
            @Override
            public void onTick(long millisUntilFinished) {
                restext.setText(String.valueOf(u)+"/"+String.valueOf(d));
                d=d+1;
                fa.setText(" ");
                r1=rand.nextInt(30);
                r2=rand.nextInt(30);
                timertext.setText(String.valueOf(millisUntilFinished/1000));
                fa.setText(" ");
                //Log.i("random",String.valueOf(r1));
                //Log.i("ran",String.valueOf(r2));
                int res=r1+r2;
                dis.setText(String.valueOf(r1)+" + "+String.valueOf(r2));
                br=rand.nextInt(4);
                Log.i("br",String.valueOf(br));
                for(i=0;i<4;i++){
                    if(i==br){
                        buttons[br].setText(String.valueOf(res));
                    }
                    else{
                        int v=rand.nextInt(30);
                        while(v==res){
                            v=rand.nextInt(30);
                        }
                        buttons[i].setText(String.valueOf(v));
                    }
                }

            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Finish", Toast.LENGTH_SHORT).show();
                gridLayout.setVisibility(View.INVISIBLE);
                timertext.setVisibility(View.INVISIBLE);
               // restext.setVisibility(View.VISIBLE);
                dis.setVisibility(View.INVISIBLE);
                fa.setText(" ");
                go.setTextSize(44);
                go.setText("Play Again");
                go.setVisibility(View.VISIBLE);

            }
        }.start();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayout=findViewById(R.id.gridLayout);
        timertext=(TextView)findViewById(R.id.timerview);
        restext=(TextView)findViewById(R.id.resultview);
        go=(TextView)findViewById(R.id.go);
        fa=(TextView)findViewById(R.id.fa);
        dis=(TextView)findViewById(R.id.dis);
        Button but=(Button)findViewById(R.id.go);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        buttons[0] = b1;
        buttons[1] = b2;
        buttons[2] = b3;
        buttons[3] = b4;
    }
}
