// Generated from C:\Users\chris\Desktop\Projects\Compiler\src\compile\compilersource\myGrammar.g4 by ANTLR 4.5.3

package compile.compilersource;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link myGrammarParser}.
 */
public interface myGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#equation}.
	 * @param ctx the parse tree
	 */
	void enterEquation(myGrammarParser.EquationContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#equation}.
	 * @param ctx the parse tree
	 */
	void exitEquation(myGrammarParser.EquationContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(myGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(myGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyingExpression(myGrammarParser.MultiplyingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyingExpression(myGrammarParser.MultiplyingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void enterPowExpression(myGrammarParser.PowExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void exitPowExpression(myGrammarParser.PowExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(myGrammarParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(myGrammarParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#scientific}.
	 * @param ctx the parse tree
	 */
	void enterScientific(myGrammarParser.ScientificContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#scientific}.
	 * @param ctx the parse tree
	 */
	void exitScientific(myGrammarParser.ScientificContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(myGrammarParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(myGrammarParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#funcname}.
	 * @param ctx the parse tree
	 */
	void enterFuncname(myGrammarParser.FuncnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#funcname}.
	 * @param ctx the parse tree
	 */
	void exitFuncname(myGrammarParser.FuncnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#relop}.
	 * @param ctx the parse tree
	 */
	void enterRelop(myGrammarParser.RelopContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#relop}.
	 * @param ctx the parse tree
	 */
	void exitRelop(myGrammarParser.RelopContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(myGrammarParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(myGrammarParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(myGrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(myGrammarParser.VariableContext ctx);
}