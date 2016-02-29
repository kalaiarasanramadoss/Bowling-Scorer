package com.game.bowling.bean;

import java.io.Serializable;

/**
 * This Bean class all required property with setter and getter 
 * @author KR00357908
 *
 */

public class ScoreBowlingBean implements Serializable {
    
   /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private  int[] turns = new int[21];
    private int turn = 1;
    int total_spare=0;
    int total_strike=0;
    int totalScore = 0; 
    
    /**
     * @return the total_spare
     */
    public int getTotal_spare() {
        return total_spare;
    }
    /**
     * @param total_spare the total_spare to set
     */
    public void setTotal_spare(int total_spare) {
        this.total_spare = total_spare;
    }
    /**
     * @return the total_strike
     */
    public int getTotal_strike() {
        return total_strike;
    }
    /**
     * @param total_strike the total_strike to set
     */
    public void setTotal_strike(int total_strike) {
        this.total_strike = total_strike;
    }
    /**
     * @return the totalScore
     */
    public int getTotalScore() {
        return totalScore;
    }
    /**
     * @param totalScore the totalScore to set
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
    /**
     * @return the turns
     */
    public int[] getTurns() {
        return turns;
    }
    /**
     * @param turns the turns to set
     */
    public void setTurns(int[] turns) {
        this.turns = turns;
    }
    /**
     * @return the turn
     */
    public int getTurn() {
        return turn;
    }
    /**
     * @param turn the turn to set
     */
    public void setTurn(int turn) {
        this.turn = turn;
    }
    
   
   

}
