package banco;

import java.util.List;

public interface ICliente {
	
	public void adicionarConta(IConta c);
	
	public boolean contemConta(IConta c);
	
	public void removerConta(IConta c);
	
	public void adicionarTelefone(String telefone);
	
	public void removerTelefone(String telefone);
	
	public List<IConta> getContas();
	
}
