package principal;

public class Node {

	public Arvore num;
	public Node prox;

	public Node(Arvore num, Node prox) {
		super();
		this.num = num;
		this.prox = prox;
	}

	public Arvore getNum() {
		return num;
	}

	public void setNum(Arvore num) {
		this.num = num;
	}

	public Node getProx() {
		return prox;
	}

	public void setProx(Node prox) {
		this.prox = prox;
	}
}
