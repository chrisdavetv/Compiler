/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource;

import java.text.MessageFormat;
import java.util.BitSet;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

/**
 *
 * @author chris
 */
public class AntlrErrorListener implements ANTLRErrorListener{

    String mainErrorString = "";
    public String GetAllErrorMessages(){
        return mainErrorString;
    }
    
    /*@Override
    public void syntaxError(Recognizer<?, ?> rcgnzr, Object o, int i, int i1, String string, RecognitionException re) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(
                MessageFormat.format("caught a syntax error: string:{0}, i:{1}, i:{2}, o:{3} ", string, i, i1)
        );
        mainErrorString += "\n"+MessageFormat.format("Caught syntax error at line {1}, char {2}: {0}", string, i - 1, i1);
    }*/
    
    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer, Object o,
            int line, int charPositionInLine, String msg, RecognitionException e) {
        String sourceName = recognizer.getInputStream().getSourceName();
        sourceName = !sourceName.isEmpty() ? sourceName+": " : "";
        mainErrorString += sourceName+"line "+line+":"+charPositionInLine+" "+msg + "\n";
    }

    @Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean bln, BitSet bitset, ATNConfigSet atncs) {
        System.out.println("reportAmbiguity triggered"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitset, ATNConfigSet atncs) {
        System.out.println("reportAttemptingFullContext triggered");  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atncs) {
        System.out.println("reportContextSensitivity triggered"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
