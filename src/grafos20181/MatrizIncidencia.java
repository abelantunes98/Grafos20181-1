package grafos20181;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleGraph;

/**
 * Representação de uma matriz de incidência.
 *
 * @author Abel, Mariana, José Guilherme, Siuanny
 */
public class MatrizIncidencia {

	/**
	 * Método construtor do grafo simples, definindo seus vértices e arestas.
	 *
	 * @return grafoSimples
	 */
	private static Graph<String, DefaultEdge> criaGrafoSimples() {
		Graph<String, DefaultEdge> grafoSimples = new SimpleGraph<>(DefaultEdge.class);

		grafoSimples.addVertex("a");
		grafoSimples.addVertex("b");
		grafoSimples.addVertex("c");
		grafoSimples.addVertex("d");
		grafoSimples.addVertex("e");
		grafoSimples.addVertex("f");

		grafoSimples.addEdge("a", "b");
		grafoSimples.addEdge("a", "c");
		grafoSimples.addEdge("b", "c");
		grafoSimples.addEdge("b", "e");
		grafoSimples.addEdge("b", "d");
		grafoSimples.addEdge("c", "d");
		grafoSimples.addEdge("c", "e");
		grafoSimples.addEdge("e", "d");
		grafoSimples.addEdge("e", "f");
		grafoSimples.addEdge("f", "d");

		return grafoSimples;
	}
	
	private static void insereVertices(Graph<String, DefaultEdge> grafo, String[][] matriz) {
		int i = 1;
		for (String vertice : grafo.vertexSet()) {
			matriz[i++][0] = vertice;
		}
	}

	private static void insereArestas(Graph<String, DefaultEdge> grafo, String[][] matriz) {
		int j = 1;
		for (DefaultEdge aresta : grafo.edgeSet()) {
			String cauda = grafo.getEdgeSource(aresta);
			String cabeca = grafo.getEdgeTarget(aresta);
			matriz[0][j++] = cauda + cabeca;
		}
	}
	
	/**
	 * Método que define a quantidade de vértices e arestas, usa-os para criar a
	 * matriz e, depois de ter sido criada, são usados dois fors para verificar se
	 * há arestas entre dois vértices.
	 *
	 * @param grafo
	 * @return matriz
	 */
	private static String[][] criaMatriz(Graph<String, DefaultEdge> grafo) {
		int linhas = grafo.vertexSet().size() + 1;
		int colunas = grafo.edgeSet().size() + 1;

		String[][] matriz = new String[linhas][colunas];
		matriz[0][0] = "#";
		insereVertices(grafo, matriz);
		insereArestas(grafo, matriz);

		int i = 1;
		for (String vertices : grafo.vertexSet()) {
			int j = 1;
			for (DefaultEdge aresta : grafo.edgeSet()) {
				String cauda = grafo.getEdgeSource(aresta);
				String cabeca = grafo.getEdgeTarget(aresta);
				if (cauda.equals(vertices) || cabeca.equals(vertices)) {
					matriz[i][j++] = " 1";
				} else {
					matriz[i][j++] = " 0";
				}
			}
			i++;
		}
		return matriz;
	}
	/**
	 * Imprime a matriz resultante.
	 */
	private static void Resposta(String[][] matriz) {
		System.out.println("Questão 1. Matriz de Incidência:" + System.lineSeparator());
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Chama os métodos de construção e exibição da matriz resutante.
	 */
	public static void main(String[] args) {
		Graph<String, DefaultEdge> grafo = criaGrafoSimples();
		String[][] matriz = criaMatriz(grafo);
		Resposta(matriz);
	}

}
