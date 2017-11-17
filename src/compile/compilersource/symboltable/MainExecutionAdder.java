/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource.symboltable;

import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class MainExecutionAdder implements IExecutionAdder {

	private ArrayList<ICommand> mainExecutionList;
	
	public MainExecutionAdder(ArrayList<ICommand> mainExecutionList) {
		this.mainExecutionList = mainExecutionList;
	}
	
	@Override
	public void addCommand(ICommand command) {
		this.mainExecutionList.add(command);
	}

}