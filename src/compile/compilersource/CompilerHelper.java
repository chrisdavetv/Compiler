/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource;

import compile.compilersource.myGrammarParser.ExpressionContext;
import java.text.MessageFormat;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author chris
 */
public class CompilerHelper {
    public /*CommonTree*/ static String compile(String expression) {
        String output = "";
		try {
			//lexer splits input into tokens
			ANTLRInputStream input = new ANTLRInputStream(expression);
			CommonTokenStream tokens = new CommonTokenStream(new myGrammarLexer(input));
			//parser generates abstract syntax tree
			myGrammarParser parser = new myGrammarParser(tokens);
			//myGrammarParser.expression_return ret = parser.expression();
			//ExpressionContext parserExpression = parser.expression();
			//acquire parse result
			//CommonTree ast = (CommonTree) parserExpression.tree;
			//printTree(ast);
			///return ast;
                        System.out.println("ruleContext nullcheck: "+parser.getRuleContext() == null);
                        output = GetASTTextOutput(parser.expression().getRuleContext());
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
                return output;
	}
    
    public static String GetASTTextOutput(RuleContext context){
        return explore(context, 1);
    }
    
    public static String explore(RuleContext context, int indentation) {
        System.out.println(
                MessageFormat.format("explore context nullcheck: {0}", context == null)
        );
        
        String output = "";
        String RuleName = myGrammarParser.ruleNames[context.getRuleIndex()];
        for(int c = 0;c < indentation;c++){
            System.out.print("  ");
            output += "  ";
        }
        System.out.println(RuleName);
        output += RuleName;
        for(int c = 0;c < context.getChildCount();c++){
            ParseTree element = context.getChild(c);
            if(element instanceof RuleContext){
                output += explore((RuleContext)element, indentation+1);
            }
        }
        return output;
    }
    
    private static void printTree(CommonTree ast) {
		print(ast, 0);
	}

	private static void print(CommonTree tree, int level) {
		//indent level
		for (int i = 0; i < level; i++)
			System.out.print("--");

		//print node description: type code followed by token text
		System.out.println(" " + tree.getType() + " " + tree.getText());
		
		//print all children
		if (tree.getChildren() != null)
			for (Object ie : tree.getChildren()) {
				print((CommonTree) ie, level + 1);
			}
	}
}
