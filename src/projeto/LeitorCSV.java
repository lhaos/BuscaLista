package projeto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LeitorCSV<T>{
	
	private Scanner arquivo;
	private Parser<T> parser;

	public LeitorCSV(String filename, Parser<T> parser)
			throws FileNotFoundException
	{
		this.arquivo =
				new Scanner(
						new BufferedReader(
								new FileReader(filename)
								)
				);
		this.parser = parser;
		//arquivo.useDelimiter("[;\\r\\n]+");
	}

	public boolean hasNext() {
		return arquivo.hasNext();
	}
	
	public void skipLine() {
		arquivo.nextLine();
	}

	public T readObject() {
		return parser.parse(arquivo.nextLine());
	}
	
	public void close() {
		arquivo.close();
	}	
	
}//close class
