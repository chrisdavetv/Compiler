package compile.compilersource;

import compile.compilersource.myGrammarParser.ExpressionContext;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTextArea;
import org.antlr.v4.runtime.tree.ParseTree;

public class EvalVisitor<T> extends myGrammarBaseVisitor<T> {
//mismatched input errors still dont get caught 
    
    Map<String, T> memory = new HashMap<String, T>();
    
    ErrorReporter VisitorErrorReporter;
    JTextArea outputArea;
    
    public EvalVisitor(ErrorReporter errorReporter, JTextArea outputTextArea){
        super();
        VisitorErrorReporter = errorReporter;
        outputArea = outputTextArea;
    }
    
    enum MathOpType {
        ADD, SUB, MULT, DIV, POW, MOD
    }
    enum ComparisonOpType{
        GREATEREQUAL, GREATER, LESSEQUAL, LESS, EQUAL, NOTEQUAL, AND, OR
    }

    String decideOperator(MathOpType type) {
        return type.equals(MathOpType.ADD) ? "+"
                : type.equals(MathOpType.SUB) ? "-"
                : type.equals(MathOpType.DIV) ? "/"
                : type.equals(MathOpType.POW) ? "^"
                : type.equals(MathOpType.MOD) ? "%"
                : type.equals(MathOpType.MULT) ? "*"
                : "";
    }

