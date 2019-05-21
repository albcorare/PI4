package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.bt.EstadoBT;

public class BT implements EstadoBT<List<Integer>, Integer, BT> {
	
	public static List<Integer> numeros;

	private Integer index;
	private List<Integer> lista;
	private Integer sum0;
	private Integer sum1;
	

	@Override
	public Tipo getTipo() {
		return Tipo.Min;
	}

	@Override
	public BT getEstadoInicial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BT avanza(Integer a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BT retrocede(Integer a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return numeros.size() - index;
	}

	@Override
	public boolean esCasoBase() {
		return index == numeros.size();
	}

	@Override
	public List<Integer> getAlternativas() {
		List<Integer> alternativas = new ArrayList<Integer>();
		alternativas.add(0);
		alternativas.add(1);
		return alternativas;
	}

	@Override
	public List<Integer> getSolucion() {
		// TODO Auto-generated method stub
		return null;
	}

}
