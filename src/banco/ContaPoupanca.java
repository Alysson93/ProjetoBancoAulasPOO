package banco;

public class ContaPoupanca implements IConta {

	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	public ContaPoupanca(String numeroConta, String agencia, String dataAbertura) {
		this.numeroConta = numeroConta;
		this.agencia = agencia;
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
		if (valor+valor*CUSTO_SACAR_CONTA_POUPANCA <= this.saldo && status) {
			this.saldo -= (valor+valor*CUSTO_SACAR_CONTA_POUPANCA);
		}
	}

	public void desativarConta() {
		if (this.status) {
			this.status = false;
		}
	}

	public void ativarConta() {
		if (!this.status) {
			this.status = true;
		}
	}
	
	public void transferir(IConta destino, float valor) {
		if (destino instanceof ContaCorrente || destino instanceof ContaInvestimento) {
			this.sacar(valor + valor*IConta.TAXA_ADMIN);
			destino.depositar(valor);
		} else {
			this.sacar(valor);
			destino.depositar(valor);
		}		
	}

	@Override
	public String toString() {
		return "ContaPoupanca [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo + ", status="
				+ status + ", dataAbertura=" + dataAbertura + "]";
	}
	
	
}
