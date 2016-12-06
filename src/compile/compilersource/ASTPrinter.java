/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource;

import java.text.MessageFormat;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author chris
 */
public class ASTPrinter {
    public static void print(RuleContext context){
        explore(context, 0);
    }
    
    public static String GetASTTextOutput(RuleContext context){
        System.out.println(
                MessageFormat.format("GetASTTextOutput context nullcheck: {0}", context == null)
        );
        
        return explore(context, 0);
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
}
