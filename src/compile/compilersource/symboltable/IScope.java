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
public interface IScope {
    public Value searchVariableIncludingLocal(String identifier);
    public boolean isParent();
}
