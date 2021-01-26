package banco;

public class ContaInvestimento extends Conta {
	
	public ContaInvestimento(String numeroConta, String agencia, String nome, String cpf, String dataAbertura) {
		super(numeroConta,agencia,nome,cpf,dataAbertura);
	}
	
	public void transferir(Conta destino, float valor) {
		if (destino instanceof ContaPoupanca || destino instanceof ContaCorrente) {
			this.sacar(valor + valor*Conta.TAXA_ADMIN);
			destino.depositar(valor);
		} else {
			this.sacar(valor);
			destino.depositar(valor);
		}		
	}
}

