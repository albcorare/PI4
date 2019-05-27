package Ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import us.lsi.pd.AlgoritmoPD;
import Ejercicio2.PD;


public class TestPD {
	public static void main(String[] args) {
		Punto c=new Punto(1, 2, 3);
		Punto c1=new Punto(2, 3, 3);
		Punto c2=new Punto(3, 3, 1);
		Punto c3=new Punto(4, 2, 1);
		Punto c4=new Punto(5, 1, 2);
		Punto c5=new Punto(6, 4, 2);
		List<Punto> puntos=new ArrayList<Punto>(Arrays.asList(c,c1,c5,c2,c3,c4));
		PD r= new PD(puntos, puntos);
		var a = AlgoritmoPD.createPD(r);
		a.ejecuta();		
		System.out.println("Solucion= "+a.getSolucion());
	}

}
