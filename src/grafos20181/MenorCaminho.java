package grafos20181;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class MenorCaminho {

	private static GraphPath<String, DefaultWeightedEdge> buscaMenorCaminho(SimpleWeightedGraph<String, DefaultWeightedEdge> grafo) {		
		DijkstraShortestPath<String, DefaultWeightedEdge> caminho = new DijkstraShortestPath<String, DefaultWeightedEdge>(grafo);
		return caminho.getPath("a", "d");
	}

	private static SimpleWeightedGraph<String, DefaultWeightedEdge> criaGrafo() {
		SimpleWeightedGraph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);

		graph.addVertex("a");
		graph.addVertex("b");
		graph.addVertex("c");
		graph.addVertex("d");
		graph.addVertex("e");
		graph.addVertex("f");
		graph.addVertex("g");
		graph.addVertex("h");
		graph.addVertex("i");

		graph.setEdgeWeight(graph.addEdge("a", "b"), 2);
		graph.setEdgeWeight(graph.addEdge("b", "c"), 4);
		graph.setEdgeWeight(graph.addEdge("c", "d"), 2);
		graph.setEdgeWeight(graph.addEdge("d", "e"), 1);
		graph.setEdgeWeight(graph.addEdge("e", "f"), 6);
		graph.setEdgeWeight(graph.addEdge("f", "a"), 7);
		graph.setEdgeWeight(graph.addEdge("a", "g"), 3);
		graph.setEdgeWeight(graph.addEdge("g", "i"), 1);
		graph.setEdgeWeight(graph.addEdge("g", "h"), 3);
		graph.setEdgeWeight(graph.addEdge("g", "b"), 6);
		graph.setEdgeWeight(graph.addEdge("h", "c"), 2);
		graph.setEdgeWeight(graph.addEdge("h", "d"), 8);
		graph.setEdgeWeight(graph.addEdge("h", "i"), 4);
		graph.setEdgeWeight(graph.addEdge("i", "f"), 5);
		graph.setEdgeWeight(graph.addEdge("i", "e"), 2);

		return graph;
	}

	private static void Resposta(GraphPath<String, DefaultWeightedEdge> caminho) {
		System.out.println("Questão 2. Menor Caminho:" + System.lineSeparator());
		System.out.println("Caminho: " + caminho.toString());
		System.out.println("Peso do caminho: " + caminho.getWeight());
		System.out.println("Quantidade de arestas: " + caminho.getLength());
	}

	public static void main(String[] args) {
		SimpleWeightedGraph<String, DefaultWeightedEdge> grafo = criaGrafo();
		GraphPath<String, DefaultWeightedEdge> caminho = buscaMenorCaminho(grafo);
		Resposta(caminho);
	}


}
