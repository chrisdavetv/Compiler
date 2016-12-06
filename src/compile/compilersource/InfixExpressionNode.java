/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource;

import com.sun.org.apache.xpath.internal.ExpressionNode;

/**
 *
 * @author chris
 */
public abstract class InfixExpressionNode implements ExpressionNode
{
    public ExpressionNode Left;
    public ExpressionNode Right;
}

abstract class AdditionNode extends InfixExpressionNode{
}
abstract class NumberNode implements ExpressionNode
{
    public double Value;
}

//class BuildAstVisitor implements myGrammarBaseVisitor<ExpressionNode>{}

