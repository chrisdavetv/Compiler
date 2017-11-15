// Generated from myGrammar.g4 by ANTLR 4.4

package compile.compilersource;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link myGrammarParser}.
 */
public interface myGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(@NotNull myGrammarParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(@NotNull myGrammarParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStat(@NotNull myGrammarParser.ElseIfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStat(@NotNull myGrammarParser.ElseIfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gtExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGtExpression(@NotNull myGrammarParser.GtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gtExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGtExpression(@NotNull myGrammarParser.GtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void enterElseStat(@NotNull myGrammarParser.ElseStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void exitElseStat(@NotNull myGrammarParser.ElseStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(@NotNull myGrammarParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(@NotNull myGrammarParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(@NotNull myGrammarParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(@NotNull myGrammarParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modulusExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterModulusExpression(@NotNull myGrammarParser.ModulusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modulusExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitModulusExpression(@NotNull myGrammarParser.ModulusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#identifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierDeclaration(@NotNull myGrammarParser.IdentifierDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#identifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierDeclaration(@NotNull myGrammarParser.IdentifierDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(@NotNull myGrammarParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(@NotNull myGrammarParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(@NotNull myGrammarParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(@NotNull myGrammarParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplyExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExpression(@NotNull myGrammarParser.MultiplyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplyExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExpression(@NotNull myGrammarParser.MultiplyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link myGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierFunctionCall(@NotNull myGrammarParser.IdentifierFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link myGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierFunctionCall(@NotNull myGrammarParser.IdentifierFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gtEqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGtEqExpression(@NotNull myGrammarParser.GtEqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gtEqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGtEqExpression(@NotNull myGrammarParser.GtEqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(@NotNull myGrammarParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(@NotNull myGrammarParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(@NotNull myGrammarParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(@NotNull myGrammarParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionExpression(@NotNull myGrammarParser.ExpressionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionExpression(@NotNull myGrammarParser.ExpressionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#indexes}.
	 * @param ctx the parse tree
	 */
	void enterIndexes(@NotNull myGrammarParser.IndexesContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#indexes}.
	 * @param ctx the parse tree
	 */
	void exitIndexes(@NotNull myGrammarParser.IndexesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNullExpression(@NotNull myGrammarParser.NullExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNullExpression(@NotNull myGrammarParser.NullExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull myGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull myGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(@NotNull myGrammarParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(@NotNull myGrammarParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull myGrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull myGrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterListExpression(@NotNull myGrammarParser.ListExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitListExpression(@NotNull myGrammarParser.ListExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltEqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLtEqExpression(@NotNull myGrammarParser.LtEqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltEqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLtEqExpression(@NotNull myGrammarParser.LtEqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(@NotNull myGrammarParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(@NotNull myGrammarParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLtExpression(@NotNull myGrammarParser.LtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLtExpression(@NotNull myGrammarParser.LtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpression(@NotNull myGrammarParser.ArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpression(@NotNull myGrammarParser.ArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(@NotNull myGrammarParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(@NotNull myGrammarParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notEqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotEqExpression(@NotNull myGrammarParser.NotEqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notEqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotEqExpression(@NotNull myGrammarParser.NotEqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull myGrammarParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull myGrammarParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(@NotNull myGrammarParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(@NotNull myGrammarParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(@NotNull myGrammarParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(@NotNull myGrammarParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(@NotNull myGrammarParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(@NotNull myGrammarParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(@NotNull myGrammarParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(@NotNull myGrammarParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#paramIdList}.
	 * @param ctx the parse tree
	 */
	void enterParamIdList(@NotNull myGrammarParser.ParamIdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#paramIdList}.
	 * @param ctx the parse tree
	 */
	void exitParamIdList(@NotNull myGrammarParser.ParamIdListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divideExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivideExpression(@NotNull myGrammarParser.DivideExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divideExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivideExpression(@NotNull myGrammarParser.DivideExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(@NotNull myGrammarParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(@NotNull myGrammarParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(@NotNull myGrammarParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(@NotNull myGrammarParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powerExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExpression(@NotNull myGrammarParser.PowerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powerExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExpression(@NotNull myGrammarParser.PowerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpression(@NotNull myGrammarParser.EqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpression(@NotNull myGrammarParser.EqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printlnFunctionCall}
	 * labeled alternative in {@link myGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintlnFunctionCall(@NotNull myGrammarParser.PrintlnFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printlnFunctionCall}
	 * labeled alternative in {@link myGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintlnFunctionCall(@NotNull myGrammarParser.PrintlnFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(@NotNull myGrammarParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(@NotNull myGrammarParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subtractExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubtractExpression(@NotNull myGrammarParser.SubtractExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subtractExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubtractExpression(@NotNull myGrammarParser.SubtractExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(@NotNull myGrammarParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(@NotNull myGrammarParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(@NotNull myGrammarParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(@NotNull myGrammarParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link myGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintFunctionCall(@NotNull myGrammarParser.PrintFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link myGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintFunctionCall(@NotNull myGrammarParser.PrintFunctionCallContext ctx);
}