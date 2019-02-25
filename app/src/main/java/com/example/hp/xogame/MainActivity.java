package com.example.hp.xogame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
Boolean Player1Turn=true;
int Player1Point,Player2Point,roundCount;
TextView Player1,Player2;
Button [][] buttons = new Button[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Player1=findViewById(R.id.player1);
        Player2=findViewById(R.id.player2);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                String ButtonId="btn"+i+j;
                int resId=getResources().getIdentifier(ButtonId,"id",getPackageName());
                buttons[i][j]=findViewById(resId);
                buttons[i][j].setOnClickListener(this);
            }
        }
        Button reset=findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

    }


    @Override
    public void onClick(View v) {
      if(!((Button) v).getText().toString().equals(""))
          return;
      if(Player1Turn){
          ((Button)v).setText("X");
      }else{
          ((Button)v).setText("O");
      }
      roundCount++;
      if(checkWin()) {
          if (Player1Turn) {
              Player1Win();
          } else {
              Player2Win();
          }
      }else if(roundCount==9){
              draw();
          }else{
              Player1Turn=!Player1Turn;
          }

    }


    private boolean checkWin() {
        String [][] field = new String[3][3];
        for(int i=0;i<3;i++){

            for(int j=0;j<3;j++){
                field[i][j]=buttons[i][j].getText().toString();
            }
        }
        //row
        for(int m=0;m<3;m++){
            if(field[m][0].equals(field[m][1])&&field[m][0].equals(field[m][2])&& !field[m][0].equals(""))
                return  true;

        }
        //column
        for(int m=0;m<3;m++){
            if(field[0][m].equals(field[1][m])&&field[0][m].equals(field[2][m])&& !field[0][m].equals(""))
                return  true;

        }
        //curosr L to R
        if(field[0][0].equals(field[1][1])&&field[0][0].equals(field[2][2])&& !field[0][0].equals("")) {
            return true;
        }
        if(field[0][2].equals(field[1][1])&&field[0][2].equals(field[2][0])&& !field[0][2].equals("")){
            return  true;}
return false;
    }




    private void  Player1Win() {
        Player1Point++;
        Toast.makeText(this,"Player 1 wins !",Toast.LENGTH_SHORT).show();
        UpdatePoints();
        resetBoard();
    }


    private void  Player2Win() {
        Player2Point++;
        Toast.makeText(this,"Player 2 wins !",Toast.LENGTH_SHORT).show();
        UpdatePoints();
        resetBoard();
    }
    private void draw() {
        Toast.makeText(this,"Draw !",Toast.LENGTH_SHORT).show();
        resetBoard();

    }
    private void UpdatePoints() {
        Player1.setText("Player 1 :"+Player1Point);
        Player2.setText("Player 2 :"+Player2Point);
    }

    private void resetBoard() {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                buttons[i][j].setText("");
            }
        }
        roundCount=0; Player1Turn=true;
    }
    private void resetGame() {
        Player2Point=0;Player1Point=0;UpdatePoints();resetBoard();
    }




}
