package Ejercicio1;

import java.util.List;

import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;

public class PD implements ProblemaPDR<Integer, Integer,PD>{

	@Override
	public Tipo getTipo() {
		return Tipo.Min;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean esCasoBase() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Sp<Integer> getSolucionParcialCasoBase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PD getSubProblema(Integer a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, Sp<Integer> s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getAlternativas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, Integer s) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
