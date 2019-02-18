package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Button PlayAginbtn ;
    private TextView c,PlayerOneScoreView,PlayerTwoScoreView;
    ArrayList<TextView> AllCells ;
    int choiceIndex,PlayerOneScore=0,PlayerTwoScore=0,Draw=0;
    int[][] Wins = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    enum Player {
            ONE,TWO,NO
    }
     Player[] PlayerChoices = new Player[9];

    Player player = Player.ONE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<9;i++){
            PlayerChoices[i]=player.NO;
        }
        PlayAginbtn = (Button)findViewById(R.id.PlayAginbtn);
        PlayAginbtn.setVisibility(View.INVISIBLE);
        PlayerOneScoreView  =  (TextView) findViewById(R.id.PlayerOneScoreView);
        PlayerTwoScoreView  =  (TextView)findViewById(R.id.PlayerTwoScoreView);
        AllCells = new ArrayList<TextView>();
        c = findViewById(R.id.cell0);
        AllCells.add(c);
        c = findViewById(R.id.cell1);
        AllCells.add(c);
        c = findViewById(R.id.cell2);
        AllCells.add(c);
        c= findViewById(R.id.cell3);
        AllCells.add(c);
        c= findViewById(R.id.cell4);
        AllCells.add(c);
        c= findViewById(R.id.cell5);
        AllCells.add(c);
        c= findViewById(R.id.cell6);
        AllCells.add(c);
        c= findViewById(R.id.cell7);
        AllCells.add(c);
        c= findViewById(R.id.cell8);
        AllCells.add(c);

}

    public void PutValue(View Position) {
        TextView pos = (TextView) Position;
        choiceIndex = Integer.parseInt(pos.getTag().toString());
        PlayerChoices[choiceIndex]=player;
        //pos.animate().rotationX(180f).setDuration(0);
        if (player == Player.ONE &&pos.getText().toString().equals("")) {
            pos.setText("X");
            Draw++;
            player = Player.TWO;
        } else if (player == Player.TWO&&pos.getText().toString().equals("")) {
            pos.setText("O");
            Draw++;
            player = Player.ONE;
        }
        pos.animate().rotationX(360f).setDuration(500);
        for(int[]win:Wins){
            if( PlayerChoices[win[0]]==PlayerChoices[win[1]]&&
                PlayerChoices[win[1]]==PlayerChoices[win[2]]&&
                PlayerChoices[win[0]]!=player.NO
                ){
                Draw=0;
                if(player!=player.ONE){
                    Toast.makeText(this,"Player One is winer",Toast.LENGTH_SHORT).show();
                    PlayerOneScoreView.setText(++PlayerOneScore+"");
                    for (TextView cell:AllCells)
                    {
                        cell.setClickable(false);

                    }


                }else
                if(player!=player.TWO){
                    Toast.makeText(this,"Player Tow is winer",Toast.LENGTH_SHORT).show();
                    PlayerTwoScoreView.setText(++PlayerTwoScore+"");
                    for (TextView cell:AllCells)
                    {
                        cell.setClickable(false);

                    }

                }

                PlayAginbtn.setVisibility(View.VISIBLE);


            }else
            if(Draw==9){
                Toast.makeText(this,"Draw",Toast.LENGTH_SHORT).show();
                for (TextView cell:AllCells)
                {
                    cell.setClickable(false);

                }
                PlayAginbtn.setVisibility(View.VISIBLE);


            }



        }

    }
    public void RestertGame(View v){
        for (TextView cell:AllCells)
        {
          cell.setText("");

        }

        for(int i=0;i<9;i++){
            PlayerChoices[i]=player.NO;
        }
        PlayAginbtn.setVisibility(View.INVISIBLE);
        player = Player.ONE;
        for (TextView cell:AllCells)
        {
            cell.setClickable(true);

        }


    }



}
