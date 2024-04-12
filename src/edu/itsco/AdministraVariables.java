package edu.itsco;

import java.util.ArrayList;

public class AdministraVariables {

	private ArrayList<Variable> variables;
	
	public AdministraVariables() {
		variables = new ArrayList<>();
	}
	
	public void addVariable(Variable v) 
			throws SemanticException {
		if(!variables.contains(v)) {
			variables.add(v);
			//System.out.println("Agregaste: "+v.getId())
		}else {
			throw new SemanticException(v.getId(),
				SemanticException.VARIABLE_DUPLICADA);
		}
	}
	
	public void existeVariable(Variable v) 
	throws SemanticException{
		//if(variables.contains(v)==false) {
		if(!variables.contains(v)) {
			throw new SemanticException(v.getId(),
				SemanticException.VARIABLE_NO_DECLARADA);
		}
	}
	
	public void inicializaVariable(Variable v) {
		int indice = variables.indexOf(v);
		if(indice > -1) {
			variables.get(indice).setInicializada(true);
		}
	}
	
	public void validarInicializada(Variable v) throws
	SemanticException{
		int indice = variables.indexOf(v);
		if(indice > -1) {
			Variable variable = variables.get(indice);
			if(!variable.isInicializada()) {
				throw new SemanticException(v.getId(), 
						SemanticException.VARIABLE_NO_INICIALIZADA);
			}
		}
	}
}
