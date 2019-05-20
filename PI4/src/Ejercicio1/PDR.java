package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;

public class PDR implements ProblemaPDR<List<Integer>, Integer,PDR>{
	
	private Integer index;
	private List<Integer> lista;
	private List<Integer> sum0;
	private List<Integer> sum1;

	public static Integer numeroBuscado(List<Integer> ls) {
		return ls.stream()
		.mapToInt(x-> ls.get(x))
		.sum();
	}
	
	public static PDR create(List<Integer> numeros) {
		return new PDR(numeros);
	}

	private PDR(List<Integer> lista) {
		super();
		this.index = 0;
		this.lista = lista;
	}
	
	public PDR clone() {
		PDR newProblem = new PDR(this.lista);
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
	public PDR getSubProblema(Integer a) {//ramifiaciones del probelma un problema menor	
		return null; //TODO
	}

	@Override
	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, Sp<Integer> s) {
		return Sp.create(a, s.propiedad + 1);//TODO
	}

	@Override
	public List<Integer> getAlternativas() {
		List<Integer> alternativas = new ArrayList<Integer>();
		alternativas.add(0);
		alternativas.add(1);
		return alternativas;
 	}
	@Override
	public List<Integer> getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		return new ArrayList<>();
	}

	@Override
	public List<Integer> getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, List<Integer> s) {
		s.add(0, sp.alternativa); //TODO
		return s;
	}
	
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
		result = prime * result + ((sum0 == null) ? 0 : sum0.hashCode());
		result = prime * result + ((sum1 == null) ? 0 : sum1.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PDR other = (PDR) obj;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		if (sum0 == null) {
			if (other.sum0 != null)
				return false;
		} else if (!sum0.equals(other.sum0))
			return false;
		if (sum1 == null) {
			if (other.sum1 != null)
				return false;
		} else if (!sum1.equals(other.sum1))
			return false;
		return true;
	}

	

}
