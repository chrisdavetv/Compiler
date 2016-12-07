
package compile.compilersource;

import compile.compilersource.myGrammarParser.ParseContext;
import java.util.HashMap;
import java.util.Map;

public class EvalVisitor<T> extends myGrammarBaseVisitor<T> {
    Map<String, T> memory = new HashMap<String, T>();
    
    @Override public T visitParse(myGrammarParser.ParseContext ctx) { 
        return visitChildren(ctx); 
    }
	
    @Override public T visitBlock(myGrammarParser.BlockContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitStatement(myGrammarParser.StatementContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitAssignment(myGrammarParser.AssignmentContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitIdentifierFunctionCall(myGrammarParser.IdentifierFunctionCallContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitPrintlnFunctionCall(myGrammarParser.PrintlnFunctionCallContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitPrintFunctionCall(myGrammarParser.PrintFunctionCallContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitIfStatement(myGrammarParser.IfStatementContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitIfStat(myGrammarParser.IfStatContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitElseIfStat(myGrammarParser.ElseIfStatContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitElseStat(myGrammarParser.ElseStatContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitFunctionDecl(myGrammarParser.FunctionDeclContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitForStatement(myGrammarParser.ForStatementContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitWhileStatement(myGrammarParser.WhileStatementContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitIdList(myGrammarParser.IdListContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitExprList(myGrammarParser.ExprListContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitLtExpression(myGrammarParser.LtExpressionContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public T visitGtExpression(myGrammarParser.GtExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitBoolExpression(myGrammarParser.BoolExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitNotEqExpression(myGrammarParser.NotEqExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitNumberExpression(myGrammarParser.NumberExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitIdentifierExpression(myGrammarParser.IdentifierExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitModulusExpression(myGrammarParser.ModulusExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitNotExpression(myGrammarParser.NotExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitMultiplyExpression(myGrammarParser.MultiplyExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitGtEqExpression(myGrammarParser.GtEqExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitDivideExpression(myGrammarParser.DivideExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitOrExpression(myGrammarParser.OrExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitPowerExpression(myGrammarParser.PowerExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitEqExpression(myGrammarParser.EqExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitAndExpression(myGrammarParser.AndExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitStringExpression(myGrammarParser.StringExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitExpressionExpression(myGrammarParser.ExpressionExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitAddExpression(myGrammarParser.AddExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitSubtractExpression(myGrammarParser.SubtractExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitNullExpression(myGrammarParser.NullExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitFunctionCallExpression(myGrammarParser.FunctionCallExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitListExpression(myGrammarParser.ListExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitLtEqExpression(myGrammarParser.LtEqExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitTernaryExpression(myGrammarParser.TernaryExpressionContext ctx) { return visitChildren(ctx); }

    @Override public T visitList(myGrammarParser.ListContext ctx) { 
        return visitChildren(ctx); 
    }

    @Override public T visitIndexes(myGrammarParser.IndexesContext ctx) { return visitChildren(ctx); }
}