package banco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ClienteJuridico implements ICliente, Serializable {

	private static final long serialVersionUID = 1L;

	String cnpj;
	String razaoSocial;
	String fantasia;
	String email;
	private List<IConta> contas = new ArrayList<>();
	private HashSet<String> telefones = new HashSet<>();

	public ClienteJuridico(String cnpj, String razaoSocial, String fantasia, String email) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.fantasia = fantasia;
		this.email = email;
	}

	public ClienteJuridico(String cnpj) {
		this.cnpj = cnpj;
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
		return "ClienteJuridico [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", fantasia=" + fantasia + ", email="
				+ email + ", contas=" + contas + ", telefones=" + telefones + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		ClienteJuridico other = (ClienteJuridico) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}

	@Override
	public List<IConta> getContas() {
		
		return null;
	}


	


	
}
