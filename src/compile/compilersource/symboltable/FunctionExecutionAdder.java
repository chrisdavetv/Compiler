/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource.symboltable;

/**
 *
 * @author chris
 */
public class FunctionExecutionAdder implements IExecutionAdder {

	private Function assignedFunction;
	
	public FunctionExecutionAdder(Function mobiFunction) {
		this.assignedFunction = mobiFunction;
	}
	
	/* (non-Javadoc)
	 * @see com.neildg.mobiprog.execution.adders.IExecutionAdder#addCommand(com.neildg.mobiprog.execution.commands.ICommand)
	 */
	@Override
	public void addCommand(ICommand command) {
		this.assignedFunction.addCommand(command);
	}
	
	public Function getAssignedFunction() {
		return this.assignedFunction;
	}

}