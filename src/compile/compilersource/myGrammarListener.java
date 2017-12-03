// Generated from myGrammar.g4 by ANTLR 4.5.3

package compile.compilersource;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link myGrammarParser}.
 */
public interface myGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(myGrammarParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(myGrammarParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#functionBlock}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBlock(myGrammarParser.FunctionBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#functionBlock}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBlock(myGrammarParser.FunctionBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(myGrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(myGrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(myGrammarParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(myGrammarParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(myGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(myGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(myGrammarParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(myGrammarParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#identifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierDeclaration(myGrammarParser.IdentifierDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#identifierDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierDeclaration(myGrammarParser.IdentifierDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link myGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierFunctionCall(myGrammarParser.IdentifierFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierFunctionCall}
	 * labeled alternative in {@link myGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierFunctionCall(myGrammarParser.IdentifierFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printlnFunctionCall}
	 * labeled alternative in {@link myGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintlnFunctionCall(myGrammarParser.PrintlnFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printlnFunctionCall}
	 * labeled alternative in {@link myGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintlnFunctionCall(myGrammarParser.PrintlnFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link myGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintFunctionCall(myGrammarParser.PrintFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printFunctionCall}
	 * labeled alternative in {@link myGrammarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintFunctionCall(myGrammarParser.PrintFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(myGrammarParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(myGrammarParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(myGrammarParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(myGrammarParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStat(myGrammarParser.ElseIfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#elseIfStat}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStat(myGrammarParser.ElseIfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void enterElseStat(myGrammarParser.ElseStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void exitElseStat(myGrammarParser.ElseStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(myGrammarParser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(myGrammarParser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#tryStat}.
	 * @param ctx the parse tree
	 */
	void enterTryStat(myGrammarParser.TryStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#tryStat}.
	 * @param ctx the parse tree
	 */
	void exitTryStat(myGrammarParser.TryStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#catchStat}.
	 * @param ctx the parse tree
	 */
	void enterCatchStat(myGrammarParser.CatchStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#catchStat}.
	 * @param ctx the parse tree
	 */
	void exitCatchStat(myGrammarParser.CatchStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#finallyStat}.
	 * @param ctx the parse tree
	 */
	void enterFinallyStat(myGrammarParser.FinallyStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#finallyStat}.
	 * @param ctx the parse tree
	 */
	void exitFinallyStat(myGrammarParser.FinallyStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(myGrammarParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(myGrammarParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(myGrammarParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(myGrammarParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(myGrammarParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(myGrammarParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(myGrammarParser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(myGrammarParser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(myGrammarParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(myGrammarParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#paramIdList}.
	 * @param ctx the parse tree
	 */
	void enterParamIdList(myGrammarParser.ParamIdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#paramIdList}.
	 * @param ctx the parse tree
	 */
	void exitParamIdList(myGrammarParser.ParamIdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(myGrammarParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(myGrammarParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gtExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGtExpression(myGrammarParser.GtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gtExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGtExpression(myGrammarParser.GtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(myGrammarParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(myGrammarParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(myGrammarParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(myGrammarParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modulusExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterModulusExpression(myGrammarParser.ModulusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modulusExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitModulusExpression(myGrammarParser.ModulusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(myGrammarParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(myGrammarParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplyExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExpression(myGrammarParser.MultiplyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplyExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExpression(myGrammarParser.MultiplyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gtEqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGtEqExpression(myGrammarParser.GtEqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gtEqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGtEqExpression(myGrammarParser.GtEqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(myGrammarParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(myGrammarParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(myGrammarParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(myGrammarParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionExpression(myGrammarParser.ExpressionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionExpression(myGrammarParser.ExpressionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNullExpression(myGrammarParser.NullExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNullExpression(myGrammarParser.NullExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(myGrammarParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(myGrammarParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayLengthExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayLengthExpression(myGrammarParser.ArrayLengthExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayLengthExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayLengthExpression(myGrammarParser.ArrayLengthExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterListExpression(myGrammarParser.ListExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitListExpression(myGrammarParser.ListExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltEqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLtEqExpression(myGrammarParser.LtEqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltEqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLtEqExpression(myGrammarParser.LtEqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLtExpression(myGrammarParser.LtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLtExpression(myGrammarParser.LtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpression(myGrammarParser.ArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpression(myGrammarParser.ArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(myGrammarParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(myGrammarParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notEqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotEqExpression(myGrammarParser.NotEqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notEqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotEqExpression(myGrammarParser.NotEqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divideExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivideExpression(myGrammarParser.DivideExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divideExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivideExpression(myGrammarParser.DivideExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(myGrammarParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(myGrammarParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powerExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExpression(myGrammarParser.PowerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powerExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExpression(myGrammarParser.PowerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpression(myGrammarParser.EqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpression(myGrammarParser.EqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(myGrammarParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(myGrammarParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subtractExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubtractExpression(myGrammarParser.SubtractExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subtractExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubtractExpression(myGrammarParser.SubtractExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(myGrammarParser.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternaryExpression}
	 * labeled alternative in {@link myGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(myGrammarParser.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(myGrammarParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(myGrammarParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#indexes}.
	 * @param ctx the parse tree
	 */
	void enterIndexes(myGrammarParser.IndexesContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#indexes}.
	 * @param ctx the parse tree
	 */
	void exitIndexes(myGrammarParser.IndexesContext ctx);
}