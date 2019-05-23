package Ejercicio1;

import java.util.Arrays;

import us.lsi.pd.AlgoritmoPD;

public class TestPDR {
	
	public static void main(String[] args) {
		
		AlgoritmoPD.isRandomize = false;
		//PDR p = PDR.create(Arrays.asList(2,0,5,4,1,0));
		PDR p = PDR.create(Arrays.asList(1,3,1,1,2,5,8,10,6,11));

		System.out.println(PDR.numeros);
		var a = AlgoritmoPD.createPDR(p);
		a.ejecuta();
		
		if(a.getSolucion() == null) {
			System.out.println("No hay solución");
		} else {
			System.out.println("Solución: " + a.getSolucion());
			System.out.println("Nº de saltos: " + a.getSolucion().size());
		}
	}

}
