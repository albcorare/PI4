package Ejercicio1;


import us.lsi.astar.AStarGraph;
import us.lsi.graphs.SimpleEdge;
import us.lsi.graphs.SimpleVirtualGraph;

public class VerticeSuma extends SimpleVirtualGraph<GV, SimpleEdge<GV>>
implements AStarGraph<GV, SimpleEdge<GV>> {

	public static VerticeSuma create(GV... v) {
		return new VerticeSuma(v);
	}
	
	private VerticeSuma(GV... v) {
		super(v);
	}

}
