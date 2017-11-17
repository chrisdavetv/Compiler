/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource.symboltable;

import compile.compilersource.myGrammarParser.ExpressionContext;
import compile.compilersource.symboltable.Util.ControlTypeEnum;
import compile.compilersource.symboltable.Value.PrimitiveType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author chris
 */
public class Function implements ICommand{
    private final static String TAG = "Function";
	
    public enum FunctionType {
            INT_TYPE,
            BOOLEAN_TYPE,
            BYTE_TYPE,
            CHAR_TYPE,
            DOUBLE_TYPE,
            FLOAT_TYPE,
            LONG_TYPE,
            SHORT_TYPE,
            STRING_TYPE,
            VOID_TYPE,
    }

    private String functionName;
    private List<ICommand> commandSequences; //the list of commands execution by the function

    private LocalScope parentLocalScope; //refers to the parent local scope of this function.

    private LinkedHashMap<String, ClassScope> parameterReferences; //the list of parameters accepted that follows the 'call-by-reference' standard.
    private LinkedHashMap<String, Value> parameterValues;	//the list of parameters accepted that follows the 'call-by-value' standard.
    private Value returnValue; //the return value of the function. null if it's a void type
    private FunctionType returnType = FunctionType.VOID_TYPE; //the return type of the function

    public Function() {
            this.commandSequences = new ArrayList<ICommand>();
            this.parameterValues = new LinkedHashMap<String,Value>();
            this.parameterReferences = new LinkedHashMap<String, ClassScope>();
    }

    public void setParentLocalScope(LocalScope localScope) {
            this.parentLocalScope = localScope;
    }

    public LocalScope getParentLocalScope() {
            return this.parentLocalScope;
    }

    public void setReturnType(FunctionType functionType) {
            this.returnType = functionType;

            //create an empty  value as a return value
            switch(this.returnType) {
                    case BOOLEAN_TYPE: this.returnValue = new Value(true, PrimitiveType.BOOLEAN); break;
                    case BYTE_TYPE: this.returnValue = new Value(0, PrimitiveType.BYTE); break;
                    case CHAR_TYPE: this.returnValue = new Value(' ', PrimitiveType.CHAR); break;
                    case INT_TYPE: this.returnValue = new Value(0, PrimitiveType.INT); break;
                    case DOUBLE_TYPE: this.returnValue = new Value(0, PrimitiveType.DOUBLE); break;
                    case FLOAT_TYPE: this.returnValue = new Value(0, PrimitiveType.FLOAT); break;
                    case LONG_TYPE: this.returnValue = new Value(0, PrimitiveType.LONG); break;
                    case SHORT_TYPE: this.returnValue = new Value(0, PrimitiveType.SHORT); break;
                    case STRING_TYPE: this.returnValue = new Value("", PrimitiveType.STRING); break;
                    default:break;	
            }
    }

    public FunctionType getReturnType() {
            return this.returnType;
    }

    public void setFunctionName(String functionName) {
            this.functionName = functionName;
    }

    public String getFunctionName() {
            return this.functionName;
    }

    /*
     * Maps parameters by values, which means that the value is copied to its parameter listing
     */
    public void mapParameterByValue(String... values) {
            for(int i = 0; i < values.length; i++) {
                    Value Value = this.getParameterAt(i);
                    Value.setValue(values[i]);
            }
    }

    public void mapParameterByValueAt(String value, int index) {
            if(index >= this.parameterValues.size()) {
                    return;
            }

            Value Value = this.getParameterAt(index);
            Value.setValue(value);
    }

    public void mapArrayAt(Value Value, int index, String identifier) {
            if(index >= this.parameterValues.size()) {
                    return;
            }

            Array Array = (Array) Value.getValue();

            Array newArray = new Array(Array.getPrimitiveType(), identifier);
            Value newValue = new Value(newArray, PrimitiveType.ARRAY);

            newArray.initializeSize(Array.getSize());

            for(int i = 0; i < newArray.getSize(); i++) {
                    newArray.updateValueAt(Array.getValueAt(i), i);
            }

            this.parameterValues.put(this.getParameterKeyAt(index), newValue);

    }

