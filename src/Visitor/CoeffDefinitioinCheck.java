package Visitor;

import java.util.ArrayList;

import ASTnodes.Class.NodeAST;
import ASTnodes.Decl.ClassDecl;
import ASTnodes.Decl.MethDecl;
import ASTnodes.Decl.VarDecl;
import Coeffect.Coef;
import Exceptioin.TypeCheckingException;
import TypeDescriptor.BoolTypeDescriptor;
import TypeDescriptor.ClassTypeDescriptor;
import TypeDescriptor.CoeffectTypeDescriptor;
import TypeDescriptor.IdTypeDescriptor;
import TypeDescriptor.MethTypeDescriptor;
import TypeDescriptor.TypeDescriptor;

/**
 * Questa classe esegue il controllo delle definizioni dei coeffetti
 */
public class CoeffDefinitioinCheck {

	private ArrayList<NodeAST> ast;

	 /**
     * Crea un oggetto CoeffDefinitionCheck.
     *
     * @param ast L'AST (Abstract Syntax Tree) da analizzare.
     * @throws TypeCheckingException Viene lanciata se si verificano errori durante il controllo dei coeffetti
     */
	public CoeffDefinitioinCheck(ArrayList<NodeAST> ast) throws TypeCheckingException {
		this.ast=ast;
		//centerrà tutti i metodi che devono essere contenuti in una COEFFECT class
		this.visitProgram(this.ast);
	}

	 
	private void visitProgram(ArrayList<NodeAST> ast) throws TypeCheckingException{
		for(NodeAST klass :  ast) 
		{
			if(klass instanceof ClassDecl) 
			{
			ClassDecl c= (ClassDecl) klass;

			if(((ClassTypeDescriptor)c.getType()).isCoeff()== Coef.COEFF ) 
			{
				this.visitClassCoeff(c);
			}else if(((ClassTypeDescriptor)c.getType()).isCoeff()== Coef.AUXCOEF) 
			{
				this.visitClassSubCoeff(c);
			}
				
			}
		}

	}



	private TypeDescriptor visitClassSubCoeff(ClassDecl c) {
		return new BoolTypeDescriptor() ;
	}


	private void visitClassCoeff(ClassDecl c) throws TypeCheckingException {

			this.containsAllMethCoeff(c.getMets(), c);		
	}
	
	private boolean containsAllMethCoeff(ArrayList<MethDecl> mets, ClassDecl c) throws TypeCheckingException {

		ArrayList<Boolean> meths= new ArrayList<Boolean>();
		for(MethDecl met:mets) 
		{//Se il metodo della classe e il metodo che deve esiste hanno lo stesso nome
			String nId= met.getId().getName();
			if(nId.equals("sup") ||nId.equals("sum") ||nId.equals("mult")) 
			{
				if(((IdTypeDescriptor)met.getRetType()).getNomeTipo().equals(c.getIdClass().getName()))	
				{
					if(met.getFormals().size()==1) 
					{	CoeffectTypeDescriptor coeff= ((CoeffectTypeDescriptor) ((VarDecl)met.getFormals().get(0)).getType());
						if(((IdTypeDescriptor)coeff.getVarType()).getNomeTipo().equals(((ClassTypeDescriptor) c.getType()).getName()))
						{
							meths.add(true);
						}
						else 
						{
							throw new TypeCheckingException (met.getLine(),1);
						}
					}
				}
			}else if(nId.equals("leq"))
			{
				if(met.getRetType() instanceof BoolTypeDescriptor)	
				{
					if(met.getFormals().size()==1) 
					{	CoeffectTypeDescriptor coeff= ((CoeffectTypeDescriptor) ((VarDecl)met.getFormals().get(0)).getType());
						if(((IdTypeDescriptor)coeff.getVarType()).getNomeTipo().equals(((ClassTypeDescriptor) c.getType()).getName()))
						{
							meths.add(true);
						}
						else 
						{
							throw new TypeCheckingException (met.getLine(),1);
						}
					}
				}
					
			}else if(nId.equals("zero") || nId.equals("one")) 
			{
				if(((IdTypeDescriptor)met.getRetType()).getNomeTipo().equals(c.getIdClass().getName()))	
				{
					if(met.getFormals().size()==0) 
					{	if(!((MethTypeDescriptor) met.getType()).isStatic()) 
						{
						throw new TypeCheckingException (met.getLine(),1);
						}else 
						{
							meths.add(true);
						}
						
					}
					else 
					{
						throw new TypeCheckingException (met.getLine(),1);
					}
				}
					
			}else if(nId.equals("fromNat")) 
			{
				if(((IdTypeDescriptor)met.getRetType()).getNomeTipo().equals(c.getIdClass().getName()))	
				{
					if(met.getFormals().size()==1) 
					{	CoeffectTypeDescriptor coeff= ((CoeffectTypeDescriptor) ((VarDecl)met.getFormals().get(0)).getType());
						if(((IdTypeDescriptor)coeff.getVarType()).getNomeTipo().equals("Nat")) 
						{
							if(!((MethTypeDescriptor) met.getType()).isStatic()) 
							{
								throw new TypeCheckingException (met.getLine(),1);
							}else 
							{
								meths.add(true);
							}
						}
						else 
						{
							throw new TypeCheckingException (met.getLine(),1);
						}
					}
				}
			}
		}
		if(!meths.contains(false) && mets.size()==7 ) 
		{
			return true;
		}
		throw new TypeCheckingException (c.getLine(),1);
	}
}
