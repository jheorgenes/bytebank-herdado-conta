package br.com.bytebank.banco.modelo;

/**
 * Classe representa a moldura de uma conta
 * */
public abstract class Conta implements Comparable<Conta>{ //Preparando classe para comparar com outra conta
	
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total = 0;
	
	/**
	 * Construtor para inicializar o objeto Conta a partir da agencia e número
	 * 
	 * @param agencia
	 * @param numero
	 */
	public Conta() {}
	
	public Conta(int agencia, int numero) {
		Conta.total++;
		//System.out.println("O total das contas é " + Conta.total);
		this.agencia = agencia;
		this.numero = numero;
		//this.saldo = 100;
		//System.out.println("Estou criando uma conta " + this.numero);
	}
	
	public abstract void deposita(double valor);
	
	/**
	 * Valor precisa ser maior do que o saldo.
	 * 
	 * @param valor
	 * @throws SaldoInsuficienteException
	 */
	public void saca(double valor) throws SaldoInsuficienteException {
		//Fazendo a inversão da lógica para sempre lançar excessão se algo ocorrer antes da execução do método.
		if(this.saldo < valor) {  //Se o valor a sacar for maior que o saldo
			throw new SaldoInsuficienteException("Saldo: " + this.saldo + ", Valor: " + valor); //Lança a exception
		}
		//Se não tiver problema, saca.
		this.saldo -= valor;
	}
	
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException {
		this.saca(valor);
		destino.deposita(valor);
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero){
        if(numero <= 0) {
            System.out.println("Nao pode valor menor igual a 0");
            return;
        }
        this.numero = numero;
    }

    public int getAgencia(){
        return this.agencia;
    }

    public void setAgencia(int agencia){
       if(agencia <= 0) {
           System.out.println("Nao pode valor menor igual a 0");
           return;
       }
       this.agencia = agencia;
    }

    public void setTitular(Cliente titular){
        this.titular = titular;
    }

    public Cliente getTitular(){
        return this.titular;
    }

    public static int getTotal(){
        return Conta.total;
    }
    
    //Comparar se a
    @Override
    public boolean equals(Object ref) { //O método equals obriga a implementar a classe Object para fazer a sobrescrita
    	
    	Conta outra = (Conta) ref; //Necessita de Cast
    	if(this.agencia != outra.agencia)
    		return false;
    	if(this.numero != outra.numero)
    		return false;
    	return true;
    }
    
    /**
     * Método sobrescrito da classe Comparable define ordem de comparação natural ou específica
     **/
    @Override
	public int compareTo(Conta outra) {
		return Double.compare(this.saldo, outra.saldo); //Comparando o saldo dessa conta com outra conta que veio através do parametro
	}
    
    @Override
    public String toString() {
    	return "Numero: " + this.numero + ", Agencia: " + this.agencia + ", Saldo: " + this.saldo;    
    }
}
