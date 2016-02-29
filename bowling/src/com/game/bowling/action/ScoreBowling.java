package com.game.bowling.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import com.game.bowling.Imp.ScoreBowlingImpl;
import com.game.bowling.bean.ScoreBowlingBean;
import com.game.bowling.constants.ScoreBowlingConstants;
import com.game.bowling.exception.ScoreBowlingValidationException;
import com.game.bowling.utils.ScoreBowlingValidation;

/**
 * The class ScoreBowling calculate the score earned by single player.There is maximum 10 frame each frame divided by
 * two roll except 10th frame.
 * 
 * @author KR00357908
 * 
 */

public class ScoreBowling extends ScoreBowlingValidation implements Serializable {

    static Logger logger = Logger.getLogger(ScoreBowling.class);

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    ScoreBowlingBean scBean = new ScoreBowlingBean();
    static Locale defaultLocale = Locale.getDefault();
    static ResourceBundle defaultBundle  = ResourceBundle.getBundle("RBundle", defaultLocale);

    int turn = 1;

    /**
     * Constructor fill -1 value in all the frames before start the game.
     */
    public ScoreBowling() {
        try {
            for (int i = 0; i < 21; i++) {
                getScBean().getTurns()[i] = -1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO Auto-generated catch block
            if (logger.isDebugEnabled()) {
                logger.error("Array index out bound exception...", e);
            }
        }
    }

    /**
     * Main method pass the string array values to fallPins method it returns the result according to the input values
     * 
     * @param args
     * @throws ScoreBowlingValidationException
     */
    public static void main(String[] args) throws ScoreBowlingValidationException {
        // TODO Auto-generated method stub
        

        String turnScores = null;
        Map<String, String> valErrorMap = new HashMap<String, String>();
        ScoreBowlingValidation bowlingValidation = new ScoreBowlingValidation();
        ScoreBowling bowl = null;
        ScoreBowlingImpl bowlingImpl = new ScoreBowlingImpl();

        BasicConfigurator.configure();
        //defaultBundle = bowlingImpl.loadResource();
        bowlingValidation.validateInput(defaultBundle, valErrorMap);
        
        if (logger.isDebugEnabled()) {
            logger.info(defaultBundle.getString("sc.enter.main.method"));
        }

        try {
           
            // Internationalization : Below line load the resource bundle
            

            if (null != bowlingValidation) {

                if (logger.isDebugEnabled()) {
                    logger.info(defaultBundle.getString("sc.welcome"));
                    logger.info(defaultBundle.getString("sc.line"));
                    logger.info(defaultBundle.getString("sc.enter.input"));
                }

                Scanner input = new Scanner(System.in);
                turnScores = input.nextLine();
                bowlingValidation.validateInput(turnScores, valErrorMap);

                if (valErrorMap.size() == 0) {

                    StringTokenizer st = new StringTokenizer(turnScores, " ");
                    StringBuffer sb = new StringBuffer();
                    while (st.hasMoreElements()) {
                        sb.append(st.nextElement()).append(" ");
                    }
                   
                    turnScores = sb.toString().trim();

                    if (!bowlingValidation.validateInput(turnScores)) {

                        bowl = new ScoreBowling();
                        String currentlyPinsKnocked[] = turnScores.split(" ");
                        for (int i = 0; i < currentlyPinsKnocked.length; i++) {
                            bowl.fallPins(Integer.parseInt(currentlyPinsKnocked[i]));
                        }

                        int total_score = bowl.calculateScoreBoard(bowlingImpl);
                        
                        // Remove the command line for below method to see the score in console
                        // bowlingImpl.displayScoreBoard(bowl.getScBean().getTurns(), total_score);

                        if (logger.isDebugEnabled()) {
                            logger.info(defaultBundle.getString("sc.exiting.main.method"));
                        }
                    } else {
                        if (logger.isDebugEnabled()) {
                            logger.info(defaultBundle.getString("sc.input.invalid")); 
                        }
                    }

                }
            }

        } catch (NumberFormatException exp) {
            // TODO Auto-generated catch block
            if (logger.isDebugEnabled()) {
                logger.error(defaultBundle.getString("sc.numberFormatException"), exp);
                
            }
            throw new ScoreBowlingValidationException(ScoreBowlingConstants.GENERIC_VALIDATOR_ERROR_KEY,
                    exp.getMessage());
        } catch (NullPointerException exp) {
            // TODO Auto-generated catch block
            if (logger.isDebugEnabled()) {
                logger.error(defaultBundle.getString("sc.nullPointerException"), exp); 
            }
            throw new ScoreBowlingValidationException(ScoreBowlingConstants.GENERIC_VALIDATOR_ERROR_KEY,
                    exp.getMessage());
        } catch (MissingResourceException exp) {
            // TODO Auto-generated catch block
            if (logger.isDebugEnabled()) {
                logger.error(defaultBundle.getString("sc.missingResourceException"), exp); 
                
            }
            throw new ScoreBowlingValidationException(ScoreBowlingConstants.GENERIC_VALIDATOR_ERROR_KEY,
                    exp.getMessage());
        } finally {

            Iterator<Entry<String, String>> iterator = valErrorMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
            }
        }
    }

    /**
     * Fall pins method gets how many pins downed in the alley that to be placed in the exact frame cell.
     * 
     * @param p
     */
    public void fallPins(int p) {
        if (logger.isDebugEnabled()) {
            logger.info(defaultBundle.getString("sc.entering.fallPins.method")); 
        }
        getScBean().getTurns()[turn - 1] = p;
        if (p == 10 && turn % 2 == 1 && turn <= 18) {
            getScBean().getTurns()[turn] = 0;
            turn += 1;
        }
        turn += 1;
        if (logger.isDebugEnabled()) {
            logger.info(defaultBundle.getString("sc.exiting.fallPins.method")); 
        }
    }

    /**
     * The method ScoreBowlingConstants used to count strike and spare scores by iterating the frame set and calculate
     * the score based on the roll value it may be strike,spare or regular
     * 
     * @return
     */
    public int calculateScoreBoard(ScoreBowlingImpl bowlingImpl) {
        if (logger.isDebugEnabled()) {
            logger.info(defaultBundle.getString("sc.entering.calculateScoreBoard.method")); 
        }
        int totalScore = 0;
        int strikeOrSpareValue = 0;

        try {
            for (int i = 0; i < 20; i += 2) {
                int _stkOrSpare = getScBean().getTurns()[i];
                int _turn = getScBean().getTurns()[i + 1];

                if (_stkOrSpare == 10) {
                    strikeOrSpareValue = bowlingImpl.callStrike(i, getScBean());
                }

                else if (_stkOrSpare + _turn == 10) {
                    strikeOrSpareValue = bowlingImpl.callSpare(i, getScBean());
                }

                else {

                    if (_stkOrSpare != -1) {
                        strikeOrSpareValue += _stkOrSpare;
                    }

                    if (_turn != -1) {
                        strikeOrSpareValue += _turn;
                    }
                }

                totalScore += strikeOrSpareValue; 
                strikeOrSpareValue = 0;

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (logger.isDebugEnabled()) {
            logger.info(defaultBundle.getString("sc.exiting.calculateScoreBoard.method")); 
        }
        return totalScore;
    }

    //Setter getter
    public ScoreBowlingBean getScBean() {
        return scBean;
    }

    public void setScBean(ScoreBowlingBean scBean) {
        this.scBean = scBean;
    }

}
