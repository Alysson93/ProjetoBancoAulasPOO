package banco;

public class ContaCorrente extends Conta {
	
	static final float TAXA_MANUTENCAO = 0.01f;
	
	public ContaCorrente(String numeroConta, String agencia, String nome, String cpf, String dataAbertura) {
		super(numeroConta,agencia,nome,cpf,dataAbertura);
	}
	
	public void transferir(Conta destino, float valor) {
		if (destino instanceof ContaPoupanca || destino instanceof ContaInvestimento) {
			this.sacar(valor + valor*Conta.TAXA_ADMIN);
			destino.depositar(valor);
		} else {
			this.sacar(valor);
			destino.depositar(valor);
		}
	}
}
