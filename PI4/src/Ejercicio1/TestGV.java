package Ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;

import us.lsi.astar.AStarAlgorithm;
import us.lsi.astar.AStarGraph;
import us.lsi.astar.AStarSimpleVirtualGraph;
import us.lsi.astar.PredicateHeuristic;
import us.lsi.graphs.SimpleEdge;

import java.util.function.BiFunction;

//test


public class TestGV {
	public static void main(String[] args) {
	GV estadoInicial = GV.create(Arrays.asList(1, 3, 1, 1, 2, 5, 8, 10, 6, 11), 0, 0, 0, new ArrayList<>());
	System.out.println("Estado inicial");
	System.out.println(estadoInicial);
	AStarGraph<GV, SimpleEdge<GV>> grafo = AStarSimpleVirtualGraph.of(e -> GV.pesoArista(e));
	PredicateHeuristic<GV> heuristica = (e1, e2) -> e1.getTam();
	AStarAlgorithm<GV, SimpleEdge<GV>> alg = AStarAlgorithm.of(grafo, estadoInicial,v -> GV.esEstadoFinal(v), heuristica); //TODOs
	System.out.println(alg.getPathVertexList());
	}
}