    public int getParameterValueSize() {
            return this.parameterValues.size();
    }

    public void verifyParameterByValueAt(ExpressionContext exprCtx, int index) {
            /*if(index >= this.parameterValues.size()) {
                    return;
            }

            Value Value = this.getParameterAt(index);
            TypeChecker typeChecker = new TypeChecker(Value, exprCtx);
            typeChecker.verify();*/
    }

    /*
     * Maps parameters by reference, in this case, accept a class scope.
     */
    public void mapParameterByReference(ClassScope... classScopes) {
            //Log.e(TAG, "Mapping of parameter by reference not yet supported.");
    }

    public void addParameter(String identifierString, Value Value) {
            this.parameterValues.put(identifierString, Value);
            //Console.log(LogType.DEBUG, this.functionName + " added an empty parameter " +identifierString+ " type " +Value.getPrimitiveType());
    }

    public boolean hasParameter(String identifierString) {
            return this.parameterValues.containsKey(identifierString);
    }
    public Value getParameter(String identifierString) {
            if(this.hasParameter(identifierString)) {
                    return this.parameterValues.get(identifierString);
            }
            else {
                    //Log.e(TAG, identifierString + " not found in parameter list");
                    return null;
            }
    }

    public Value getParameterAt(int index) {
            int i = 0;

            for(Value Value : this.parameterValues.values()) {
                    if(i == index) {
                            return Value;
                    }

                    i++;
            }

            //Log.e(TAG, index + " has exceeded parameter list.");
            return null;
    }

    private String getParameterKeyAt(int index) {
            int i = 0;

            for(String key : this.parameterValues.keySet()) {
                    if(i == index) {
                            return key;
                    }

                    i++;
            }

            //Log.e(TAG, index + " has exceeded parameter list.");
            return null;
    }

    public Value getReturnValue() {
            if(this.returnType == FunctionType.VOID_TYPE) {
                    //Console.log(LogType.DEBUG, this.functionName + " is a void function. Null  value is returned");
                    return null;
            }
            else {
                    return this.returnValue;
            }
    }

    //@Override
    public void addCommand(ICommand command) {
            this.commandSequences.add(command);
            ////Console.log("Command added to " +this.functionName);
    }

    @Override
    public void execute() {
            ExecutionMonitor executionMonitor = ExecutionManager.getInstance().getExecutionMonitor();
            FunctionTracker.getInstance().reportEnterFunction(this);
            try {
                    for(ICommand command : this.commandSequences) {
                            executionMonitor.tryExecution();
                            command.execute();
                    }

            } catch(InterruptedException e) {
                    //Log.e(TAG, "Monitor block interrupted! " +e.getMessage());
            }

            FunctionTracker.getInstance().reportExitFunction();
    }

    //@Override
    public ControlTypeEnum getControlType() {
            return ControlTypeEnum.FUNCTION_TYPE;
    }

    public static FunctionType identifyFunctionType(String primitiveTypeString) {

            if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_BOOLEAN, primitiveTypeString)) {
                    return FunctionType.BOOLEAN_TYPE;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_BYTE, primitiveTypeString)) {
                    return FunctionType.BYTE_TYPE;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_CHAR, primitiveTypeString)) {
                    return FunctionType.CHAR_TYPE;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_DOUBLE, primitiveTypeString)) {
                    return FunctionType.DOUBLE_TYPE;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_FLOAT, primitiveTypeString)) {
                    return FunctionType.FLOAT_TYPE;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_INT, primitiveTypeString)) {
                    return FunctionType.INT_TYPE;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_LONG, primitiveTypeString)) {
                    return FunctionType.LONG_TYPE;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_SHORT, primitiveTypeString)) {
                    return FunctionType.SHORT_TYPE;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_STRING, primitiveTypeString)) {
                    return FunctionType.STRING_TYPE;
            }

            return FunctionType.VOID_TYPE;
    }
}
