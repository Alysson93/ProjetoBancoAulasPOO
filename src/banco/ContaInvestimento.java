package banco;

import java.io.Serializable;

import excecoes.SaldoInsuficienteException;

public class ContaInvestimento implements IConta, Serializable {

	private static final long serialVersionUID = 1L;
	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	public ContaInvestimento(String numeroConta, String agencia, String dataAbertura) {	
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.saldo = 0f;
		this.status = true;
		this.dataAbertura = dataAbertura;
	}
	
	public ContaInvestimento(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public float getSaldo() {
		return this.saldo;
	}
	
	public void depositar(float valor) {
		if (valor > 0 && status) {
			this.saldo += valor;
		}
	}
	
	public void sacar(float valor) throws SaldoInsuficienteException{
		if (valor+valor*CUSTO_SACAR_CONTA_INVESTIMENTO <= this.saldo && status) {
			this.saldo -= (valor+valor*CUSTO_SACAR_CONTA_INVESTIMENTO);
		} else {
			new SaldoInsuficienteException("Saldo indisponível");
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
		if (destino instanceof ContaPoupanca || destino instanceof ContaCorrente) {
			try {
				this.sacar(valor + valor*IConta.TAXA_ADMIN);
			} catch (SaldoInsuficienteException e) {
				e.printStackTrace();
			}
			destino.depositar(valor);
		} else {
			try {
				this.sacar(valor);
			} catch (SaldoInsuficienteException e) {
				e.printStackTrace();
			}
			destino.depositar(valor);
		}		
	}

	@Override
	public String toString() {
		return "ContaInvestimento [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo
				+ ", status=" + status + ", dataAbertura=" + dataAbertura + "]";
	}
	
	
}

