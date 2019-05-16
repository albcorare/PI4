package Ejercicio1;

import java.util.Arrays;

import us.lsi.pd.AlgoritmoPD;

public class TestPD {
	
	public static void main(String[] args) {
		
		AlgoritmoPD.isRandomize = false;
		PD p = PD.create(Arrays.asList(2,0,5,4,1,0));
		var a = AlgoritmoPD.createPDR(p);
		a.ejecuta();
		
		if(a.getSolucion() == null) {
			System.out.println("No hay soluci�n");
		} else {
			System.out.println("Soluci�n: " + a.getSolucion());
			System.out.println("N� de saltos: " + a.getSolucion().size());
		}
	}

}
