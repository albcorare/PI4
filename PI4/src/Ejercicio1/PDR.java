package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Lists2;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;

public class PDR implements ProblemaPDR<List<Integer>, Integer,PDR>{
	
	public static List<Integer> numeros;

	private Integer index;
	private List<Integer> lista;
	private Integer sum0;
	private Integer sum1;

	
	public static PDR create(List<Integer> numeros) {
		PDR.numeros = numeros;
		return new PDR(new ArrayList<>());
	}

	public static PDR create(Integer index, List<Integer> lista, Integer sum0, Integer sum1) {
		return new PDR( index, lista,  sum0,  sum1);
	}
	
	private PDR(Integer index, List<Integer> lista, Integer sum0, Integer sum1) {
		super();
		this.index = index;
		this.lista = lista;
		this.sum0 = sum0;
		this.sum1 = sum1;
	}

	private PDR(List<Integer> lista) {
		this(0,lista,0,0);
		
	}

	@Override
	public Tipo getTipo() {
		return Tipo.Min;
	}

	@Override
	public int size() {
		return numeros.size() - index;
	}

	@Override
	public boolean esCasoBase() {//que pasa cuando llego al final
		return index == numeros.size();
	}

	@Override
	public Sp<Integer> getSolucionParcialCasoBase() {//llego al final y no encuentro solucion
		if (sum1==sum0) {
			return Sp.create(null, 0.0);
		}
		return null;
	}

	@Override
	public PDR getSubProblema(Integer a) {//ramifiaciones del probelma un problema menor	
		 List<Integer> nlista = Lists2.newList(lista);
		 Integer nsum0 = sum0;
	    Integer nsum1=sum1;
	    Integer e = numeros.get(index);
		if (a==1) {
			nlista.add(e);
			nsum0 = nsum0 + e;
		} else {
			nsum1 = nsum1 + e;
		}
		return PDR.create(index+1,nlista,nsum0,nsum1); //TODO
	}

	@Override
	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, Sp<Integer> s) {
		if (a==1) {
		return Sp.create(a, s.propiedad + 1);//TODO
		}
		return Sp.create(a, s.propiedad);//TODO

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
		if (sp.alternativa==1) {
		    Integer e = numeros.get(index);
		    s.add(0, e);
		}
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
