// Generated from C:\Users\chris\Desktop\Projects\Compiler\src\compile\compilersource\myGrammar.g4 by ANTLR 4.5.3

package compile.compilersource;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link myGrammarParser}.
 */
public interface myGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompileUnit(myGrammarParser.CompileUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompileUnit(myGrammarParser.CompileUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInfixExpr(myGrammarParser.InfixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInfixExpr(myGrammarParser.InfixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(myGrammarParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(myGrammarParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(myGrammarParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(myGrammarParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(myGrammarParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(myGrammarParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(myGrammarParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(myGrammarParser.ParensExprContext ctx);
}