/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource;
import java.awt.Color;
import java.text.MessageFormat;
import java.util.ArrayList;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import org.antlr.v4.runtime.Token;

import compile.compiler.CompilerUI;

/**
 *
 * @author chris
 */
public class ErrorReporter {
    ArrayList<String> errorList = new ArrayList<String>();
    myGrammarParser.BlockContext blockCtx;
    CompilerUI ui;
    
    public ErrorReporter(CompilerUI ui){
    	 this.ui = ui;
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
        
        if(ui.getEditor() != null){            
            try{
                int offset = ui.getEditor().getLineStartOffset(startToken.getLine()-1);
                int endOffset = ui.getEditor().getLineEndOffset(startToken.getLine()-1);
                Highlighter highlighter = ui.getEditor().getHighlighter();
                highlighter.addHighlight(offset, endOffset, new DefaultHighlighter.DefaultHighlightPainter(Color.RED));
            }catch(BadLocationException ex){
                System.out.println("Semantic highlight error: " + ex.getMessage());
            }
        }else System.out.println("Semantic error: editor cannot be accessed");
        
        
    }
    public Boolean ReportErrorIfIsErrorMessage(String message){
        if(message.toLowerCase().contains("exception!")){
            errorList.add(message);
            return true;
        }
        return false;
    }
}
