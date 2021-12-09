package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayListEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Conta cc1 = new ContaCorrente(22, 11);
//		Conta cc2 = new ContaCorrente(22, 11);
//		
//		boolean igual = cc1.ehIgual(cc2);
//		System.out.println(igual);
		
		ArrayList<Conta> lista = new ArrayList<Conta>();
		
		Conta cc1 = new ContaCorrente(22, 11);
		lista.add(cc1);
		
		Conta cc2 = new ContaCorrente(11, 22);
		lista.add(cc2);
		
		Conta cc3 = new ContaCorrente(11, 22);
		
		boolean existe = lista.contains(cc3); //Verifica se já há uma referência dessa classe na lista
		
		System.out.println("Já existe? " + existe);
		
		for(Conta conta : lista) {
			System.out.println(conta);
		}
	}

}
