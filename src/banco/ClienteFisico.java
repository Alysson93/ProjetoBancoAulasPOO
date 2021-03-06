package banco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ClienteFisico implements ICliente, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String cpf;
	String nome;
	String dataNascimento;
	private List<IConta> contas = new ArrayList<>();
	private HashSet<String> telefones = new HashSet<>();
	
	public ClienteFisico(String cpf,String nome, String dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	public ClienteFisico(String cpf) {
		this.cpf = cpf;
	}
	
	public void adicionarConta(IConta c) {
		if (contas.contains(c)) {
			System.out.println("Esta conta já está registrada ou é inexistente");
		} else {
			contas.add(c);
		}
	}
	
	public boolean contemConta(IConta c) {
		return this.contas.contains(c);
	}
	
	public void removerConta(IConta c) {
		if (contas.contains(c)) {
			contas.remove(c);
		} else {
			System.out.println("Esta conta não está registrada ou é inexistente");
		}
	}
	
	public void adicionarTelefone(String telefone) {
		this.telefones.add(telefone);
	}
	
	public void removerTelefone(String telefone) {
		if (telefones.contains(telefone)) {
			telefones.remove(telefone);
		} else {
			System.out.println("Cliente não tem o referido telefone");
		}
	}
	

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", contas=" + contas + 
				", telefones=" + telefones
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		ClienteFisico other = (ClienteFisico) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public List<IConta> getContas() {
		
		return null;
	}
	
	public IConta buscarContaInvestimento(String numeroConta) {
		IConta conta = new ContaInvestimento(numeroConta);
		if (contas.contains(conta)) {
			int index = contas.indexOf(conta);
			conta = contas.get(index);
		}
		return conta;
	}

}
