package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.bt.EstadoBT;

public class BT implements EstadoBT<List<Integer>, Integer, BT> {

	public static List<Integer> listaNumeros;

	private List<Integer> lista;
	private Integer index;
	private Double ls0;
	private Double ls1;
	private List<Integer> sls0;
	private List<Integer> sls1;
	private List<List<Integer>> s = new ArrayList<>();

	//---------------------------------------
	public BT(Integer index, Double ls0, Double ls1, List<Integer> sls0, List<Integer> sls1, List<List<Integer>> s) {
		super();
		this.index = index;
		this.ls0 = ls0;
		this.ls1 = ls1;
		this.sls0 = sls0;
		this.sls1 = sls1;
		this.s = s;
	}

	private BT() {
		lista = List.of(1, 6, 3, 2);
		index = 0;
		ls0 = 0.0;
		ls1 = 0.0;
		sls0 = new ArrayList<Integer>();
		sls1 = new ArrayList<Integer>();
		s = new ArrayList<List<Integer>>();

	}
	public static BT create() {
		return new BT();
	}

	//---------------------------------------

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
		if (a == 0) {
			sls0.add(lista.get(index));
			if (!sls0.isEmpty()) {
				ls0 = ls0 + sls0.get(sls0.size() - 1);
			}

			index = index + 1;
		}
		if (a == 1) {
			sls1.add(lista.get(index));
			if (!sls1.isEmpty()) {
				ls1 = ls1 + sls0.get(sls1.size() - 1);
			}

			index++;
		}
		return this;
	}

	@Override
	public BT retrocede(Integer a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return lista.size() - index;
	}

	@Override
	public boolean esCasoBase() {
		return lista.size() == index;
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
