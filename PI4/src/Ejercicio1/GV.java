package Ejercicio1;


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
	
	public GV(List<Integer> num, Integer s1, Integer s2, Integer index2) {
		this.numeros= num;
		this.sum1 = s1;
		this.sum2 = s2;
		this.index = index2;
	}

	public static GV create(List<Integer> num, Integer s1,Integer s2,Integer index) {
		return new GV(num,s1,s2,index);
	}

	@Override
	public boolean isValid() {
	return this.index <= numeros.size();
	}

	@Override
	public Set<GV> getNeighborListOf() {
		Set<GV> n = new HashSet<>();
		if (index < numeros.size()) {
			n.add(create(numeros, sum1 + numeros.get(index), sum2, index + 1));
			n.add(create(numeros, sum1, sum2 + numeros.get(index), index + 1));
		}
		return n;
	}

	@Override
	public Set<SimpleEdge<GV>> edgesOf() {
		return this.getNeighborListOf().stream().map(x->SimpleEdge.of(this, x)).collect(Collectors.toSet());
	}
	
	public Integer getDistancia(GV s) {
		int difSum1 = s.sum1 - this.sum1;
		int difSum2 = s.sum2 - this.sum2;
		return difSum1 + difSum2;

	}

	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((numeros == null) ? 0 : numeros.hashCode());
		result = prime * result + ((sum2 == null) ? 0 : sum2.hashCode());
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
		GV other = (GV) obj;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (numeros == null) {
			if (other.numeros != null)
				return false;
		} else if (!numeros.equals(other.numeros))
			return false;
		if (sum2 == null) {
			if (other.sum2 != null)
				return false;
		} else if (!sum2.equals(other.sum2))
			return false;
		if (sum1 == null) {
			if (other.sum1 != null)
				return false;
		} else if (!sum1.equals(other.sum1))
			return false;
		return true;
	}
	
	public String toString() {
		return "Conjunto " + this.numeros.toString() + " Sub1 " + this.sum1 + " Sub2 " + this.sum2 + " Index "
				+ this.index + "\n";
	}
}
