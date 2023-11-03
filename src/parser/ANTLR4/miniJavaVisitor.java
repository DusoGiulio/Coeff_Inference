// Generated from miniJava.g4 by ANTLR 4.4

    package parser.ANTLR4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link miniJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface miniJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#varDeclp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclp(@NotNull miniJavaParser.VarDeclpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainClass(@NotNull miniJavaParser.MainClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(@NotNull miniJavaParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(@NotNull miniJavaParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull miniJavaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(@NotNull miniJavaParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull miniJavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#coeffect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoeffect(@NotNull miniJavaParser.CoeffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#coefClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoefClass(@NotNull miniJavaParser.CoefClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#typeCoeff}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeCoeff(@NotNull miniJavaParser.TypeCoeffContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull miniJavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(@NotNull miniJavaParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link miniJavaParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(@NotNull miniJavaParser.VarDeclContext ctx);
}