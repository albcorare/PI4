package Ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import us.lsi.pd.AlgoritmoPD;

public class TestPDR {
	
	public static void main(String[] args) {
		
		AlgoritmoPD.isRandomize = false;
		PDR p = PDR.create(Arrays.asList(1,3,1,1,2,5,8,10,6,11));
		System.out.println(PDR.numeros);
		var a = AlgoritmoPD.createPDR(p);
		a.ejecuta();
		
		List<Integer> kk = PDR.numeros;
		List<Integer> sol = a.getSolucion();
		List<Integer> lista2= new ArrayList<Integer>();
		
		for(int i=0; i < kk.size(); i++) {
			if(!sol.contains(kk.get(i))) {
				lista2.add(kk.get(i));
			}
		}
		
		
		if(a.getSolucion() == null) {
			System.out.println("No hay solución");
		} else {
			System.out.println("Solución: " + a.getSolucion()+"-"+ lista2);
			System.out.println("Nº de saltos: " + a.getSolucion().size());
		}
	}

}
