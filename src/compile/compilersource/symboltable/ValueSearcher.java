/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource.symboltable;

import compile.compilersource.CompilerHelper;

/**
 *
 * @author chris
 */
public class ValueSearcher {
    private final static String TAG = "Prog_ValueSearcher";

    public static Value searchValue(String identifier) {

            Value value = null;

            if(FunctionTracker.getInstance().isInsideFunction()) {
                    Function Function = FunctionTracker.getInstance().getLatestFunction();

                    if(Function.hasParameter(identifier)) {
                            value =  Function.getParameter(identifier);
                    }
                    else {
                            value = LocalScopeCreator.searchVariableInLocalIterative(identifier, Function.getParentLocalScope());
                    }
            }

            if(value == null) {
                    ClassScope classScope = SymbolTableManager.getInstance().getClassScope(CompilerHelper.getCurrentClassName());
                    value = classScope.searchVariableIncludingLocal(identifier);
            }

            return value;

    }
}
