/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource;

import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 *
 * @author chris
 */
public class BaseErrorListenerExtension extends BaseErrorListener{
    
    private String allErrorMessages = "";
    public String GetAllErrorMessages(){
        return allErrorMessages;
    }
    public List<String> ErrorMessagesList = new CopyOnWriteArrayList<String>();
    
    @Override
    public void syntaxError( Recognizer<?, ?> rcgnzr, Object o, int i, int i1, String string, RecognitionException re) {
        String errorMessage = MessageFormat.format("Caught syntax error at line {1}, char {2}: {0}", string, i - 1, i1);
        System.out.println(errorMessage);
        allErrorMessages += "\n"+errorMessage;
        ErrorMessagesList.add(errorMessage);
   }
}
