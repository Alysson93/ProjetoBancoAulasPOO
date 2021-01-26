package banco;

public class Conta {
	
	String numeroConta;
	String agencia;
	String nome;
	String cpf;
	char tipoConta;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	private static final float TAXA_ADMIN = 0.02f;
	
	public Conta(String numeroConta, String agencia, String nome, String cpf, char tipoConta, String dataAbertura) {
		
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.nome = nome;
		this.cpf = cpf;
		this.tipoConta = tipoConta;
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
	
	public void transferir(Conta destino, float valor) {
		if (this.tipoConta == destino.tipoConta) {
			sacar(valor);
			destino.depositar(valor);
		} else {
			sacar(valor + valor * TAXA_ADMIN);
			destino.depositar(valor);
		}
	}
	
	public void desativarConta() {
		if (this.status) {
			this.status = false;
		}
	}

	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", agencia=" + agencia + ", nome=" + nome + ", cpf=" + cpf
				+ ", tipoConta=" + tipoConta + ", saldo=" + saldo + ", status=" + status + ", dataAbertura="
				+ dataAbertura + "]";
	}
	
	
	
}
