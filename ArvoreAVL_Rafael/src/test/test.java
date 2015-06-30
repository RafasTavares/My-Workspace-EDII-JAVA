package test;

import static org.junit.Assert.*;

import org.junit.Test;

import principal.Arvore;
import principal.ArvoreAvl;

public class test {

	@Test
	public void test() {
		Arvore a = new Arvore();
		ArvoreAvl aa= new ArvoreAvl();
		aa.Inserir(a, 1);
		//aa.Inserir(a, 5);
		//aa.Inserir(a, 4);
		//aa.Inserir(a, 3);
		//aa.Inserir(a, 2);
		aa.MostrarPosOrdem(a);
	}

}
