package banco;

import java.io.Serializable;

public class ContaSalario implements IConta, Serializable {

	private static final long serialVersionUID = 1L;
	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	public ContaSalario(String numeroConta, String agencia, String dataAbertura) {		
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
		if (valor+ valor*CUSTO_SACAR_CONTA_SALARIO <= this.saldo && status) {
			this.saldo -= (valor + valor*CUSTO_SACAR_CONTA_SALARIO);
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
		System.out.println("Conta salário não faz transferência");
	}

	@Override
	public String toString() {
		return "ContaCorrente [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo + ", status="
				+ status + ", dataAbertura=" + dataAbertura + "]";
	}
	
}
