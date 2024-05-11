package edu.itsco;

import java.io.IOException;
import java.io.PrintWriter;

public class GeneraCodigo {
	
	private PrintWriter salida;
	
	public GeneraCodigo(String path) {
		try {
			salida = new PrintWriter(path);
			salida.println("#include <stdlib.h>");
			salida.println("#include <stdio.h>");
			salida.println("int main(){");
			
		}catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public void terminarGeneracion() {
		salida.println("}");
		salida.close();
	}

}
