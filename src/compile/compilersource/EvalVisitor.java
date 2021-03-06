package compile.compilersource;

import compile.compiler.CompilerUI;
import compile.compilersource.myGrammarParser.ExpressionContext;
import java.awt.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class EvalVisitor<T> extends myGrammarBaseVisitor<T> {

    class FunctionData{
    	public String parent;
    	public String returnValue;
    	public int length = 0;
        public Map<String, ArrayList<T>> identifierMemory = new HashMap<String, ArrayList<T>>();
        public Map<Integer, String> funcIdentifierTracker = new HashMap<Integer, String>();
        //public myGrammarParser.BlockContext blockCtx;
        public myGrammarParser.FunctionBlockContext functionBlockCtx;
        
        private String returnType; 
        private String name;
        
        public FunctionData(Map<String, ArrayList<T>> identifierMemory, Map<Integer, String> funcIdentifierTracker,
        		String returnType, String returnValue) {
        	this.funcIdentifierTracker.putAll(funcIdentifierTracker);
        	this.identifierMemory.putAll(identifierMemory);
        	this.returnValue = returnValue;
        	this.returnType = returnType;
        }
        public FunctionData() {
        	
        }
        public String getFunctionName() {
        	return name;
        }
        
        public void setFunctionName(String name) {
        	this.name = name;
        } 
        
        Boolean identifierExists(String idName){
            return identifierMemory.get(idName) != null;
        }
        
        public String getReturnType() {
        	return returnType;
        }
        public void setReturnType(String returnType) {
        	this.returnType = returnType;
        }
        public String getReturnValue() {
        	return returnValue;
        }
        public void setReturnValue(String returnValue) {
        	this.returnValue = returnValue;
        }
     }
    
    class ErrorData{
    	 public ArrayList<String> errorStorage = new ArrayList<String>();
    	 public ArrayList<Token> tokenStorage = new ArrayList<Token>();
    	 public ArrayList<String> errorType = new ArrayList<String>();
    	 public boolean runnable;
    	 public myGrammarParser.BlockContext blockCtx;
    }
    
    
    //Map<String, ArrayList<T>> identifierMemory = new HashMap<String, ArrayList<T>>();
    Map<String, FunctionData> functionMemory = new HashMap<String, FunctionData>();
    ArrayList<FunctionData> functionList = new ArrayList<FunctionData>();
    ArrayList<ErrorData> errorList = new ArrayList<ErrorData>();
    ArrayList<String> arrays = new ArrayList<String>();
    ArrayList<String> functionNames = new ArrayList<String>();  
    String currentFunction = "";
    ErrorReporter VisitorErrorReporter;
    CompilerUI ui;
    FunctionData main;
    final String functionParamSeparator = ",";
    String[] depth = new String[1000];
    int depthIndex;
    int errorBlockIndex;
    int returnCount = 0;
    boolean printOn = true;
    FunctionData currentFunctionData;
    ErrorData currentErrorData;
    ArrayList<String> watchList = new ArrayList<String>();
    ArrayList<String> watchListValue = new ArrayList<String>();
    ArrayList<Integer> breaklineList = new ArrayList<Integer>();
    ArrayList<ArrayList<String>> blockIdentifiers = new ArrayList<ArrayList<String>>();
    String catchErrorMessage, catchVarName;
    int blockIndex;    
    public EvalVisitor(ErrorReporter errorReporter, CompilerUI ui, ArrayList watchList, ArrayList breaklineList){
        super();
        VisitorErrorReporter = errorReporter;
        this.ui = ui;
        currentFunction = "main";
        currentFunctionData = new FunctionData();
        currentErrorData = new ErrorData();
        currentErrorData.runnable = true;
        functionMemory.put("main", currentFunctionData);
        depthIndex = 0;
        errorBlockIndex = 0;
        blockIndex = -1;
        depth[0] = "main";
        functionList.add(currentFunctionData);
        errorList.add(currentErrorData);
        catchVarName = "";
        this.watchList.addAll(watchList);
        for(int i = 0; i < watchList.size(); i++)
            this.watchListValue.add("");
        this.breaklineList.addAll(breaklineList);
        
        for (int i = 0; i < breaklineList.size(); i++) {
        	System.out.println("breakLine List [" + i + "] = " + breaklineList.get(i));
        }
    }
    
    enum MathOpType {
        ADD, SUB, MULT, DIV, POW, MOD
    }
    enum ComparisonOpType{
        GREATEREQUAL, GREATER, LESSEQUAL, LESS, EQUAL, NOTEQUAL, AND, OR
    }

    String decideOperator(MathOpType type) {
        return type.equals(MathOpType.ADD) ? "+"
                : type.equals(MathOpType.SUB) ? "-"
                : type.equals(MathOpType.DIV) ? "/"
                : type.equals(MathOpType.POW) ? "^"
                : type.equals(MathOpType.MOD) ? "%"
                : type.equals(MathOpType.MULT) ? "*"
                : "";
    }

    BigDecimal CalculateValue(BigDecimal aggregateValue, ParseTree child, MathOpType type) {
    	
    	BigDecimal num = new BigDecimal(visit(child).toString());
    	try {
        if (type.equals(MathOpType.ADD))
        	return aggregateValue.add(num);
        else if (type.equals(MathOpType.SUB))
        	return aggregateValue.subtract(num);
        else if (type.equals(MathOpType.DIV)) 
        	if (child.getText().contains(".") || aggregateValue.toString().contains("."))
        		return aggregateValue.divide(num, 2, RoundingMode.HALF_UP);
        	else
        		return aggregateValue.divide(num, RoundingMode.FLOOR);
        else if (type.equals(MathOpType.POW))
        	return aggregateValue.pow(num.intValueExact()); 
        else if (type.equals(MathOpType.MOD))
        	return aggregateValue.remainder(num);
        else if (type.equals(MathOpType.MULT))
        	return aggregateValue.multiply(num);
        else
        	return null;
    	} catch (ArithmeticException e) {
    		//e.printStackTrace();
    		return null;
    	}
    }
    
    T Calculate(ExpressionContext ctx, MathOpType type) {
        BigDecimal result = new BigDecimal("0.0");
        String finalResult = "";
        int numberOfChildren = ctx.getChildCount();
        String operatorString = decideOperator(type);
        try {
            System.out.println(numberOfChildren + " children in Expression");
            for (int c = 0; c < numberOfChildren; c++) {
                ParseTree child = ctx.getChild(c);
                System.out.println("child : " + child.getText());
                if (!(child.getText().contains("\"")) && child.getText().matches("[a-zA-Z_][a-zA-Z_0-9]*") &&
                		!(child.getText().equals("true") || child.getText().equals("false"))) {
                	if (currentFunctionData.identifierMemory.get(child.getText()) == null) {
                		currentErrorData.errorStorage.add("the identifier : "
                        		+ child.getText() + " used in the expression does not exist!");
                		currentErrorData.tokenStorage.add(ctx.getStart());
                        /* VisitorErrorReporter.CreateErrorMessage("the identifier : "
                        		+ child.getText() + " used in the expression does not exist!", 
                                ctx.getStart()); */
                        break;
                	}
                }
                
                if (child.getText().equals("true") || child.getText().equals("false")) {
                    /*VisitorErrorReporter.CreateErrorMessage("boolean datatype exists in the equation.", 
                            ctx.getStart());*/
            		currentErrorData.errorStorage.add("boolean datatype exists in the equation.");
            		currentErrorData.tokenStorage.add(ctx.getStart());
                    break;
                }
                if (!child.getText().equals(operatorString)) {
                    if (c == 0) {
                        result = new BigDecimal(visit(child).toString());
                        System.out.println("calculate : " + result);
                    } else {
                    	BigDecimal catcher = CalculateValue(result, child, type);
                    	if (catcher != null) {
                        result = CalculateValue(result, child, type);///= Double.parseDouble(visit(child).toString());
                    	} else {
                    		currentErrorData.errorStorage.add("ArithmeticException occurred.");
                    		currentErrorData.tokenStorage.add(ctx.getStart());
                    		currentErrorData.runnable = false;
                    		return (T)"";
                    	}
                        
                    }
                }
                else System.out.println("found a " + operatorString + " sign at position" + c);
            }
            finalResult = result.toString();
            /*if (finalResult.endsWith(".0"))
            	finalResult = finalResult.substring(0, finalResult.length() - 2);*/
            System.out.println("Expression returning: " + finalResult);
            
            
        } catch (NullPointerException ne) {
            /*VisitorErrorReporter.CreateErrorMessage("operator can only be applied to type Number", 
                    ctx.getStart());*/
    		currentErrorData.errorStorage.add("operator can only be applied to type Number");
    		currentErrorData.tokenStorage.add(ctx.getStart());        	
            return (T)"";
        } catch (NumberFormatException nfe) {
            /*VisitorErrorReporter.CreateErrorMessage("Invalid equation. Please check again.", 
                    ctx.getStart());*/
    		//currentErrorData.errorStorage.add("Invalid equation. Please check again.");
    		//currentErrorData.tokenStorage.add(ctx.getStart());   
        }
        return (T) finalResult;
    }
    
    String decideComparison(ExpressionContext ctx, ComparisonOpType type){
		String s = visit(ctx.getChild(0)).toString();
		String s2 = visit(ctx.getChild(2)).toString();
		
		if (s.contains("\"") && s2.contains("\"")){
			if (type.equals(ComparisonOpType.EQUAL)) {
				if (s.equals(s2)) {
					return "true";
				}
				else {
					return "false";
				}
			}
			else if (type.equals(ComparisonOpType.NOTEQUAL)) {
				if (!(s.equals(s2))) {
					return "true";
				}
				else {
					return "false";
				}
			}
		}
		
        return type.equals(ComparisonOpType.EQUAL) ? 
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) == 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
               type.equals(ComparisonOpType.GREATER) ?
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) > 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
               type.equals(ComparisonOpType.GREATEREQUAL) ?
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) >= 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
               type.equals(ComparisonOpType.LESS) ?
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) < 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
               type.equals(ComparisonOpType.LESSEQUAL) ?
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) <= 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
               type.equals(ComparisonOpType.NOTEQUAL) ?
                String.valueOf(Double.parseDouble(visit(ctx.getChild(0)).toString()) != 
                    Double.parseDouble(visit(ctx.getChild(2)).toString())) :
                
                type.equals(ComparisonOpType.AND) ?
                String.valueOf(Boolean.parseBoolean(visit(ctx.getChild(0)).toString()) && 
                    Boolean.parseBoolean(visit(ctx.getChild(2)).toString())) :
                
                type.equals(ComparisonOpType.OR) ?
                String.valueOf(Boolean.parseBoolean(visit(ctx.getChild(0)).toString()) || 
                    Boolean.parseBoolean(visit(ctx.getChild(2)).toString())) :
                
                String.valueOf(Boolean.parseBoolean(""))//will cause exception
                ;
    }
    
    T CompareExp(ExpressionContext ctx, ComparisonOpType type){
        int numberOfChildren = ctx.getChildCount();
        String result = "";
        System.out.println(numberOfChildren + " children in Expression");
  
        try{
            result = decideComparison(ctx, type);
        }catch(Exception e){
            System.out.println("error in visitGtEqExpression of type: "+e.getMessage());
            /*VisitorErrorReporter.CreateErrorMessage(
                    " - please check expressions on both sides of your comparison operators", 
                    ctx.getStart());*/
    		currentErrorData.errorStorage.add("- please check expressions on both sides of your comparison operators");
    		currentErrorData.tokenStorage.add(ctx.getStart());   
            result = "";
        }
        return (T)result;
    }

    @Override
    public T aggregateResult(T aggregate, T nextResult) {
        if (aggregate == null) {
            return nextResult;
        }

        if (nextResult == null) {
            return (T) aggregate;
        }

        StringBuilder sb = new StringBuilder(aggregate.toString());
        System.out.println("sb : " + sb);
        sb.append(" ");
        sb.append(nextResult);

        return (T) sb.toString();
    }

    @Override
    public T visitParse(myGrammarParser.ParseContext ctx) {
        //in here goes error checking, etc - in antlr3, all the code previously mixed in the grammar goes here
        T result = (T) "";
        System.out.println("visitParse result: " + result);
        
        try{
            //Breakpoint.checkBreakpoint(ctx, breaklineList);
            result = (T) visitChildren(ctx);
        }catch(Exception e){
            /*VisitorErrorReporter.CreateErrorMessage(
                    " - syntax error", 
                    ctx.getStart());
            e.printStackTrace();*/
        	e.printStackTrace();
    		currentErrorData.errorStorage.add(" - syntax error");
    		currentErrorData.tokenStorage.add(ctx.getStart());   
        }
        
        
        for (int i = 0; i < functionList.size(); i++) {
        	System.out.println(functionList.get(i).identifierMemory);
        	System.out.println("-------------------------------");
        }
        
    	for (int i = 0; i < errorList.get(errorBlockIndex).errorStorage.size(); i++) {
    		//System.out.println("errors : " + errorList.get(errorBlockIndex).errorStorage.get(i));
    		VisitorErrorReporter.CreateErrorMessage(errorList.get(errorBlockIndex).errorStorage.get(i),
    				errorList.get(errorBlockIndex).tokenStorage.get(i));
    	}
        
        
        return result;
    }
    
    @Override
    public T visitFunctionBlock(myGrammarParser.FunctionBlockContext ctx) {
    	T result = (T) "";
    	
    	////////////where function starts and ends!
    	System.out.println("In visit FunctionBlock");
    	returnCount = 0;
    	result = (T) visitChildren(ctx);
    	if (currentErrorData.runnable) {
    	if (!(depthIndex <= 0)) {
    		
    	
    	if (returnCount <= 0 && !(currentFunctionData.getReturnType().equals("void"))) {
            /*VisitorErrorReporter.CreateErrorMessage("The function does not contain a return statement! ", 
                    ctx.getStart());*/
    		currentErrorData.errorStorage.add("The function does not contain a return statement! ");
    		currentErrorData.tokenStorage.add(ctx.getStart());   
    	}
    	
    	}
    	}
    	
    	if (!(depthIndex <= 0))
    	{
        	if (currentFunctionData.getReturnType().equals("void")) {
        		depthIndex--;
        		currentFunction = depth[depthIndex];
        		result = (T)"";
        		currentFunctionData.setReturnValue(null);
        		
        		for (int j = 0; j < arrays.size(); j++) {
        		if (functionList.get(depthIndex).identifierExists(arrays.get(j))) {
        		ArrayList<T> arrayInfo = currentFunctionData.identifierMemory.get(arrays.get(j));
        		functionList.get(depthIndex).identifierMemory.put(arrays.get(j), arrayInfo);
        		for (int i = 0; i < Integer.parseInt(arrayInfo.get(0).toString()); i++) {
        			ArrayList<T> tArray = new ArrayList<T>(currentFunctionData.identifierMemory.get(arrays.get(j) + "[" + i + "]"));
        			//currentFunctionData.identifierMemory.get(arrays + "[" + i + "]").get(0).toString();
        			//currentFunctionData.identifierMemory.get(arrays + "[" + i + "]").get(1).toString();
        			//currentFunctionData.identifierMemory.get(arrays + "[" + i + "]").get(2).toString();
        			functionList.get(depthIndex).identifierMemory.put(arrays.get(j) + "[" + i + "]", tArray);
        			System.out.println("putted " + arrays.get(j) + "[" + i + "]");
        		}
        		}
        		}
        		currentFunctionData = functionList.get(depthIndex);
        		functionList.remove(depthIndex + 1);
        		
        		/*for (int i = 0; i < currentFunctionData.identifierMemory.size(); i++) {
        			
        		}*/
        		//currentFunction = currentFunctionData.parent;
        	}
        	else {
        		if (currentErrorData.runnable)
        			result = (T)currentFunctionData.getReturnValue();
        		else
        			result = (T)"";
	    		System.out.println("Function " + currentFunction + " returned : " + currentFunctionData.getReturnValue());
	    		currentFunctionData.setReturnValue(null);
	    		depthIndex--;
	    		currentFunction = depth[depthIndex];
	    		
        		for (int j = 0; j < arrays.size(); j++) {
        		if (functionList.get(depthIndex).identifierExists(arrays.get(j))) {
        		ArrayList<T> arrayInfo = currentFunctionData.identifierMemory.get(arrays.get(j));
        		functionList.get(depthIndex).identifierMemory.put(arrays.get(j), arrayInfo);
        		for (int i = 0; i < Integer.parseInt(arrayInfo.get(0).toString()); i++) {
        			ArrayList<T> tArray = new ArrayList<T>(currentFunctionData.identifierMemory.get(arrays.get(j) + "[" + i + "]"));
        			//currentFunctionData.identifierMemory.get(arrays + "[" + i + "]").get(0).toString();
        			//currentFunctionData.identifierMemory.get(arrays + "[" + i + "]").get(1).toString();
        			//currentFunctionData.identifierMemory.get(arrays + "[" + i + "]").get(2).toString();
        			functionList.get(depthIndex).identifierMemory.put(arrays.get(j) + "[" + i + "]", tArray);
        			System.out.println("putted " + arrays.get(j) + "[" + i + "]");
        		}
        		}
        		}
        		
	    		//currentFunctionData = functionMemory.get(currentFunction);
	    		currentFunctionData = functionList.get(depthIndex);
	    		functionList.remove(depthIndex + 1);
	    		//currentFunction = currentFunctionData.parent;
        	}
    	}
    	
    	if (depthIndex <= 0) { // call unvisited functions here.
    		for (int i = 0; i < functionNames.size(); i++) {
    			System.out.println("Remaining Functions : " + functionNames.get(i));
    		}
    		for (int i = 0; i < functionNames.size(); i++) {
    	        
    			String func = functionNames.get(i);
    			functionNames.remove(i);
    			
    	        FunctionData functionData = new FunctionData(functionMemory.get(func).identifierMemory,
    	        		functionMemory.get(func).funcIdentifierTracker, functionMemory.get(func).getReturnType(), 
    	        		null);
    	        functionData.functionBlockCtx = functionMemory.get(func).functionBlockCtx;
    	        functionList.add(functionData);
    	        
            	depthIndex++;
            	depth[depthIndex] = func;
            	currentFunction = func;
            	currentFunctionData = functionData;
            	printOn = false;
            	for (int j = 1; j < currentFunctionData.funcIdentifierTracker.size() + 1; j++) {
            		String paramName = currentFunctionData.funcIdentifierTracker.get(j);
            		// set param value here for the unvisited errors!
            		GenerateErrorIfIdentifierDoesNotExistElseAddToMemory(paramName, "1", "not", ctx);
            		System.out.println("added value to IDENTIFIER : " + paramName);
            	}
    			EvaluateFunctionBlockWithErrorGeneration(currentFunctionData.functionBlockCtx);
    		}
    	}
    	System.out.println("currentFunction : " + currentFunction);
    	System.out.println(currentErrorData.runnable);
		return result;
    }
    

    @Override
    public T visitBlock(myGrammarParser.BlockContext ctx) {
    	System.out.println("enter visitBlock : ");
    	
        //int breakpointLineNum = Breakpoint.checkBreakpoint(ctx, breaklineList);
        //ui.getOutputConsole().append(ctx.getStart().getLine() + " : " + breakpointLineNum + "\n");
        /*
	    for (int i = 0; i < breaklineList.size(); i++) {
	    	if (breakpointLineNum != -1 && breaklineList.get(i) == breakpointLineNum) {
	    		watchListVisited.set(i, true);
	    		break;
	    	}
	    }
	    
	    for (int i = 0; i < breaklineList.size(); i++) {
	    	if (watchListVisited.get(i) == false && ctx.getStart().getLine() > breaklineList.get(i)) {
	    		breakpointLineNum = breaklineList.get(i);
	    		watchListVisited.set(i, true);
	    	}
	    }
        if(breakpointLineNum != -1){// if this statement line number matches a breakpoint line number, show watcher variables and continue option
            showWatcherDialogue(this.ui, breakpointLineNum);
        }
        */
    	T result = (T) "";
    	
    	ArrayList<String> blockIdentifier = new ArrayList<String>();
    	blockIdentifiers.add(blockIdentifier);
    	blockIndex++;
    	
    	if (catchVarName.length() > 0) {
    		GenerateErrorIfIdentifierExistsElseAddToMemory(catchVarName, catchErrorMessage, "string", "not", ctx);
    		catchVarName = "";
    	}
        result = (T) visitChildren(ctx);
        
        
        for (int i = 0; i < currentFunctionData.identifierMemory.size(); i++) {
        	for (int j = 0; j < blockIdentifiers.get(blockIndex).size(); j++) {
        	if (currentFunctionData.identifierExists(blockIdentifiers.get(blockIndex).get(j))){
        		RemoveIdentifierFromMemory(blockIdentifiers.get(blockIndex).get(j));
        	}
        	}
        }
        blockIdentifiers.remove(blockIndex);
        blockIndex--;
        
        System.out.println("visitBlock result: " + result);
        
        return result;
    }
    
    @Override
    public T visitReturnStatement(myGrammarParser.ReturnStatementContext ctx) {
    	
    	if (currentErrorData.runnable) {
    	T result = (T) visitChildren(ctx);
    	returnCount += 1;
    	System.out.println("return stmt : " + result.toString());
    	if (currentErrorData.runnable) {
    	result = (T)typeCheck(currentFunctionData.getReturnType(), result.toString(), ctx);
    	
    	if (depthIndex > 0 ) {
    	if (returnCount >= 1 && currentFunctionData.getReturnType().equals("void")) {
            /*VisitorErrorReporter.CreateErrorMessage("Return data type of the function is void, but has a return statement. ", 
                    ctx.getStart());*/
    		currentErrorData.errorStorage.add("Return data type of the function is void, but has a return statement. ");
    		currentErrorData.tokenStorage.add(ctx.getStart());
    	}
    	}
    	
        if (currentFunctionData.getReturnValue() == null)
        	currentFunctionData.setReturnValue((String) result);
    	}
    	}
    	return (T)"";    	
    }
    @Override
    public T visitStatement(myGrammarParser.StatementContext ctx) {
    	T result = (T)"";

    	System.out.println("visitStatement");
    	updateValue();
        watchLine(ctx.getStart().getLine());
    	if (currentErrorData.runnable) {        
        result = (T) visitChildren(ctx);
    	}
        return result;
    }
    
    private void showWatcherDialogue(Component parent, int line){
            if(watchList.isEmpty()){
            JOptionPane.showMessageDialog(null, "No variables in WatchList");
            
            }
            else{  
            //String[] options = new String[watchList.size()];
            Object[] options = watchList.toArray(); 
            
            Object obj;
            do {
            obj = JOptionPane.showInputDialog(null, "The following variables have these values at line "+line+": ",
            		"Breakpoint", JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
            
            if (obj != null) {
            	int selectedOption = 0;
            	for (int i = 0; i < watchList.size(); i++) {
            		if (obj.toString().equals(watchList.get(i))) {
            			selectedOption = i;
            			break;
            		}
            	}
            	JOptionPane.showMessageDialog(null, watchList.get(selectedOption) + " = "+ watchListValue.get(selectedOption));
            }
            } while (obj != null); 
            /*while(obj.toString().equals(options)){
            //JPanel panel = new JPanel();
            //JLabel lbl = new JLabel("The following variables have these values at line "+line+": ");
            //panel.add(lbl);


            if(selectedOption == JOptionPane.YES_OPTION)
            JOptionPane.showMessageDialog(null, watchList.get(selectedOption) + " = "+ watchListValue.get(selectedOption));
            
            }*/
            }
    }
    
    void GenerateErrorIfIdentifierExistsElseAddToMemory(String identifierName, String value, String type, String constant, ParserRuleContext ctx){
    
        if(currentFunctionData.identifierMemory.get(identifierName) != null){
            /*VisitorErrorReporter.CreateErrorMessage(
                "identifier "+identifierName+" already exists", 
                ctx.getStart());*/
    		currentErrorData.errorStorage.add("identifier "+identifierName+" already exists");
    		currentErrorData.tokenStorage.add(ctx.getStart());
            
        }else{
        	ArrayList<T> tArray = new ArrayList<T>();
        	tArray.add((T)value);
        	tArray.add((T)type);
        	tArray.add((T)constant);
            currentFunctionData.identifierMemory.put(identifierName, tArray);
            blockIdentifiers.get(blockIndex).add(identifierName);
        }
    	
    }
    
    void GenerateErrorIfIdentifierDoesNotExistElseAddToMemory(String idName, String value, String constant, ParserRuleContext ctx){
    	System.out.println("idName : " + idName);
        if(currentFunctionData.identifierMemory.get(idName) == null){
            /*VisitorErrorReporter.CreateErrorMessage("identifier does not exist: "+idName, 
                    ctx.getStart());*/
    		currentErrorData.errorStorage.add("identifier does not exist: " + idName);
    		currentErrorData.tokenStorage.add(ctx.getStart());
        }else{
        	ArrayList<T> tArray = new ArrayList<T>();
        	tArray.add((T)value);
        	tArray.add(currentFunctionData.identifierMemory.get(idName).get(1));
        	if (constant.equals("final")) {
        		tArray.add((T)"used");
        	}
        	else if (constant.equals("used")) {
                /*VisitorErrorReporter.CreateErrorMessage("the constant identifier : "+idName + " cannot be assigned again", 
                        ctx.getStart());*/
        		currentErrorData.errorStorage.add("the constant identifier : " +idName + " cannot be assigned again");
        		currentErrorData.tokenStorage.add(ctx.getStart());
                tArray.add((T)"used");
        	}
        	else {
        		tArray.add((T)constant);
        	}
           currentFunctionData.identifierMemory.put(idName, tArray);
        }
    }
    T GenerateErrorIfIdentifierDoesNotExistElseReturnValue(String idName, ParserRuleContext ctx){
    	boolean a = false;
        if(currentFunctionData.identifierMemory.get(idName) == null){
        	if (idName.contains("[") && idName.contains("]")) {
        		String s, s2;
        		int cut = idName.indexOf("[");
        		int cut2 = idName.indexOf("]");
        		s = idName.substring(0, cut);
        		s2 = idName.substring(cut+1, cut2);
        		int val = Integer.parseInt(currentFunctionData.identifierMemory.get(s).get(0).toString());
        		if (Integer.parseInt(s2) > (val - 1) || Integer.parseInt(s2) < 0) {
            		currentErrorData.errorStorage.add("ArrayIndexOutOfBounds Error: "+idName);
            		currentErrorData.tokenStorage.add(ctx.getStart());
            		currentErrorData.runnable = false;

            		return (T)"";
        		}
        		a = true;
        	}
            /* VisitorErrorReporter.CreateErrorMessage("identifier does not exist: "+idName, 
                    ctx.getStart()); */
        	if (!a) {
    		currentErrorData.errorStorage.add("identifier does not exist: "+idName);
    		currentErrorData.tokenStorage.add(ctx.getStart());
        	}
            return (T)"";
        }else{
            return currentFunctionData.identifierMemory.get(idName).get(0);
        }
    }
    
    void RemoveIdentifierFromMemory(String idName){
        currentFunctionData.identifierMemory.remove(idName);
    }

    @Override
    public T visitAssignment(myGrammarParser.AssignmentContext ctx) {
        String value = "";
        System.out.println("In visitAssignment");
        if (currentErrorData.runnable) {
        try {
        if(ctx.getChild(0) == ctx.Identifier()){
        	
        	if (ctx.indexes() == null && ctx.Split() == null) {
            String identifierName = ctx.Identifier().getText();
            String type, constant;
            value = "";
            type = currentFunctionData.identifierMemory.get(identifierName).get(1).toString();
            constant = currentFunctionData.identifierMemory.get(identifierName).get(2).toString();
            
            try{
                value = visit(ctx.expression()).toString();
            }catch(NullPointerException ne){
            	return (T)"";
                /*VisitorErrorReporter.CreateErrorMessage("Something wrong with the assignment statement", 
                        ctx.getStart());*/
        		/*currentErrorData.errorStorage.add("Something wrong with the assignment statement");
        		currentErrorData.tokenStorage.add(ctx.getStart());*/
            }
            
            if (!currentErrorData.runnable) {
            	return (T)"";
            }
                   
            /*
            if (!(type.equals("float")) && !(type.equals("string")) && value.contains(".0")) {
            	value = value.replace(".0", "");
            }*/
            
         
            if (ctx.OpenParen() != null) {
            	String dataType = ctx.DataType().getText();
            	if (dataType.equals(type)) {
            		if (dataType.equals("int")) {
            			try {
            			System.out.println("before conv : " + value);
            			BigDecimal num = new BigDecimal(value.replace("\"", ""));
            			num = num.setScale(0, RoundingMode.FLOOR);
            			//int convertedInt = (int) Math.floor(Float.parseFloat(value.replace("\"", "")));
            			int convertedInt = num.intValueExact();
            			value = Integer.toString(convertedInt);
            			System.out.println("convertedInt : " + convertedInt);
            			} catch(NumberFormatException nfe) {
    	                    /*VisitorErrorReporter.CreateErrorMessage("Float or String composed of numbers only can be converted to int.", 
    	                            ctx.getStart());*/
                    		currentErrorData.errorStorage.add("NumberFormatException : Float or String composed of numbers only can be converted to int.");
                    		currentErrorData.tokenStorage.add(ctx.getStart());
                    		currentErrorData.runnable = false;
                    		return (T)"";
            			}
            		}
            		else if (dataType.equals("float")) {
            			try {
                			double convertedFloat = Float.parseFloat(value.replace("\"", ""));
                			value = Double.toString(convertedFloat);           				
            			} catch(NumberFormatException nfe) {
    	                    /*VisitorErrorReporter.CreateErrorMessage("Int or String composed of numbers only can be converted to float.", 
    	                            ctx.getStart());*/
                    		currentErrorData.errorStorage.add("NumberFormatException : Int or String composed of numbers only can be converted to float.");
                    		currentErrorData.tokenStorage.add(ctx.getStart());
                    		currentErrorData.runnable = false;
                    		return (T)"";
            			}            			
            		}
            		else if (dataType.equals("string")) {
            			try {
            				value = '"' + value + '"';
            			} catch(NumberFormatException nfe) {
    	                    /*VisitorErrorReporter.CreateErrorMessage("Cannot be converted to String.", 
    	                            ctx.getStart());*/
                    		currentErrorData.errorStorage.add("Cannot be converted to String.");
                    		currentErrorData.tokenStorage.add(ctx.getStart());
            			}
            		}
            		
            		// cast to boolean not supported.
            	}
            	else {
                    /*VisitorErrorReporter.CreateErrorMessage("The data type of the assigning identifier and the cast data type should be the same.", 
                            ctx.getStart());*/
            		currentErrorData.errorStorage.add("The data type of the assigning identifier and the cast data type should be the same.");
            		currentErrorData.tokenStorage.add(ctx.getStart());
            		// cast type mismatch error
            	}
            }
            
            value = typeCheck(type, value, ctx);
            
            if (!(value.equals(""))) {
            	GenerateErrorIfIdentifierDoesNotExistElseAddToMemory(identifierName, value, constant, ctx);
            	System.out.println("value of " + identifierName + " now : " + currentFunctionData.identifierMemory.get(identifierName).get(0).toString());
            }
            System.out.println("value of " + identifierName + " now : " + currentFunctionData.identifierMemory.get(identifierName).get(0).toString());

        	}
        	
        	else if (ctx.getChild(1) == ctx.Assign() && ctx.getChild(2) == ctx.DataType()){
        		if (currentFunctionData.identifierExists(ctx.Identifier().getText())) {
        			int length = 0;
        			try {
        				length = Integer.parseInt(visit(ctx.indexes()).toString());
        			} catch (NumberFormatException nfe) {
                        /*VisitorErrorReporter.CreateErrorMessage("Type Mismatch : only integer or integer variable are possible for the array size.", 
                                ctx.getStart());*/
                		currentErrorData.errorStorage.add("Type Mismatch : only integer or integer variable are possible for the array size.");
                		currentErrorData.tokenStorage.add(ctx.getStart());
        			}
        	        String type = ctx.DataType().getText();
        	        String originalType = currentFunctionData.identifierMemory.get(ctx.Identifier().getText()).get(1).toString();
        	        if (typeCheckByTypeName(type, originalType.replace("array,", ""), ctx)) {
        			for (int i = 0; i < length; i++) {
    	        	String identifierName = ctx.Identifier().getText() + "[" + i + "]";
    	        	GenerateErrorIfIdentifierExistsElseAddToMemory(identifierName, "", type, "not", ctx);
    	        	System.out.println(identifierName + "generated.");
        			}
        			GenerateErrorIfIdentifierDoesNotExistElseAddToMemory(ctx.Identifier().getText(), Integer.toString(length), 
        					currentFunctionData.identifierMemory.get(ctx.Identifier().getText()).get(2).toString(), ctx);
        	        }
        		}
        		else {
                    /* VisitorErrorReporter.CreateErrorMessage("The identifier : " + ctx.Identifier().getText() + " does not exist.", 
                            ctx.getStart()); */
            		currentErrorData.errorStorage.add("The identifier : " + ctx.Identifier().getText() + " does not exist.");
            		currentErrorData.tokenStorage.add(ctx.getStart());
        		}
        	}
        	
        	else if (ctx.Split() != null) {
        		String rawString = visit(ctx.expression()).toString();
        		if (rawString.contains("\"")) {
        			String[] stringList = rawString.replace("\"", "").split(" ");
        			
        			String arrayName = ctx.Identifier().getText();
        			String type = currentFunctionData.identifierMemory.get(arrayName).get(1).toString();
        			String originalSize = currentFunctionData.identifierMemory.get(arrayName).get(0).toString();
        			if (type.equals("array,string")) {
        				GenerateErrorIfIdentifierDoesNotExistElseAddToMemory(arrayName, Integer.toString(stringList.length), "not", ctx);
        				if (originalSize.length() > 0) {
	        				for (int i = 0; i < Integer.parseInt(originalSize); i++) {
	        					if (currentFunctionData.identifierExists(arrayName + "[" + i + "]")){        							
	        						RemoveIdentifierFromMemory(arrayName + "[" + i + "]");
	        					}
	        				}	        				
        				}
        				
        				for (int i = 0; i < stringList.length; i++) {
        					GenerateErrorIfIdentifierExistsElseAddToMemory(arrayName + "[" + i + "]", 
        							'"' + stringList[i] +'"', type, "not", ctx);
        				} 
        				
        			}
        		}
        		else {
                    /* VisitorErrorReporter.CreateErrorMessage("The function split can only be used to the string data type.", 
                            ctx.getStart()); */       
            		currentErrorData.errorStorage.add("The function split can only be used to the string data type.");
            		currentErrorData.tokenStorage.add(ctx.getStart());
        			// not string, throw error
        		}
        	}
        	
            else{
                String type = "" , constant = "";
                value = "";
                String desiredLoc = visit(ctx.indexes()).toString();
                String identifierName = ctx.Identifier().getText() + "[" + desiredLoc +  "]";
                System.out.println("identifierName : " + identifierName);
                boolean boundCheck = false;
                int length = -1;
                //for (int i = 0; i < 1; i++) {
                try {
                	length = Integer.parseInt(currentFunctionData.identifierMemory.get(ctx.Identifier().getText()).get(0).toString());
                } catch (NullPointerException ne) {
                    /*VisitorErrorReporter.CreateErrorMessage("The array variable is not declared.", 
                            ctx.getStart());*/
            		currentErrorData.errorStorage.add("The array variable is not declared.");
            		currentErrorData.tokenStorage.add(ctx.getStart());
            		
                } catch (NumberFormatException ne) {
                    /*VisitorErrorReporter.CreateErrorMessage("The array variable is not initalized.", 
                            ctx.getStart());*/
            		currentErrorData.errorStorage.add("The array variable is not initalized.");
            		currentErrorData.tokenStorage.add(ctx.getStart());
            		
                }
                
                System.out.println("Array bound : " + length);
                try {
                if (length > -1) {
	                if (Integer.parseInt(desiredLoc) >= length) {
	                    /*VisitorErrorReporter.CreateErrorMessage("ArrayIndexOutOfBounds : Array index out of bound!", 
	                            ctx.getStart());*/
	            		currentErrorData.errorStorage.add("ArrayIndexOutOfBounds : Array index out of bound!");
	            		currentErrorData.tokenStorage.add(ctx.getStart());
	            		currentErrorData.runnable = false;
	            		return (T)"";
	            		//return null;
	            		//boundCheck = true;
	                }
	                else if (Integer.parseInt(desiredLoc) < 0) {
	            		currentErrorData.errorStorage.add("ArrayIndexOutOfBounds : Array index out of bound!");
	            		currentErrorData.tokenStorage.add(ctx.getStart());
	            		currentErrorData.runnable = false;
	            		return (T)"";
	                }
                }
                } catch (NumberFormatException nfe) {
                    /* VisitorErrorReporter.CreateErrorMessage("Only integer or integer variable is allowed for the array index.", 
                            ctx.getStart()); */
            		   currentErrorData.errorStorage.add("Only integer or integer variable is allowed for the array index.");
            		   currentErrorData.tokenStorage.add(ctx.getStart());
            		   
                }
                try {
                type = currentFunctionData.identifierMemory.get(identifierName).get(1).toString();
                constant = currentFunctionData.identifierMemory.get(identifierName).get(2).toString();
                } catch (NullPointerException ne) {
                	// 
                }
                
            	System.out.println("identifierName of the array : " + identifierName);

                try{
                    value = visit(ctx.expression()).toString();
                }catch(NullPointerException ne){
                    /* VisitorErrorReporter.CreateErrorMessage("Something wrong with the assignment statement", 
                            ctx.getStart()); */
         		   /*currentErrorData.errorStorage.add("Something wrong with the assignment statement");
         		   currentErrorData.tokenStorage.add(ctx.getStart());*/
         		   
                }
             
                if (ctx.OpenParen() != null) {
                	String dataType = ctx.DataType().getText();
                	if (dataType.equals(type)) {
                		if (dataType.equals("int")) {
                			try {
                			int convertedInt = (int) Math.floor(Float.parseFloat(value.replace("\"", "")));
                			value = Integer.toString(convertedInt);
                			System.out.println("convertedInt : " + convertedInt);
                			} catch(NumberFormatException nfe) {
        	                    /*VisitorErrorReporter.CreateErrorMessage("Float or String composed of numbers only can be converted to int.", 
        	                            ctx.getStart());*/
                      		   currentErrorData.errorStorage.add("NumberFormatException : Float or String composed of numbers only can be converted to int.");
                     		   currentErrorData.tokenStorage.add(ctx.getStart());
	                    	   currentErrorData.runnable = false;
	                    	   return (T)"";      
                     		   
                			}
                		}
                		else if (dataType.equals("float")) {
                			try {
                    			double convertedFloat = Float.parseFloat(value.replace("\"", ""));
                    			value = Double.toString(convertedFloat);           				
                			} catch(NumberFormatException nfe) {
        	                    /*VisitorErrorReporter.CreateErrorMessage("Int or String composed of numbers only can be converted to float.", 
        	                            ctx.getStart());*/
                       		   currentErrorData.errorStorage.add("NumberFormatException : Int or String composed of numbers only can be converted to float.");
                      		   currentErrorData.tokenStorage.add(ctx.getStart());
	                    	   currentErrorData.runnable = false;
	                    	   return (T)"";           		   
                			}            			
                		}
                		else if (dataType.equals("string")) {
                			try {
                				value = '"' + value + '"';
                			} catch(NumberFormatException nfe) {
        	                    /*VisitorErrorReporter.CreateErrorMessage("Cannot be converted to String.", 
        	                            ctx.getStart());*/
                        		currentErrorData.errorStorage.add("Cannot be converted to String.");
                          		currentErrorData.tokenStorage.add(ctx.getStart());
                          		
                			}
                		}
                		
                		// cast to boolean not supported.
                	}
                	else {
                        /* VisitorErrorReporter.CreateErrorMessage("The data type of the assigning identifier and the cast data type should be the same.", 
                                ctx.getStart()); */
                		currentErrorData.errorStorage.add("The data type of the assigning identifier and the cast data type should be the same.");
                  		currentErrorData.tokenStorage.add(ctx.getStart());
                  		
                		// cast type mismatch error
                	}
                }
                if (!boundCheck) {
                value = typeCheck(type, value, ctx);
                System.out.println("after mismatch check : " + value);
               
                if (!value.equals("")) 
                	GenerateErrorIfIdentifierDoesNotExistElseAddToMemory(identifierName, value, constant, ctx);
                }
                }
            //}
        	
        }
        
        else if(ctx.getChild(0) == ctx.Scan()){
        	// scan 1st argument = string only?
            String identifierName;
            if (ctx.indexes() == null) {
            	identifierName = ctx.Identifier().getText();
            }
            else {
            	int index = Integer.parseInt(visit(ctx.indexes()).toString());
            	identifierName = ctx.Identifier().getText() + "[" + index + "]";
            	if (currentFunctionData.identifierExists(ctx.Identifier().getText())) {
            		int size = Integer.parseInt(currentFunctionData.identifierMemory.get(ctx.Identifier().getText()).get(0).toString());
                	if (index > size - 1) {
                		currentErrorData.errorStorage.add("ArrayIndexOutOfBounds Error : " + identifierName);
                  		currentErrorData.tokenStorage.add(ctx.getStart());
                  		currentErrorData.runnable = false;
                  		return (T)"";
                	}
                	
            	}
            	else {
            		currentErrorData.errorStorage.add("the identifier does not exist.");
              		currentErrorData.tokenStorage.add(ctx.getStart());
              		return (T)"";
            	}
            }
            value = "";
            String type = "", constant = "";
            try {
            type = currentFunctionData.identifierMemory.get(identifierName).get(1).toString();
            constant = currentFunctionData.identifierMemory.get(identifierName).get(2).toString();
            } catch(NullPointerException ne) {
                /*VisitorErrorReporter.CreateErrorMessage("the identifier does not exist.", 
                        ctx.getStart());*/
        		currentErrorData.errorStorage.add("the identifier does not exist.");
          		currentErrorData.tokenStorage.add(ctx.getStart());
            }
            try{
                value = JOptionPane.showInputDialog(visit(ctx.expression()).toString().replace("\"", ""));
                System.out.println("Value:" + value);
                if (type.equals("string") || type.equals("char")) {
                	value = '"' + value + '"';
                }
                typeCheck(type,value,ctx);
                
            }catch(NullPointerException ne){
                /*VisitorErrorReporter.CreateErrorMessage("Something wrong with the assignment statement", 
                        ctx.getStart());*/
        		/*currentErrorData.errorStorage.add("Something wrong with the assignment statement");
          		currentErrorData.tokenStorage.add(ctx.getStart());*/
            }
            GenerateErrorIfIdentifierDoesNotExistElseAddToMemory(identifierName, value, constant, ctx);    
        }
        } catch(NullPointerException ne){
            System.out.println("visitAssignment Error: "+ne.getMessage());
    		currentErrorData.errorStorage.add("The variable does not exist!");
      		currentErrorData.tokenStorage.add(ctx.getStart());
        }
        
    }
    
    
     
    
        
    return (T)"";
    }

    public FunctionData GenerateErrorIfFuncDoesNotExistElseReturnValue(String idName, ParserRuleContext ctx){
        if(!functionExists(idName)){
            /*VisitorErrorReporter.CreateErrorMessage("function does not exist: "+idName, 
                    ctx.getStart());*/
    		currentErrorData.errorStorage.add("function does not exist: "+idName);
      		currentErrorData.tokenStorage.add(ctx.getStart());
            return null;
        }else{
            return functionMemory.get(idName);
        }
    }
    
    @Override
    public T visitIdentifierFunctionCall(myGrammarParser.IdentifierFunctionCallContext ctx) {
        System.out.println("In visitIdentifierFunctionCall");
        T result = (T)"";
        if (currentErrorData.runnable) {
        	
        if (!functionExists(ctx.Identifier().getText())) {
            /*VisitorErrorReporter.CreateErrorMessage("the function does not exist: " + ctx.Identifier(), 
                    ctx.getStart());*/
    		currentErrorData.errorStorage.add("the function does not exist: " + ctx.Identifier());
      		currentErrorData.tokenStorage.add(ctx.getStart());
        }
	try{
        String funcName = ctx.Identifier().getText();
        String exParam = "", temp = "";
        String[] postParam = new String[1];
        String[] splitRes = new String[1];
        String[] paramNameList = new String[1];
        boolean hasParam = false;
        boolean hasError = false;
        if (ctx.exprList() != null)
        	exParam = ctx.exprList().getText();
        if (!(exParam.equals(""))){
        	exParam = exParam.replaceAll("\\s", "");
        	postParam = exParam.split(",");
        	paramNameList = new String[postParam.length];
    		for (int i = 0; i < postParam.length; i++){
    		System.out.println("Param List : " + postParam[i]);
    		paramNameList[i] = postParam[i];
    		}            
        	hasParam = true;
        	
        		T res = (T) visitChildren(ctx);
        		System.out.println("Result : " + res);
        		temp = (String) res;
        		splitRes = temp.split("\\s");
        		System.out.println(splitRes[0]);
        		for (int i = 0; i < splitRes.length; i++){
        		postParam[i] = splitRes[i];
        		System.out.println("Post : " + postParam[i]);
        		}
        	
        }
        
        FunctionData functionData = new FunctionData(functionMemory.get(funcName).identifierMemory,
        		functionMemory.get(funcName).funcIdentifierTracker, functionMemory.get(funcName).getReturnType(), 
        		null);
        functionData.functionBlockCtx = functionMemory.get(funcName).functionBlockCtx;
        functionList.add(functionData);
        //functionData = GenerateErrorIfFuncDoesNotExistElseReturnValue(funcName, ctx);
        
        
        if(functionData != null){
        	if (hasParam){
        		
        		String[] memToArray = currentFunctionData.identifierMemory.keySet().toArray(new String[currentFunctionData.identifierMemory.keySet().size()]);
            	int k = 1;
            	while (k <= postParam.length){
            		System.out.println(k);
	        		/*for (int i = 1; i <= functionData.identifierMemory.size(); i++){
	        			identifierMemory.replace(functionData.funcIdentifierTracker.get(k).toString(), (T) postParam[i-1]);
	        			k++;
	        		}*/
	        		
	        		if (k > postParam.length)
	        			break;
	        		
	            	for (int i = 0; i < postParam.length; i++){
	            		boolean found = false;
            			if (postParam.length > functionData.funcIdentifierTracker.size()) {
            	            /*VisitorErrorReporter.CreateErrorMessage(
            	                    "Parameter exceeds the number of arguments the function needs", 
            	                    ctx.getStart());*/
            	    		currentErrorData.errorStorage.add("Parameter exceeds the number of arguments the function needs");
            	      		currentErrorData.tokenStorage.add(ctx.getStart());
            	            hasError = true;
            	            k = postParam.length + 1;
            	            break;
            			}
            			else if (postParam.length < functionData.funcIdentifierTracker.size()) {
            	            /*VisitorErrorReporter.CreateErrorMessage(
            	                    "Parameter does not suffice the number of arguments the function needs", 
            	                    ctx.getStart());*/
            	    		currentErrorData.errorStorage.add("Parameter does not suffice the number of arguments the function needs");
            	      		currentErrorData.tokenStorage.add(ctx.getStart());
            	            k = postParam.length + 1;
            	            hasError = true;
            	            break;
            			}
	            		for (int j = 0; j < currentFunctionData.identifierMemory.keySet().size(); j++){
	            			System.out.println("j : " + j);	            	
	            			
	            			if (k > postParam.length)
	            				break;
	            			
	            			if (paramNameList[i].equals(memToArray[j])) {
	            				System.out.println("CONTAINS VARIABLE" + memToArray[j]);
	            				String s;
	            				boolean a = typeCheckByTypeName(functionData.identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(1).toString(), currentFunctionData.identifierMemory.get(memToArray[j]).get(1).toString(), ctx);
	            				//s = typeCheck(identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(1).toString(), identifierMemory.get(memToArray[j]).get(0).toString(), ctx);
	            				
	            				//System.out.println("Final s : " + s);
	            				
	            				ArrayList<T> tArray = new ArrayList<T>();
	            				tArray.add((T) currentFunctionData.identifierMemory.get(memToArray[j]).get(0).toString());
	            				tArray.add((T) functionData.identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(1).toString());
	            				tArray.add((T) functionData.identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(2).toString());
	            				functionData.identifierMemory.replace(functionData.funcIdentifierTracker.get(k).toString(), tArray);
	            				
	            				if (currentFunctionData.identifierMemory.get(memToArray[j]).get(1).toString().contains("array,")) {
	            					arrays.add(memToArray[j]);
		            				for (int l = 0; l < Integer.parseInt(currentFunctionData.identifierMemory.get(memToArray[j]).get(0).toString()); l++) {
		            					
		            					
		            					ArrayList<T> tArray2 = new ArrayList<T>();
			            				tArray2.add((T) currentFunctionData.identifierMemory.get(memToArray[j] + "[" + l + "]").get(0).toString());
			            				tArray2.add((T) currentFunctionData.identifierMemory.get(memToArray[j] + "[" + l + "]").get(1).toString());
			            				tArray2.add((T) currentFunctionData.identifierMemory.get(memToArray[j] + "[" + l + "]").get(2).toString());
			            				functionData.identifierMemory.put(functionData.funcIdentifierTracker.get(k) + "[" + l + "]", tArray2);

		            				} 
	            				}
	            				k++;
	            				found = true;
	            				break;
	            			}	            			
	            		}
	            		
        				if (!found){
        					System.out.println("function param dataType : " + functionData.identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(1));
        					String s;
        					// ����
        					if (postParam[i].trim().equals("")) {
        						System.out.println("real?");
        						return (T)"";
        					}
        					s = typeCheck(functionData.identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(1).toString(), postParam[i], ctx);
        					System.out.println("s : " + s);
        					ArrayList<T> tArray = new ArrayList<T>();
        					tArray.add((T) s);
        					tArray.add((T) functionData.identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(1).toString());
        					tArray.add((T) functionData.identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(2).toString());
        					functionData.identifierMemory.replace(functionData.funcIdentifierTracker.get(k).toString(), tArray);
	        				k++;	            				
        				}
        				
	            	}
	            } 
            } 
        	else {
        		if (functionData.funcIdentifierTracker.size() > 0) {
    	            /*VisitorErrorReporter.CreateErrorMessage(
    	                    "the function requires 1 ore more parameter value", 
    	                    ctx.getStart());*/
    	    		currentErrorData.errorStorage.add("the function requires 1 ore more parameter value");
    	      		currentErrorData.tokenStorage.add(ctx.getStart());
    	            hasError = true;
        		}
        	}
        	if (!hasError) {
        	//functionData.parent = currentFunction;
        	depthIndex++;
        	depth[depthIndex] = funcName;
        	currentFunction = funcName;
        	currentFunctionData = functionData;
        	for (int z = 0; z < functionNames.size(); z++) {
        		if (functionNames.get(z).equals(funcName)) {
        			functionNames.remove(z);
        		}
        	}
            result = EvaluateFunctionBlockWithErrorGeneration(functionData.functionBlockCtx);//what about function identifiers???
            
            System.out.println("IDENTIFIER CALL RESULT : " + result);
        	}
        	else {
        		result = (T)"";
        	}
        }
        }catch(NullPointerException ne){
        	System.out.println("Caught in visitIdentifierFunctionCall: "+ne.getMessage());
        }
    }
        return result;
    }

    @Override
    public T visitPrintlnFunctionCall(myGrammarParser.PrintlnFunctionCallContext ctx) {
        System.out.println("In VisitPrintlnFunctionCall: " + ctx.getText());
        T result = (T)"";
        if (currentErrorData.runnable) {
        if (printOn) {
        if(ctx.expression() != null) {
        	
            String printAppender = visitChildren(ctx).toString() + "\n";
            ui.getOutputConsole().append(printAppender.replace("\"", ""));
            ui.getOutputConsole().update(ui.getOutputConsole().getGraphics());
            result = (T) printAppender;

        }
        else {
            result = (T)"\n";
            ui.getOutputConsole().append("\n");
            ui.getOutputConsole().update(ui.getGraphics());
        }
        System.out.println("Writing a new line, result: " + result);
        }
    	}
        return (T)"";
    }

    @Override
    public T visitPrintFunctionCall(myGrammarParser.PrintFunctionCallContext ctx) {
        System.out.println("In visitPrintFunctionCall");
        if (currentErrorData.runnable) {
        if (printOn) {
        String printAppender = visitChildren(ctx).toString();
        T result = (T) printAppender;
        ui.getOutputConsole().append(printAppender.replace("\"", ""));
        ui.getOutputConsole().update(ui.getOutputConsole().getGraphics()); 
        return result;
        }
        else 
        	return (T)"";
        }
        else 
        	return (T)"";
    }
    
    T EvaluatelBlockWithErrorGeneration(myGrammarParser.BlockContext ctx){
        T result = (T)"";
        try{
            result = (T)visitBlock(ctx).toString();
        }catch(NullPointerException ne){
            /*VisitorErrorReporter.CreateErrorMessage(
                ne.getMessage()+
                " - Could not resolve conditional code block", 
                ctx.getStart());*/
    		/*currentErrorData.errorStorage.add(ne.getMessage()+
                    " - Could not resolve conditional code block");
      		currentErrorData.tokenStorage.add(ctx.getStart());*/
        }
        return result;
    }
    
    T EvaluateFunctionBlockWithErrorGeneration(myGrammarParser.FunctionBlockContext ctx) {
    	T result = (T)"";
        try{
            result = (T)visitFunctionBlock(ctx).toString();
        }catch(NullPointerException ne){
            /*VisitorErrorReporter.CreateErrorMessage(
                ne.getMessage()+
                " - Could not resolve function code block", 
                ctx.getStart());*/
    		currentErrorData.errorStorage.add(ne.getMessage()+
                    " - Could not resolve function code block");
      		currentErrorData.tokenStorage.add(ctx.getStart());
            //ne.printStackTrace();
        }    	
    	return result;
    }
    
    @Override
    public T visitIfStatement(myGrammarParser.IfStatementContext ctx) {
        System.out.println("In visitIfStatement");
        System.out.println(ctx.getChildCount()+" children in if statement");
        T result = (T)"";
        if (currentErrorData.runnable) {
        boolean checker = true; // 
        boolean changed = false;
        int checkerCount = ctx.getChildCount() - 3;
        
        if (ctx.ifStat().block().returnStatement() != null) {
        	checker = true;
        	changed = true;
        }
       
        if (checker) {
        	System.out.println("checkerCount : " + ctx.elseIfStat().size());
        	for(int c = 0;c < checkerCount;c++) {
        		if (ctx.elseIfStat(c).block().returnStatement() == null) {
        			checker = false;
        		}
        	}
        }
        
        if (checker && ctx.elseStat() != null) {
        	if (ctx.elseStat().block().returnStatement() == null) {
        		checker = false;
        	}
        }
        
        if (ctx.elseStat() == null) {
        	if (checker) {
        		checker = false;
        	}
        }
        
        if (!checker && changed) {
            /*VisitorErrorReporter.CreateErrorMessage(
                    "The function may not return value when if condition (or else if) is not satisfied.", 
                    ctx.getStart());*/
    		currentErrorData.errorStorage.add("The function may not return value when if condition (or else if) is not satisfied.");
      		currentErrorData.tokenStorage.add(ctx.getStart());
        }
        
        try{
            Boolean ifConditional = Boolean.parseBoolean(visitIfStat(ctx.ifStat()).toString());
            //if first condition is satisfied, then don't move to succeeding else-if code blocks
            if(ifConditional){
            	System.out.println("if satisfied.");
                result = EvaluatelBlockWithErrorGeneration(ctx.ifStat().block());
            }else{
                //check else if statements
                int elseIfStatmentCount = ctx.getChildCount() - 3;
                Boolean ifElseConditional = false;
                for(int c = 0;c < elseIfStatmentCount;c++){
                    System.out.println("if statement not statisfied, checking ifelse statements");
                    ifElseConditional = Boolean.parseBoolean(visitElseIfStat(ctx.elseIfStat(c)).toString());
                    System.out.println(ifElseConditional);
                    if(ifElseConditional){
                        result = EvaluatelBlockWithErrorGeneration(ctx.elseIfStat(c).block());
                        break;
                    }
                }
                //if no ifelse conditions were satisfied, then check if else statement exists
                if(!ifElseConditional && ctx.elseStat() != null){
                    System.out.println("ifelse statements not statisfied, checking else statements");
                    result = EvaluatelBlockWithErrorGeneration(ctx.elseStat().block());
                    
                }
            }
        }catch(NullPointerException ne){
            /*VisitorErrorReporter.CreateErrorMessage(
                    ne.getMessage()+
                    " - Could not resolve condition inside if statement", 
                    ctx.getStart());*/
    		currentErrorData.errorStorage.add(ne.getMessage()+
                    " - Could not resolve condition inside if statement");
      		currentErrorData.tokenStorage.add(ctx.getStart());
        }
        catch(Exception e){
            /*VisitorErrorReporter.CreateErrorMessage(
                    e.getMessage()+
                    " - Could not resolve code block inside if statement", 
                    ctx.getStart());*/
            
    		currentErrorData.errorStorage.add(e.getMessage()+
                    " - Could not resolve code block inside if statement");
      		currentErrorData.tokenStorage.add(ctx.getStart());
        }
        
    }
   
        
        return result;
    }

    @Override
    public T visitIfStat(myGrammarParser.IfStatContext ctx) {
        System.out.println("In visitIfStat");
        T result = (T)"";
        if (currentErrorData.runnable) {
        int numberOfChildren = ctx.getChildCount();
        System.out.println(numberOfChildren+" children in visitIfStat");
        
        ParseTree conditionChild = ctx.expression();
        ParseTree blockChild = ctx.block();
        
        Boolean condition = false;
        try{
            condition = Boolean.parseBoolean(visit(conditionChild).toString());
        }catch(Exception e){
            /*VisitorErrorReporter.CreateErrorMessage(
                    e.getMessage()+
                    " - Could not resolve if statement condition", 
                    ctx.getStart());*/
    		currentErrorData.errorStorage.add(e.getMessage()+
                    " - Could not resolve if statement condition");
      		currentErrorData.tokenStorage.add(ctx.getStart());
        }
       
        return (T)String.valueOf(condition);
        }
        else 
        	return (T)"";
    }
    
    @Override
    public T visitElseIfStat(myGrammarParser.ElseIfStatContext ctx) {
        System.out.println("In visitElseIfStat");
        T result = (T)"";
        if (currentErrorData.runnable) {
        int numberOfChildren = ctx.getChildCount();
        System.out.println(numberOfChildren+" children in visitIfStat");
        
        ParseTree conditionChild = ctx.expression();
        ParseTree blockChild = ctx.block();
        
        Boolean condition = false;
        try{
            condition = Boolean.parseBoolean(visit(conditionChild).toString());
        }catch(Exception e){
            /*VisitorErrorReporter.CreateErrorMessage(
                    e.getMessage()+
                    " - Could not resolve else if condition", 
                    ctx.getStart());*/
    		currentErrorData.errorStorage.add(e.getMessage()+
                    " - Could not resolve else if condition");
      		currentErrorData.tokenStorage.add(ctx.getStart());
        }
        
        /*if(condition){//implement error recovery?
            try{
                result = (T)visit(blockChild).toString();
            }catch(NullPointerException ne){
                VisitorErrorReporter.CreateErrorMessage(
                    ne.getMessage()+
                    " - Could not resolve if statement body code block", 
                    ctx.getStart());
            }
        }
        
        return result;*/
        return (T)String.valueOf(condition);
        } 
        else 
        	return (T)"";
    }

    @Override
    public T visitElseStat(myGrammarParser.ElseStatContext ctx) {
        T result = (T)"";
        ui.getOutputConsole().append("Else : " + ctx.getStart().getLine() + "\n");
        int numberOfChildren = ctx.getChildCount();
        System.out.println(numberOfChildren+" children in visitIfStat");
        if (currentErrorData.runnable) {
        ParseTree blockChild = ctx.block();
        try{
            result = (T)visit(blockChild).toString();
        }catch(NullPointerException ne){
            /*VisitorErrorReporter.CreateErrorMessage(
                ne.getMessage()+
                " - Could not resolve if statement body code block", 
                ctx.getStart());*/
    		currentErrorData.errorStorage.add(ne.getMessage()+
                    " - Could not resolve if statement body code block");
      		currentErrorData.tokenStorage.add(ctx.getStart());
        }
        }
        return result;
    }
    
    @Override
    public T visitTryStatement(myGrammarParser.TryStatementContext ctx) {
    	if (currentErrorData.runnable) {
    	ErrorData errorData = new ErrorData();
    	Boolean key = false;
    	for (int i = 0; i < ctx.catchStat().size(); i++) {
    		errorData.errorType.add(ctx.catchStat(i).Exception().getText());
    	}
    	
    	errorData.runnable = true;
    	errorData.blockCtx = ctx.tryStat().block();
    	errorBlockIndex += 1;
    	errorList.add(errorData);
    	currentErrorData = errorData;
    	
    	
    	EvaluatelBlockWithErrorGeneration(errorData.blockCtx);
    	if (currentErrorData.runnable == false) {
    		key = true;
    	}
    	currentErrorData.runnable = true;
        	for (int i = 0; i < ctx.catchStat().size(); i++) {
        		boolean enter = false; 
        		catchVarName = "";
        		if (ctx.catchStat(i).Exception().getText().equals("ArrayIndexOutOfBounds")) {
        			
        			for (int j = currentErrorData.errorStorage.size() - 1; j >= 0 ; j--) {
	            		if (currentErrorData.errorStorage.get(j).contains("ArrayIndexOutOfBounds")){
	            	        catchErrorMessage = MessageFormat.format(
	                                "Exception! line {0}, char {2}: {1}",
	                                currentErrorData.tokenStorage.get(j).getLine(),
	                                currentErrorData.errorStorage.get(j),
	                                currentErrorData.tokenStorage.get(j).getCharPositionInLine());
	            	        catchVarName = ctx.catchStat(i).Identifier().getText();
	            			currentErrorData.errorStorage.remove(j);
	            			currentErrorData.tokenStorage.remove(j);
	            			enter = true;
	            			key = false;
	            		}	
        			}
        			if (enter) {
        			ParseTree catchStatVisitor = ctx.catchStat(i);
        			visit(catchStatVisitor);
        			}
        		}

        		if (ctx.catchStat(i).Exception().getText().equals("NumberFormatException")) {
        			
        			for (int j = currentErrorData.errorStorage.size() - 1; j >= 0 ; j--) {
	            		if (currentErrorData.errorStorage.get(j).contains("NumberFormatException")){
	            	        catchErrorMessage = MessageFormat.format(
	                                "Exception! line {0}, char {2}: {1}",
	                                currentErrorData.tokenStorage.get(j).getLine(),
	                                currentErrorData.errorStorage.get(j),
	                                currentErrorData.tokenStorage.get(j).getCharPositionInLine());
	            	        catchVarName = ctx.catchStat(i).Identifier().getText();
	            			currentErrorData.errorStorage.remove(j);
	            			currentErrorData.tokenStorage.remove(j);
	            			
	            			enter = true;
	            			key = false;
	            		}	
        			}
        			if (enter) {
        			ParseTree catchStatVisitor = ctx.catchStat(i);
        			visit(catchStatVisitor);
        			}
        		}
        		
        		if (ctx.catchStat(i).Exception().getText().equals("ArithmeticException")) {
        			
        			for (int j = currentErrorData.errorStorage.size() - 1; j >= 0 ; j--) {
	            		if (currentErrorData.errorStorage.get(j).contains("ArithmeticException")){
	            	        catchErrorMessage = MessageFormat.format(
	                                "Exception! line {0}, char {2}: {1}",
	                                currentErrorData.tokenStorage.get(j).getLine(),
	                                currentErrorData.errorStorage.get(j),
	                                currentErrorData.tokenStorage.get(j).getCharPositionInLine());
	            	        catchVarName = ctx.catchStat(i).Identifier().getText();
	            			currentErrorData.errorStorage.remove(j);
	            			currentErrorData.tokenStorage.remove(j);
	            			enter = true;
	            			key = false;
	            		}	
        			}
        			if (enter) {
        			ParseTree catchStatVisitor = ctx.catchStat(i);
        			visit(catchStatVisitor);
        			}
        			catchVarName = "";
        		}
        		
        		
        	}
        	
        	if (ctx.finallyStat() != null) {
			ParseTree finallyStatVisitor = ctx.finallyStat();
			visit(finallyStatVisitor);    
        	}
        
        if (errorBlockIndex - 1 <= 0) {
    	for (int i = 0; i < currentErrorData.errorStorage.size(); i++) {
    		System.out.println("where : " + i);
    		System.out.println("errors " + "[" + i + "] : " + currentErrorData.errorStorage.get(i));
    		if (currentErrorData.errorStorage.get(i).contains("ArrayIndexOut") ||
        			currentErrorData.errorStorage.get(i).contains("NumberFormat") ||
        			currentErrorData.errorStorage.get(i).contains("ArithmeticException"))
    		{
    			errorList.get(errorBlockIndex - 1).runnable = false;
    		}
    		VisitorErrorReporter.CreateErrorMessage(currentErrorData.errorStorage.get(i),
    				currentErrorData.tokenStorage.get(i));
    	}
        }
        else {
        	System.out.println(currentErrorData.errorStorage.size());
        	for (int i = 0; i < currentErrorData.errorStorage.size(); i++) {
        		errorList.get(errorBlockIndex - 1).errorStorage.add(currentErrorData.errorStorage.get(i));
        	    errorList.get(errorBlockIndex - 1).tokenStorage.add(currentErrorData.tokenStorage.get(i));  
        	}   
        }
    	
    	errorList.remove(errorBlockIndex);
    	errorBlockIndex -= 1;
    	currentErrorData = errorList.get(errorBlockIndex);
    	if (key == true && errorBlockIndex > 0)
    		currentErrorData.runnable = false;
    	
    	System.out.println(currentErrorData.runnable);
    	}
		return (T)"";
    	
    }
    
    @Override
    public T visitTryStat(myGrammarParser.TryStatContext ctx) {
    	return (T)"";
    }
    
    @Override
    public T visitCatchStat(myGrammarParser.CatchStatContext ctx) {
    	EvaluatelBlockWithErrorGeneration(ctx.block());
    	return (T)"";
    }
    
    @Override
    public T visitFinallyStat(myGrammarParser.FinallyStatContext ctx) {
    	EvaluatelBlockWithErrorGeneration(ctx.block());
    	return (T)"";
    }

    Boolean functionExists(String funcName){
        return functionMemory.get(funcName) != null;
    }
    
    void saveFunctionToMemory(String funcName, FunctionData value){
        functionMemory.put(funcName, value);
    }
    
    void RemoveFuncFromMemory(String idName){
        functionMemory.remove(idName);
    }
    
    String[] ExtractParamsFromFunctionValue(String paramString){
        return paramString.split(functionParamSeparator);
    }
    
    public void GenerateErrorIfFuncExistsElseAddToMemory(String identifierName, FunctionData value, 
            ParserRuleContext ctx){
        if(functionMemory.get(identifierName) != null){
            /*VisitorErrorReporter.CreateErrorMessage(
                "function "+identifierName+" already exists", 
                ctx.getStart());*/
    		currentErrorData.errorStorage.add("function "+identifierName+" already exists");
      		currentErrorData.tokenStorage.add(ctx.getStart());
        }else{
            functionMemory.put(identifierName, value);
        }
    }
    
    @Override
    public T visitFunctionDecl(myGrammarParser.FunctionDeclContext ctx) {//prints twice
    	if (currentErrorData.runnable) {
        System.out.println("In visitFunctionDecl");

        String funcName = ctx.Identifier().getText();
        HashMap<String, ArrayList<T>> funcIdentifiers = new HashMap<String, ArrayList<T>>();
        FunctionData funcData = new FunctionData();
        
        funcData.setReturnType(ctx.DataType().getText());
        if(ctx.paramIdList() != null){
        	// if openbracket is null
        	// else �ؿ��̰�.

            for(int c = 0;c < ctx.paramIdList().Identifier().size();c++){
            	ArrayList<T> tArray = new ArrayList<T>();
            	tArray.add((T)"");
            	
            	if (!(ctx.paramIdList().DataType(c).getText().contains("[]"))) 
            		tArray.add((T)ctx.paramIdList().DataType(c).getText());
            	else 
            		tArray.add((T)("array," + ctx.paramIdList().DataType(c).getText().replace("[]", "")));            	
            	tArray.add((T)"not");
            	funcData.funcIdentifierTracker.put(c+1, ctx.paramIdList().Identifier(c).getText());
                funcIdentifiers.put(ctx.paramIdList().Identifier(c).getText(), tArray);
                System.out.println("PUT : " + ctx.paramIdList().Identifier(c).getText());
        
            }
            funcData.identifierMemory = funcIdentifiers;
        }
        funcData.functionBlockCtx = ctx.functionBlock();
        functionNames.add(ctx.Identifier().getText());
        
        
        //iden check
        
        /*if (ctx.functionBlock().block().returnStatement() == null) {
        	for (int i = 0; i < ctx.functionBlock().block().statement().size(); i++) {
        		if (ctx.functionBlock().block().statement(i).ifStatement() != null)
        		{
        			if (ctx.functionBlock().block().statement(i).ifStatement().ifStat().block().returnStatement() != null) {
        				if (ctx.functionBlock().block().statement(i).ifStatement().elseStat() != null) {
        				if (ctx.functionBlock().block().statement(i).ifStatement().elseStat().block().returnStatement() != null) {
        					returnCheck = true;
        					break;
        				}
        				}
        			}
        			// how to handle the nested one? (if else inside while loop)
        		}
        	}
        }*/
     
        
        
        GenerateErrorIfFuncExistsElseAddToMemory(funcName, funcData, ctx);
        System.out.println("Created Function Name : " + funcName);
        
        //return (T)visitChildren(ctx);
    	}
        return (T)"";
    }

    @Override
    public T visitForStatement(myGrammarParser.ForStatementContext ctx) {
        System.out.println("In visitForStatement");
        if (currentErrorData.runnable) {
	try{    
        T result = (T)"";
        String temp = "";
        Double lowerLimit = 0.0;
        Double upperLimit = 0.0;
        try{
            lowerLimit = Double.parseDouble(visit(ctx.expression(0)).toString());
        }catch(Exception e){
            /*VisitorErrorReporter.CreateErrorMessage(
                e.getMessage()+
                " - for loop lower limit must be an object of type Number", 
                ctx.getStart());*/
    		currentErrorData.errorStorage.add(e.getMessage()+
                    " - for loop lower limit must be an object of type Number");
      		currentErrorData.tokenStorage.add(ctx.getStart());
        }
        try{
            upperLimit = Double.parseDouble(visit(ctx.expression(1)).toString());
        }catch(Exception e){
            /*VisitorErrorReporter.CreateErrorMessage(
                e.getMessage()+
                " - for loop upper limit must be an object of type Number", 
                ctx.getStart());*/
    		currentErrorData.errorStorage.add(e.getMessage()+
                    " - for loop upper limit must be an object of type Number");
      		currentErrorData.tokenStorage.add(ctx.getStart());
        }
        
        if(lowerLimit < upperLimit){
            while(lowerLimit < upperLimit){
            	//update
            	if (ctx.DataType().getText().equals("int") || ctx.DataType().getText().equals("short")
            			|| ctx.DataType().getText().equals("long"))
            	{
            		long val = (long) Double.parseDouble(lowerLimit.toString());
                GenerateErrorIfIdentifierExistsElseAddToMemory(
                    ctx.Identifier().getText(), String.valueOf(val), ctx.DataType().getText(), "not", ctx);
            	}
            	// for string type?
            	else {
                    GenerateErrorIfIdentifierExistsElseAddToMemory(
                            ctx.Identifier().getText(), lowerLimit.toString(), ctx.DataType().getText(), "not", ctx);        		
            	}
            	System.out.println("LowerLimit : " + lowerLimit);
            	System.out.println(ctx.Identifier().getText());
                temp = EvaluatelBlockWithErrorGeneration(ctx.block()).toString();
                result = (T) (result + temp);
                lowerLimit++;
                RemoveIdentifierFromMemory(ctx.Identifier().getText());
            }
        }
        else if(upperLimit < lowerLimit - 1){
        	lowerLimit = lowerLimit - 1;
            while(upperLimit <= lowerLimit){
            	//update
            	if (ctx.DataType().getText().equals("int") || ctx.DataType().getText().equals("short")
            			|| ctx.DataType().getText().equals("long"))
            	{
            		long val = (long) Double.parseDouble(lowerLimit.toString());
                GenerateErrorIfIdentifierExistsElseAddToMemory(
                    ctx.Identifier().getText(), String.valueOf(val), ctx.DataType().getText(), "not", ctx);
            	}
            	// for string type?
            	else {
                    GenerateErrorIfIdentifierExistsElseAddToMemory(
                            ctx.Identifier().getText(), lowerLimit.toString(), ctx.DataType().getText(), "not", ctx);        		
            	}
            	System.out.println("LowerLimit : " + lowerLimit);
            	System.out.println(ctx.Identifier().getText());
                temp = EvaluatelBlockWithErrorGeneration(ctx.block()).toString();
                result = (T) (result + temp);
                lowerLimit--;
                RemoveIdentifierFromMemory(ctx.Identifier().getText());
            }
        }
        return result;
	}catch(Exception e){
		e.printStackTrace();
            /*VisitorErrorReporter.CreateErrorMessage(
               "Identifier does not exist: " + ctx.Identifier(), 
                ctx.getStart());*/
		currentErrorData.errorStorage.add("Identifier does not exist: " + ctx.Identifier());
  		currentErrorData.tokenStorage.add(ctx.getStart());
        }
        }
        return (T)"";	
    }

    @Override
    public T visitWhileStatement(myGrammarParser.WhileStatementContext ctx) {//need to implement variables to test
        System.out.println("In visitWhileStatement, condition: "+ctx.expression().getText());
      
        
        T result = (T)"";
        if (currentErrorData.runnable) {
        Boolean whileConditional = false;
        try{
            whileConditional = Boolean.parseBoolean(visit(ctx.expression()).toString());
        }catch(Exception e){
            /*VisitorErrorReporter.CreateErrorMessage(
                e.getMessage()+
                " - Could not resolve while statement condition. It must return an object of type Bool", 
                ctx.getStart()
            );*/
    		currentErrorData.errorStorage.add(e.getMessage()+
                    " - Could not resolve while statement condition. It must return an object of type Bool");
      		currentErrorData.tokenStorage.add(ctx.getStart());        	
        }
        while(whileConditional){
          String iterationOutput = EvaluatelBlockWithErrorGeneration(ctx.block()).toString();
          returnCount = 0;
          result = (T) (result + iterationOutput);
          whileConditional = Boolean.parseBoolean(visit(ctx.expression()).toString());
          if (!currentErrorData.runnable) {
        	  break;
          }
          //outputArea.setText(outputArea.getText() + iterationOutput);
        }
        }
        return result;
    }
    
    @Override
    public T visitDoWhileStatement(myGrammarParser.DoWhileStatementContext ctx) {
    	T result = (T)"";
    	if (currentErrorData.runnable) {
    	Boolean whileConditional = false;
    	System.out.println("in visit do while");
    	String iterationOutput = EvaluatelBlockWithErrorGeneration(ctx.block()).toString();
    	result = (T) (result + iterationOutput);
    	whileConditional = Boolean.parseBoolean(visit(ctx.expression()).toString());
    	while (whileConditional) {
        	iterationOutput = EvaluatelBlockWithErrorGeneration(ctx.block()).toString();
        	result = (T) (result + iterationOutput);
        	whileConditional = Boolean.parseBoolean(visit(ctx.expression()).toString());    		
    	}
    	}
    	return result;
    }

    @Override
    public T visitIdList(myGrammarParser.IdListContext ctx) {
        System.out.println("In visitIdList");
        return visitChildren(ctx);
    }

    @Override
    public T visitExprList(myGrammarParser.ExprListContext ctx) {
        System.out.println("In visitExprList");
        return visitChildren(ctx);
    }

    @Override
    public T visitLtExpression(myGrammarParser.LtExpressionContext ctx) {
        return CompareExp(ctx, ComparisonOpType.LESS);
    }

    @Override
    public T visitGtExpression(myGrammarParser.GtExpressionContext ctx) {
        return CompareExp(ctx, ComparisonOpType.GREATER);
    }

    @Override
    public T visitBoolExpression(myGrammarParser.BoolExpressionContext ctx) {
        return (T)ctx.Bool().toString();
    }

    @Override
    public T visitNotEqExpression(myGrammarParser.NotEqExpressionContext ctx) {
        return CompareExp(ctx, ComparisonOpType.NOTEQUAL);
    }

    @Override
    public T visitNumberExpression(myGrammarParser.NumberExpressionContext ctx) {
        String number = ctx.getText();
        System.out.println("in visitNumberExpression: " + number);
        return (T) number;
    }

    @Override
    public T visitIdentifierExpression(myGrammarParser.IdentifierExpressionContext ctx) {
    	System.out.println("in visit IdentifierExp");
        String idName = ctx.Identifier().getText();
        System.out.println("idName : " + idName);
        System.out.println("current Function : " + currentFunction);
        String result = GenerateErrorIfIdentifierDoesNotExistElseReturnValue(idName, ctx).toString();
        if(CompilerHelper.isStringNullOrWhiteSpace(result)){
            /*VisitorErrorReporter.CreateErrorMessage(
                "identifier "+idName+" has no value yet", 
                ctx.getStart());*/
    		currentErrorData.errorStorage.add("Identifier "+idName+" has no value yet");
      		currentErrorData.tokenStorage.add(ctx.getStart()); 
        }
        System.out.println("result was : " + result);
        return (T)result;
    }

    @Override
    public T visitModulusExpression(myGrammarParser.ModulusExpressionContext ctx) {
        T result = Calculate(ctx, MathOpType.MOD);
        return result;
    }

    @Override
    public T visitNotExpression(myGrammarParser.NotExpressionContext ctx) {
        System.out.println("inNotExpression has "+ctx.getChildCount()+" children");
        ParseTree origBoolChild = ctx.getChild(1);
        String result = "";
        try{
            result = String.valueOf(!Boolean.parseBoolean(visit(origBoolChild).toString()));
        }catch(Exception e){
            /*VisitorErrorReporter.CreateErrorMessage(e.getMessage(), 
                    ctx.getStart());*/
    		currentErrorData.errorStorage.add(e.getMessage());
      		currentErrorData.tokenStorage.add(ctx.getStart()); 
        }
        return (T)result;
    }

    @Override
    public T visitMultiplyExpression(myGrammarParser.MultiplyExpressionContext ctx) {
        T result = Calculate(ctx, MathOpType.MULT);
        return result;
    }

    @Override
    public T visitGtEqExpression(myGrammarParser.GtEqExpressionContext ctx) {
        return CompareExp(ctx, ComparisonOpType.GREATEREQUAL);
    }
    
    
    
    @Override
    public T visitDivideExpression(myGrammarParser.DivideExpressionContext ctx) {
        T result = Calculate(ctx, MathOpType.DIV);
        return result;
    }

    @Override
    public T visitOrExpression(myGrammarParser.OrExpressionContext ctx) {
        return CompareExp(ctx, ComparisonOpType.OR);
    }

    @Override
    public T visitPowerExpression(myGrammarParser.PowerExpressionContext ctx) {
        T result = Calculate(ctx, MathOpType.POW);
        return result;
    }

    @Override
    public T visitEqExpression(myGrammarParser.EqExpressionContext ctx) {
        return CompareExp(ctx, ComparisonOpType.EQUAL);
    }

    @Override
    public T visitAndExpression(myGrammarParser.AndExpressionContext ctx) {
        return CompareExp(ctx, ComparisonOpType.AND);
    }

    @Override
    public T visitStringExpression(myGrammarParser.StringExpressionContext ctx) {//string formatting?
        System.out.println("in visitStringExpression: "+ctx.getText());
        return (T)ctx.getText();
    }

    @Override
    public T visitExpressionExpression(myGrammarParser.ExpressionExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitAddExpression(myGrammarParser.AddExpressionContext ctx) {
    	T result = (T)"";
    	String stringBuilder = "";
    	boolean toCalculate = true;
    	
    	for (int i = 0; i < ctx.getChildCount(); i++) {
    		if (ctx.getChild(i).getText().contains("\"")){
    			toCalculate = false;
    		}
    	}
    	
    	if (!toCalculate) {
	    	for (int i = 0; i < ctx.getChildCount(); i++) {
	    		if (i == 0) {
	    			stringBuilder = visit(ctx.getChild(i)).toString().replace("\"", "");
	    		}
	    		else {
	    			
	    			if (ctx.getChild(i).getText().equals("+")){
	    				
	    			}
	    			else {
	    				stringBuilder += visit(ctx.getChild(i)).toString().replace("\"", "");
	    			}
	    			
	    		}
	    	}
	    	stringBuilder = '"' + stringBuilder + '"';
	    	result = (T)stringBuilder;
    	}
    	else {
    		result = Calculate(ctx, MathOpType.ADD);
    	}
        return result;
    }

    @Override
    public T visitSubtractExpression(myGrammarParser.SubtractExpressionContext ctx) {
        T result = Calculate(ctx, MathOpType.SUB);
        return result;
    }

    @Override
    public T visitNullExpression(myGrammarParser.NullExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitFunctionCallExpression(myGrammarParser.FunctionCallExpressionContext ctx) {
        System.out.println("Calling a function");
        
        return (T) visitChildren(ctx);
    }

    @Override
    public T visitListExpression(myGrammarParser.ListExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitLtEqExpression(myGrammarParser.LtEqExpressionContext ctx) {
        return CompareExp(ctx, ComparisonOpType.LESSEQUAL);
    }

    @Override
    public T visitTernaryExpression(myGrammarParser.TernaryExpressionContext ctx) {
        T result = (T)"";
        int numberOfChildren = ctx.getChildCount();
        System.out.println(numberOfChildren+" children in visitTernaryExpression");
        
        ParseTree conditionChild = ctx.getChild(0);
        ParseTree trueConditionChild = ctx.getChild(2);
        ParseTree falseConditionChild = ctx.getChild(4);
        
        Boolean condition = false;
        try{
            condition = Boolean.parseBoolean(visit(conditionChild).toString());
        }catch(Exception e){
            /*VisitorErrorReporter.CreateErrorMessage(
                    e.getMessage()+
                    " - Could not resolve ternary expression condition, continuing with false branch expression", 
                    ctx.getStart());*/
    		currentErrorData.errorStorage.add(e.getMessage()+
                    " - Could not resolve ternary expression condition, continuing with false branch expression");
      		currentErrorData.tokenStorage.add(ctx.getStart()); 
        }
        
        if(condition){//implement error recovery?
            try{
                result = (T)visit(trueConditionChild).toString();
            }catch(NullPointerException ne){
                /*VisitorErrorReporter.CreateErrorMessage(
                    ne.getMessage()+
                    " - Could not resolve ternary expression true condition branch", 
                    ctx.getStart());*/
        		currentErrorData.errorStorage.add(ne.getMessage()+
                        " - Could not resolve ternary expression true condition branch");
          		currentErrorData.tokenStorage.add(ctx.getStart()); 
            }
        }else{
            try{
                result = (T)visit(falseConditionChild).toString();
            }catch(NullPointerException ne){
                /*VisitorErrorReporter.CreateErrorMessage(
                    ne.getMessage()+
                    " - Could not resolve ternary expression false condition branch", 
                    ctx.getStart());*/
        		currentErrorData.errorStorage.add(ne.getMessage()+
                        " - Could not resolve ternary expression false condition branch");
          		currentErrorData.tokenStorage.add(ctx.getStart()); 
            }
        }
        
        return result;
    }

    @Override
    public T visitList(myGrammarParser.ListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitIndexes(myGrammarParser.IndexesContext ctx) {
        return visitChildren(ctx);
    }
    
    @Override
    public T visitArrayExpression(myGrammarParser.ArrayExpressionContext ctx) {
    	//here
    	System.out.println("visited array expression");
    	
        String idName = ctx.Identifier().getText() + "[" + visit(ctx.indexes()).toString() + "]";    
        System.out.println("idName : " + idName);
        String result = GenerateErrorIfIdentifierDoesNotExistElseReturnValue(idName, ctx).toString();
        /*if(CompilerHelper.isStringNullOrWhiteSpace(result)){
            VisitorErrorReporter.CreateErrorMessage(
                "identifier "+idName+" has no value yet", 
                ctx.getStart());
    		currentErrorData.errorStorage.add("identifier "+idName+" has no value yet");
      		currentErrorData.tokenStorage.add(ctx.getStart()); 
        }*/
        //
        return (T)result;	
    }
    
    @Override
    public T visitIdentifierDeclaration(myGrammarParser.IdentifierDeclarationContext ctx){
        List<TerminalNode> identifiers = ctx.idList().Identifier();
   
        {
	        if ((ctx.DataType().getText().contains("boolean") || ctx.DataType().getText().contains("string") 
	        	|| ctx.DataType().getText().contains("int") || ctx.DataType().getText().contains("float")
	        	|| ctx.DataType().getText().contains("char")))
	        {
		        for(int c = 0;c < identifiers.size(); c++){
		        	if (ctx.Final() == null) {
		        		if (!(ctx.DataType().getText().contains("[]"))) {
		        			GenerateErrorIfIdentifierExistsElseAddToMemory(identifiers.get(c).getText(), "", ctx.DataType().getText(), "not", ctx);
		        		}
		        		else {
		        			GenerateErrorIfIdentifierExistsElseAddToMemory(identifiers.get(c).getText(), "", "array,"+ctx.DataType().getText().replace("[]", ""), "not", ctx);
		        			
		        		}	
		        		}
		        			
		        	
		        	else {
		        		if (!(ctx.DataType().getText().contains("[]"))) {
		        			GenerateErrorIfIdentifierExistsElseAddToMemory(identifiers.get(c).getText(), "", ctx.DataType().getText(), "final", ctx);
		        		}
		        		else {
		        			GenerateErrorIfIdentifierExistsElseAddToMemory(identifiers.get(c).getText(), "", "array,"+ctx.DataType().getText().replace("[]", ""), "final", ctx);	
		        			
		        		}
		        	}
		        	
		        }
	        }
	        else {
	            /*VisitorErrorReporter.CreateErrorMessage(
	                    "identifier cannot have " + ctx.DataType().getText() + " datatype!", 
	                    ctx.getStart());*/
	    		currentErrorData.errorStorage.add("identifier cannot have " + ctx.DataType().getText() + " datatype!");
	      		currentErrorData.tokenStorage.add(ctx.getStart()); 
	        }
        } 
        /*
            else{
                int i = 0;
                System.out.println(visit(ctx.indexes()).toString());
                int length = Integer.parseInt(visit(ctx.indexes()).toString());
                
                GenerateErrorIfIdentifierExistsElseAddToMemory(ctx.idList().Identifier().toString(), getText(), 
                		Integer.toString(length), "array", "not", ctx);
                
                for(int j = 0; j < length; j++){
                String identifierName = ctx.Identifier().getText() + "[" + i + "]";
                String type = ctx.DataType().getText();
                GenerateErrorIfIdentifierExistsElseAddToMemory(identifierName, "", type, "not", ctx);
                char a = 0;
                String value = "";
                GenerateErrorIfIdentifierDoesNotExistElseAddToMemory(identifierName, value, "not", ctx);  
                System.out.println(identifierName + "generated.");
                i++;
                }
            }
            */
        
        return (T)"";
    }
    
    // usually compares value to variable or vice-versa 
    //(for variable to variable, use typeCheckByTypeName)
    
    public String typeCheck(String type, String value, ParserRuleContext ctx) {
    	
    	boolean passed = true;
    	System.out.println("Check type : " + type);
    	System.out.println("Check value : " + value);
    	
        if (type.equals("int")) {
        	try {
        	System.out.println("Integer Test : " + value);
        	value = value.trim();
        	int integerTest = Integer.parseInt(value);
        	}	catch(NumberFormatException nfe) {
                	/*VisitorErrorReporter.CreateErrorMessage("the value is not an integer.", 
                    ctx.getStart());*/
	    		currentErrorData.errorStorage.add("the value is not an integer.");
	      		currentErrorData.tokenStorage.add(ctx.getStart()); 
                	passed = false;
                	
        	}
        }
        
        /*
        else if (type.equals("long")) {
        	try {
        	value = value.trim();
        	long longTest = Long.parseLong(value);
        	}	catch(NumberFormatException nfe) {
                	VisitorErrorReporter.CreateErrorMessage("the value is not long.", 
                    ctx.getStart());
                	passed = false;
        	}
        }
        
        else if (type.equals("short")) {
        	try {
        	value = value.trim();
        	short shortTest = Short.parseShort(value);
        	}	catch(NumberFormatException nfe) {
                	VisitorErrorReporter.CreateErrorMessage("the value is not short.", 
                    ctx.getStart());
                	passed = false;
        	}
        }
        */
        
        else if (type.equals("string")) {
        	int stringTest = 0;
        	if(value.startsWith("\"") && value.endsWith("\"")) {
        		for (int i = 0; i < value.length(); i++) {
        			System.out.println(i);
        			if (stringTest >= 3) {
        				break;
        			}
        			if(value.charAt(i) == '"') {
        				stringTest++;
        			}
        		 }
	        	 if (stringTest >= 3) {
	             	/*VisitorErrorReporter.CreateErrorMessage("the value is not a string.", 
	                        ctx.getStart());*/
	 	    		currentErrorData.errorStorage.add("the value is not a string.");
		      		currentErrorData.tokenStorage.add(ctx.getStart()); 
	             	passed = false;
	        	 }
        	}
        	else {
            	/*VisitorErrorReporter.CreateErrorMessage("the value is not a string.", 
                        ctx.getStart());*/
        		currentErrorData.errorStorage.add("the value is not a string.");
	      		currentErrorData.tokenStorage.add(ctx.getStart());
            	passed = false;
        	}        	        	
        }
        
        else if (type.equals("boolean")) {
        	if (value.equals("true") || value.equals("false")) {
        		System.out.println("bool test passed");
        	}
        	else {
            	/*VisitorErrorReporter.CreateErrorMessage("the value is not a boolean.", 
                        ctx.getStart());*/
        		currentErrorData.errorStorage.add("the value is not a boolean");
	      		currentErrorData.tokenStorage.add(ctx.getStart());
            	passed = false;
        	}
        }
        
        else if (type.equals("float")) {
        	try {
        		value = value.trim();
        		String fValue = value;
        		float floatTest = Float.parseFloat(value);
        		value = Float.toString(floatTest);
        		System.out.println("fvalue : " + fValue + " , " + value);
        		/*if ((fValue + ".0").equals(value)) {
        			floatTest = Float.parseFloat("deny");
        		}*/
        	} catch(NumberFormatException nfe) {
            	/*VisitorErrorReporter.CreateErrorMessage("the value is not a float.", 
                        ctx.getStart());*/
        		currentErrorData.errorStorage.add("the value is not a float.");
	      		currentErrorData.tokenStorage.add(ctx.getStart());
            	passed = false;
            }
        }
        else if (type.equals("char")) {
        	if (value.contains("\"")) {
        	String charTest = value.replace("\"", "");
        	if (charTest.length() > 1) {
            	/*VisitorErrorReporter.CreateErrorMessage("the value is not a character.", 
                        ctx.getStart());*/
        		currentErrorData.errorStorage.add("the value is not a character.");
	      		currentErrorData.tokenStorage.add(ctx.getStart());
            	passed = false;
        	}
        	}
        	else {
            	/*VisitorErrorReporter.CreateErrorMessage("the value is not a character.", 
                        ctx.getStart());*/
        		currentErrorData.errorStorage.add("the value is not a character.");
	      		currentErrorData.tokenStorage.add(ctx.getStart());
            	passed = false;
        	}
        }
        
        if (passed)
        	return value;
        else
        	return "";
    }
    
    // handle type mismatch by variable names (only works for variable to variable
    public boolean typeCheckByTypeName(String type, String type2, ParserRuleContext ctx) {
    	System.out.println("Type 1 :" + type + ":");
    	System.out.println("Type 2 :" + type2 + ":");
    	if (type.equals(type2)) {
    		System.out.println("accepted");
    		return true;
    	}
    	else {
    		System.out.println("rejected");
    		try {
    		float a = Float.parseFloat("deny");
    		} catch (NumberFormatException nfe) {
            	/*VisitorErrorReporter.CreateErrorMessage("Type Mismatch, please check the data types of variable(s) again.", 
                        ctx.getStart());*/
        		currentErrorData.errorStorage.add("Type Mismatch, please check the data types of variable(s) again.");
	      		currentErrorData.tokenStorage.add(ctx.getStart());
    		}
    	}
    	return false;
    }
    
    @Override
    public T visitArrayLengthExpression(myGrammarParser.ArrayLengthExpressionContext ctx) {
    	System.out.println("In visit Array Length ");
    	try {
	    	if (currentFunctionData.identifierMemory.get(ctx.Identifier().getText()).get(1).toString().contains("array")) {	    		
	    		return (T) currentFunctionData.identifierMemory.get(ctx.Identifier().getText()).get(0).toString();
	    	}
    	} catch (NullPointerException npe) {
            /*VisitorErrorReporter.CreateErrorMessage("The identifier : " + ctx.Identifier().getText() + " does not exist.", 
                    ctx.getStart());*/
    		currentErrorData.errorStorage.add("The identifier : " + ctx.Identifier().getText() + " does not exist.");
      		currentErrorData.tokenStorage.add(ctx.getStart());
    	}
    	//error handling needed?
        /*VisitorErrorReporter.CreateErrorMessage("The identifier : " + ctx.Identifier().getText() + " is not an array.", 
            ctx.getStart());*/
		currentErrorData.errorStorage.add("The identifier : " + ctx.Identifier().getText() + " is not an array.");
  		currentErrorData.tokenStorage.add(ctx.getStart());
		return (T)"";	
    }
    
    public void watchLine(int line) {
	 System.out.println("Line Number : " + line);
     int breakpointLineNum = Breakpoint.checkBreakpoint(line, breaklineList);
     int result = -1;

	    for (int i = 0; i < breaklineList.size(); i++) {
	    	if (breakpointLineNum != -1 && breakpointLineNum == breaklineList.get(i)) {
	    		result = breakpointLineNum;
	    		break;
	    	}
	    }
	    
	    /*for (int i = 0; i < breaklineList.size(); i++) {
	    	if (watchListVisited.get(i) == false && line > breaklineList.get(i)) {
	    		breakpointLineNum = breaklineList.get(i);
	    		watchListVisited.set(i, true);
	    		result = breakpointLineNum;
	    		break;
	    	}
	    }*/
     if(result != -1){// if this statement line number matches a breakpoint line number, show watcher variables and continue option
         showWatcherDialogue(this.ui, result);
     }
    }
    
    public void updateValue() {
	    for (int i = 0; i < watchList.size(); i++){   
		       if(currentFunctionData.identifierExists(watchList.get(i))){
		           ui.getOutputConsole().append(watchList.get(i) + ":" + currentFunctionData.identifierMemory.get(watchList.get(i)).get(0).toString() + "\n");
		           watchListValue.set(i, currentFunctionData.identifierMemory.get(watchList.get(i)).get(0).toString());		          
		       }   
		    }
    }
}
