package Ejercicio1;

import java.util.List;

import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;

public class PD implements ProblemaPDR<List<Integer>, Integer,PD>{
	
	private Integer index;
	private List<Integer> lista;

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
		return null;
	}

	@Override
	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, Sp<Integer> s) {
		return null;
	}

	@Override
	public List<Integer> getAlternativas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, List<Integer> s) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
