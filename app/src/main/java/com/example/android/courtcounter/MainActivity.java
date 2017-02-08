package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    private int foulsTeamA = 0;
    private int foulsTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given scoreTeamA for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void goalTeamA(View v){
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
        displayGoalHistory(getResources().getString(R.string.team_a));
    }

    /**
     * Displays the given scoreTeamB for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given scoreTeamB for Team B.
     */
    public void displayGoalHistory(String teamName) {
        TextView scoreView = (TextView) findViewById(R.id.goal_history);
        scoreView.setBackgroundColor(0xffffff);
        CharSequence currentHistory = scoreView.getText();
        scoreView.setText(currentHistory.toString() + "\n" + teamName
                + " " + String.valueOf(scoreTeamA)
                + " : "  + String.valueOf(scoreTeamB));
    }

    public void resetGoalHistory() {
        TextView scoreView = (TextView) findViewById(R.id.goal_history);
        scoreView.setText("");
    }

    public void goalTeamB(View v){
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
        displayGoalHistory(getResources().getString(R.string.team_b));
    }

    public void foulsTeamA(View v){
        foulsTeamA = foulsTeamA + 1;
        displayFoulsForTeamA(foulsTeamA);
    }
    public void foulsTeamB(View v){
        foulsTeamB = foulsTeamB + 1;
        displayFoulsForTeamB(foulsTeamB);
    }
    public void displayFoulsForTeamA(int foulsTeamA) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_foul);
        scoreView.setText(String.valueOf(foulsTeamA));
    }

    public void displayFoulsForTeamB(int foulsTeamB) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_foul);
        scoreView.setText(String.valueOf(foulsTeamB));
    }

    public void resetScore(View v){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        foulsTeamA = 0;
        foulsTeamB = 0;
        displayFoulsForTeamA(foulsTeamA);
        displayFoulsForTeamB(foulsTeamB);
        resetGoalHistory();
    }

}
