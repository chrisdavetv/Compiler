package compile.compilersource;

import compile.compilersource.myGrammarParser.ExpressionContext;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.tree.ParseTree;

public class EvalVisitor<T> extends myGrammarBaseVisitor<T> {

    Map<String, T> memory = new HashMap<String, T>();
    
    ErrorReporter VisitorErrorReporter;
    
    public EvalVisitor(ErrorReporter errorReporter){
        super();
        VisitorErrorReporter = errorReporter;
    }
    
    enum MathOpType {
        ADD, SUB, MULT, DIV, POW, MOD
    }
    enum NumberComparisonType{
        GREATEREQUAL, GREATER, LESSEQUAL, LESS, EQUAL, NOTEQUAL
    }

    String decideOperator(MathOpType type) {
        return type.equals(MathOpType.ADD) ? "+"
                : type.equals(MathOpType.SUB) ? "-"
                : type.equals(MathOpType.DIV) ? "/"
                : type.equals(MathOpType.POW) ? "^"
                : type.equals(MathOpType.MOD) ? "%"
                : "";
    }

    Double CalculateValue(Double aggregateValue, ParseTree child, MathOpType type) {
        return type.equals(MathOpType.ADD) ? aggregateValue += Double.parseDouble(visit(child).toString())
                : type.equals(MathOpType.SUB) ? aggregateValue -= Double.parseDouble(visit(child).toString())
                : type.equals(MathOpType.DIV) ? aggregateValue /= Double.parseDouble(visit(child).toString())
                : type.equals(MathOpType.POW) ? aggregateValue = Math.pow(aggregateValue, Double.parseDouble(visit(child).toString())) :
                type.equals(MathOpType.MOD) ? aggregateValue %= Double.parseDouble(visit(child).toString())
                : null;
    }
    
    T Calculate(ExpressionContext ctx, MathOpType type) {
        Double result = 0.0;
        int numberOfChildren = ctx.getChildCount();
        String operatorString = decideOperator(type);
        try {
            System.out.println(numberOfChildren + " children in Expression");
            for (int c = 0; c < numberOfChildren; c++) {
                ParseTree child = ctx.getChild(c);
                if (!child.getText().equals(operatorString)) {
                    if (c == 0) {
                        result = Double.parseDouble(visit(child).toString());
                    } else {
                        result = CalculateValue(result, child, type);///= Double.parseDouble(visit(child).toString());
                    }
                }
                System.out.println("found a " + operatorString + " sign at position" + c);
            }
            System.out.println("Expression returning: " + (T) result.toString());
        } catch (NullPointerException ne) {
            VisitorErrorReporter.CreateErrorMessage("operator can only be applied to type Number", 
                    ctx.getAltNumber());
            return (T)"";
        }
        return (T) result.toString();
    }
    
