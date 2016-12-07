/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

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
                        
                        EvalVisitor<String> eval = new EvalVisitor<String>();   
                        
                        parser.removeErrorListeners();
                        AntlrErrorListener errorListener = new AntlrErrorListener();//BaseErrorListenerExtension errorListener = new BaseErrorListenerExtension();
                        parser.addErrorListener(errorListener);
                        
                        //parse input text
                        ParseTreeWalker walker = new ParseTreeWalker();
                        GrammarListener listener = new GrammarListener();
                        walker.walk(listener, parser.parse());
                        output = errorListener.GetAllErrorMessages();
                        
                        //if no errors, then print value of expression
                        if(isStringNullOrWhiteSpace(output)){
                            String result = eval.visit(parser.parse());
                            System.out.println("result: "+result);
                            output = result.toString();
                            //output = GetASTTextOutput(parser.parse().getRuleContext());
                        }
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
                return output;
	}
    
    public static boolean isStringNullOrWhiteSpace(String value) {
        if (value == null) {
            return true;
        }

        for (int i = 0; i < value.length(); i++) {
            if (!Character.isWhitespace(value.charAt(i))) {
                return false;
            }
        }

        return true;
    }
    //sample usage: output = GetASTTextOutput(parser.expression().getRuleContext());
    public static String GetASTTextOutput(RuleContext context){
        return explore(context, 1);
    }
    
    public static String explore(RuleContext context, int indentation) {
        String output = "";
        String RuleName = myGrammarParser.ruleNames[context.getRuleIndex()];
        for(int c = 0;c < indentation;c++){
            System.out.print("  ");
            output += "  ";
        }
        System.out.println(RuleName);
        output += RuleName+"\n";
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
