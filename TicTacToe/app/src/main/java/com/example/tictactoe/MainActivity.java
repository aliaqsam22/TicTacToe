package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
private TextView player;
public boolean turn=true;
public String[][] str= new String[3][3];
public void player1win(){
    AlertDialog.Builder winner=new AlertDialog.Builder(MainActivity.this);
    winner.setMessage("Player 1 has won the game!!" +
            "\n"+" Do You want to play again? ");
    winner.setTitle("Congratulations!!");
    winner.setCancelable(false);
    winner.setPositiveButton("Yes",(DialogInterface.OnClickListener)(dialog,which)->{
        dialog.cancel();
        reset();});
    winner.setNegativeButton("NO",(DialogInterface.OnClickListener)(dialog,which)->{
        finish();
    });
    AlertDialog alertDialog=winner.create();
    alertDialog.show();

}
    public void player2win(){
        AlertDialog.Builder winner1=new AlertDialog.Builder(MainActivity.this);
        winner1.setMessage("Player 2 has won the game"+"\n"+" Do You want to play again? ");
        winner1.setTitle("Congratulations");
        winner1.setCancelable(false);
        winner1.setPositiveButton("Yes",(DialogInterface.OnClickListener)(dialog,which)->{
            dialog.cancel();
            reset();});
        winner1.setNegativeButton("NO",(DialogInterface.OnClickListener)(dialog,which)->{
            finish();
        });
        AlertDialog alertDialog=winner1.create();
        alertDialog.show();

    }
    public void draw(){
        AlertDialog.Builder winner2=new AlertDialog.Builder(MainActivity.this);
        winner2.setMessage("The Game is Draw"+"\n"+" Do You want to play again? ");
        winner2.setTitle("Draw");
        winner2.setCancelable(false);
        winner2.setPositiveButton("Yes",(DialogInterface.OnClickListener)(dialog,which)->{
            dialog.cancel();
            reset();});
        winner2.setNegativeButton("NO",(DialogInterface.OnClickListener)(dialog,which)->{
            finish();
            });
        AlertDialog alertDialog=winner2.create();
        alertDialog.show();

    }
    public void reset(){

        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");

        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b1.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);

        str[0][0]=null;
        str[0][1]=null;
        str[0][2]=null;
        str[1][0]=null;
        str[1][1]=null;
        str[1][2]=null;
        str[2][0]=null;
        str[2][1]=null;
        str[2][2]=null;

      turn=true;
    }
public void checkwiner(){
    if(str[0][0]=="X"&&str[1][1]=="X"&&str[2][2]=="X"||str[0][0]=="X"&&str[1][0]=="X"&&str[2][0]=="X"||str[0][0]=="X"&&str[0][1]=="X"&&str[0][2]=="X"||str[0][1]=="X"&&str[1][1]=="X"&&str[2][1]=="X"||str[0][2]=="X"&&str[1][1]=="X"&&str[2][0]=="X"||str[0][2]=="X"&&str[1][2]=="X"&&str[2][2]=="X"||str[1][0]=="X"&&str[1][1]=="X"&&str[1][2]=="X"||str[2][0]=="X"&&str[2][1]=="X"&&str[2][2]=="X"){
        player1win();
    }
     else if(str[0][0]=="O"&&str[1][1]=="O"&&str[2][2]=="O"||str[0][0]=="O"&&str[1][0]=="O"&&str[2][0]=="O"||str[0][0]=="O"&&str[0][1]=="O"&&str[0][2]=="O"||str[0][1]=="O"&&str[1][1]=="O"&&str[2][1]=="O"||str[0][2]=="O"&&str[1][1]=="O"&&str[2][0]=="O"||str[0][2]=="O"&&str[1][2]=="O"&&str[2][2]=="O"||str[1][0]=="O"&&str[1][1]=="O"&&str[1][2]=="O"||str[2][0]=="O"&&str[2][1]=="O"&&str[2][2]=="O"){
        player2win();
    }
    else if(str[0][0]!=null&&str[0][1]!=null&&str[0][2]!=null&&str[1][0]!=null&&str[1][1]!=null&&str[1][2]!=null&&str[2][0]!=null&&str[2][1]!=null&&str[2][2]!=null){
        draw();
    }

}
    public void player1(Button button){

        button.setText("X");
        button.setEnabled(false);
        checkwiner();
        player.setText("Player 2's turn");
        turn=false;
    }
    public void player2(Button button){
        button.setText("O");
        button.setEnabled(false);
        checkwiner();
        player.setText("Player 1's Turn");
        turn=true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        b5=findViewById(R.id.button5);
        b6=findViewById(R.id.button6);
        b7=findViewById(R.id.button7);
        b8=findViewById(R.id.button8);
        b9=findViewById(R.id.button9);
        player=findViewById(R.id.textView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn){
                    str[0][0]="X";
                    player1(b1);
                }
                else{
                    str[0][0]="O";
                    player2(b1);

                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn){
                    str[0][1]="X";
                    player1(b2);

                }
                else{
                    str[0][1]="O";
                    player2(b2);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn){
                    str[0][2]="X";
                    player1(b3);

                }
                else{
                    str[0][2]="O";
                    player2(b3);

                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn){
                    str[1][0]="X";
                    player1(b4);

                }
                else{
                    str[1][0]="O";
                    player2(b4);

                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn){
                    str[1][1]="X";
                    player1(b5);

                }
                else{
                    str[1][1]="O";
                    player2(b5);

                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn){
                    str[1][2]="X";
                    player1(b6);

                }
                else{
                    str[1][2]="O";
                    player2(b6);

                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn){
                    str[2][0]="X";
                    player1(b7);

                }
                else{
                    str[2][0]="O";
                    player2(b7);

                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn){
                    str[2][1]="X";
                    player1(b8);

                }
                else{
                    str[2][1]="O";
                    player2(b8);

                }
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn){
                    str[2][2]="X";
                    player1(b9);

                }
                else{
                    str[2][2]="O";
                    player2(b9);

                }
            }
        });
    }
}