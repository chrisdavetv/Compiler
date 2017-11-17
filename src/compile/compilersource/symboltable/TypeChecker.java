/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource.symboltable;

import compile.compilersource.AntlrErrorListener;
import compile.compilersource.myGrammarParser.ExpressionContext;
import compile.compilersource.symboltable.Value.PrimitiveType;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author chris
 */
public class TypeChecker implements IErrorChecker, ParseTreeListener {
    private final static String TAG = "_TypeChecker";

    private Value value;
    private ExpressionContext exprCtx;
    private int lineNumber;

    public TypeChecker(Value assignmentValue, ExpressionContext exprCtx) {
            this.value = assignmentValue;
            this.exprCtx = exprCtx;

            Token firstToken = exprCtx.getStart();
            this.lineNumber = firstToken.getLine();
    }

    @Override
    public void verify() {
            ParseTreeWalker treeWalker = new ParseTreeWalker();
            treeWalker.walk(this, this.exprCtx);
    }

    public static boolean isNumeric(String str) {
      return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    @Override
    public void visitTerminal(TerminalNode node) {

    }

    @Override
    public void visitErrorNode(ErrorNode node) {
            // TODO Auto-generated method stub

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
            if(ctx instanceof LiteralContext) {//need to replace literalcontext with our grammar version of a literal
                    if(this.value == null) {
                            return;
                    }
                    LiteralContext literalCtx = (LiteralContext) ctx;
                    String expressionString = literalCtx.getText();

                    if(this.value.getPrimitiveType() == PrimitiveType.ARRAY) {

                    }
                    else if(this.value.getPrimitiveType() == PrimitiveType.BOOLEAN) {
                            if(literalCtx.BooleanLiteral() == null) {
                                    String additionalMessage = "Expected boolean.";
                                    AntlrErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                            }
                    }
                    else if(this.value.getPrimitiveType() == PrimitiveType.INT) {
                            if(literalCtx.IntegerLiteral() == null) {
                                    String additionalMessage = "Expected int.";
                                    AntlrErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                            }
                    }
                    else if(this.value.getPrimitiveType() == PrimitiveType.FLOAT || this.value.getPrimitiveType() == PrimitiveType.DOUBLE) {
                            if(literalCtx.FloatingPointLiteral() == null) {
                                    String additionalMessage = "Expected floating point or double.";
                                    AntlrErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                            }
                    }

                    else if(this.value.getPrimitiveType() == PrimitiveType.STRING) {
                            if(expressionString.charAt(0) != '\"' && expressionString.charAt(expressionString.length() - 1) != '\"') {
                                    String additionalMessage = "Expected string.";
                                    AntlrErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                            }

                            else if(literalCtx.StringLiteral() == null) {
                                    String additionalMessage = "Expected string.";
                                    AntlrErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                            }
                    }
            }
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
            // TODO Auto-generated method stub

    }
}
