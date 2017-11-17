/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource.symboltable;

import java.io.Console;
import java.util.HashMap;
import sun.rmi.runtime.Log;

/**
 *
 * @author chris
 */
public class ClassScope implements IScope{

    private final static String TAG = "Prog_ClassScope";
	
	private String className;
	
	private HashMap<String, Value> publicVariables;
	private HashMap<String, Value> privateVariables;
	
	private HashMap<String, Function> publicFunctions;
	private HashMap<String, Function> privateFunctions;
	
	private LocalScope parentLocalScope; //represents the parent local scope which is the local scope covered by the main() function. Other classes may not contain this.
	
	public ClassScope(String className) {
		this.className = className;
		
		this.publicVariables = new HashMap<String, Value>();
		this.privateVariables = new HashMap<String, Value>();
		
		this.publicFunctions = new HashMap<String, Function>();
		this.privateFunctions = new HashMap<String, Function>();
	}
	
	public String getClassName() {
		return this.className;
	}
	
	
	/*
	 * Sets the parent local scope which is instantiated if this class contains a main function.
	 */
	public void setParentLocalScope(LocalScope localScope) {
		this.parentLocalScope = localScope;
	}
	
	@Override
	public boolean isParent(){
		return true;
	}
	
	/*
	 * Attempts to add an empty variable based from keywords
	 */
	public void addEmptyVariableFromKeywords(String classModifierString, String primitiveTypeString, String identifierString) {
		boolean isPublic = true;
		
		if(Keywords.matchesKeyword(Keywords.CLASS_MODIFIER_PRIVATE, classModifierString)) {
			isPublic = false;
		}
		
		//create empty  value
		Value value = Value.createEmptyVariableFromKeywords(primitiveTypeString);
		
		if(isPublic) {
			this.publicVariables.put(identifierString, value);
			//Console.log(LogType.DEBUG, "Created public variable " +identifierString+ " type: " +Value.getPrimitiveType());
		}
		else {
			this.privateVariables.put(identifierString, value);
			//Console.log(LogType.DEBUG, "Created private variable " +identifierString+ " type: " +Value.getPrimitiveType());
		}
	}
	
	/*
	 * Attempts to add an initialized variable  value
	 */
	public void addInitializedVariableFromKeywords(String classModifierString, String primitiveTypeString, String identifierString, String valueString) {
		boolean isPublic = true;
		
		if(Keywords.matchesKeyword(Keywords.CLASS_MODIFIER_PRIVATE, classModifierString)) {
			isPublic = false;
		}
		
		this.addEmptyVariableFromKeywords(classModifierString, primitiveTypeString, identifierString);
		
		if(isPublic) {
			Value Value = this.publicVariables.get(identifierString);
			Value.setValue(valueString);
			//Console.log(LogType.DEBUG, "Updated public variable " +identifierString+ " of type " +Value.getPrimitiveType()+ " with value " +valueString);
		}
		else {
			Value Value = this.privateVariables.get(identifierString);
			Value.setValue(valueString);
			//Console.log(LogType.DEBUG, "Updated private variable " +identifierString+ " of type " +Value.getPrimitiveType()+ " with value " +valueString);
		}
	}
	
	public Value getPublicVariable(String identifier) {
		if(this.containsPublicVariable(identifier)) {
			return this.publicVariables.get(identifier);
		}
		else {
			//Log.e(TAG, "Public " +identifier + " is not found.");
			return null;
		}
	}
	
	public Value getPrivateVariable(String identifier) {
		if(this.containsPrivateVariable(identifier)) {
			return this.privateVariables.get(identifier);
		}
		else {
			//Log.e(TAG, "Private " +identifier + " is not found.");
			return null;
		}
	}
	
	public void addPrivateFunction(String identifier, Function Function) {
		this.privateFunctions.put(identifier, Function);
		//Console.log(LogType.DEBUG, "Created private function " +identifier+ " with return type " +Function.getReturnType());
	}
	
	public void addPublicFunction(String identifier, Function Function) {
		this.publicFunctions.put(identifier, Function);
		//Console.log(LogType.DEBUG, "Created public function " +identifier+ " with return type " +Function.getReturnType());
	}
	
	public void addValue(String accessControlModifier, String identifier, Value Value) {
		boolean isPublic = true;
		
		if(Keywords.matchesKeyword(Keywords.CLASS_MODIFIER_PRIVATE, accessControlModifier)) {
			isPublic = false;
		}
		
		if(isPublic){
			this.publicVariables.put(identifier, Value);
		}
		else {
			this.privateVariables.put(identifier, Value);
		}	
	}
	
	public Function getPublicFunction(String identifier) {
		if(this.containsPublicFunction(identifier)) {
			return this.publicFunctions.get(identifier);
		}
		else {
			//Log.e(TAG, "Private " +identifier+ " function is not found.");
			return null;
		}
	}
	
	public Function getPrivateFunction(String identifier) {
		if(this.containsPublicFunction(identifier)) {
			return this.privateFunctions.get(identifier);
		}
		else {
			//Log.e(TAG, "Public " +identifier+ " function is not found");
			return null;
		}
	}
	
	public Function searchFunction(String identifier) {
		if(this.containsPublicFunction(identifier)) {
			return this.publicFunctions.get(identifier);
		}
		else if(this.containsPrivateFunction(identifier)) {
			return this.privateFunctions.get(identifier);
		}
		else {
			//Log.e(TAG, identifier + " is not found in " +this.className);
			return null;
		}
	}
	
	public boolean containsPublicFunction(String identifier) {
		return this.publicFunctions.containsKey(identifier);
	}
	
	public boolean containsPrivateFunction(String identifier) {
		return this.privateFunctions.containsKey(identifier);
	}
	
	@Override
	/* Attempts to find a variable first in the private and public variable storage, then on the local scopes.
	 * (non-Javadoc)
	 * @see com.neildg.prog.semantics.symboltable.scopes.IScope#getVariable(java.lang.String)
	 */
	public Value searchVariableIncludingLocal(String identifier) {
		Value value;
		if(this.containsPrivateVariable(identifier)) {
			value = this.getPrivateVariable(identifier);
		}
		else if(this.containsPublicVariable(identifier)) {
			value = this.getPublicVariable(identifier);
		}
		else {
			value = LocalScopeCreator.searchVariableInLocalIterative(identifier, this.parentLocalScope);
		}
		
		return value;
	}
	
	public Value searchVariable(String identifier) {
		Value value = null;
		if(this.containsPrivateVariable(identifier)) {
			value = this.getPrivateVariable(identifier);
		}
		else if(this.containsPublicVariable(identifier)) {
			value = this.getPublicVariable(identifier);
		}
		
		return value;
	}
	
	public boolean containsPublicVariable(String identifier) {
		return this.publicVariables.containsKey(identifier);
	}
	
	public boolean containsPrivateVariable(String identifier) {
		return this.privateVariables.containsKey(identifier);
	}
	
	/*
	 * Resets all stored variables. This is called after the execution manager finishes
	 */
	public void resetValues() {
		Value[] publicValues = this.publicVariables.values().toArray(new Value[this.publicVariables.size()]);
		Value[] privateValues = this.privateVariables.values().toArray(new Value[this.privateVariables.size()]);
		
		for(int i = 0; i < publicValues.length; i++) {
			publicValues[i].reset();
		}
		
		for(int i = 0; i < privateValues.length; i++) {
			privateValues[i].reset();
		}
	}
    
}
