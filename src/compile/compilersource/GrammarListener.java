/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author chris
 */
public class GrammarListener implements myGrammarListener{

    @Override
    public void enterProg(myGrammarParser.ProgContext ctx) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitProg(myGrammarParser.ProgContext ctx) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterPrintExpr(myGrammarParser.PrintExprContext ctx) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitPrintExpr(myGrammarParser.PrintExprContext ctx) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterAssign(myGrammarParser.AssignContext ctx) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitAssign(myGrammarParser.AssignContext ctx) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterBlank(myGrammarParser.BlankContext ctx) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void exitBlank(myGrammarParser.BlankContext ctx){
    }

    @Override
    public void enterParens(myGrammarParser.ParensContext ctx) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitParens(myGrammarParser.ParensContext ctx) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterMulDiv(myGrammarParser.MulDivContext ctx) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitMulDiv(myGrammarParser.MulDivContext ctx) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterAddSub(myGrammarParser.AddSubContext ctx) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void exitAddSub(myGrammarParser.AddSubContext ctx){
    }
    
    @Override
    public void enterId(myGrammarParser.IdContext ctx){
    }
    
    @Override
    public void exitId(myGrammarParser.IdContext ctx){
    }
    
    @Override
    public void enterInt(myGrammarParser.IntContext ctx){
    }
    
    @Override
    public void exitInt(myGrammarParser.IntContext ctx){
    }

    @Override
    public void visitTerminal(TerminalNode tn) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitErrorNode(ErrorNode en) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterEveryRule(ParserRuleContext prc) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitEveryRule(ParserRuleContext prc) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
