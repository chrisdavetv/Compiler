/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.IntervalSet;

/**
 *
 * @author chris
 */
public class ExceptionErrorStrategy extends DefaultErrorStrategy {
    
    String totalErrorString = "";
    public String getTotalErrorString(){
        return totalErrorString;
    }
    
    /*@Override
    public void recover(Parser recognizer, RecognitionException e) {
        throw e;
    }*/

    @Override
    public void reportInputMismatch(Parser recognizer, InputMismatchException e) throws RecognitionException {
        String msg = "mismatched input: " + getTokenErrorDisplay(e.getOffendingToken());
        msg += " expecting one of "+e.getExpectedTokens().toString(recognizer.getTokenNames());
        totalErrorString += msg + "\n";
        RecognitionException ex = new RecognitionException(msg, recognizer, recognizer.getInputStream(), recognizer.getContext());
        ex.initCause(e);
        throw ex;
        //super.reportInputMismatch(recognizer, e);
    }

    @Override
    public void reportMissingToken(Parser recognizer) {
        beginErrorCondition(recognizer);
        Token t = recognizer.getCurrentToken();
        IntervalSet expecting = getExpectedTokens(recognizer);
        String msg = "missing "+expecting.toString(recognizer.getTokenNames()) + " at " + getTokenErrorDisplay(t);
        totalErrorString += msg + "\n";
        throw new RecognitionException(msg, recognizer, recognizer.getInputStream(), recognizer.getContext());
    }
}