    Double CalculateValue(Double aggregateValue, ParseTree child, MathOpType type) {
        return type.equals(MathOpType.ADD) ? aggregateValue += Double.parseDouble(visit(child).toString())
                : type.equals(MathOpType.SUB) ? aggregateValue -= Double.parseDouble(visit(child).toString())
                : type.equals(MathOpType.DIV) ? aggregateValue /= Double.parseDouble(visit(child).toString())
                : type.equals(MathOpType.POW) ? aggregateValue = Math.pow(aggregateValue, Double.parseDouble(visit(child).toString())) 
                : type.equals(MathOpType.MOD) ? aggregateValue %= Double.parseDouble(visit(child).toString())
                : type.equals(MathOpType.MULT) ? aggregateValue *= Double.parseDouble(visit(child).toString())
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
                else System.out.println("found a " + operatorString + " sign at position" + c);
            }
            System.out.println("Expression returning: " + (T) result.toString());
        } catch (NullPointerException ne) {
            VisitorErrorReporter.CreateErrorMessage("operator can only be applied to type Number", 
                    ctx.getAltNumber());
            return (T)"";
        }
        return (T) result.toString();
    }
    
    String decideComparison(ExpressionContext ctx, ComparisonOpType type){
        return type.equals(ComparisonOpType.EQUAL) ? 
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) == 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
               type.equals(ComparisonOpType.GREATER) ?
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) > 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
               type.equals(ComparisonOpType.GREATEREQUAL) ?
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) >= 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
               type.equals(ComparisonOpType.LESS) ?
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) < 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
               type.equals(ComparisonOpType.LESSEQUAL) ?
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) <= 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
               type.equals(ComparisonOpType.NOTEQUAL) ?
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) != 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
                type.equals(ComparisonOpType.AND) ?
                String.valueOf(Boolean.parseBoolean(visit(ctx.getChild(0)).toString()) && 
                    Boolean.parseBoolean(visit(ctx.getChild(2)).toString())) :
                
                type.equals(ComparisonOpType.OR) ?
                String.valueOf(Boolean.parseBoolean(visit(ctx.getChild(0)).toString()) || 
                    Boolean.parseBoolean(visit(ctx.getChild(2)).toString())) :
                
                String.valueOf(Boolean.parseBoolean(""))//will cause exception
                ;
    }
    
    T CompareExp(ExpressionContext ctx, ComparisonOpType type){
        int numberOfChildren = ctx.getChildCount();
        String result = "";
        System.out.println(numberOfChildren + " children in Expression");
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
        T result = (T) visitChildren(ctx.block());
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
        T result = (T) (visitChildren(ctx).toString());
        return result;
    }
    
    T EvaluateConditionalBlock(myGrammarParser.BlockContext ctx){
        T result = (T)"";
        try{
            result = (T)visitBlock(ctx).toString();
        }catch(NullPointerException ne){
            VisitorErrorReporter.CreateErrorMessage(
                ne.getMessage()+
                " - Could not resolve conditional code block", 
                ctx.getAltNumber());
        }
        return result;
    }
    
    @Override
    public T visitIfStatement(myGrammarParser.IfStatementContext ctx) {
        System.out.println("In visitIfStatement");
        System.out.println(ctx.getChildCount()+" children in if statement");
        T result = (T)"";
        
        try{
            Boolean ifConditional = Boolean.parseBoolean(visitIfStat(ctx.ifStat()).toString());
            //if first condition is satisfied, then don't move to succeeding else-if code blocks
            if(ifConditional){
                result = EvaluateConditionalBlock(ctx.ifStat().block());
            }else{
                //check else if statements
                int elseIfStatmentCount = ctx.getChildCount() - 3;
                Boolean ifElseConditional = false;
                for(int c = 0;c < elseIfStatmentCount;c++){
                    System.out.println("if statement not statisfied, checking ifelse statements");
                    ifElseConditional = Boolean.parseBoolean(visitElseIfStat(ctx.elseIfStat(c)).toString());
                    if(ifElseConditional){
                        result = EvaluateConditionalBlock(ctx.elseIfStat(c).block());
                    }
                }
                //if no ifelse conditions were satisfied, then check if else statement exists
                if(!ifElseConditional && ctx.elseStat() != null){
                    System.out.println("ifelse statements not statisfied, checking else statements");
                    result = EvaluateConditionalBlock(ctx.elseStat().block());
                }
            }
        }catch(Exception e){
            VisitorErrorReporter.CreateErrorMessage(
                    e.getMessage()+
                    " - Could not resolve condition inside if statement", 
                    ctx.getAltNumber());
        }
        
        return result;
    }

    @Override
    public T visitIfStat(myGrammarParser.IfStatContext ctx) {
        System.out.println("In visitIfStat");
        T result = (T)"";
        int numberOfChildren = ctx.getChildCount();
        System.out.println(numberOfChildren+" children in visitIfStat");
        
        ParseTree conditionChild = ctx.expression();
        ParseTree blockChild = ctx.block();
        
        Boolean condition = false;
        try{
            condition = Boolean.parseBoolean(visit(conditionChild).toString());
        }catch(Exception e){
            VisitorErrorReporter.CreateErrorMessage(
                    e.getMessage()+
                    " - Could not resolve if statement condition", 
                    ctx.getAltNumber());
        }
        
        /*if(condition){//implement error recovery?
            try{
                result = (T)visit(blockChild).toString();
            }catch(NullPointerException ne){
                VisitorErrorReporter.CreateErrorMessage(
                    ne.getMessage()+
                    " - Could not resolve if statement body code block", 
                    ctx.getAltNumber());
            }
        }
        
        return result;*/
        return (T)String.valueOf(condition);
    }
    
    @Override
    public T visitElseIfStat(myGrammarParser.ElseIfStatContext ctx) {
        System.out.println("In visitElseIfStat");
        T result = (T)"";
        int numberOfChildren = ctx.getChildCount();
        System.out.println(numberOfChildren+" children in visitIfStat");
        
        ParseTree conditionChild = ctx.expression();
        ParseTree blockChild = ctx.block();
        
        Boolean condition = false;
        try{
            condition = Boolean.parseBoolean(visit(conditionChild).toString());
        }catch(Exception e){
            VisitorErrorReporter.CreateErrorMessage(
                    e.getMessage()+
                    " - Could not resolve else if condition", 
                    ctx.getAltNumber());
        }
        
        /*if(condition){//implement error recovery?
            try{
                result = (T)visit(blockChild).toString();
            }catch(NullPointerException ne){
                VisitorErrorReporter.CreateErrorMessage(
                    ne.getMessage()+
                    " - Could not resolve if statement body code block", 
                    ctx.getAltNumber());
            }
        }
        
        return result;*/
        return (T)String.valueOf(condition);
    }

    @Override
    public T visitElseStat(myGrammarParser.ElseStatContext ctx) {
        T result = (T)"";
        int numberOfChildren = ctx.getChildCount();
        System.out.println(numberOfChildren+" children in visitIfStat");
        
        ParseTree blockChild = ctx.block();
        try{
            result = (T)visit(blockChild).toString();
        }catch(NullPointerException ne){
            VisitorErrorReporter.CreateErrorMessage(
                ne.getMessage()+
                " - Could not resolve if statement body code block", 
                ctx.getAltNumber());
        }
        
        return result;
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
    public T visitWhileStatement(myGrammarParser.WhileStatementContext ctx) {//need to implement variables to test
        System.out.println("In visitWhileStatement, condition: "+ctx.expression().getText());
        
        T result = (T)"";
        Boolean whileConditional = false;
        try{
            whileConditional = Boolean.parseBoolean(visit(ctx.expression()).toString());
        }catch(Exception e){
            VisitorErrorReporter.CreateErrorMessage(
                e.getMessage()+
                " - Could not resolve while statement condition. It must return an object of type Bool", 
                ctx.getAltNumber());
        }
        while(whileConditional){
          String iterationOutput = EvaluateConditionalBlock(ctx.block()).toString();
          result += iterationOutput;
          //outputArea.setText(outputArea.getText() + iterationOutput);
        }
        
        return result;
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
        return CompareExp(ctx, ComparisonOpType.LESS);
    }

    @Override
    public T visitGtExpression(myGrammarParser.GtExpressionContext ctx) {
        return CompareExp(ctx, ComparisonOpType.GREATER);
    }

    @Override
    public T visitBoolExpression(myGrammarParser.BoolExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitNotEqExpression(myGrammarParser.NotEqExpressionContext ctx) {
        return CompareExp(ctx, ComparisonOpType.NOTEQUAL);
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
        System.out.println("inNotExpression has "+ctx.getChildCount()+" children");
        ParseTree origBoolChild = ctx.getChild(1);
        String result = "";
        try{
            result = String.valueOf(!Boolean.parseBoolean(visit(origBoolChild).toString()));
        }catch(Exception e){
            VisitorErrorReporter.CreateErrorMessage(e.getMessage(), 
                    ctx.getAltNumber());
        }
        return (T)result;
    }

    @Override
    public T visitMultiplyExpression(myGrammarParser.MultiplyExpressionContext ctx) {
        T result = Calculate(ctx, MathOpType.MULT);
        return result;
    }

    @Override
    public T visitGtEqExpression(myGrammarParser.GtEqExpressionContext ctx) {
        return CompareExp(ctx, ComparisonOpType.GREATEREQUAL);
    }
    
    
    
    @Override
    public T visitDivideExpression(myGrammarParser.DivideExpressionContext ctx) {
        T result = Calculate(ctx, MathOpType.DIV);
        return result;
    }

    @Override
    public T visitOrExpression(myGrammarParser.OrExpressionContext ctx) {
        return CompareExp(ctx, ComparisonOpType.OR);
    }

    @Override
    public T visitPowerExpression(myGrammarParser.PowerExpressionContext ctx) {
        T result = Calculate(ctx, MathOpType.POW);
        return result;
    }

    @Override
    public T visitEqExpression(myGrammarParser.EqExpressionContext ctx) {
        return CompareExp(ctx, ComparisonOpType.EQUAL);
    }

    @Override
    public T visitAndExpression(myGrammarParser.AndExpressionContext ctx) {
        return CompareExp(ctx, ComparisonOpType.AND);
    }

    @Override
    public T visitStringExpression(myGrammarParser.StringExpressionContext ctx) {//string formatting?
        System.out.println("in visitStringExpression: "+ctx.getText());
        return (T)ctx.getText();
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
        return CompareExp(ctx, ComparisonOpType.LESSEQUAL);
    }

    @Override
    public T visitTernaryExpression(myGrammarParser.TernaryExpressionContext ctx) {
        T result = (T)"";
        int numberOfChildren = ctx.getChildCount();
        System.out.println(numberOfChildren+" children in visitTernaryExpression");
        
        ParseTree conditionChild = ctx.getChild(0);
        ParseTree trueConditionChild = ctx.getChild(2);
        ParseTree falseConditionChild = ctx.getChild(4);
        
        Boolean condition = false;
        try{
            condition = Boolean.parseBoolean(visit(conditionChild).toString());
        }catch(Exception e){
            VisitorErrorReporter.CreateErrorMessage(
                    e.getMessage()+
                    " - Could not resolve ternary expression condition, continuing with false branch expression", 
                    ctx.getAltNumber());
        }
        
        if(condition){//implement error recovery?
            try{
                result = (T)visit(trueConditionChild).toString();
            }catch(NullPointerException ne){
                VisitorErrorReporter.CreateErrorMessage(
                    ne.getMessage()+
                    " - Could not resolve ternary expression true condition branch", 
                    ctx.getAltNumber());
            }
        }else{
            try{
                result = (T)visit(falseConditionChild).toString();
            }catch(NullPointerException ne){
                VisitorErrorReporter.CreateErrorMessage(
                    ne.getMessage()+
                    " - Could not resolve ternary expression false condition branch", 
                    ctx.getAltNumber());
            }
        }
        
        return result;
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
