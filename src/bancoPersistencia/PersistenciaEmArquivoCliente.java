package bancoPersistencia;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import banco.ClienteFisico;
import banco.ClienteJuridico;
import banco.ICliente;
import excecoes.ClienteJaCadastradoException;
import excecoes.ClienteNaoEncontradoException;

public class PersistenciaEmArquivoCliente implements IPersistenciaCliente {

	private List<ICliente> clientesCadastrados = new ArrayList<>();
	
	public PersistenciaEmArquivoCliente() {
		lerArquivo();
	}
	
	public void cadastrarCliente(ICliente obj) throws ClienteJaCadastradoException {
		if (!clientesCadastrados.contains(obj)) {
			clientesCadastrados.add(obj);
			salvarEmArquivo();	
		} else {
			throw new ClienteJaCadastradoException("Cliente do tipo "+obj.getClass().getName()+" já cadastrado no banco!");
		}
	}

	@Override
	public ICliente localizarClientePorCPF(String cpf) throws ClienteNaoEncontradoException {
		ICliente cliente = new ClienteFisico(cpf);
		if (clientesCadastrados.contains(cliente)) {
			int index = clientesCadastrados.indexOf(cliente);
			cliente = clientesCadastrados.get(index);
		} else {
			new ClienteNaoEncontradoException("Cliente não encontrado!");
		}
		return cliente;
	}

	@Override
	public ICliente localizarClientePorCNPJ(String cnpj) throws ClienteNaoEncontradoException {
		ICliente cliente = new ClienteJuridico(cnpj);
		if (clientesCadastrados.contains(cliente)) {
			int index = clientesCadastrados.indexOf(cliente);
			cliente = clientesCadastrados.get(index);
		} else {
			new ClienteNaoEncontradoException("Cliente não encontrado!");
		}
		return cliente;
	}

	public void removerCliente(ICliente obj) {
		if (clientesCadastrados.contains(obj)) {
			clientesCadastrados.remove(obj);
			salvarEmArquivo();
		}
		
		
	}
	
	private void salvarEmArquivo() {
		try {
			FileOutputStream fos = new FileOutputStream("persistencia_cliente.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clientesCadastrados);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void lerArquivo() {
		try {
			FileInputStream fis = new FileInputStream("persistencia_cliente.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			clientesCadastrados = (ArrayList<ICliente>)obj;
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizarCliente(ICliente cliente) throws ClienteNaoEncontradoException {
		
	}
}
