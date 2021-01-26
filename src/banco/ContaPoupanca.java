package banco;

public class ContaPoupanca extends Conta {
	
	static final float RENDIMENTO = 0.03f;
	
	public ContaPoupanca(String numeroConta, String agencia, String nome, String cpf, String dataAbertura) {
		super(numeroConta,agencia,nome,cpf,dataAbertura);
	}
	
	public void transferir(Conta destino, float valor) {
		if (destino instanceof ContaCorrente || destino instanceof ContaInvestimento) {
			this.sacar(valor + valor*Conta.TAXA_ADMIN);
			destino.depositar(valor);
		} else {
			this.sacar(valor);
			destino.depositar(valor);
		}		
	}
}
