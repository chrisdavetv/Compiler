grammar myGrammar;

options
{
  // antlr will generate java lexer and parser
  language = Java;
  // generated parser should create abstract syntax tree
  //output = AST;
  contextSuperClass = org.antlr.v4.runtime.RuleContextWithAltNum;
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

parse
 : functionBlock EOF
 ;

functionBlock
 : block
 ;
block
 : (statement | functionDecl)* returnStatement?
 ;
 
returnStatement
 : Return expression
 ;

statement
 : assignment Comment?
 | identifierDeclaration 
 | functionCall 
 | ifStatement 
 | forStatement
 | whileStatement 
 | expression
 | doWhileStatement
 ;

assignment
 : Identifier Assign (OpenParen DataType CloseParen)? expression
 | Identifier indexes Assign (OpenParen DataType CloseParen)? expression
 | Scan OpenParen expression? Comma Identifier indexes? CloseParen
 | Identifier Assign DataType indexes
 ;


identifierDeclaration
: Def Final? DataType (OpenBracket CloseBracket)? idList
;

functionCall
 : Identifier OpenParen exprList? CloseParen #identifierFunctionCall
 | Writeln OpenParen expression? CloseParen  #printlnFunctionCall
 | Write OpenParen expression CloseParen     #printFunctionCall
 ;

ifStatement
 : ifStat elseIfStat* elseStat? End
 ;

ifStat
 : If expression Do block
 ;

elseIfStat
 : Else If expression Do block
 ;

elseStat
 : Else Do block
 ;

functionDecl
 : Def DataType Identifier OpenParen paramIdList? CloseParen functionBlock End
 ;

forStatement
 : For DataType Identifier '=' expression To expression Do block End
 | For Identifier '=' expression To expression Do block End
 ;

whileStatement
 : While expression Do block End
 ;

doWhileStatement
 : Start block While expression 
 ;
 
idList
 : Identifier (',' Identifier)*
 ;

paramIdList
 : DataType Identifier (',' DataType Identifier)*
 ;

exprList
 : expression (',' expression)*
 ;

expression
 : Exclamation expression                           #notExpression
 | expression Pow expression                #powerExpression
 | expression '*' expression                #multiplyExpression
 | expression '/' expression                #divideExpression
 | expression '%' expression                #modulusExpression
 | expression '+' expression                #addExpression
 | expression Subtract expression                #subtractExpression
 | expression GTEquals expression               #gtEqExpression
 | expression LTEquals expression               #ltEqExpression
 | expression GreatThan expression                #gtExpression
 | expression LessThan expression                #ltExpression
 | expression Equals expression               #eqExpression
 | expression NEquals expression               #notEqExpression
 | expression And expression               #andExpression
 | expression Or expression               #orExpression
 | expression '?' expression ':' expression #ternaryExpression
 | Identifier indexes                         #arrayExpression
 | Number                                   #numberExpression
 | Bool                                     #boolExpression
 | Null                                     #nullExpression
 | functionCall indexes?                    #functionCallExpression
 | list indexes?                            #listExpression
 | Identifier indexes?                      #identifierExpression
 | String indexes?                          #stringExpression
 | OpenParen expression CloseParen indexes?              #expressionExpression
 ;

list
 : OpenBracket exprList? CloseBracket
 ;

indexes
 : (OpenBracket expression CloseBracket)+
 ;

Writeln  : 'Writeln';
Write    : 'Write';
Scan     : 'Scan';
Def      : 'def';
If       : 'if';
Else     : 'else';
Return   : 'return';
For      : 'for';
While    : 'while';
To       : 'to';
Do       : 'do';
Start    : 'start';
End      : 'end';
Null     : 'null';

Or       : '||';
And      : '&&';
Equals   : '==';
NEquals  : '!=';
GTEquals : '>=';
LTEquals : '<=';
Pow      : '^';
Exclamation     : '!';
GreatThan       : '>';
LessThan       : '<';
Add      : '+';
Subtract : '-';
Multiply : '*';
Divide   : '/';
Modulus  : '%';
OpenCurlyBracket   : '{';
CloseCurlyBracket   : '}';
OpenBracket : '[';
CloseBracket : ']';
OpenParen   : '(';
CloseParen   : ')';
SemiColon   : ';';
Assign   : '=';
Comma    : ',';
Colon    : ':';
Final    : 'final';

DataType 
: 'boolean'
| 'string'
| 'int'
| 'float'
| 'long'
| 'short'
| 'void'
;

Bool
 : 'true' 
 | 'false'
 ;

Number
 : Int ('.' Digit*)?
 ;

Identifier
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

String
 : ["] (~["\r\n] | '\\\\' | '\\"')* ["]
 | ['] (~['\r\n] | '\\\\' | '\\\'')* [']
 ;
Comment
 : ('//' ~[\r\n]* | '/*' .*? '*/') -> skip
 ;
Space
 : [ \t\r\n\u000C] -> skip
 ;
Int
 : [1-9] Digit*
 | '0'
 ;
  
Digit 
 : [0-9]
 ;

UNKNOWN_CHAR 
    : . ;