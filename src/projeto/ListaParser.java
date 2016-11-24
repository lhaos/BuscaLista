package projeto;
import java.util.Scanner;

import projeto.Lista;
import projeto.Parser;

public class ListaParser implements Parser<Lista> {
	public Lista parse(String dados) {		
		Scanner scanner = new Scanner(dados);
		
		scanner.useDelimiter(";");
		String valor = scanner.next();
		
		Lista lista = new Lista(valor);
		
		scanner.close();
		return lista;
	}//fecha lista	
}
