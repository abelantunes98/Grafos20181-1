package grafos20181;

/**
 * Execultará os casos de teste para cada exercício
 * proposto na disciplina de Teoria dos Grafos.
 */
public class Execucao {

	private static void separador() {
		System.out.println(System.lineSeparator());
	}
	
	public static void main(String[] args) {
		MatrizIncidencia.main(args);
		separador();
		MenorCaminho.main(args);
		separador();
		EhBipartido.main(args);
	}

}
