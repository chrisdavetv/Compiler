/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import org.antlr.v4.runtime.ParserRuleContext;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author chris
 */
public class Breakpoint// implements Runnable
{
    //lkjhlkjh
    private static Boolean stopExecution = false;
    private myGrammarParser.StatementContext ctx;
    private ArrayList<Integer> breaklineList;
    
    public static int checkBreakpoint(int lineo, ArrayList<Integer> breaklineList){
        String line = lineo + "";
        System.out.println("breakline time: "+breaklineList.size());
        for(int i = 0; i < breaklineList.size(); i++){ 
            int breakPointLineNum = breaklineList.get(i);
            System.out.println("checking a breakline at line: "+breakPointLineNum);
            if(line.equals(breaklineList.get(i).toString())){
                System.out.println("found a breakline at line: "+breakPointLineNum);
                //System.out.println("executing: "+Breakpoint.executing());
                
                return breakPointLineNum;
                
                /*while(Breakpoint.executing()){
                    try {
                        System.out.println("About to sleep");
                        Thread.sleep(100);
                        System.out.println("Woke up");
                    } catch (InterruptedException ex) {
                        System.out.println("Breakpoint sleep interrupted: "+ex.getMessage());
                    }

                }*/
            }   
         }
        
        return -1;
    }
    
    public Breakpoint(){
    }

    
}
