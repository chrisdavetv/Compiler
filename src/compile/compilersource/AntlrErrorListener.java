/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource;

import compile.compiler.CompilerUI;
import compile.compilersource.symboltable.ErrorRepository;
import java.awt.Color;
import java.util.BitSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

/**
 *
 * @author chris
 */
public class AntlrErrorListener implements ANTLRErrorListener{
    
    private final static String TAG = "AntlrErrorListener";
    String mainErrorString = "";
    CompilerUI ui;
    private static AntlrErrorListener sharedInstance = null;
    private boolean successful = true;
    
    public static AntlrErrorListener getInstance() {
            return sharedInstance;
    }
 
    public AntlrErrorListener(CompilerUI ui){
        super();
        this.ui = ui;
    }
    
    public AntlrErrorListener(){}
    
    public static void initialize() {
            sharedInstance = new AntlrErrorListener();
            ErrorRepository.initialize();
    }
    
    public String GetAllErrorMessages(){
        return mainErrorString;
    }
    
    public static void reset() {
            sharedInstance.successful  = true;
            ErrorRepository.reset();
    }
    
    public boolean canExecute() {
            return this.successful;
    }
    
    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer, Object o,
            int line, int charPositionInLine, String msg, RecognitionException e) {
        
        System.out.println("In syntaxError");
        
        String sourceName = recognizer.getInputStream().getSourceName();
        sourceName = !sourceName.isEmpty() ? sourceName+": " : "";
        mainErrorString += sourceName+"line "+line+":"+charPositionInLine+" "+msg + "\n";
        
        highlightErrorLine(line);
    }
    
    public void highlightErrorLine(int line){
        line -= 1;
        
        if(ui.getEditor() != null){
            System.out.println("Editor ready");
            
            try{
                int offset = ui.getEditor().getLineStartOffset(line);
                int endOffset = ui.getEditor().getLineEndOffset(line);
                Highlighter highlighter = ui.getEditor().getHighlighter();
                highlighter.addHighlight(offset, endOffset, new DefaultHighlighter.DefaultHighlightPainter(Color.RED));
            }catch(BadLocationException ex){
                System.out.println("Syntax highlight error: " + ex.getMessage());
            }
        }else System.out.println("Syntax highlight error: editor cannot be accessed");
    }

    @Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean bln, BitSet bitset, ATNConfigSet atncs) {
        System.out.println("reportAmbiguity triggered"); //To change body of generated methods, choose Tools | Templates.
        highlightErrorLine(1);
    }

    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitset, ATNConfigSet atncs) {
        System.out.println("reportAttemptingFullContext triggered");  //To change body of generated methods, choose Tools | Templates.
        highlightErrorLine(1);
    }

    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atncs) {
        System.out.println("reportContextSensitivity triggered"); //To change body of generated methods, choose Tools | Templates.
        highlightErrorLine(1);
    }
    
    public static void reportCustomError(int errorCode, String additionalMessage) {
            String errorMessage = ErrorRepository.getErrorMessage(errorCode) + " " + additionalMessage;
            //Console.log(LogType.ERROR, errorMessage);

            sharedInstance.successful = false;
    }

    public static void reportCustomError(int errorCode, String additionalMessage, Object... parameters) {
            String errorMessage = String.format(ErrorRepository.getErrorMessage(errorCode) + " " + additionalMessage, parameters);
            //Console.log(LogType.ERROR, errorMessage);

            sharedInstance.successful = false;
    }
    
}
