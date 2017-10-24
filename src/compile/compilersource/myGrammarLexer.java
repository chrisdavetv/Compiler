// Generated from /Users/chris/Documents/Projects/Compiler/src/compile/compilersource/myGrammar.g4 by ANTLR 4.5.3

package compile.compilersource;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class myGrammarLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "Writeln", "Write", "Def", "If", "Else", "Return", "For", "While", 
		"To", "Do", "End", "Null", "Or", "And", "Equals", "NEquals", "GTEquals", 
		"LTEquals", "Pow", "Exclamation", "GreatThan", "LessThan", "Add", "Subtract", 
		"Multiply", "Divide", "Modulus", "OpenCurlyBracket", "CloseCurlyBracket", 
		"OpenBracket", "CloseBracket", "OpenParen", "CloseParen", "SemiColon", 
		"Assign", "Comma", "Colon", "Bool", "Number", "Identifier", "String", 
		"Comment", "Space", "Int", "Digit", "UNKNOWN_CHAR"
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


	public myGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "myGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\61\u0135\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\5(\u00df\n(\3)\3)\3)\7)\u00e4\n)\f)\16)\u00e7\13)\5)\u00e9\n)\3*"+
		"\3*\7*\u00ed\n*\f*\16*\u00f0\13*\3+\3+\3+\3+\3+\3+\7+\u00f8\n+\f+\16+"+
		"\u00fb\13+\3+\3+\3+\3+\3+\3+\3+\7+\u0104\n+\f+\16+\u0107\13+\3+\5+\u010a"+
		"\n+\3,\3,\3,\3,\7,\u0110\n,\f,\16,\u0113\13,\3,\3,\3,\3,\7,\u0119\n,\f"+
		",\16,\u011c\13,\3,\3,\5,\u0120\n,\3,\3,\3-\3-\3-\3-\3.\3.\7.\u012a\n."+
		"\f.\16.\u012d\13.\3.\5.\u0130\n.\3/\3/\3\60\3\60\3\u011a\2\61\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61\3\2\f\5\2C\\aac|\6\2\62;C\\aac|\3\2"+
		"$$\5\2\f\f\17\17$$\3\2))\5\2\f\f\17\17))\4\2\f\f\17\17\5\2\13\f\16\17"+
		"\"\"\3\2\63;\3\2\62;\u0144\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5c\3\2\2\2\7k\3\2\2\2\tq\3\2\2\2\13u\3"+
		"\2\2\2\rx\3\2\2\2\17}\3\2\2\2\21\u0084\3\2\2\2\23\u0088\3\2\2\2\25\u008e"+
		"\3\2\2\2\27\u0091\3\2\2\2\31\u0094\3\2\2\2\33\u0098\3\2\2\2\35\u009d\3"+
		"\2\2\2\37\u00a0\3\2\2\2!\u00a3\3\2\2\2#\u00a6\3\2\2\2%\u00a9\3\2\2\2\'"+
		"\u00ac\3\2\2\2)\u00af\3\2\2\2+\u00b1\3\2\2\2-\u00b3\3\2\2\2/\u00b5\3\2"+
		"\2\2\61\u00b7\3\2\2\2\63\u00b9\3\2\2\2\65\u00bb\3\2\2\2\67\u00bd\3\2\2"+
		"\29\u00bf\3\2\2\2;\u00c1\3\2\2\2=\u00c3\3\2\2\2?\u00c5\3\2\2\2A\u00c7"+
		"\3\2\2\2C\u00c9\3\2\2\2E\u00cb\3\2\2\2G\u00cd\3\2\2\2I\u00cf\3\2\2\2K"+
		"\u00d1\3\2\2\2M\u00d3\3\2\2\2O\u00de\3\2\2\2Q\u00e0\3\2\2\2S\u00ea\3\2"+
		"\2\2U\u0109\3\2\2\2W\u011f\3\2\2\2Y\u0123\3\2\2\2[\u012f\3\2\2\2]\u0131"+
		"\3\2\2\2_\u0133\3\2\2\2ab\7A\2\2b\4\3\2\2\2cd\7Y\2\2de\7t\2\2ef\7k\2\2"+
		"fg\7v\2\2gh\7g\2\2hi\7n\2\2ij\7p\2\2j\6\3\2\2\2kl\7Y\2\2lm\7t\2\2mn\7"+
		"k\2\2no\7v\2\2op\7g\2\2p\b\3\2\2\2qr\7f\2\2rs\7g\2\2st\7h\2\2t\n\3\2\2"+
		"\2uv\7k\2\2vw\7h\2\2w\f\3\2\2\2xy\7g\2\2yz\7n\2\2z{\7u\2\2{|\7g\2\2|\16"+
		"\3\2\2\2}~\7t\2\2~\177\7g\2\2\177\u0080\7v\2\2\u0080\u0081\7w\2\2\u0081"+
		"\u0082\7t\2\2\u0082\u0083\7p\2\2\u0083\20\3\2\2\2\u0084\u0085\7h\2\2\u0085"+
		"\u0086\7q\2\2\u0086\u0087\7t\2\2\u0087\22\3\2\2\2\u0088\u0089\7y\2\2\u0089"+
		"\u008a\7j\2\2\u008a\u008b\7k\2\2\u008b\u008c\7n\2\2\u008c\u008d\7g\2\2"+
		"\u008d\24\3\2\2\2\u008e\u008f\7v\2\2\u008f\u0090\7q\2\2\u0090\26\3\2\2"+
		"\2\u0091\u0092\7f\2\2\u0092\u0093\7q\2\2\u0093\30\3\2\2\2\u0094\u0095"+
		"\7g\2\2\u0095\u0096\7p\2\2\u0096\u0097\7f\2\2\u0097\32\3\2\2\2\u0098\u0099"+
		"\7p\2\2\u0099\u009a\7w\2\2\u009a\u009b\7n\2\2\u009b\u009c\7n\2\2\u009c"+
		"\34\3\2\2\2\u009d\u009e\7~\2\2\u009e\u009f\7~\2\2\u009f\36\3\2\2\2\u00a0"+
		"\u00a1\7(\2\2\u00a1\u00a2\7(\2\2\u00a2 \3\2\2\2\u00a3\u00a4\7?\2\2\u00a4"+
		"\u00a5\7?\2\2\u00a5\"\3\2\2\2\u00a6\u00a7\7#\2\2\u00a7\u00a8\7?\2\2\u00a8"+
		"$\3\2\2\2\u00a9\u00aa\7@\2\2\u00aa\u00ab\7?\2\2\u00ab&\3\2\2\2\u00ac\u00ad"+
		"\7>\2\2\u00ad\u00ae\7?\2\2\u00ae(\3\2\2\2\u00af\u00b0\7`\2\2\u00b0*\3"+
		"\2\2\2\u00b1\u00b2\7#\2\2\u00b2,\3\2\2\2\u00b3\u00b4\7@\2\2\u00b4.\3\2"+
		"\2\2\u00b5\u00b6\7>\2\2\u00b6\60\3\2\2\2\u00b7\u00b8\7-\2\2\u00b8\62\3"+
		"\2\2\2\u00b9\u00ba\7/\2\2\u00ba\64\3\2\2\2\u00bb\u00bc\7,\2\2\u00bc\66"+
		"\3\2\2\2\u00bd\u00be\7\61\2\2\u00be8\3\2\2\2\u00bf\u00c0\7\'\2\2\u00c0"+
		":\3\2\2\2\u00c1\u00c2\7}\2\2\u00c2<\3\2\2\2\u00c3\u00c4\7\177\2\2\u00c4"+
		">\3\2\2\2\u00c5\u00c6\7]\2\2\u00c6@\3\2\2\2\u00c7\u00c8\7_\2\2\u00c8B"+
		"\3\2\2\2\u00c9\u00ca\7*\2\2\u00caD\3\2\2\2\u00cb\u00cc\7+\2\2\u00ccF\3"+
		"\2\2\2\u00cd\u00ce\7=\2\2\u00ceH\3\2\2\2\u00cf\u00d0\7?\2\2\u00d0J\3\2"+
		"\2\2\u00d1\u00d2\7.\2\2\u00d2L\3\2\2\2\u00d3\u00d4\7<\2\2\u00d4N\3\2\2"+
		"\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7t\2\2\u00d7\u00d8\7w\2\2\u00d8\u00df"+
		"\7g\2\2\u00d9\u00da\7h\2\2\u00da\u00db\7c\2\2\u00db\u00dc\7n\2\2\u00dc"+
		"\u00dd\7u\2\2\u00dd\u00df\7g\2\2\u00de\u00d5\3\2\2\2\u00de\u00d9\3\2\2"+
		"\2\u00dfP\3\2\2\2\u00e0\u00e8\5[.\2\u00e1\u00e5\7\60\2\2\u00e2\u00e4\5"+
		"]/\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e1\3\2"+
		"\2\2\u00e8\u00e9\3\2\2\2\u00e9R\3\2\2\2\u00ea\u00ee\t\2\2\2\u00eb\u00ed"+
		"\t\3\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00efT\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f9\t\4\2\2"+
		"\u00f2\u00f8\n\5\2\2\u00f3\u00f4\7^\2\2\u00f4\u00f8\7^\2\2\u00f5\u00f6"+
		"\7^\2\2\u00f6\u00f8\7$\2\2\u00f7\u00f2\3\2\2\2\u00f7\u00f3\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2"+
		"\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u010a\t\4\2\2\u00fd"+
		"\u0105\t\6\2\2\u00fe\u0104\n\7\2\2\u00ff\u0100\7^\2\2\u0100\u0104\7^\2"+
		"\2\u0101\u0102\7^\2\2\u0102\u0104\7)\2\2\u0103\u00fe\3\2\2\2\u0103\u00ff"+
		"\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0108\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u010a\t\6"+
		"\2\2\u0109\u00f1\3\2\2\2\u0109\u00fd\3\2\2\2\u010aV\3\2\2\2\u010b\u010c"+
		"\7\61\2\2\u010c\u010d\7\61\2\2\u010d\u0111\3\2\2\2\u010e\u0110\n\b\2\2"+
		"\u010f\u010e\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112"+
		"\3\2\2\2\u0112\u0120\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115\7\61\2\2"+
		"\u0115\u0116\7,\2\2\u0116\u011a\3\2\2\2\u0117\u0119\13\2\2\2\u0118\u0117"+
		"\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u011b\3\2\2\2\u011a\u0118\3\2\2\2\u011b"+
		"\u011d\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\7,\2\2\u011e\u0120\7\61"+
		"\2\2\u011f\u010b\3\2\2\2\u011f\u0114\3\2\2\2\u0120\u0121\3\2\2\2\u0121"+
		"\u0122\b,\2\2\u0122X\3\2\2\2\u0123\u0124\t\t\2\2\u0124\u0125\3\2\2\2\u0125"+
		"\u0126\b-\2\2\u0126Z\3\2\2\2\u0127\u012b\t\n\2\2\u0128\u012a\5]/\2\u0129"+
		"\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c\u0130\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u0130\7\62\2\2\u012f"+
		"\u0127\3\2\2\2\u012f\u012e\3\2\2\2\u0130\\\3\2\2\2\u0131\u0132\t\13\2"+
		"\2\u0132^\3\2\2\2\u0133\u0134\13\2\2\2\u0134`\3\2\2\2\21\2\u00de\u00e5"+
		"\u00e8\u00ee\u00f7\u00f9\u0103\u0105\u0109\u0111\u011a\u011f\u012b\u012f"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}