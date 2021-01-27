package banco;

import bancoPersistencia.IPersistenciaCliente;
import bancoPersistencia.PersistenciaEmArquivoCliente;

public class Programa {

	public static void main(String[] args) {
		
//		IConta cc = new ContaCorrente("123","1","26/01/2021");
//		IConta cp = new ContaPoupanca("234","2","26/01/2021");
//		
//		ClienteFisico cliente1 = new ClienteFisico("103","Alysson","13/10/1993");
//		cliente1.adicionarConta(cc);
//		cliente1.adicionarTelefone("982858952");
//		
//		ClienteFisico cliente2 = new ClienteFisico("858","Pereira","05/10/1998");
//		cliente2.adicionarConta(cp);
//		cliente2.adicionarTelefone("940028922");
//		
//		System.out.println(cliente1);
//		System.out.println(cliente2);
		
		IPersistenciaCliente pac = new PersistenciaEmArquivoCliente();
//		pac.cadastrarCliente(cliente2);
		
		ICliente obj = pac.localizarClientePorCPF("103");
		
		System.out.println(obj);
		
		
		
	}

}
