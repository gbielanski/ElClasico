package com.example.android.courtcounter;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ScoreViewModel extends ViewModel {
    public int getScoreTeamA() {
        return scoreTeamA;
    }

    public void increaseScoreTeamA() {
        this.scoreTeamA++;
    }

    public int getScoreTeamB() {
        return scoreTeamB;
    }

    public void increaseScoreTeamB() {
        this.scoreTeamB++;
    }

    public int getFoulsTeamA() {
        return foulsTeamA;
    }

    public void increaseFoulsTeamA() {
        this.foulsTeamA++;
    }

    public int getFoulsTeamB() {
        return foulsTeamB;
    }

    public void increaseFoulsTeamB() {
        this.foulsTeamB++;
    }

    public void resetAll(){
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulsTeamA = 0;
        foulsTeamB = 0;
        goalHistory.clear();
    }

    public void addGoalHistory(String goal){
        goalHistory.add(goal);
    }

    public List<String> getGoalHistory(){
        return goalHistory;
    }

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private int foulsTeamA = 0;
    private int foulsTeamB = 0;
    private ArrayList<String> goalHistory = new ArrayList<>();

}
