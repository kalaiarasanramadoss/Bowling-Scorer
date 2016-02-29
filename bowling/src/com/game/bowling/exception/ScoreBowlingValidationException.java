/**
 * 
 */
package com.game.bowling.exception;

/**
 * @author KR00357908
 *
 */
public class ScoreBowlingValidationException extends Exception{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String mErrorKey;

    public ScoreBowlingValidationException(String pExceptionMsg) {
        super(pExceptionMsg);
    }
    
  //Setting exception with error key and exception message
    public ScoreBowlingValidationException(String pErrorKey, String pExceptionMsg) {
        super(pExceptionMsg);
        this.mErrorKey = pErrorKey;     
    }
    
  //Setting exception with error key and source exception
    public ScoreBowlingValidationException(String pErrorKey, Throwable pSourceException) {
        super(pSourceException);
        this.mErrorKey = pErrorKey;     
    }
    
    /**
     * @param mErrorKey The mErrorKey to set.
     */
    public void setErrorKey(String mErrorKey) {
        this.mErrorKey = mErrorKey;
    }

    /**
     * @return Returns the mErrorKey.
     */
    public String getErrorKey() {
        return mErrorKey;
    }
    
    

}
