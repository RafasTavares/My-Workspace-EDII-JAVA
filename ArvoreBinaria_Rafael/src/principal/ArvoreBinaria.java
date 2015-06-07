package principal;

public class ArvoreBinaria {

	Arvore raiz = null;
	Arvore aux;
	Arvore aux1;
	Arvore novo;
	Arvore anterior;
	Node topo;
	Node auz_pilha;
	int achou;

	public void InserirElemento(int elemento) {
		if (raiz == null) {
			novo.num = elemento;
			novo.dir = null;
			novo.esq = null;

			raiz = novo;
		} else {
			aux = raiz;
			achou = 0;
			while (achou == 0) {
				if (novo.num < aux.num) {
					if (aux.esq == null) {
						aux.esq = novo;
						achou = 1;
					} else
						aux = aux.esq;
				} else if (novo.num >= aux.num) {
					if (aux.dir == null) {
						aux.dir = novo;
						achou = 1;
					} else
						aux = aux.dir;
				}
			}

		}
	}

	public String RemoverElemento(int elemento) {
		if (raiz == null) {
			return "A arvore est� vazia";
		} else {
			aux = raiz;
			achou = 0;
			while (achou == 0 && aux != null) {
				if (aux.num == elemento) {
					achou = 1;
				} else if (aux.num > elemento) {
					// O numero est� � esquerda da arvore
					aux = aux.esq;
				} else
					// O numero esta a direita
					aux = aux.dir;
				if (achou == 0) {
					return "Numero n�o encontrado";
				} else {
					if (aux != raiz) {
						/*
						 * o numero foi encontrado e excluido. N�o � a raiz �
						 * necess�rio encontrar o anterior para acertar os
						 * ponteiros anterior = elemento que aponta para o
						 * numero a ser excluido
						 */
						anterior = raiz;
						while (anterior.dir != aux && anterior.esq != aux) {
							if (anterior.num > elemento)
								// o numero esta a esquerda da arvore
								anterior = anterior.esq;
							else
								// o numero esta a direita
								anterior = anterior.dir;

							// um numero folha sera excluido
							if (aux.dir == null && aux.esq == null) {

								if (anterior.dir == aux)
									anterior.dir = null;
								else
									anterior.esq = null;
							} else {
								// um numero folha n�o sera excluido
								if (aux.dir != null && aux.esq == null) {
									// numero que possui filhos somente a
									// esquerda
									if (anterior.esq == aux)
										anterior.esq = aux.dir;
									else
										anterior.dir = aux.dir;
								} else if (aux.esq != null && aux.dir == null) {
									// numero que possui filhos somente a
									// esquerda
									if (anterior.esq == aux)
										anterior.esq = aux.esq;
									else
										anterior.dir = aux.esq;
								} else if (aux.esq != null && aux.dir != null) {
									// um numero que possui filhos para esquerda
									// e direita
									if (anterior.dir == aux) {
										anterior.dir = aux.dir;
										aux1 = aux.esq;
									} else {
										anterior.esq = aux.esq;
										aux1 = aux.dir;
									}
									// recolocando o pedaco da arvore
									aux = anterior;
								}
								while (aux != null) {
									if (aux.num < aux1.num) {
										if (aux.dir == null) {
											aux.dir = aux1;
											aux = null;
										} else
											aux = aux.dir;
									} else if (aux.num > aux1.num) {
										if (aux.esq == null) {
											aux.esq = aux1;
											aux = null;
										} else
											aux = aux.esq;
									}
								}
							}
						}

					} else {
						// O numero a ser excluido � a raiz
						if (aux.dir == null && aux.esq == null) {
							// a raiz nao tem filhos e sera excluida
							raiz = null;
						} else {
							if (aux.dir != null && aux.esq == null) {
								// a raiz sera excluida e so possui filhos a
								// direita
								raiz = aux.dir;
							} else if (aux.esq != null && aux.dir == null) {
								// a raiz sera excluida e so possui filhos a
								// esquerda
								raiz = aux.esq;
							} else if (aux.esq != null && aux.dir != null) {
								// a raiz sera excluida e possui filhos a
								// direita e a esquerda
								raiz = aux.dir;
								aux1 = aux.esq;
								// recolocando o pedaco da arvore
								aux = raiz;

								while (aux != null) {
									if (aux.num < aux1.num) {
										if (aux.dir == null) {
											aux.dir = aux1;
											aux = null;
										} else
											aux = aux.dir;
									} else if (aux.num > aux1.num) {
										if (aux.esq == null) {
											aux.esq = aux1;
											aux = null;
										} else
											aux = aux.esq;
									}
								}
							}
						}
					}
				}
			}
			return "Removido com sucesso";
		}
	}

	public void ConsultarNo() {
	}

	public void ConsultarOrdem() {
	}

	public void ConsultarPreOrdem() {
	}

	public void ConusltarPosOrdem() {
	}

	public void Esvaziararvore() {
	}

}
