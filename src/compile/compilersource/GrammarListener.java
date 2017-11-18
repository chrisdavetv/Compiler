/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import compile.compilersource.myGrammarParser.ArrayExpressionContext;
import compile.compilersource.myGrammarParser.FunctionBlockContext;
import compile.compilersource.myGrammarParser.ParamIdListContext;

/**
 *
 * @author chris
 */
public class GrammarListener implements myGrammarListener{

    
    @Override
    public void enterParse(myGrammarParser.ParseContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitParse(myGrammarParser.ParseContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterBlock(myGrammarParser.BlockContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitBlock(myGrammarParser.BlockContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterStatement(myGrammarParser.StatementContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitStatement(myGrammarParser.StatementContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterAssignment(myGrammarParser.AssignmentContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitAssignment(myGrammarParser.AssignmentContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterIdentifierFunctionCall(myGrammarParser.IdentifierFunctionCallContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitIdentifierFunctionCall(myGrammarParser.IdentifierFunctionCallContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterPrintlnFunctionCall(myGrammarParser.PrintlnFunctionCallContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitPrintlnFunctionCall(myGrammarParser.PrintlnFunctionCallContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterPrintFunctionCall(myGrammarParser.PrintFunctionCallContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitPrintFunctionCall(myGrammarParser.PrintFunctionCallContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterIfStatement(myGrammarParser.IfStatementContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitIfStatement(myGrammarParser.IfStatementContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterIfStat(myGrammarParser.IfStatContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitIfStat(myGrammarParser.IfStatContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterElseIfStat(myGrammarParser.ElseIfStatContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitElseIfStat(myGrammarParser.ElseIfStatContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterElseStat(myGrammarParser.ElseStatContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitElseStat(myGrammarParser.ElseStatContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterFunctionDecl(myGrammarParser.FunctionDeclContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitFunctionDecl(myGrammarParser.FunctionDeclContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterForStatement(myGrammarParser.ForStatementContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitForStatement(myGrammarParser.ForStatementContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterWhileStatement(myGrammarParser.WhileStatementContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitWhileStatement(myGrammarParser.WhileStatementContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterIdList(myGrammarParser.IdListContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitIdList(myGrammarParser.IdListContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterExprList(myGrammarParser.ExprListContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitExprList(myGrammarParser.ExprListContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterLtExpression(myGrammarParser.LtExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitLtExpression(myGrammarParser.LtExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterGtExpression(myGrammarParser.GtExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitGtExpression(myGrammarParser.GtExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterBoolExpression(myGrammarParser.BoolExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitBoolExpression(myGrammarParser.BoolExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterNotEqExpression(myGrammarParser.NotEqExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitNotEqExpression(myGrammarParser.NotEqExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterNumberExpression(myGrammarParser.NumberExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitNumberExpression(myGrammarParser.NumberExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterIdentifierExpression(myGrammarParser.IdentifierExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitIdentifierExpression(myGrammarParser.IdentifierExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterModulusExpression(myGrammarParser.ModulusExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitModulusExpression(myGrammarParser.ModulusExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterNotExpression(myGrammarParser.NotExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitNotExpression(myGrammarParser.NotExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterMultiplyExpression(myGrammarParser.MultiplyExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitMultiplyExpression(myGrammarParser.MultiplyExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterGtEqExpression(myGrammarParser.GtEqExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitGtEqExpression(myGrammarParser.GtEqExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterDivideExpression(myGrammarParser.DivideExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitDivideExpression(myGrammarParser.DivideExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterOrExpression(myGrammarParser.OrExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitOrExpression(myGrammarParser.OrExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterPowerExpression(myGrammarParser.PowerExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitPowerExpression(myGrammarParser.PowerExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterEqExpression(myGrammarParser.EqExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitEqExpression(myGrammarParser.EqExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterAndExpression(myGrammarParser.AndExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitAndExpression(myGrammarParser.AndExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterStringExpression(myGrammarParser.StringExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitStringExpression(myGrammarParser.StringExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterExpressionExpression(myGrammarParser.ExpressionExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitExpressionExpression(myGrammarParser.ExpressionExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterAddExpression(myGrammarParser.AddExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitAddExpression(myGrammarParser.AddExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterSubtractExpression(myGrammarParser.SubtractExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitSubtractExpression(myGrammarParser.SubtractExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterNullExpression(myGrammarParser.NullExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitNullExpression(myGrammarParser.NullExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterFunctionCallExpression(myGrammarParser.FunctionCallExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitFunctionCallExpression(myGrammarParser.FunctionCallExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterListExpression(myGrammarParser.ListExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitListExpression(myGrammarParser.ListExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterLtEqExpression(myGrammarParser.LtEqExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitLtEqExpression(myGrammarParser.LtEqExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterTernaryExpression(myGrammarParser.TernaryExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitTernaryExpression(myGrammarParser.TernaryExpressionContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterList(myGrammarParser.ListContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitList(myGrammarParser.ListContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterIndexes(myGrammarParser.IndexesContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitIndexes(myGrammarParser.IndexesContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitTerminal(TerminalNode tn) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitErrorNode(ErrorNode en) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterEveryRule(ParserRuleContext prc) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitEveryRule(ParserRuleContext prc) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterIdentifierDeclaration(myGrammarParser.IdentifierDeclarationContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitIdentifierDeclaration(myGrammarParser.IdentifierDeclarationContext ctx) {
        //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public void enterParamIdList(ParamIdListContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitParamIdList(ParamIdListContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterArrayExpression(ArrayExpressionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitArrayExpression(ArrayExpressionContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterFunctionBlock(FunctionBlockContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitFunctionBlock(FunctionBlockContext ctx) {
		// TODO Auto-generated method stub
		
	}
    
    
}
