package com.example.android.stronhold;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /* Set global variables
     */

    int redTeamStrongholds = 0;
    int redTeamPlayersEliminated = 8;
    int blueTeamStrongholds = 0;
    int blueTeamPlayersEliminated = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* method for displaying strongholds captured by red team/left side team
     */
    public void displayRedTeamStrongholds (int captures){
        TextView redStrongholds = (TextView) findViewById(R.id.red_Team_Strongholds_Score);
        redStrongholds.setText(String.valueOf(captures));
    }

    /* this method handles the capture logic for red team
     */
    public void redCaptures (View view){
        redTeamStrongholds = redTeamStrongholds + 1;
        displayRedTeamStrongholds(redTeamStrongholds);
        if (redTeamStrongholds >= 5){
            redTeamStrongholds = 5;
            Toast.makeText(this, "RED TEAM WINS!!!", Toast.LENGTH_LONG).show();
            displayRedTeamStrongholds(redTeamStrongholds);
        }
    }

    /* this method handles the display logic for red team members eliminated
     */
    public void displayRedTeamEliminates (int eliminations1){
        TextView redEliminates = (TextView) findViewById(R.id.red_Team_Players_Eliminated_Score);
        redEliminates.setText(String.valueOf(eliminations1));
        if (redTeamPlayersEliminated < 1){
            Toast.makeText(this, "BLUE TEAM WINS!!!", Toast.LENGTH_LONG).show();
        }
    }

    /* method for red team players eliminated
     */
    public void redEliminate (View view){
        if (redTeamPlayersEliminated < 1){
            displayRedTeamEliminates(redTeamPlayersEliminated);
            Toast.makeText(this, "BLUE TEAM WINS!!!", Toast.LENGTH_LONG).show();
            return;
        }
        redTeamPlayersEliminated = redTeamPlayersEliminated - 1;
        displayRedTeamEliminates(redTeamPlayersEliminated);
    }

    /* this method displays strongholds captured by blue team/right side team
     */
    public void displayBlueTeamStrongholds (int captures1){
        TextView redStrongholds = (TextView) findViewById(R.id.blue_Team_Strongholds_Score);
        redStrongholds.setText(String.valueOf(captures1));
    }

    /* method handles stronghold capture logic for blue team
     */
    public void blueCaptures (View view){
        blueTeamStrongholds = blueTeamStrongholds + 1;
        displayBlueTeamStrongholds(blueTeamStrongholds);
        if (blueTeamStrongholds >= 5){
            blueTeamStrongholds = 5;
            Toast.makeText(this, "BLUE TEAM WINS!!!", Toast.LENGTH_LONG).show();
            displayBlueTeamStrongholds(blueTeamStrongholds);
        }
    }

    /* this method displays blue team players eliminated
     */
    public void displayBlueTeamEliminates (int eliminations2){
        TextView blueEliminates = (TextView) findViewById(R.id.blue_Team_Players_Eliminated_Score);
        blueEliminates.setText(String.valueOf(eliminations2));
        if (blueTeamPlayersEliminated < 1){
            Toast.makeText(this, "RED TEAM WINS!!!", Toast.LENGTH_LONG).show();
        }
    }

    /* method for elimination logic of blue team
     */
    public void blueEliminate (View view){
        if (blueTeamPlayersEliminated < 1){
            Toast.makeText(this, "RED TEAM WINS!!!", Toast.LENGTH_LONG).show();
            return;
        }
        blueTeamPlayersEliminated = blueTeamPlayersEliminated - 1;
        displayBlueTeamEliminates(blueTeamPlayersEliminated);
    }

    /* this method resets the strongholds captured and team members eliminated for both teams
     */
    public void reset (View view){
        redTeamStrongholds = 0;
        redTeamPlayersEliminated = 8;
        blueTeamStrongholds = 0;
        blueTeamPlayersEliminated = 8;
        displayRedTeamStrongholds(redTeamStrongholds);
        displayRedTeamEliminates(redTeamPlayersEliminated);
        displayBlueTeamStrongholds(blueTeamStrongholds);
        displayBlueTeamEliminates(blueTeamPlayersEliminated);
    }
}
