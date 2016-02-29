package com.game.bowling.utils;

import java.util.Map;

import com.game.bowling.constants.ScoreBowlingConstants;
import com.game.bowling.exception.ScoreBowlingValidationException;

public class ScoreBowlingValidation {
    
    
    /**
     * 
     * @param strValue
     * @param pValErrorMap
     * @throws ScoreBowlingValidationException
     */
    
    public  Map<String, String> validateInput(String pStrValue, Map<String, String> pValErrorMap) {
         
         if(null!=pValErrorMap){
             
                 if(pStrValue.trim().isEmpty()){
                 pValErrorMap.put(ScoreBowlingConstants.EMPTY_INPUT_ERROR_KEY, ScoreBowlingConstants.INPUT_CONTAINS_ONLY_EMPTY_SPACE);
             }
         } 
         return pValErrorMap;
    }
     
 /**
  * This is method validate weather the Resource Bundle found or not 
  * @param value
  * @param pValErrorMap
  * @throws ScoreBowlingValidationException
  */
 public  Map<String, String> validateInput(Object pValue, Map<String, String> pValErrorMap) {
         
         if(null!=pValErrorMap){
             if(null==pValue){
                     pValErrorMap.put(ScoreBowlingConstants.BUNDLE_NOT_FOUND, ScoreBowlingConstants.BUNDLE_NOT_FOUND);
             }
         } 
         return pValErrorMap;
    }
 
 
 public boolean validateInput(String strValue){
     
     String truns[] = strValue.split(" ");
     boolean result=false;
     if(!truns.toString().trim().isEmpty()){

            for (int i = 0; i < truns.length; i++) {
                 //result = Integer.parseInt(truns[i].trim()) > 11 ? true : false;
                if(Integer.parseInt(truns[i].trim()) > 10){
                     result=true;
                     break;
                }
                
                 
            }

        }
     
     return result;
     
 }
     

 }
      
    


