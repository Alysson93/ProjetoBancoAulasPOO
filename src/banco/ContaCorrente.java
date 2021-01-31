package banco;

import java.io.Serializable;

import excecoes.SaldoInsuficienteException;

public class ContaCorrente implements IConta, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroConta == null) ? 0 : numeroConta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaCorrente other = (ContaCorrente) obj;
		if (numeroConta == null) {
			if (other.numeroConta != null)
				return false;
		} else if (!numeroConta.equals(other.numeroConta))
			return false;
		return true;
	}

	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	public ContaCorrente(String numeroConta, String agencia, String dataAbertura) {		
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
		if (valor+ valor*CUSTO_SACAR_CONTA_CORRENTE <= this.saldo && status) {
			this.saldo -= (valor + valor*CUSTO_SACAR_CONTA_CORRENTE);
		} else {
			new SaldoInsuficienteException("Saldo insuficiente");
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
	
	public void transferir(IConta destino, float valor) throws SaldoInsuficienteException {
		if (destino instanceof ContaPoupanca || destino instanceof ContaInvestimento) {
			this.sacar(valor + valor*IConta.TAXA_ADMIN);
			destino.depositar(valor);
		} else {
			this.sacar(valor);
			destino.depositar(valor);
		}
	}

	@Override
	public String toString() {
		return "ContaCorrente [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo + ", status="
				+ status + ", dataAbertura=" + dataAbertura + "]";
	}
	
	
}
