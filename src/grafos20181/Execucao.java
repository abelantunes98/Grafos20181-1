package grafos20181;

/**
 * Esse é o programa principal. É aqui onde todas as questões serão chamadas
 * para realizar seu trabalho.
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
