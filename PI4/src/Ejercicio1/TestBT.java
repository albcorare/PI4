package Ejercicio1;

import us.lsi.bt.AlgoritmoBT;

public class TestBT {

	public static void main(String[] args) {
		AlgoritmoBT.conFiltro=false;
		AlgoritmoBT.isRandomize=false;
		AlgoritmoBT.numeroDeSoluciones=1;

		BT estadoInicial = BT.create();
		var a = AlgoritmoBT.create(estadoInicial);
		a.ejecuta();

		if (a.getSolucion() == null) {
			System.out.println("No hay solucion");
		} else {
			System.out.println("Solucion: " + a.getSolucion());
		}
	}

}
