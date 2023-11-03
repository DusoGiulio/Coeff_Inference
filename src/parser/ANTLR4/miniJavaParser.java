// Generated from miniJava.g4 by ANTLR 4.4

    package parser.ANTLR4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class miniJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOLEAN=1, INSTANCEOF=2, CLASS=3, ELSE=4, EXTENDS=5, IF=6, INT=7, NEW=8, 
		PUBLIC=9, RETURN=10, STATIC=11, THIS=12, VOID=13, WHILE=14, MAIN=15, ABSTRACT=16, 
		STRING=17, SOP=18, LENGTH=19, COEFCLASS=20, COEFSUBCLASS=21, COEFFECT=22, 
		CF=23, EXP=24, DECIMAL_LITERAL=25, BOOL_LITERAL=26, LPAREN=27, RPAREN=28, 
		LBRACE=29, RBRACE=30, LBRACK=31, RBRACK=32, SEMI=33, COMMA=34, DOT=35, 
		ASSIGN=36, GT=37, LT=38, AND=39, OR=40, BANG=41, ADD=42, SUB=43, MUL=44, 
		DIV=45, DQ=46, WS=47, COMMENT=48, LINE_COMMENT=49, IDENTIFIER=50;
	public static final String[] tokenNames = {
		"<INVALID>", "'boolean'", "'instanceof'", "'class'", "'else'", "'extends'", 
		"'if'", "'int'", "'new'", "'public'", "'return'", "'static'", "'this'", 
		"'void'", "'while'", "'main'", "'abstract'", "'String'", "'System.out.println'", 
		"'lenght'", "'@CoeffectClass'", "'@CoeffectAuxClass'", "'@Coeffect'", 
		"'coeffClass'", "'exp'", "DECIMAL_LITERAL", "BOOL_LITERAL", "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "';'", "','", "'.'", "'='", "'>'", "'<'", 
		"'&&'", "'||'", "'!'", "'+'", "'-'", "'*'", "'/'", "'\"'", "WS", "COMMENT", 
		"LINE_COMMENT", "IDENTIFIER"
	};
	public static final int
		RULE_program = 0, RULE_mainClass = 1, RULE_classDecl = 2, RULE_fieldDecl = 3, 
		RULE_coefClass = 4, RULE_varDecl = 5, RULE_varDeclp = 6, RULE_typeCoeff = 7, 
		RULE_coeffect = 8, RULE_methodDecl = 9, RULE_type = 10, RULE_statement = 11, 
		RULE_exp = 12;
	public static final String[] ruleNames = {
		"program", "mainClass", "classDecl", "fieldDecl", "coefClass", "varDecl", 
		"varDeclp", "typeCoeff", "coeffect", "methodDecl", "type", "statement", 
		"exp"
	};

	@Override
	public String getGrammarFileName() { return "miniJava.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public miniJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
		public MainClassContext mainClass() {
			return getRuleContext(MainClassContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); mainClass();
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << ABSTRACT) | (1L << COEFCLASS) | (1L << COEFSUBCLASS))) != 0)) {
				{
				{
				setState(27); classDecl();
				}
				}
				setState(32);
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

	public static class MainClassContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SOP() { return getToken(miniJavaParser.SOP, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(miniJavaParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(miniJavaParser.LBRACE, i);
		}
		public TerminalNode STRING() { return getToken(miniJavaParser.STRING, 0); }
		public List<TerminalNode> RPAREN() { return getTokens(miniJavaParser.RPAREN); }
		public TerminalNode RBRACK() { return getToken(miniJavaParser.RBRACK, 0); }
		public TerminalNode LBRACK() { return getToken(miniJavaParser.LBRACK, 0); }
		public TerminalNode MAIN() { return getToken(miniJavaParser.MAIN, 0); }
		public TerminalNode RBRACE(int i) {
			return getToken(miniJavaParser.RBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(miniJavaParser.RBRACE); }
		public TerminalNode STATIC() { return getToken(miniJavaParser.STATIC, 0); }
		public TerminalNode RPAREN(int i) {
			return getToken(miniJavaParser.RPAREN, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(miniJavaParser.LPAREN); }
		public TerminalNode SEMI() { return getToken(miniJavaParser.SEMI, 0); }
		public TerminalNode VOID() { return getToken(miniJavaParser.VOID, 0); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(miniJavaParser.IDENTIFIER, i);
		}
		public TerminalNode PUBLIC() { return getToken(miniJavaParser.PUBLIC, 0); }
		public TerminalNode CLASS() { return getToken(miniJavaParser.CLASS, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(miniJavaParser.IDENTIFIER); }
		public TerminalNode LPAREN(int i) {
			return getToken(miniJavaParser.LPAREN, i);
		}
		public MainClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainClass; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitMainClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainClassContext mainClass() throws RecognitionException {
		MainClassContext _localctx = new MainClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); match(CLASS);
			setState(34); match(IDENTIFIER);
			setState(35); match(LBRACE);
			setState(36); match(PUBLIC);
			setState(37); match(STATIC);
			setState(38); match(VOID);
			setState(39); match(MAIN);
			setState(40); match(LPAREN);
			setState(41); match(STRING);
			setState(42); match(LBRACK);
			setState(43); match(RBRACK);
			setState(44); match(IDENTIFIER);
			setState(45); match(RPAREN);
			setState(46); match(LBRACE);
			setState(47); match(SOP);
			setState(48); match(LPAREN);
			setState(49); exp(0);
			setState(50); match(RPAREN);
			setState(51); match(SEMI);
			setState(52); match(RBRACE);
			setState(53); match(RBRACE);
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

	public static class ClassDeclContext extends ParserRuleContext {
		public CoefClassContext coefClass() {
			return getRuleContext(CoefClassContext.class,0);
		}
		public TerminalNode ABSTRACT() { return getToken(miniJavaParser.ABSTRACT, 0); }
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public TerminalNode RBRACE() { return getToken(miniJavaParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(miniJavaParser.LBRACE, 0); }
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public TerminalNode IDENTIFIER(int i) {
			return getToken(miniJavaParser.IDENTIFIER, i);
		}
		public TerminalNode CLASS() { return getToken(miniJavaParser.CLASS, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(miniJavaParser.IDENTIFIER); }
		public TerminalNode EXTENDS() { return getToken(miniJavaParser.EXTENDS, 0); }
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if (_la==COEFCLASS || _la==COEFSUBCLASS) {
				{
				setState(55); coefClass();
				}
			}

			setState(59);
			_la = _input.LA(1);
			if (_la==ABSTRACT) {
				{
				setState(58); match(ABSTRACT);
				}
			}

			setState(61); match(CLASS);
			setState(62); match(IDENTIFIER);
			setState(65);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(63); match(EXTENDS);
				setState(64); match(IDENTIFIER);
				}
			}

			setState(67); match(LBRACE);
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(68); fieldDecl();
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << STATIC) | (1L << ABSTRACT) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(74); methodDecl();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80); match(RBRACE);
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

	public static class FieldDeclContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(miniJavaParser.SEMI, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(miniJavaParser.IDENTIFIER, 0); }
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitFieldDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fieldDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82); type();
			setState(83); match(IDENTIFIER);
			setState(84); match(SEMI);
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

	public static class CoefClassContext extends ParserRuleContext {
		public TerminalNode DQ(int i) {
			return getToken(miniJavaParser.DQ, i);
		}
		public List<TerminalNode> DQ() { return getTokens(miniJavaParser.DQ); }
		public TerminalNode COEFCLASS() { return getToken(miniJavaParser.COEFCLASS, 0); }
		public TerminalNode LPAREN() { return getToken(miniJavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(miniJavaParser.RPAREN, 0); }
		public TerminalNode COEFSUBCLASS() { return getToken(miniJavaParser.COEFSUBCLASS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(miniJavaParser.IDENTIFIER, 0); }
		public CoefClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coefClass; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitCoefClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoefClassContext coefClass() throws RecognitionException {
		CoefClassContext _localctx = new CoefClassContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_coefClass);
		try {
			setState(93);
			switch (_input.LA(1)) {
			case COEFCLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(86); match(COEFCLASS);
				}
				break;
			case COEFSUBCLASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(87); match(COEFSUBCLASS);
				setState(88); match(LPAREN);
				setState(89); match(DQ);
				setState(90); match(IDENTIFIER);
				setState(91); match(DQ);
				setState(92); match(RPAREN);
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

	public static class VarDeclContext extends ParserRuleContext {
		public TypeCoeffContext typeCoeff() {
			return getRuleContext(TypeCoeffContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(miniJavaParser.SEMI, 0); }
		public TerminalNode IDENTIFIER() { return getToken(miniJavaParser.IDENTIFIER, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); typeCoeff();
			setState(96); match(IDENTIFIER);
			setState(97); match(SEMI);
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

	public static class VarDeclpContext extends ParserRuleContext {
		public TypeCoeffContext typeCoeff() {
			return getRuleContext(TypeCoeffContext.class,0);
		}
		public TerminalNode THIS() { return getToken(miniJavaParser.THIS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(miniJavaParser.IDENTIFIER, 0); }
		public VarDeclpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitVarDeclp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclpContext varDeclp() throws RecognitionException {
		VarDeclpContext _localctx = new VarDeclpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varDeclp);
		try {
			setState(105);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99); typeCoeff();
				setState(100); match(THIS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102); typeCoeff();
				setState(103); match(IDENTIFIER);
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

	public static class TypeCoeffContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CoeffectContext coeffect() {
			return getRuleContext(CoeffectContext.class,0);
		}
		public TypeCoeffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeCoeff; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitTypeCoeff(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeCoeffContext typeCoeff() throws RecognitionException {
		TypeCoeffContext _localctx = new TypeCoeffContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_typeCoeff);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if (_la==COEFFECT) {
				{
				setState(107); coeffect();
				}
			}

			setState(110); type();
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

	public static class CoeffectContext extends ParserRuleContext {
		public TerminalNode DQ(int i) {
			return getToken(miniJavaParser.DQ, i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(miniJavaParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(miniJavaParser.ASSIGN, i);
		}
		public List<TerminalNode> DQ() { return getTokens(miniJavaParser.DQ); }
		public TerminalNode LPAREN() { return getToken(miniJavaParser.LPAREN, 0); }
		public TerminalNode COMMA() { return getToken(miniJavaParser.COMMA, 0); }
		public TerminalNode EXP() { return getToken(miniJavaParser.EXP, 0); }
		public TerminalNode RPAREN() { return getToken(miniJavaParser.RPAREN, 0); }
		public TerminalNode CF() { return getToken(miniJavaParser.CF, 0); }
		public TerminalNode IDENTIFIER() { return getToken(miniJavaParser.IDENTIFIER, 0); }
		public TerminalNode COEFFECT() { return getToken(miniJavaParser.COEFFECT, 0); }
		public CoeffectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coeffect; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitCoeffect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoeffectContext coeffect() throws RecognitionException {
		CoeffectContext _localctx = new CoeffectContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_coeffect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); match(COEFFECT);
			setState(113); match(LPAREN);
			setState(114); match(CF);
			setState(115); match(ASSIGN);
			setState(116); match(DQ);
			setState(117); match(IDENTIFIER);
			setState(118); match(DQ);
			setState(119); match(COMMA);
			setState(120); match(EXP);
			setState(121); match(ASSIGN);
			setState(122); match(DQ);
			setState(123); exp(0);
			setState(124); match(DQ);
			setState(125); match(RPAREN);
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

	public static class MethodDeclContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VarDeclpContext varDeclp(int i) {
			return getRuleContext(VarDeclpContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(miniJavaParser.LBRACE, 0); }
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(miniJavaParser.RPAREN, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode THIS() { return getToken(miniJavaParser.THIS, 0); }
		public List<VarDeclpContext> varDeclp() {
			return getRuleContexts(VarDeclpContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(miniJavaParser.COMMA, i);
		}
		public TerminalNode ABSTRACT() { return getToken(miniJavaParser.ABSTRACT, 0); }
		public TerminalNode RETURN() { return getToken(miniJavaParser.RETURN, 0); }
		public TerminalNode RBRACE() { return getToken(miniJavaParser.RBRACE, 0); }
		public TypeCoeffContext typeCoeff() {
			return getRuleContext(TypeCoeffContext.class,0);
		}
		public TerminalNode STATIC() { return getToken(miniJavaParser.STATIC, 0); }
		public TerminalNode LPAREN() { return getToken(miniJavaParser.LPAREN, 0); }
		public TerminalNode SEMI() { return getToken(miniJavaParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(miniJavaParser.COMMA); }
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public TerminalNode IDENTIFIER(int i) {
			return getToken(miniJavaParser.IDENTIFIER, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(miniJavaParser.IDENTIFIER); }
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_methodDecl);
		int _la;
		try {
			int _alt;
			setState(181);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case INT:
			case STATIC:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				_la = _input.LA(1);
				if (_la==STATIC) {
					{
					setState(127); match(STATIC);
					}
				}

				setState(130); type();
				setState(131); match(IDENTIFIER);
				setState(132); match(LPAREN);
				setState(142);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << COEFFECT) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(133); typeCoeff();
					setState(134);
					_la = _input.LA(1);
					if ( !(_la==THIS || _la==IDENTIFIER) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(135); match(COMMA);
						setState(136); varDeclp();
						}
						}
						setState(141);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(144); match(RPAREN);
				setState(145); match(LBRACE);
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(146); varDecl();
						}
						} 
					}
					setState(151);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SOP) | (1L << LBRACE) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(152); statement();
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(158); match(RETURN);
				setState(159); exp(0);
				setState(160); match(SEMI);
				setState(161); match(RBRACE);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 2);
				{
				setState(163); match(ABSTRACT);
				setState(164); type();
				setState(165); match(IDENTIFIER);
				setState(166); match(LPAREN);
				setState(176);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << COEFFECT) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(167); typeCoeff();
					setState(168);
					_la = _input.LA(1);
					if ( !(_la==THIS || _la==IDENTIFIER) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(169); match(COMMA);
						setState(170); varDeclp();
						}
						}
						setState(175);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(178); match(RPAREN);
				setState(179); match(SEMI);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode RBRACK() { return getToken(miniJavaParser.RBRACK, 0); }
		public TerminalNode BOOLEAN() { return getToken(miniJavaParser.BOOLEAN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(miniJavaParser.IDENTIFIER, 0); }
		public TerminalNode INT() { return getToken(miniJavaParser.INT, 0); }
		public TerminalNode LBRACK() { return getToken(miniJavaParser.LBRACK, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		try {
			setState(195);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183); match(IDENTIFIER);
				setState(184); match(LBRACK);
				setState(185); match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186); match(BOOLEAN);
				setState(187); match(LBRACK);
				setState(188); match(RBRACK);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(189); match(INT);
				setState(190); match(LBRACK);
				setState(191); match(RBRACK);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(192); match(BOOLEAN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(193); match(INT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(194); match(IDENTIFIER);
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

	public static class StatementContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode ELSE() { return getToken(miniJavaParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(miniJavaParser.IF, 0); }
		public TerminalNode SOP() { return getToken(miniJavaParser.SOP, 0); }
		public TerminalNode LBRACE() { return getToken(miniJavaParser.LBRACE, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(miniJavaParser.RPAREN, 0); }
		public TerminalNode RBRACK() { return getToken(miniJavaParser.RBRACK, 0); }
		public TerminalNode WHILE() { return getToken(miniJavaParser.WHILE, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode LBRACK() { return getToken(miniJavaParser.LBRACK, 0); }
		public TerminalNode ASSIGN() { return getToken(miniJavaParser.ASSIGN, 0); }
		public TerminalNode RBRACE() { return getToken(miniJavaParser.RBRACE, 0); }
		public TerminalNode LPAREN() { return getToken(miniJavaParser.LPAREN, 0); }
		public TerminalNode SEMI() { return getToken(miniJavaParser.SEMI, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode IDENTIFIER() { return getToken(miniJavaParser.IDENTIFIER, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		int _la;
		try {
			setState(238);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197); match(LBRACE);
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SOP) | (1L << LBRACE) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(198); statement();
					}
					}
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(204); match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205); match(IF);
				setState(206); match(LPAREN);
				setState(207); exp(0);
				setState(208); match(RPAREN);
				setState(209); statement();
				setState(210); match(ELSE);
				setState(211); statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(213); match(WHILE);
				setState(214); match(LPAREN);
				setState(215); exp(0);
				setState(216); match(RPAREN);
				setState(217); statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(219); match(SOP);
				setState(220); match(LPAREN);
				setState(221); exp(0);
				setState(222); match(RPAREN);
				setState(223); match(SEMI);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(225); match(IDENTIFIER);
				setState(226); match(ASSIGN);
				setState(227); exp(0);
				setState(228); match(SEMI);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(230); match(IDENTIFIER);
				setState(231); match(LBRACK);
				setState(232); exp(0);
				setState(233); match(RBRACK);
				setState(234); match(ASSIGN);
				setState(235); exp(0);
				setState(236); match(SEMI);
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

	public static class ExpContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode RBRACK() { return getToken(miniJavaParser.RBRACK, 0); }
		public TerminalNode INT() { return getToken(miniJavaParser.INT, 0); }
		public TerminalNode LBRACK() { return getToken(miniJavaParser.LBRACK, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(miniJavaParser.COMMA, i);
		}
		public TerminalNode MUL() { return getToken(miniJavaParser.MUL, 0); }
		public TerminalNode DOT() { return getToken(miniJavaParser.DOT, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(miniJavaParser.BOOL_LITERAL, 0); }
		public TerminalNode LPAREN() { return getToken(miniJavaParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(miniJavaParser.COMMA); }
		public TerminalNode ADD() { return getToken(miniJavaParser.ADD, 0); }
		public TerminalNode AND() { return getToken(miniJavaParser.AND, 0); }
		public TerminalNode DIV() { return getToken(miniJavaParser.DIV, 0); }
		public TerminalNode LENGTH() { return getToken(miniJavaParser.LENGTH, 0); }
		public TerminalNode DECIMAL_LITERAL() { return getToken(miniJavaParser.DECIMAL_LITERAL, 0); }
		public TerminalNode SUB() { return getToken(miniJavaParser.SUB, 0); }
		public TerminalNode LT() { return getToken(miniJavaParser.LT, 0); }
		public TerminalNode GT() { return getToken(miniJavaParser.GT, 0); }
		public TerminalNode RPAREN() { return getToken(miniJavaParser.RPAREN, 0); }
		public TerminalNode BOOLEAN() { return getToken(miniJavaParser.BOOLEAN, 0); }
		public TerminalNode THIS() { return getToken(miniJavaParser.THIS, 0); }
		public TerminalNode OR() { return getToken(miniJavaParser.OR, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode NEW() { return getToken(miniJavaParser.NEW, 0); }
		public TerminalNode INSTANCEOF() { return getToken(miniJavaParser.INSTANCEOF, 0); }
		public TerminalNode ASSIGN() { return getToken(miniJavaParser.ASSIGN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(miniJavaParser.IDENTIFIER, 0); }
		public TerminalNode BANG() { return getToken(miniJavaParser.BANG, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof miniJavaVisitor ) return ((miniJavaVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(241);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(242); exp(17);
				}
				break;
			case 2:
				{
				setState(243); match(LPAREN);
				setState(244); match(IDENTIFIER);
				setState(245); match(RPAREN);
				setState(246); exp(6);
				}
				break;
			case 3:
				{
				setState(247); match(NEW);
				setState(248); match(IDENTIFIER);
				setState(249); match(LBRACK);
				setState(250); exp(0);
				setState(251); match(RBRACK);
				}
				break;
			case 4:
				{
				setState(253); match(NEW);
				setState(254); match(BOOLEAN);
				setState(255); match(LBRACK);
				setState(256); exp(0);
				setState(257); match(RBRACK);
				}
				break;
			case 5:
				{
				setState(259); match(NEW);
				setState(260); match(INT);
				setState(261); match(LBRACK);
				setState(262); exp(0);
				setState(263); match(RBRACK);
				}
				break;
			case 6:
				{
				setState(265); match(NEW);
				setState(266); match(IDENTIFIER);
				setState(267); match(LPAREN);
				setState(268); match(RPAREN);
				}
				break;
			case 7:
				{
				setState(269); match(DECIMAL_LITERAL);
				}
				break;
			case 8:
				{
				setState(270); match(BOOL_LITERAL);
				}
				break;
			case 9:
				{
				setState(271); match(IDENTIFIER);
				}
				break;
			case 10:
				{
				setState(272); match(THIS);
				}
				break;
			case 11:
				{
				setState(273); match(LPAREN);
				setState(274); exp(0);
				setState(275); match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(319);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(317);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(279);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(280);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(281); exp(16);
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(282);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(283);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(284); exp(15);
						}
						break;
					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(285);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(286);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(287); exp(14);
						}
						break;
					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(288);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(289);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGN) | (1L << GT) | (1L << LT))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(290); exp(13);
						}
						break;
					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(291);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(292); match(LBRACK);
						setState(293); exp(0);
						setState(294); match(RBRACK);
						}
						break;
					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(296);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(297); match(INSTANCEOF);
						setState(298); match(IDENTIFIER);
						}
						break;
					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(299);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(300); match(DOT);
						setState(301); match(LENGTH);
						}
						break;
					case 8:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(302);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(303); match(DOT);
						setState(304); match(IDENTIFIER);
						setState(305); match(LPAREN);
						setState(314);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << THIS) | (1L << DECIMAL_LITERAL) | (1L << BOOL_LITERAL) | (1L << LPAREN) | (1L << BANG) | (1L << SUB) | (1L << IDENTIFIER))) != 0)) {
							{
							setState(306); exp(0);
							setState(311);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(307); match(COMMA);
								setState(308); exp(0);
								}
								}
								setState(313);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(316); match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(321);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12: return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 15);
		case 1: return precpred(_ctx, 14);
		case 2: return precpred(_ctx, 13);
		case 3: return precpred(_ctx, 12);
		case 4: return precpred(_ctx, 19);
		case 5: return precpred(_ctx, 18);
		case 6: return precpred(_ctx, 16);
		case 7: return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\64\u0145\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\7\2\37\n\2\f\2\16\2\"\13\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\5\4;\n\4\3\4\5\4>\n\4\3\4\3\4\3\4\3\4\5\4D\n\4\3\4"+
		"\3\4\7\4H\n\4\f\4\16\4K\13\4\3\4\7\4N\n\4\f\4\16\4Q\13\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6`\n\6\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\5\bl\n\b\3\t\5\to\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\5\13\u0083\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\7\13\u008c\n\13\f\13\16\13\u008f\13\13\5\13"+
		"\u0091\n\13\3\13\3\13\3\13\7\13\u0096\n\13\f\13\16\13\u0099\13\13\3\13"+
		"\7\13\u009c\n\13\f\13\16\13\u009f\13\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00ae\n\13\f\13\16\13\u00b1\13"+
		"\13\5\13\u00b3\n\13\3\13\3\13\3\13\5\13\u00b8\n\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c6\n\f\3\r\3\r\7\r\u00ca\n\r\f\r\16"+
		"\r\u00cd\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u00f1\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u0118\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\7\16\u0138\n\16\f\16\16\16\u013b\13\16\5\16"+
		"\u013d\n\16\3\16\7\16\u0140\n\16\f\16\16\16\u0143\13\16\3\16\2\3\32\17"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\2\b\4\2\16\16\64\64\4\2++--\3\2./\3"+
		"\2,-\3\2)*\3\2&(\u0167\2\34\3\2\2\2\4#\3\2\2\2\6:\3\2\2\2\bT\3\2\2\2\n"+
		"_\3\2\2\2\fa\3\2\2\2\16k\3\2\2\2\20n\3\2\2\2\22r\3\2\2\2\24\u00b7\3\2"+
		"\2\2\26\u00c5\3\2\2\2\30\u00f0\3\2\2\2\32\u0117\3\2\2\2\34 \5\4\3\2\35"+
		"\37\5\6\4\2\36\35\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\3\3\2\2"+
		"\2\" \3\2\2\2#$\7\5\2\2$%\7\64\2\2%&\7\37\2\2&\'\7\13\2\2\'(\7\r\2\2("+
		")\7\17\2\2)*\7\21\2\2*+\7\35\2\2+,\7\23\2\2,-\7!\2\2-.\7\"\2\2./\7\64"+
		"\2\2/\60\7\36\2\2\60\61\7\37\2\2\61\62\7\24\2\2\62\63\7\35\2\2\63\64\5"+
		"\32\16\2\64\65\7\36\2\2\65\66\7#\2\2\66\67\7 \2\2\678\7 \2\28\5\3\2\2"+
		"\29;\5\n\6\2:9\3\2\2\2:;\3\2\2\2;=\3\2\2\2<>\7\22\2\2=<\3\2\2\2=>\3\2"+
		"\2\2>?\3\2\2\2?@\7\5\2\2@C\7\64\2\2AB\7\7\2\2BD\7\64\2\2CA\3\2\2\2CD\3"+
		"\2\2\2DE\3\2\2\2EI\7\37\2\2FH\5\b\5\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ"+
		"\3\2\2\2JO\3\2\2\2KI\3\2\2\2LN\5\24\13\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2"+
		"OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2RS\7 \2\2S\7\3\2\2\2TU\5\26\f\2UV\7\64\2"+
		"\2VW\7#\2\2W\t\3\2\2\2X`\7\26\2\2YZ\7\27\2\2Z[\7\35\2\2[\\\7\60\2\2\\"+
		"]\7\64\2\2]^\7\60\2\2^`\7\36\2\2_X\3\2\2\2_Y\3\2\2\2`\13\3\2\2\2ab\5\20"+
		"\t\2bc\7\64\2\2cd\7#\2\2d\r\3\2\2\2ef\5\20\t\2fg\7\16\2\2gl\3\2\2\2hi"+
		"\5\20\t\2ij\7\64\2\2jl\3\2\2\2ke\3\2\2\2kh\3\2\2\2l\17\3\2\2\2mo\5\22"+
		"\n\2nm\3\2\2\2no\3\2\2\2op\3\2\2\2pq\5\26\f\2q\21\3\2\2\2rs\7\30\2\2s"+
		"t\7\35\2\2tu\7\31\2\2uv\7&\2\2vw\7\60\2\2wx\7\64\2\2xy\7\60\2\2yz\7$\2"+
		"\2z{\7\32\2\2{|\7&\2\2|}\7\60\2\2}~\5\32\16\2~\177\7\60\2\2\177\u0080"+
		"\7\36\2\2\u0080\23\3\2\2\2\u0081\u0083\7\r\2\2\u0082\u0081\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\5\26\f\2\u0085\u0086\7"+
		"\64\2\2\u0086\u0090\7\35\2\2\u0087\u0088\5\20\t\2\u0088\u008d\t\2\2\2"+
		"\u0089\u008a\7$\2\2\u008a\u008c\5\16\b\2\u008b\u0089\3\2\2\2\u008c\u008f"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u0090\u0087\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\u0093\7\36\2\2\u0093\u0097\7\37\2\2\u0094\u0096\5\f\7\2\u0095"+
		"\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u009d\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009c\5\30\r\2\u009b"+
		"\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2"+
		"\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7\f\2\2\u00a1"+
		"\u00a2\5\32\16\2\u00a2\u00a3\7#\2\2\u00a3\u00a4\7 \2\2\u00a4\u00b8\3\2"+
		"\2\2\u00a5\u00a6\7\22\2\2\u00a6\u00a7\5\26\f\2\u00a7\u00a8\7\64\2\2\u00a8"+
		"\u00b2\7\35\2\2\u00a9\u00aa\5\20\t\2\u00aa\u00af\t\2\2\2\u00ab\u00ac\7"+
		"$\2\2\u00ac\u00ae\5\16\b\2\u00ad\u00ab\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2"+
		"\2\2\u00b2\u00a9\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b5\7\36\2\2\u00b5\u00b6\7#\2\2\u00b6\u00b8\3\2\2\2\u00b7\u0082\3\2"+
		"\2\2\u00b7\u00a5\3\2\2\2\u00b8\25\3\2\2\2\u00b9\u00ba\7\64\2\2\u00ba\u00bb"+
		"\7!\2\2\u00bb\u00c6\7\"\2\2\u00bc\u00bd\7\3\2\2\u00bd\u00be\7!\2\2\u00be"+
		"\u00c6\7\"\2\2\u00bf\u00c0\7\t\2\2\u00c0\u00c1\7!\2\2\u00c1\u00c6\7\""+
		"\2\2\u00c2\u00c6\7\3\2\2\u00c3\u00c6\7\t\2\2\u00c4\u00c6\7\64\2\2\u00c5"+
		"\u00b9\3\2\2\2\u00c5\u00bc\3\2\2\2\u00c5\u00bf\3\2\2\2\u00c5\u00c2\3\2"+
		"\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\27\3\2\2\2\u00c7\u00cb"+
		"\7\37\2\2\u00c8\u00ca\5\30\r\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2"+
		"\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00ce\u00f1\7 \2\2\u00cf\u00d0\7\b\2\2\u00d0\u00d1\7\35\2\2\u00d1"+
		"\u00d2\5\32\16\2\u00d2\u00d3\7\36\2\2\u00d3\u00d4\5\30\r\2\u00d4\u00d5"+
		"\7\6\2\2\u00d5\u00d6\5\30\r\2\u00d6\u00f1\3\2\2\2\u00d7\u00d8\7\20\2\2"+
		"\u00d8\u00d9\7\35\2\2\u00d9\u00da\5\32\16\2\u00da\u00db\7\36\2\2\u00db"+
		"\u00dc\5\30\r\2\u00dc\u00f1\3\2\2\2\u00dd\u00de\7\24\2\2\u00de\u00df\7"+
		"\35\2\2\u00df\u00e0\5\32\16\2\u00e0\u00e1\7\36\2\2\u00e1\u00e2\7#\2\2"+
		"\u00e2\u00f1\3\2\2\2\u00e3\u00e4\7\64\2\2\u00e4\u00e5\7&\2\2\u00e5\u00e6"+
		"\5\32\16\2\u00e6\u00e7\7#\2\2\u00e7\u00f1\3\2\2\2\u00e8\u00e9\7\64\2\2"+
		"\u00e9\u00ea\7!\2\2\u00ea\u00eb\5\32\16\2\u00eb\u00ec\7\"\2\2\u00ec\u00ed"+
		"\7&\2\2\u00ed\u00ee\5\32\16\2\u00ee\u00ef\7#\2\2\u00ef\u00f1\3\2\2\2\u00f0"+
		"\u00c7\3\2\2\2\u00f0\u00cf\3\2\2\2\u00f0\u00d7\3\2\2\2\u00f0\u00dd\3\2"+
		"\2\2\u00f0\u00e3\3\2\2\2\u00f0\u00e8\3\2\2\2\u00f1\31\3\2\2\2\u00f2\u00f3"+
		"\b\16\1\2\u00f3\u00f4\t\3\2\2\u00f4\u0118\5\32\16\23\u00f5\u00f6\7\35"+
		"\2\2\u00f6\u00f7\7\64\2\2\u00f7\u00f8\7\36\2\2\u00f8\u0118\5\32\16\b\u00f9"+
		"\u00fa\7\n\2\2\u00fa\u00fb\7\64\2\2\u00fb\u00fc\7!\2\2\u00fc\u00fd\5\32"+
		"\16\2\u00fd\u00fe\7\"\2\2\u00fe\u0118\3\2\2\2\u00ff\u0100\7\n\2\2\u0100"+
		"\u0101\7\3\2\2\u0101\u0102\7!\2\2\u0102\u0103\5\32\16\2\u0103\u0104\7"+
		"\"\2\2\u0104\u0118\3\2\2\2\u0105\u0106\7\n\2\2\u0106\u0107\7\t\2\2\u0107"+
		"\u0108\7!\2\2\u0108\u0109\5\32\16\2\u0109\u010a\7\"\2\2\u010a\u0118\3"+
		"\2\2\2\u010b\u010c\7\n\2\2\u010c\u010d\7\64\2\2\u010d\u010e\7\35\2\2\u010e"+
		"\u0118\7\36\2\2\u010f\u0118\7\33\2\2\u0110\u0118\7\34\2\2\u0111\u0118"+
		"\7\64\2\2\u0112\u0118\7\16\2\2\u0113\u0114\7\35\2\2\u0114\u0115\5\32\16"+
		"\2\u0115\u0116\7\36\2\2\u0116\u0118\3\2\2\2\u0117\u00f2\3\2\2\2\u0117"+
		"\u00f5\3\2\2\2\u0117\u00f9\3\2\2\2\u0117\u00ff\3\2\2\2\u0117\u0105\3\2"+
		"\2\2\u0117\u010b\3\2\2\2\u0117\u010f\3\2\2\2\u0117\u0110\3\2\2\2\u0117"+
		"\u0111\3\2\2\2\u0117\u0112\3\2\2\2\u0117\u0113\3\2\2\2\u0118\u0141\3\2"+
		"\2\2\u0119\u011a\f\21\2\2\u011a\u011b\t\4\2\2\u011b\u0140\5\32\16\22\u011c"+
		"\u011d\f\20\2\2\u011d\u011e\t\5\2\2\u011e\u0140\5\32\16\21\u011f\u0120"+
		"\f\17\2\2\u0120\u0121\t\6\2\2\u0121\u0140\5\32\16\20\u0122\u0123\f\16"+
		"\2\2\u0123\u0124\t\7\2\2\u0124\u0140\5\32\16\17\u0125\u0126\f\25\2\2\u0126"+
		"\u0127\7!\2\2\u0127\u0128\5\32\16\2\u0128\u0129\7\"\2\2\u0129\u0140\3"+
		"\2\2\2\u012a\u012b\f\24\2\2\u012b\u012c\7\4\2\2\u012c\u0140\7\64\2\2\u012d"+
		"\u012e\f\22\2\2\u012e\u012f\7%\2\2\u012f\u0140\7\25\2\2\u0130\u0131\f"+
		"\r\2\2\u0131\u0132\7%\2\2\u0132\u0133\7\64\2\2\u0133\u013c\7\35\2\2\u0134"+
		"\u0139\5\32\16\2\u0135\u0136\7$\2\2\u0136\u0138\5\32\16\2\u0137\u0135"+
		"\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u0134\3\2\2\2\u013c\u013d\3\2"+
		"\2\2\u013d\u013e\3\2\2\2\u013e\u0140\7\36\2\2\u013f\u0119\3\2\2\2\u013f"+
		"\u011c\3\2\2\2\u013f\u011f\3\2\2\2\u013f\u0122\3\2\2\2\u013f\u0125\3\2"+
		"\2\2\u013f\u012a\3\2\2\2\u013f\u012d\3\2\2\2\u013f\u0130\3\2\2\2\u0140"+
		"\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\33\3\2\2"+
		"\2\u0143\u0141\3\2\2\2\33 :=CIO_kn\u0082\u008d\u0090\u0097\u009d\u00af"+
		"\u00b2\u00b7\u00c5\u00cb\u00f0\u0117\u0139\u013c\u013f\u0141";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}