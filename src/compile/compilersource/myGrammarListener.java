// Generated from /Users/chris/Desktop/Projects/Compiler/src/compile/compilersource/myGrammar.g4 by ANTLR 4.5.3

package compile.compilersource;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link myGrammarParser}.
 */
public interface myGrammarListener extends ParseTreeListener {
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
}