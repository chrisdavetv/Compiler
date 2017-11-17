/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource.symboltable;

import java.util.Stack;

/**
 *
 * @author chris
 */
public class FunctionTracker {
    private final static String TAG = "Prog_CallGraphManager";
	
    private static FunctionTracker sharedInstance = null;

    private Stack<Function> callStack;

    public static FunctionTracker getInstance() {
            return sharedInstance;
    }

    private FunctionTracker() {
            this.callStack = new Stack<Function>();
    }

    public static void initialize() {
            sharedInstance = new FunctionTracker();
    }

    public static void reset() {

    }

    public void reportEnterFunction(Function Function) {
            this.callStack.push(Function);
    }

    public void reportExitFunction() {
            this.callStack.pop();
    }

    public Function getLatestFunction() {
            return this.callStack.peek();
    }

    /*
     * Returns true if the control flow is currently inside a function
     */
    public boolean isInsideFunction() {
            return (this.callStack.size() != 0);
    }
}
