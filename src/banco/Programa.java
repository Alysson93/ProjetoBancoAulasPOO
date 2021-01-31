package banco;

import bancoPersistencia.IPersistenciaCliente;
import bancoPersistencia.PersistenciaEmArquivoCliente;
import excecoes.ClienteJaCadastradoException;
import excecoes.ClienteNaoEncontradoException;
import excecoes.SaldoInsuficienteException;

public class Programa {

	public static void main(String[] args) {
		
//		IConta cc = new ContaCorrente("123","1","26/01/2021");
//		IConta cp = new ContaPoupanca("234","2","26/01/2021");
//		
//		ICliente cliente1 = new ClienteFisico("103","Alysson","13/10/1993");
//		cliente1.adicionarConta(cc);
//		cliente1.adicionarTelefone("982858952");
//		
//		ICliente cliente2 = new ClienteFisico("858","Pereira","05/10/1998");
//		cliente2.adicionarConta(cp);
//		cliente2.adicionarTelefone("940028922");
		
//		ICliente clientej = new ClienteJuridico("CNPJ000");
//		IConta cc1 = new ContaCorrente("345","3","28/01/2021");
//		clientej.adicionarConta(cc1);
//		clientej.adicionarTelefone("911223344");
		
//		
//		System.out.println(cliente1);
//		System.out.println(cliente2);
		
		IPersistenciaCliente pac = new PersistenciaEmArquivoCliente();
//		pac.cadastrarCliente(cliente2);
//		pac.cadastrarCliente(clientej);
		
		ICliente obj;
		try {
			obj = pac.localizarClientePorCPF("103");
			System.out.println(obj);
		} catch (ClienteNaoEncontradoException e1) {
			e1.printStackTrace();
		}
		
		ICliente obj2;
		try {
			obj2 = pac.localizarClientePorCPF("858");
			System.out.println(obj2);
		} catch (ClienteNaoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ICliente obj3;
		try {
			obj3 = pac.localizarClientePorCNPJ("CNPJ000");
			System.out.println(obj3);
		} catch (ClienteNaoEncontradoException e1) {
			e1.printStackTrace();
		}
		
		ICliente cliente3 = new ClienteFisico("103");
		IConta conta3 = new ContaPoupanca("345","3","29/01/2021");
		cliente3.adicionarConta(conta3);
		cliente3.adicionarTelefone("99998888");
		
		
		try {
			pac.cadastrarCliente(cliente3);
		} catch (ClienteJaCadastradoException e) {
			System.out.println(e.getMessage());
		}
		
		cliente3.getContas();
		
		
	}

}
