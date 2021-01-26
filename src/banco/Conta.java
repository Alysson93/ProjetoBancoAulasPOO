package banco;

public abstract class Conta {
	
	String numeroConta;
	String agencia;
	String nome;
	String cpf;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	protected static final float TAXA_ADMIN = 0.02f;
	
	public Conta(String numeroConta, String agencia, String nome, String cpf, String dataAbertura) {
		
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.nome = nome;
		this.cpf = cpf;
		this.saldo = 0f;
		this.status = true;
		this.dataAbertura = dataAbertura;
	
	}
	
	public float getSaldo() {
		return this.saldo;
	}
	
	public void depositar(float valor) {
		if (valor > 0 && status) {
			this.saldo += valor;
		}
	}
	
	public void sacar(float valor) {
		if (valor <= this.saldo && status) {
			this.saldo -= valor;
		}
	}
	
	public abstract void transferir(Conta destino, float valor);
	
	public void desativarConta() {
		if (this.status) {
			this.status = false;
		}
	}

	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", agencia=" + agencia + ", nome=" + nome + ", cpf=" + cpf
				+", saldo=" + saldo + ", status=" + status + ", dataAbertura="
				+ dataAbertura + "]";
	}
	
	
	
}
