// Generated from myGrammar.g4 by ANTLR 4.5.3

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
		T__0=1, Writeln=2, Write=3, Scan=4, Def=5, If=6, Else=7, Return=8, For=9, 
		While=10, To=11, Do=12, End=13, Null=14, Or=15, And=16, Equals=17, NEquals=18, 
		GTEquals=19, LTEquals=20, Pow=21, Exclamation=22, GreatThan=23, LessThan=24, 
		Add=25, Subtract=26, Multiply=27, Divide=28, Modulus=29, OpenCurlyBracket=30, 
		CloseCurlyBracket=31, OpenBracket=32, CloseBracket=33, OpenParen=34, CloseParen=35, 
		SemiColon=36, Assign=37, Comma=38, Colon=39, DataType=40, Bool=41, Number=42, 
		Identifier=43, String=44, Comment=45, Space=46, Int=47, Digit=48, UNKNOWN_CHAR=49, 
		ArrayUnion=50, Array=51;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "Writeln", "Write", "Scan", "Def", "If", "Else", "Return", "For", 
		"While", "To", "Do", "End", "Null", "Or", "And", "Equals", "NEquals", 
		"GTEquals", "LTEquals", "Pow", "Exclamation", "GreatThan", "LessThan", 
		"Add", "Subtract", "Multiply", "Divide", "Modulus", "OpenCurlyBracket", 
		"CloseCurlyBracket", "OpenBracket", "CloseBracket", "OpenParen", "CloseParen", 
		"SemiColon", "Assign", "Comma", "Colon", "DataType", "Bool", "Number", 
		"Identifier", "String", "Comment", "Space", "Int", "Digit", "UNKNOWN_CHAR", 
		"ArrayUnion", "Array"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'?'", "'Writeln'", "'Write'", "'Scan'", "'def'", "'if'", "'else'", 
		"'return'", "'for'", "'while'", "'to'", "'do'", "'end'", "'null'", "'||'", 
		"'&&'", "'=='", "'!='", "'>='", "'<='", "'^'", "'!'", "'>'", "'<'", "'+'", 
		"'-'", "'*'", "'/'", "'%'", "'{'", "'}'", "'['", "']'", "'('", "')'", 
		"';'", "'='", "','", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "Writeln", "Write", "Scan", "Def", "If", "Else", "Return", 
		"For", "While", "To", "Do", "End", "Null", "Or", "And", "Equals", "NEquals", 
		"GTEquals", "LTEquals", "Pow", "Exclamation", "GreatThan", "LessThan", 
		"Add", "Subtract", "Multiply", "Divide", "Modulus", "OpenCurlyBracket", 
		"CloseCurlyBracket", "OpenBracket", "CloseBracket", "OpenParen", "CloseParen", 
		"SemiColon", "Assign", "Comma", "Colon", "DataType", "Bool", "Number", 
		"Identifier", "String", "Comment", "Space", "Int", "Digit", "UNKNOWN_CHAR", 
		"ArrayUnion", "Array"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\65\u0177\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\3)\3)\5)\u0107\n)\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u0112\n*\3+\3+"+
		"\3+\7+\u0117\n+\f+\16+\u011a\13+\5+\u011c\n+\3,\3,\7,\u0120\n,\f,\16,"+
		"\u0123\13,\3-\3-\3-\3-\3-\3-\7-\u012b\n-\f-\16-\u012e\13-\3-\3-\3-\3-"+
		"\3-\3-\3-\7-\u0137\n-\f-\16-\u013a\13-\3-\5-\u013d\n-\3.\3.\3.\3.\7.\u0143"+
		"\n.\f.\16.\u0146\13.\3.\3.\3.\3.\7.\u014c\n.\f.\16.\u014f\13.\3.\3.\5"+
		".\u0153\n.\3.\3.\3/\3/\3/\3/\3\60\3\60\7\60\u015d\n\60\f\60\16\60\u0160"+
		"\13\60\3\60\5\60\u0163\n\60\3\61\3\61\3\62\3\62\3\63\3\63\5\63\u016b\n"+
		"\63\3\64\3\64\3\64\3\64\7\64\u0171\n\64\f\64\16\64\u0174\13\64\3\64\3"+
		"\64\3\u014d\2\65\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64"+
		"g\65\3\2\f\5\2C\\aac|\6\2\62;C\\aac|\3\2$$\5\2\f\f\17\17$$\3\2))\5\2\f"+
		"\f\17\17))\4\2\f\f\17\17\5\2\13\f\16\17\"\"\3\2\63;\3\2\62;\u018e\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\3i\3\2\2\2\5k\3\2\2\2\7s\3\2\2\2\t"+
		"y\3\2\2\2\13~\3\2\2\2\r\u0082\3\2\2\2\17\u0085\3\2\2\2\21\u008a\3\2\2"+
		"\2\23\u0091\3\2\2\2\25\u0095\3\2\2\2\27\u009b\3\2\2\2\31\u009e\3\2\2\2"+
		"\33\u00a1\3\2\2\2\35\u00a5\3\2\2\2\37\u00aa\3\2\2\2!\u00ad\3\2\2\2#\u00b0"+
		"\3\2\2\2%\u00b3\3\2\2\2\'\u00b6\3\2\2\2)\u00b9\3\2\2\2+\u00bc\3\2\2\2"+
		"-\u00be\3\2\2\2/\u00c0\3\2\2\2\61\u00c2\3\2\2\2\63\u00c4\3\2\2\2\65\u00c6"+
		"\3\2\2\2\67\u00c8\3\2\2\29\u00ca\3\2\2\2;\u00cc\3\2\2\2=\u00ce\3\2\2\2"+
		"?\u00d0\3\2\2\2A\u00d2\3\2\2\2C\u00d4\3\2\2\2E\u00d6\3\2\2\2G\u00d8\3"+
		"\2\2\2I\u00da\3\2\2\2K\u00dc\3\2\2\2M\u00de\3\2\2\2O\u00e0\3\2\2\2Q\u0106"+
		"\3\2\2\2S\u0111\3\2\2\2U\u0113\3\2\2\2W\u011d\3\2\2\2Y\u013c\3\2\2\2["+
		"\u0152\3\2\2\2]\u0156\3\2\2\2_\u0162\3\2\2\2a\u0164\3\2\2\2c\u0166\3\2"+
		"\2\2e\u016a\3\2\2\2g\u016c\3\2\2\2ij\7A\2\2j\4\3\2\2\2kl\7Y\2\2lm\7t\2"+
		"\2mn\7k\2\2no\7v\2\2op\7g\2\2pq\7n\2\2qr\7p\2\2r\6\3\2\2\2st\7Y\2\2tu"+
		"\7t\2\2uv\7k\2\2vw\7v\2\2wx\7g\2\2x\b\3\2\2\2yz\7U\2\2z{\7e\2\2{|\7c\2"+
		"\2|}\7p\2\2}\n\3\2\2\2~\177\7f\2\2\177\u0080\7g\2\2\u0080\u0081\7h\2\2"+
		"\u0081\f\3\2\2\2\u0082\u0083\7k\2\2\u0083\u0084\7h\2\2\u0084\16\3\2\2"+
		"\2\u0085\u0086\7g\2\2\u0086\u0087\7n\2\2\u0087\u0088\7u\2\2\u0088\u0089"+
		"\7g\2\2\u0089\20\3\2\2\2\u008a\u008b\7t\2\2\u008b\u008c\7g\2\2\u008c\u008d"+
		"\7v\2\2\u008d\u008e\7w\2\2\u008e\u008f\7t\2\2\u008f\u0090\7p\2\2\u0090"+
		"\22\3\2\2\2\u0091\u0092\7h\2\2\u0092\u0093\7q\2\2\u0093\u0094\7t\2\2\u0094"+
		"\24\3\2\2\2\u0095\u0096\7y\2\2\u0096\u0097\7j\2\2\u0097\u0098\7k\2\2\u0098"+
		"\u0099\7n\2\2\u0099\u009a\7g\2\2\u009a\26\3\2\2\2\u009b\u009c\7v\2\2\u009c"+
		"\u009d\7q\2\2\u009d\30\3\2\2\2\u009e\u009f\7f\2\2\u009f\u00a0\7q\2\2\u00a0"+
		"\32\3\2\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7f\2\2\u00a4"+
		"\34\3\2\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7w\2\2\u00a7\u00a8\7n\2\2\u00a8"+
		"\u00a9\7n\2\2\u00a9\36\3\2\2\2\u00aa\u00ab\7~\2\2\u00ab\u00ac\7~\2\2\u00ac"+
		" \3\2\2\2\u00ad\u00ae\7(\2\2\u00ae\u00af\7(\2\2\u00af\"\3\2\2\2\u00b0"+
		"\u00b1\7?\2\2\u00b1\u00b2\7?\2\2\u00b2$\3\2\2\2\u00b3\u00b4\7#\2\2\u00b4"+
		"\u00b5\7?\2\2\u00b5&\3\2\2\2\u00b6\u00b7\7@\2\2\u00b7\u00b8\7?\2\2\u00b8"+
		"(\3\2\2\2\u00b9\u00ba\7>\2\2\u00ba\u00bb\7?\2\2\u00bb*\3\2\2\2\u00bc\u00bd"+
		"\7`\2\2\u00bd,\3\2\2\2\u00be\u00bf\7#\2\2\u00bf.\3\2\2\2\u00c0\u00c1\7"+
		"@\2\2\u00c1\60\3\2\2\2\u00c2\u00c3\7>\2\2\u00c3\62\3\2\2\2\u00c4\u00c5"+
		"\7-\2\2\u00c5\64\3\2\2\2\u00c6\u00c7\7/\2\2\u00c7\66\3\2\2\2\u00c8\u00c9"+
		"\7,\2\2\u00c98\3\2\2\2\u00ca\u00cb\7\61\2\2\u00cb:\3\2\2\2\u00cc\u00cd"+
		"\7\'\2\2\u00cd<\3\2\2\2\u00ce\u00cf\7}\2\2\u00cf>\3\2\2\2\u00d0\u00d1"+
		"\7\177\2\2\u00d1@\3\2\2\2\u00d2\u00d3\7]\2\2\u00d3B\3\2\2\2\u00d4\u00d5"+
		"\7_\2\2\u00d5D\3\2\2\2\u00d6\u00d7\7*\2\2\u00d7F\3\2\2\2\u00d8\u00d9\7"+
		"+\2\2\u00d9H\3\2\2\2\u00da\u00db\7=\2\2\u00dbJ\3\2\2\2\u00dc\u00dd\7?"+
		"\2\2\u00ddL\3\2\2\2\u00de\u00df\7.\2\2\u00dfN\3\2\2\2\u00e0\u00e1\7<\2"+
		"\2\u00e1P\3\2\2\2\u00e2\u00e3\7d\2\2\u00e3\u00e4\7q\2\2\u00e4\u00e5\7"+
		"q\2\2\u00e5\u00e6\7n\2\2\u00e6\u00e7\7g\2\2\u00e7\u00e8\7c\2\2\u00e8\u0107"+
		"\7p\2\2\u00e9\u00ea\7u\2\2\u00ea\u00eb\7v\2\2\u00eb\u00ec\7t\2\2\u00ec"+
		"\u00ed\7k\2\2\u00ed\u00ee\7p\2\2\u00ee\u0107\7i\2\2\u00ef\u00f0\7k\2\2"+
		"\u00f0\u00f1\7p\2\2\u00f1\u0107\7v\2\2\u00f2\u00f3\7h\2\2\u00f3\u00f4"+
		"\7n\2\2\u00f4\u00f5\7q\2\2\u00f5\u00f6\7c\2\2\u00f6\u0107\7v\2\2\u00f7"+
		"\u00f8\7n\2\2\u00f8\u00f9\7q\2\2\u00f9\u00fa\7p\2\2\u00fa\u0107\7i\2\2"+
		"\u00fb\u00fc\7u\2\2\u00fc\u00fd\7j\2\2\u00fd\u00fe\7q\2\2\u00fe\u00ff"+
		"\7t\2\2\u00ff\u0107\7v\2\2\u0100\u0101\7f\2\2\u0101\u0102\7q\2\2\u0102"+
		"\u0103\7w\2\2\u0103\u0104\7d\2\2\u0104\u0105\7n\2\2\u0105\u0107\7g\2\2"+
		"\u0106\u00e2\3\2\2\2\u0106\u00e9\3\2\2\2\u0106\u00ef\3\2\2\2\u0106\u00f2"+
		"\3\2\2\2\u0106\u00f7\3\2\2\2\u0106\u00fb\3\2\2\2\u0106\u0100\3\2\2\2\u0107"+
		"R\3\2\2\2\u0108\u0109\7v\2\2\u0109\u010a\7t\2\2\u010a\u010b\7w\2\2\u010b"+
		"\u0112\7g\2\2\u010c\u010d\7h\2\2\u010d\u010e\7c\2\2\u010e\u010f\7n\2\2"+
		"\u010f\u0110\7u\2\2\u0110\u0112\7g\2\2\u0111\u0108\3\2\2\2\u0111\u010c"+
		"\3\2\2\2\u0112T\3\2\2\2\u0113\u011b\5_\60\2\u0114\u0118\7\60\2\2\u0115"+
		"\u0117\5a\61\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011b"+
		"\u0114\3\2\2\2\u011b\u011c\3\2\2\2\u011cV\3\2\2\2\u011d\u0121\t\2\2\2"+
		"\u011e\u0120\t\3\2\2\u011f\u011e\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f"+
		"\3\2\2\2\u0121\u0122\3\2\2\2\u0122X\3\2\2\2\u0123\u0121\3\2\2\2\u0124"+
		"\u012c\t\4\2\2\u0125\u012b\n\5\2\2\u0126\u0127\7^\2\2\u0127\u012b\7^\2"+
		"\2\u0128\u0129\7^\2\2\u0129\u012b\7$\2\2\u012a\u0125\3\2\2\2\u012a\u0126"+
		"\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c"+
		"\u012d\3\2\2\2\u012d\u012f\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u013d\t\4"+
		"\2\2\u0130\u0138\t\6\2\2\u0131\u0137\n\7\2\2\u0132\u0133\7^\2\2\u0133"+
		"\u0137\7^\2\2\u0134\u0135\7^\2\2\u0135\u0137\7)\2\2\u0136\u0131\3\2\2"+
		"\2\u0136\u0132\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136"+
		"\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b"+
		"\u013d\t\6\2\2\u013c\u0124\3\2\2\2\u013c\u0130\3\2\2\2\u013dZ\3\2\2\2"+
		"\u013e\u013f\7\61\2\2\u013f\u0140\7\61\2\2\u0140\u0144\3\2\2\2\u0141\u0143"+
		"\n\b\2\2\u0142\u0141\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144"+
		"\u0145\3\2\2\2\u0145\u0153\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0148\7\61"+
		"\2\2\u0148\u0149\7,\2\2\u0149\u014d\3\2\2\2\u014a\u014c\13\2\2\2\u014b"+
		"\u014a\3\2\2\2\u014c\u014f\3\2\2\2\u014d\u014e\3\2\2\2\u014d\u014b\3\2"+
		"\2\2\u014e\u0150\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0151\7,\2\2\u0151"+
		"\u0153\7\61\2\2\u0152\u013e\3\2\2\2\u0152\u0147\3\2\2\2\u0153\u0154\3"+
		"\2\2\2\u0154\u0155\b.\2\2\u0155\\\3\2\2\2\u0156\u0157\t\t\2\2\u0157\u0158"+
		"\3\2\2\2\u0158\u0159\b/\2\2\u0159^\3\2\2\2\u015a\u015e\t\n\2\2\u015b\u015d"+
		"\5a\61\2\u015c\u015b\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e"+
		"\u015f\3\2\2\2\u015f\u0163\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0163\7\62"+
		"\2\2\u0162\u015a\3\2\2\2\u0162\u0161\3\2\2\2\u0163`\3\2\2\2\u0164\u0165"+
		"\t\13\2\2\u0165b\3\2\2\2\u0166\u0167\13\2\2\2\u0167d\3\2\2\2\u0168\u016b"+
		"\5_\60\2\u0169\u016b\5W,\2\u016a\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016b"+
		"f\3\2\2\2\u016c\u016d\5A!\2\u016d\u0172\5e\63\2\u016e\u016f\7.\2\2\u016f"+
		"\u0171\5e\63\2\u0170\u016e\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2"+
		"\2\2\u0172\u0173\3\2\2\2\u0173\u0175\3\2\2\2\u0174\u0172\3\2\2\2\u0175"+
		"\u0176\5C\"\2\u0176h\3\2\2\2\24\2\u0106\u0111\u0118\u011b\u0121\u012a"+
		"\u012c\u0136\u0138\u013c\u0144\u014d\u0152\u015e\u0162\u016a\u0172\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}