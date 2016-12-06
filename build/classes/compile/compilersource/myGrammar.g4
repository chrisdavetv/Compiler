grammar myGrammar;

options
{
  // antlr will generate java lexer and parser
  language = Java;
  // generated parser should create abstract syntax tree
  //output = AST;
}

//as the generated lexer will reside in org.meri.antlr_step_by_step.parsers 
//package, we have to add package declaration on top of it
@lexer::header {
package compile.compilersource;
}

//as the generated parser will reside in org.meri.antlr_step_by_step.parsers 
//package, we have to add package declaration on top of it
@parser::header {
package compile.compilersource;
}

compileUnit
    :   expr EOF
    ;

expr
    :   '(' expr ')'                         # parensExpr
    |   op=('+'|'-') expr                    # unaryExpr
    |   left=expr op=('*'|'/') right=expr    # infixExpr
    |   left=expr op=('+'|'-') right=expr    # infixExpr
    |   func=ID '(' expr ')'                 # funcExpr
    |   value=NUM                            # numberExpr
    ;

OP_ADD: '+';
OP_SUB: '-';
OP_MUL: '*';
OP_DIV: '/';

NUM :   [0-9]+ ('.' [0-9]+)? ([eE] [+-]? [0-9]+)?;
ID  :   [a-zA-Z]+;
WS  :   [ \t\r\n] -> channel(HIDDEN);

UNKNOWN_CHAR 
    : . ;