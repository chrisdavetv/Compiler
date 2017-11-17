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
public class VariableSearcher {
    private final static String TAG = "VariableSearcher";
	
    public static Value searchVariable(String identifierString) {
            Value value = null;

            if(FunctionTracker.getInstance().isInsideFunction()) {
                    value = searchVariableInFunction(FunctionTracker.getInstance().getLatestFunction(), identifierString);
            }

            if(value == null) {
                    ClassScope classScope = SymbolTableManager.getInstance().getClassScope(CompilerHelper.getCurrentClassName());
                    value = searchVariableInClassIncludingLocal(classScope, identifierString);
            }

            return value;
    }

    public static Value searchVariableInFunction(Function Function, String identifierString) {
            Value value = null;

            if(Function.hasParameter(identifierString)) {
                    value = Function.getParameter(identifierString);
            }
            else {
                    value = LocalScopeCreator.searchVariableInLocalIterative(identifierString, Function.getParentLocalScope());
            }

            return value;
    }

    public static Value searchVariableInClassIncludingLocal(ClassScope classScope, String identifierString) {
            return classScope.searchVariableIncludingLocal(identifierString);
    }

    public static Value searchVariableInClass(ClassScope classScope, String identifierString) {
            return classScope.searchVariable(identifierString);
    }
}
