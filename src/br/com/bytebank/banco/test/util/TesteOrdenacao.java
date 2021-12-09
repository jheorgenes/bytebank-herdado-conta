package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteOrdenacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Conta cc1 = new ContaCorrente(22, 33);
         Cliente clienteCC1 = new Cliente();
         clienteCC1.setNome("Nico");
         cc1.setTitular(clienteCC1);
         cc1.deposita(333.0);

         Conta cc2 = new ContaPoupanca(22, 44);
         Cliente clienteCC2 = new Cliente();
         clienteCC2.setNome("Guilherme");
         cc2.setTitular(clienteCC2);
         cc2.deposita(444.0);

         Conta cc3 = new ContaCorrente(22, 11);
         Cliente clienteCC3 = new Cliente();
         clienteCC3.setNome("Paulo");
         cc3.setTitular(clienteCC3);
         cc3.deposita(111.0);

         Conta cc4 = new ContaPoupanca(22, 22);
         Cliente clienteCC4 = new Cliente();
         clienteCC4.setNome("Ana");
         cc4.setTitular(clienteCC4);
         cc4.deposita(222.0);


         List<Conta> lista = new ArrayList<>();
         lista.add(cc1);
         lista.add(cc2);
         lista.add(cc3);
         lista.add(cc4);
		
		for (Conta conta : lista) {
			System.out.println(conta);
		}
		
		System.out.println("--------------------");
		
		//NumeroDaContaComparator comparator = new NumeroDaContaComparator();
		//lista.sort(new TitularDaContaComparator());
		lista.sort(null); //Realiza a ordem natural, porém é uma má prática passar o parametro null para isso.
		
		//Formas antigas de ordenação.
		//Collections.sort(lista, new NumeroDaContaComparator()); //Também ordena a lista (de forma crescente)
		//Collections.sort(lista);
		//Collections.reverse(lista); //Ordena de forma decrescente
		
		for (Conta conta : lista) {
			System.out.println(conta + ", " + conta.getTitular().getNome());
		}
	}
}

class TitularDaContaComparator implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {
		String nomeC1 = c1.getTitular().getNome(); //Buscando o nome titular que está dentro da conta
		String nomeC2 = c2.getTitular().getNome();	
		return nomeC1.compareTo(nomeC2); //Verifica se as strings são iguais, ou se a string é maior ou menor que a outra. (0, -1, 1) (ordena em crescente)
	}	
}

/**
 * Implementar a interface comparator significa que terá que ser implementado o método de comparação
 * O método será sobrescrito e terá que ter dois parametros para comparar.
 * Deverão ser retornados (0, -1, 1)
 * 0 - São iguais;
 * -1 - parametro 1 é menor que parametro 2
 * 1 - parametro 1 é maior que parametro 2
 * @param Conta
 *
 */
class NumeroDaContaComparator implements Comparator<Conta> {

	@Override 
	public int compare(Conta c1, Conta c2) {
		
		return Integer.compare(c1.getNumero(), c2.getNumero());
		
//		return c1.getNumero() - c2.getNumero(); //Faz a mesma comparação para retornar um valor positivo, negativo ou igual a 0
		
//		if(c1.getNumero() < c2.getNumero())  //Menor
//			return -1;	
//		if(c1.getNumero() > c2.getNumero())  //Maior
//			return 1;
//		return 0;
	}	
}
