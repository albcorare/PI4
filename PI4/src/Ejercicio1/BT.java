package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.bt.EstadoBT;
import us.lsi.common.Lists2;

public class BT implements EstadoBT<List<Integer>, Integer, BT> {

	public static List<Integer> numeros;
	private Integer index;
	private List<Integer> lista;
	private Integer sum0;
	private Integer sum1;
 
	// ---------------------------------------
	public BT(List<Integer> numeros, Integer index, List<Integer> lista, Integer sum0, Integer sum1) {
		super();
		BT.numeros = numeros;
		this.index = index;
		this.lista = lista;
		this.sum0 = sum0;
		this.sum1 = sum1;
	}

	public static BT create() {
		BT.numeros = List.of(1, 3, 1, 1, 2, 5, 8, 10, 6, 11);
		return new BT(List.of(1, 3, 1, 1, 2, 5, 8, 10, 6, 11), 0, new ArrayList<Integer>(), 0, 0);
	}

	// ---------------------------------------

	@Override
	public Tipo getTipo() {
		return Tipo.Min;
	}

	@Override
	public BT getEstadoInicial() {
		return create();
	}

	@Override
	public BT avanza(Integer a) {
		Integer e = numeros.get(index);
		if (a == 1) {
			lista.add(e);
			sum0 = sum0 + e;
		} else {
			sum1 = sum1 + e;
		}
		index = index+1;
		return this;
	}

	@Override
	public BT retrocede(Integer a) {
		index = index-1;
		Integer e = numeros.get(index);
		if (a == 1) {
			lista.remove(lista.size()-1);
			sum0 = sum0 - e;
		} else {
			sum1 = sum1 - e;
		}
		return this;
	}

	@Override
	public int size() {
		return numeros.size() - index;
	}

	@Override
	public boolean esCasoBase() {

		return numeros.size() == index;
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
		if (sum0==sum1) {
			return Lists2.newList(this.lista);
		}
		return null;
	}

	
	public Double getObjetivo() {
		return (double)this.lista.size();
	}
	
	

}
