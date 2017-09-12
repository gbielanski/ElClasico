package com.example.android.courtcounter;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;

public class MainActivity extends LifecycleActivity {

    @BindView(R.id.team_a_score) TextView teamAScoreTextView;
    @BindView(R.id.team_b_score) TextView teamBScoreTextView;
    @BindView(R.id.goal_history) TextView goalHistoryTextView;
    @BindView(R.id.team_a_foul) TextView teamAFouls;
    @BindView(R.id.team_b_foul) TextView teamBFouls;

    private ScoreViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
        displayAll();

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
        resetGoalHistory();
        displayAll();
    }

    private void displayAll() {
        displayFoulsForTeamA(mViewModel.getFoulsTeamA());
        displayFoulsForTeamB(mViewModel.getFoulsTeamB());
        displayForTeamA(mViewModel.getScoreTeamA());
        displayForTeamB(mViewModel.getScoreTeamB());
    }

}
