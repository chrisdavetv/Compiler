// Generated from myGrammar.g4 by ANTLR 4.5.3

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
		T__0=1, Writeln=2, Write=3, Scan=4, Def=5, If=6, Else=7, Return=8, For=9, 
		While=10, To=11, Do=12, Start=13, End=14, Null=15, Split=16, Length=17, 
		Period=18, Or=19, And=20, Equals=21, NEquals=22, GTEquals=23, LTEquals=24, 
		Pow=25, Exclamation=26, GreatThan=27, LessThan=28, Add=29, Subtract=30, 
		Multiply=31, Divide=32, Modulus=33, OpenCurlyBracket=34, CloseCurlyBracket=35, 
		OpenBracket=36, CloseBracket=37, OpenParen=38, CloseParen=39, SemiColon=40, 
		Assign=41, Comma=42, Colon=43, Final=44, DataType=45, Bool=46, Number=47, 
		Identifier=48, String=49, Comment=50, Space=51, Int=52, Digit=53, UNKNOWN_CHAR=54;
	public static final int
		RULE_parse = 0, RULE_functionBlock = 1, RULE_block = 2, RULE_returnStatement = 3, 
		RULE_statement = 4, RULE_assignment = 5, RULE_identifierDeclaration = 6, 
		RULE_functionCall = 7, RULE_ifStatement = 8, RULE_ifStat = 9, RULE_elseIfStat = 10, 
		RULE_elseStat = 11, RULE_functionDecl = 12, RULE_forStatement = 13, RULE_whileStatement = 14, 
		RULE_doWhileStatement = 15, RULE_idList = 16, RULE_paramIdList = 17, RULE_exprList = 18, 
		RULE_expression = 19, RULE_list = 20, RULE_indexes = 21;
	public static final String[] ruleNames = {
		"parse", "functionBlock", "block", "returnStatement", "statement", "assignment", 
		"identifierDeclaration", "functionCall", "ifStatement", "ifStat", "elseIfStat", 
		"elseStat", "functionDecl", "forStatement", "whileStatement", "doWhileStatement", 
		"idList", "paramIdList", "exprList", "expression", "list", "indexes"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'?'", "'Writeln'", "'Write'", "'Scan'", "'def'", "'if'", "'else'", 
		"'return'", "'for'", "'while'", "'to'", "'do'", "'start'", "'end'", "'null'", 
		"'split'", "'length'", "'.'", "'||'", "'&&'", "'=='", "'!='", "'>='", 
		"'<='", "'^'", "'!'", "'>'", "'<'", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'{'", "'}'", "'['", "']'", "'('", "')'", "';'", "'='", "','", "':'", 
		"'final'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "Writeln", "Write", "Scan", "Def", "If", "Else", "Return", 
		"For", "While", "To", "Do", "Start", "End", "Null", "Split", "Length", 
		"Period", "Or", "And", "Equals", "NEquals", "GTEquals", "LTEquals", "Pow", 
		"Exclamation", "GreatThan", "LessThan", "Add", "Subtract", "Multiply", 
		"Divide", "Modulus", "OpenCurlyBracket", "CloseCurlyBracket", "OpenBracket", 
		"CloseBracket", "OpenParen", "CloseParen", "SemiColon", "Assign", "Comma", 
		"Colon", "Final", "DataType", "Bool", "Number", "Identifier", "String", 
		"Comment", "Space", "Int", "Digit", "UNKNOWN_CHAR"
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
	public static class ParseContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public FunctionBlockContext functionBlock() {
			return getRuleContext(FunctionBlockContext.class,0);
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
			setState(44);
			functionBlock();
			setState(45);
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

	public static class FunctionBlockContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterFunctionBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitFunctionBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitFunctionBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionBlockContext functionBlock() throws RecognitionException {
		FunctionBlockContext _localctx = new FunctionBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
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

	public static class BlockContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
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
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
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
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(51);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(49);
						statement();
						}
						break;
					case 2:
						{
						setState(50);
						functionDecl();
						}
						break;
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(57);
			_la = _input.LA(1);
			if (_la==Return) {
				{
				setState(56);
				returnStatement();
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

	public static class ReturnStatementContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public TerminalNode Return() { return getToken(myGrammarParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(Return);
			setState(60);
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

	public static class StatementContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode Comment() { return getToken(myGrammarParser.Comment, 0); }
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DoWhileStatementContext doWhileStatement() {
			return getRuleContext(DoWhileStatementContext.class,0);
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
		enterRule(_localctx, 8, RULE_statement);
		int _la;
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				assignment();
				setState(64);
				_la = _input.LA(1);
				if (_la==Comment) {
					{
					setState(63);
					match(Comment);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				identifierDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				ifStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				forStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(70);
				whileStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(71);
				expression(0);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(72);
				doWhileStatement();
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

	public static class AssignmentContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public TerminalNode Identifier() { return getToken(myGrammarParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(myGrammarParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(myGrammarParser.OpenParen, 0); }
		public TerminalNode DataType() { return getToken(myGrammarParser.DataType, 0); }
		public TerminalNode CloseParen() { return getToken(myGrammarParser.CloseParen, 0); }
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public TerminalNode Scan() { return getToken(myGrammarParser.Scan, 0); }
		public TerminalNode Comma() { return getToken(myGrammarParser.Comma, 0); }
		public TerminalNode Split() { return getToken(myGrammarParser.Split, 0); }
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
		enterRule(_localctx, 10, RULE_assignment);
		int _la;
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(Identifier);
				setState(76);
				match(Assign);
				setState(80);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(77);
					match(OpenParen);
					setState(78);
					match(DataType);
					setState(79);
					match(CloseParen);
					}
					break;
				}
				setState(82);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(Identifier);
				setState(84);
				indexes();
				setState(85);
				match(Assign);
				setState(89);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(86);
					match(OpenParen);
					setState(87);
					match(DataType);
					setState(88);
					match(CloseParen);
					}
					break;
				}
				setState(91);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				match(Scan);
				setState(94);
				match(OpenParen);
				setState(96);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Writeln) | (1L << Write) | (1L << Null) | (1L << Exclamation) | (1L << OpenBracket) | (1L << OpenParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
					{
					setState(95);
					expression(0);
					}
				}

				setState(98);
				match(Comma);
				setState(99);
				match(Identifier);
				setState(101);
				_la = _input.LA(1);
				if (_la==OpenBracket) {
					{
					setState(100);
					indexes();
					}
				}

				setState(103);
				match(CloseParen);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				match(Identifier);
				setState(105);
				match(Assign);
				setState(106);
				match(DataType);
				setState(107);
				indexes();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(108);
				match(Identifier);
				setState(109);
				match(Assign);
				setState(110);
				match(Split);
				setState(111);
				match(OpenParen);
				setState(112);
				expression(0);
				setState(113);
				match(CloseParen);
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

	public static class IdentifierDeclarationContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public TerminalNode Def() { return getToken(myGrammarParser.Def, 0); }
		public TerminalNode DataType() { return getToken(myGrammarParser.DataType, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public TerminalNode Final() { return getToken(myGrammarParser.Final, 0); }
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
		enterRule(_localctx, 12, RULE_identifierDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(Def);
			setState(119);
			_la = _input.LA(1);
			if (_la==Final) {
				{
				setState(118);
				match(Final);
				}
			}

			setState(121);
			match(DataType);
			setState(122);
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

	public static class FunctionCallContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
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
		enterRule(_localctx, 14, RULE_functionCall);
		int _la;
		try {
			setState(141);
			switch (_input.LA(1)) {
			case Identifier:
				_localctx = new IdentifierFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(Identifier);
				setState(125);
				match(OpenParen);
				setState(127);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Writeln) | (1L << Write) | (1L << Null) | (1L << Exclamation) | (1L << OpenBracket) | (1L << OpenParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
					{
					setState(126);
					exprList();
					}
				}

				setState(129);
				match(CloseParen);
				}
				break;
			case Writeln:
				_localctx = new PrintlnFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(Writeln);
				setState(131);
				match(OpenParen);
				setState(133);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Writeln) | (1L << Write) | (1L << Null) | (1L << Exclamation) | (1L << OpenBracket) | (1L << OpenParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
					{
					setState(132);
					expression(0);
					}
				}

				setState(135);
				match(CloseParen);
				}
				break;
			case Write:
				_localctx = new PrintFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				match(Write);
				setState(137);
				match(OpenParen);
				setState(138);
				expression(0);
				setState(139);
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

	public static class IfStatementContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
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
		enterRule(_localctx, 16, RULE_ifStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			ifStat();
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(144);
					elseIfStat();
					}
					} 
				}
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(151);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(150);
				elseStat();
				}
			}

			setState(153);
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

	public static class IfStatContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
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
		enterRule(_localctx, 18, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(If);
			setState(156);
			expression(0);
			setState(157);
			match(Do);
			setState(158);
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

	public static class ElseIfStatContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
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
		enterRule(_localctx, 20, RULE_elseIfStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(Else);
			setState(161);
			match(If);
			setState(162);
			expression(0);
			setState(163);
			match(Do);
			setState(164);
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

	public static class ElseStatContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
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
		enterRule(_localctx, 22, RULE_elseStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(Else);
			setState(167);
			match(Do);
			setState(168);
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

	public static class FunctionDeclContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public TerminalNode Def() { return getToken(myGrammarParser.Def, 0); }
		public TerminalNode DataType() { return getToken(myGrammarParser.DataType, 0); }
		public TerminalNode Identifier() { return getToken(myGrammarParser.Identifier, 0); }
		public TerminalNode OpenParen() { return getToken(myGrammarParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(myGrammarParser.CloseParen, 0); }
		public FunctionBlockContext functionBlock() {
			return getRuleContext(FunctionBlockContext.class,0);
		}
		public TerminalNode End() { return getToken(myGrammarParser.End, 0); }
		public ParamIdListContext paramIdList() {
			return getRuleContext(ParamIdListContext.class,0);
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
		enterRule(_localctx, 24, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(Def);
			setState(171);
			match(DataType);
			setState(172);
			match(Identifier);
			setState(173);
			match(OpenParen);
			setState(175);
			_la = _input.LA(1);
			if (_la==DataType) {
				{
				setState(174);
				paramIdList();
				}
			}

			setState(177);
			match(CloseParen);
			setState(178);
			functionBlock();
			setState(179);
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

	public static class ForStatementContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public TerminalNode For() { return getToken(myGrammarParser.For, 0); }
		public TerminalNode DataType() { return getToken(myGrammarParser.DataType, 0); }
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
		enterRule(_localctx, 26, RULE_forStatement);
		try {
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(For);
				setState(182);
				match(DataType);
				setState(183);
				match(Identifier);
				setState(184);
				match(Assign);
				setState(185);
				expression(0);
				setState(186);
				match(To);
				setState(187);
				expression(0);
				setState(188);
				match(Do);
				setState(189);
				block();
				setState(190);
				match(End);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				match(For);
				setState(193);
				match(Identifier);
				setState(194);
				match(Assign);
				setState(195);
				expression(0);
				setState(196);
				match(To);
				setState(197);
				expression(0);
				setState(198);
				match(Do);
				setState(199);
				block();
				setState(200);
				match(End);
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

	public static class WhileStatementContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
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
		enterRule(_localctx, 28, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(While);
			setState(205);
			expression(0);
			setState(206);
			match(Do);
			setState(207);
			block();
			setState(208);
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

	public static class DoWhileStatementContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public TerminalNode Start() { return getToken(myGrammarParser.Start, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode While() { return getToken(myGrammarParser.While, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterDoWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitDoWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitDoWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
		DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_doWhileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(Start);
			setState(211);
			block();
			setState(212);
			match(While);
			setState(213);
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

	public static class IdListContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
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
		enterRule(_localctx, 32, RULE_idList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(Identifier);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(216);
				match(Comma);
				setState(217);
				match(Identifier);
				}
				}
				setState(222);
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

	public static class ParamIdListContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public List<TerminalNode> DataType() { return getTokens(myGrammarParser.DataType); }
		public TerminalNode DataType(int i) {
			return getToken(myGrammarParser.DataType, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(myGrammarParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myGrammarParser.Identifier, i);
		}
		public ParamIdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramIdList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterParamIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitParamIdList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitParamIdList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamIdListContext paramIdList() throws RecognitionException {
		ParamIdListContext _localctx = new ParamIdListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_paramIdList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(DataType);
			setState(224);
			match(Identifier);
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(225);
				match(Comma);
				setState(226);
				match(DataType);
				setState(227);
				match(Identifier);
				}
				}
				setState(232);
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

	public static class ExprListContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
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
		enterRule(_localctx, 36, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			expression(0);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(234);
				match(Comma);
				setState(235);
				expression(0);
				}
				}
				setState(240);
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

	public static class ExpressionContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
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
	public static class ArrayLengthExpressionContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(myGrammarParser.Identifier, 0); }
		public TerminalNode Period() { return getToken(myGrammarParser.Period, 0); }
		public TerminalNode Length() { return getToken(myGrammarParser.Length, 0); }
		public ArrayLengthExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterArrayLengthExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitArrayLengthExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitArrayLengthExpression(this);
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
	public static class ArrayExpressionContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(myGrammarParser.Identifier, 0); }
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public ArrayExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterArrayExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitArrayExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor ) return ((myGrammarVisitor<? extends T>)visitor).visitArrayExpression(this);
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(242);
				match(Exclamation);
				setState(243);
				expression(26);
				}
				break;
			case 2:
				{
				_localctx = new ArrayExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244);
				match(Identifier);
				setState(245);
				indexes();
				}
				break;
			case 3:
				{
				_localctx = new NumberExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(246);
				match(Number);
				}
				break;
			case 4:
				{
				_localctx = new BoolExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(247);
				match(Bool);
				}
				break;
			case 5:
				{
				_localctx = new NullExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(248);
				match(Null);
				}
				break;
			case 6:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(249);
				functionCall();
				setState(251);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(250);
					indexes();
					}
					break;
				}
				}
				break;
			case 7:
				{
				_localctx = new ListExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(253);
				list();
				setState(255);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(254);
					indexes();
					}
					break;
				}
				}
				break;
			case 8:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(257);
				match(Identifier);
				setState(259);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(258);
					indexes();
					}
					break;
				}
				}
				break;
			case 9:
				{
				_localctx = new StringExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(261);
				match(String);
				setState(263);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(262);
					indexes();
					}
					break;
				}
				}
				break;
			case 10:
				{
				_localctx = new ExpressionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265);
				match(OpenParen);
				setState(266);
				expression(0);
				setState(267);
				match(CloseParen);
				setState(269);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(268);
					indexes();
					}
					break;
				}
				}
				break;
			case 11:
				{
				_localctx = new ArrayLengthExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(271);
				match(Identifier);
				setState(272);
				match(Period);
				setState(273);
				match(Length);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(326);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(324);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new PowerExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(276);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(277);
						match(Pow);
						setState(278);
						expression(26);
						}
						break;
					case 2:
						{
						_localctx = new MultiplyExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(279);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(280);
						match(Multiply);
						setState(281);
						expression(25);
						}
						break;
					case 3:
						{
						_localctx = new DivideExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(282);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(283);
						match(Divide);
						setState(284);
						expression(24);
						}
						break;
					case 4:
						{
						_localctx = new ModulusExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(285);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(286);
						match(Modulus);
						setState(287);
						expression(23);
						}
						break;
					case 5:
						{
						_localctx = new AddExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(288);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(289);
						match(Add);
						setState(290);
						expression(22);
						}
						break;
					case 6:
						{
						_localctx = new SubtractExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(291);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(292);
						match(Subtract);
						setState(293);
						expression(21);
						}
						break;
					case 7:
						{
						_localctx = new GtEqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(294);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(295);
						match(GTEquals);
						setState(296);
						expression(20);
						}
						break;
					case 8:
						{
						_localctx = new LtEqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(297);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(298);
						match(LTEquals);
						setState(299);
						expression(19);
						}
						break;
					case 9:
						{
						_localctx = new GtExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(300);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(301);
						match(GreatThan);
						setState(302);
						expression(18);
						}
						break;
					case 10:
						{
						_localctx = new LtExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(303);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(304);
						match(LessThan);
						setState(305);
						expression(17);
						}
						break;
					case 11:
						{
						_localctx = new EqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(306);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(307);
						match(Equals);
						setState(308);
						expression(16);
						}
						break;
					case 12:
						{
						_localctx = new NotEqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(309);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(310);
						match(NEquals);
						setState(311);
						expression(15);
						}
						break;
					case 13:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(312);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(313);
						match(And);
						setState(314);
						expression(14);
						}
						break;
					case 14:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(315);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(316);
						match(Or);
						setState(317);
						expression(13);
						}
						break;
					case 15:
						{
						_localctx = new TernaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(318);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(319);
						match(T__0);
						setState(320);
						expression(0);
						setState(321);
						match(Colon);
						setState(322);
						expression(12);
						}
						break;
					}
					} 
				}
				setState(328);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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

	public static class ListContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
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
		enterRule(_localctx, 40, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(OpenBracket);
			setState(331);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Writeln) | (1L << Write) | (1L << Null) | (1L << Exclamation) | (1L << OpenBracket) | (1L << OpenParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
				{
				setState(330);
				exprList();
				}
			}

			setState(333);
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

	public static class IndexesContext extends org.antlr.v4.runtime.RuleContextWithAltNum {
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
		enterRule(_localctx, 42, RULE_indexes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(339); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(335);
					match(OpenBracket);
					setState(336);
					expression(0);
					setState(337);
					match(CloseBracket);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(341); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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
		case 19:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 25);
		case 1:
			return precpred(_ctx, 24);
		case 2:
			return precpred(_ctx, 23);
		case 3:
			return precpred(_ctx, 22);
		case 4:
			return precpred(_ctx, 21);
		case 5:
			return precpred(_ctx, 20);
		case 6:
			return precpred(_ctx, 19);
		case 7:
			return precpred(_ctx, 18);
		case 8:
			return precpred(_ctx, 17);
		case 9:
			return precpred(_ctx, 16);
		case 10:
			return precpred(_ctx, 15);
		case 11:
			return precpred(_ctx, 14);
		case 12:
			return precpred(_ctx, 13);
		case 13:
			return precpred(_ctx, 12);
		case 14:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\38\u015a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\7\4\66\n\4\f\4\16\49\13\4\3\4\5\4<\n\4\3\5\3\5\3\5\3\6\3\6\5"+
		"\6C\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6L\n\6\3\7\3\7\3\7\3\7\3\7\5\7S"+
		"\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\\\n\7\3\7\3\7\3\7\3\7\3\7\5\7c\n"+
		"\7\3\7\3\7\3\7\5\7h\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\5\7v\n\7\3\b\3\b\5\bz\n\b\3\b\3\b\3\b\3\t\3\t\3\t\5\t\u0082\n\t\3\t"+
		"\3\t\3\t\3\t\5\t\u0088\n\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0090\n\t\3\n\3"+
		"\n\7\n\u0094\n\n\f\n\16\n\u0097\13\n\3\n\5\n\u009a\n\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u00b2\n\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00cd\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\7\22\u00dd\n\22\f\22\16\22\u00e0\13\22"+
		"\3\23\3\23\3\23\3\23\3\23\7\23\u00e7\n\23\f\23\16\23\u00ea\13\23\3\24"+
		"\3\24\3\24\7\24\u00ef\n\24\f\24\16\24\u00f2\13\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00fe\n\25\3\25\3\25\5\25\u0102\n"+
		"\25\3\25\3\25\5\25\u0106\n\25\3\25\3\25\5\25\u010a\n\25\3\25\3\25\3\25"+
		"\3\25\5\25\u0110\n\25\3\25\3\25\3\25\5\25\u0115\n\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\7\25\u0147\n\25\f\25\16\25\u014a\13\25\3\26\3\26\5\26\u014e"+
		"\n\26\3\26\3\26\3\27\3\27\3\27\3\27\6\27\u0156\n\27\r\27\16\27\u0157\3"+
		"\27\2\3(\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\2\u0182\2"+
		".\3\2\2\2\4\61\3\2\2\2\6\67\3\2\2\2\b=\3\2\2\2\nK\3\2\2\2\fu\3\2\2\2\16"+
		"w\3\2\2\2\20\u008f\3\2\2\2\22\u0091\3\2\2\2\24\u009d\3\2\2\2\26\u00a2"+
		"\3\2\2\2\30\u00a8\3\2\2\2\32\u00ac\3\2\2\2\34\u00cc\3\2\2\2\36\u00ce\3"+
		"\2\2\2 \u00d4\3\2\2\2\"\u00d9\3\2\2\2$\u00e1\3\2\2\2&\u00eb\3\2\2\2(\u0114"+
		"\3\2\2\2*\u014b\3\2\2\2,\u0155\3\2\2\2./\5\4\3\2/\60\7\2\2\3\60\3\3\2"+
		"\2\2\61\62\5\6\4\2\62\5\3\2\2\2\63\66\5\n\6\2\64\66\5\32\16\2\65\63\3"+
		"\2\2\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28;\3\2\2\29"+
		"\67\3\2\2\2:<\5\b\5\2;:\3\2\2\2;<\3\2\2\2<\7\3\2\2\2=>\7\n\2\2>?\5(\25"+
		"\2?\t\3\2\2\2@B\5\f\7\2AC\7\64\2\2BA\3\2\2\2BC\3\2\2\2CL\3\2\2\2DL\5\16"+
		"\b\2EL\5\20\t\2FL\5\22\n\2GL\5\34\17\2HL\5\36\20\2IL\5(\25\2JL\5 \21\2"+
		"K@\3\2\2\2KD\3\2\2\2KE\3\2\2\2KF\3\2\2\2KG\3\2\2\2KH\3\2\2\2KI\3\2\2\2"+
		"KJ\3\2\2\2L\13\3\2\2\2MN\7\62\2\2NR\7+\2\2OP\7(\2\2PQ\7/\2\2QS\7)\2\2"+
		"RO\3\2\2\2RS\3\2\2\2ST\3\2\2\2Tv\5(\25\2UV\7\62\2\2VW\5,\27\2W[\7+\2\2"+
		"XY\7(\2\2YZ\7/\2\2Z\\\7)\2\2[X\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\5(\25\2"+
		"^v\3\2\2\2_`\7\6\2\2`b\7(\2\2ac\5(\25\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2"+
		"de\7,\2\2eg\7\62\2\2fh\5,\27\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2iv\7)\2\2"+
		"jk\7\62\2\2kl\7+\2\2lm\7/\2\2mv\5,\27\2no\7\62\2\2op\7+\2\2pq\7\22\2\2"+
		"qr\7(\2\2rs\5(\25\2st\7)\2\2tv\3\2\2\2uM\3\2\2\2uU\3\2\2\2u_\3\2\2\2u"+
		"j\3\2\2\2un\3\2\2\2v\r\3\2\2\2wy\7\7\2\2xz\7.\2\2yx\3\2\2\2yz\3\2\2\2"+
		"z{\3\2\2\2{|\7/\2\2|}\5\"\22\2}\17\3\2\2\2~\177\7\62\2\2\177\u0081\7("+
		"\2\2\u0080\u0082\5&\24\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0090\7)\2\2\u0084\u0085\7\4\2\2\u0085\u0087\7(\2"+
		"\2\u0086\u0088\5(\25\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089"+
		"\3\2\2\2\u0089\u0090\7)\2\2\u008a\u008b\7\5\2\2\u008b\u008c\7(\2\2\u008c"+
		"\u008d\5(\25\2\u008d\u008e\7)\2\2\u008e\u0090\3\2\2\2\u008f~\3\2\2\2\u008f"+
		"\u0084\3\2\2\2\u008f\u008a\3\2\2\2\u0090\21\3\2\2\2\u0091\u0095\5\24\13"+
		"\2\u0092\u0094\5\26\f\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2"+
		"\2\2\u0098\u009a\5\30\r\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u009c\7\20\2\2\u009c\23\3\2\2\2\u009d\u009e\7\b\2"+
		"\2\u009e\u009f\5(\25\2\u009f\u00a0\7\16\2\2\u00a0\u00a1\5\6\4\2\u00a1"+
		"\25\3\2\2\2\u00a2\u00a3\7\t\2\2\u00a3\u00a4\7\b\2\2\u00a4\u00a5\5(\25"+
		"\2\u00a5\u00a6\7\16\2\2\u00a6\u00a7\5\6\4\2\u00a7\27\3\2\2\2\u00a8\u00a9"+
		"\7\t\2\2\u00a9\u00aa\7\16\2\2\u00aa\u00ab\5\6\4\2\u00ab\31\3\2\2\2\u00ac"+
		"\u00ad\7\7\2\2\u00ad\u00ae\7/\2\2\u00ae\u00af\7\62\2\2\u00af\u00b1\7("+
		"\2\2\u00b0\u00b2\5$\23\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b4\7)\2\2\u00b4\u00b5\5\4\3\2\u00b5\u00b6\7\20"+
		"\2\2\u00b6\33\3\2\2\2\u00b7\u00b8\7\13\2\2\u00b8\u00b9\7/\2\2\u00b9\u00ba"+
		"\7\62\2\2\u00ba\u00bb\7+\2\2\u00bb\u00bc\5(\25\2\u00bc\u00bd\7\r\2\2\u00bd"+
		"\u00be\5(\25\2\u00be\u00bf\7\16\2\2\u00bf\u00c0\5\6\4\2\u00c0\u00c1\7"+
		"\20\2\2\u00c1\u00cd\3\2\2\2\u00c2\u00c3\7\13\2\2\u00c3\u00c4\7\62\2\2"+
		"\u00c4\u00c5\7+\2\2\u00c5\u00c6\5(\25\2\u00c6\u00c7\7\r\2\2\u00c7\u00c8"+
		"\5(\25\2\u00c8\u00c9\7\16\2\2\u00c9\u00ca\5\6\4\2\u00ca\u00cb\7\20\2\2"+
		"\u00cb\u00cd\3\2\2\2\u00cc\u00b7\3\2\2\2\u00cc\u00c2\3\2\2\2\u00cd\35"+
		"\3\2\2\2\u00ce\u00cf\7\f\2\2\u00cf\u00d0\5(\25\2\u00d0\u00d1\7\16\2\2"+
		"\u00d1\u00d2\5\6\4\2\u00d2\u00d3\7\20\2\2\u00d3\37\3\2\2\2\u00d4\u00d5"+
		"\7\17\2\2\u00d5\u00d6\5\6\4\2\u00d6\u00d7\7\f\2\2\u00d7\u00d8\5(\25\2"+
		"\u00d8!\3\2\2\2\u00d9\u00de\7\62\2\2\u00da\u00db\7,\2\2\u00db\u00dd\7"+
		"\62\2\2\u00dc\u00da\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df#\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7/\2\2\u00e2"+
		"\u00e8\7\62\2\2\u00e3\u00e4\7,\2\2\u00e4\u00e5\7/\2\2\u00e5\u00e7\7\62"+
		"\2\2\u00e6\u00e3\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9%\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00f0\5(\25\2"+
		"\u00ec\u00ed\7,\2\2\u00ed\u00ef\5(\25\2\u00ee\u00ec\3\2\2\2\u00ef\u00f2"+
		"\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\'\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f3\u00f4\b\25\1\2\u00f4\u00f5\7\34\2\2\u00f5\u0115\5"+
		"(\25\34\u00f6\u00f7\7\62\2\2\u00f7\u0115\5,\27\2\u00f8\u0115\7\61\2\2"+
		"\u00f9\u0115\7\60\2\2\u00fa\u0115\7\21\2\2\u00fb\u00fd\5\20\t\2\u00fc"+
		"\u00fe\5,\27\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0115\3\2"+
		"\2\2\u00ff\u0101\5*\26\2\u0100\u0102\5,\27\2\u0101\u0100\3\2\2\2\u0101"+
		"\u0102\3\2\2\2\u0102\u0115\3\2\2\2\u0103\u0105\7\62\2\2\u0104\u0106\5"+
		",\27\2\u0105\u0104\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0115\3\2\2\2\u0107"+
		"\u0109\7\63\2\2\u0108\u010a\5,\27\2\u0109\u0108\3\2\2\2\u0109\u010a\3"+
		"\2\2\2\u010a\u0115\3\2\2\2\u010b\u010c\7(\2\2\u010c\u010d\5(\25\2\u010d"+
		"\u010f\7)\2\2\u010e\u0110\5,\27\2\u010f\u010e\3\2\2\2\u010f\u0110\3\2"+
		"\2\2\u0110\u0115\3\2\2\2\u0111\u0112\7\62\2\2\u0112\u0113\7\24\2\2\u0113"+
		"\u0115\7\23\2\2\u0114\u00f3\3\2\2\2\u0114\u00f6\3\2\2\2\u0114\u00f8\3"+
		"\2\2\2\u0114\u00f9\3\2\2\2\u0114\u00fa\3\2\2\2\u0114\u00fb\3\2\2\2\u0114"+
		"\u00ff\3\2\2\2\u0114\u0103\3\2\2\2\u0114\u0107\3\2\2\2\u0114\u010b\3\2"+
		"\2\2\u0114\u0111\3\2\2\2\u0115\u0148\3\2\2\2\u0116\u0117\f\33\2\2\u0117"+
		"\u0118\7\33\2\2\u0118\u0147\5(\25\34\u0119\u011a\f\32\2\2\u011a\u011b"+
		"\7!\2\2\u011b\u0147\5(\25\33\u011c\u011d\f\31\2\2\u011d\u011e\7\"\2\2"+
		"\u011e\u0147\5(\25\32\u011f\u0120\f\30\2\2\u0120\u0121\7#\2\2\u0121\u0147"+
		"\5(\25\31\u0122\u0123\f\27\2\2\u0123\u0124\7\37\2\2\u0124\u0147\5(\25"+
		"\30\u0125\u0126\f\26\2\2\u0126\u0127\7 \2\2\u0127\u0147\5(\25\27\u0128"+
		"\u0129\f\25\2\2\u0129\u012a\7\31\2\2\u012a\u0147\5(\25\26\u012b\u012c"+
		"\f\24\2\2\u012c\u012d\7\32\2\2\u012d\u0147\5(\25\25\u012e\u012f\f\23\2"+
		"\2\u012f\u0130\7\35\2\2\u0130\u0147\5(\25\24\u0131\u0132\f\22\2\2\u0132"+
		"\u0133\7\36\2\2\u0133\u0147\5(\25\23\u0134\u0135\f\21\2\2\u0135\u0136"+
		"\7\27\2\2\u0136\u0147\5(\25\22\u0137\u0138\f\20\2\2\u0138\u0139\7\30\2"+
		"\2\u0139\u0147\5(\25\21\u013a\u013b\f\17\2\2\u013b\u013c\7\26\2\2\u013c"+
		"\u0147\5(\25\20\u013d\u013e\f\16\2\2\u013e\u013f\7\25\2\2\u013f\u0147"+
		"\5(\25\17\u0140\u0141\f\r\2\2\u0141\u0142\7\3\2\2\u0142\u0143\5(\25\2"+
		"\u0143\u0144\7-\2\2\u0144\u0145\5(\25\16\u0145\u0147\3\2\2\2\u0146\u0116"+
		"\3\2\2\2\u0146\u0119\3\2\2\2\u0146\u011c\3\2\2\2\u0146\u011f\3\2\2\2\u0146"+
		"\u0122\3\2\2\2\u0146\u0125\3\2\2\2\u0146\u0128\3\2\2\2\u0146\u012b\3\2"+
		"\2\2\u0146\u012e\3\2\2\2\u0146\u0131\3\2\2\2\u0146\u0134\3\2\2\2\u0146"+
		"\u0137\3\2\2\2\u0146\u013a\3\2\2\2\u0146\u013d\3\2\2\2\u0146\u0140\3\2"+
		"\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149"+
		")\3\2\2\2\u014a\u0148\3\2\2\2\u014b\u014d\7&\2\2\u014c\u014e\5&\24\2\u014d"+
		"\u014c\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\7\'"+
		"\2\2\u0150+\3\2\2\2\u0151\u0152\7&\2\2\u0152\u0153\5(\25\2\u0153\u0154"+
		"\7\'\2\2\u0154\u0156\3\2\2\2\u0155\u0151\3\2\2\2\u0156\u0157\3\2\2\2\u0157"+
		"\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158-\3\2\2\2!\65\67;BKR[bguy\u0081"+
		"\u0087\u008f\u0095\u0099\u00b1\u00cc\u00de\u00e8\u00f0\u00fd\u0101\u0105"+
		"\u0109\u010f\u0114\u0146\u0148\u014d\u0157";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}