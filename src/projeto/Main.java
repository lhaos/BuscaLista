package projeto;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import projeto.LeitorCSV;
import projeto.Iterador;
import projeto.Lista;
import projeto.ListaEncadeada;
import projeto.ListaParser;
import projeto.Main;
import projeto.Parser;

public class Main {

	public static void main(String[] args) {
		
		try {
			(new Main()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrou arquivo.");
			System.err.println(e.getMessage());
		}//fecha try-catch
	}//fecha main
	
	Parser<Lista> parserList = new ListaParser();
	
	private void run() throws FileNotFoundException {
	
		ListaEncadeada lista = new ListaEncadeada();
		//importando informacoes dos arquivos csv
		importarArquivo("src/arquivos/lista.csv", lista, parserList);
		
		Iterador iter = lista.iterator();
		
		Scanner sc = new Scanner(System.in);            
	    String valor = null, resp = null;
	      do{         
	         System.out.println("\nEscolha a opção\n1->Inserir dados\n2->Pesquisar um valor a esquerda"
	         		+ "\n3->Pesquisar um valor a direita\n4->Listar valores da lista"
	         		+ "\n5->Sair da aplicacao");      
	         resp = sc.next();         
	         if(resp.equals("1")){
	            System.out.println("Digite um valor:");
	            valor = sc.next();
	            //Insere valore no inicio da lista.
	            try {
	               lista.insert(valor);
	            } 
	            catch (Exception e) {               
	               e.printStackTrace();
	            }
	         }  
	         else if(resp.equals("2")){
		            System.out.println("Digite um valor:");
		            valor = sc.next();
		            //Pesquisa por valores na lista.
		            if(lista.FindLeft(valor) == true){
		               System.out.println("Valor existe na lista!");
		               System.out.println("Foram feita "+lista.num_ver+" consultas para acha-lo!");}
		            else{
		               System.out.println("Valor não existe na lista!");  }          
		         }         
		         else if(resp.equals("4")){
		            try {
		                lista.print();
		            } 
		            catch (Exception e) {
		               e.printStackTrace();               
		            }
		            
		         }
	         else if(resp.equals("3")){
	            System.out.println("Digite um valor:");
	            valor = sc.next();
	            //Pesquisa por valores na lista.
	            if(lista.FindRight(valor) == true){
	               System.out.println("Valor existe na lista!");
	               System.out.println("Foram feita "+lista.num_ver+" consultas para acha-lo!");}
	            else{
	               System.out.println("Valor não existe na lista!");  }          
	         }         
	         else if(resp.equals("4")){
	            try {
	                lista.print();
	            } 
	            catch (Exception e) {
	               e.printStackTrace();               
	            }
	            
	         }
	         else if(resp.equals("5")){
		            System.exit(0);
		            
		         }
	         else{
	            System.out.println("Opção inválida!");
	         }
	      }while(resp != "9");
		
		
	}//fecha run
	
	private void importarArquivo(String arquivo,ListaEncadeada lista, Parser parser) throws FileNotFoundException {
		//Parser<Object> parse = new ObjectParser();
		LeitorCSV<Lista> reader = new LeitorCSV<>(arquivo, parser);
		reader.skipLine(); //se houver cabeçalho cabecalho
		
		while (reader.hasNext()) {
			Lista dados = reader.readObject();
			lista.append(dados.getValor());
		}//fecha while		
		reader.close();
	}//fecha verArquivo
		
		//======================================================
		
		  
}
