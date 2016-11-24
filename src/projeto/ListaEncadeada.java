package projeto;

public class ListaEncadeada implements Iterable<String> {

	private class ListaIterator implements Iterador {

		private Node current = null;
		private Node previous = null;
		
		@Override
		public boolean hasNext() {
			if (current == null)
				return head != null;
			return current.getNext() != null;
		}

		@Override
		public String next() {
			if (current == null) {
				current = head;
			} else {
				previous = current;
				current = current.getNext();
			}
			return current.dado;
		}

		@Override
		public void insert(String dado) {
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			Node node = new Node();
			node.setDado(dado);
			node.setNext(current);
			if (previous == null) {
				head = node;
			} else {
				previous.setNext(node);
			}
		}
		
		@Override
		public void append(String dado) {
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			
			Node node = new Node();
			Node proximo = current.getNext();
			
			node.setDado(dado);
			node.setNext(proximo);
			
			node.setPrevious(previous);
			
			
			current.setNext(node);
			if (proximo == null) {
				tail = node;
			}
		}
		
		@Override
		public void remove() {
			if (current == null) {
				throw new IllegalStateException("Use next()!");
			}
			previous.setNext(current.getNext());
			if (!hasNext()) {
				tail = previous;
			}
			if (current == head) {
				head = head.getNext();
			}
		}
		
	}//fecha classe privada do iterator
	
	private class Node {
		public String dado;
		private Node next;
		private Node previous;
		
		public Node() {
			this.next = null;
			this.previous = null;
		}
		
		public void setDado(String dado){
			this.dado = dado;
		}
		
		public void setPrevious(Node previous){
			this.previous = previous;
		}
		
		public Node getPrevious(){
			return previous;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getNext() {
			return next;
		}
	}//fecha classe de nos
	
	private Node head = null;
	private Node tail = null;
	private Node anterior = null;
	public int num_ver = 0;
	private boolean testa_head = false;

	public void append(String dado) {
		Node node = new Node();
		node.setDado(dado);
		if (head == null) {
			head  = node;
		} else {
			if(!testa_head){
				head.setNext(node);
				node.setPrevious(head);
				anterior = node;
			}else{
				node.setPrevious(anterior);
				anterior = node;
			}
			tail.setNext(node);
			System.out.println("Caiu aq");
			testa_head = true;
		}
		tail = node;
	}

	public void pushFront(String dado) {
		Node node = new Node();
		node.setDado(dado);
		if (head == null) {
			tail = node;
		} else {
			node.setNext(head);
		}
		head = node;
	}
	
	public boolean Find(String valor){
	      Node aux = tail;
	      for(int i = 0; aux != null; i++){
	         if(valor.equals(aux.dado)){
	        	 num_ver = i+1;
	            return true;
	         }
	         aux = aux.getPrevious();
	      }
	      
	      return false;
	   }

	public void print() {
		Node iter = head;
		while (iter != null) {
			System.out.print(iter.dado+" ");
			iter = iter.getNext();
		}
	}

	@Override
	public Iterador iterator() {
		return new ListaIterator() ;
	}

}