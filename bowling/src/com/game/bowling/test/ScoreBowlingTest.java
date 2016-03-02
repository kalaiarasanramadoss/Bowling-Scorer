package com.game.bowling.test;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;

import com.game.bowling.action.ScoreBowling;
import com.game.bowling.bean.ScoreBowlingBean;
import com.game.bowling.exception.ScoreBowlingValidationException;
import com.game.bowling.imp.ScoreBowlingImpl;

/**
 * Score Bowling test case
 * @author KR00357908
 *
 */
public class ScoreBowlingTest  extends TestCase {
    
    /**
     * Verifying main method executed success / not.
     * @throws ScoreBowlingValidationException
     */
    @Test
    public void testMainMethod() throws ScoreBowlingValidationException{
        ScoreBowling sb = new ScoreBowling();
        String args[] = {"Score Bowling TestCase "};
        sb.main(args);
    }

    /**
     * Verifying testFallPins1 method with input 10 success / not.
     */
    @Test
    public void testFallPins1() {
        ScoreBowling sb = new ScoreBowling();
        ScoreBowlingBean sbBean = new ScoreBowlingBean();
        sb.setScBean(sbBean);
        sb.fallPins(10);
    }
    
    /**
     *  Verifying testFallPins2 method with input 0 success / not.
     */
    @Test
    public void testFallPins2() {
        ScoreBowling sb = new ScoreBowling();
        ScoreBowlingBean sbBean = new ScoreBowlingBean();
        sb.setScBean(sbBean);
        sb.fallPins(0);
    }
    
