package compile.compilersource;

import compile.compiler.CompilerUI;
import compile.compilersource.myGrammarParser.ExpressionContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextArea;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class EvalVisitor<T> extends myGrammarBaseVisitor<T> {
//mismatched input errors still dont get caught 
    class FunctionData{
        public Map<String, ArrayList<T>> identifierMemory = new HashMap<String, ArrayList<T>>();
        public Map<Integer, String> funcIdentifierTracker = new HashMap<Integer, String>();
        public myGrammarParser.BlockContext blockCtx;
        /*public Boolean identifierExists(String idName){
            return identifierMemory.get(idName) != null;
        }
        
        // needs datatype, scope
         * 
         * 

        public void GenerateErrorIfIdentifierExistsElseAddToMemory(String identifierName, String value, ParserRuleContext ctx){
            if(identifierExists(identifierName)){
                VisitorErrorReporter.CreateErrorMessage(
                    "identifier "+identifierName+" already exists", 
                    ctx.getStart());
            }else{
                identifierMemory.put(identifierName, (T)value);
            }
        }

       public void GenerateErrorIfIdentifierDoesNotExistElseAddToMemory(String idName, String value, ParserRuleContext ctx){
            if(!identifierExists(idName)){
                VisitorErrorReporter.CreateErrorMessage("identifier already exists: "+idName, 
                        ctx.getStart());
            }else{
                identifierMemory.put(idName, (T)value);
            }
        }
        public T GenerateErrorIfIdentifierDoesNotExistElseReturnValue(String idName, ParserRuleContext ctx){
            if(!identifierExists(idName)){
                VisitorErrorReporter.CreateErrorMessage("identifier does not exist: "+idName, 
                        ctx.getStart());
                return (T)"";
            }else{
                return identifierMemory.get(idName);
            }
        }

        public void RemoveIdentifierFromMemory(String idName){
            identifierMemory.remove(idName);
        }*/
    }
    
    Map<String, ArrayList<T>> identifierMemory = new HashMap<String, ArrayList<T>>();
    Map<String, FunctionData> functionMemory = new HashMap<String, FunctionData>();
        
    ErrorReporter VisitorErrorReporter;
    CompilerUI ui;
    
    final String functionParamSeparator = ",";
    
    public EvalVisitor(ErrorReporter errorReporter, CompilerUI ui){
        super();
        VisitorErrorReporter = errorReporter;
        this.ui = ui;
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

    Double CalculateValue(Double aggregateValue, ParseTree child, MathOpType type) {
        return type.equals(MathOpType.ADD) ? aggregateValue += Double.parseDouble(visit(child).toString())
                : type.equals(MathOpType.SUB) ? aggregateValue -= Double.parseDouble(visit(child).toString())
                : type.equals(MathOpType.DIV) ? aggregateValue /= Double.parseDouble(visit(child).toString())
                : type.equals(MathOpType.POW) ? aggregateValue = Math.pow(aggregateValue, Double.parseDouble(visit(child).toString())) 
                : type.equals(MathOpType.MOD) ? aggregateValue %= Double.parseDouble(visit(child).toString())
                : type.equals(MathOpType.MULT) ? aggregateValue *= Double.parseDouble(visit(child).toString())
                : null;
    }
    
    T Calculate(ExpressionContext ctx, MathOpType type) {
        Double result = 0.0;
        int numberOfChildren = ctx.getChildCount();
        String operatorString = decideOperator(type);
        try {
            System.out.println(numberOfChildren + " children in Expression");
            for (int c = 0; c < numberOfChildren; c++) {
                ParseTree child = ctx.getChild(c);
                if (!child.getText().equals(operatorString)) {
                    if (c == 0) {
                        result = Double.parseDouble(visit(child).toString());
                        System.out.println("calculate : " + result);
                    } else {
                        result = CalculateValue(result, child, type);///= Double.parseDouble(visit(child).toString());
                    }
                }
                else System.out.println("found a " + operatorString + " sign at position" + c);
            }
            System.out.println("Expression returning: " + (T) result.toString());
        } catch (NullPointerException ne) {
            VisitorErrorReporter.CreateErrorMessage("operator can only be applied to type Number", 
                    ctx.getStart());
            return (T)"";
        }
        return (T) result.toString();
    }
    
    String decideComparison(ExpressionContext ctx, ComparisonOpType type){
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
            VisitorErrorReporter.CreateErrorMessage(
                    " - please check expressions on both sides of your comparison operators", 
                    ctx.getStart());
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
        sb.append(" ");
        sb.append(nextResult);

        return (T) sb.toString();
    }

    @Override
    public T visitParse(myGrammarParser.ParseContext ctx) {
        //in here goes error checking, etc - in antlr3, all the code previously mixed in the grammar goes here
        T result = (T) visitChildren(ctx.block());
        System.out.println("visitParse result: " + result);
        return result;
    }

    @Override
    public T visitBlock(myGrammarParser.BlockContext ctx) {
        T result = (T) visitChildren(ctx);
        System.out.println("visitBlock result: " + result);
        return result;
    }

    @Override
    public T visitStatement(myGrammarParser.StatementContext ctx) {
        /*Boolean continueVisit = false;
        System.out.println("in visitStatement");
        if(ctx.assignment() != null || ctx.identifierDeclaration() != null || ctx.functionCall() != null){
            System.out.println("statement contains either assignment, identifierDeclaration or functionCall");
            System.out.println("has semi colon: "+ctx.SemiColon().getText());
            if(!ctx.SemiColon().getText().equals(";")){
                System.out.println("Missing semi colon");
                VisitorErrorReporter.CreateErrorMessage(
                    " - Missing ';' at the end of the statement", 
                    ctx.getStart());
            }else continueVisit = true;
        }
        
        T result = continueVisit? (T) visitChildren(ctx) : (T)"";*/
        T result = (T) visitChildren(ctx);
        return result;
    }
    
    Boolean identifierExists(String idName){
        return identifierMemory.get(idName) != null;
    }
    
    void GenerateErrorIfIdentifierExistsElseAddToMemory(String identifierName, String value, String type, ParserRuleContext ctx){
        if(identifierExists(identifierName)){
            VisitorErrorReporter.CreateErrorMessage(
                "identifier "+identifierName+" already exists", 
                ctx.getStart());
        }else{
        	ArrayList<T> tArray = new ArrayList<T>();
        	tArray.add((T)value);
        	tArray.add((T)type);
            identifierMemory.put(identifierName, tArray);
        }
    }
    
    void GenerateErrorIfIdentifierDoesNotExistElseAddToMemory(String idName, String value, ParserRuleContext ctx){
        if(!identifierExists(idName)){
            VisitorErrorReporter.CreateErrorMessage("identifier does not exist: "+idName, 
                    ctx.getStart());
        }else{
        	ArrayList<T> tArray = new ArrayList<T>();
        	tArray.add((T)value);
        	tArray.add(identifierMemory.get(idName).get(1));
            identifierMemory.put(idName, tArray);
        }
    }
    T GenerateErrorIfIdentifierDoesNotExistElseReturnValue(String idName, ParserRuleContext ctx){
        if(!identifierExists(idName)){
            VisitorErrorReporter.CreateErrorMessage("identifier does not exist: "+idName, 
                    ctx.getStart());
            return (T)"";
        }else{
            return identifierMemory.get(idName).get(0);
        }
    }
    
    void RemoveIdentifierFromMemory(String idName){
        identifierMemory.remove(idName);
    }

    @Override
    public T visitAssignment(myGrammarParser.AssignmentContext ctx) {
        System.out.println("In visitAssignment");
        
        String identifierName = ctx.Identifier().getText();
        String type;
        String value = "";
        
        type = identifierMemory.get(identifierName).get(1).toString();
        
        try{
            value = visit(ctx.expression()).toString();
        }catch(NullPointerException ne){
            VisitorErrorReporter.CreateErrorMessage("Something wrong with the assignment statement", 
                    ctx.getStart());
        }
        
        if (!(type.equals("float")) && !(type.equals("string")) && value.contains(".0")) {
        	value = value.replaceAll(".0", "");
        }
        
        value = typeCheck(type, value, ctx);
        System.out.println("after mismatch check : " + value);
        
        // double?
                	
        
        
        
        GenerateErrorIfIdentifierDoesNotExistElseAddToMemory(identifierName, value, ctx);
        
        return (T)"";
    }

    public FunctionData GenerateErrorIfFuncDoesNotExistElseReturnValue(String idName, ParserRuleContext ctx){
        if(!functionExists(idName)){
            VisitorErrorReporter.CreateErrorMessage("function does not exist: "+idName, 
                    ctx.getStart());
            return null;
        }else{
            return functionMemory.get(idName);
        }
    }
    
    @Override
    public T visitIdentifierFunctionCall(myGrammarParser.IdentifierFunctionCallContext ctx) {
        System.out.println("In visitIdentifierFunctionCall");
        T result = (T)"";
        String funcName = ctx.Identifier().getText();
        String exParam = "", temp = "";
        String[] postParam = new String[1];
        String[] splitRes = new String[1];
        String[] paramNameList = new String[1];
        boolean hasParam = false;
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
        FunctionData functionData = GenerateErrorIfFuncDoesNotExistElseReturnValue(funcName, ctx);
        //System.out.println(functionData.identifierMemory.size());
        if(functionData != null){
        	if (hasParam){
        		
        		String[] memToArray = identifierMemory.keySet().toArray(new String[identifierMemory.keySet().size()]);
            	int k = 1;
            	while (k <= postParam.length){
	        		/*for (int i = 1; i <= functionData.identifierMemory.size(); i++){
	        			identifierMemory.replace(functionData.funcIdentifierTracker.get(k).toString(), (T) postParam[i-1]);
	        			k++;
	        		}*/
	        		
	        		if (k > postParam.length)
	        			break;
	        		
	            	for (int i = 0; i < postParam.length; i++){
	            		for (int j = 0; j < identifierMemory.keySet().size(); j++){
	            			if (k > postParam.length)
	            				break;
	            			
	            			if (paramNameList[i].equals(memToArray[j])) {
	            				System.out.println("CONTAINS VARIABLE" + memToArray[j]);
	            				String s;
	            				boolean a = typeCheckByTypeName(identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(1).toString(), identifierMemory.get(memToArray[j]).get(1).toString(), ctx);
	            				//s = typeCheck(identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(1).toString(), identifierMemory.get(memToArray[j]).get(0).toString(), ctx);
	            				
	            				//System.out.println("Final s : " + s);
	            				
	            				ArrayList<T> tArray = new ArrayList<T>();
	            				tArray.add((T) identifierMemory.get(memToArray[j]).get(0).toString());
	            				tArray.add((T) identifierMemory.get(memToArray[j]).get(1).toString());
	            				identifierMemory.replace(functionData.funcIdentifierTracker.get(k).toString(), identifierMemory.get(memToArray[j]));
	            				k++;
	            				break;
	            			}
	  	
	            			
	            			else{
	            				if (j == (identifierMemory.keySet().size() - 1)){
	            					System.out.println("function param dataType : " + identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(1));
	            					String s;
	            					
	            	 				/*if ((identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(1).toString().equals("int") ||
		            						identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(1).toString().equals("short") ||
		            						identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(1).toString().equals("long"))
		            						&& postParam[i].contains(".0") 
		            						&& !(postParam[i].contains("\""))){
		            					s =  postParam[i].replace(".0", "");
		            					//s = typeCheck(identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(1).toString(), s, ctx);
		            					System.out.println("sssssssss : " + s + " post param " + postParam[i]);
		            					postParam[i] = s;
		            				}*/
	            					s = typeCheck(identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(1).toString(), postParam[i], ctx);
	            					System.out.println("s : " + s);
	            					ArrayList<T> tArray = new ArrayList<T>();
	            					tArray.add((T) s);
	            					tArray.add((T) identifierMemory.get(functionData.funcIdentifierTracker.get(k)).get(1).toString());
	           
	            					identifierMemory.replace(functionData.funcIdentifierTracker.get(k).toString(), tArray);
	    	        				k++;	            				
	            				}
	            			}
	            		}
	            	}
	            } 
            } 
            result = EvaluatelBlockWithErrorGeneration(functionData.blockCtx);//what about function identifiers???
        }
        
        return result;
    }

    @Override
    public T visitPrintlnFunctionCall(myGrammarParser.PrintlnFunctionCallContext ctx) {
        System.out.println("In VisitPrintlnFunctionCall: " + ctx.getText());
        T result = (T)"";
        if(ctx.expression() != null) 
            result = (T)(visitChildren(ctx).toString() +"\n");
        else 
            result = (T)"\n";
        System.out.println("Writing a new line, result: " + result);
        return result;
    }

    @Override
    public T visitPrintFunctionCall(myGrammarParser.PrintFunctionCallContext ctx) {
        System.out.println("In visitPrintFunctionCall");
        T result = (T) (visitChildren(ctx).toString());
        return result;
    }
    
    T EvaluatelBlockWithErrorGeneration(myGrammarParser.BlockContext ctx){
        T result = (T)"";
        try{
            result = (T)visitBlock(ctx).toString();
        }catch(NullPointerException ne){
            VisitorErrorReporter.CreateErrorMessage(
                ne.getMessage()+
                " - Could not resolve conditional code block", 
                ctx.getStart());
        }
        return result;
    }
    
    @Override
    public T visitIfStatement(myGrammarParser.IfStatementContext ctx) {
        System.out.println("In visitIfStatement");
        System.out.println(ctx.getChildCount()+" children in if statement");
        T result = (T)"";
        
        try{
            Boolean ifConditional = Boolean.parseBoolean(visitIfStat(ctx.ifStat()).toString());
            //if first condition is satisfied, then don't move to succeeding else-if code blocks
            if(ifConditional){
                result = EvaluatelBlockWithErrorGeneration(ctx.ifStat().block());
            }else{
                //check else if statements
                int elseIfStatmentCount = ctx.getChildCount() - 3;
                Boolean ifElseConditional = false;
                for(int c = 0;c < elseIfStatmentCount;c++){
                    System.out.println("if statement not statisfied, checking ifelse statements");
                    ifElseConditional = Boolean.parseBoolean(visitElseIfStat(ctx.elseIfStat(c)).toString());
                    if(ifElseConditional){
                        result = EvaluatelBlockWithErrorGeneration(ctx.elseIfStat(c).block());
                    }
                }
                //if no ifelse conditions were satisfied, then check if else statement exists
                if(!ifElseConditional && ctx.elseStat() != null){
                    System.out.println("ifelse statements not statisfied, checking else statements");
                    result = EvaluatelBlockWithErrorGeneration(ctx.elseStat().block());
                }
            }
        }catch(NullPointerException ne){
            VisitorErrorReporter.CreateErrorMessage(
                    ne.getMessage()+
                    " - Could not resolve condition inside if statement", 
                    ctx.getStart());
        }
        catch(Exception e){
            VisitorErrorReporter.CreateErrorMessage(
                    e.getMessage()+
                    " - Could not resolve code block inside if statement", 
                    ctx.getStart());
        }
        
        return result;
    }

    @Override
    public T visitIfStat(myGrammarParser.IfStatContext ctx) {
        System.out.println("In visitIfStat");
        T result = (T)"";
        int numberOfChildren = ctx.getChildCount();
        System.out.println(numberOfChildren+" children in visitIfStat");
        
        ParseTree conditionChild = ctx.expression();
        ParseTree blockChild = ctx.block();
        
        Boolean condition = false;
        try{
            condition = Boolean.parseBoolean(visit(conditionChild).toString());
        }catch(Exception e){
            VisitorErrorReporter.CreateErrorMessage(
                    e.getMessage()+
                    " - Could not resolve if statement condition", 
                    ctx.getStart());
        }
       
        return (T)String.valueOf(condition);
    }
    
    @Override
    public T visitElseIfStat(myGrammarParser.ElseIfStatContext ctx) {
        System.out.println("In visitElseIfStat");
        T result = (T)"";
        int numberOfChildren = ctx.getChildCount();
        System.out.println(numberOfChildren+" children in visitIfStat");
        
        ParseTree conditionChild = ctx.expression();
        ParseTree blockChild = ctx.block();
        
        Boolean condition = false;
        try{
            condition = Boolean.parseBoolean(visit(conditionChild).toString());
        }catch(Exception e){
            VisitorErrorReporter.CreateErrorMessage(
                    e.getMessage()+
                    " - Could not resolve else if condition", 
                    ctx.getStart());
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

    @Override
    public T visitElseStat(myGrammarParser.ElseStatContext ctx) {
        T result = (T)"";
        int numberOfChildren = ctx.getChildCount();
        System.out.println(numberOfChildren+" children in visitIfStat");
        
        ParseTree blockChild = ctx.block();
        try{
            result = (T)visit(blockChild).toString();
        }catch(NullPointerException ne){
            VisitorErrorReporter.CreateErrorMessage(
                ne.getMessage()+
                " - Could not resolve if statement body code block", 
                ctx.getStart());
        }
        
        return result;
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
        if(identifierExists(identifierName)){
            VisitorErrorReporter.CreateErrorMessage(
                "function "+identifierName+" already exists", 
                ctx.getStart());
        }else{
            functionMemory.put(identifierName, value);
        }
    }
    
    @Override
    public T visitFunctionDecl(myGrammarParser.FunctionDeclContext ctx) {//prints twice
        System.out.println("In visitFunctionDecl");
        
        String funcName = ctx.Identifier().getText();
        HashMap<String, ArrayList<T>> funcIdentifiers = new HashMap<String, ArrayList<T>>();
        FunctionData funcData = new FunctionData();
      
        if(ctx.paramIdList() != null){
            for(int c = 0;c < ctx.paramIdList().Identifier().size();c++){
            	ArrayList<T> tArray = new ArrayList<T>();
            	tArray.add((T)"");
            	tArray.add((T)ctx.paramIdList().DataType(c).getText());
            	System.out.println("datatype is : " + (T)ctx.paramIdList().DataType(c).getText());
            	funcData.funcIdentifierTracker.put(c+1, ctx.paramIdList().Identifier(c).getText());
                funcIdentifiers.put(ctx.paramIdList().Identifier(c).getText(), tArray);
                System.out.println("PUT : " + ctx.paramIdList().Identifier(c).getText());
                GenerateErrorIfIdentifierExistsElseAddToMemory(ctx.paramIdList().
                		Identifier(c).getText(), "", ctx.paramIdList().DataType(c).getText(), ctx);
            }
            funcData.identifierMemory = funcIdentifiers;
        }
        funcData.blockCtx = ctx.block();
        GenerateErrorIfFuncExistsElseAddToMemory(funcName, funcData, ctx);
        
        //return (T)visitChildren(ctx);
        return (T)"";
    }

    @Override
    public T visitForStatement(myGrammarParser.ForStatementContext ctx) {
        System.out.println("In visitForStatement");
        
        T result = (T)"";
        String temp = "";
        Double lowerLimit = 0.0;
        Double upperLimit = 0.0;
        try{
            lowerLimit = Double.parseDouble(visit(ctx.expression(0)).toString());
        }catch(Exception e){
            VisitorErrorReporter.CreateErrorMessage(
                e.getMessage()+
                " - for loop lower limit must be an object of type Number", 
                ctx.getStart());
        }
        try{
            upperLimit = Double.parseDouble(visit(ctx.expression(1)).toString());
        }catch(Exception e){
            VisitorErrorReporter.CreateErrorMessage(
                e.getMessage()+
                " - for loop upper limit must be an object of type Number", 
                ctx.getStart());
        }
        
        if(lowerLimit < upperLimit){
            GenerateErrorIfIdentifierExistsElseAddToMemory(
                ctx.Identifier().getText(), ctx.DataType().getText(), lowerLimit.toString(), ctx);
            while(lowerLimit < upperLimit){
                temp = EvaluatelBlockWithErrorGeneration(ctx.block()).toString();
                result = (T) (result + temp);
                lowerLimit++;
            }
            RemoveIdentifierFromMemory(ctx.Identifier().getText());
        }
        
        return result;
    }

    @Override
    public T visitWhileStatement(myGrammarParser.WhileStatementContext ctx) {//need to implement variables to test
        System.out.println("In visitWhileStatement, condition: "+ctx.expression().getText());
        
        T result = (T)"";
        Boolean whileConditional = false;
        try{
            whileConditional = Boolean.parseBoolean(visit(ctx.expression()).toString());
        }catch(Exception e){
            VisitorErrorReporter.CreateErrorMessage(
                e.getMessage()+
                " - Could not resolve while statement condition. It must return an object of type Bool", 
                ctx.getStart()
            );
        }
        while(whileConditional){
          String iterationOutput = EvaluatelBlockWithErrorGeneration(ctx.block()).toString();
          result = (T) (result + iterationOutput);
          whileConditional = Boolean.parseBoolean(visit(ctx.expression()).toString());
          //outputArea.setText(outputArea.getText() + iterationOutput);
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
        String idName = ctx.Identifier().getText();
        String result = GenerateErrorIfIdentifierDoesNotExistElseReturnValue(idName, ctx).toString();
        if(CompilerHelper.isStringNullOrWhiteSpace(result)){
            VisitorErrorReporter.CreateErrorMessage(
                "identifier "+idName+" has no value yet", 
                ctx.getStart());
        }
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
            VisitorErrorReporter.CreateErrorMessage(e.getMessage(), 
                    ctx.getStart());
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
        T result = Calculate(ctx, MathOpType.ADD);
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
            VisitorErrorReporter.CreateErrorMessage(
                    e.getMessage()+
                    " - Could not resolve ternary expression condition, continuing with false branch expression", 
                    ctx.getStart());
        }
        
        if(condition){//implement error recovery?
            try{
                result = (T)visit(trueConditionChild).toString();
            }catch(NullPointerException ne){
                VisitorErrorReporter.CreateErrorMessage(
                    ne.getMessage()+
                    " - Could not resolve ternary expression true condition branch", 
                    ctx.getStart());
            }
        }else{
            try{
                result = (T)visit(falseConditionChild).toString();
            }catch(NullPointerException ne){
                VisitorErrorReporter.CreateErrorMessage(
                    ne.getMessage()+
                    " - Could not resolve ternary expression false condition branch", 
                    ctx.getStart());
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
    public T visitIdentifierDeclaration(myGrammarParser.IdentifierDeclarationContext ctx){
        List<TerminalNode> identifiers = ctx.idList().Identifier();
        for(int c = 0;c < identifiers.size();c++){
            GenerateErrorIfIdentifierExistsElseAddToMemory(identifiers.get(c).getText(), "", ctx.DataType().getText(), ctx);
        }
        return (T)"";
    }
    
    // usually compares value to variable or vice-versa 
    //(for variable to variable, use typeCheckByTypeName)
    
    public String typeCheck(String type, String value, ParserRuleContext ctx) {
    	
    	System.out.println("entered");
    	System.out.println("Check type : " + type);
    	System.out.println("Check value : " + value);
    	
        if (type.equals("int")) {
        	try {
        	int integerTest = Integer.parseInt(value);
        	}	catch(NumberFormatException nfe) {
                	VisitorErrorReporter.CreateErrorMessage("the value assigned is not an integer.", 
                    ctx.getStart());
        	}
        }
        
        
        else if (type.equals("long")) {
        	try {
        	long longTest = Long.parseLong(value);
        	}	catch(NumberFormatException nfe) {
                	VisitorErrorReporter.CreateErrorMessage("the value assigned is not long.", 
                    ctx.getStart());
        	}
        }
        
        else if (type.equals("short")) {
        	try {
        	short shortTest = Short.parseShort(value);
        	}	catch(NumberFormatException nfe) {
                	VisitorErrorReporter.CreateErrorMessage("the value assigned is not short.", 
                    ctx.getStart());
        	}
        }
        
        else if (type.equals("string")) {
        	int stringTest = 0;
        	System.out.println("entered");
        	System.out.println("current value is : " + value);
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
	             	VisitorErrorReporter.CreateErrorMessage("the value assigned is not a string.", 
	                        ctx.getStart());        		 
	        	 }
        	}
        	else {
            	VisitorErrorReporter.CreateErrorMessage("the value assigned is not a string.", 
                        ctx.getStart());        		
        	}        	        	
        }
        
        else if (type.equals("boolean")) {
        	if (value.equals("true") || value.equals("false")) {
        		System.out.println("bool test passed");
        	}
        	else {
            	VisitorErrorReporter.CreateErrorMessage("the value assigned is not a boolean.", 
                        ctx.getStart());        		
        	}
        }
        
        else if (type.equals("float")) {
        	try {
        		String fValue = value;
        		float floatTest = Float.parseFloat(value);
        		value = Float.toString(floatTest);
        		System.out.println("fvalue : " + fValue + " , " + value);
        		if ((fValue + ".0").equals(value)) {
        			floatTest = Float.parseFloat("deny");
        		}
        	} catch(NumberFormatException nfe) {
            	VisitorErrorReporter.CreateErrorMessage("the value assigned is not a float.", 
                        ctx.getStart());
            }
        }
		return value;
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
            	VisitorErrorReporter.CreateErrorMessage("types do not match for the variables.", 
                        ctx.getStart());    			
    		}
    	}
    	return false;
    }
}
