
package compile.compilersource;

import compile.compilersource.myGrammarBaseVisitor;
import static compile.compilersource.myGrammarParser.ADD;
import compile.compilersource.myGrammarParser.AddSubContext;
import compile.compilersource.myGrammarParser.AssignContext;
import compile.compilersource.myGrammarParser.IdContext;
import compile.compilersource.myGrammarParser.IntContext;
import static compile.compilersource.myGrammarParser.MUL;
import compile.compilersource.myGrammarParser.MulDivContext;
import compile.compilersource.myGrammarParser.ParensContext;
import compile.compilersource.myGrammarParser.PrintExprContext;
import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends myGrammarBaseVisitor<Double> {
    Map<String, Double> memory = new HashMap<String, Double>();
    
    @Override
    public Double visitAssign(AssignContext ctx) {
        String id = ctx.ID().getText();
        double value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }
     
    @Override
    public Double visitPrintExpr(PrintExprContext ctx) {
        Double value = visit(ctx.expr());
        System.out.println(value);
        return 0.;
    }
     
    @Override
    public Double visitInt(IntContext ctx) {
        return Double.valueOf(ctx.INT().getText());
    }
     
    @Override
    public Double visitId(IdContext ctx) {
        String id = ctx.ID().getText();
        if ( memory.containsKey(id) ) return memory.get(id);
        return 0.;
    }
     
    @Override
    public Double visitMulDiv(MulDivContext ctx) {
        double left = visit(ctx.expr(0));
        double right = visit(ctx.expr(1));
        if ( ctx.op.getType() == MUL ) return left * right;
        return left / right;
    }
 
    @Override
    public Double visitAddSub(AddSubContext ctx) {
        double left = visit(ctx.expr(0));
        double right = visit(ctx.expr(1));
        if ( ctx.op.getType() == ADD ) return left + right;
        return left - right;
    }
     
    @Override
    public Double visitParens(ParensContext ctx) {
        return visit(ctx.expr());
    }
}