package Ejercicio1;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import us.lsi.graphs.SimpleEdge;
import us.lsi.graphs.VirtualVertex;

public class GV implements VirtualVertex<GV, SimpleEdge<GV>>{
	private List<Integer> numeros;
	private Integer sum1;
	private Integer sum2;
	private Integer index;
	private List<Integer> listSum1;
	
	public GV(List<Integer> num, Integer s1, Integer s2, Integer index, List<Integer> listSum1) {
		this.numeros= num;
		this.sum1 = s1;
		this.sum2 = s2;
		this.index = index;
		this.listSum1 = listSum1;
	}

	public static GV create(List<Integer> num, Integer s1,Integer s2,Integer index, List<Integer> listSum1) {
		return new GV(num,s1,s2,index,new ArrayList<>());
	}

	@Override
	public boolean isValid() {
	return this.index <= numeros.size();
	}

	@Override
	public Set<GV> getNeighborListOf() {
		Set<GV> n = new HashSet<>();
		if(this.index == this.numeros.size()) {
			return n;
		}
		List<Integer> nListSum1 = new ArrayList<>(this.listSum1);
		nListSum1.add(this.numeros.get(this.index));
		n.add(new GV(this.numeros, this.sum1 + this.numeros.get(this.index), this.sum2, this.index + 1, nListSum1));
		nListSum1 = new ArrayList<>(this.listSum1);
		n.add(new GV(this.numeros, this.sum1, this.sum2 + this.numeros.get(this.index), this.index + 1, nListSum1));
		return n;
	}

	@Override
	public Set<SimpleEdge<GV>> edgesOf() {
		return this.getNeighborListOf().stream().map(x->SimpleEdge.of(this, x)).collect(Collectors.toSet());
	}
	
//	public static List<Integer> alternativa(){
//		List<Integer> alternativas = new ArrayList<Integer>();
//		alternativas.add(0);
//		alternativas.add(1);
//		return alternativas;
//	}
	
	public Integer getDistancia(GV s) {
		int difSum1 = s.sum1 - this.sum1;
		int difSum2 = s.sum2 - this.sum2;
		return difSum1 + difSum2;

	}
	
	public Double getTam() {
		return (double) this.listSum1.size();
	}
	
	public static Double pesoArista(SimpleEdge<GV> gv) {
		GV origen = gv.source;
		GV destino = gv.target;
		Double res = 0.;
		if(origen.sum1 < destino.sum1) {
			res = 1.;
		}
		return res;
	}
	
	public static Boolean esEstadoFinal(GV gv) {
		return gv.index == gv.numeros.size() && gv.sum1 == gv.sum2;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((listSum1 == null) ? 0 : listSum1.hashCode());
		result = prime * result + ((numeros == null) ? 0 : numeros.hashCode());
		result = prime * result + ((sum1 == null) ? 0 : sum1.hashCode());
		result = prime * result + ((sum2 == null) ? 0 : sum2.hashCode());
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
		GV other = (GV) obj;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (listSum1 == null) {
			if (other.listSum1 != null)
				return false;
		} else if (!listSum1.equals(other.listSum1))
			return false;
		if (numeros == null) {
			if (other.numeros != null)
				return false;
		} else if (!numeros.equals(other.numeros))
			return false;
		if (sum1 == null) {
			if (other.sum1 != null)
				return false;
		} else if (!sum1.equals(other.sum1))
			return false;
		if (sum2 == null) {
			if (other.sum2 != null)
				return false;
		} else if (!sum2.equals(other.sum2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "listSum1=" + listSum1;
	}

}
