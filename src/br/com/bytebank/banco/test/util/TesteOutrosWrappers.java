package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

public class TesteOutrosWrappers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int idade = 29; //Variavel primitiva
		Integer idadeRef = Integer.valueOf(29); //Classe Integer n�o � primitiva e permite ser adicionada no ArrayList (autoboxing)
		System.out.println(idadeRef.doubleValue());
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.SIZE); //Retorna a capacidade em bits de armazenamento.
		System.out.println(Integer.BYTES); //Retorna a capacidade em bytes de armazenamento
		
		int valor = idadeRef.intValue(); //Verifica se o n�mero foi baseado em qual primitivo (unboxing)
		String s = args[0];
		//Integer numero = Integer.valueOf(s); //Transformando uma string em n�mero
		int numero = Integer.parseInt(s);
		System.out.println(numero);
		
		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(29); //Autoboxing (permite que seja adicionado um n�mero qualquer na lista sem ser por refer�ncia.
		
	}

}
