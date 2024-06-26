package edu.itsco;

public class SemanticException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final int VARIABLE_NO_DECLARADA = 10;
	public static final int VARIABLE_DUPLICADA = 20;
	public static final int 
		VARIABLE_NO_INICIALIZADA = 30;
	public static final int 
		TIPOS_DATOS_NO_COMPATIBLES = 40;
	
	public SemanticException(String msg) {
		super(msg);
	}
	
	public SemanticException(String id, int causa) {
		super(getMessage(id, causa));
	}
	
	public SemanticException(int causa, 
			String tipo1, String tipo2) {
		super(getMessage(causa,tipo1,tipo2));
	}
	
	public static String getMessage(int causa,
			String tipo1, String tipo2) {
		String msg="";
		if(causa==TIPOS_DATOS_NO_COMPATIBLES) {
			msg = "El tipo de dato "+tipo1
			+" no es compatible con el tipo de datos "
			+tipo2;
		}
		return msg;
	}
	
	public static String getMessage(String id, 
			int causa) {
		String msg = "";
		switch(causa) {
		case VARIABLE_DUPLICADA:
			msg = "La variable "+id+" ya está declarada";
			break;
		case VARIABLE_NO_DECLARADA:
			msg = "La variable "+id+" no está declarada";
			break;
		case VARIABLE_NO_INICIALIZADA:
			msg = "La variable "+id+" no está inicializada";
			break;
		}
		return msg;
	}
}
