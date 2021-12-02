
public class TesteTributaveis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContaCorrente cc = new ContaCorrente(222, 333);
		cc.deposita(100.0);
		
		SeguroDeVida seguro = new SeguroDeVida();
		
		CalculadorImposto imposto = new CalculadorImposto();
		imposto.registra(cc);
		imposto.registra(seguro);
		
		System.out.println(imposto.getTotalImposto());
	}

}