    String decideComparison(ExpressionContext ctx, NumberComparisonType type){
        return type.equals(NumberComparisonType.EQUAL) ? 
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) == 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
               type.equals(NumberComparisonType.GREATER) ?
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) > 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
               type.equals(NumberComparisonType.GREATEREQUAL) ?
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) >= 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
               type.equals(NumberComparisonType.LESS) ?
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) < 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
               type.equals(NumberComparisonType.LESSEQUAL) ?
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) <= 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
               type.equals(NumberComparisonType.NOTEQUAL) ?
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) != 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
                String.valueOf(Boolean.parseBoolean(""))//will cause exception
                ;
    }
    
    T CompareNumbers(ExpressionContext ctx, NumberComparisonType type){
        int numberOfChildren = ctx.getChildCount();
        String result = "";
        System.out.println(numberOfChildren + " children in Expression");
        /*for(int c = 0;c < numberOfChildren;c++){
            System.out.println("child at "+c+" has text "+ctx.getChild(c).getText());
        }*/
        try{
            result = decideComparison(ctx, type);
        }catch(Exception e){
            System.out.println("error in visitGtEqExpression of type: "+e.getMessage());
            VisitorErrorReporter.CreateErrorMessage(e.getMessage()+" - please check expressions on both sides of your comparison operators", ctx.getAltNumber());
            result = "";
        }
        return (T)result;
    }

    @Override
    public T aggregateResult(T aggregate, T nextResult) {
        if (aggregate == null) {
            return nextResult;
        }

        if (nextResult == null) {
            return (T) aggregate;
        }

        StringBuilder sb = new StringBuilder(aggregate.toString());
        sb.append(" ");
        sb.append(nextResult);

        return (T) sb.toString();
    }

    @Override
    public T visitParse(myGrammarParser.ParseContext ctx) {
        //in here goes error checking, etc - in antlr3, all the code previously mixed in the grammar goes here
        T result = (T) visitChildren(ctx);
        System.out.println("visitParse result: " + result);
        return result;
    }

    @Override
    public T visitBlock(myGrammarParser.BlockContext ctx) {
        T result = (T) visitChildren(ctx);
        System.out.println("visitBlock result: " + result);
        return result;
    }

    @Override
    public T visitStatement(myGrammarParser.StatementContext ctx) {
        T result = (T) visitChildren(ctx);
        System.out.println("visitStatement result: " + result);
        return result;
    }

    @Override
    public T visitAssignment(myGrammarParser.AssignmentContext ctx) {
        System.out.println("In visitAssignment");
        return visitChildren(ctx);
    }

    @Override
    public T visitIdentifierFunctionCall(myGrammarParser.IdentifierFunctionCallContext ctx) {
        System.out.println("In visitIdentifierFunctionCall");
        return visitChildren(ctx);
    }

    @Override
    public T visitPrintlnFunctionCall(myGrammarParser.PrintlnFunctionCallContext ctx) {
        System.out.println("In VisitPrintlnFunctionCall: " + ctx.getText());
        T result = (T) (visitChildren(ctx).toString() + "\n");
        System.out.println("Writing a new line, result: " + result);
        return result;
    }

    @Override
    public T visitPrintFunctionCall(myGrammarParser.PrintFunctionCallContext ctx) {
        System.out.println("In visitPrintFunctionCall");
        return visitChildren(ctx);
    }

    @Override
    public T visitIfStatement(myGrammarParser.IfStatementContext ctx) {
        System.out.println("In visitIfStatement");
        return visitChildren(ctx);
    }

    @Override
    public T visitIfStat(myGrammarParser.IfStatContext ctx) {
        System.out.println("In visitIfStat");
        return visitChildren(ctx);
    }

    @Override
    public T visitElseIfStat(myGrammarParser.ElseIfStatContext ctx) {
        System.out.println("In visitElseIfStat");
        return visitChildren(ctx);
    }

    @Override
    public T visitElseStat(myGrammarParser.ElseStatContext ctx) {
        System.out.println("In visitElseStat");
        return visitChildren(ctx);
    }

    @Override
    public T visitFunctionDecl(myGrammarParser.FunctionDeclContext ctx) {
        System.out.println("In visitFunctionDecl");
        return visitChildren(ctx);
    }

    @Override
    public T visitForStatement(myGrammarParser.ForStatementContext ctx) {
        System.out.println("In visitForStatement");
        return visitChildren(ctx);
    }

    @Override
    public T visitWhileStatement(myGrammarParser.WhileStatementContext ctx) {
        System.out.println("In visitWhileStatement");
        return visitChildren(ctx);
    }

    @Override
    public T visitIdList(myGrammarParser.IdListContext ctx) {
        System.out.println("In visitIdList");
        return visitChildren(ctx);
    }

    @Override
    public T visitExprList(myGrammarParser.ExprListContext ctx) {
        System.out.println("In visitExprList");
        return visitChildren(ctx);
    }

    @Override
    public T visitLtExpression(myGrammarParser.LtExpressionContext ctx) {
        return CompareNumbers(ctx, NumberComparisonType.LESS);
    }

    @Override
    public T visitGtExpression(myGrammarParser.GtExpressionContext ctx) {
        return CompareNumbers(ctx, NumberComparisonType.GREATER);
    }

    @Override
    public T visitBoolExpression(myGrammarParser.BoolExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitNotEqExpression(myGrammarParser.NotEqExpressionContext ctx) {
        return CompareNumbers(ctx, NumberComparisonType.NOTEQUAL);
    }

    @Override
    public T visitNumberExpression(myGrammarParser.NumberExpressionContext ctx) {
        String number = ctx.getText();
        System.out.println("in visitNumberExpression: " + number);
        return (T) number;
    }

    @Override
    public T visitIdentifierExpression(myGrammarParser.IdentifierExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitModulusExpression(myGrammarParser.ModulusExpressionContext ctx) {
        T result = Calculate(ctx, MathOpType.MOD);
        return result;
    }

    @Override
    public T visitNotExpression(myGrammarParser.NotExpressionContext ctx) {
        System.out.println("in visitNotExpression: "+ctx.getText());
        
        return visitChildren(ctx);
    }

    @Override
    public T visitMultiplyExpression(myGrammarParser.MultiplyExpressionContext ctx) {
        T result = Calculate(ctx, MathOpType.DIV);
        return result;
    }

    @Override
    public T visitGtEqExpression(myGrammarParser.GtEqExpressionContext ctx) {
        return CompareNumbers(ctx, NumberComparisonType.GREATEREQUAL);
    }
    
    
    
    @Override
    public T visitDivideExpression(myGrammarParser.DivideExpressionContext ctx) {
        T result = Calculate(ctx, MathOpType.MOD);
        return result;
    }

    @Override
    public T visitOrExpression(myGrammarParser.OrExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitPowerExpression(myGrammarParser.PowerExpressionContext ctx) {
        T result = Calculate(ctx, MathOpType.POW);
        return result;
    }

    @Override
    public T visitEqExpression(myGrammarParser.EqExpressionContext ctx) {
        return CompareNumbers(ctx, NumberComparisonType.EQUAL);
    }

    @Override
    public T visitAndExpression(myGrammarParser.AndExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitStringExpression(myGrammarParser.StringExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitExpressionExpression(myGrammarParser.ExpressionExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitAddExpression(myGrammarParser.AddExpressionContext ctx) {
        T result = Calculate(ctx, MathOpType.ADD);
        return result;
    }

    @Override
    public T visitSubtractExpression(myGrammarParser.SubtractExpressionContext ctx) {
        T result = Calculate(ctx, MathOpType.SUB);
        return result;
    }

    @Override
    public T visitNullExpression(myGrammarParser.NullExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitFunctionCallExpression(myGrammarParser.FunctionCallExpressionContext ctx) {
        System.out.println("Calling a function");
        return (T) visitChildren(ctx);
    }

    @Override
    public T visitListExpression(myGrammarParser.ListExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitLtEqExpression(myGrammarParser.LtEqExpressionContext ctx) {
        return CompareNumbers(ctx, NumberComparisonType.LESSEQUAL);
    }

    @Override
    public T visitTernaryExpression(myGrammarParser.TernaryExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitList(myGrammarParser.ListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitIndexes(myGrammarParser.IndexesContext ctx) {
        return visitChildren(ctx);
    }
}
