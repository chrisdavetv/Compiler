/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author chris
 */
public class ErrorReporter {
    ArrayList<String> errorList = new ArrayList<String>();
    
    public ErrorReporter(){
        
    }
    public String GetTotalErrorString(){
        String totalErrors = "";
        String[] arr = errorList.toArray(new String[0]);
        for(int c = 0;c < arr.length;c++){
            System.out.println("Adding error "+arr[c]+" to printout string");
            totalErrors += arr[c]+"\n";
        }
        return totalErrors;
    }
    public String GetErrorAtPosition(int position){
        return errorList.toArray()[position].toString();
    }
    public void CreateErrorMessage(String message, Token startToken){
        String errMessage = MessageFormat.format(
                    "Exception! line {0}, char {2}: {1}", startToken.getLine(), message, startToken.getCharPositionInLine());
        errorList.add(errMessage);
        //return errMessage;
    }
    public Boolean ReportErrorIfIsErrorMessage(String message){
        if(message.toLowerCase().contains("exception!")){
            errorList.add(message);
            return true;
        }
        return false;
    }
}
