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
	
	public void validaTipos(String tipo1, 
			String tipo2) throws SemanticException {
		if(!tipo1.equals(tipo2)) {
			//System.err.println("No son iguales los tipos de datos");
			throw new SemanticException(
					SemanticException.TIPOS_DATOS_NO_COMPATIBLES,
					tipo1, tipo2);
		}
	}
	
	public void operacionInvalidaConCadenas(
			String tipo) throws SemanticException {
		if(tipo.equals("cadena")) {
			throw new SemanticException(
					"Las cadenas solo se pueden concatenar"
					);
		}
	}
	
	public void tiposDeDatosIncompatibles(String tipo1, String tipo2)
	throws SemanticException{
		if(!tipo1.equals("cadena")) {
			if(!tipo1.equals(tipo2)) {
				throw new SemanticException("El tipo de datos: "+tipo1
						+"no es compatible con el tipo de datos: "+tipo2);
			}
		}
	}
	
	public String getTipoDato(Variable v) {
		String tipo = "";
		int index = variables.indexOf(v);
		if(index > -1) {
			tipo = variables.get(index).getTipoDato();
		}
		return tipo;
	}
}
