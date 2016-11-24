package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);      
	      ListaEncadeada lista = new ListaEncadeada();      
	      String valor = null, resp = null;      
	      do{         
	         System.out.println("Escolha a opção\n1->Inserir no Início:\n2->Inserir no fim:\n3->Pesquisar um valor:\n4->Listar valores da lista:");      
	         resp = sc.next();         
	         if(resp.equals("1")){
	            System.out.println("Digite um valor:");
	            valor = sc.next();
	            //Insere valore no inicio da lista.
	            try {
	               lista.appendOrder(valor);
	            } 
	            catch (Exception e) {               
	               e.printStackTrace();
	            }
	         }            
	         else if(resp.equals("3")){
	            System.out.println("Digite um valor:");
	            valor = sc.next();
	            //Pesquisa por valores na lista.
	            if(lista.Find(valor) == true){
	               System.out.println("Valor existe na lista!");
	            	System.out.println(lista.num_ver);}
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
	         else
	            System.out.println("Opção inválida!");
	      }
	      while(resp != "9");

	}

}
