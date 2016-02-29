package com.game.bowling.Imp;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.game.bowling.action.ScoreBowling;
import com.game.bowling.bean.ScoreBowlingBean;
import com.game.bowling.inf.ScoreBowlingInf;

/**
 * ScoreBowlingImpl gives implementation for all the methods
 * 
 * @author KR00357908
 * 
 */
abstract class ScoreBowlingImplAbst  {

    abstract int callSpare(int turn, ScoreBowlingBean scBean);
    
}

public class ScoreBowlingImpl extends ScoreBowlingImplAbst implements ScoreBowlingInf, Serializable {

    static Logger logger = Logger.getLogger(ScoreBowling.class);
    static Locale defaultLocale = Locale.getDefault();
    static ResourceBundle defaultBundle  = ResourceBundle.getBundle("RBundle", defaultLocale);

    /**
     * This method called when strike point is found in the score card
     */
    @Override
    public int callStrike(int turn, ScoreBowlingBean scBean) {
        // TODO Auto-generated method stub
        if (logger.isDebugEnabled()) {
            logger.info(defaultBundle.getString("sc.entering.callStrike.method"));
        }

        int value = 0;
        try {
            // Strike on the 10th frame
            if (turn == 18) {
                return scBean.getTurns()[19] + scBean.getTurns()[20] + 10;
            }

            int _stkOrSpare = scBean.getTurns()[turn + 2];
            int _turn = scBean.getTurns()[turn + 3];
            int _used = scBean.getTurns()[turn];

            
            if ((_stkOrSpare == 10 && _used == -1) || (_stkOrSpare < 10 && _turn == -1)) {
                return 0;
            } 
            value += _stkOrSpare;

            if (_stkOrSpare == 10) {
                value += _used;
            } 
            else {//Regular add
                value += _turn;
            } 

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (logger.isDebugEnabled()) {
            logger.info(defaultBundle.getString("sc.exiting.callStrike.method"));
        }

        return value + 10; 
    }

    /**
     * 
     */
    @Override
    public int callSpare(int turn, ScoreBowlingBean scBean) {
        // TODO Auto-generated method stub

        if (logger.isDebugEnabled()) {
            logger.info(defaultBundle.getString("sc.entering.method.callSpare"));
        }

        int _stkOrSpare = 0;
        try {
             // the first one of the next frame
            _stkOrSpare = scBean.getTurns()[turn + 2]; 
            if (_stkOrSpare == -1) {
                return 0;
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.debug("ScoreBowlingImpl Method:Call spare  ", e);

        }
        if (logger.isDebugEnabled()) {
            logger.info(defaultBundle.getString("sc.exiting.callSpare.method"));
        }
        return 10 + _stkOrSpare;

    }

   

    /**
     * Resource here we can localize based on the country
     * 
     * @return
     */
    /*@Override
    public ResourceBundle loadResource() {
        Locale defaultLocale = Locale.getDefault();
         defaultBundle = ResourceBundle.getBundle("RBundle", defaultLocale);
        return defaultBundle;
    }*/
    

}
