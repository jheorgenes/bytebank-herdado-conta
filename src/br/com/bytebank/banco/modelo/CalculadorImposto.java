package br.com.bytebank.banco.modelo;

public class CalculadorImposto {
	
	private double totalImposto;

	//Aqui est� fazendo uma composi��o de interface
	public void registra(Tributavel t) {
		double valor = t.getValorImposto();
		this.totalImposto += valor;
	}
	
	public double getTotalImposto() {
		return totalImposto;
	}
}
