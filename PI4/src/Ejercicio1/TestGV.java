package Ejercicio1;

import java.util.Arrays;

import us.lsi.astar.AStarAlgorithm;
import us.lsi.astar.AStarGraph;
import us.lsi.graphs.SimpleEdge;

import java.util.function.BiFunction;

//test


public class TestGV {
	public static void main(String[] args) {
	GV estadoInicial = GV.create(Arrays.asList(1, 3, 1, 1, 2, 5, 8, 10, 6, 11), 0, 0, 0);
	System.out.println("Estado inicial");
	System.out.println(estadoInicial);
	System.out.println("Estado final");
	GV estadoFinal = GV.create(Arrays.asList(1, 3, 1, 1, 2, 5, 8, 10, 6, 11), 24, 24, 10);
	System.out.println(estadoFinal);
	AStarGraph<GV, SimpleEdge<GV>> grafo = VerticeSuma.create(estadoInicial,
			estadoFinal);
	BiFunction<GV, GV, Double> heuristica = (e1, e2) -> e1.getDistancia(e2) * 1.;
	AStarAlgorithm<GV, SimpleEdge<GV>> alg = AStarAlgorithm.of(grafo, estadoInicial,
			estadoFinal, heuristica);
	System.out.println(alg.getPathVertexList());
	}
}
