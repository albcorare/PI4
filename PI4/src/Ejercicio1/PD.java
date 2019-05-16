package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;

public class PD implements ProblemaPDR<List<Integer>, Integer,PD>{
	
	private Integer index;
	private List<Integer> lista;
	
	public static PD create(List<Integer> numeros) {
		return new PD(numeros);
	}

	private PD(List<Integer> lista) {
		super();
		this.index = 0;
		this.lista = lista;
	}
	
	public PD clone() {
		PD newProblem = new PD(this.lista);
		return newProblem;
	}


	@Override
	public Tipo getTipo() {
		return Tipo.Min;
	}

	@Override
	public int size() {
		return lista.size() - index;
	}

	@Override
	public boolean esCasoBase() {//que pasa cuando llego al final
		return index == lista.size();
	}

	@Override
	public Sp<Integer> getSolucionParcialCasoBase() {//llego al final y no encuentro solucion
		return Sp.create(null, 0.0);
	}

	@Override
	public PD getSubProblema(Integer a) {//ramifiaciones del probelma un problema menor
		PD pro = this.clone();
		pro.index = this.index + 1;
		return pro;
		
	}

	@Override
	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, Sp<Integer> s) {
		return Sp.create(a, s.propiedad + 1);
	}

	@Override
	public List<Integer> getAlternativas() {
		List<Integer> alternativas = new ArrayList<Integer>();
		
	}

	@Override
	public List<Integer> getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		return new ArrayList<>();
	}

	@Override
	public List<Integer> getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, List<Integer> s) {
		s.add(0, sp.alternativa);
		return s;
	}

	

}
