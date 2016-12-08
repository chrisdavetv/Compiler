// Generated from C:\Users\chris\Desktop\Projects\Compiler\src\compile\compilersource\myGrammar.g4 by ANTLR 4.5.3

package compile.compilersource;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class myGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, Writeln=2, Write=3, Def=4, If=5, Else=6, Return=7, For=8, While=9, 
		To=10, Do=11, End=12, Null=13, Or=14, And=15, Equals=16, NEquals=17, GTEquals=18, 
		LTEquals=19, Pow=20, Exclamation=21, GreatThan=22, LessThan=23, Add=24, 
		Subtract=25, Multiply=26, Divide=27, Modulus=28, OpenCurlyBracket=29, 
		CloseCurlyBracket=30, OpenBracket=31, CloseBracket=32, OpenParen=33, CloseParen=34, 
		SemiColon=35, Assign=36, Comma=37, Colon=38, Bool=39, Number=40, Identifier=41, 
		String=42, Comment=43, Space=44, Int=45, Digit=46, UNKNOWN_CHAR=47;
	public static final int
		RULE_parse = 0, RULE_block = 1, RULE_statement = 2, RULE_assignment = 3, 
		RULE_identifierDeclaration = 4, RULE_functionCall = 5, RULE_ifStatement = 6, 
		RULE_ifStat = 7, RULE_elseIfStat = 8, RULE_elseStat = 9, RULE_functionDecl = 10, 
		RULE_forStatement = 11, RULE_whileStatement = 12, RULE_idList = 13, RULE_exprList = 14, 
		RULE_expression = 15, RULE_list = 16, RULE_indexes = 17;
	public static final String[] ruleNames = {
		"parse", "block", "statement", "assignment", "identifierDeclaration", 
		"functionCall", "ifStatement", "ifStat", "elseIfStat", "elseStat", "functionDecl", 
		"forStatement", "whileStatement", "idList", "exprList", "expression", 
		"list", "indexes"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'?'", "'Writeln'", "'Write'", "'def'", "'if'", "'else'", "'return'", 
		"'for'", "'while'", "'to'", "'do'", "'end'", "'null'", "'||'", "'&&'", 
		"'=='", "'!='", "'>='", "'<='", "'^'", "'!'", "'>'", "'<'", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'{'", "'}'", "'['", "']'", "'('", "')'", "';'", 
		"'='", "','", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "Writeln", "Write", "Def", "If", "Else", "Return", "For", 
		"While", "To", "Do", "End", "Null", "Or", "And", "Equals", "NEquals", 
		"GTEquals", "LTEquals", "Pow", "Exclamation", "GreatThan", "LessThan", 
		"Add", "Subtract", "Multiply", "Divide", "Modulus", "OpenCurlyBracket", 
		"CloseCurlyBracket", "OpenBracket", "CloseBracket", "OpenParen", "CloseParen", 
		"SemiColon", "Assign", "Comma", "Colon", "Bool", "Number", "Identifier", 
		"String", "Comment", "Space", "Int", "Digit", "UNKNOWN_CHAR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "myGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public myGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(myGrammarParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			block();
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public TerminalNode Return() { return getToken(myGrammarParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(myGrammarParser.SemiColon, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Writeln) | (1L << Write) | (1L << Def) | (1L << If) | (1L << For) | (1L << While) | (1L << Identifier))) != 0)) {
				{
				setState(41);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(39);
					statement();
					}
					break;
				case 2:
					{
					setState(40);
					functionDecl();
					}
					break;
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			_la = _input.LA(1);
			if (_la==Return) {
				{
				setState(46);
				match(Return);
				setState(47);
				expression(0);
				setState(48);
				match(SemiColon);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(myGrammarParser.SemiColon, 0); }
		public IdentifierDeclarationContext identifierDeclaration() {
			return getRuleContext(IdentifierDeclarationContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				assignment();
				setState(53);
				match(SemiColon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				identifierDeclaration();
				setState(56);
				match(SemiColon);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				functionCall();
				setState(59);
				match(SemiColon);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				ifStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(62);
				forStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(63);
				whileStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(myGrammarParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(myGrammarParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(Identifier);
			setState(68);
			_la = _input.LA(1);
			if (_la==OpenBracket) {
				{
				setState(67);
				indexes();
				}
			}

			setState(70);
			match(Assign);
			setState(71);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierDeclarationContext extends ParserRuleContext {
		public TerminalNode Def() { return getToken(myGrammarParser.Def, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public IdentifierDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterIdentifierDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitIdentifierDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitIdentifierDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierDeclarationContext identifierDeclaration() throws RecognitionException {
		IdentifierDeclarationContext _localctx = new IdentifierDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_identifierDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(Def);
			setState(74);
			idList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	 
		public FunctionCallContext() { }
		public void copyFrom(FunctionCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintlnFunctionCallContext extends FunctionCallContext {
		public TerminalNode Writeln() { return getToken(myGrammarParser.Writeln, 0); }
		public TerminalNode OpenParen() { return getToken(myGrammarParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(myGrammarParser.CloseParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintlnFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterPrintlnFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitPrintlnFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitPrintlnFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierFunctionCallContext extends FunctionCallContext {
		public TerminalNode Identifier() { return getToken(myGrammarParser.Identifier, 0); }
		public TerminalNode OpenParen() { return getToken(myGrammarParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(myGrammarParser.CloseParen, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public IdentifierFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterIdentifierFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitIdentifierFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitIdentifierFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintFunctionCallContext extends FunctionCallContext {
		public TerminalNode Write() { return getToken(myGrammarParser.Write, 0); }
		public TerminalNode OpenParen() { return getToken(myGrammarParser.OpenParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(myGrammarParser.CloseParen, 0); }
		public PrintFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterPrintFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitPrintFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitPrintFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionCall);
		int _la;
		try {
			setState(93);
			switch (_input.LA(1)) {
			case Identifier:
				_localctx = new IdentifierFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(Identifier);
				setState(77);
				match(OpenParen);
				setState(79);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Writeln) | (1L << Write) | (1L << Null) | (1L << Exclamation) | (1L << OpenBracket) | (1L << OpenParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
					{
					setState(78);
					exprList();
					}
				}

				setState(81);
				match(CloseParen);
				}
				break;
			case Writeln:
				_localctx = new PrintlnFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(Writeln);
				setState(83);
				match(OpenParen);
				setState(85);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Writeln) | (1L << Write) | (1L << Null) | (1L << Exclamation) | (1L << OpenBracket) | (1L << OpenParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
					{
					setState(84);
					expression(0);
					}
				}

				setState(87);
				match(CloseParen);
				}
				break;
			case Write:
				_localctx = new PrintFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				match(Write);
				setState(89);
				match(OpenParen);
				setState(90);
				expression(0);
				setState(91);
				match(CloseParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public TerminalNode End() { return getToken(myGrammarParser.End, 0); }
		public List<ElseIfStatContext> elseIfStat() {
			return getRuleContexts(ElseIfStatContext.class);
		}
		public ElseIfStatContext elseIfStat(int i) {
			return getRuleContext(ElseIfStatContext.class,i);
		}
		public ElseStatContext elseStat() {
			return getRuleContext(ElseStatContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			ifStat();
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(96);
					elseIfStat();
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(103);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(102);
				elseStat();
				}
			}

			setState(105);
			match(End);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(myGrammarParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Do() { return getToken(myGrammarParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(If);
			setState(108);
			expression(0);
			setState(109);
			match(Do);
			setState(110);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseIfStatContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(myGrammarParser.Else, 0); }
		public TerminalNode If() { return getToken(myGrammarParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Do() { return getToken(myGrammarParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterElseIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitElseIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitElseIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfStatContext elseIfStat() throws RecognitionException {
		ElseIfStatContext _localctx = new ElseIfStatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_elseIfStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(Else);
			setState(113);
			match(If);
			setState(114);
			expression(0);
			setState(115);
			match(Do);
			setState(116);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStatContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(myGrammarParser.Else, 0); }
		public TerminalNode Do() { return getToken(myGrammarParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterElseStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitElseStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitElseStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatContext elseStat() throws RecognitionException {
		ElseStatContext _localctx = new ElseStatContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_elseStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(Else);
			setState(119);
			match(Do);
			setState(120);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode Def() { return getToken(myGrammarParser.Def, 0); }
		public TerminalNode Identifier() { return getToken(myGrammarParser.Identifier, 0); }
		public TerminalNode OpenParen() { return getToken(myGrammarParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(myGrammarParser.CloseParen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode End() { return getToken(myGrammarParser.End, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(Def);
			setState(123);
			match(Identifier);
			setState(124);
			match(OpenParen);
			setState(126);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(125);
				idList();
				}
			}

			setState(128);
			match(CloseParen);
			setState(129);
			block();
			setState(130);
			match(End);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(myGrammarParser.For, 0); }
		public TerminalNode Identifier() { return getToken(myGrammarParser.Identifier, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode To() { return getToken(myGrammarParser.To, 0); }
		public TerminalNode Do() { return getToken(myGrammarParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode End() { return getToken(myGrammarParser.End, 0); }
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(For);
			setState(133);
			match(Identifier);
			setState(134);
			match(Assign);
			setState(135);
			expression(0);
			setState(136);
			match(To);
			setState(137);
			expression(0);
			setState(138);
			match(Do);
			setState(139);
			block();
			setState(140);
			match(End);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(myGrammarParser.While, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Do() { return getToken(myGrammarParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode End() { return getToken(myGrammarParser.End, 0); }
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(While);
			setState(143);
			expression(0);
			setState(144);
			match(Do);
			setState(145);
			block();
			setState(146);
			match(End);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdListContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(myGrammarParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myGrammarParser.Identifier, i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitIdList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitIdList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_idList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(Identifier);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(149);
				match(Comma);
				setState(150);
				match(Identifier);
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitExprList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			expression(0);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(157);
				match(Comma);
				setState(158);
				expression(0);
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LtExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LessThan() { return getToken(myGrammarParser.LessThan, 0); }
		public LtExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterLtExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitLtExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitLtExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GtExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GreatThan() { return getToken(myGrammarParser.GreatThan, 0); }
		public GtExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterGtExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitGtExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitGtExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExpressionContext extends ExpressionContext {
		public TerminalNode Bool() { return getToken(myGrammarParser.Bool, 0); }
		public BoolExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterBoolExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitBoolExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitBoolExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotEqExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode NEquals() { return getToken(myGrammarParser.NEquals, 0); }
		public NotEqExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterNotEqExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitNotEqExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitNotEqExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberExpressionContext extends ExpressionContext {
		public TerminalNode Number() { return getToken(myGrammarParser.Number, 0); }
		public NumberExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterNumberExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitNumberExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitNumberExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierExpressionContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(myGrammarParser.Identifier, 0); }
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public IdentifierExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterIdentifierExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitIdentifierExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitIdentifierExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModulusExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ModulusExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterModulusExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitModulusExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitModulusExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExpressionContext extends ExpressionContext {
		public TerminalNode Exclamation() { return getToken(myGrammarParser.Exclamation, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitNotExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplyExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultiplyExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterMultiplyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitMultiplyExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitMultiplyExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GtEqExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GTEquals() { return getToken(myGrammarParser.GTEquals, 0); }
		public GtEqExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterGtEqExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitGtEqExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitGtEqExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivideExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DivideExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterDivideExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitDivideExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitDivideExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Or() { return getToken(myGrammarParser.Or, 0); }
		public OrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowerExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Pow() { return getToken(myGrammarParser.Pow, 0); }
		public PowerExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterPowerExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitPowerExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitPowerExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Equals() { return getToken(myGrammarParser.Equals, 0); }
		public EqExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterEqExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitEqExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitEqExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode And() { return getToken(myGrammarParser.And, 0); }
		public AndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringExpressionContext extends ExpressionContext {
		public TerminalNode String() { return getToken(myGrammarParser.String, 0); }
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public StringExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitStringExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitStringExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionExpressionContext extends ExpressionContext {
		public TerminalNode OpenParen() { return getToken(myGrammarParser.OpenParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(myGrammarParser.CloseParen, 0); }
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public ExpressionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterExpressionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitExpressionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitExpressionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterAddExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitAddExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitAddExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubtractExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Subtract() { return getToken(myGrammarParser.Subtract, 0); }
		public SubtractExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterSubtractExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitSubtractExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitSubtractExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullExpressionContext extends ExpressionContext {
		public TerminalNode Null() { return getToken(myGrammarParser.Null, 0); }
		public NullExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterNullExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitNullExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitNullExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallExpressionContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public FunctionCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterFunctionCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitFunctionCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitFunctionCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListExpressionContext extends ExpressionContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public ListExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterListExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitListExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitListExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtEqExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LTEquals() { return getToken(myGrammarParser.LTEquals, 0); }
		public LtEqExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterLtEqExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitLtEqExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitLtEqExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TernaryExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TernaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterTernaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitTernaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitTernaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(165);
				match(Exclamation);
				setState(166);
				expression(24);
				}
				break;
			case 2:
				{
				_localctx = new NumberExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				match(Number);
				}
				break;
			case 3:
				{
				_localctx = new BoolExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				match(Bool);
				}
				break;
			case 4:
				{
				_localctx = new NullExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(Null);
				}
				break;
			case 5:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(170);
				functionCall();
				setState(172);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(171);
					indexes();
					}
					break;
				}
				}
				break;
			case 6:
				{
				_localctx = new ListExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				list();
				setState(176);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(175);
					indexes();
					}
					break;
				}
				}
				break;
			case 7:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				match(Identifier);
				setState(180);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(179);
					indexes();
					}
					break;
				}
				}
				break;
			case 8:
				{
				_localctx = new StringExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				match(String);
				setState(184);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(183);
					indexes();
					}
					break;
				}
				}
				break;
			case 9:
				{
				_localctx = new ExpressionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				match(OpenParen);
				setState(187);
				expression(0);
				setState(188);
				match(CloseParen);
				setState(190);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(189);
					indexes();
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(244);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(242);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new PowerExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(194);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(195);
						match(Pow);
						setState(196);
						expression(24);
						}
						break;
					case 2:
						{
						_localctx = new MultiplyExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(197);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(198);
						match(Multiply);
						setState(199);
						expression(23);
						}
						break;
					case 3:
						{
						_localctx = new DivideExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(200);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(201);
						match(Divide);
						setState(202);
						expression(22);
						}
						break;
					case 4:
						{
						_localctx = new ModulusExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(203);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(204);
						match(Modulus);
						setState(205);
						expression(21);
						}
						break;
					case 5:
						{
						_localctx = new AddExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(206);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(207);
						match(Add);
						setState(208);
						expression(20);
						}
						break;
					case 6:
						{
						_localctx = new SubtractExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(209);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(210);
						match(Subtract);
						setState(211);
						expression(19);
						}
						break;
					case 7:
						{
						_localctx = new GtEqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(212);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(213);
						match(GTEquals);
						setState(214);
						expression(18);
						}
						break;
					case 8:
						{
						_localctx = new LtEqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(215);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(216);
						match(LTEquals);
						setState(217);
						expression(17);
						}
						break;
					case 9:
						{
						_localctx = new GtExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(218);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(219);
						match(GreatThan);
						setState(220);
						expression(16);
						}
						break;
					case 10:
						{
						_localctx = new LtExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(221);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(222);
						match(LessThan);
						setState(223);
						expression(15);
						}
						break;
					case 11:
						{
						_localctx = new EqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(224);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(225);
						match(Equals);
						setState(226);
						expression(14);
						}
						break;
					case 12:
						{
						_localctx = new NotEqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(227);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(228);
						match(NEquals);
						setState(229);
						expression(13);
						}
						break;
					case 13:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(230);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(231);
						match(And);
						setState(232);
						expression(12);
						}
						break;
					case 14:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(233);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(234);
						match(Or);
						setState(235);
						expression(11);
						}
						break;
					case 15:
						{
						_localctx = new TernaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(236);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(237);
						match(T__0);
						setState(238);
						expression(0);
						setState(239);
						match(Colon);
						setState(240);
						expression(10);
						}
						break;
					}
					} 
				}
				setState(246);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ListContext extends ParserRuleContext {
		public TerminalNode OpenBracket() { return getToken(myGrammarParser.OpenBracket, 0); }
		public TerminalNode CloseBracket() { return getToken(myGrammarParser.CloseBracket, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(OpenBracket);
			setState(249);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Writeln) | (1L << Write) | (1L << Null) | (1L << Exclamation) | (1L << OpenBracket) | (1L << OpenParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
				{
				setState(248);
				exprList();
				}
			}

			setState(251);
			match(CloseBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexesContext extends ParserRuleContext {
		public List<TerminalNode> OpenBracket() { return getTokens(myGrammarParser.OpenBracket); }
		public TerminalNode OpenBracket(int i) {
			return getToken(myGrammarParser.OpenBracket, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> CloseBracket() { return getTokens(myGrammarParser.CloseBracket); }
		public TerminalNode CloseBracket(int i) {
			return getToken(myGrammarParser.CloseBracket, i);
		}
		public IndexesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterIndexes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitIndexes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitIndexes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexesContext indexes() throws RecognitionException {
		IndexesContext _localctx = new IndexesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_indexes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(257); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(253);
					match(OpenBracket);
					setState(254);
					expression(0);
					setState(255);
					match(CloseBracket);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(259); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 23);
		case 1:
			return precpred(_ctx, 22);
		case 2:
			return precpred(_ctx, 21);
		case 3:
			return precpred(_ctx, 20);
		case 4:
			return precpred(_ctx, 19);
		case 5:
			return precpred(_ctx, 18);
		case 6:
			return precpred(_ctx, 17);
		case 7:
			return precpred(_ctx, 16);
		case 8:
			return precpred(_ctx, 15);
		case 9:
			return precpred(_ctx, 14);
		case 10:
			return precpred(_ctx, 13);
		case 11:
			return precpred(_ctx, 12);
		case 12:
			return precpred(_ctx, 11);
		case 13:
			return precpred(_ctx, 10);
		case 14:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\61\u0108\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\3\3\3\3\3\3\3"+
		"\5\3\65\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4C\n\4\3"+
		"\5\3\5\5\5G\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\5\7R\n\7\3\7\3\7\3"+
		"\7\3\7\5\7X\n\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7`\n\7\3\b\3\b\7\bd\n\b\f\b"+
		"\16\bg\13\b\3\b\5\bj\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\5\f\u0081\n\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\7\17\u009a\n\17\f\17\16\17\u009d\13\17\3\20\3\20\3"+
		"\20\7\20\u00a2\n\20\f\20\16\20\u00a5\13\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u00af\n\21\3\21\3\21\5\21\u00b3\n\21\3\21\3\21\5\21"+
		"\u00b7\n\21\3\21\3\21\5\21\u00bb\n\21\3\21\3\21\3\21\3\21\5\21\u00c1\n"+
		"\21\5\21\u00c3\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00f5\n\21\f\21"+
		"\16\21\u00f8\13\21\3\22\3\22\5\22\u00fc\n\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\6\23\u0104\n\23\r\23\16\23\u0105\3\23\2\3 \24\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$\2\2\u0125\2&\3\2\2\2\4-\3\2\2\2\6B\3\2\2\2\b"+
		"D\3\2\2\2\nK\3\2\2\2\f_\3\2\2\2\16a\3\2\2\2\20m\3\2\2\2\22r\3\2\2\2\24"+
		"x\3\2\2\2\26|\3\2\2\2\30\u0086\3\2\2\2\32\u0090\3\2\2\2\34\u0096\3\2\2"+
		"\2\36\u009e\3\2\2\2 \u00c2\3\2\2\2\"\u00f9\3\2\2\2$\u0103\3\2\2\2&\'\5"+
		"\4\3\2\'(\7\2\2\3(\3\3\2\2\2),\5\6\4\2*,\5\26\f\2+)\3\2\2\2+*\3\2\2\2"+
		",/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\64\3\2\2\2/-\3\2\2\2\60\61\7\t\2\2\61"+
		"\62\5 \21\2\62\63\7%\2\2\63\65\3\2\2\2\64\60\3\2\2\2\64\65\3\2\2\2\65"+
		"\5\3\2\2\2\66\67\5\b\5\2\678\7%\2\28C\3\2\2\29:\5\n\6\2:;\7%\2\2;C\3\2"+
		"\2\2<=\5\f\7\2=>\7%\2\2>C\3\2\2\2?C\5\16\b\2@C\5\30\r\2AC\5\32\16\2B\66"+
		"\3\2\2\2B9\3\2\2\2B<\3\2\2\2B?\3\2\2\2B@\3\2\2\2BA\3\2\2\2C\7\3\2\2\2"+
		"DF\7+\2\2EG\5$\23\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2\2HI\7&\2\2IJ\5 \21\2J"+
		"\t\3\2\2\2KL\7\6\2\2LM\5\34\17\2M\13\3\2\2\2NO\7+\2\2OQ\7#\2\2PR\5\36"+
		"\20\2QP\3\2\2\2QR\3\2\2\2RS\3\2\2\2S`\7$\2\2TU\7\4\2\2UW\7#\2\2VX\5 \21"+
		"\2WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2Y`\7$\2\2Z[\7\5\2\2[\\\7#\2\2\\]\5 \21"+
		"\2]^\7$\2\2^`\3\2\2\2_N\3\2\2\2_T\3\2\2\2_Z\3\2\2\2`\r\3\2\2\2ae\5\20"+
		"\t\2bd\5\22\n\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fi\3\2\2\2ge\3"+
		"\2\2\2hj\5\24\13\2ih\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\7\16\2\2l\17\3\2\2"+
		"\2mn\7\7\2\2no\5 \21\2op\7\r\2\2pq\5\4\3\2q\21\3\2\2\2rs\7\b\2\2st\7\7"+
		"\2\2tu\5 \21\2uv\7\r\2\2vw\5\4\3\2w\23\3\2\2\2xy\7\b\2\2yz\7\r\2\2z{\5"+
		"\4\3\2{\25\3\2\2\2|}\7\6\2\2}~\7+\2\2~\u0080\7#\2\2\177\u0081\5\34\17"+
		"\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083"+
		"\7$\2\2\u0083\u0084\5\4\3\2\u0084\u0085\7\16\2\2\u0085\27\3\2\2\2\u0086"+
		"\u0087\7\n\2\2\u0087\u0088\7+\2\2\u0088\u0089\7&\2\2\u0089\u008a\5 \21"+
		"\2\u008a\u008b\7\f\2\2\u008b\u008c\5 \21\2\u008c\u008d\7\r\2\2\u008d\u008e"+
		"\5\4\3\2\u008e\u008f\7\16\2\2\u008f\31\3\2\2\2\u0090\u0091\7\13\2\2\u0091"+
		"\u0092\5 \21\2\u0092\u0093\7\r\2\2\u0093\u0094\5\4\3\2\u0094\u0095\7\16"+
		"\2\2\u0095\33\3\2\2\2\u0096\u009b\7+\2\2\u0097\u0098\7\'\2\2\u0098\u009a"+
		"\7+\2\2\u0099\u0097\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\35\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a3\5 \21"+
		"\2\u009f\u00a0\7\'\2\2\u00a0\u00a2\5 \21\2\u00a1\u009f\3\2\2\2\u00a2\u00a5"+
		"\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\37\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a6\u00a7\b\21\1\2\u00a7\u00a8\7\27\2\2\u00a8\u00c3\5"+
		" \21\32\u00a9\u00c3\7*\2\2\u00aa\u00c3\7)\2\2\u00ab\u00c3\7\17\2\2\u00ac"+
		"\u00ae\5\f\7\2\u00ad\u00af\5$\23\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af\u00c3\3\2\2\2\u00b0\u00b2\5\"\22\2\u00b1\u00b3\5$\23\2\u00b2"+
		"\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00c3\3\2\2\2\u00b4\u00b6\7+"+
		"\2\2\u00b5\u00b7\5$\23\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00c3\3\2\2\2\u00b8\u00ba\7,\2\2\u00b9\u00bb\5$\23\2\u00ba\u00b9\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00c3\3\2\2\2\u00bc\u00bd\7#\2\2\u00bd"+
		"\u00be\5 \21\2\u00be\u00c0\7$\2\2\u00bf\u00c1\5$\23\2\u00c0\u00bf\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00a6\3\2\2\2\u00c2"+
		"\u00a9\3\2\2\2\u00c2\u00aa\3\2\2\2\u00c2\u00ab\3\2\2\2\u00c2\u00ac\3\2"+
		"\2\2\u00c2\u00b0\3\2\2\2\u00c2\u00b4\3\2\2\2\u00c2\u00b8\3\2\2\2\u00c2"+
		"\u00bc\3\2\2\2\u00c3\u00f6\3\2\2\2\u00c4\u00c5\f\31\2\2\u00c5\u00c6\7"+
		"\26\2\2\u00c6\u00f5\5 \21\32\u00c7\u00c8\f\30\2\2\u00c8\u00c9\7\34\2\2"+
		"\u00c9\u00f5\5 \21\31\u00ca\u00cb\f\27\2\2\u00cb\u00cc\7\35\2\2\u00cc"+
		"\u00f5\5 \21\30\u00cd\u00ce\f\26\2\2\u00ce\u00cf\7\36\2\2\u00cf\u00f5"+
		"\5 \21\27\u00d0\u00d1\f\25\2\2\u00d1\u00d2\7\32\2\2\u00d2\u00f5\5 \21"+
		"\26\u00d3\u00d4\f\24\2\2\u00d4\u00d5\7\33\2\2\u00d5\u00f5\5 \21\25\u00d6"+
		"\u00d7\f\23\2\2\u00d7\u00d8\7\24\2\2\u00d8\u00f5\5 \21\24\u00d9\u00da"+
		"\f\22\2\2\u00da\u00db\7\25\2\2\u00db\u00f5\5 \21\23\u00dc\u00dd\f\21\2"+
		"\2\u00dd\u00de\7\30\2\2\u00de\u00f5\5 \21\22\u00df\u00e0\f\20\2\2\u00e0"+
		"\u00e1\7\31\2\2\u00e1\u00f5\5 \21\21\u00e2\u00e3\f\17\2\2\u00e3\u00e4"+
		"\7\22\2\2\u00e4\u00f5\5 \21\20\u00e5\u00e6\f\16\2\2\u00e6\u00e7\7\23\2"+
		"\2\u00e7\u00f5\5 \21\17\u00e8\u00e9\f\r\2\2\u00e9\u00ea\7\21\2\2\u00ea"+
		"\u00f5\5 \21\16\u00eb\u00ec\f\f\2\2\u00ec\u00ed\7\20\2\2\u00ed\u00f5\5"+
		" \21\r\u00ee\u00ef\f\13\2\2\u00ef\u00f0\7\3\2\2\u00f0\u00f1\5 \21\2\u00f1"+
		"\u00f2\7(\2\2\u00f2\u00f3\5 \21\f\u00f3\u00f5\3\2\2\2\u00f4\u00c4\3\2"+
		"\2\2\u00f4\u00c7\3\2\2\2\u00f4\u00ca\3\2\2\2\u00f4\u00cd\3\2\2\2\u00f4"+
		"\u00d0\3\2\2\2\u00f4\u00d3\3\2\2\2\u00f4\u00d6\3\2\2\2\u00f4\u00d9\3\2"+
		"\2\2\u00f4\u00dc\3\2\2\2\u00f4\u00df\3\2\2\2\u00f4\u00e2\3\2\2\2\u00f4"+
		"\u00e5\3\2\2\2\u00f4\u00e8\3\2\2\2\u00f4\u00eb\3\2\2\2\u00f4\u00ee\3\2"+
		"\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"!\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fb\7!\2\2\u00fa\u00fc\5\36\20\2"+
		"\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe"+
		"\7\"\2\2\u00fe#\3\2\2\2\u00ff\u0100\7!\2\2\u0100\u0101\5 \21\2\u0101\u0102"+
		"\7\"\2\2\u0102\u0104\3\2\2\2\u0103\u00ff\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106%\3\2\2\2\31+-\64BFQW_ei\u0080"+
		"\u009b\u00a3\u00ae\u00b2\u00b6\u00ba\u00c0\u00c2\u00f4\u00f6\u00fb\u0105";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}