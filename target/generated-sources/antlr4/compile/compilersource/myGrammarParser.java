// Generated from myGrammar.g4 by ANTLR 4.4

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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, Writeln=2, Write=3, Scan=4, Def=5, If=6, Else=7, Return=8, For=9, 
		While=10, To=11, Do=12, End=13, Null=14, Or=15, And=16, Equals=17, NEquals=18, 
		GTEquals=19, LTEquals=20, Pow=21, Exclamation=22, GreatThan=23, LessThan=24, 
		Add=25, Subtract=26, Multiply=27, Divide=28, Modulus=29, OpenCurlyBracket=30, 
		CloseCurlyBracket=31, OpenBracket=32, CloseBracket=33, OpenParen=34, CloseParen=35, 
		SemiColon=36, Assign=37, Comma=38, Colon=39, Final=40, DataType=41, Bool=42, 
		Number=43, Identifier=44, String=45, Comment=46, Space=47, Int=48, Digit=49, 
		UNKNOWN_CHAR=50;
	public static final String[] tokenNames = {
		"<INVALID>", "'?'", "'Writeln'", "'Write'", "'Scan'", "'def'", "'if'", 
		"'else'", "'return'", "'for'", "'while'", "'to'", "'do'", "'end'", "'null'", 
		"'||'", "'&&'", "'=='", "'!='", "'>='", "'<='", "'^'", "'!'", "'>'", "'<'", 
		"'+'", "'-'", "'*'", "'/'", "'%'", "'{'", "'}'", "'['", "']'", "'('", 
		"')'", "';'", "'='", "','", "':'", "'final'", "DataType", "Bool", "Number", 
		"Identifier", "String", "Comment", "Space", "Int", "Digit", "UNKNOWN_CHAR"
	};
	public static final int
		RULE_parse = 0, RULE_functionBlock = 1, RULE_block = 2, RULE_statement = 3, 
		RULE_assignment = 4, RULE_identifierDeclaration = 5, RULE_functionCall = 6, 
		RULE_ifStatement = 7, RULE_ifStat = 8, RULE_elseIfStat = 9, RULE_elseStat = 10, 
		RULE_functionDecl = 11, RULE_forStatement = 12, RULE_whileStatement = 13, 
		RULE_idList = 14, RULE_paramIdList = 15, RULE_exprList = 16, RULE_expression = 17, 
		RULE_list = 18, RULE_indexes = 19;
	public static final String[] ruleNames = {
		"parse", "functionBlock", "block", "statement", "assignment", "identifierDeclaration", 
		"functionCall", "ifStatement", "ifStat", "elseIfStat", "elseStat", "functionDecl", 
		"forStatement", "whileStatement", "idList", "paramIdList", "exprList", 
		"expression", "list", "indexes"
	};

	@Override
	public String getGrammarFileName() { return "myGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public TerminalNode EOF() { return getToken(myGrammarParser.EOF, 0); }
		public FunctionBlockContext functionBlock() {
			return getRuleContext(FunctionBlockContext.class,0);
		}
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
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); functionBlock();
			setState(41); match(EOF);
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

	public static class FunctionBlockContext extends ParserRuleContext {
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
	}

	public final FunctionBlockContext functionBlock() throws RecognitionException {
		FunctionBlockContext _localctx = new FunctionBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); block();
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
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode Return() { return getToken(myGrammarParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Writeln) | (1L << Write) | (1L << Scan) | (1L << Def) | (1L << If) | (1L << For) | (1L << While) | (1L << Null) | (1L << Exclamation) | (1L << OpenBracket) | (1L << OpenParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
				{
				setState(47);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(45); statement();
					}
					break;
				case 2:
					{
					setState(46); functionDecl();
					}
					break;
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			_la = _input.LA(1);
			if (_la==Return) {
				{
				setState(52); match(Return);
				setState(53); expression(0);
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
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IdentifierDeclarationContext identifierDeclaration() {
			return getRuleContext(IdentifierDeclarationContext.class,0);
		}
		public TerminalNode Comment() { return getToken(myGrammarParser.Comment, 0); }
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			setState(66);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56); assignment();
				setState(58);
				_la = _input.LA(1);
				if (_la==Comment) {
					{
					setState(57); match(Comment);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60); identifierDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(61); functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(62); ifStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(63); forStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(64); whileStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(65); expression(0);
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
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(myGrammarParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(myGrammarParser.Assign, 0); }
		public TerminalNode DataType() { return getToken(myGrammarParser.DataType, 0); }
		public TerminalNode OpenParen() { return getToken(myGrammarParser.OpenParen, 0); }
		public TerminalNode Def() { return getToken(myGrammarParser.Def, 0); }
		public TerminalNode Scan() { return getToken(myGrammarParser.Scan, 0); }
		public TerminalNode CloseParen() { return getToken(myGrammarParser.CloseParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Comma() { return getToken(myGrammarParser.Comma, 0); }
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
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignment);
		int _la;
		try {
			setState(88);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68); match(Identifier);
				setState(69); match(Assign);
				setState(70); expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71); match(Identifier);
				setState(72); indexes();
				setState(73); match(Assign);
				setState(74); expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(76); match(Scan);
				setState(77); match(OpenParen);
				setState(79);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Writeln) | (1L << Write) | (1L << Null) | (1L << Exclamation) | (1L << OpenBracket) | (1L << OpenParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
					{
					setState(78); expression(0);
					}
				}

				setState(81); match(Comma);
				setState(82); match(Identifier);
				setState(83); match(CloseParen);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(84); match(Def);
				setState(85); match(DataType);
				setState(86); match(Identifier);
				setState(87); indexes();
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

	public static class IdentifierDeclarationContext extends ParserRuleContext {
		public TerminalNode DataType() { return getToken(myGrammarParser.DataType, 0); }
		public TerminalNode Def() { return getToken(myGrammarParser.Def, 0); }
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
	}

	public final IdentifierDeclarationContext identifierDeclaration() throws RecognitionException {
		IdentifierDeclarationContext _localctx = new IdentifierDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_identifierDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); match(Def);
			setState(92);
			_la = _input.LA(1);
			if (_la==Final) {
				{
				setState(91); match(Final);
				}
			}

			setState(94); match(DataType);
			setState(95); idList();
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
		public TerminalNode OpenParen() { return getToken(myGrammarParser.OpenParen, 0); }
		public TerminalNode Writeln() { return getToken(myGrammarParser.Writeln, 0); }
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
	}
	public static class IdentifierFunctionCallContext extends FunctionCallContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(myGrammarParser.Identifier, 0); }
		public TerminalNode OpenParen() { return getToken(myGrammarParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(myGrammarParser.CloseParen, 0); }
		public IdentifierFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterIdentifierFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitIdentifierFunctionCall(this);
		}
	}
	public static class PrintFunctionCallContext extends FunctionCallContext {
		public TerminalNode Write() { return getToken(myGrammarParser.Write, 0); }
		public TerminalNode OpenParen() { return getToken(myGrammarParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(myGrammarParser.CloseParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterPrintFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitPrintFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionCall);
		int _la;
		try {
			setState(114);
			switch (_input.LA(1)) {
			case Identifier:
				_localctx = new IdentifierFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(97); match(Identifier);
				setState(98); match(OpenParen);
				setState(100);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Writeln) | (1L << Write) | (1L << Null) | (1L << Exclamation) | (1L << OpenBracket) | (1L << OpenParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
					{
					setState(99); exprList();
					}
				}

				setState(102); match(CloseParen);
				}
				break;
			case Writeln:
				_localctx = new PrintlnFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103); match(Writeln);
				setState(104); match(OpenParen);
				setState(106);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Writeln) | (1L << Write) | (1L << Null) | (1L << Exclamation) | (1L << OpenBracket) | (1L << OpenParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
					{
					setState(105); expression(0);
					}
				}

				setState(108); match(CloseParen);
				}
				break;
			case Write:
				_localctx = new PrintFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(109); match(Write);
				setState(110); match(OpenParen);
				setState(111); expression(0);
				setState(112); match(CloseParen);
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
		public ElseIfStatContext elseIfStat(int i) {
			return getRuleContext(ElseIfStatContext.class,i);
		}
		public List<ElseIfStatContext> elseIfStat() {
			return getRuleContexts(ElseIfStatContext.class);
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
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116); ifStat();
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(117); elseIfStat();
					}
					} 
				}
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(124);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(123); elseStat();
				}
			}

			setState(126); match(End);
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
		public TerminalNode Do() { return getToken(myGrammarParser.Do, 0); }
		public TerminalNode If() { return getToken(myGrammarParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); match(If);
			setState(129); expression(0);
			setState(130); match(Do);
			setState(131); block();
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
		public TerminalNode Do() { return getToken(myGrammarParser.Do, 0); }
		public TerminalNode Else() { return getToken(myGrammarParser.Else, 0); }
		public TerminalNode If() { return getToken(myGrammarParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
	}

	public final ElseIfStatContext elseIfStat() throws RecognitionException {
		ElseIfStatContext _localctx = new ElseIfStatContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_elseIfStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); match(Else);
			setState(134); match(If);
			setState(135); expression(0);
			setState(136); match(Do);
			setState(137); block();
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
		public TerminalNode Do() { return getToken(myGrammarParser.Do, 0); }
		public TerminalNode Else() { return getToken(myGrammarParser.Else, 0); }
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
	}

	public final ElseStatContext elseStat() throws RecognitionException {
		ElseStatContext _localctx = new ElseStatContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_elseStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); match(Else);
			setState(140); match(Do);
			setState(141); block();
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
		public TerminalNode DataType() { return getToken(myGrammarParser.DataType, 0); }
		public TerminalNode Identifier() { return getToken(myGrammarParser.Identifier, 0); }
		public TerminalNode OpenParen() { return getToken(myGrammarParser.OpenParen, 0); }
		public TerminalNode Def() { return getToken(myGrammarParser.Def, 0); }
		public TerminalNode End() { return getToken(myGrammarParser.End, 0); }
		public FunctionBlockContext functionBlock() {
			return getRuleContext(FunctionBlockContext.class,0);
		}
		public ParamIdListContext paramIdList() {
			return getRuleContext(ParamIdListContext.class,0);
		}
		public TerminalNode CloseParen() { return getToken(myGrammarParser.CloseParen, 0); }
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
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); match(Def);
			setState(144); match(DataType);
			setState(145); match(Identifier);
			setState(146); match(OpenParen);
			setState(148);
			_la = _input.LA(1);
			if (_la==DataType) {
				{
				setState(147); paramIdList();
				}
			}

			setState(150); match(CloseParen);
			setState(151); functionBlock();
			setState(152); match(End);
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
		public TerminalNode DataType() { return getToken(myGrammarParser.DataType, 0); }
		public TerminalNode Identifier() { return getToken(myGrammarParser.Identifier, 0); }
		public TerminalNode To() { return getToken(myGrammarParser.To, 0); }
		public TerminalNode End() { return getToken(myGrammarParser.End, 0); }
		public TerminalNode Do() { return getToken(myGrammarParser.Do, 0); }
		public TerminalNode For() { return getToken(myGrammarParser.For, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
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
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forStatement);
		try {
			setState(175);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154); match(For);
				setState(155); match(DataType);
				setState(156); match(Identifier);
				setState(157); match(Assign);
				setState(158); expression(0);
				setState(159); match(To);
				setState(160); expression(0);
				setState(161); match(Do);
				setState(162); block();
				setState(163); match(End);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(165); match(For);
				setState(166); match(Identifier);
				setState(167); match(Assign);
				setState(168); expression(0);
				setState(169); match(To);
				setState(170); expression(0);
				setState(171); match(Do);
				setState(172); block();
				setState(173); match(End);
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

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(myGrammarParser.While, 0); }
		public TerminalNode End() { return getToken(myGrammarParser.End, 0); }
		public TerminalNode Do() { return getToken(myGrammarParser.Do, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
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
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); match(While);
			setState(178); expression(0);
			setState(179); match(Do);
			setState(180); block();
			setState(181); match(End);
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
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_idList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); match(Identifier);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(184); match(Comma);
				setState(185); match(Identifier);
				}
				}
				setState(190);
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

	public static class ParamIdListContext extends ParserRuleContext {
		public List<TerminalNode> DataType() { return getTokens(myGrammarParser.DataType); }
		public List<TerminalNode> Identifier() { return getTokens(myGrammarParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(myGrammarParser.Identifier, i);
		}
		public TerminalNode DataType(int i) {
			return getToken(myGrammarParser.DataType, i);
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
	}

	public final ParamIdListContext paramIdList() throws RecognitionException {
		ParamIdListContext _localctx = new ParamIdListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_paramIdList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); match(DataType);
			setState(192); match(Identifier);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(193); match(Comma);
				setState(194); match(DataType);
				setState(195); match(Identifier);
				}
				}
				setState(200);
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
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201); expression(0);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(202); match(Comma);
				setState(203); expression(0);
				}
				}
				setState(208);
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
	public static class GtExpressionContext extends ExpressionContext {
		public TerminalNode GreatThan() { return getToken(myGrammarParser.GreatThan, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public GtExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterGtExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitGtExpression(this);
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
	}
	public static class IdentifierExpressionContext extends ExpressionContext {
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(myGrammarParser.Identifier, 0); }
		public IdentifierExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterIdentifierExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitIdentifierExpression(this);
		}
	}
	public static class ModulusExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
	}
	public static class NotExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Exclamation() { return getToken(myGrammarParser.Exclamation, 0); }
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitNotExpression(this);
		}
	}
	public static class MultiplyExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
	}
	public static class GtEqExpressionContext extends ExpressionContext {
		public TerminalNode GTEquals() { return getToken(myGrammarParser.GTEquals, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public GtEqExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterGtEqExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitGtEqExpression(this);
		}
	}
	public static class AndExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
	}
	public static class StringExpressionContext extends ExpressionContext {
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public TerminalNode String() { return getToken(myGrammarParser.String, 0); }
		public StringExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitStringExpression(this);
		}
	}
	public static class ExpressionExpressionContext extends ExpressionContext {
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public TerminalNode OpenParen() { return getToken(myGrammarParser.OpenParen, 0); }
		public TerminalNode CloseParen() { return getToken(myGrammarParser.CloseParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
	}
	public static class FunctionCallExpressionContext extends ExpressionContext {
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
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
	}
	public static class ListExpressionContext extends ExpressionContext {
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
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
	}
	public static class LtEqExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LTEquals() { return getToken(myGrammarParser.LTEquals, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public LtEqExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterLtEqExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitLtEqExpression(this);
		}
	}
	public static class LtExpressionContext extends ExpressionContext {
		public TerminalNode LessThan() { return getToken(myGrammarParser.LessThan, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public LtExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterLtExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitLtExpression(this);
		}
	}
	public static class ArrayExpressionContext extends ExpressionContext {
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(myGrammarParser.Identifier, 0); }
		public ArrayExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterArrayExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitArrayExpression(this);
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
	}
	public static class NotEqExpressionContext extends ExpressionContext {
		public TerminalNode NEquals() { return getToken(myGrammarParser.NEquals, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public NotEqExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterNotEqExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitNotEqExpression(this);
		}
	}
	public static class DivideExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
	}
	public static class OrExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Or() { return getToken(myGrammarParser.Or, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public OrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitOrExpression(this);
		}
	}
	public static class PowerExpressionContext extends ExpressionContext {
		public TerminalNode Pow() { return getToken(myGrammarParser.Pow, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public PowerExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).enterPowerExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener ) ((myGrammarListener)listener).exitPowerExpression(this);
		}
	}
	public static class EqExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
	}
	public static class AddExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
	}
	public static class SubtractExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
	}
	public static class TernaryExpressionContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(210); match(Exclamation);
				setState(211); expression(25);
				}
				break;
			case 2:
				{
				_localctx = new ArrayExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212); match(Identifier);
				setState(213); indexes();
				}
				break;
			case 3:
				{
				_localctx = new NumberExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214); match(Number);
				}
				break;
			case 4:
				{
				_localctx = new BoolExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215); match(Bool);
				}
				break;
			case 5:
				{
				_localctx = new NullExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216); match(Null);
				}
				break;
			case 6:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217); functionCall();
				setState(219);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(218); indexes();
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
				setState(221); list();
				setState(223);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(222); indexes();
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
				setState(225); match(Identifier);
				setState(227);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(226); indexes();
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
				setState(229); match(String);
				setState(231);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(230); indexes();
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
				setState(233); match(OpenParen);
				setState(234); expression(0);
				setState(235); match(CloseParen);
				setState(237);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(236); indexes();
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(291);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(289);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new PowerExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(241);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(242); match(Pow);
						setState(243); expression(25);
						}
						break;
					case 2:
						{
						_localctx = new MultiplyExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(244);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(245); match(Multiply);
						setState(246); expression(24);
						}
						break;
					case 3:
						{
						_localctx = new DivideExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(247);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(248); match(Divide);
						setState(249); expression(23);
						}
						break;
					case 4:
						{
						_localctx = new ModulusExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(250);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(251); match(Modulus);
						setState(252); expression(22);
						}
						break;
					case 5:
						{
						_localctx = new AddExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(253);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(254); match(Add);
						setState(255); expression(21);
						}
						break;
					case 6:
						{
						_localctx = new SubtractExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(256);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(257); match(Subtract);
						setState(258); expression(20);
						}
						break;
					case 7:
						{
						_localctx = new GtEqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(259);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(260); match(GTEquals);
						setState(261); expression(19);
						}
						break;
					case 8:
						{
						_localctx = new LtEqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(262);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(263); match(LTEquals);
						setState(264); expression(18);
						}
						break;
					case 9:
						{
						_localctx = new GtExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(265);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(266); match(GreatThan);
						setState(267); expression(17);
						}
						break;
					case 10:
						{
						_localctx = new LtExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(268);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(269); match(LessThan);
						setState(270); expression(16);
						}
						break;
					case 11:
						{
						_localctx = new EqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(271);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(272); match(Equals);
						setState(273); expression(15);
						}
						break;
					case 12:
						{
						_localctx = new NotEqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(274);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(275); match(NEquals);
						setState(276); expression(14);
						}
						break;
					case 13:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(277);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(278); match(And);
						setState(279); expression(13);
						}
						break;
					case 14:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(280);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(281); match(Or);
						setState(282); expression(12);
						}
						break;
					case 15:
						{
						_localctx = new TernaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(283);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(284); match(T__0);
						setState(285); expression(0);
						setState(286); match(Colon);
						setState(287); expression(11);
						}
						break;
					}
					} 
				}
				setState(293);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode OpenBracket() { return getToken(myGrammarParser.OpenBracket, 0); }
		public TerminalNode CloseBracket() { return getToken(myGrammarParser.CloseBracket, 0); }
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
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294); match(OpenBracket);
			setState(296);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Writeln) | (1L << Write) | (1L << Null) | (1L << Exclamation) | (1L << OpenBracket) | (1L << OpenParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
				{
				setState(295); exprList();
				}
			}

			setState(298); match(CloseBracket);
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
		public TerminalNode OpenBracket(int i) {
			return getToken(myGrammarParser.OpenBracket, i);
		}
		public List<TerminalNode> OpenBracket() { return getTokens(myGrammarParser.OpenBracket); }
		public List<TerminalNode> CloseBracket() { return getTokens(myGrammarParser.CloseBracket); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
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
	}

	public final IndexesContext indexes() throws RecognitionException {
		IndexesContext _localctx = new IndexesContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_indexes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(304); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(300); match(OpenBracket);
					setState(301); expression(0);
					setState(302); match(CloseBracket);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(306); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
		case 17: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 24);
		case 1: return precpred(_ctx, 23);
		case 2: return precpred(_ctx, 22);
		case 3: return precpred(_ctx, 21);
		case 4: return precpred(_ctx, 20);
		case 5: return precpred(_ctx, 19);
		case 6: return precpred(_ctx, 18);
		case 7: return precpred(_ctx, 17);
		case 8: return precpred(_ctx, 16);
		case 9: return precpred(_ctx, 15);
		case 10: return precpred(_ctx, 14);
		case 11: return precpred(_ctx, 13);
		case 12: return precpred(_ctx, 12);
		case 13: return precpred(_ctx, 11);
		case 14: return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\64\u0137\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\3\3\3\3\4\3\4\7\4\62\n\4"+
		"\f\4\16\4\65\13\4\3\4\3\4\5\49\n\4\3\5\3\5\5\5=\n\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5E\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6R\n\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6[\n\6\3\7\3\7\5\7_\n\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\5\bg\n\b\3\b\3\b\3\b\3\b\5\bm\n\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bu"+
		"\n\b\3\t\3\t\7\ty\n\t\f\t\16\t|\13\t\3\t\5\t\177\n\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\5\r\u0097\n\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u00b2\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\7\20\u00bd"+
		"\n\20\f\20\16\20\u00c0\13\20\3\21\3\21\3\21\3\21\3\21\7\21\u00c7\n\21"+
		"\f\21\16\21\u00ca\13\21\3\22\3\22\3\22\7\22\u00cf\n\22\f\22\16\22\u00d2"+
		"\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00de\n"+
		"\23\3\23\3\23\5\23\u00e2\n\23\3\23\3\23\5\23\u00e6\n\23\3\23\3\23\5\23"+
		"\u00ea\n\23\3\23\3\23\3\23\3\23\5\23\u00f0\n\23\5\23\u00f2\n\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\7\23\u0124\n\23\f\23\16\23\u0127\13\23\3\24\3"+
		"\24\5\24\u012b\n\24\3\24\3\24\3\25\3\25\3\25\3\25\6\25\u0133\n\25\r\25"+
		"\16\25\u0134\3\25\2\3$\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(\2\2\u015b\2*\3\2\2\2\4-\3\2\2\2\6\63\3\2\2\2\bD\3\2\2\2\nZ\3\2\2\2\f"+
		"\\\3\2\2\2\16t\3\2\2\2\20v\3\2\2\2\22\u0082\3\2\2\2\24\u0087\3\2\2\2\26"+
		"\u008d\3\2\2\2\30\u0091\3\2\2\2\32\u00b1\3\2\2\2\34\u00b3\3\2\2\2\36\u00b9"+
		"\3\2\2\2 \u00c1\3\2\2\2\"\u00cb\3\2\2\2$\u00f1\3\2\2\2&\u0128\3\2\2\2"+
		"(\u0132\3\2\2\2*+\5\4\3\2+,\7\2\2\3,\3\3\2\2\2-.\5\6\4\2.\5\3\2\2\2/\62"+
		"\5\b\5\2\60\62\5\30\r\2\61/\3\2\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61"+
		"\3\2\2\2\63\64\3\2\2\2\648\3\2\2\2\65\63\3\2\2\2\66\67\7\n\2\2\679\5$"+
		"\23\28\66\3\2\2\289\3\2\2\29\7\3\2\2\2:<\5\n\6\2;=\7\60\2\2<;\3\2\2\2"+
		"<=\3\2\2\2=E\3\2\2\2>E\5\f\7\2?E\5\16\b\2@E\5\20\t\2AE\5\32\16\2BE\5\34"+
		"\17\2CE\5$\23\2D:\3\2\2\2D>\3\2\2\2D?\3\2\2\2D@\3\2\2\2DA\3\2\2\2DB\3"+
		"\2\2\2DC\3\2\2\2E\t\3\2\2\2FG\7.\2\2GH\7\'\2\2H[\5$\23\2IJ\7.\2\2JK\5"+
		"(\25\2KL\7\'\2\2LM\5$\23\2M[\3\2\2\2NO\7\6\2\2OQ\7$\2\2PR\5$\23\2QP\3"+
		"\2\2\2QR\3\2\2\2RS\3\2\2\2ST\7(\2\2TU\7.\2\2U[\7%\2\2VW\7\7\2\2WX\7+\2"+
		"\2XY\7.\2\2Y[\5(\25\2ZF\3\2\2\2ZI\3\2\2\2ZN\3\2\2\2ZV\3\2\2\2[\13\3\2"+
		"\2\2\\^\7\7\2\2]_\7*\2\2^]\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\7+\2\2ab\5\36"+
		"\20\2b\r\3\2\2\2cd\7.\2\2df\7$\2\2eg\5\"\22\2fe\3\2\2\2fg\3\2\2\2gh\3"+
		"\2\2\2hu\7%\2\2ij\7\4\2\2jl\7$\2\2km\5$\23\2lk\3\2\2\2lm\3\2\2\2mn\3\2"+
		"\2\2nu\7%\2\2op\7\5\2\2pq\7$\2\2qr\5$\23\2rs\7%\2\2su\3\2\2\2tc\3\2\2"+
		"\2ti\3\2\2\2to\3\2\2\2u\17\3\2\2\2vz\5\22\n\2wy\5\24\13\2xw\3\2\2\2y|"+
		"\3\2\2\2zx\3\2\2\2z{\3\2\2\2{~\3\2\2\2|z\3\2\2\2}\177\5\26\f\2~}\3\2\2"+
		"\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\7\17\2\2\u0081\21\3\2\2"+
		"\2\u0082\u0083\7\b\2\2\u0083\u0084\5$\23\2\u0084\u0085\7\16\2\2\u0085"+
		"\u0086\5\6\4\2\u0086\23\3\2\2\2\u0087\u0088\7\t\2\2\u0088\u0089\7\b\2"+
		"\2\u0089\u008a\5$\23\2\u008a\u008b\7\16\2\2\u008b\u008c\5\6\4\2\u008c"+
		"\25\3\2\2\2\u008d\u008e\7\t\2\2\u008e\u008f\7\16\2\2\u008f\u0090\5\6\4"+
		"\2\u0090\27\3\2\2\2\u0091\u0092\7\7\2\2\u0092\u0093\7+\2\2\u0093\u0094"+
		"\7.\2\2\u0094\u0096\7$\2\2\u0095\u0097\5 \21\2\u0096\u0095\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\7%\2\2\u0099\u009a\5\4"+
		"\3\2\u009a\u009b\7\17\2\2\u009b\31\3\2\2\2\u009c\u009d\7\13\2\2\u009d"+
		"\u009e\7+\2\2\u009e\u009f\7.\2\2\u009f\u00a0\7\'\2\2\u00a0\u00a1\5$\23"+
		"\2\u00a1\u00a2\7\r\2\2\u00a2\u00a3\5$\23\2\u00a3\u00a4\7\16\2\2\u00a4"+
		"\u00a5\5\6\4\2\u00a5\u00a6\7\17\2\2\u00a6\u00b2\3\2\2\2\u00a7\u00a8\7"+
		"\13\2\2\u00a8\u00a9\7.\2\2\u00a9\u00aa\7\'\2\2\u00aa\u00ab\5$\23\2\u00ab"+
		"\u00ac\7\r\2\2\u00ac\u00ad\5$\23\2\u00ad\u00ae\7\16\2\2\u00ae\u00af\5"+
		"\6\4\2\u00af\u00b0\7\17\2\2\u00b0\u00b2\3\2\2\2\u00b1\u009c\3\2\2\2\u00b1"+
		"\u00a7\3\2\2\2\u00b2\33\3\2\2\2\u00b3\u00b4\7\f\2\2\u00b4\u00b5\5$\23"+
		"\2\u00b5\u00b6\7\16\2\2\u00b6\u00b7\5\6\4\2\u00b7\u00b8\7\17\2\2\u00b8"+
		"\35\3\2\2\2\u00b9\u00be\7.\2\2\u00ba\u00bb\7(\2\2\u00bb\u00bd\7.\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\37\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7+\2\2\u00c2\u00c8"+
		"\7.\2\2\u00c3\u00c4\7(\2\2\u00c4\u00c5\7+\2\2\u00c5\u00c7\7.\2\2\u00c6"+
		"\u00c3\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9!\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00d0\5$\23\2\u00cc\u00cd"+
		"\7(\2\2\u00cd\u00cf\5$\23\2\u00ce\u00cc\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1#\3\2\2\2\u00d2\u00d0\3\2\2\2"+
		"\u00d3\u00d4\b\23\1\2\u00d4\u00d5\7\30\2\2\u00d5\u00f2\5$\23\33\u00d6"+
		"\u00d7\7.\2\2\u00d7\u00f2\5(\25\2\u00d8\u00f2\7-\2\2\u00d9\u00f2\7,\2"+
		"\2\u00da\u00f2\7\20\2\2\u00db\u00dd\5\16\b\2\u00dc\u00de\5(\25\2\u00dd"+
		"\u00dc\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00f2\3\2\2\2\u00df\u00e1\5&"+
		"\24\2\u00e0\u00e2\5(\25\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00f2\3\2\2\2\u00e3\u00e5\7.\2\2\u00e4\u00e6\5(\25\2\u00e5\u00e4\3\2"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00f2\3\2\2\2\u00e7\u00e9\7/\2\2\u00e8"+
		"\u00ea\5(\25\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00f2\3\2"+
		"\2\2\u00eb\u00ec\7$\2\2\u00ec\u00ed\5$\23\2\u00ed\u00ef\7%\2\2\u00ee\u00f0"+
		"\5(\25\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1"+
		"\u00d3\3\2\2\2\u00f1\u00d6\3\2\2\2\u00f1\u00d8\3\2\2\2\u00f1\u00d9\3\2"+
		"\2\2\u00f1\u00da\3\2\2\2\u00f1\u00db\3\2\2\2\u00f1\u00df\3\2\2\2\u00f1"+
		"\u00e3\3\2\2\2\u00f1\u00e7\3\2\2\2\u00f1\u00eb\3\2\2\2\u00f2\u0125\3\2"+
		"\2\2\u00f3\u00f4\f\32\2\2\u00f4\u00f5\7\27\2\2\u00f5\u0124\5$\23\33\u00f6"+
		"\u00f7\f\31\2\2\u00f7\u00f8\7\35\2\2\u00f8\u0124\5$\23\32\u00f9\u00fa"+
		"\f\30\2\2\u00fa\u00fb\7\36\2\2\u00fb\u0124\5$\23\31\u00fc\u00fd\f\27\2"+
		"\2\u00fd\u00fe\7\37\2\2\u00fe\u0124\5$\23\30\u00ff\u0100\f\26\2\2\u0100"+
		"\u0101\7\33\2\2\u0101\u0124\5$\23\27\u0102\u0103\f\25\2\2\u0103\u0104"+
		"\7\34\2\2\u0104\u0124\5$\23\26\u0105\u0106\f\24\2\2\u0106\u0107\7\25\2"+
		"\2\u0107\u0124\5$\23\25\u0108\u0109\f\23\2\2\u0109\u010a\7\26\2\2\u010a"+
		"\u0124\5$\23\24\u010b\u010c\f\22\2\2\u010c\u010d\7\31\2\2\u010d\u0124"+
		"\5$\23\23\u010e\u010f\f\21\2\2\u010f\u0110\7\32\2\2\u0110\u0124\5$\23"+
		"\22\u0111\u0112\f\20\2\2\u0112\u0113\7\23\2\2\u0113\u0124\5$\23\21\u0114"+
		"\u0115\f\17\2\2\u0115\u0116\7\24\2\2\u0116\u0124\5$\23\20\u0117\u0118"+
		"\f\16\2\2\u0118\u0119\7\22\2\2\u0119\u0124\5$\23\17\u011a\u011b\f\r\2"+
		"\2\u011b\u011c\7\21\2\2\u011c\u0124\5$\23\16\u011d\u011e\f\f\2\2\u011e"+
		"\u011f\7\3\2\2\u011f\u0120\5$\23\2\u0120\u0121\7)\2\2\u0121\u0122\5$\23"+
		"\r\u0122\u0124\3\2\2\2\u0123\u00f3\3\2\2\2\u0123\u00f6\3\2\2\2\u0123\u00f9"+
		"\3\2\2\2\u0123\u00fc\3\2\2\2\u0123\u00ff\3\2\2\2\u0123\u0102\3\2\2\2\u0123"+
		"\u0105\3\2\2\2\u0123\u0108\3\2\2\2\u0123\u010b\3\2\2\2\u0123\u010e\3\2"+
		"\2\2\u0123\u0111\3\2\2\2\u0123\u0114\3\2\2\2\u0123\u0117\3\2\2\2\u0123"+
		"\u011a\3\2\2\2\u0123\u011d\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2"+
		"\2\2\u0125\u0126\3\2\2\2\u0126%\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u012a"+
		"\7\"\2\2\u0129\u012b\5\"\22\2\u012a\u0129\3\2\2\2\u012a\u012b\3\2\2\2"+
		"\u012b\u012c\3\2\2\2\u012c\u012d\7#\2\2\u012d\'\3\2\2\2\u012e\u012f\7"+
		"\"\2\2\u012f\u0130\5$\23\2\u0130\u0131\7#\2\2\u0131\u0133\3\2\2\2\u0132"+
		"\u012e\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2"+
		"\2\2\u0135)\3\2\2\2\36\61\638<DQZ^fltz~\u0096\u00b1\u00be\u00c8\u00d0"+
		"\u00dd\u00e1\u00e5\u00e9\u00ef\u00f1\u0123\u0125\u012a\u0134";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}