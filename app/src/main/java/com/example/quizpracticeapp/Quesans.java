package com.example.quizpracticeapp;

public class Quesans {
    private String ques;
    private boolean ans;

    public Quesans(String ques, boolean ans) {
        this.ques = ques;
        this.ans = ans;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public boolean isAns() {
        return ans;
    }

    public void setAns(boolean ans) {
        this.ans = ans;
    }
}
