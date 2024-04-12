package edu.itsco;

public class Variable {
	private String id;
	private String tipoDato;
	private boolean inicializada;
	
	public Variable() {
		
	}

	public Variable(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTipoDato() {
		return tipoDato;
	}
	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}
	public boolean isInicializada() {
		return inicializada;
	}
	public void setInicializada(boolean inicializada) {
		this.inicializada = inicializada;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Variable) {
			Variable v = (Variable) obj;
			return id.equals(v.getId());
		}
		return false;
	}
	
}
