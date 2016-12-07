// Generated from /Users/chris/Desktop/Projects/Compiler/src/compile/compilersource/myGrammar.g4 by ANTLR 4.5.3

package compile.compilersource;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link myGrammarParser}.
 */
public interface myGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(myGrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(myGrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link myGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(myGrammarParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link myGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(myGrammarParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link myGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(myGrammarParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link myGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(myGrammarParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link myGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(myGrammarParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link myGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(myGrammarParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(myGrammarParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(myGrammarParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(myGrammarParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(myGrammarParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(myGrammarParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(myGrammarParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(myGrammarParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(myGrammarParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(myGrammarParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link myGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(myGrammarParser.IntContext ctx);
}