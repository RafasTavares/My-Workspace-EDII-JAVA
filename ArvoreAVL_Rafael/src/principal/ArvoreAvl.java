package principal;

public class ArvoreAvl {

	public static Arvore Inserir(Arvore aux, int num) {
		Arvore novo; // obj auxiliar
		if (aux == null) {

			novo = new Arvore();
			novo.num = num;
			novo.altd = 0;
			novo.alte = 0;
			novo.esq = null;
			novo.dir = null;
			aux = novo;
		} else if (num < aux.num) {
			aux.esq = Inserir(aux.esq, num);
			if (aux.esq.altd > aux.esq.alte) {
				aux.alte = aux.esq.altd + 1;
			} else
				aux.alte = aux.esq.alte + 1;
			aux = Balanceamneto(aux);

		} else {
			aux.dir = Inserir(aux.dir, num);
			if (aux.dir.altd > aux.dir.alte) {
				aux.altd = aux.dir.altd + 1;
			} else
				aux.altd = aux.dir.alte + 1;
			aux = Balanceamneto(aux);
		}
		return aux;
	}

	public static Arvore Balanceamneto(Arvore aux) {
		int d, dif;
		d = aux.altd = aux.alte;
		if (d == 2) {
			dif = aux.dir.altd = aux.dir.alte;
			if (dif >= 0) {
				aux = RotacaoEsquerda(aux);
			} else {
				aux.dir = RotacaoDireita(aux.dir);
				aux = RotacaoEsquerda(aux);
			}
		} else if (d == -2) {

			dif = aux.esq.altd - aux.esq.alte;

			if (dif <= 0) {
				aux = RotacaoDireita(aux);
			} else {
				aux.esq = RotacaoEsquerda(aux.esq);
				aux = RotacaoDireita(aux);
			}
		}
		return aux;
	}

	public static Arvore RotacaoEsquerda(Arvore aux) {
		Arvore aux1, aux2;
		aux1 = aux.dir;
		aux2 = aux1.esq;
		aux.dir = aux2;
		aux1.esq = aux;

		if (aux.dir == null)
			aux.altd = 0;
		else if (aux.dir.alte > aux.dir.altd)
			aux.altd = aux.dir.alte + 1;
		else
			aux.altd = aux.dir.altd + 1;

		if (aux1.esq.alte > aux1.esq.altd)
			aux1.alte = aux1.esq.alte + 1;
		else
			aux1.alte = aux1.esq.alte + 1;

		return aux1;
	}

	public static Arvore RotacaoDireita(Arvore aux) {
		Arvore aux1, aux2;
		aux1 = aux.esq;
		aux2 = aux1.dir;
		aux.esq = aux2;
		aux1.dir = aux;

		if (aux.esq == null)
			aux.alte = 0;
		else if (aux.esq.alte > aux.esq.altd)
			aux.alte = aux.esq.alte + 1;
		else
			aux.alte = aux.esq.altd + 1;

		if (aux1.dir.alte > aux1.dir.altd)
			aux1.altd = aux.esq.alte + 1;
		else
			aux1.altd = aux.esq.altd + 1;

		return aux1;
	}

	public static int Consultar(Arvore aux, int num, int achou) {
		if (aux != null && achou == 0) {
			if (aux.num == num) {
				achou = 1;
			}
		} else if (num < aux.num) {
			achou = Consultar(aux.esq, num, achou);
		} else
			achou = Consultar(aux.dir, num, achou);

		return achou;
	}

	public static void MostrarOrdem(Arvore aux) {

		if (aux != null) {
			MostrarOrdem(aux.esq);
			System.out.println(aux.num + "  ");
			MostrarOrdem(aux.dir);
		}
	}

	public static void MostrarPreOrdem(Arvore aux) {

		if (aux != null) {
			System.out.println(aux.num + "  ");
			MostrarPreOrdem(aux.esq);
			MostrarPreOrdem(aux.dir);
		}
	}

	public static void MostrarPosOrdem(Arvore aux) {

		if (aux != null) {

			MostrarPosOrdem(aux.esq);
			MostrarPosOrdem(aux.dir);
			System.out.println(aux.num + "  ");
		}
	}

	public static Arvore Remover(Arvore aux, int num) {

		Arvore p, p2;
		if (aux.num == num) {
			if (aux.esq == aux.dir) {
				// o elemento a ser removido nao pode ser removido
				return null;
			} else if (aux.esq == null) {
				// o elemento a ser removido nao tem filho a esquerda
				return aux.dir;
			} else if (aux.dir == null) {
				// o elemento a ser removido nao tem filho a esquerda
				return aux.esq;
			} else {
				// o elemento a ser removido tem filhos para ambos os lados
				p2 = aux.dir;
				p = aux.dir;
				while (p.esq != null) {
					p = p.esq;
				}
				p.esq = aux.esq;
				return p2;
			}
		} else if (aux.num < num) {
			aux.dir = Remover(aux.dir, num);
		} else {
			aux.esq = Remover(aux.esq, num);
		}
		return aux;
	}

	public static Arvore Atualiza(Arvore aux) {
		if (aux != null) {
			aux.esq = Atualiza(aux.esq);
			if (aux.esq == null)
				aux.alte = 0;
			else if (aux.esq.alte > aux.esq.altd) {
				aux.alte = aux.esq.alte + 1;
			} else {
				aux.alte = aux.esq.altd + 1;
			}
			aux.dir = Atualiza(aux.dir);

			if (aux.dir == null)
				aux.altd = 0;
			else if (aux.dir.alte > aux.dir.altd) {
				aux.altd = aux.dir.alte + 1;
			} else {
				aux.altd = aux.dir.altd + 1;
			}
			aux = Balanceamneto(aux);
		}
		return aux;
	}
}
