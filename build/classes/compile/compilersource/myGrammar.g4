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

prog: stat+;

stat:   expr NEWLINE            # printExpr
    |   ID '=' expr NEWLINE     # assign
    |   NEWLINE                 # blank
    ;
    
expr:   expr op=('*'|'/') expr     # MulDiv
    |   expr op=('+'|'-') expr     # AddSub
    |   INT                     # int 
    |   ID                      # id
    |   '(' expr ')'            # parens
    ;
    
MUL:    '*';
DIV:    '/';
ADD:    '+';
SUB:    '-';

ID:         [a-zA-Z]+;
INT:        [0-9]+;
NEWLINE:    '\r'? '\n';
WS:         [ \t]+ -> skip;

UNKNOWN_CHAR 
    : . ;