package com.example.android.courtcounter;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends LifecycleActivity {

    private TextView teamAScoreTextView;
    private TextView teamBScoreTextView;
    private TextView goalHistoryTextView;
    private TextView teamAFouls;
    private TextView teamBFouls;

    private ScoreViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamAScoreTextView = (TextView) findViewById(R.id.team_a_score);
        teamBScoreTextView = (TextView) findViewById(R.id.team_b_score);
        goalHistoryTextView = (TextView) findViewById(R.id.goal_history);
        teamAFouls = (TextView) findViewById(R.id.team_a_foul);
        teamBFouls = (TextView) findViewById(R.id.team_b_foul);

        mViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);

        displayFoulsForTeamA(mViewModel.getFoulsTeamA());
        displayFoulsForTeamB(mViewModel.getFoulsTeamB());
        displayForTeamA(mViewModel.getScoreTeamA());
        displayForTeamB(mViewModel.getScoreTeamB());

    }

    /**
     * Displays the given scoreTeamA for Team A.
     */
    public void displayForTeamA(int score) {
        teamAScoreTextView.setText(String.valueOf(score));
    }

    public void goalTeamA(View v){
        mViewModel.increaseScoreTeamA();
        displayForTeamA(mViewModel.getScoreTeamA());
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
        CharSequence currentHistory = goalHistoryTextView.getText();
        if (currentHistory.toString().isEmpty())
            goalHistoryTextView.setText(currentHistory.toString() + teamName
                    + " " + String.valueOf(mViewModel.getScoreTeamA())
                    + " : " + String.valueOf(mViewModel.getScoreTeamB()));
        else
            goalHistoryTextView.setText(currentHistory.toString() + "\n" + teamName
                    + " " + String.valueOf(mViewModel.getScoreTeamA())
                    + " : " + String.valueOf(mViewModel.getScoreTeamB()));
    }

    public void resetGoalHistory() {
        goalHistoryTextView.setText("");
    }

    public void goalTeamB(View v){
        mViewModel.increaseScoreTeamB();
        displayForTeamB(mViewModel.getScoreTeamB());
        displayGoalHistory(getResources().getString(R.string.team_b));
    }

    public void foulsTeamA(View v){
        mViewModel.increaseFoulsTeamA();
        displayFoulsForTeamA(mViewModel.getFoulsTeamA());
    }
    public void foulsTeamB(View v){
        mViewModel.increaseFoulsTeamB();
        displayFoulsForTeamB(mViewModel.getFoulsTeamB());
    }
    public void displayFoulsForTeamA(int foulsTeamA) {
        teamAFouls.setText(String.valueOf(foulsTeamA));
    }

    public void displayFoulsForTeamB(int foulsTeamB) {
        teamBFouls.setText(String.valueOf(foulsTeamB));
    }

    public void resetScore(View v) {
        mViewModel.resetAll();
        displayFoulsForTeamA(mViewModel.getFoulsTeamA());
        displayFoulsForTeamB(mViewModel.getFoulsTeamB());
        displayForTeamA(mViewModel.getScoreTeamA());
        displayForTeamB(mViewModel.getScoreTeamB());
        resetGoalHistory();
    }

}
