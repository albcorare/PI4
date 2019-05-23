package Ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import us.lsi.pd.AlgoritmoPD;

public class TestPDR {
	
	public static void main(String[] args) {
		
		AlgoritmoPD.isRandomize = false;
		PDR p = PDR.create(Arrays.asList(1,3,1,1,2,5,8,10,6,11));
		

//		


		System.out.println(PDR.numeros);
		var a = AlgoritmoPD.createPDR(p);
		a.ejecuta();
		
//		List<Integer> kk = PDR.numeros;
//		for(int i = 0; i<kk.size();i++) {
//			for(int j = 0; j<a.getSolucion().size();j++) {
//				kk.remove(a.getSolucion().get(j));
//			}
//		}
//		
		if(a.getSolucion() == null) {
			System.out.println("No hay solución");
		} else {
			System.out.println("Solución: " + a.getSolucion());
			System.out.println("Nº de saltos: " + a.getSolucion().size());
		}
	}

}