    /**
     *  Verifying testFallPins3 method with input 9 success / not.
     */
    @Test
    public void testFallPins3() {
        ScoreBowling sb = new ScoreBowling();
        ScoreBowlingBean sbBean = new ScoreBowlingBean();
        sb.setScBean(sbBean);
        sb.fallPins(9);
    }
    
    
    /**
     * Verifying testCalculateScoreBoard1 method with the input {1,2,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
     * 
     */
    @Test
    public void testCalculateScoreBoard1() {
        ScoreBowling sb = new ScoreBowling();
        ScoreBowlingBean sbBean = new ScoreBowlingBean();
        ScoreBowlingImpl bowlingImpl = new ScoreBowlingImpl();
        sb.setScBean(sbBean);
        int[] turns = {1,2,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        sbBean.setTurns(turns);
        int result = sb.calculateScoreBoard(bowlingImpl);
        assertEquals(10, result);
    }
    
    /**
     * Verifying testCalculateScoreBoard2 method with the input {9,1,9,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
     */
    @Test
    public void testCalculateScoreBoard2() {
        ScoreBowling sb = new ScoreBowling();
        ScoreBowlingBean sbBean = new ScoreBowlingBean();
        ScoreBowlingImpl bowlingImpl = new ScoreBowlingImpl();
        sb.setScBean(sbBean);
        int[] turns = {9,1,9,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        sbBean.setTurns(turns);
        int result = sb.calculateScoreBoard(bowlingImpl);
        assertEquals(10, result);
    }
    
    
    /**
     * Verifying testCalculateScoreBoard3 method with the input {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}
     */
    @Test
    public void testCalculateScoreBoard3() {
        ScoreBowling sb = new ScoreBowling();
        ScoreBowlingBean sbBean = new ScoreBowlingBean();
        ScoreBowlingImpl bowlingImpl = new ScoreBowlingImpl();
        sb.setScBean(sbBean);
        int[] turns = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        sbBean.setTurns(turns);
        int result = sb.calculateScoreBoard(bowlingImpl);
        assertEquals(10, result);
    }
    
    
    /**
     * Verifying testcallStrike1 method with the input {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}
     */
    @Test
    public void testcallStrike1() {
        ScoreBowling sb = new ScoreBowling();
        ScoreBowlingBean sbBean = new ScoreBowlingBean();
        ScoreBowlingImpl bowlingImpl = new ScoreBowlingImpl();
        sb.setScBean(sbBean);
        int[] turns = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10,10,10};
        sbBean.setTurns(turns);
        int result = bowlingImpl.callStrike(18, sbBean);
        assertEquals(30, result);
    }
    
    
    /** Verifying testcallStrike2 method with the input {10,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
     * Strike Test 2
     * Here -1 values in the array are unrolled cells
     */
    @Test
    public void testcallStrike2() throws ScoreBowlingValidationException{
        ScoreBowling sb = new ScoreBowling();
        ScoreBowlingBean sbBean = new ScoreBowlingBean();
        ScoreBowlingImpl bowlingImpl = new ScoreBowlingImpl();
        sb.setScBean(sbBean);
        int[] turns = {10,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        sbBean.setTurns(turns);
        int result = bowlingImpl.callStrike(1, sbBean);
        assertEquals(0, result);
    }
    
    /**
     * Verifying testcallStrike3 method with the input {10,1,9,1,10,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
     * 
     */
    @Test
    public void testcallStrike3() throws ScoreBowlingValidationException{
        ScoreBowling sb = new ScoreBowling();
        ScoreBowlingBean sbBean = new ScoreBowlingBean();
        ScoreBowlingImpl bowlingImpl = new ScoreBowlingImpl();
        sb.setScBean(sbBean);
        int[] turns = {10,1,9,1,10,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        sbBean.setTurns(turns);
        int result = bowlingImpl.callStrike(1, sbBean);
        assertEquals(21, result);
    }
    
    /**
     * Verifying testCallSpare1 method with the input {10,1,9,1,10,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
     * Here -1 values in the array are unrolled cells
     */
    @Test
    public void testCallSpare1() {
        ScoreBowling sb = new ScoreBowling();
        ScoreBowlingBean sbBean = new ScoreBowlingBean();
        ScoreBowlingImpl bowlingImpl = new ScoreBowlingImpl();
        sb.setScBean(sbBean);
        int[] turns = {10,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        sbBean.setTurns(turns);
        int result = bowlingImpl.callSpare(3, sbBean);
        assertEquals(0, result);
    }
   
    /**
     * Verifying testCallSpare2 method with the input {10,0,2,8,0,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
     * Here -1 values in the array are unrolled cells
     */
    @Test
    public void testCallSpare2() {
        ScoreBowling sb = new ScoreBowling();
        ScoreBowlingBean sbBean = new ScoreBowlingBean();
        ScoreBowlingImpl bowlingImpl = new ScoreBowlingImpl();
        sb.setScBean(sbBean);
        int[] turns = {10,0,2,8,0,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        sbBean.setTurns(turns);
        int result = bowlingImpl.callSpare(3, sbBean);
        assertEquals(13, result);
    }
    
    /**
     * Verifying testvalidateInput1 method with the input turns = "1 1 1 1 11 1 1"
     * 
     */
    @Test
    public void testvalidateInput1() {
        ScoreBowling sb = new ScoreBowling();
        String turns = "1 1 1 1 11 1 1";
        boolean result = sb.validateInput(turns);
        assertEquals(true, result);
       
    }
    
    /**
     * Verifying testvalidateInput2 method with the input turns = "1 1 1 1 0 1 1"
     * 
     */
    @Test
    public void testvalidateInput2() {
        ScoreBowling sb = new ScoreBowling();
        String turns = "1 1 1 1 0 1 1";
        boolean result = sb.validateInput(turns);
        assertEquals(false, result);
    }
    
    /**
     * Verifying testvalidateInput2 method with the input turns = ""
     * 
     */
    @Test
    public void testvalidateInput3() {
        ScoreBowling sb = new ScoreBowling();
        String turns = "";
        boolean result = sb.validateInput(turns);
        assertEquals(false, result);
    }
    
    
    /**
     * Verifying testvalidateInput2 method with the input turns = "" and map object contains the result if any possible result occur during validation
     * 
     */
    @Test
    public void testvalidateInputBundleTest1()   {
        ScoreBowling sb = new ScoreBowling();
        Map<String, String> valErrorMap = new HashMap<String, String>();
        String str="";
        Map<String, String> result = sb.validateInput(str,valErrorMap);
        assertEquals(1, result.size());
    }
    
    /**
     * Verifying testvalidateInputBundleTest2 method with the input turns = "" and map object contains the result if any possible result occur during validation
     * 
     */
    @Test
    public void testvalidateInputBundleTest2()   {
        ScoreBowling sb = new ScoreBowling();
        Map<String, String> valErrorMap = new HashMap<String, String>();
        Object object="";
        Map<String, String> result = sb.validateInput(object,valErrorMap);
        assertEquals(1, result.size());
    }
    
    
    
    
    
    
   
    
    

}
