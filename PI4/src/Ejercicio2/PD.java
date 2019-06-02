package Ejercicio2;

import java.util.ArrayList;
import java.util.List;
import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPD;

public class PD implements ProblemaPD<List<Tuple2<Punto, Punto>>, Tuple2<Integer, Integer>, PD> {

	private List<Punto> pO;
	private List<Punto> p;
	
	public PD(List<Punto> pO,List<Punto> p) {
		super();
		this.pO= pO;
		this.p = p;
	}

	public PD create(List<Punto> p) {
		return new PD(this.pO,p);
	}
	public PD create1(List<Punto> pO) {
		return new PD(pO,pO);
	}
	
	
	@Override
	public Tipo getTipo() {
		return Tipo.Min;
	}

	@Override
	public int size() {
		return p.size();
	}

	@Override
	public boolean esCasoBase() {
		return p.size()==3;
	}

	@Override
	public Sp<Tuple2<Integer,Integer>> getSolucionParcialCasoBase() {
		return Sp.create(null, 0.);
	}

	@Override
	public PD getSubProblema(Tuple2<Integer,Integer> a, int np) {
		List<Punto> np1= new ArrayList<Punto>();
		List<Punto> np2= new ArrayList<Punto>();
		for(Integer i=0;i<p.size();i++) {
			if(i<= a.getV1()) {
				np1.add(this.p.get(i));
				if(i==a.getV1()) {
					np2.add(this.p.get(i));
				}
				
			}else if(i>=a.getV2()) {
				np1.add(this.p.get(i));
				if(i==a.getV2()) {
					np2.add(this.p.get(i));
				}
			}else {
				np2.add(this.p.get(i));
			}
		}
				
		if(np==0){
			PD res= create(np1);
			return res;
		}else if(np==1){
			PD res=create(np2);
			return res;
		}return null;
	}

	@Override
	public Sp<Tuple2<Integer,Integer>> getSolucionParcialPorAlternativa(Tuple2<Integer,Integer> a, List<Sp<Tuple2<Integer,Integer>>> ls) {
		Double distanciaSub= 0.;
		for (Sp<Tuple2<Integer, Integer>> solucion : ls) {
			distanciaSub =+solucion.propiedad;
		}
		return Sp.create(a, distanciaSub+this.p.get(a.getV1()).getDistacia(this.p.get(a.getV2())));
	}

	@Override
	public List<Tuple2<Integer, Integer>> getAlternativas() {
		List<Tuple2<Integer, Integer>> alternativas=new ArrayList<Tuple2<Integer,Integer>>();
		for(int i=0;i<= this.p.size()-1;i++){
			for(int j=i+2;j<= i+this.p.size()-2;j++) {
				Tuple2<Integer, Integer> c=Tuple.create(i, j%this.p.size());
				if(!alternativas.contains(Tuple.create(j%(this.p.size()),i))) {
					alternativas.add(c);
				}
			}
		}
		return alternativas;
	}

	@Override
	public int getNumeroSubProblemas(Tuple2<Integer,Integer> a) {
		return 2;
	}

	@Override
	public List<Tuple2<Punto, Punto>> getSolucionReconstruidaCasoBase(Sp<Tuple2<Integer,Integer>> sp) {
		List<Tuple2<Punto, Punto>> p=new ArrayList<Tuple2<Punto, Punto>>(); 

		return p;
	}

	@Override
	public List<Tuple2<Punto, Punto>> getSolucionReconstruidaCasoRecursivo(Sp<Tuple2<Integer, Integer>> sp,
			List<List<Tuple2<Punto, Punto>>> ls) {
		List<Tuple2<Punto, Punto>> p=new ArrayList<Tuple2<Punto, Punto>>(); 
		if(ls!=null) {
		for (List<Tuple2<Punto, Punto>> lista : ls) {
			if(lista!=null) {
				for (Tuple2<Punto, Punto> tuple2 : lista) {
					p.add( tuple2);
				}	
			}
			}	
		}
		Tuple2<Punto, Punto> arista= Tuple.create(this.p.get(sp.alternativa.getV1()), this.p.get(sp.alternativa.getV2()));
		p.add(arista);
		return p;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		result = prime * result + ((pO == null) ? 0 : pO.hashCode());
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
		PD other = (PD) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (pO == null) {
			if (other.pO != null)
				return false;
		} else if (!pO.equals(other.pO))
			return false;
		return true;
	}

}
