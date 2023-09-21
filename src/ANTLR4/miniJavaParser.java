// Generated from miniJava.g4 by ANTLR 4.4

    package ANTLR4;

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
		PUBLIC=9, RETURN=10, STATIC=11, THIS=12, VOID=13, WHILE=14, MAIN=15, STRING=16, 
		SOP=17, LENGTH=18, COEFCLASS=19, COEFSUBCLASS=20, COEFFECT=21, CF=22, 
		EXP=23, DECIMAL_LITERAL=24, BOOL_LITERAL=25, LPAREN=26, RPAREN=27, LBRACE=28, 
		RBRACE=29, LBRACK=30, RBRACK=31, SEMI=32, COMMA=33, DOT=34, ASSIGN=35, 
		GT=36, LT=37, AND=38, OR=39, BANG=40, ADD=41, SUB=42, MUL=43, DIV=44, 
		DQ=45, WS=46, COMMENT=47, LINE_COMMENT=48, IDENTIFIER=49;
	public static final String[] tokenNames = {
		"<INVALID>", "'boolean'", "'instanceof'", "'class'", "'else'", "'extends'", 
		"'if'", "'int'", "'new'", "'public'", "'return'", "'static'", "'this'", 
		"'void'", "'while'", "'main'", "'String'", "'System.out.println'", "'lenght'", 
		"'@CoeffectClass'", "'@CoeffectAuxClass'", "'@Coeffect'", "'coeffClass'", 
		"'exp'", "DECIMAL_LITERAL", "BOOL_LITERAL", "'('", "')'", "'{'", "'}'", 
		"'['", "']'", "';'", "','", "'.'", "'='", "'>'", "'<'", "'&&'", "'||'", 
		"'!'", "'+'", "'-'", "'*'", "'/'", "'\"'", "WS", "COMMENT", "LINE_COMMENT", 
		"IDENTIFIER"
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << COEFCLASS) | (1L << COEFSUBCLASS))) != 0)) {
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

			setState(58); match(CLASS);
			setState(59); match(IDENTIFIER);
			setState(62);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(60); match(EXTENDS);
				setState(61); match(IDENTIFIER);
				}
			}

			setState(64); match(LBRACE);
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(65); fieldDecl();
					}
					} 
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << STATIC) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(71); methodDecl();
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77); match(RBRACE);
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
			setState(79); type();
			setState(80); match(IDENTIFIER);
			setState(81); match(SEMI);
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
			setState(90);
			switch (_input.LA(1)) {
			case COEFCLASS:
				enterOuterAlt(_localctx, 1);
				{
				setState(83); match(COEFCLASS);
				}
				break;
			case COEFSUBCLASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(84); match(COEFSUBCLASS);
				setState(85); match(LPAREN);
				setState(86); match(DQ);
				setState(87); match(IDENTIFIER);
				setState(88); match(DQ);
				setState(89); match(RPAREN);
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
			setState(92); typeCoeff();
			setState(93); match(IDENTIFIER);
			setState(94); match(SEMI);
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
			setState(102);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96); typeCoeff();
				setState(97); match(THIS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99); typeCoeff();
				setState(100); match(IDENTIFIER);
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
			setState(105);
			_la = _input.LA(1);
			if (_la==COEFFECT) {
				{
				setState(104); coeffect();
				}
			}

			setState(107); type();
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
			setState(109); match(COEFFECT);
			setState(110); match(LPAREN);
			setState(111); match(CF);
			setState(112); match(ASSIGN);
			setState(113); match(DQ);
			setState(114); match(IDENTIFIER);
			setState(115); match(DQ);
			setState(116); match(COMMA);
			setState(117); match(EXP);
			setState(118); match(ASSIGN);
			setState(119); match(DQ);
			setState(120); exp(0);
			setState(121); match(DQ);
			setState(122); match(RPAREN);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(124); match(STATIC);
				}
			}

			setState(127); type();
			setState(128); match(IDENTIFIER);
			setState(129); match(LPAREN);
			setState(139);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << COEFFECT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(130); typeCoeff();
				setState(131);
				_la = _input.LA(1);
				if ( !(_la==THIS || _la==IDENTIFIER) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(132); match(COMMA);
					setState(133); varDeclp();
					}
					}
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(141); match(RPAREN);
			setState(142); match(LBRACE);
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(143); varDecl();
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SOP) | (1L << LBRACE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(149); statement();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155); match(RETURN);
			setState(156); exp(0);
			setState(157); match(SEMI);
			setState(158); match(RBRACE);
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
			setState(172);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160); match(IDENTIFIER);
				setState(161); match(LBRACK);
				setState(162); match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163); match(BOOLEAN);
				setState(164); match(LBRACK);
				setState(165); match(RBRACK);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(166); match(INT);
				setState(167); match(LBRACK);
				setState(168); match(RBRACK);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(169); match(BOOLEAN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(170); match(INT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(171); match(IDENTIFIER);
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
			setState(215);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174); match(LBRACE);
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << SOP) | (1L << LBRACE) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(175); statement();
					}
					}
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(181); match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(182); match(IF);
				setState(183); match(LPAREN);
				setState(184); exp(0);
				setState(185); match(RPAREN);
				setState(186); statement();
				setState(187); match(ELSE);
				setState(188); statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(190); match(WHILE);
				setState(191); match(LPAREN);
				setState(192); exp(0);
				setState(193); match(RPAREN);
				setState(194); statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(196); match(SOP);
				setState(197); match(LPAREN);
				setState(198); exp(0);
				setState(199); match(RPAREN);
				setState(200); match(SEMI);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(202); match(IDENTIFIER);
				setState(203); match(ASSIGN);
				setState(204); exp(0);
				setState(205); match(SEMI);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(207); match(IDENTIFIER);
				setState(208); match(LBRACK);
				setState(209); exp(0);
				setState(210); match(RBRACK);
				setState(211); match(ASSIGN);
				setState(212); exp(0);
				setState(213); match(SEMI);
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
			setState(254);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(218);
				_la = _input.LA(1);
				if ( !(_la==BANG || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(219); exp(17);
				}
				break;
			case 2:
				{
				setState(220); match(LPAREN);
				setState(221); match(IDENTIFIER);
				setState(222); match(RPAREN);
				setState(223); exp(6);
				}
				break;
			case 3:
				{
				setState(224); match(NEW);
				setState(225); match(IDENTIFIER);
				setState(226); match(LBRACK);
				setState(227); exp(0);
				setState(228); match(RBRACK);
				}
				break;
			case 4:
				{
				setState(230); match(NEW);
				setState(231); match(BOOLEAN);
				setState(232); match(LBRACK);
				setState(233); exp(0);
				setState(234); match(RBRACK);
				}
				break;
			case 5:
				{
				setState(236); match(NEW);
				setState(237); match(INT);
				setState(238); match(LBRACK);
				setState(239); exp(0);
				setState(240); match(RBRACK);
				}
				break;
			case 6:
				{
				setState(242); match(NEW);
				setState(243); match(IDENTIFIER);
				setState(244); match(LPAREN);
				setState(245); match(RPAREN);
				}
				break;
			case 7:
				{
				setState(246); match(DECIMAL_LITERAL);
				}
				break;
			case 8:
				{
				setState(247); match(BOOL_LITERAL);
				}
				break;
			case 9:
				{
				setState(248); match(IDENTIFIER);
				}
				break;
			case 10:
				{
				setState(249); match(THIS);
				}
				break;
			case 11:
				{
				setState(250); match(LPAREN);
				setState(251); exp(0);
				setState(252); match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(296);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(294);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(256);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(257);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(258); exp(16);
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(259);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(260);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(261); exp(15);
						}
						break;
					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(262);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(263);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(264); exp(14);
						}
						break;
					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(265);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(266);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGN) | (1L << GT) | (1L << LT))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(267); exp(13);
						}
						break;
					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(268);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(269); match(LBRACK);
						setState(270); exp(0);
						setState(271); match(RBRACK);
						}
						break;
					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(273);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(274); match(INSTANCEOF);
						setState(275); match(IDENTIFIER);
						}
						break;
					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(276);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(277); match(DOT);
						setState(278); match(LENGTH);
						}
						break;
					case 8:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(279);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(280); match(DOT);
						setState(281); match(IDENTIFIER);
						setState(282); match(LPAREN);
						setState(291);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << THIS) | (1L << DECIMAL_LITERAL) | (1L << BOOL_LITERAL) | (1L << LPAREN) | (1L << BANG) | (1L << SUB) | (1L << IDENTIFIER))) != 0)) {
							{
							setState(283); exp(0);
							setState(288);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(284); match(COMMA);
								setState(285); exp(0);
								}
								}
								setState(290);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(293); match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(298);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\63\u012e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\7\2\37\n\2\f\2\16\2\"\13\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\5\4;\n\4\3\4\3\4\3\4\3\4\5\4A\n\4\3\4\3\4\7\4E\n\4"+
		"\f\4\16\4H\13\4\3\4\7\4K\n\4\f\4\16\4N\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6]\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\5\bi\n\b\3\t\5\tl\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\5\13\u0080\n\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\7\13\u0089\n\13\f\13\16\13\u008c\13\13\5\13\u008e\n\13\3"+
		"\13\3\13\3\13\7\13\u0093\n\13\f\13\16\13\u0096\13\13\3\13\7\13\u0099\n"+
		"\13\f\13\16\13\u009c\13\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00af\n\f\3\r\3\r\7\r\u00b3\n\r\f\r"+
		"\16\r\u00b6\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\5\r\u00da\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u0101\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\7\16\u0121\n\16\f\16\16\16\u0124\13\16\5\16"+
		"\u0126\n\16\3\16\7\16\u0129\n\16\f\16\16\16\u012c\13\16\3\16\2\3\32\17"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\2\b\4\2\16\16\63\63\4\2**,,\3\2-.\3"+
		"\2+,\3\2()\3\2%\'\u014c\2\34\3\2\2\2\4#\3\2\2\2\6:\3\2\2\2\bQ\3\2\2\2"+
		"\n\\\3\2\2\2\f^\3\2\2\2\16h\3\2\2\2\20k\3\2\2\2\22o\3\2\2\2\24\177\3\2"+
		"\2\2\26\u00ae\3\2\2\2\30\u00d9\3\2\2\2\32\u0100\3\2\2\2\34 \5\4\3\2\35"+
		"\37\5\6\4\2\36\35\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\3\3\2\2"+
		"\2\" \3\2\2\2#$\7\5\2\2$%\7\63\2\2%&\7\36\2\2&\'\7\13\2\2\'(\7\r\2\2("+
		")\7\17\2\2)*\7\21\2\2*+\7\34\2\2+,\7\22\2\2,-\7 \2\2-.\7!\2\2./\7\63\2"+
		"\2/\60\7\35\2\2\60\61\7\36\2\2\61\62\7\23\2\2\62\63\7\34\2\2\63\64\5\32"+
		"\16\2\64\65\7\35\2\2\65\66\7\"\2\2\66\67\7\37\2\2\678\7\37\2\28\5\3\2"+
		"\2\29;\5\n\6\2:9\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\7\5\2\2=@\7\63\2\2>?\7"+
		"\7\2\2?A\7\63\2\2@>\3\2\2\2@A\3\2\2\2AB\3\2\2\2BF\7\36\2\2CE\5\b\5\2D"+
		"C\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GL\3\2\2\2HF\3\2\2\2IK\5\24\13"+
		"\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3\2\2\2OP\7\37"+
		"\2\2P\7\3\2\2\2QR\5\26\f\2RS\7\63\2\2ST\7\"\2\2T\t\3\2\2\2U]\7\25\2\2"+
		"VW\7\26\2\2WX\7\34\2\2XY\7/\2\2YZ\7\63\2\2Z[\7/\2\2[]\7\35\2\2\\U\3\2"+
		"\2\2\\V\3\2\2\2]\13\3\2\2\2^_\5\20\t\2_`\7\63\2\2`a\7\"\2\2a\r\3\2\2\2"+
		"bc\5\20\t\2cd\7\16\2\2di\3\2\2\2ef\5\20\t\2fg\7\63\2\2gi\3\2\2\2hb\3\2"+
		"\2\2he\3\2\2\2i\17\3\2\2\2jl\5\22\n\2kj\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn"+
		"\5\26\f\2n\21\3\2\2\2op\7\27\2\2pq\7\34\2\2qr\7\30\2\2rs\7%\2\2st\7/\2"+
		"\2tu\7\63\2\2uv\7/\2\2vw\7#\2\2wx\7\31\2\2xy\7%\2\2yz\7/\2\2z{\5\32\16"+
		"\2{|\7/\2\2|}\7\35\2\2}\23\3\2\2\2~\u0080\7\r\2\2\177~\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\5\26\f\2\u0082\u0083\7\63\2\2"+
		"\u0083\u008d\7\34\2\2\u0084\u0085\5\20\t\2\u0085\u008a\t\2\2\2\u0086\u0087"+
		"\7#\2\2\u0087\u0089\5\16\b\2\u0088\u0086\3\2\2\2\u0089\u008c\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2"+
		"\2\2\u008d\u0084\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u0090\7\35\2\2\u0090\u0094\7\36\2\2\u0091\u0093\5\f\7\2\u0092\u0091\3"+
		"\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u009a\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0099\5\30\r\2\u0098\u0097\3"+
		"\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009e\7\f\2\2\u009e\u009f\5\32"+
		"\16\2\u009f\u00a0\7\"\2\2\u00a0\u00a1\7\37\2\2\u00a1\25\3\2\2\2\u00a2"+
		"\u00a3\7\63\2\2\u00a3\u00a4\7 \2\2\u00a4\u00af\7!\2\2\u00a5\u00a6\7\3"+
		"\2\2\u00a6\u00a7\7 \2\2\u00a7\u00af\7!\2\2\u00a8\u00a9\7\t\2\2\u00a9\u00aa"+
		"\7 \2\2\u00aa\u00af\7!\2\2\u00ab\u00af\7\3\2\2\u00ac\u00af\7\t\2\2\u00ad"+
		"\u00af\7\63\2\2\u00ae\u00a2\3\2\2\2\u00ae\u00a5\3\2\2\2\u00ae\u00a8\3"+
		"\2\2\2\u00ae\u00ab\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af"+
		"\27\3\2\2\2\u00b0\u00b4\7\36\2\2\u00b1\u00b3\5\30\r\2\u00b2\u00b1\3\2"+
		"\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00da\7\37\2\2\u00b8\u00b9\7"+
		"\b\2\2\u00b9\u00ba\7\34\2\2\u00ba\u00bb\5\32\16\2\u00bb\u00bc\7\35\2\2"+
		"\u00bc\u00bd\5\30\r\2\u00bd\u00be\7\6\2\2\u00be\u00bf\5\30\r\2\u00bf\u00da"+
		"\3\2\2\2\u00c0\u00c1\7\20\2\2\u00c1\u00c2\7\34\2\2\u00c2\u00c3\5\32\16"+
		"\2\u00c3\u00c4\7\35\2\2\u00c4\u00c5\5\30\r\2\u00c5\u00da\3\2\2\2\u00c6"+
		"\u00c7\7\23\2\2\u00c7\u00c8\7\34\2\2\u00c8\u00c9\5\32\16\2\u00c9\u00ca"+
		"\7\35\2\2\u00ca\u00cb\7\"\2\2\u00cb\u00da\3\2\2\2\u00cc\u00cd\7\63\2\2"+
		"\u00cd\u00ce\7%\2\2\u00ce\u00cf\5\32\16\2\u00cf\u00d0\7\"\2\2\u00d0\u00da"+
		"\3\2\2\2\u00d1\u00d2\7\63\2\2\u00d2\u00d3\7 \2\2\u00d3\u00d4\5\32\16\2"+
		"\u00d4\u00d5\7!\2\2\u00d5\u00d6\7%\2\2\u00d6\u00d7\5\32\16\2\u00d7\u00d8"+
		"\7\"\2\2\u00d8\u00da\3\2\2\2\u00d9\u00b0\3\2\2\2\u00d9\u00b8\3\2\2\2\u00d9"+
		"\u00c0\3\2\2\2\u00d9\u00c6\3\2\2\2\u00d9\u00cc\3\2\2\2\u00d9\u00d1\3\2"+
		"\2\2\u00da\31\3\2\2\2\u00db\u00dc\b\16\1\2\u00dc\u00dd\t\3\2\2\u00dd\u0101"+
		"\5\32\16\23\u00de\u00df\7\34\2\2\u00df\u00e0\7\63\2\2\u00e0\u00e1\7\35"+
		"\2\2\u00e1\u0101\5\32\16\b\u00e2\u00e3\7\n\2\2\u00e3\u00e4\7\63\2\2\u00e4"+
		"\u00e5\7 \2\2\u00e5\u00e6\5\32\16\2\u00e6\u00e7\7!\2\2\u00e7\u0101\3\2"+
		"\2\2\u00e8\u00e9\7\n\2\2\u00e9\u00ea\7\3\2\2\u00ea\u00eb\7 \2\2\u00eb"+
		"\u00ec\5\32\16\2\u00ec\u00ed\7!\2\2\u00ed\u0101\3\2\2\2\u00ee\u00ef\7"+
		"\n\2\2\u00ef\u00f0\7\t\2\2\u00f0\u00f1\7 \2\2\u00f1\u00f2\5\32\16\2\u00f2"+
		"\u00f3\7!\2\2\u00f3\u0101\3\2\2\2\u00f4\u00f5\7\n\2\2\u00f5\u00f6\7\63"+
		"\2\2\u00f6\u00f7\7\34\2\2\u00f7\u0101\7\35\2\2\u00f8\u0101\7\32\2\2\u00f9"+
		"\u0101\7\33\2\2\u00fa\u0101\7\63\2\2\u00fb\u0101\7\16\2\2\u00fc\u00fd"+
		"\7\34\2\2\u00fd\u00fe\5\32\16\2\u00fe\u00ff\7\35\2\2\u00ff\u0101\3\2\2"+
		"\2\u0100\u00db\3\2\2\2\u0100\u00de\3\2\2\2\u0100\u00e2\3\2\2\2\u0100\u00e8"+
		"\3\2\2\2\u0100\u00ee\3\2\2\2\u0100\u00f4\3\2\2\2\u0100\u00f8\3\2\2\2\u0100"+
		"\u00f9\3\2\2\2\u0100\u00fa\3\2\2\2\u0100\u00fb\3\2\2\2\u0100\u00fc\3\2"+
		"\2\2\u0101\u012a\3\2\2\2\u0102\u0103\f\21\2\2\u0103\u0104\t\4\2\2\u0104"+
		"\u0129\5\32\16\22\u0105\u0106\f\20\2\2\u0106\u0107\t\5\2\2\u0107\u0129"+
		"\5\32\16\21\u0108\u0109\f\17\2\2\u0109\u010a\t\6\2\2\u010a\u0129\5\32"+
		"\16\20\u010b\u010c\f\16\2\2\u010c\u010d\t\7\2\2\u010d\u0129\5\32\16\17"+
		"\u010e\u010f\f\25\2\2\u010f\u0110\7 \2\2\u0110\u0111\5\32\16\2\u0111\u0112"+
		"\7!\2\2\u0112\u0129\3\2\2\2\u0113\u0114\f\24\2\2\u0114\u0115\7\4\2\2\u0115"+
		"\u0129\7\63\2\2\u0116\u0117\f\22\2\2\u0117\u0118\7$\2\2\u0118\u0129\7"+
		"\24\2\2\u0119\u011a\f\r\2\2\u011a\u011b\7$\2\2\u011b\u011c\7\63\2\2\u011c"+
		"\u0125\7\34\2\2\u011d\u0122\5\32\16\2\u011e\u011f\7#\2\2\u011f\u0121\5"+
		"\32\16\2\u0120\u011e\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122"+
		"\u0123\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u011d\3\2"+
		"\2\2\u0125\u0126\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0129\7\35\2\2\u0128"+
		"\u0102\3\2\2\2\u0128\u0105\3\2\2\2\u0128\u0108\3\2\2\2\u0128\u010b\3\2"+
		"\2\2\u0128\u010e\3\2\2\2\u0128\u0113\3\2\2\2\u0128\u0116\3\2\2\2\u0128"+
		"\u0119\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2"+
		"\2\2\u012b\33\3\2\2\2\u012c\u012a\3\2\2\2\27 :@FL\\hk\177\u008a\u008d"+
		"\u0094\u009a\u00ae\u00b4\u00d9\u0100\u0122\u0125\u0128\u012a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}