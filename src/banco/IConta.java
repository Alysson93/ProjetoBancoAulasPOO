package banco;

import excecoes.SaldoInsuficienteException;

public interface IConta {

	public float TAXA_ADMIN = 0.02f;
	public float CUSTO_SACAR_CONTA_CORRENTE = 0.01f;
	public float CUSTO_SACAR_CONTA_INVESTIMENTO = 0.02f;
	public float CUSTO_SACAR_CONTA_POUPANCA = 0.03f;
	public float CUSTO_SACAR_CONTA_SALARIO = 0.04f;
	public float RENDIMENTO_POUPANCA = 0.03f;
	
	public float getSaldo();
	
	public void depositar(float valor);
	
	public void sacar(float valor) throws SaldoInsuficienteException;
	
	public void transferir(IConta destino, float valor) throws SaldoInsuficienteException;
	
	public void desativarConta();
	
	public void ativarConta();
	
}
