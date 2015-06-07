package principal;

public class Arvore {

	public int num;
	public Arvore dir, esq;
	
	public Arvore(int num, Arvore dir, Arvore esq) {
		super();
		this.num = num;
		this.dir = dir;
		this.esq = esq;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Arvore getDir() {
		return dir;
	}
	public void setDir(Arvore dir) {
		this.dir = dir;
	}
	public Arvore getEsq() {
		return esq;
	}
	public void setEsq(Arvore esq) {
		this.esq = esq;
	}	
}
