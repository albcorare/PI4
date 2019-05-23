package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.bt.AlgoritmoBT;

public class TestBT {

	public static void main(String[] args) {
//		AlgoritmoBT.conFiltro=false;
//		AlgoritmoBT.isRandomize=false;
//		AlgoritmoBT.numeroDeSoluciones=1;


		BT estadoInicial = BT.create();
		var a = AlgoritmoBT.create(estadoInicial);
		a.ejecuta();
		List<Integer> kk = new ArrayList<Integer>(BT.numeros);
		
		for(int i = 0; i<kk.size();i++) {
			for(int j = 0; j<a.getSolucion().size();j++) {
				kk.remove(a.getSolucion().get(j));
			}
		}

		if (a.getSolucion() == null) {
			System.out.println("No hay solucion");
		} else {
			System.out.println("Solucion: " + a.getSolucion()+"-"+ kk);

		}
	}

}
