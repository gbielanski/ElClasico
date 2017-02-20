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
    private TextView teamAScoreTextView;
    private TextView teamBScoreTextView;
    private TextView goalHistoryTextView;
    private TextView teamAFouls;
    private TextView teamBFouls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamAScoreTextView = (TextView) findViewById(R.id.team_a_score);
        teamBScoreTextView = (TextView) findViewById(R.id.team_b_score);
        goalHistoryTextView = (TextView) findViewById(R.id.goal_history);
        teamAFouls = (TextView) findViewById(R.id.team_a_foul);
        teamBFouls = (TextView) findViewById(R.id.team_b_foul);
    }

    /**
     * Displays the given scoreTeamA for Team A.
     */
    public void displayForTeamA(int score) {
        teamAScoreTextView.setText(String.valueOf(score));
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
        teamBScoreTextView.setText(String.valueOf(score));
    }

    /**
     * Displays the given scoreTeamB for Team B.
     */
    public void displayGoalHistory(String teamName) {
        goalHistoryTextView.setBackgroundColor(0xffffff);
        CharSequence currentHistory = goalHistoryTextView.getText();
        goalHistoryTextView.setText(currentHistory.toString() + "\n" + teamName
                + " " + String.valueOf(scoreTeamA)
                + " : "  + String.valueOf(scoreTeamB));
    }

    public void resetGoalHistory() {
        goalHistoryTextView.setText("");
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
        teamAFouls.setText(String.valueOf(foulsTeamA));
    }

    public void displayFoulsForTeamB(int foulsTeamB) {
        teamBFouls.setText(String.valueOf(foulsTeamB));
    }

    public void resetScore(View v){
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulsTeamA = 0;
        foulsTeamB = 0;
        displayFoulsForTeamA(foulsTeamA);
        displayFoulsForTeamB(foulsTeamB);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        resetGoalHistory();
    }

}
