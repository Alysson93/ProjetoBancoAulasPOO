package bancoPersistencia;

import banco.ICliente;
import excecoes.ClienteJaCadastradoException;
import excecoes.ClienteNaoEncontradoException;

public interface IPersistenciaCliente {

	public void cadastrarCliente(ICliente obj) throws ClienteJaCadastradoException;
	
	public ICliente localizarClientePorCPF(String cpf) throws ClienteNaoEncontradoException;
	
	public ICliente localizarClientePorCNPJ(String cnpj) throws ClienteNaoEncontradoException;
	
	public void removerCliente(ICliente obj);
	
	public void atualizarCliente(ICliente cliente) throws ClienteNaoEncontradoException;
	
}
